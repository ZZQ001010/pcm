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

import com.fasterxml.jackson.core.type.TypeReference;

import cn.sunline.common.KC;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.vo.VMulct;
import cn.sunline.pcm.definition.Mulct;
import cn.sunline.pcm.definition.MulctDef;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.definition.enums.MulctCollectMethod;
import cn.sunline.pcm.definition.enums.MulctMethod;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 罚金利率 Controller 层
 * </p>
 * @version 1.0 2017-11-10 gaoguihua 修改内容:初版
 */ 
@Controller
@RequestMapping("mulct")
public class MulctController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 罚金利率 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mulctQueryPage.in")
	public ModelAndView mulctQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("mulct/mulctQuery");
			view.addObject("mulctMethodJson", KC.Enum.getI18nLabelMapJson(MulctMethod.class));
			view.addObject("mulctCalMethodJson", KC.Enum.getI18nLabelMapJson(MulctCollectMethod.class));
			view.addObject("isReviewMulctJson", KC.Enum.getI18nLabelMapJson(Indicator.class));
			view.addObject("mulct", new Mulct());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mulct.mulctQueryPageFail","加载罚金利率列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询罚金利率列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryMulctList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryMulctList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, Mulct.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mulct.queryMulctListFail","查询罚金利率列表失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载新增罚金利率页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mulctAddPage.in")
	public ModelAndView mulctAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("mulct/mulctAdd");
			view.addObject("mulctMethod", KC.Enum.getI18nLabelMap(MulctMethod.class));				
			view.addObject("mulctCalMethod", KC.Enum.getI18nLabelMap(MulctCollectMethod.class));				
			view.addObject("isReviewMulct", KC.Enum.getI18nLabelMap(Indicator.class));				
			view.addObject("mulct", new Mulct());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mulct.mulctAddPageFail","加载新增罚金利率页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增罚金利率表
	 * </p>
	 * @param mulct
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addMulct.in", method = { RequestMethod.POST })
	public void addMulct(@RequestBody VMulct vMulct) throws FlatException {
		try {
			Mulct mulct = new Mulct();
			KC.bean.copyProperties(vMulct, mulct);
			String mulctDefsStr = vMulct.getMulctDefsStr();
			if(mulctDefsStr != null){
				List<MulctDef> list = KC.json.reSerializerNoType(mulctDefsStr, new TypeReference<List<MulctDef>>() {});
				mulct.setMulctDefs(list);
			}			
			parameterSurface.addNewParameter(mulct.getMulctTableId(), mulct);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mulct.addMulctFail", "新增罚金利率失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改罚金利率页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mulctEditPage.in")
	public ModelAndView mulctEditPage(String mulctTableId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("mulct/mulctEdit");
			view.addObject("mulctMethod", KC.Enum.getI18nLabelMap(MulctMethod.class));				
			view.addObject("mulctCalMethod", KC.Enum.getI18nLabelMap(MulctCollectMethod.class));				
			//view.addObject("isReviewMulct", KC.Enum.getI18nLabelMap(Indicator.class));				
			Mulct mulct = parameterSurface.getParameterObject(mulctTableId, Mulct.class);
			view.addObject("isReviewMulct",mulct.getIsReviewMulct());
			List<MulctDef> list = mulct.getMulctDefs();
			if(list == null){
				view.addObject("list", KC.json.serializerNoType("[]"));
			}else{
				view.addObject("list", KC.json.serializerNoType(list));		
			}
			view.addObject("mulct", mulct);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mulct.mulctEditPageFail","加载修改罚金利率页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改罚金利率表
	 * </p>
	 * @param mulct
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updMulct.in", method = { RequestMethod.POST })
	public void updMulct(@RequestBody VMulct vMulct) throws FlatException {
		Mulct mulct = new Mulct();
		try {
			KC.bean.copyProperties(vMulct, mulct);
			String mulctDefsStr = vMulct.getMulctDefsStr();
			if(mulctDefsStr != null){
				List<MulctDef> list = KC.json.reSerializerNoType(mulctDefsStr, new TypeReference<List<MulctDef>>() {});
				mulct.setMulctDefs(list);	
			}				
			parameterSurface.updateParameterObject(mulct.getMulctTableId(), mulct);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), mulct.getMulctTableId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mulct.updMulctFail", "修改罚金利率失败");
		}
	}

	/** 
	 * <p>
	 * 删除罚金利率
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delMulct.in", method = { RequestMethod.POST })
	public void delMulcts(@RequestBody List<String> mulctTableIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(mulctTableIds, Mulct.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mulct.delMulctFail", "删除罚金利率失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载罚金利率明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mulctDetailPage.in")
	public ModelAndView mulctDetailPage(String mulctTableId,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("mulct/mulctDetail");
			view.addObject("factoey",mulctTableId==null);
			Mulct mulct = parameterSurface.getParameterObject(mulctTableId==null?code:mulctTableId, Mulct.class);
			List<MulctDef> list = mulct.getMulctDefs();
			if(list == null){
				view.addObject("list", KC.json.serializerNoType("[]"));
			}else{
				view.addObject("list", KC.json.serializerNoType(list));		
			}
			view.addObject("mulct", mulct);
			view.addObject("mulctMethod", KC.Enum.getI18nLabel(mulct.getMulctMethod()));
			view.addObject("mulctCalMethod", KC.Enum.getI18nLabel(mulct.getMulctCalMethod()));
			//view.addObject("isReviewMulct", KC.Enum.getI18nLabel(mulct.getIsReviewMulct()));
			
			view.addObject("isReviewMulct",mulct.getIsReviewMulct());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mulct.mulctDetailPageFail", "加载罚金利率详情页面失败");
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
                    parameterSurface.getParameterObject(Mulct.class).forEach(
                                    item->resMap.put(item.getMulctTableId(),item.getMulctName()));
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
	   Mulct parameterObject = parameterSurface.getParameterObject(code,Mulct.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getMulctTableId());
                   list.add(parameterObject.getMulctName());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getMulctMethod()));
                   return list;
   }

	
}