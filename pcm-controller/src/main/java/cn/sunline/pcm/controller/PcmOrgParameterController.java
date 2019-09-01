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
import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;

/** 
 * <p>
 * 机构参数 Controller 层
 * </p>
 * @version 1.0 2019-07-10 修改内容:初版
 */ 
@Controller
@RequestMapping("pcmOrgParameter")
public class PcmOrgParameterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 机构参数 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmOrgParameterQueryPage.in")
	public ModelAndView pcmOrgParameterQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("pcmOrgParameter/pcmOrgParameterQuery");
			view.addObject("pcmOrgParameter", new PcmOrgParameter());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmOrgParameter.pcmOrgParameterQueryPageFail","加载机构参数列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询机构参数列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPcmOrgParameterList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPcmOrgParameterList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PcmOrgParameter.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmOrgParameter.queryPcmOrgParameterListFail","查询机构参数列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增机构参数页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmOrgParameterAddPage.in")
	public ModelAndView pcmOrgParameterAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmOrgParameter/pcmOrgParameterAdd");
			view.addObject("pcmOrgParameter", new PcmOrgParameter());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmOrgParameter.pcmOrgParameterAddPageFail","加载新增机构参数页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增机构参数
	 * </p>
	 * @param pcmOrgParameter
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPcmOrgParameter.in", method = { RequestMethod.POST })
	public void addPcmOrgParameter(PcmOrgParameter pcmOrgParameter) throws FlatException {
		try {
			parameterSurface.addNewParameter(pcmOrgParameter.getOrgCode(), pcmOrgParameter);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmOrgParameter.addPcmOrgParameterFail", "新增机构参数失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改机构参数页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmOrgParameterEditPage.in")
	public ModelAndView pcmOrgParameterEditPage(String orgCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmOrgParameter/pcmOrgParameterEdit");
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(orgCode, PcmOrgParameter.class);
			view.addObject("pcmOrgParameter", pcmOrgParameter);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmOrgParameter.pcmOrgParameterEditPageFail","加载修改机构参数页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改机构参数
	 * </p>
	 * @param pcmOrgParameter
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPcmOrgParameter.in", method = { RequestMethod.POST })
	public void updPcmOrgParameter(PcmOrgParameter pcmOrgParameter) throws FlatException {
		try {
			parameterSurface.updateParameterObject(pcmOrgParameter.getOrgCode(), pcmOrgParameter);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), pcmOrgParameter.getOrgCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmOrgParameter.updPcmOrgParameterFail", "修改机构参数失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除机构参数
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPcmOrgParameter.in", method = { RequestMethod.POST })
	public void delPcmOrgParameters(@RequestBody List<String> orgCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(orgCodes, PcmOrgParameter.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmOrgParameter.delPcmOrgParameterFail", "删除机构参数失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载机构参数明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmOrgParameterDetailPage.in")
	public ModelAndView pcmOrgParameterDetailPage(String orgCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("pcmOrgParameter/pcmOrgParameterDetail");
			view.addObject("factory",code == null);
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(
						code==null? orgCode:code, PcmOrgParameter.class);
			view.addObject("pcmOrgParameter", pcmOrgParameter);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmOrgParameter.pcmOrgParameterDetailPageFail", "加载机构参数详情页面失败");
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
                    parameterSurface.getParameterObject(PcmOrgParameter.class).forEach(
                                    item->resMap.put(item.getOrgCode(),item.getOrgName()));
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
	   PcmOrgParameter parameterObject = parameterSurface.getParameterObject(code,PcmOrgParameter.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getOrgCode());
                   list.add(parameterObject.getOrgName());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(parameterObject.getParentOrgCode());
                   return list;
   }
}