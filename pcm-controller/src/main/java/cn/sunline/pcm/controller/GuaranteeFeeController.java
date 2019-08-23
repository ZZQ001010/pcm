package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.GuaranteeFee;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.Settlement;

/** 
 * <p>
 * 担保费 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-15 修改内容:初版
 */ 
@Controller
@RequestMapping("guaranteeFee")
public class GuaranteeFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 担保费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("guaranteeFeeQueryPage.in")
	public ModelAndView guaranteeFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("guaranteeFee/guaranteeFeeQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeBasis.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("guaranteeFee", new GuaranteeFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"guaranteeFee.guaranteeFeeQueryPageFail","加载担保费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询担保费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryGuaranteeFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryGuaranteeFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, GuaranteeFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"guaranteeFee.queryGuaranteeFeeListFail","查询担保费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增担保费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("guaranteeFeeAddPage.in")
	public ModelAndView guaranteeFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("guaranteeFee/guaranteeFeeAdd");
			view.addObject("accumulated", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.Accumulated.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("settlement", KC.Enum.getI18nLabelMap(Settlement.class));
			
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));				
			view.addObject("guaranteeFee", new GuaranteeFee());
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
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"guaranteeFee.guaranteeFeeAddPageFail","加载新增担保费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增担保费
	 * </p>
	 * @param guaranteeFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addGuaranteeFee.in", method = { RequestMethod.POST })
	public void addGuaranteeFee(GuaranteeFee guaranteeFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(guaranteeFee.getGuaranteeFeeCode(), guaranteeFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "guaranteeFee.addGuaranteeFeeFail", "新增担保费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改担保费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("guaranteeFeeEditPage.in")
	public ModelAndView guaranteeFeeEditPage(String guaranteeFeeCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("guaranteeFee/guaranteeFeeEdit");
			view.addObject("accumulated", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.Accumulated.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("settlement", KC.Enum.getI18nLabelMap(Settlement.class));
			
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));				
			GuaranteeFee guaranteeFee = parameterSurface.getParameterObject(guaranteeFeeCode, GuaranteeFee.class);
			view.addObject("guaranteeFee", guaranteeFee);
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
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"guaranteeFee.guaranteeFeeEditPageFail","加载修改担保费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改担保费
	 * </p>
	 * @param guaranteeFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updGuaranteeFee.in", method = { RequestMethod.POST })
	public void updGuaranteeFee(GuaranteeFee guaranteeFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(guaranteeFee.getGuaranteeFeeCode(), guaranteeFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), guaranteeFee.getGuaranteeFeeCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "guaranteeFee.updGuaranteeFeeFail", "修改担保费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除担保费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delGuaranteeFee.in", method = { RequestMethod.POST })
	public void delGuaranteeFees(@RequestBody List<String> guaranteeFeeCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(guaranteeFeeCodes, GuaranteeFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "guaranteeFee.delGuaranteeFeeFail", "删除担保费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载担保费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("guaranteeFeeDetailPage.in")
	public ModelAndView guaranteeFeeDetailPage(String guaranteeFeeCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("guaranteeFee/guaranteeFeeDetail");
			 view.addObject("factroy",guaranteeFeeCode==null); 
			GuaranteeFee guaranteeFee = parameterSurface.getParameterObject(
						guaranteeFeeCode==null?code:guaranteeFeeCode, GuaranteeFee.class);
			view.addObject("guaranteeFee", guaranteeFee);
			
			view.addObject("partnerType", KC.Enum.getI18nLabel(guaranteeFee.getPartnerType()));
			view.addObject("accumulated", KC.Enum.getI18nLabel(guaranteeFee.getAccumulated()));
			view.addObject("banceDate", KC.Enum.getI18nLabel(guaranteeFee.getBanceDate()));
			view.addObject("settlement", KC.Enum.getI18nLabel(guaranteeFee.getSettlement()));
			
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(guaranteeFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(guaranteeFee.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(guaranteeFee.getFrequencyOfCharge()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(guaranteeFee.getBillingCycle()));
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(guaranteeFee.getOrgCode(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = guaranteeFee.getPartnerType();
            if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(guaranteeFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(guaranteeFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(guaranteeFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(guaranteeFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "guaranteeFee.guaranteeFeeDetailPageFail", "加载担保费详情页面失败");
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
                    parameterSurface.getParameterObject(GuaranteeFee.class).forEach(
                                    item->resMap.put(item.getGuaranteeFeeCode(),item.getGuaranteeFeeDesc()));
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
   GuaranteeFee parameterObject = parameterSurface.getParameterObject(code,GuaranteeFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getGuaranteeFeeCode());
                   list.add(parameterObject.getGuaranteeFeeDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeCollectionMethod()));
                   return list;
   }

	
	
	
	
	
	
	
}