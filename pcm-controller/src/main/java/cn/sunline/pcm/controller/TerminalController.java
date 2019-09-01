package cn.sunline.pcm.controller;

import java.util.ArrayList;
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

import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.Terminal;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 终端类型维护 Controller 层
 * </p>
 * 
 * @version 1.0 2017-11-10 修改内容:初版
 */
@Controller
@RequestMapping("terminal")
public class TerminalController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;

	/**
	 * <p>
	 * 终端类型维护 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("terminalQueryPage.in")
	public ModelAndView terminalQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("terminal/terminalQuery");
			view.addObject("terminal", new Terminal());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.terminalQueryPageFail", "加载终端类型维护列表页面失败");
		}
	}

	/**
	 * <p>
	 * 查询终端类型维护列表
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "queryTerminalList.in", method = {RequestMethod.POST})
	public FetchResponse<?> queryTerminalList(FetchRequest request) throws FlatException {
		try {
			return parameterSurface.getFetchResponse(request, Terminal.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.queryTerminalListFail", "查询终端类型维护列表失败");
		}
	}

	/**
	 * <p>
	 * 加载新增终端类型维护页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("terminalAddPage.in")
	public ModelAndView terminalAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("terminal/terminalAdd");
			view.addObject("terminal", new Terminal());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.terminalAddPageFail", "加载新增终端类型维护页面异常");
		}
	}

	/**
	 * <p>
	 * 新增终端类型维护
	 * </p>
	 * 
	 * @param terminal
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addTerminal.in", method = {RequestMethod.POST})
	public void addTerminal(Terminal terminal) throws FlatException {
		try {
			parameterSurface.addNewParameter(terminal.getTerminalId(), terminal);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.addTerminalFail", "新增终端类型维护失败");
		}
	}

	/**
	 * <p>
	 * 加载修改终端类型维护页面
	 * </p>
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("terminalEditPage.in")
	public ModelAndView terminalEditPage(String terminalId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("terminal/terminalEdit");
			Terminal terminal = parameterSurface.getParameterObject(terminalId, Terminal.class);
			view.addObject("terminal", terminal);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.terminalEditPageFail", "加载修改终端类型维护页面失败");
		}
	}

	/**
	 * <p>
	 * 修改终端类型维护
	 * </p>
	 * 
	 * @param terminal
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updTerminal.in", method = {RequestMethod.POST})
	public void updTerminal(Terminal terminal) throws FlatException {
		try {
			parameterSurface.updateParameterObject(terminal.getTerminalId(), terminal);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), terminal.getTerminalId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.updTerminalFail", "修改终端类型维护失败");
		}
	}

	/**
	 * <p>
	 * 删除终端类型维护
	 * </p>
	 * 
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delTerminal.in", method = {RequestMethod.POST})
	public void delTerminals(@RequestBody List<String> branchIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(branchIds, Terminal.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.delTerminalFail", "删除终端类型维护失败");
		}
	}

	/**
	 * <p>
	 * 加载终端类型维护明细页面
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("terminalDetailPage.in")
	public ModelAndView terminalDetailPage(String terminalId) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("terminal/terminalDetail");
			Terminal terminal = parameterSurface.getParameterObject(terminalId, Terminal.class);
			view.addObject("terminal", terminal);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "terminal.terminalDetailPageFail", "加载终端类型维护详情页面失败");
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
        	   		Map<String,String> resMap = new java.util.HashMap<>();
                    parameterSurface.getParameterObject(Terminal.class).forEach(
                                    item->resMap.put(item.getTerminalId(),item.getTerminalDesc()));
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
	   Terminal parameterObject = parameterSurface.getParameterObject(code,Terminal.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getTerminalId());
                   list.add(parameterObject.getTerminalDesc());
                   return list;
   }
	

}