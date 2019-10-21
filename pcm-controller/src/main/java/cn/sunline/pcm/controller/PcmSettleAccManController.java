package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import cn.sunline.web.service.CodeService;
import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PcmSettleAccMan;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.AccountOwner;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.OrganizationAccountType;

/** 
 * <p>
 * 结算账号管理 Controller 层
 * </p>
 * @version 1.0 2019-07-10 修改内容:初版
 */ 
@Controller
@RequestMapping("pcmSettleAccMan")
public class PcmSettleAccManController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	
	@Autowired
	private AddressHelperFacility addressHelperFacility;

    @Autowired
    private CodeService codeService;
	/** 
	 * <p>
	 * 结算账号管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmSettleAccManQueryPage.in")
	public ModelAndView pcmSettleAccManQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("pcmSettleAccMan/pcmSettleAccManQuery");
			view.addObject("accountOwnerJson", KC.Enum.getI18nLabelMapJson(AccountOwner.class));
			view.addObject("accountOwner", KC.Enum.getI18nLabelMap(AccountOwner.class));				
			view.addObject("pcmSettleAccMan", new PcmSettleAccMan());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmSettleAccMan.pcmSettleAccManQueryPageFail","加载结算账号管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询结算账号管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPcmSettleAccManList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPcmSettleAccManList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PcmSettleAccMan.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmSettleAccMan.queryPcmSettleAccManListFail","查询结算账号管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增结算账号管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmSettleAccManAddPage.in")
	public ModelAndView pcmSettleAccManAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmSettleAccMan/pcmSettleAccManAdd");
			TreeMap<String, String> map = addressHelperFacility.loadProvince();
			view.addObject("accountOwner", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AccountOwner.class));
			view.addObject("openBankProv", map);
			view.addObject("openBankCity", new LinkedHashMap<String, String>());
//			view.addObject("acctType", codeService.getCodeMapByCodeType("acctType"));
//			view.addObject("orgType", codeService.getCodeMapByCodeType("orgType"));
//            view.addObject("bankCode", codeService.getCodeMapByCodeType("bankName"));
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
			// 自有
			List<PcmOrgParameter> pcmOrgParameterList = parameterSurface.getFetchResponse(null, PcmOrgParameter.class).getRows();
			Map<String,String> pcmOrgParameterMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : pcmOrgParameterList) {
				pcmOrgParameterMap.put(pcmOrgParameter.getOrgCode(), 
						pcmOrgParameter.getOrgCode()+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("pcmOrgParameterMap",new JSONObject(pcmOrgParameterMap));
			view.addObject("organizationAccountType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.OrganizationAccountType.class));
			view.addObject("settlementAccountType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SettlementAccountType.class));
			//view.addObject("assetSideInfoMap",assetSideInfoMap);
			view.addObject("pcmSettleAccMan", new PcmSettleAccMan());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmSettleAccMan.pcmSettleAccManAddPageFail","加载新增结算账号管理页面异常");
		}
	}
	

	/** 
	 * <p>
	 * 新增结算账号管理
	 * </p>
	 * @param pcmSettleAccMan
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPcmSettleAccMan.in", method = { RequestMethod.POST })
	public void addPcmSettleAccMan(PcmSettleAccMan pcmSettleAccMan) throws FlatException {
		try {
			parameterSurface.addNewParameter(pcmSettleAccMan.getSettleAccCode(), pcmSettleAccMan);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmSettleAccMan.addPcmSettleAccManFail", "新增结算账号管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改结算账号管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmSettleAccManEditPage.in")
	public ModelAndView pcmSettleAccManEditPage(String settleAccCode, HttpServletRequest request) throws FlatException {
		try {
			
			ModelAndView view = KW.mvc.forwardView("pcmSettleAccMan/pcmSettleAccManEdit");
			view.addObject("accountOwner", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AccountOwner.class));
			PcmSettleAccMan pcmSettleAccMan = parameterSurface.getParameterObject(settleAccCode, PcmSettleAccMan.class);
			view.addObject("province", addressHelperFacility.loadProvince());
			view.addObject("city",addressHelperFacility.loadCity(pcmSettleAccMan.getOpenBankProv()));
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
			view.addObject("organizationAccountType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.OrganizationAccountType.class));
			view.addObject("settlementAccountType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SettlementAccountType.class));
			if (KC.string.isNotBlank(pcmSettleAccMan.getOpenBankProv())) {
				view.addObject("openBankPriv", addressHelperFacility.loadCity(pcmSettleAccMan.getOpenBankProv()));
			}
			view.addObject("pcmSettleAccMan", pcmSettleAccMan);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmSettleAccMan.pcmSettleAccManEditPageFail","加载修改结算账号管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改结算账号管理
	 * </p>
	 * @param pcmSettleAccMan
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPcmSettleAccMan.in", method = { RequestMethod.POST })
	public void updPcmSettleAccMan(PcmSettleAccMan pcmSettleAccMan) throws FlatException {
		try {
			parameterSurface.updateParameterObject(pcmSettleAccMan.getSettleAccCode(), pcmSettleAccMan);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), pcmSettleAccMan.getSettleAccCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmSettleAccMan.updPcmSettleAccManFail", "修改结算账号管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除结算账号管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPcmSettleAccMan.in", method = { RequestMethod.POST })
	public void delPcmSettleAccMans(@RequestBody List<String> settleAccCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(settleAccCodes, PcmSettleAccMan.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmSettleAccMan.delPcmSettleAccManFail", "删除结算账号管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载结算账号管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmSettleAccManDetailPage.in")
	public ModelAndView pcmSettleAccManDetailPage(String settleAccCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("pcmSettleAccMan/pcmSettleAccManDetail");
			
			view.addObject("factory",code == null);
			PcmSettleAccMan pcmSettleAccMan = parameterSurface.getParameterObject(
					code==null? settleAccCode:code, PcmSettleAccMan.class);
			Map<String, String> map = addressHelperFacility.loadChineseAddress();
			pcmSettleAccMan.setOpenBankProv(pcmSettleAccMan.getOpenBankProv() == null ? "" : map.get(pcmSettleAccMan.getOpenBankProv()));
			pcmSettleAccMan.setOpenBankCity(pcmSettleAccMan.getOpenBankCity() == null ? "": map.get(pcmSettleAccMan.getOpenBankCity()));
			view.addObject("pcmSettleAccMan", pcmSettleAccMan);
			view.addObject("org",KC.Enum.getI18nLabel(pcmSettleAccMan.getOrganizationAccountType()));
			//资产方
			view.addObject("accountOwner", KC.Enum.getI18nLabel(pcmSettleAccMan.getAccountOwner()));
			
//			AccountOwner accountOwner = pcmSettleAccMan.accountOwner;
//			if(accountOwner!=null){
//				System.err.println(accountOwner);
//				//资产方
//				if(accountOwner.equals(AccountOwner.A)){
//					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(pcmSettleAccMan.getOrgCode(),AssetSideInfo.class);
//					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
//				}
//				//资金方
//				if(accountOwner.equals(AccountOwner.F)){
//					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(pcmSettleAccMan.getOrgCode(),FundSideInfo.class);
//					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
//				}
//				//服务方
//				if(accountOwner.equals(AccountOwner.Z)){
//					ServerInfo serverInfo = parameterSurface.getParameterObject(pcmSettleAccMan.getOrgCode(),ServerInfo.class);
//					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
//				}
//				//渠道方 
//				if(accountOwner.equals(AccountOwner.Q)){
//					ChannelInfo channelInfo = parameterSurface.getParameterObject(pcmSettleAccMan.getOrgCode(),ChannelInfo.class);
//					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
//				}
//			}
			
			
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmSettleAccMan.pcmSettleAccManDetailPageFail", "加载结算账号管理详情页面失败");
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
                    parameterSurface.getParameterObject(PcmSettleAccMan.class).forEach(
                                    item->resMap.put(item.getSettleAccCode(),item.getSettleAccDes()));
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
	   PcmSettleAccMan parameterObject = parameterSurface.getParameterObject(code,PcmSettleAccMan.class);
                   List<String> list = new ArrayList<>();
//                   list.add(parameterObject.getAccNoteName());
                   list.add(parameterObject.getSettleAccDes());
                   list.add(parameterObject.getOpenBankBranch());
                   return list;
   }
}