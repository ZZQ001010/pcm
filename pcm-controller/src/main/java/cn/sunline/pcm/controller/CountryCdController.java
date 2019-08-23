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
import cn.sunline.pcm.definition.CountryCd;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 国家代码管理 Controller 层
 * </p>
 * @author fuliwen
 * @version 1.0 2018-01-03 修改内容:初版
 */ 
@Controller
@RequestMapping("countryCd")
public class CountryCdController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 国家代码管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("countryCdQueryPage.in")
	public ModelAndView countryCdQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("countryCd/countryCdQuery");
			view.addObject("countryCdModel", new CountryCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"countryCd.countryCdQueryPageFail","加载国家代码管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询国家代码管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryCountryCdList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryCountryCdList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, CountryCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"countryCd.queryCountryCdListFail","查询国家代码管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增国家代码管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("countryCdAddPage.in")
	public ModelAndView countryCdAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("countryCd/countryCdAdd");
			view.addObject("countryCd", new CountryCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"countryCd.countryCdAddPageFail","加载新增国家代码管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增国家代码管理
	 * </p>
	 * @param countryCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addCountryCd.in", method = { RequestMethod.POST })
	public void addCountryCd(CountryCd countryCd) throws FlatException {
		try {
			parameterSurface.addNewParameter(countryCd.getCountryCd(), countryCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "countryCd.addCountryCdFail", "新增国家代码管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改国家代码管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("countryCdEditPage.in")
	public ModelAndView countryCdEditPage(String countryCd, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("countryCd/countryCdEdit");
			CountryCd countryCd1 = parameterSurface.getParameterObject(countryCd, CountryCd.class);
			view.addObject("countryCd", countryCd1);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"countryCd.countryCdEditPageFail","加载修改国家代码管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改国家代码管理
	 * </p>
	 * @param countryCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updCountryCd.in", method = { RequestMethod.POST })
	public void updCountryCd(CountryCd countryCd) throws FlatException {
		try {
			parameterSurface.updateParameterObject(countryCd.getCountryCd(), countryCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), countryCd.getCountryCd());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "countryCd.updCountryCdFail", "修改国家代码管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除国家代码管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delCountryCd.in", method = { RequestMethod.POST })
	public void delCountryCds(@RequestBody List<String> countryCds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(countryCds, CountryCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "countryCd.delCountryCdFail", "删除国家代码管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载国家代码管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("countryCdDetailPage.in")
	public ModelAndView countryCdDetailPage(String countryCd) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("countryCd/countryCdDetail");
			CountryCd countryCd1 = parameterSurface.getParameterObject(countryCd, CountryCd.class);
			view.addObject("countryCd", countryCd1);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "countryCd.countryCdDetailPageFail", "加载国家代码管理详情页面失败");
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
                    parameterSurface.getParameterObject(CountryCd.class).forEach(
                                    item->resMap.put(item.getCountryCd(),item.getCountryCdShort()));
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
	   CountryCd parameterObject = parameterSurface.getParameterObject(code,CountryCd.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCountryCd());
                   list.add(parameterObject.getCountryCdShort());
                   return list;
   }
	
}