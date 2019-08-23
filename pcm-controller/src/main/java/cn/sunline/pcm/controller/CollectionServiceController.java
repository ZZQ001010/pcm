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
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.BasicNetPremium;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.CollectionService;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 催收服务费 Controller 层
 * </p>
 * @version 1.0 2019-07-31 修改内容:初版
 */ 
@Controller
@RequestMapping("collectionService")
public class CollectionServiceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 催收服务费 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("collectionServiceQueryPage.in")
	public ModelAndView collectionServiceQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("collectionService/collectionServiceQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.RmasFeeBasis.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.BillingCycle.class));
			
			view.addObject("collectionService", new CollectionService());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"collectionService.collectionServiceQueryPageFail","加载催收服务费列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询催收服务费列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryCollectionServiceList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryCollectionServiceList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, CollectionService.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"collectionService.queryCollectionServiceListFail","查询催收服务费列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增催收服务费页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("collectionServiceAddPage.in")
	public ModelAndView collectionServiceAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("collectionService/collectionServiceAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.RmasFeeBasis.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
	
            //所属机构
            HashMap<String, String> orgMap = new HashMap<>();
            parameterSurface.getParameterObject(PcmOrgParameter.class).forEach(
                    item->orgMap.put(item.getOrgCode(),item.getOrgName()));
            view.addObject("orgCode", orgMap);
            
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
			view.addObject("collectionService", new CollectionService());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"collectionService.collectionServiceAddPageFail","加载新增催收服务费页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增催收服务费
	 * </p>
	 * @param collectionService
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addCollectionService.in", method = { RequestMethod.POST })
	public void addCollectionService(CollectionService collectionService) throws FlatException {
		try {
			parameterSurface.addNewParameter(collectionService.getCode(),collectionService);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "collectionService.addCollectionServiceFail", "新增催收服务费失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改催收服务费页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("collectionServiceEditPage.in")
	public ModelAndView collectionServiceEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("collectionService/collectionServiceEdit");
			
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));				
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.RmasFeeBasis.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));

            //所属机构
            HashMap<String, String> orgMap = new HashMap<>();
            parameterSurface.getParameterObject(PcmOrgParameter.class).forEach(
                    item->orgMap.put(item.getOrgCode(),item.getOrgCode()+"-"+item.getOrgName()));
            view.addObject("orgCode", orgMap);
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
			CollectionService collectionService = parameterSurface.getParameterObject(code, CollectionService.class);
			view.addObject("collectionService", collectionService);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"collectionService.collectionServiceEditPageFail","加载修改催收服务费页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改催收服务费
	 * </p>
	 * @param collectionService
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updCollectionService.in", method = { RequestMethod.POST })
	public void updCollectionService(CollectionService collectionService) throws FlatException {
		try {
			parameterSurface.updateParameterObject(collectionService.getCode(), collectionService);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), collectionService.getCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "collectionService.updCollectionServiceFail", "修改催收服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除催收服务费
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delCollectionService.in", method = { RequestMethod.POST })
	public void delCollectionServices(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes, CollectionService.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "collectionService.delCollectionServiceFail", "删除催收服务费失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载催收服务费明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("collectionServiceDetailPage.in")
	public ModelAndView collectionServiceDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("collectionService/collectionServiceDetail");
			view.addObject("factory",dcode==null);
			CollectionService collectionService = parameterSurface.getParameterObject(dcode==null?code:dcode, CollectionService.class);
			
			view.addObject("partnerType", KC.Enum.getI18nLabel(collectionService.getPartnerType()));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(collectionService.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(collectionService.getFeeBasis()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(collectionService.getBillingCycle()));
			//资产方
            HashMap<String, String> assetMap = new HashMap<>();
            parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                            item->assetMap.put(item.getAssetSideCode(),item.getAssetSideDesc()));
            view.addObject("assetFundSideCode", assetMap);
            //所属机构
            HashMap<String, String> orgMap = new HashMap<>();
            parameterSurface.getParameterObject(PcmOrgParameter.class).forEach(
                    item->orgMap.put(item.getOrgCode(),item.getOrgName()));
            view.addObject("orgCode", orgMap);
            ChannelPartnerType type = collectionService.getPartnerType();
            if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(collectionService.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(collectionService.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(collectionService.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(collectionService.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			view.addObject("collectionService", collectionService);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "collectionService.collectionServiceDetailPageFail", "加载催收服务费详情页面失败");
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
                    parameterSurface.getParameterObject(CollectionService.class).forEach(
                                    item->resMap.put(item.getCode(),item.getDesc()));
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
	   CollectionService parameterObject = parameterSurface.getParameterObject(code,CollectionService.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCode());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeCollectionMethod()));
                   return list;
   }
	
}