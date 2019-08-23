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

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.MessageTemplate;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.MessageSendingMethod;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.web.service.CodeService;

/** 
 * <p>
 * 短信模板 Controller 层
 * </p>
 * @version 1.0 2017-11-07 修改内容:初版
 */ 
@Controller
@RequestMapping("msgTemplate")
public class MsgTemplateController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private CodeService codeService;

	/** 
	 * <p>
	 * 短信模板 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("msgTemplateQueryPage.in")
	public ModelAndView msgTemplateQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("msgTemplate/msgTemplateQuery");
			view.addObject("systemTypeJson", KC.json.serializerNoType(codeService.getCodeMapByCodeType("SystemCode")));				
			view.addObject("systemType", codeService.getCodeMapByCodeType("SystemCode"));				
			view.addObject("msgCategoryJson", KC.json.serializerNoType(codeService.getCodeMapByCodeType("msgGroup")));				
			view.addObject("msgCategory", codeService.getCodeMapByCodeType("msgGroup"));				
			view.addObject("sendingMethodJson", KC.Enum.getI18nLabelMapJson(MessageSendingMethod.class));
			view.addObject("bMPMessageTemplate", new MessageTemplate());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"msgTemplate.msgTemplateQueryPageFail","加载短信模板列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询短信模板列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryMsgTemplateList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryMsgTemplateList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, MessageTemplate.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"msgTemplate.queryMsgTemplateListFail","查询短信模板列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增短信模板页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("msgTemplateAddPage.in")
	public ModelAndView msgTemplateAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("msgTemplate/msgTemplateAdd");
			view.addObject("systemType", codeService.getCodeMapByCodeType("SystemCode"));	
			//没有依赖
			view.addObject("msgCategory",  codeService.getCodeMapByCodeType("msgGroup"));		
			view.addObject("sendingMethod", KC.Enum.getI18nLabelMap(MessageSendingMethod.class));				
			view.addObject("bMPMessageTemplate", new MessageTemplate());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"msgTemplate.msgTemplateAddPageFail","加载新增短信模板页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增短信模板
	 * </p>
	 * @param bMPMessageTemplate
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addMsgTemplate.in", method = { RequestMethod.POST })
	public void addMsgTemplate(MessageTemplate bMPMessageTemplate) throws FlatException {
		try {
			parameterSurface.addNewParameter(bMPMessageTemplate.getCode(), bMPMessageTemplate);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "msgTemplate.addMsgTemplateFail", "新增短信模板失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改短信模板页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("msgTemplateEditPage.in")
	public ModelAndView msgTemplateEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("msgTemplate/msgTemplateEdit");
			view.addObject("systemType", codeService.getCodeMapByCodeType("SystemCode"));				
			view.addObject("msgCategory", codeService.getCodeMapByCodeType("msgGroup"));				
			view.addObject("sendingMethod", KC.Enum.getI18nLabelMap(MessageSendingMethod.class));				
			MessageTemplate bMPMessageTemplate = parameterSurface.getParameterObject(code, MessageTemplate.class);
			view.addObject("bMPMessageTemplate", bMPMessageTemplate);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"msgTemplate.msgTemplateEditPageFail","加载修改短信模板页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改短信模板
	 * </p>
	 * @param bMPMessageTemplate
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updMsgTemplate.in", method = { RequestMethod.POST })
	public void updMsgTemplate(MessageTemplate bMPMessageTemplate) throws FlatException {
		try {
			parameterSurface.updateParameterObject(bMPMessageTemplate.getCode(), bMPMessageTemplate);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bMPMessageTemplate.getCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "msgTemplate.updMsgTemplateFail", "修改短信模板失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除短信模板
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delMsgTemplate.in", method = { RequestMethod.POST })
	public void delMsgTemplates(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes, MessageTemplate.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "msgTemplate.delMsgTemplateFail", "删除短信模板失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载短信模板明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("msgTemplateDetailPage.in")
	public ModelAndView msgTemplateDetailPage(String code) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("msgTemplate/msgTemplateDetail");
			MessageTemplate bMPMessageTemplate = parameterSurface.getParameterObject(code, MessageTemplate.class);
			view.addObject("bMPMessageTemplate", bMPMessageTemplate);
			view.addObject("systemType", codeService.getCodeNameByCodeType("SystemCode", bMPMessageTemplate.getSystemType()));				
			view.addObject("msgCategory", codeService.getCodeNameByCodeType("MsgGroup", bMPMessageTemplate.getMsgCategory()));				
			view.addObject("sendingMethod", KC.Enum.getI18nLabel(bMPMessageTemplate.getSendingMethod()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "msgTemplate.msgTemplateDetailPageFail", "加载短信模板详情页面失败");
		}
	}
	//详情按钮
	@RequestMapping("msgTemplateCheckPage.in")
	public ModelAndView msgTemplateCheckPage(String code) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("msgTemplate/msgTemplateCheck");
			MessageTemplate bMPMessageTemplate = parameterSurface.getParameterObject(code, MessageTemplate.class);
			view.addObject("bMPMessageTemplate", bMPMessageTemplate);
			view.addObject("systemType", codeService.getCodeNameByCodeType("SystemCode", bMPMessageTemplate.getSystemType()));				
			view.addObject("msgCategory", codeService.getCodeNameByCodeType("MsgGroup", bMPMessageTemplate.getMsgCategory()));				
			view.addObject("sendingMethod", KC.Enum.getI18nLabel(bMPMessageTemplate.getSendingMethod()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "msgTemplate.msgTemplateDetailPageFail", "加载短信模板详情页面失败");
		}
	}
	
}