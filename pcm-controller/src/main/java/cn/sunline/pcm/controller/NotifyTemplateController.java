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
import cn.sunline.pcm.definition.NotifyTemplate;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.MessageType;
import cn.sunline.ppy.dictionary.enums.ReqType;
import cn.sunline.ppy.dictionary.enums.TransprotType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.web.service.CodeService;

/** 
 * <p>
 * 通知模板管理 Controller 层
 * </p>
 * @version 1.0 2018-03-19 修改内容:初版
 */ 
@Controller
@RequestMapping("notifyTemplate")
public class NotifyTemplateController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private CodeService codeService;
	/** 
	 * <p>
	 * 通知模板管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("notifyTemplateQueryPage.in")
	public ModelAndView notifyTemplateQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("notifyTemplate/notifyTemplateQuery");
			//TODO
			view.addObject("messageTypeJson", KC.Enum.getI18nLabelMapJson(MessageType.class));
			view.addObject("messageType", KC.Enum.getI18nLabelMap(MessageType.class));
			view.addObject("notifyTemplate", new NotifyTemplate());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"notifyTemplate.notifyTemplateQueryPageFail","加载通知模板管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询通知模板管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryNotifyTemplateList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryNotifyTemplateList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, NotifyTemplate.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"notifyTemplate.queryNotifyTemplateListFail","查询通知模板管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增通知模板管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("notifyTemplateAddPage.in")
	public ModelAndView notifyTemplateAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("notifyTemplate/notifyTemplateAdd");
			//TODO
			view.addObject("messageType", KC.Enum.getI18nLabelMap(MessageType.class));
			view.addObject("requestType", KC.Enum.getI18nLabelMap(ReqType.class));
//			view.addObject("transportProtocol",new HashMap<String,String>());
			view.addObject("transportProtocol", KC.Enum.getI18nLabelMap(TransprotType.class));
			view.addObject("notifyTemplate", new NotifyTemplate());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"notifyTemplate.notifyTemplateAddPageFail","加载新增通知模板管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增通知模板管理
	 * </p>
	 * @param notifyTemplate
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addNotifyTemplate.in", method = { RequestMethod.POST })
	public void addNotifyTemplate(NotifyTemplate notifyTemplate) throws FlatException {
		try {
			parameterSurface.addNewParameter(notifyTemplate.getNotifyCode(), notifyTemplate);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "notifyTemplate.addNotifyTemplateFail", "新增通知模板管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改通知模板管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("notifyTemplateEditPage.in")
	public ModelAndView notifyTemplateEditPage(String notifyCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("notifyTemplate/notifyTemplateEdit");
			//TODO
			view.addObject("messageType", KC.Enum.getI18nLabelMap(MessageType.class));				
			view.addObject("requestType", KC.Enum.getI18nLabelMap(ReqType.class));
			view.addObject("transportProtocol", KC.Enum.getI18nLabelMap(TransprotType.class));
//			view.addObject("transportProtocol",new HashMap<String,String>() );
			NotifyTemplate notifyTemplate = parameterSurface.getParameterObject(notifyCode, NotifyTemplate.class);
			view.addObject("notifyTemplate", notifyTemplate);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"notifyTemplate.notifyTemplateEditPageFail","加载修改通知模板管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改通知模板管理
	 * </p>
	 * @param notifyTemplate
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updNotifyTemplate.in", method = { RequestMethod.POST })
	public void updNotifyTemplate(NotifyTemplate notifyTemplate) throws FlatException {
		try {
			parameterSurface.updateParameterObject(notifyTemplate.getNotifyCode(), notifyTemplate);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), notifyTemplate.getNotifyCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "notifyTemplate.updNotifyTemplateFail", "修改通知模板管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除通知模板管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delNotifyTemplate.in", method = { RequestMethod.POST })
	public void delNotifyTemplates(@RequestBody List<String> notifyCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(notifyCodes, NotifyTemplate.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "notifyTemplate.delNotifyTemplateFail", "删除通知模板管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载通知模板管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("notifyTemplateDetailPage.in")
	public ModelAndView notifyTemplateDetailPage(String notifyCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("notifyTemplate/notifyTemplateDetail");
			view.addObject("factory", notifyCode == null);
			
			NotifyTemplate notifyTemplate = parameterSurface.getParameterObject(notifyCode==null?code:notifyCode,NotifyTemplate.class);
			view.addObject("notifyTemplate", notifyTemplate);
			//TODO
			view.addObject("messageType", notifyTemplate.getMessageType());
			view.addObject("transportProtocol",notifyTemplate.getTransportProtocol());
			view.addObject("isRepeat",KC.Enum.getI18nLabel(notifyTemplate.getIsRepeat()));
			view.addObject("isHeaders",KC.Enum.getI18nLabel(notifyTemplate.getIsHeaders()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "notifyTemplate.notifyTemplateDetailPageFail", "加载通知模板管理详情页面失败");
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
                    parameterSurface.getParameterObject(NotifyTemplate.class).forEach(
                                    item->resMap.put(item.getNotifyCode(),item.getNoticeName()));
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
	   NotifyTemplate parameterObject = parameterSurface.getParameterObject(code,NotifyTemplate.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getNotifyCode());
                   list.add(parameterObject.getNoticeName());
                   return list;
   }

	
}