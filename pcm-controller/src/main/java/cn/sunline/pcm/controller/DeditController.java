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
import cn.sunline.pcm.controller.common.Fee;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.Dedit;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.FundSideRoutRule;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditBasisOfFeeCollection;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 平台违约金 Controller 层
 * </p>
 * @version 1.0 2019-07-30 修改内容:初版
 */ 
@Controller
@RequestMapping("dedit")
public class DeditController extends Fee{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 平台违约金 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("deditQueryPage.in")
	public ModelAndView deditQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("dedit/deditQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(DeditMethodOfFeeCollection.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(DeditBasisOfFeeCollection.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.BillingCycle.class));
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgJson",new JSONObject(orgMap));
			//资产方
			List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
			}
			view.addObject("assetSideInfoJson",new JSONObject(assetSideInfoMap));
			view.addObject("dedit", new Dedit());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"dedit.deditQueryPageFail","加载平台违约金列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询平台违约金列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryDeditList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryDeditList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, Dedit.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"dedit.queryDeditListFail","查询平台违约金列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增平台违约金页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("deditAddPage.in")
	public ModelAndView deditAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("dedit/deditAdd");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(DeditBasisOfFeeCollection.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			//所属机构
			List<PcmOrgParameter> list  = parameterSurface.getParameterObject( PcmOrgParameter.class);
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			 /**
			  * 
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
			view.addObject("dedit", new Dedit());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"dedit.deditAddPageFail","加载新增平台违约金页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增平台违约金
	 * </p>
	 * @param dedit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addDedit.in", method = { RequestMethod.POST })
	public void addDedit(Dedit dedit) throws FlatException {
		try {
			parameterSurface.addNewParameter(dedit.getDeditCode(), dedit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "dedit.addDeditFail", "新增平台违约金失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改平台违约金页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("deditEditPage.in")
	public ModelAndView deditEditPage(String deditCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("dedit/deditEdit");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));	
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(DeditBasisOfFeeCollection.class));
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			Dedit dedit = parameterSurface.getParameterObject(deditCode, Dedit.class);
			//所属机构
			List<PcmOrgParameter> list= parameterSurface.getParameterObject( PcmOrgParameter.class);
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
			view.addObject("dedit", dedit);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"dedit.deditEditPageFail","加载修改平台违约金页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改平台违约金
	 * </p>
	 * @param dedit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updDedit.in", method = { RequestMethod.POST })
	public void updDedit(Dedit dedit) throws FlatException {
		try {
			parameterSurface.updateParameterObject(dedit.getDeditCode(), dedit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), dedit.getDeditCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "dedit.updDeditFail", "修改平台违约金失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除平台违约金
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delDedit.in", method = { RequestMethod.POST })
	public void delDedits(@RequestBody List<String> deditCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(deditCodes, Dedit.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "dedit.delDeditFail", "删除平台违约金失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载平台违约金明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("deditDetailPage.in")
	public ModelAndView deditDetailPage(String deditCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("dedit/deditDetail");
			view.addObject("factory",deditCode==null);
			Dedit dedit = parameterSurface.getParameterObject(deditCode==null?code:deditCode, Dedit.class);
			view.addObject("partnerType", KC.Enum.getI18nLabel(dedit.getPartnerType()));
			view.addObject("dedit", dedit);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(dedit.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(dedit.getFeeBasis()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(dedit.getBillingCycle()));
			
			dedit.setTransferAccount(getPcmSettleAccMan(dedit.getTransferAccount()));
			dedit.setTransferToAccount(getPcmSettleAccMan(dedit.getTransferToAccount()));
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(dedit.getOrganization(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			ChannelPartnerType type = dedit.getPartnerType();
            if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(dedit.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(dedit.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(dedit.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(dedit.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "dedit.deditDetailPageFail", "加载平台违约金详情页面失败");
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
                    parameterSurface.getParameterObject(Dedit.class).forEach(
                                    item->resMap.put(item.getDeditCode(),item.getDeditDesc()));
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
	   Dedit fundSideRoutRule = parameterSurface.getParameterObject(code,Dedit.class);
                   List<String> list = new ArrayList<>();
                   list.add(fundSideRoutRule.getDeditCode());
                   list.add(fundSideRoutRule.getDeditDesc());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(fundSideRoutRule.getTransferAccount());
                   return list;
   }
	
	
}