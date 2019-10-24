package cn.sunline.pcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import cn.sunline.pcm.controller.common.Fee;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.ChannelServiceFee;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PacificInsuranceAgencyDedit;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.DeditBasisOfFeeCollection;
import cn.sunline.pcm.definition.enums.DeditMethodOfFeeCollection;
import cn.sunline.pcm.definition.enums.SafeTymatFeeBasis;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 太保违约金收入 Controller 层
 * </p>
 * @version 1.0 2019-08-12 修改内容:初版
 */ 
@Controller
@RequestMapping("pacificInsuranceAgencyDedit")
public class PacificInsuranceAgencyDeditController  extends Fee{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 太保违约金收入 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pacificInsuranceAgencyDeditQueryPage.in")
	public ModelAndView pacificInsuranceAgencyDeditQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("pacificInsuranceAgencyDedit/pacificInsuranceAgencyDeditQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(DeditMethodOfFeeCollection.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(DeditBasisOfFeeCollection.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
			view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
			view.addObject("pacificInsuranceAgencyDedit", new PacificInsuranceAgencyDedit());
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
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pacificInsuranceAgencyDedit.pacificInsuranceAgencyDeditQueryPageFail","加载太保违约金收入列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询太保违约金收入列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPacificInsuranceAgencyDeditList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPacificInsuranceAgencyDeditList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PacificInsuranceAgencyDedit.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pacificInsuranceAgencyDedit.queryPacificInsuranceAgencyDeditListFail","查询太保违约金收入列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增太保违约金收入页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pacificInsuranceAgencyDeditAddPage.in")
	public ModelAndView pacificInsuranceAgencyDeditAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pacificInsuranceAgencyDedit/pacificInsuranceAgencyDeditAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(DeditBasisOfFeeCollection.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("pacificInsuranceAgencyDedit", new PacificInsuranceAgencyDedit());
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			//所属机构
			List<PcmOrgParameter> list  = parameterSurface.getParameterObject(PcmOrgParameter.class);
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
			throw new FlatException(e,"pacificInsuranceAgencyDedit.pacificInsuranceAgencyDeditAddPageFail","加载新增太保违约金收入页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增太保违约金收入
	 * </p>
	 * @param pacificInsuranceAgencyDedit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPacificInsuranceAgencyDedit.in", method = { RequestMethod.POST })
	public void addPacificInsuranceAgencyDedit(PacificInsuranceAgencyDedit pacificInsuranceAgencyDedit) throws FlatException {
		try {
			parameterSurface.addNewParameter(pacificInsuranceAgencyDedit.getDeditCode(), pacificInsuranceAgencyDedit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pacificInsuranceAgencyDedit.addPacificInsuranceAgencyDeditFail", "新增太保违约金收入失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改太保违约金收入页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pacificInsuranceAgencyDeditEditPage.in")
	public ModelAndView pacificInsuranceAgencyDeditEditPage(String deditCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pacificInsuranceAgencyDedit/pacificInsuranceAgencyDeditEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(DeditMethodOfFeeCollection.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(DeditBasisOfFeeCollection.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));	
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			PacificInsuranceAgencyDedit pacificInsuranceAgencyDedit = parameterSurface.getParameterObject(deditCode, PacificInsuranceAgencyDedit.class);
			view.addObject("pacificInsuranceAgencyDedit", pacificInsuranceAgencyDedit);
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
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pacificInsuranceAgencyDedit.pacificInsuranceAgencyDeditEditPageFail","加载修改太保违约金收入页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改太保违约金收入
	 * </p>
	 * @param pacificInsuranceAgencyDedit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPacificInsuranceAgencyDedit.in", method = { RequestMethod.POST })
	public void updPacificInsuranceAgencyDedit(PacificInsuranceAgencyDedit pacificInsuranceAgencyDedit) throws FlatException {
		try {
			parameterSurface.updateParameterObject(pacificInsuranceAgencyDedit.getDeditCode(), pacificInsuranceAgencyDedit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), pacificInsuranceAgencyDedit.getDeditCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pacificInsuranceAgencyDedit.updPacificInsuranceAgencyDeditFail", "修改太保违约金收入失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除太保违约金收入
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPacificInsuranceAgencyDedit.in", method = { RequestMethod.POST })
	public void delPacificInsuranceAgencyDedits(@RequestBody List<String> deditCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(deditCodes, PacificInsuranceAgencyDedit.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pacificInsuranceAgencyDedit.delPacificInsuranceAgencyDeditFail", "删除太保违约金收入失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载太保违约金收入明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pacificInsuranceAgencyDeditDetailPage.in")
	public ModelAndView pacificInsuranceAgencyDeditDetailPage(String deditCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("pacificInsuranceAgencyDedit/pacificInsuranceAgencyDeditDetail");
			view.addObject("factory",deditCode == null);
			PacificInsuranceAgencyDedit pacificInsuranceAgencyDedit = parameterSurface.getParameterObject(deditCode==null?code:deditCode, PacificInsuranceAgencyDedit.class) ;
			pacificInsuranceAgencyDedit.setTransferAccount(getPcmSettleAccMan(pacificInsuranceAgencyDedit.getTransferAccount()));
			pacificInsuranceAgencyDedit.setTransferToAccount(getPcmSettleAccMan(pacificInsuranceAgencyDedit.getTransferToAccount()));
			view.addObject("pacificInsuranceAgencyDedit", pacificInsuranceAgencyDedit);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(pacificInsuranceAgencyDedit.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(pacificInsuranceAgencyDedit.getFeeBasis()));
			view.addObject("partnerType", KC.Enum.getI18nLabel(pacificInsuranceAgencyDedit.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(pacificInsuranceAgencyDedit.getBillingCycle()));
			//所属机构
			if (StringUtils.isNotEmpty(pacificInsuranceAgencyDedit.getOrganization())) {
				PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(pacificInsuranceAgencyDedit.getOrganization(),PcmOrgParameter.class);
				view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			ChannelPartnerType type = pacificInsuranceAgencyDedit.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(pacificInsuranceAgencyDedit.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo == null?"":assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(pacificInsuranceAgencyDedit.getPartnerCode(),FundSideInfo.class);
					if (fundSideInfo!=null) {
						view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
					}else{
						view.addObject("partner", "");
					}
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(pacificInsuranceAgencyDedit.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo == null?"":serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(pacificInsuranceAgencyDedit.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo == null?"":channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pacificInsuranceAgencyDedit.pacificInsuranceAgencyDeditDetailPageFail", "加载太保违约金收入详情页面失败");
		}
	}
		
		
}