package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.vo.VElectronicTemplet;
import cn.sunline.pcm.definition.ElectronicTemplet;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.definition.enums.RequireType;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 风控电子资料模板管理 Controller 层
 * </p>
 * @version 1.0 2017-11-27 修改内容:初版
 */ 
@Controller
@RequestMapping("electronicTemplet")
public class ElectronicTempletController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 风控电子资料模板管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("electronicTempletQueryPage.in")
	public ModelAndView electronicTempletQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("electronicTemplet/electronicTempletQuery");
			view.addObject("electronicTemplet", new ElectronicTemplet());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"electronicTemplet.electronicTempletQueryPageFail","加载风控电子资料模板管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询风控电子资料模板管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryElectronicTempletList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryElectronicTempletList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, ElectronicTemplet.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"electronicTemplet.queryElectronicTempletListFail","查询风控电子资料模板管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增风控电子资料模板管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("electronicTempletAddPage.in")
	public ModelAndView electronicTempletAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("electronicTemplet/electronicTempletAdd");
			
			view.addObject("electronicTemplet", new ElectronicTemplet());
			view.addObject("requireType",KC.Enum.getI18nLabelMap(RequireType.class));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"electronicTemplet.electronicTempletAddPageFail","加载新增风控电子资料模板管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增风控电子资料模板管理
	 * </p>
	 * @param electronicTemplet
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addElectronicTemplet.in", method = { RequestMethod.POST })
	public void addElectronicTemplet(@RequestBody VElectronicTemplet vElectronicTemplet) throws FlatException {
		try {
			ElectronicTemplet electronicTemplet=new ElectronicTemplet();
			
			KC.bean.copyProperties(vElectronicTemplet, electronicTemplet);
			
			String templetListStr=vElectronicTemplet.getTempletListStr();
			Map<String, String> templetList = KC.json.reSerializerNoType(templetListStr,new TypeReference<Map<String, String>>() {});
			electronicTemplet.setTempletList(templetList);
			
			
			parameterSurface.addNewParameter(electronicTemplet.getTempletId(), electronicTemplet);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "electronicTemplet.addElectronicTempletFail", "新增风控电子资料模板管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改风控电子资料模板管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("electronicTempletEditPage.in")
	public ModelAndView electronicTempletEditPage(String templetId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("electronicTemplet/electronicTempletEdit");
			ElectronicTemplet electronicTemplet = parameterSurface.getParameterObject(templetId, ElectronicTemplet.class);
			
			Map<String, String> templetList =electronicTemplet.getTempletList();
			
			view.addObject("requireType",KC.Enum.getI18nLabelMap(RequireType.class));
			view.addObject("templetList", KC.json.serializerNoType(templetList));
			view.addObject("electronicTemplet", electronicTemplet);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"electronicTemplet.electronicTempletEditPageFail","加载修改风控电子资料模板管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改风控电子资料模板管理
	 * </p>
	 * @param electronicTemplet
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updElectronicTemplet.in", method = { RequestMethod.POST })
	public void updElectronicTemplet(@RequestBody VElectronicTemplet vElectronicTemplet) throws FlatException {
		try {
            ElectronicTemplet electronicTemplet=new ElectronicTemplet();
			
			KC.bean.copyProperties(vElectronicTemplet, electronicTemplet);
			
			String templetListStr=vElectronicTemplet.getTempletListStr();
			Map<String, String> templetList = KC.json.reSerializerNoType(templetListStr,new TypeReference<Map<String, String>>() {});
			electronicTemplet.setTempletList(templetList);
			
			parameterSurface.updateParameterObject(electronicTemplet.getTempletId(), electronicTemplet);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "electronicTemplet.updElectronicTempletFail", "修改风控电子资料模板管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除风控电子资料模板管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delElectronicTemplet.in", method = { RequestMethod.POST })
	public void delElectronicTemplets(@RequestBody List<String> templetIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(templetIds, ElectronicTemplet.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "electronicTemplet.delElectronicTempletFail", "删除风控电子资料模板管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载风控电子资料模板管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("electronicTempletDetailPage.in")
	public ModelAndView electronicTempletDetailPage(String templetId,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("electronicTemplet/electronicTempletDetail");
			view.addObject("factory",templetId==null);
			ElectronicTemplet electronicTemplet = parameterSurface.getParameterObject(templetId==null?code:templetId, ElectronicTemplet.class);
			Map<String, String> map =electronicTemplet.getTempletList();
			for (Entry<String, String>  entity : map.entrySet()) {
				view.addObject(entity.getKey(), KC.Enum.getI18nLabel(RequireType.valueOf(entity.getValue())));
			}
			
			view.addObject("electronicTemplet", electronicTemplet);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "electronicTemplet.electronicTempletDetailPageFail", "加载风控电子资料模板管理详情页面失败");
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
                    parameterSurface.getParameterObject(ElectronicTemplet.class).forEach(
                                    item->resMap.put(item.getTempletId(),item.getTempletDesc()));
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
	   ElectronicTemplet parameterObject = parameterSurface.getParameterObject(code,ElectronicTemplet.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getTempletId());
                   list.add(parameterObject.getTempletDesc());
                   return list;
   }

}