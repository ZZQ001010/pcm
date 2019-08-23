package cn.sunline.pcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PaymentPremium;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.IsNotParticipate;
import cn.sunline.pcm.definition.enums.PaymentPremiumType;
import cn.sunline.pcm.definition.enums.PremiumAdvanceFlowServiceCharges;
import cn.sunline.pcm.definition.enums.PremiumAdvanceSafetyPadDividedLogo;
import cn.sunline.pcm.definition.enums.UnpaidRepaymentSafetyPad;
import cn.sunline.pcm.definition.enums.UnpaidRepaymentServiceFee;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 保费垫付 Controller 层
 * </p>
 * @version 1.0 2019-08-13 修改内容:初版
 */ 
@Controller
@RequestMapping("paymentPremium")
public class PaymentPremiumController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 保费垫付 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumQueryPage.in")
	public ModelAndView paymentPremiumQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremium/paymentPremiumQuery");
			view.addObject("paymentPremiumTypeJson", KC.Enum.getI18nLabelMapJson(PaymentPremiumType.class));
			view.addObject("isNotParticipateJson", KC.Enum.getI18nLabelMapJson(IsNotParticipate.class));
			view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgJson",new JSONObject(orgMap));
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
			Map<String,String> fundSideInfoMap = new HashMap<String,String>();
			for (FundSideInfo fundSideInfo : fundSideInfoList) {
				fundSideInfoMap.put(fundSideInfo.getFundSideCode(), 
						fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
			}
			view.addObject("fundSideInfoJson",new JSONObject(fundSideInfoMap));
			//资产方
			List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
						AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
			}
			view.addObject("assetSideInfoJson",new JSONObject(assetSideInfoMap));
			//渠道方  
			List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
			Map<String,String> channelInfoMap = new HashMap<String,String>();
			for (ChannelInfo channelInfo : channelInfoList) {
				channelInfoMap.put(channelInfo.getChannelCode(), 
						channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
			}
			view.addObject("channelInfoJson",new JSONObject(channelInfoMap));
			//服务方  
			List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
			Map<String,String> serverInfoMap = new HashMap<String,String>();
			for (ServerInfo serverInfo : serverInfoList) {
				serverInfoMap.put(serverInfo.getServerCode(), 
						serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
			}
			view.addObject("serverInfoJson",new JSONObject(serverInfoMap));
			view.addObject("paymentPremium", new PaymentPremium());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremium.paymentPremiumQueryPageFail","加载保费垫付列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询保费垫付列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPaymentPremiumList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPaymentPremiumList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PaymentPremium.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremium.queryPaymentPremiumListFail","查询保费垫付列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增保费垫付页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumAddPage.in")
	public ModelAndView paymentPremiumAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremium/paymentPremiumAdd");
			view.addObject("paymentPremiumType", KC.Enum.getI18nLabelMap(PaymentPremiumType.class));
			view.addObject("isNotParticipate", KC.Enum.getI18nLabelMap(IsNotParticipate.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("premiumAdvanceSafetyPadDividedLogo", KC.Enum.getI18nLabelMap(PremiumAdvanceSafetyPadDividedLogo.class));
			view.addObject("premiumAdvanceFlowServiceCharges", KC.Enum.getI18nLabelMap(PremiumAdvanceFlowServiceCharges.class));
			view.addObject("unpaidRepaymentSafetyPad", KC.Enum.getI18nLabelMap(UnpaidRepaymentSafetyPad.class));
			view.addObject("unpaidRepaymentServiceFee", KC.Enum.getI18nLabelMap(UnpaidRepaymentServiceFee.class));
			
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
			Map<String,String> fundSideInfoMap = new HashMap<String,String>();
			for (FundSideInfo fundSideInfo : fundSideInfoList) {
				fundSideInfoMap.put(fundSideInfo.getFundSideCode(), 
						fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
			}
			view.addObject("fundSideInfoMap",new JSONObject(fundSideInfoMap));
			//资产方
			List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
						AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
			}
			view.addObject("assetSideInfoMap",new JSONObject(assetSideInfoMap));
			//渠道方  
			List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
			Map<String,String> channelInfoMap = new HashMap<String,String>();
			for (ChannelInfo channelInfo : channelInfoList) {
				channelInfoMap.put(channelInfo.getChannelCode(), 
						channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
			}
			view.addObject("channelInfoMap",new JSONObject(channelInfoMap));
			//服务方  
			List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
			Map<String,String> serverInfoMap = new HashMap<String,String>();
			for (ServerInfo serverInfo : serverInfoList) {
				serverInfoMap.put(serverInfo.getServerCode(), 
						serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
			}
			view.addObject("serverInfoMap",new JSONObject(serverInfoMap));
			view.addObject("paymentPremium", new PaymentPremium());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremium.paymentPremiumAddPageFail","加载新增保费垫付页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增保费垫付
	 * </p>
	 * @param paymentPremium
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPaymentPremium.in", method = { RequestMethod.POST })
	public void addPaymentPremium(PaymentPremium paymentPremium) throws FlatException {
		try {
			parameterSurface.addNewParameter(paymentPremium.getPaymentPremiumCode(), paymentPremium);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremium.addPaymentPremiumFail", "新增保费垫付失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改保费垫付页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumEditPage.in")
	public ModelAndView paymentPremiumEditPage(String paymentPremiumCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremium/paymentPremiumEdit");
			view.addObject("paymentPremiumType", KC.Enum.getI18nLabelMap(PaymentPremiumType.class));
			view.addObject("isNotParticipate", KC.Enum.getI18nLabelMap(IsNotParticipate.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			
			view.addObject("premiumAdvanceSafetyPadDividedLogo", KC.Enum.getI18nLabelMap(PremiumAdvanceSafetyPadDividedLogo.class));
			view.addObject("premiumAdvanceFlowServiceCharges", KC.Enum.getI18nLabelMap(PremiumAdvanceFlowServiceCharges.class));
			view.addObject("unpaidRepaymentSafetyPad", KC.Enum.getI18nLabelMap(UnpaidRepaymentSafetyPad.class));
			view.addObject("unpaidRepaymentServiceFee", KC.Enum.getI18nLabelMap(UnpaidRepaymentServiceFee.class));
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
			Map<String,String> fundSideInfoMap = new HashMap<String,String>();
			for (FundSideInfo fundSideInfo : fundSideInfoList) {
				fundSideInfoMap.put(fundSideInfo.getFundSideCode(), 
						fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
			}
			view.addObject("fundSideInfoMap",new JSONObject(fundSideInfoMap));
			//资产方
			List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
						AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
			}
			view.addObject("assetSideInfoMap",new JSONObject(assetSideInfoMap));
			//渠道方  
			List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
			Map<String,String> channelInfoMap = new HashMap<String,String>();
			for (ChannelInfo channelInfo : channelInfoList) {
				channelInfoMap.put(channelInfo.getChannelCode(), 
						channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
			}
			view.addObject("channelInfoMap",new JSONObject(channelInfoMap));
			//服务方  
			List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
			Map<String,String> serverInfoMap = new HashMap<String,String>();
			for (ServerInfo serverInfo : serverInfoList) {
				serverInfoMap.put(serverInfo.getServerCode(), 
						serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
			}
			view.addObject("serverInfoMap",new JSONObject(serverInfoMap));
			PaymentPremium paymentPremium = parameterSurface.getParameterObject(paymentPremiumCode,PaymentPremium.class);
			ChannelPartnerType partnerType = paymentPremium.getPartnerType();
			if (partnerType.equals(ChannelPartnerType.FW)) {
				view.addObject("partnerCode", serverInfoMap);
			}else if (partnerType.equals(ChannelPartnerType.QD)) {
				view.addObject("partnerCode",channelInfoMap);
			}else if (partnerType.equals(ChannelPartnerType.ZC)) {
				view.addObject("partnerCode",assetSideInfoMap);
			}else if (partnerType.equals(ChannelPartnerType.ZJ)) {
				view.addObject("partnerCode",fundSideInfoMap);
			}
			view.addObject("paymentPremium", paymentPremium);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremium.paymentPremiumEditPageFail","加载修改保费垫付页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改保费垫付
	 * </p>
	 * @param paymentPremium
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPaymentPremium.in", method = { RequestMethod.POST })
	public void updPaymentPremium(PaymentPremium paymentPremium) throws FlatException {
		try {
			parameterSurface.updateParameterObject(paymentPremium.getPaymentPremiumCode(), paymentPremium);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), paymentPremium.getPaymentPremiumCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremium.updPaymentPremiumFail", "修改保费垫付失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除保费垫付
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPaymentPremium.in", method = { RequestMethod.POST })
	public void delPaymentPremiums(@RequestBody List<String> paymentPremiumCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(paymentPremiumCodes, PaymentPremium.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremium.delPaymentPremiumFail", "删除保费垫付失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载保费垫付明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumDetailPage.in")
	public ModelAndView paymentPremiumDetailPage(String paymentPremiumCode) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremium/paymentPremiumDetail");
			PaymentPremium paymentPremium = parameterSurface.getParameterObject(paymentPremiumCode, PaymentPremium.class);
			view.addObject("paymentPremiumType", KC.Enum.getI18nLabel(paymentPremium.getPaymentPremiumType()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(paymentPremium.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(paymentPremium.getBillingCycle()));
			view.addObject("paymentPremium", paymentPremium);
			if(paymentPremium.getBillingCycle().equals(BillingCycle.Z)){
				view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(paymentPremium.balanceDate));
			}else{
				view.addObject("balanceDate", paymentPremium.getBalanceDate() );
			}
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(paymentPremium.getOrganization(),PcmOrgParameter.class);
			if(null != pcmOrgParameter){
				view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			ChannelPartnerType type = paymentPremium.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(paymentPremium.getPartnerCode(),AssetSideInfo.class);
					if(null != assetSideInfo){
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
					}
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(paymentPremium.getPartnerCode(),FundSideInfo.class);
					if(null != fundSideInfo){
						view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
					}
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(paymentPremium.getPartnerCode(),ServerInfo.class);
					if(null != serverInfo){
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
					}
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(paymentPremium.getPartnerCode(),ChannelInfo.class);
					if(null != channelInfo){
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
					}
				}
			}
			
			
			view.addObject("premiumAdvanceSafetyPadDividedLogo", KC.Enum.getI18nLabel(paymentPremium.getPremiumAdvanceSafetyPadDividedLogo()));
			view.addObject("premiumAdvanceFlowServiceCharges", KC.Enum.getI18nLabel(paymentPremium.getPremiumAdvanceFlowServiceCharges() ));
			view.addObject("unpaidRepaymentSafetyPad", KC.Enum.getI18nLabel(paymentPremium.getUnpaidRepaymentSafetyPad()));
			view.addObject("unpaidRepaymentServiceFee", KC.Enum.getI18nLabel(paymentPremium.getUnpaidRepaymentServiceFee()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremium.paymentPremiumDetailPageFail", "加载保费垫付详情页面失败");
		}
	}
	
}