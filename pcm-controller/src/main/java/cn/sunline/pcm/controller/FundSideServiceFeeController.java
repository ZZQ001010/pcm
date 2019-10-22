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
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.common.Fee;
import cn.sunline.pcm.controller.common.constent.ParameterFlags;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.Dedit;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.FundSideServiceFee;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.CapitalMoneyBasics;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.definition.enums.FrequencyOfCharge;
import cn.sunline.pcm.definition.enums.Settlement;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 资金方技术服务费 Controller 层
 * </p>
 * @version 1.0 2019-07-30 修改内容:初版
 */ 
@Controller
@RequestMapping("fundSideServiceFee")
public class FundSideServiceFeeController extends Fee {

	Logger logger = LoggerFactory.getLogger(this.getClass());

 

	/** 
	 * <p>
	 * 资金方技术服务费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideServiceFeeQueryPage.in")
	public ModelAndView fundSideServiceFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideServiceFee/fundSideServiceFeeQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(DeditMethodOfFeeCollection.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(CapitalMoneyBasics.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(FrequencyOfCharge.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgJson",new JSONObject(orgMap));
			//资金方
			List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
			Map<String,String> fundSideInfoMap = new HashMap<String,String>();
			//资金方平台服务方
			Map<String,String> fundSidePaltformMap = new HashMap<String,String>();
			for (FundSideInfo fundSideInfo : fundSideInfoList) {
				fundSideInfoMap.put(fundSideInfo.getFundSideCode(), fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				fundSidePaltformMap.put(fundSideInfo.getFundSideCode(), fundSideInfo.getFundSeverSide());
			}
			view.addObject("fundSideInfoJson",new JSONObject(fundSideInfoMap));
			view.addObject("fundSeverSideJson",new JSONObject(fundSidePaltformMap));
			view.addObject("fundSideServiceFee", new FundSideServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideServiceFee.fundSideServiceFeeQueryPageFail","加载资金方技术服务费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资金方技术服务费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryFundSideServiceFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryFundSideServiceFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, FundSideServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideServiceFee.queryFundSideServiceFeeListFail","查询资金方技术服务费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资金方技术服务费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideServiceFeeAddPage.in")
	public ModelAndView fundSideServiceFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideServiceFee/fundSideServiceFeeAdd");
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			//view.addObject("settlement", KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(CapitalMoneyBasics.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			//所属机构
			List<PcmOrgParameter> list = parameterSurface.getParameterObject(PcmOrgParameter.class);
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			List<FundSideInfo> fundSideInfoList = parameterSurface.getParameterObject( FundSideInfo.class);
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
			view.addObject("fundSideServiceFee", new FundSideServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideServiceFee.fundSideServiceFeeAddPageFail","加载新增资金方技术服务费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资金方技术服务费
	 * </p>
	 * @param fundSideServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addFundSideServiceFee.in", method = { RequestMethod.POST })
	public void addFundSideServiceFee(FundSideServiceFee fundSideServiceFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(fundSideServiceFee.getSkillcode(), fundSideServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideServiceFee.addFundSideServiceFeeFail", "新增资金方技术服务费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资金方技术服务费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideServiceFeeEditPage.in")
	public ModelAndView fundSideServiceFeeEditPage(String skillcode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideServiceFee/fundSideServiceFeeEdit");
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			//view.addObject("settlement", KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));	
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(CapitalMoneyBasics.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			//所属机构
			Map<String,String> orgMap = parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream() .collect(Collectors.toMap(PcmOrgParameter::getOrgCode, v->v.getOrgCode()+ParameterFlags.SHORT_CROSS+v.getOrgName()));
			view.addObject("orgMap",orgMap);
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
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
			FundSideServiceFee fundSideServiceFee = parameterSurface.getParameterObject(skillcode, FundSideServiceFee.class);
			view.addObject("fundSideServiceFee", fundSideServiceFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideServiceFee.fundSideServiceFeeEditPageFail","加载修改资金方技术服务费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资金方技术服务费
	 * </p>
	 * @param fundSideServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updFundSideServiceFee.in", method = { RequestMethod.POST })
	public void updFundSideServiceFee(FundSideServiceFee fundSideServiceFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(fundSideServiceFee.getSkillcode(), fundSideServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideServiceFee.getSkillcode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideServiceFee.updFundSideServiceFeeFail", "修改资金方技术服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资金方技术服务费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delFundSideServiceFee.in", method = { RequestMethod.POST })
	public void delFundSideServiceFees(@RequestBody List<String> skillcodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(skillcodes, FundSideServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideServiceFee.delFundSideServiceFeeFail", "删除资金方技术服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资金方技术服务费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideServiceFeeDetailPage.in")
	public ModelAndView fundSideServiceFeeDetailPage(String skillcode,String code) throws FlatException {
		try {
			
			ModelAndView view = KW.mvc.forwardView("fundSideServiceFee/fundSideServiceFeeDetail");
			view.addObject("factory",skillcode==null);
			FundSideServiceFee fundSideServiceFee = parameterSurface
					.getParameterObject(skillcode==null?code:skillcode,FundSideServiceFee.class);
			fundSideServiceFee.setTransferAccount(getPcmSettleAccMan(fundSideServiceFee.getTransferAccount()));
			fundSideServiceFee.setTransferToAccount(getPcmSettleAccMan(fundSideServiceFee.getTransferToAccount()));
			view.addObject("banceDate", KC.Enum.getI18nLabel(fundSideServiceFee.getBanceDate()));
			//view.addObject("settlement", KC.Enum.getI18nLabel(fundSideServiceFee.getSettlement()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(fundSideServiceFee.getPartnerType()));
			view.addObject("fundSideServiceFee", fundSideServiceFee);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(fundSideServiceFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(fundSideServiceFee.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(fundSideServiceFee.getFrequencyOfCharge()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(fundSideServiceFee.getBillingCycle()));
			
			view.addObject("partnerType",KC.Enum.getI18nLabel(fundSideServiceFee.getPartnerType()));
			
			
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(fundSideServiceFee.getOrganization(),PcmOrgParameter.class);
			view.addObject("organization",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = fundSideServiceFee.getPartnerType();
            if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(fundSideServiceFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(fundSideServiceFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(fundSideServiceFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(fundSideServiceFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideServiceFee.fundSideServiceFeeDetailPageFail", "加载资金方技术服务费详情页面失败");
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
                    parameterSurface.getParameterObject(FundSideServiceFee.class).forEach(
                                    item->resMap.put(item.getSkillcode(),item.getSkillDesc()));
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
	   FundSideServiceFee fundSideRoutRule = parameterSurface.getParameterObject(code,FundSideServiceFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(fundSideRoutRule.getSkillcode());
                   list.add(fundSideRoutRule.getSkillDesc());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(fundSideRoutRule.getOrganization());
                   return list;
   }
	
	
	
	
	
}