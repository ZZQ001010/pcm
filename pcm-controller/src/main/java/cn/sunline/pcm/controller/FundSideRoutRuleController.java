package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.FundSideRoutRule;
import cn.sunline.pcm.definition.PcmOrgParameter;

/** 
 * <p>
 * 资产方路由规则 Controller 层
 * </p>
 * @version 1.0 2019-07-11 修改内容:初版
 */ 
@Controller
@RequestMapping("fundSideRoutRule")
public class FundSideRoutRuleController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 资产方路由规则 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideRoutRuleQueryPage.in")
	public ModelAndView fundSideRoutRuleQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideRoutRule/fundSideRoutRuleQuery");
			view.addObject("fundSideRoutRule", new FundSideRoutRule());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideRoutRule.fundSideRoutRuleQueryPageFail","加载资产方路由规则列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资产方路由规则列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryFundSideRoutRuleList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryFundSideRoutRuleList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, FundSideRoutRule.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideRoutRule.queryFundSideRoutRuleListFail","查询资产方路由规则列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资产方路由规则页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideRoutRuleAddPage.in")
	public ModelAndView fundSideRoutRuleAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideRoutRule/fundSideRoutRuleAdd");
			view.addObject("fundSideRoutRule", new FundSideRoutRule());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideRoutRule.fundSideRoutRuleAddPageFail","加载新增资产方路由规则页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资产方路由规则
	 * </p>
	 * @param fundSideRoutRule
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addFundSideRoutRule.in", method = { RequestMethod.POST })
	public void addFundSideRoutRule(FundSideRoutRule fundSideRoutRule) throws FlatException {
		try {
			parameterSurface.addNewParameter(fundSideRoutRule.getFundSideRoutCode(), fundSideRoutRule);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideRoutRule.addFundSideRoutRuleFail", "新增资产方路由规则失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资产方路由规则页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideRoutRuleEditPage.in")
	public ModelAndView fundSideRoutRuleEditPage(String fundSideRoutCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideRoutRule/fundSideRoutRuleEdit");
			FundSideRoutRule fundSideRoutRule = parameterSurface.getParameterObject(fundSideRoutCode, FundSideRoutRule.class);
			view.addObject("fundSideRoutRule", fundSideRoutRule);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideRoutRule.fundSideRoutRuleEditPageFail","加载修改资产方路由规则页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资产方路由规则
	 * </p>
	 * @param fundSideRoutRule
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updFundSideRoutRule.in", method = { RequestMethod.POST })
	public void updFundSideRoutRule(FundSideRoutRule fundSideRoutRule) throws FlatException {
		try {
			parameterSurface.updateParameterObject(fundSideRoutRule.getFundSideRoutCode(), fundSideRoutRule);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideRoutRule.getFundSideRoutCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideRoutRule.updFundSideRoutRuleFail", "修改资产方路由规则失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资产方路由规则
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delFundSideRoutRule.in", method = { RequestMethod.POST })
	public void delFundSideRoutRules(@RequestBody List<String> fundSideRoutCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(fundSideRoutCodes, FundSideRoutRule.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideRoutRule.delFundSideRoutRuleFail", "删除资产方路由规则失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资产方路由规则明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideRoutRuleDetailPage.in")
	public ModelAndView fundSideRoutRuleDetailPage(String fundSideRoutCode,String code,ModelAndView view) throws FlatException {
		try {
		
			
			 view = KW.mvc.forwardView("fundSideRoutRule/fundSideRoutRuleDetail");
				view.addObject("factory",code==null);
			FundSideRoutRule fundSideRoutRule = parameterSurface.getParameterObject(fundSideRoutCode==null?code:fundSideRoutCode, FundSideRoutRule.class);
			view.addObject("fundSideRoutRule", fundSideRoutRule);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideRoutRule.fundSideRoutRuleDetailPageFail", "加载资产方路由规则详情页面失败");
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
                    parameterSurface.getParameterObject(FundSideRoutRule.class).forEach(
                                    item->resMap.put(item.getRoutRuleCode(),item.getFundSIdeRoutDesc()));
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
	   FundSideRoutRule fundSideRoutRule = parameterSurface.getParameterObject(code,FundSideRoutRule.class);
                   List<String> list = new ArrayList<>();
                   list.add(fundSideRoutRule.getFundSideRoutCode());
                   list.add(fundSideRoutRule.getFundSIdeRoutDesc());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(fundSideRoutRule.getFundSide());
                   return list;
   }
	
}