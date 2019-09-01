package cn.sunline.pcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl;
import cn.sunline.pcm.surface.PrmControlSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 参数管控 Controller 层
 * </p>
 * 
 * @version 1.0 2017-11-11 修改内容:初版
 */
@Controller
@RequestMapping("prmControl")
public class PrmControlController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PrmControlSurface prmControlSurface;

	/**
	 * <p>
	 * 参数管控 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmControlQueryPage.in")
	public ModelAndView prmControlQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prmControl/prmControlQuery");
			view.addObject("tmPrmControl", new BPcmPrmControl());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.prmControlQueryPageFail", "加载参数管控列表页面失败");
		}
	}

	/**
	 * <p>
	 * 查询参数管控列表
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "queryPrmControlList.in", method = {RequestMethod.POST})
	public FetchResponse<?> queryPrmControlList(FetchRequest request) throws FlatException {
		try {
			return prmControlSurface.queryPrmControlList(request);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.queryPrmControlListFail", "查询参数管控列表失败");
		}
	}

	/**
	 * <p>
	 * 加载新增参数管控页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmControlAddPage.in")
	public ModelAndView prmControlAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prmControl/prmControlAdd");
			view.addObject("tmPrmControl", new BPcmPrmControl());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.prmControlAddPageFail", "加载新增参数管控页面异常");
		}
	}

	/**
	 * <p>
	 * 新增参数管控
	 * </p>
	 * 
	 * @param tmPrmControl
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPrmControl.in", method = {RequestMethod.POST})
	public void addPrmControl(BPcmPrmControl tmPrmControl) throws FlatException {
		try {
			prmControlSurface.addPrmControl(tmPrmControl);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.addPrmControlFail", "新增参数管控失败");
		}
	}

	/**
	 * <p>
	 * 加载修改参数管控页面
	 * </p>
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmControlEditPage.in")
	public ModelAndView prmControlEditPage(String id, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prmControl/prmControlEdit");
			BPcmPrmControl tmPrmControl = prmControlSurface.findPrmControlById(id);
			view.addObject("tmPrmControl", tmPrmControl);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.prmControlEditPageFail", "加载修改参数管控页面失败");
		}
	}

	/**
	 * <p>
	 * 修改参数管控
	 * </p>
	 * 
	 * @param tmPrmControl
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPrmControl.in", method = {RequestMethod.POST})
	public void updPrmControl(BPcmPrmControl bPcmPrmControl) throws FlatException {
		try {
			prmControlSurface.updPrmControl(bPcmPrmControl);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bPcmPrmControl.getId().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.updPrmControlFail", "修改参数管控失败");
		}
	}

	/**
	 * <p>
	 * 删除参数管控
	 * </p>
	 * 
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPrmControl.in", method = {RequestMethod.POST})
	public void delPrmControls(@RequestBody List<String> ids) throws FlatException {
		try {
			prmControlSurface.delPrmControlByIds(ids);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.delPrmControlFail", "删除参数管控失败");
		}
	}

	/**
	 * <p>
	 * 加载参数管控明细页面
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmControlDetailPage.in")
	public ModelAndView prmControlDetailPage(String id) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prmControl/prmControlDetail");
			BPcmPrmControl tmPrmControl = prmControlSurface.findPrmControlById(id);
			view.addObject("tmPrmControl", tmPrmControl);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmControl.prmControlDetailPageFail", "加载参数管控详情页面失败");
		}
	}

}