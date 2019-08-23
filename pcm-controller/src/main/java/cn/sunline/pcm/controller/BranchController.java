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
import cn.sunline.common.address.AddressHelperFacility;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.BasicInfoOfPremium;
import cn.sunline.pcm.definition.Branch;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 分支机构 Controller 层
 * </p>
 * 
 * @author zhangxingchaun
 * @version 1.0 2017-11-10 修改内容:初版
 */
@Controller
@RequestMapping("branch")
public class BranchController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;

	@Autowired
	private AddressHelperFacility addressHelperFacility;

	/**
	 * <p>
	 * 分支机构 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("branchQueryPage.in")
	public ModelAndView branchQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("branch/branchQuery");
			view.addObject("branch", new Branch());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.branchQueryPageFail", "加载分支机构列表页面失败");
		}
	}

	/**
	 * <p>
	 * 查询分支机构列表
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "queryBranchList.in", method = {RequestMethod.POST})
	public FetchResponse<?> queryBranchList(FetchRequest request) throws FlatException {
		try {
			return parameterSurface.getFetchResponse(request, Branch.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.queryBranchListFail", "查询分支机构列表失败");
		}
	}

	/**
	 * <p>
	 * 加载新增分支机构页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("branchAddPage.in")
	public ModelAndView branchAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("branch/branchAdd");
			view.addObject("acctProvince", addressHelperFacility.loadProvince());
			view.addObject("branch", new Branch());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.branchAddPageFail", "加载新增分支机构页面异常");
		}
	}

	/**
	 * <p>
	 * 新增分支机构
	 * </p>
	 * 
	 * @param branch
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addBranch.in", method = {RequestMethod.POST})
	public void addBranch(Branch branch) throws FlatException {
		try {
			parameterSurface.addNewParameter(branch.getBranchId(), branch);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.addBranchFail", "新增分支机构失败");
		}
	}

	/**
	 * <p>
	 * 加载修改分支机构页面
	 * </p>
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("branchEditPage.in")
	public ModelAndView branchEditPage(String branchId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("branch/branchEdit");
			Branch branch = parameterSurface.getParameterObject(branchId, Branch.class);
			view.addObject("acctProvince", addressHelperFacility.loadProvince());
			view.addObject("acctCity", addressHelperFacility.loadCity(branch.getAcctProvince()));
			view.addObject("branch", branch);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.branchEditPageFail", "加载修改分支机构页面失败");
		}
	}

	/**
	 * <p>
	 * 修改分支机构
	 * </p>
	 * 
	 * @param branch
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updBranch.in", method = {RequestMethod.POST})
	public void updBranch(Branch branch) throws FlatException {
		try {
			parameterSurface.updateParameterObject(branch.getBranchId(), branch);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), branch.getBranchId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.updBranchFail", "修改分支机构失败");
		}
	}

	/**
	 * <p>
	 * 删除分支机构
	 * </p>
	 * 
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delBranch.in", method = {RequestMethod.POST})
	public void delBranchs(@RequestBody List<String> branchIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(branchIds, Branch.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.delBranchFail", "删除分支机构失败");
		}
	}

	/**
	 * <p>
	 * 加载分支机构明细页面
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("branchDetailPage.in")
	public ModelAndView branchDetailPage(String branchId,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("branch/branchDetail");
			view.addObject("factory",branchId==null);
			Map<String, String> map = addressHelperFacility.loadChineseAddress();
			Branch branch = parameterSurface.getParameterObject(branchId==null?code:branchId,Branch.class);
			branch.setAcctProvince(map.get(branch.getAcctProvince()));
			branch.setAcctCity(map.get(branch.getAcctCity()));
			view.addObject("branch", branch);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "branch.branchDetailPageFail", "加载分支机构详情页面失败");
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
                    parameterSurface.getParameterObject(Branch.class).forEach(
                                    item->resMap.put(item.getBranchId(),item.getName()));
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
	   Branch parameterObject = parameterSurface.getParameterObject(code,Branch.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getBranchId());
                   list.add(parameterObject.getName());
                   list.add(parameterObject.getAddress());
                   return list;
   }

  

}