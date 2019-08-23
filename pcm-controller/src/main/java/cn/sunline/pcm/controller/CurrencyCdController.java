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
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 货币代码管理 Controller 层
 * </p>
 * @author fuliwen
 * @version 1.0 2018-01-03 修改内容:初版
 */ 
@Controller
@RequestMapping("currencyCd")
public class CurrencyCdController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 货币代码管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("currencyCdQueryPage.in")
	public ModelAndView currencyCdQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("currencyCd/currencyCdQuery");
			view.addObject("currencyCdModel", new CurrencyCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"currencyCd.currencyCdQueryPageFail","加载货币代码管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询货币代码管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryCurrencyCdList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryCurrencyCdList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, CurrencyCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"currencyCd.queryCurrencyCdListFail","查询货币代码管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增货币代码管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("currencyCdAddPage.in")
	public ModelAndView currencyCdAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("currencyCd/currencyCdAdd");
			view.addObject("currencyCd", new CurrencyCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"currencyCd.currencyCdAddPageFail","加载新增货币代码管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增货币代码管理
	 * </p>
	 * @param currencyCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addCurrencyCd.in", method = { RequestMethod.POST })
	public void addCurrencyCd(CurrencyCd currencyCd) throws FlatException {
		try {
			parameterSurface.addNewParameter(currencyCd.getCurrencyCd(), currencyCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "currencyCd.addCurrencyCdFail", "新增货币代码管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改货币代码管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("currencyCdEditPage.in")
	public ModelAndView currencyCdEditPage(String currencyCd, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("currencyCd/currencyCdEdit");
			CurrencyCd currencyCd1 = parameterSurface.getParameterObject(currencyCd, CurrencyCd.class);
			view.addObject("currencyCd", currencyCd1);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"currencyCd.currencyCdEditPageFail","加载修改货币代码管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改货币代码管理
	 * </p>
	 * @param currencyCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updCurrencyCd.in", method = { RequestMethod.POST })
	public void updCurrencyCd(CurrencyCd currencyCd) throws FlatException {
		try {
			parameterSurface.updateParameterObject(currencyCd.getCurrencyCd(), currencyCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), currencyCd.getCurrencyCd());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "currencyCd.updCurrencyCdFail", "修改货币代码管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除货币代码管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delCurrencyCd.in", method = { RequestMethod.POST })
	public void delCurrencyCds(@RequestBody List<String> currencyCds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(currencyCds, CurrencyCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "currencyCd.delCurrencyCdFail", "删除货币代码管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载货币代码管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("currencyCdDetailPage.in")
	public ModelAndView currencyCdDetailPage(String currencyCd) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("currencyCd/currencyCdDetail");
			CurrencyCd currencyCd1 = parameterSurface.getParameterObject(currencyCd, CurrencyCd.class);
			view.addObject("currencyCd", currencyCd1);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "currencyCd.currencyCdDetailPageFail", "加载货币代码管理详情页面失败");
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
                    parameterSurface.getParameterObject(CurrencyCd.class).forEach(
                                    item->resMap.put(item.getCurrencyCd(),item.getDescription()));
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
	   CurrencyCd parameterObject = parameterSurface.getParameterObject(code,CurrencyCd.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCurrencyCd());
                   list.add(parameterObject.getDescription());
                   return list;
   }

	
}