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
import cn.sunline.pcm.definition.PaymentPremiumBack;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 保费垫付返还 Controller 层
 * </p>
 * @version 1.0 2019-08-13 修改内容:初版
 */ 
@Controller
@RequestMapping("paymentPremiumBack")
public class PaymentPremiumBackController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 保费垫付返还 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumBackQueryPage.in")
	public ModelAndView paymentPremiumBackQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremiumBack/paymentPremiumBackQuery");
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
			view.addObject("paymentPremiumBack", new PaymentPremiumBack());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremiumBack.paymentPremiumBackQueryPageFail","加载保费垫付返还列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询保费垫付返还列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPaymentPremiumBackList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPaymentPremiumBackList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PaymentPremiumBack.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremiumBack.queryPaymentPremiumBackListFail","查询保费垫付返还列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增保费垫付返还页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumBackAddPage.in")
	public ModelAndView paymentPremiumBackAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremiumBack/paymentPremiumBackAdd");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
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
			view.addObject("paymentPremiumBack", new PaymentPremiumBack());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremiumBack.paymentPremiumBackAddPageFail","加载新增保费垫付返还页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增保费垫付返还
	 * </p>
	 * @param paymentPremiumBack
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPaymentPremiumBack.in", method = { RequestMethod.POST })
	public void addPaymentPremiumBack(PaymentPremiumBack paymentPremiumBack) throws FlatException {
		try {
			parameterSurface.addNewParameter(paymentPremiumBack.getPaymentPremiumBackCode(), paymentPremiumBack);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremiumBack.addPaymentPremiumBackFail", "新增保费垫付返还失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改保费垫付返还页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumBackEditPage.in")
	public ModelAndView paymentPremiumBackEditPage(String paymentPremiumBackCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremiumBack/paymentPremiumBackEdit");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
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
			PaymentPremiumBack paymentPremiumBack = parameterSurface.getParameterObject(paymentPremiumBackCode, PaymentPremiumBack.class);
			view.addObject("paymentPremiumBack", paymentPremiumBack);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paymentPremiumBack.paymentPremiumBackEditPageFail","加载修改保费垫付返还页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改保费垫付返还
	 * </p>
	 * @param paymentPremiumBack
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPaymentPremiumBack.in", method = { RequestMethod.POST })
	public void updPaymentPremiumBack(PaymentPremiumBack paymentPremiumBack) throws FlatException {
		try {
			parameterSurface.updateParameterObject(paymentPremiumBack.getPaymentPremiumBackCode(), paymentPremiumBack);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), paymentPremiumBack.getPaymentPremiumBackCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremiumBack.updPaymentPremiumBackFail", "修改保费垫付返还失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除保费垫付返还
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPaymentPremiumBack.in", method = { RequestMethod.POST })
	public void delPaymentPremiumBacks(@RequestBody List<String> paymentPremiumBackCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(paymentPremiumBackCodes, PaymentPremiumBack.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremiumBack.delPaymentPremiumBackFail", "删除保费垫付返还失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载保费垫付返还明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("paymentPremiumBackDetailPage.in")
	public ModelAndView paymentPremiumBackDetailPage(String paymentPremiumBackCode) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("paymentPremiumBack/paymentPremiumBackDetail");
			PaymentPremiumBack paymentPremiumBack = parameterSurface.getParameterObject(paymentPremiumBackCode, PaymentPremiumBack.class);
			view.addObject("paymentPremiumBack", paymentPremiumBack);
			view.addObject("partnerType", KC.Enum.getI18nLabel(paymentPremiumBack.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(paymentPremiumBack.getBillingCycle()));
			if(paymentPremiumBack.getBillingCycle().equals(BillingCycle.Z)){
				view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(paymentPremiumBack.balanceDate));
			}else{
				view.addObject("balanceDate", paymentPremiumBack.getBalanceDate() );
			}
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(paymentPremiumBack.getOrganization(),PcmOrgParameter.class);
			if(null != pcmOrgParameter){
				view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			ChannelPartnerType type = paymentPremiumBack.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(paymentPremiumBack.getPartnerCode(),AssetSideInfo.class);
					if(null != assetSideInfo){
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
					}
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(paymentPremiumBack.getPartnerCode(),FundSideInfo.class);
					if(null != fundSideInfo){
						view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
					}
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(paymentPremiumBack.getPartnerCode(),ServerInfo.class);
					if(null != serverInfo){
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
					}
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(paymentPremiumBack.getPartnerCode(),ChannelInfo.class);
					if(null != channelInfo){
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
					}
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "paymentPremiumBack.paymentPremiumBackDetailPageFail", "加载保费垫付返还详情页面失败");
		}
	}
	
}