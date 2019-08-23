package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.KC.map;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.ChannelServiceFee;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.definition.SafetyMat;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelFeeCollectionMethod;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import scala.reflect.internal.Trees.New;

/** 
 * <p>
 * 渠道方服务费 Controller 层
 * </p>
 * @version 1.0 2019-07-31 修改内容:初版
 */ 
@Controller
@RequestMapping("channelServiceFee")
public class ChannelServiceFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 渠道方服务费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelServiceFeeQueryPage.in")
	public ModelAndView channelServiceFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("channelServiceFee/channelServiceFeeQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(ChannelFeeCollectionMethod.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(FeeBasis.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(FrequencyOfChannel.class));
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
			view.addObject("channelServiceFee", new ChannelServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelServiceFee.channelServiceFeeQueryPageFail","加载渠道方服务费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询渠道方服务费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryChannelServiceFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryChannelServiceFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, ChannelServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelServiceFee.queryChannelServiceFeeListFail","查询渠道方服务费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增渠道方服务费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelServiceFeeAddPage.in")
	public ModelAndView channelServiceFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("channelServiceFee/channelServiceFeeAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));				
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
			view.addObject("channelServiceFee", new ChannelServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelServiceFee.channelServiceFeeAddPageFail","加载新增渠道方服务费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增渠道方服务费
	 * </p>
	 * @param channelServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addChannelServiceFee.in", method = { RequestMethod.POST })
	public void addChannelServiceFee(ChannelServiceFee channelServiceFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(channelServiceFee.getChannelServiceCode(), channelServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelServiceFee.addChannelServiceFeeFail", "新增渠道方服务费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改渠道方服务费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelServiceFeeEditPage.in")
	public ModelAndView channelServiceFeeEditPage(String channelServiceCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("channelServiceFee/channelServiceFeeEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));				
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
			ChannelServiceFee channelServiceFee = parameterSurface.getParameterObject(channelServiceCode, ChannelServiceFee.class);
			view.addObject("channelServiceFee", channelServiceFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelServiceFee.channelServiceFeeEditPageFail","加载修改渠道方服务费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改渠道方服务费
	 * </p>
	 * @param channelServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updChannelServiceFee.in", method = { RequestMethod.POST })
	public void updChannelServiceFee(ChannelServiceFee channelServiceFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(channelServiceFee.getChannelServiceCode(), channelServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), channelServiceFee.getChannelServiceCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelServiceFee.updChannelServiceFeeFail", "修改渠道方服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除渠道方服务费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delChannelServiceFee.in", method = { RequestMethod.POST })
	public void delChannelServiceFees(@RequestBody List<String> channelServiceCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(channelServiceCodes, ChannelServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelServiceFee.delChannelServiceFeeFail", "删除渠道方服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载渠道方服务费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelServiceFeeDetailPage.in")
	public ModelAndView channelServiceFeeDetailPage(String channelServiceCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("channelServiceFee/channelServiceFeeDetail");
			view.addObject("factory", channelServiceCode == null);
			ChannelServiceFee channelServiceFee = parameterSurface.getParameterObject(channelServiceCode==null?code:channelServiceCode, ChannelServiceFee.class);
			if(channelServiceFee.getBillingCycle().equals(BillingCycle.Z)){
				view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(channelServiceFee.balanceDate));
			}else{
				view.addObject("balanceDate", channelServiceFee.getBalanceDate() );
			}
			view.addObject("channelServiceFee", channelServiceFee);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(channelServiceFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(channelServiceFee.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(channelServiceFee.getFrequencyOfCharge()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(channelServiceFee.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(channelServiceFee.getBillingCycle()));
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(channelServiceFee.getOrganization(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = channelServiceFee.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(channelServiceFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(channelServiceFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(channelServiceFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(channelServiceFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelServiceFee.channelServiceFeeDetailPageFail", "加载渠道方服务费详情页面失败");
		}
	}
	
	/**
    *
    * @Description:    TODO(所有组件的简略信息)
    * @param:  @return
    * @param:  @throws FlatException
    * @throws
    */
   @ResponseBody
   @PostMapping(value="/unitConfig.in",produces={"application/json"})
   public Map<String,String> unitConfig() throws FlatException{
           try{
                   HashMap<String, String> resMap = new HashMap<>();
                   parameterSurface.getParameterObject(ChannelServiceFee.class)
                   .stream().collect(Collectors.toMap(
                		   ChannelServiceFee::getChannelServiceCode, ChannelServiceFee::getChannelServiceDesc));
                   return resMap;
           } catch (ProcessException e) {
                   logger.error(e.getMessage(), e);
                   throw new FlatException(e.getErrorCode(), e.getMessage());
           } catch (Exception e) {
                   logger.error(e.getMessage(), e);
                   throw new FlatException(e, "branch.branchunitConfigFail", "加载数据失败！");
           }

   }
   
   @ResponseBody
   @PostMapping(value="/unitBase.in")
   public List<String> unitBase(@RequestParam("code") String code){
	   ChannelServiceFee parameterObject = parameterSurface.getParameterObject(code,ChannelServiceFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getChannelServiceCode());
                   list.add(parameterObject.getChannelServiceDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeCollectionMethod()));
                   return list;
   }
	
}