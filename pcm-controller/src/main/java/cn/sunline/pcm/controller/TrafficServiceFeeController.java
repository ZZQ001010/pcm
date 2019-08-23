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
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.TrafficServiceFee;
import cn.sunline.pcm.definition.enums.AdvanceSettlement;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.Expenses;

/** 
 * <p>
 * 流量服务费 Controller 层
 * </p>
 * @version 1.0 2019-07-15 修改内容:初版
 * @author zzq
 */ 
@Controller
@RequestMapping("trafficServiceFee")
public class TrafficServiceFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 流量服务费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("trafficServiceFeeQueryPage.in")
	public ModelAndView trafficServiceFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("trafficServiceFee/trafficServiceFeeQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeBasis.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("trafficServiceFee", new TrafficServiceFee());
			view.addObject("expensesJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.Expenses.class));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"trafficServiceFee.trafficServiceFeeQueryPageFail","加载流量服务费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询流量服务费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryTrafficServiceFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryTrafficServiceFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, TrafficServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"trafficServiceFee.queryTrafficServiceFeeListFail","查询流量服务费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增流量服务费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("trafficServiceFeeAddPage.in")
	public ModelAndView trafficServiceFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("trafficServiceFee/trafficServiceFeeAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));	
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("expenses",KC.Enum.getI18nLabelMap(Expenses.class));
			view.addObject("advanceSettlement",KC.Enum.getI18nLabelMap(AdvanceSettlement.class));
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
			view.addObject("fundSideInfoMap",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-' +x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoMap",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方
			view.addObject("channelInfoMap",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoMap",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			//view.addObject("trafficServiceFee", new trafficServiceFee());
			view.addObject("trafficServiceFee", new TrafficServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"trafficServiceFee.trafficServiceFeeAddPageFail","加载新增流量服务费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增流量服务费
	 * </p>
	 * @param trafficServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addTrafficServiceFee.in", method = { RequestMethod.POST })
	public void addTrafficServiceFee(TrafficServiceFee trafficServiceFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(trafficServiceFee.getTrafficServiceFeeCode(), trafficServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "trafficServiceFee.addTrafficServiceFeeFail", "新增流量服务费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改流量服务费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("trafficServiceFeeEditPage.in")
	public ModelAndView trafficServiceFeeEditPage(String trafficServiceFeeCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("trafficServiceFee/trafficServiceFeeEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));				
			TrafficServiceFee trafficServiceFee = parameterSurface.getParameterObject(trafficServiceFeeCode, TrafficServiceFee.class);
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("expenses",KC.Enum.getI18nLabelMap(Expenses.class));
			view.addObject("advanceSettlement",KC.Enum.getI18nLabelMap(AdvanceSettlement.class));
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
			view.addObject("fundSideInfoMap",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-' +x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoMap",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方
			view.addObject("channelInfoMap",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoMap",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			view.addObject("trafficServiceFee", trafficServiceFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"trafficServiceFee.trafficServiceFeeEditPageFail","加载修改流量服务费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改流量服务费
	 * </p>
	 * @param trafficServiceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updTrafficServiceFee.in", method = { RequestMethod.POST })
	public void updTrafficServiceFee(TrafficServiceFee trafficServiceFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(trafficServiceFee.getTrafficServiceFeeCode(), trafficServiceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), trafficServiceFee.getTrafficServiceFeeCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "trafficServiceFee.updTrafficServiceFeeFail", "修改流量服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除流量服务费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delTrafficServiceFee.in", method = { RequestMethod.POST })
	public void delTrafficServiceFees(@RequestBody List<String> trafficServiceFeeCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(trafficServiceFeeCodes, TrafficServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "trafficServiceFee.delTrafficServiceFeeFail", "删除流量服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载流量服务费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("trafficServiceFeeDetailPage.in")
	public ModelAndView trafficServiceFeeDetailPage(String trafficServiceFeeCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("trafficServiceFee/trafficServiceFeeDetail");
			 view.addObject("factory",trafficServiceFeeCode==null);
			TrafficServiceFee trafficServiceFee = parameterSurface.getParameterObject(
					trafficServiceFeeCode==null?code:trafficServiceFeeCode, TrafficServiceFee.class);
			view.addObject("trafficServiceFee", trafficServiceFee);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(trafficServiceFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(trafficServiceFee.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(trafficServiceFee.getFrequencyOfCharge()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(trafficServiceFee.getBillingCycle()));
			view.addObject("expenses", KC.Enum.getI18nLabel(trafficServiceFee.getExpenses()));
			view.addObject("advanceSettlement", KC.Enum.getI18nLabel(trafficServiceFee.getAdvanceSettlement()));
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("org",orgMap.get(trafficServiceFee.getOrganization()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(trafficServiceFee.getPartnerType()));
			ChannelPartnerType type = trafficServiceFee.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(trafficServiceFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(trafficServiceFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(trafficServiceFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(trafficServiceFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			//view.addObject("assetSideInfo",assetSideInfoMap.get(trafficServiceFee.getAsset()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "trafficServiceFee.trafficServiceFeeDetailPageFail", "加载流量服务费详情页面失败");
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
                    parameterSurface.getParameterObject(TrafficServiceFee.class).forEach(
                                    item->resMap.put(item.getTrafficServiceFeeCode(),
                                    				item.getTrafficServiceFeeDesc()));
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
	   TrafficServiceFee parameterObject = parameterSurface.getParameterObject(code,TrafficServiceFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getTrafficServiceFeeCode());
                   list.add(parameterObject.getTrafficServiceFeeDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getBillingCycle()));
                   return list;
   }
}