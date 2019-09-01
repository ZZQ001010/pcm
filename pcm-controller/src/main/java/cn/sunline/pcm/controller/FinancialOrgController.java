package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

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
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.FinancialOrg;
import cn.sunline.pcm.definition.FundSideRoutRule;
import cn.sunline.pcm.definition.Split;
import cn.sunline.pcm.definition.enums.CheckE4Channel;
import cn.sunline.pcm.definition.enums.ClaimType;
import cn.sunline.pcm.definition.enums.SettleUnit;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 合作机构 Controller 层
 * </p>
 * 
 * @version 1.0 2017-11-10 xiongyuanyuan 修改内容:初版
 */
@Controller
@RequestMapping("financialOrg")
public class FinancialOrgController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;

	@Autowired
	private AddressHelperFacility addressHelperFacility;

	/**
	 * <p>
	 * 合作机构 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgQueryPage.in")
	public ModelAndView financialOrgQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgQuery");
			view.addObject("financialOrg", new FinancialOrg());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.financialOrgQueryPageFail", "加载合作机构列表页面失败");
		}
	}

	/**
	 * <p>
	 * 查询合作机构列表
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "queryFinancialOrgList.in", method = {RequestMethod.POST})
	public FetchResponse<?> queryFinancialOrgList(FetchRequest request) throws FlatException {
		try {
			return parameterSurface.getFetchResponse(request, FinancialOrg.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.queryFinancialOrgListFail", "查询合作机构列表失败");
		}
	}

	/**
	 * <p>
	 * 加载新增合作机构页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgAddPage.in")
	public ModelAndView financialOrgAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgAdd");

			view.addObject("settleUnit", KC.Enum.getI18nLabelMap(SettleUnit.class));
			view.addObject("claimType", KC.Enum.getI18nLabelMap(ClaimType.class));
			TreeMap<String, String> map = addressHelperFacility.loadProvince();
			view.addObject("province", map);
			view.addObject("acctProvince", map);
			view.addObject("payProvince", map);

			List<FinancialOrg> orgList = parameterSurface.getParameterObject(FinancialOrg.class);
			Map<String, String> orgMap = new LinkedHashMap<String, String>();
			for (FinancialOrg org : orgList) {
				orgMap.put(org.getAcqAcceptorId(), org.getAcqAcceptorId() + "-" + org.getFinancialOrgName());
			}
			view.addObject("financialOrgMap", orgMap);

			List<Split> splitList = parameterSurface.getParameterObject(Split.class);
			Map<String, String> splitMap = new LinkedHashMap<String, String>();
			for (Split split : splitList) {
				splitMap.put(split.getSplitTableId(), split.getSplitTableId() + "-" + split.getSplitName());
			}
			view.addObject("splitTableId", splitMap);
			view.addObject("acctCity", new LinkedHashMap<String, String>());
			view.addObject("payCity", new LinkedHashMap<String, String>());
			view.addObject("isSettle", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("checkE4Channel", KC.Enum.getI18nLabelMap(CheckE4Channel.class));
			view.addObject("city", new LinkedHashMap<String, String>());
			view.addObject("externalLoanCompOrg", new LinkedHashMap<String, String>());
			view.addObject("derectLoanCompOrg", new LinkedHashMap<String, String>());
			view.addObject("externalCutCompOrg", new LinkedHashMap<String, String>());
			view.addObject("derectCutCompOrg", new LinkedHashMap<String, String>());
			view.addObject("externalLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("derectLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("externalCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("derectCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("financialOrg", new FinancialOrg());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.financialOrgAddPageFail", "加载新增合作机构页面异常");
		}
	}

	/**
	 * <p>
	 * 新增合作机构
	 * </p>
	 * 
	 * @param financialOrg
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addFinancialOrg.in", method = {RequestMethod.POST})
	public void addFinancialOrg(FinancialOrg financialOrg) throws FlatException {
		try {
			parameterSurface.addNewParameter(financialOrg.getFinancialOrgNO(), financialOrg);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.addFinancialOrgFail", "新增合作机构失败");
		}
	}

	/**
	 * <p>
	 * 加载修改合作机构页面
	 * </p>
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgEditPage.in")
	public ModelAndView financialOrgEditPage(String financialOrgNO, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgEdit");
//			view.addObject("acctProvince", codeService.getCodeMapByCodeType(""));				
//			view.addObject("acctCity", codeService.getCodeMapByCodeType(""));				
//			view.addObject("payProvince", codeService.getCodeMapByCodeType(""));				
//			view.addObject("payCity", codeService.getCodeMapByCodeType(""));				
//			view.addObject("splitTableId", codeService.getCodeMapByCodeType(""));				

//			view.addObject("province", codeService.getCodeMapByCodeType(""));				
//			view.addObject("city", codeService.getCodeMapByCodeType(""));				
//			view.addObject("externalLoanCompOrg", codeService.getCodeMapByCodeType(""));				
//			view.addObject("derectLoanCompOrg", codeService.getCodeMapByCodeType(""));				
//			view.addObject("externalCutCompOrg", codeService.getCodeMapByCodeType(""));				
//			view.addObject("derectCutCompOrg", codeService.getCodeMapByCodeType(""));	

//			view.addObject("externalLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("derectLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("externalCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("derectCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));
//			view.addObject("isSettle", KC.Enum.getI18nLabelMap(Indicator.class));

//			view.addObject("payProvince", new LinkedHashMap<String, String>());				
//			view.addObject("payCity", new LinkedHashMap<String, String>());				
//			view.addObject("splitTableId", new LinkedHashMap<String, String>());				
//			view.addObject("isSettle", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("province", new LinkedHashMap<String, String>());				
//			view.addObject("city", new LinkedHashMap<String, String>());				
//			view.addObject("externalLoanCompOrg", new LinkedHashMap<String, String>());				
//			view.addObject("derectLoanCompOrg", new LinkedHashMap<String, String>());				
//			view.addObject("externalCutCompOrg", new LinkedHashMap<String, String>());				
//			view.addObject("derectCutCompOrg", new LinkedHashMap<String, String>());
//			view.addObject("externalLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("derectLoanCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("externalCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("derectCutCompInd", KC.Enum.getI18nLabelMap(Indicator.class));	
			view.addObject("checkE4Channel", KC.Enum.getI18nLabelMap(CheckE4Channel.class));
			FinancialOrg financialOrg = parameterSurface.getParameterObject(financialOrgNO, FinancialOrg.class);

			view.addObject("financialOrg", financialOrg);
			if (financialOrg.getIsSettle() != null) {
				view.addObject("isSettle", financialOrg.getIsSettle());
			}
			if (financialOrg.getDerectCutCompInd() != null) {
				view.addObject("derectCutCompInd", financialOrg.getDerectCutCompInd());
			}
			if (financialOrg.getExternalCutCompInd() != null) {
				view.addObject("externalCutCompInd", financialOrg.getExternalCutCompInd());
			}
			if (financialOrg.getDerectLoanCompInd() != null) {
				view.addObject("derectLoanCompInd", financialOrg.getDerectLoanCompInd());
			}
			if (financialOrg.getExternalLoanCompInd() != null) {
				view.addObject("externalLoanCompInd", financialOrg.getExternalLoanCompInd());
			}

			view.addObject("settleUnit", KC.Enum.getI18nLabelMap(SettleUnit.class));
			view.addObject("claimType", KC.Enum.getI18nLabelMap(ClaimType.class));
			view.addObject("payProvince", addressHelperFacility.loadProvince());
			if (KC.string.isNotBlank(financialOrg.getPayProvince())) {
				view.addObject("payCity", addressHelperFacility.loadCity(financialOrg.getPayProvince()));
			}
			view.addObject("acctProvince", addressHelperFacility.loadProvince());
			if (KC.string.isNotBlank(financialOrg.getAcctProvince())) {
				view.addObject("acctCity", addressHelperFacility.loadCity(financialOrg.getAcctProvince()));
			}
			view.addObject("province", addressHelperFacility.loadProvince());
			if (KC.string.isNotBlank(financialOrg.getProvince())) {
				view.addObject("city", addressHelperFacility.loadCity(financialOrg.getProvince()));
			}

			List<FinancialOrg> orgList = parameterSurface.getParameterObject(FinancialOrg.class);
			Map<String, String> orgMap = new LinkedHashMap<String, String>();
			for (FinancialOrg org : orgList) {
				orgMap.put(org.getAcqAcceptorId(), org.getAcqAcceptorId() + "-" + org.getFinancialOrgName());
			}
			view.addObject("financialOrgMap", orgMap);

			List<Split> splitList = parameterSurface.getParameterObject(Split.class);
			Map<String, String> splitMap = new LinkedHashMap<String, String>();
			for (Split split : splitList) {
				splitMap.put(split.getSplitTableId(), split.getSplitTableId() + "-" + split.getSplitName());
			}
			view.addObject("splitTableId", splitMap);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.financialOrgEditPageFail", "加载修改合作机构页面失败");
		}
	}

	/**
	 * <p>
	 * 修改合作机构
	 * </p>
	 * 
	 * @param financialOrg
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updFinancialOrg.in", method = {RequestMethod.POST})
	public void updFinancialOrg(FinancialOrg financialOrg) throws FlatException {
		try {
			parameterSurface.updateParameterObject(financialOrg.getFinancialOrgNO(), financialOrg);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), financialOrg.getFinancialOrgNO());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.updFinancialOrgFail", "修改合作机构失败");
		}
	}

	/**
	 * <p>
	 * 删除合作机构
	 * </p>
	 * 
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delFinancialOrg.in", method = {RequestMethod.POST})

	public void delFinancialOrgs(@RequestBody List<String> branchIds) throws FlatException {

		try {
			parameterSurface.deleteParameterObjectList(branchIds, FinancialOrg.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.delFinancialOrgFail", "删除合作机构失败");
		}
	}

	/**
	 * <p>
	 * 加载合作机构明细页面
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgDetailPage.in")
	public ModelAndView financialOrgDetailPage(String financialOrgNO,String code) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgDetail");
			view.addObject("factory",financialOrgNO!=null);
			FinancialOrg financialOrg = parameterSurface.getParameterObject(
					financialOrgNO==null?code:financialOrgNO, FinancialOrg.class);
			
			view.addObject("financialOrg", financialOrg);
			if (financialOrg.getIsSettle() != null) {
				view.addObject("isSettle", financialOrg.getIsSettle());
			}
			if (financialOrg.getDerectCutCompInd() != null) {
				view.addObject("derectCutCompInd", financialOrg.getDerectCutCompInd());
			}
			if (financialOrg.getExternalCutCompInd() != null) {
				view.addObject("externalCutCompInd", financialOrg.getExternalCutCompInd());
			}
			if (financialOrg.getDerectLoanCompInd() != null) {
				view.addObject("derectLoanCompInd", financialOrg.getDerectLoanCompInd());
			}
			if (financialOrg.getExternalLoanCompInd() != null) {
				view.addObject("externalLoanCompInd", financialOrg.getExternalLoanCompInd());
			}

			Map<String, String> map = addressHelperFacility.loadChineseAddress();
			financialOrg.setProvince(financialOrg.getProvince() == null ? "" : map.get(financialOrg.getProvince()));
			financialOrg.setCity(financialOrg.getCity() == null ? "" : map.get(financialOrg.getCity()));
			financialOrg.setAcctProvince(
					financialOrg.getAcctProvince() == null ? "" : map.get(financialOrg.getAcctProvince()));
			financialOrg.setAcctCity(financialOrg.getAcctCity() == null ? "" : map.get(financialOrg.getAcctCity()));
			financialOrg.setPayProvince(
					financialOrg.getPayProvince() == null ? "" : map.get(financialOrg.getPayProvince()));
			financialOrg.setPayCity(financialOrg.getPayCity() == null ? "" : map.get(financialOrg.getPayCity()));
			view.addObject("settleUnit", KC.Enum.getI18nLabel(financialOrg.getSettleUnit()));
			view.addObject("claimType", KC.Enum.getI18nLabel(financialOrg.getClaimType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.financialOrgDetailPageFail", "加载合作机构详情页面失败");
		}
	}

	@RequestMapping("financialOrgCheckPage.in")
	public ModelAndView financialOrgCheckPage(String financialOrgNO) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgCheck");
			FinancialOrg financialOrg = parameterSurface.getParameterObject(financialOrgNO, FinancialOrg.class);
			view.addObject("financialOrg", financialOrg);
			if (financialOrg.getIsSettle() != null) {
				view.addObject("isSettle", financialOrg.getIsSettle());
			}
			if (financialOrg.getDerectCutCompInd() != null) {
				view.addObject("derectCutCompInd", financialOrg.getDerectCutCompInd());
			}
			if (financialOrg.getExternalCutCompInd() != null) {
				view.addObject("externalCutCompInd", financialOrg.getExternalCutCompInd());
			}
			if (financialOrg.getDerectLoanCompInd() != null) {
				view.addObject("derectLoanCompInd", financialOrg.getDerectLoanCompInd());
			}
			if (financialOrg.getExternalLoanCompInd() != null) {
				view.addObject("externalLoanCompInd", financialOrg.getExternalLoanCompInd());
			}
			Map<String, String> map = addressHelperFacility.loadChineseAddress();
			financialOrg.setProvince(financialOrg.getProvince() == null ? "" : map.get(financialOrg.getProvince()));
			financialOrg.setCity(financialOrg.getCity() == null ? "" : map.get(financialOrg.getCity()));
			financialOrg.setAcctProvince(
					financialOrg.getAcctProvince() == null ? "" : map.get(financialOrg.getAcctProvince()));
			financialOrg.setAcctCity(financialOrg.getAcctCity() == null ? "" : map.get(financialOrg.getAcctCity()));
			financialOrg.setPayProvince(
					financialOrg.getPayProvince() == null ? "" : map.get(financialOrg.getPayProvince()));
			financialOrg.setPayCity(financialOrg.getPayCity() == null ? "" : map.get(financialOrg.getPayCity()));
			view.addObject("settleUnit", KC.Enum.getI18nLabelMap(SettleUnit.class));
			view.addObject("claimType", KC.Enum.getI18nLabelMap(ClaimType.class));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrg.financialOrgDetailPageFail", "加载合作机构详情页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 产品工厂-加载合作机构配置页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgProductConfigPage.in")
	public ModelAndView financialOrgProductConfigPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgProductConfig");
			//从合作机构管理中取数据
			List<FinancialOrg> financeOrgs = parameterSurface.getParameterObject(FinancialOrg.class);
			String productCode = request.getParameter("productCode");
			view.addObject("financeOrgs", financeOrgs);
			view.addObject("productCode", productCode);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrgProduct.financialOrgProductDetailPageFail", "加载合作机构管理详情页面失败");
		}
	}
	
	/** 
	 * <p>
	 *  产品工厂-加载合作机构详情页面
	 * </p>
	 * @param productCode
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgProductCheckPage.in")
	public ModelAndView financialOrgProductCheckPage(String productCode) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgProductCheck");
			FinancialOrg financialOrgParam = parameterSurface.getParameterObject(productCode, FinancialOrg.class);
			view.addObject("financeOrgNo", financialOrgParam);				
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrgProduct.financialOrgProductDetailPageFail", "加载合作机构管理详情页面失败");
		}
	}
	
	/** 
	 * <p>
	 *  产品工厂-合作机构基础信息展示
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("financialOrgProductSmallPage.in")
	public ModelAndView financialOrgProductSmallPage(String productCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("financialOrg/financialOrgProductSmall");
			FinancialOrg financialOrgParam=null;
			if(KC.string.isNotBlank(productCode)){
				financialOrgParam = parameterSurface.getParameterObject(productCode, FinancialOrg.class);
			}
			if(financialOrgParam==null){
				financialOrgParam=new FinancialOrg();
			}
			view.addObject("financialOrgParam", financialOrgParam);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "financialOrgProduct.financialOrgProductDetailPageFail", "加载合作机构管理详情页面失败");
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
                    parameterSurface.getParameterObject(FinancialOrg.class).forEach(
                                    item->resMap.put(item.getFinancialOrgNO(),item.getFinancialOrgName()));
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
	   FinancialOrg fundSideRoutRule = parameterSurface.getParameterObject(code,FinancialOrg.class);
	   			 HashMap<String, String> map = new HashMap<>();
	   			 
                   List<String> list = new ArrayList<>();
                   list.add(fundSideRoutRule.getFinancialOrgNO());
                   list.add(fundSideRoutRule.getFinancialOrgName());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(fundSideRoutRule.getBankOutAcctName());
                   return list;
   }
	
	
	
	
	
	
	
//	/** 
//	 * <p>
//	 * 修改合作机构管理
//	 * </p>
//	 * @param financialOrgParam
//	 * @throws FlatException
//	 */
//	@ResponseBody
//	@RequestMapping(value = "updFinancialOrgProduct.in", method = { RequestMethod.POST })
//	public void updFinancialOrgProduct(FinancialOrg financialOrgParam) throws FlatException {
//		try {
//			parameterSurface.updateParameterObject(financialOrgParam.getProductCode(), financialOrgParam);
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage(), financialOrgParam.getProductCode());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e, "financialOrgProduct.updFinancialOrgProductFail", "修改合作机构管理失败");
//		}
//	}
//	
//	/** 
//	 * <p>
//	 * 新增合作机构管理
//	 * </p>
//	 * @param financialOrgParam
//	 * @throws FlatException
//	 */
//	@ResponseBody
//	@RequestMapping(value = "addFinancialOrgProduct.in", method = { RequestMethod.POST })
//	public void addFinancialOrgProduct(FinancialOrg financialOrgParam) throws FlatException {
//		try {
//			parameterSurface.addNewParameter(financialOrgParam.getProductCode(), financialOrgParam);
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e, "financialOrgProduct.addFinancialOrgProductFail", "新增合作机构管理失败");
//		}
//	}
}