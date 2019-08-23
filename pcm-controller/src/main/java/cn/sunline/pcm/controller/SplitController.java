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

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.Split;
import cn.sunline.pcm.definition.enums.SplitMethod;
import cn.sunline.pcm.definition.enums.SplitSort;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 扣款拆分 Controller 层
 * </p>
 * @version 1.0 2017-11-10 gaoguihua 修改内容:初版
 */ 
@Controller
@RequestMapping("split")
public class SplitController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 扣款拆分 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("splitQueryPage.in")
	public ModelAndView splitQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("split/splitQuery");
			view.addObject("splitMethodJson", KC.Enum.getI18nLabelMapJson(SplitMethod.class));
			view.addObject("splitMethod", KC.Enum.getI18nLabelMap(SplitMethod.class));				
			view.addObject("splitAmtSortJson", KC.Enum.getI18nLabelMapJson(SplitSort.class));
			view.addObject("split", new Split());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"split.splitQueryPageFail","加载扣款拆分列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询扣款拆分列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="querySplitList.in", method = { RequestMethod.POST })
	public FetchResponse<?> querySplitList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, Split.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"split.querySplitListFail","查询扣款拆分列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增扣款拆分页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("splitAddPage.in")
	public ModelAndView splitAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("split/splitAdd");
			view.addObject("splitMethod", KC.Enum.getI18nLabelMap(SplitMethod.class));				
			view.addObject("splitAmtSort", KC.Enum.getI18nLabelMap(SplitSort.class));				
			view.addObject("split", new Split());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"split.splitAddPageFail","加载新增扣款拆分页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增扣款拆分
	 * </p>
	 * @param split
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addSplit.in", method = { RequestMethod.POST })
	public void addSplit(Split split) throws FlatException {
		try {
			parameterSurface.addNewParameter(split.getSplitTableId(), split);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "split.addSplitFail", "新增扣款拆分失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改扣款拆分页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("splitEditPage.in")
	public ModelAndView splitEditPage(String splitTableId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("split/splitEdit");
			view.addObject("splitMethod", KC.Enum.getI18nLabelMap(SplitMethod.class));				
			view.addObject("splitAmtSort", KC.Enum.getI18nLabelMap(SplitSort.class));				
			Split split = parameterSurface.getParameterObject(splitTableId, Split.class);
			view.addObject("split", split);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"split.splitEditPageFail","加载修改扣款拆分页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改扣款拆分
	 * </p>
	 * @param split
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updSplit.in", method = { RequestMethod.POST })
	public void updSplit(Split split) throws FlatException {
		try {
			parameterSurface.updateParameterObject(split.getSplitTableId(), split);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), split.getSplitTableId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "split.updSplitFail", "修改扣款拆分失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除扣款拆分
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delSplit.in", method = { RequestMethod.POST })
	public void delSplits(@RequestBody List<String> splitTableIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(splitTableIds, Split.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "split.delSplitFail", "删除扣款拆分失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载扣款拆分明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("splitDetailPage.in")
	public ModelAndView splitDetailPage(String splitTableId,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("split/splitDetail");
			view.addObject("factory", splitTableId == null);
			Split split = parameterSurface.getParameterObject(splitTableId==null?code:splitTableId, Split.class);
			view.addObject("split", split);
			view.addObject("splitMethod", KC.Enum.getI18nLabel(split.getSplitMethod()));
			view.addObject("splitAmtSort", KC.Enum.getI18nLabel(split.getSplitAmtSort()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "split.splitDetailPageFail", "加载扣款拆分详情页面失败");
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
                    parameterSurface.getParameterObject(Split.class).forEach(
                                    item->resMap.put(item.getSplitTableId(),item.getSplitName()));
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
	   Split parameterObject = parameterSurface.getParameterObject(code,Split.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getSplitTableId());
                   list.add(parameterObject.getSplitName());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getSplitMethod()));
                   return list;
   }
	
}