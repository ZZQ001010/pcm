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
import cn.sunline.common.address.AddressHelperFacility;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.SafetyMat;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.ServiceFee;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelFeeCollectionMethod;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;

/** 
 * <p>
 * 服务方服务费 Controller 层
 * </p>
 * @version 1.0 2019-08-13 修改内容:初版
 */ 
@Controller
@RequestMapping("serviceFee")
public class ServiceFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private AddressHelperFacility addressHelperFacility;
	
	/** 
	 * <p>
	 * 服务方服务费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serviceFeeQueryPage.in")
	public ModelAndView serviceFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("serviceFee/serviceFeeQuery");
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
			view.addObject("serviceFee", new ServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serviceFee.serviceFeeQueryPageFail","加载服务方服务费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询服务方服务费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryServiceFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryServiceFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, ServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serviceFee.queryServiceFeeListFail","查询服务方服务费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增服务方服务费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serviceFeeAddPage.in")
	public ModelAndView serviceFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("serviceFee/serviceFeeAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));				
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			
			
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
			view.addObject("serviceFee", new ServiceFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serviceFee.serviceFeeAddPageFail","加载新增服务方服务费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增服务方服务费
	 * </p>
	 * @param serviceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addServiceFee.in", method = { RequestMethod.POST })
	public void addServiceFee(ServiceFee serviceFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(serviceFee.getServiceFeeNo(), serviceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serviceFee.addServiceFeeFail", "新增服务方服务费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改服务方服务费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serviceFeeEditPage.in")
	public ModelAndView serviceFeeEditPage(String serviceFeeNo, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("serviceFee/serviceFeeEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));				
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省

			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			
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
			ServiceFee serviceFee = parameterSurface.getParameterObject(serviceFeeNo, ServiceFee.class);
			view.addObject("serviceFee", serviceFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serviceFee.serviceFeeEditPageFail","加载修改服务方服务费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改服务方服务费
	 * </p>
	 * @param serviceFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updServiceFee.in", method = { RequestMethod.POST })
	public void updServiceFee(ServiceFee serviceFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(serviceFee.getServiceFeeNo(), serviceFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), serviceFee.getServiceFeeNo());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serviceFee.updServiceFeeFail", "修改服务方服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除服务方服务费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delServiceFee.in", method = { RequestMethod.POST })
	public void delServiceFees(@RequestBody List<String> serviceFeeNos) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(serviceFeeNos, ServiceFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serviceFee.delServiceFeeFail", "删除服务方服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载服务方服务费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serviceFeeDetailPage.in")
	public ModelAndView serviceFeeDetailPage(String serviceFeeNo,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("serviceFee/serviceFeeDetail");
			view.addObject("factory",serviceFeeNo == null);
			ServiceFee serviceFee = parameterSurface.getParameterObject(serviceFeeNo==null?code:serviceFeeNo, ServiceFee.class);
			view.addObject("serviceFee",serviceFee);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(serviceFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(serviceFee.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(serviceFee.getFrequencyOfCharge()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(serviceFee.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(serviceFee.getBillingCycle()));
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(serviceFee.getOrganization(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = serviceFee.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(serviceFee.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(serviceFee.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(serviceFee.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(serviceFee.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serviceFee.serviceFeeDetailPageFail", "加载服务方服务费详情页面失败");
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
                    parameterSurface.getParameterObject(ServiceFee.class).forEach(
                                    item->resMap.put(item.getServiceFeeNo(),item.getServiceFeeDesc()));
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
	   ServiceFee parameterObject = parameterSurface.getParameterObject(code,ServiceFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getServiceFeeNo());
                   list.add(parameterObject.getServiceFeeDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeCollectionMethod()));
                   return list;
   }
	
}