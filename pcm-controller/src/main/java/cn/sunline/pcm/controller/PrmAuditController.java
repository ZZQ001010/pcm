package cn.sunline.pcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.surface.PrmAuditSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 参数变更日志 Controller 层
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */ 
@Controller
@RequestMapping("prmAudit")
public class PrmAuditController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PrmAuditSurface prmAuditSurface;
	

	/** 
	 * <p>
	 * 参数变更日志 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmAuditQueryPage.in")
	public ModelAndView prmAuditQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("prmAudit/prmAuditQuery");
			view.addObject("paramOperationJson", KC.Enum.getI18nLabelMapJson(ParamOperationDef.class));
			view.addObject("paramOperation", KC.Enum.getI18nLabelMap(ParamOperationDef.class));				
			view.addObject("tmPrmAudit", new BPcmPrmAudit());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prmAudit.prmAuditQueryPageFail","加载参数变更日志列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询参数变更日志列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPrmAuditList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPrmAuditList(FetchRequest request) throws FlatException{
		try {
			return prmAuditSurface.queryPrmAuditList(request);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"prmAudit.queryPrmAuditListFail","查询参数变更日志列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载参数变更日志明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("prmAuditDetailPage.in")
	public ModelAndView prmAuditDetailPage(String id) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("prmAudit/prmAuditDetail");
			BPcmPrmAudit tmPrmAudit = prmAuditSurface.findPrmAuditById(id);
			view.addObject("tmPrmAudit", tmPrmAudit);
			view.addObject("paramOperation", KC.Enum.getI18nLabel(tmPrmAudit.getParamOperation()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "prmAudit.prmAuditDetailPageFail", "加载参数变更日志详情页面失败");
		}
	}
	
}