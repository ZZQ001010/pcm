package cn.sunline.pcm.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.web.service.CodeService;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.Organization;
import cn.sunline.pcm.definition.enums.PbocRptType;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.GraceIntType;

/** 
 * <p>
 * 机构参数管理 Controller 层
 * </p>
 * @version 1.0 2019-01-29 修改内容:初版
 */ 
@Controller
@RequestMapping("organization")
public class OrganizationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParameterSurface parameterSurface;

	@Autowired
	private CodeService codeService;

	/**
	 * <p>
	 * 机构参数维护 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("organizationQueryPage.in")
	public ModelAndView organizationQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("organization/organizationQuery");
			Organization organization = parameterSurface.getParameterObject("*", Organization.class);
			if (organization == null) {
				organization = new Organization();
			}
//			view.addObject("dualEnableInd", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("needRds", codeService.getCodeMapByCodeType("booleanDic"));
			view.addObject("intPostOnPlan", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("creditVoidOtbCtrlInd", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("creditReverseOtbCtrlInd", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("glAgeCdConsistentWithAgeCd", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("cashLoanNeedAudit", codeService.getCodeMapByCodeType("booleanDic"));
//			view.addObject("limitControlType", KC.Enum.getI18nLabelMap(LimitControlType.class));
			view.addObject("overlimitDeferInd", KC.Enum.getI18nLabelMap(GraceIntType.class));
			view.addObject("nofullpayDeferInd", KC.Enum.getI18nLabelMap(GraceIntType.class));
			view.addObject("pbocType", KC.Enum.getI18nLabelMap(PbocRptType.class));
			view.addObject("bookingOnlineFlag", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("repayBookingOnlineFlag", KC.Enum.getI18nLabelMap(Indicator.class));
//			view.addObject("noCardSelfDiscern", KC.Enum.getI18nLabelMap(NoCardSelfDiscern.class));
//			view.addObject("cashLoanSendMode", KC.Enum.getI18nLabelMap(LoanLendWay.class));
			
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> map1=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				map1.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("baseCurrCd",map1);
			view.addObject("organization", organization);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"organization.organizationQueryPageFail","加载机构参数管理列表页面失败");
		}
	}
	/**
	 * <p>
	 * 保存机构参数维护 页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "saveOrganizationPage.in", method = { RequestMethod.POST })
	public void saveOrganizationPage(@RequestBody Organization organization) throws FlatException {
		try {
			Organization org = parameterSurface.getParameterObject("*", Organization.class);
			if (org != null) {
				parameterSurface.updateParameterObject("*", organization);
			} else {
				parameterSurface.addNewParameter("*", organization);
			}
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException("保存机构参数失败");
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
                    parameterSurface.getParameterObject(Organization.class).forEach(
                                    item->resMap.put("*","*"));
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
	   Organization organization = parameterSurface.getParameterObject(code,Organization.class);
                   List<String> list = new ArrayList<>();
                   list.add(organization.getBaseCurrCd());
                   list.add(organization.getCreditInstitutions());
                   list.add(organization.getDefaultBranchNo());
                   return list;
   }

   /**
    * 详情页面
    */
   @ResponseBody
   @GetMapping(value="/organizationDetailPage.in")
   public ModelAndView unitDetails(String code,ModelAndView view){
	   view=KW.mvc.forwardView("organization/organizationDetail");
	   Organization organization = parameterSurface.getParameterObject(code,Organization.class);
	   view.addObject("organization",organization);
	   return view; 
   }
	
	
	
	
}