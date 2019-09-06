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
import scala.reflect.internal.Trees.New;
import cn.sunline.pcm.controller.common.Fee;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.SafetyMat;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.Expenses;
import cn.sunline.pcm.definition.enums.Settlement;

/** 
 * <p>
 * 安全垫 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-15 修改内容:初版
 */ 
@Controller
@RequestMapping("safetyMat")
public class SafetyMatController extends Fee {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	

	/** 
	 * <p>
	 * 安全垫 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("safetyMatQueryPage.in")
	public ModelAndView safetyMatQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("safetyMat/safetyMatQuery");
			view.addObject("expensesJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.Expenses.class));
			view.addObject("settlementJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.Settlement.class));
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.SafeTyFeeCollectionMethod.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.SafeTymatFeeBasis.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.BillingCycle.class));
			//view.addObject("participationStatusJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.Indicator.class));
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
			//安全垫下限控制方式
			view.addObject("controlModeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.SafetyPadLowerLimitControlMode.class));
			//技术服务费收取方式
			view.addObject("chargeWayJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionMethod.class));
			//技术服务费收取基础
			view.addObject("chargeBasicsJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionBasics.class));
			view.addObject("safetyMat", new SafetyMat());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"safetyMat.safetyMatQueryPageFail","加载安全垫列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询安全垫列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="querySafetyMatList.in", method = { RequestMethod.POST })
	public FetchResponse<?> querySafetyMatList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, SafetyMat.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"safetyMat.querySafetyMatListFail","查询安全垫列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增安全垫页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("safetyMatAddPage.in")
	public ModelAndView safetyMatAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("safetyMat/safetyMatAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafeTyFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafeTymatFeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));				
			//view.addObject("participationStatusMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.Indicator.class));
			view.addObject("safetyMat", new SafetyMat());
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("settlement",KC.Enum.getI18nLabelMap(Settlement.class));
			//view.addObject("backsettlement",KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("expenses",KC.Enum.getI18nLabelMap(Expenses.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			//资产方
			List<AssetSideInfo> AssetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : AssetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
			}
			view.addObject("assetSideInfoMap",assetSideInfoMap);
			//安全垫下限控制方式
			view.addObject("controlModeMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafetyPadLowerLimitControlMode.class));
			//技术服务费收取方式
			view.addObject("chargeWayMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionMethod.class));
			//技术服务费收取基础
			view.addObject("chargeBasicsMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionBasics.class));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"safetyMat.safetyMatAddPageFail","加载新增安全垫页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增安全垫
	 * </p>
	 * @param safetyMat
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addSafetyMat.in", method = { RequestMethod.POST })
	public void addSafetyMat(SafetyMat safetyMat) throws FlatException {
		try {
			parameterSurface.addNewParameter(safetyMat.getCode(), safetyMat);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "safetyMat.addSafetyMatFail", "新增安全垫失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改安全垫页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("safetyMatEditPage.in")
	public ModelAndView safetyMatEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("safetyMat/safetyMatEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafeTyFeeCollectionMethod.class));				
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafeTymatFeeBasis.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.BillingCycle.class));				
			//view.addObject("participationStatusMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.Indicator.class));
			view.addObject("safetyMat", new SafetyMat());
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("settlement",KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			//view.addObject("backsettlement",KC.Enum.getI18nLabelMap(Settlement.class));
			view.addObject("expenses",KC.Enum.getI18nLabelMap(Expenses.class));
			SafetyMat safetyMat = parameterSurface.getParameterObject(code, SafetyMat.class);
			view.addObject("safetyMat",safetyMat);
			//所属机构
			FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
			List<PcmOrgParameter> list = response.getRows();
			Map<String,String> orgMap = new HashMap<String,String>();
			for (PcmOrgParameter pcmOrgParameter : list) {
				orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}
			view.addObject("orgMap",orgMap);
			//资产方
			List<AssetSideInfo> AssetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
			Map<String,String> assetSideInfoMap = new HashMap<String,String>();
			for (AssetSideInfo AssetSideInfo : AssetSideInfoList) {
				assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideCode());
			}
			view.addObject("assetSideInfoMap",assetSideInfoMap);
			view.addObject("assetSideInfo",assetSideInfoMap.get(safetyMat.getAsset()));
			//安全垫下限控制方式
			view.addObject("controlModeMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.SafetyPadLowerLimitControlMode.class));
			//技术服务费收取方式
			view.addObject("chargeWayMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionMethod.class));
			//技术服务费收取基础
			view.addObject("chargeBasicsMap", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.TechnicalServiceFeeCollectionBasics.class));
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"safetyMat.safetyMatEditPageFail","加载修改安全垫页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改安全垫
	 * </p>
	 * @param safetyMat
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updSafetyMat.in", method = { RequestMethod.POST })
	public void updSafetyMat(SafetyMat safetyMat) throws FlatException {
		try {
			parameterSurface.updateParameterObject(safetyMat.getCode(), safetyMat);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), safetyMat.getCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "safetyMat.updSafetyMatFail", "修改安全垫失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除安全垫
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delSafetyMat.in", method = { RequestMethod.POST })
	public void delSafetyMats(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes, SafetyMat.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "safetyMat.delSafetyMatFail", "删除安全垫失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载安全垫明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("safetyMatDetailPage.in")
	public ModelAndView safetyMatDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("safetyMat/safetyMatDetail");
			 view.addObject("factory",code==null); 
			SafetyMat safetyMat = parameterSurface.getParameterObject(dcode==null?code:dcode, SafetyMat.class);
			safetyMat.setTransferAccount(getPcmSettleAccMan(safetyMat.getTransferAccount()));
			safetyMat.setTransferToAccount(getPcmSettleAccMan(safetyMat.getTransferToAccount()));
			view.addObject("safetyMat", safetyMat);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(safetyMat.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(safetyMat.getFeeBasis()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(safetyMat.getFrequencyOfCharge()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(safetyMat.getBillingCycle()));
			//view.addObject("participationStatus", KC.Enum.getI18nLabel(safetyMat.getParticipationStatus()));
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(safetyMat.getOrganization(),PcmOrgParameter.class);
			view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			//资产方
			AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(safetyMat.getAsset(),AssetSideInfo.class);
			view.addObject("assetSideInfo",assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
			//安全垫下限控制方式
			view.addObject("controlMode", KC.Enum.getI18nLabel(safetyMat.getControlMode()));
			//技术服务费收取方式
			view.addObject("chargeWay", KC.Enum.getI18nLabel(safetyMat.getChargeWay()));
			//技术服务费收取基础
			view.addObject("chargeBasics", KC.Enum.getI18nLabel(safetyMat.getChargeBasics()));
			
			view.addObject("settlement",KC.Enum.getI18nLabel(safetyMat.getSettlement()));
			//view.addObject("backsettlement",KC.Enum.getI18nLabel(safetyMat.getBacksettlement()));
			view.addObject("expenses",KC.Enum.getI18nLabel(safetyMat.getExpenses()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "safetyMat.safetyMatDetailPageFail", "加载安全垫详情页面失败");
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
                    parameterSurface.getParameterObject(SafetyMat.class).forEach(
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
	   SafetyMat parameterObject = parameterSurface.getParameterObject(code,SafetyMat.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCode());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getBillingCycle()));
                   return list;
   }
	
	
	
	
	
}