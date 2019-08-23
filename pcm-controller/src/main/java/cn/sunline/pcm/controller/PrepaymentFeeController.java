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
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PrepaymentFee;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.PrepaymentFeeMethod;
import cn.sunline.pcm.definition.enums.Settlement;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 提前还款手续费 Controller 层
 * </p>
 * @version 1.0 2019-08-13 修改内容:初版
 */ 
@Controller
@RequestMapping("prepaymentFee")
public class PrepaymentFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;

	/** 
	 * <p>
	 * 提前还款手续费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prepaymentFeeQueryPage.in")
	public ModelAndView prepaymentFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("prepaymentFee/prepaymentFeeQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(PrepaymentFeeMethod.class));
			view.addObject("loanDayFeeColMethodJson", KC.Enum.getI18nLabelMapJson(Settlement.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
			view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
			view.addObject("fundSideInfoJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
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
			view.addObject("prepaymentFee", new PrepaymentFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prepaymentFee.prepaymentFeeQueryPageFail","加载提前还款手续费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询提前还款手续费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPrepaymentFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPrepaymentFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PrepaymentFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prepaymentFee.queryPrepaymentFeeListFail","查询提前还款手续费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增提前还款手续费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prepaymentFeeAddPage.in")
	public ModelAndView prepaymentFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prepaymentFee/prepaymentFeeAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(PrepaymentFeeMethod.class));				
			view.addObject("loanDayFeeColMethod", KC.Enum.getI18nLabelMap(Settlement.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
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
			view.addObject("prepaymentFee", new PrepaymentFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prepaymentFee.prepaymentFeeAddPageFail","加载新增提前还款手续费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增提前还款手续费
	 * </p>
	 * @param prepaymentFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPrepaymentFee.in", method = { RequestMethod.POST })
	public void addPrepaymentFee(PrepaymentFee prepaymentFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(prepaymentFee.getPrepaymentFeeCode(), prepaymentFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prepaymentFee.addPrepaymentFeeFail", "新增提前还款手续费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改提前还款手续费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prepaymentFeeEditPage.in")
	public ModelAndView prepaymentFeeEditPage(String prepaymentFeeCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prepaymentFee/prepaymentFeeEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(PrepaymentFeeMethod.class));				
			view.addObject("loanDayFeeColMethod", KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			PrepaymentFee prepaymentFee = parameterSurface.getParameterObject(prepaymentFeeCode, PrepaymentFee.class);
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
				//key,防止key值相同
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
			view.addObject("prepaymentFee", prepaymentFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prepaymentFee.prepaymentFeeEditPageFail","加载修改提前还款手续费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改提前还款手续费
	 * </p>
	 * @param prepaymentFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPrepaymentFee.in", method = { RequestMethod.POST })
	public void updPrepaymentFee(PrepaymentFee prepaymentFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(prepaymentFee.getPrepaymentFeeCode(), prepaymentFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), prepaymentFee.getPrepaymentFeeCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prepaymentFee.updPrepaymentFeeFail", "修改提前还款手续费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除提前还款手续费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPrepaymentFee.in", method = { RequestMethod.POST })
	public void delPrepaymentFees(@RequestBody List<String> prepaymentFeeCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(prepaymentFeeCodes, PrepaymentFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prepaymentFee.delPrepaymentFeeFail", "删除提前还款手续费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载提前还款手续费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prepaymentFeeDetailPage.in")
	public ModelAndView prepaymentFeeDetailPage(String prepaymentFeeCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("prepaymentFee/prepaymentFeeDetail");
			view.addObject("factory",prepaymentFeeCode == null);
			PrepaymentFee prepaymentFee = parameterSurface.getParameterObject(prepaymentFeeCode==null?code:prepaymentFeeCode, PrepaymentFee.class);
			view.addObject("prepaymentFee", prepaymentFee);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(prepaymentFee.getFeeCollectionMethod()));
			view.addObject("loanDayFeeColMethod", KC.Enum.getI18nLabel(prepaymentFee.getLoanDayFeeColMethod()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(prepaymentFee.getBillingCycle()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(prepaymentFee.getPartnerType()));
			if(prepaymentFee.getBillingCycle().equals(BillingCycle.Z)){
				view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(prepaymentFee.balanceDate));
			}else{
				view.addObject("balanceDate", prepaymentFee.getBalanceDate() );
			}
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(prepaymentFee.getOrganization(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = prepaymentFee.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(prepaymentFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(prepaymentFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(prepaymentFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(prepaymentFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prepaymentFee.prepaymentFeeDetailPageFail", "加载提前还款手续费详情页面失败");
		}
	}
	
}