package cn.sunline.pcm.controller;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import scala.annotation.meta.param;
import cn.sunline.pcm.infrastructure.model.bo.BPcmParameterOrder;
import cn.sunline.pcm.infrastructure.shared.model.PcmParameterOrder;
import cn.sunline.pcm.service.ProductUnitService;
import cn.sunline.pcm.surface.PcmParameterOrderSurface;

/** 
 * <p>
 * 参数展示字段自定义排序 Controller 层
 * </p>
 * @version 1.0 2019-09-17 修改内容:初版
 */ 
@Controller
@RequestMapping("pcmParameterOrder")
public class PcmParameterOrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private ProductUnitService productUnitService;
	
	@Autowired
	private PcmParameterOrderSurface pcmParameterOrderSurface;
	

	/** 
	 * <p>
	 * 参数展示字段自定义排序 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmParameterOrderQueryPage.in")
	public ModelAndView pcmParameterOrderQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("pcmParameterOrder/pcmParameterOrderQuery");
			view.addObject("pcmParameterOrder", new BPcmParameterOrder());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmParameterOrder.pcmParameterOrderQueryPageFail","加载参数展示字段自定义排序列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询参数展示字段自定义排序列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPcmParameterOrderList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPcmParameterOrderList(FetchRequest request) throws FlatException{
		try {
			return pcmParameterOrderSurface.queryPcmParameterOrderList(request);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmParameterOrder.queryPcmParameterOrderListFail","查询参数展示字段自定义排序列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增参数展示字段自定义排序页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmParameterOrderAddPage.in")
	public ModelAndView pcmParameterOrderAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmParameterOrder/pcmParameterOrderAdd");
			view.addObject("units",productUnitService.getProductUnitsMap().entrySet()
					.stream().collect(Collectors.toMap(entity->entity.getValue().getUnitClass(), entity->entity.getValue().getUnitNameCn())));
			
			view.addObject("pcmParameterOrder", new BPcmParameterOrder());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmParameterOrder.pcmParameterOrderAddPageFail","加载新增参数展示字段自定义排序页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增参数展示字段自定义排序
	 * </p>
	 * @param pcmParameterOrder
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPcmParameterOrder.in", method = { RequestMethod.POST })
	public void addPcmParameterOrder(@RequestBody List<BPcmParameterOrder> pcmParameterOrders) throws FlatException {
		try {
			Integer counter  = 0 ; 
			for (BPcmParameterOrder bPcmParameterOrder : pcmParameterOrders) {
				bPcmParameterOrder.setOrderIndex(counter.toString());
				bPcmParameterOrder.setOrgCode(KC.threadLocal.getCurrentOrg());
				pcmParameterOrderSurface.addPcmParameterOrder(bPcmParameterOrder);
				counter++;
			}
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmParameterOrder.addPcmParameterOrderFail", "新增参数展示字段自定义排序失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改参数展示字段自定义排序页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmParameterOrderEditPage.in")
	public ModelAndView pcmParameterOrderEditPage(String paramClass, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmParameterOrder/pcmParameterOrderEdit");
			view.addObject("units",productUnitService.getProductUnitsMap().entrySet()
					.stream().collect(Collectors.toMap(entity->entity.getValue().getUnitClass(), entity->entity.getValue().getUnitNameCn())));
			  List<BPcmParameterOrder> map = pcmParameterOrderSurface.findPcmParameterOrderByParamClass(paramClass);
			  Map<Object, Object> fileds = fetchFileds( map.get(0).getParamClass());
			  view.addObject("fileds",fileds);
			  view.addObject("pcmParameterOrdersJson",KC.json.serializerNoType(map));
			view.addObject("pcmParameterOrders", map);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"pcmParameterOrder.pcmParameterOrderEditPageFail","加载修改参数展示字段自定义排序页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改参数展示字段自定义排序
	 * </p>
	 * @param pcmParameterOrder
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPcmParameterOrder.in", method = { RequestMethod.POST })
	public void updPcmParameterOrder(@RequestBody List<BPcmParameterOrder> bPcmParameterOrder) throws FlatException {
		try {
			pcmParameterOrderSurface.updPcmParameterOrders(bPcmParameterOrder);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmParameterOrder.addPcmParameterOrderFail", "新增参数展示字段自定义排序失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除参数展示字段自定义排序
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPcmParameterOrder.in", method = { RequestMethod.POST })
	public void delPcmParameterOrders(@RequestBody List<String> ids) throws FlatException {
		try {
			pcmParameterOrderSurface.delPcmParameterOrderByParamClasses(ids);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmParameterOrder.delPcmParameterOrderFail", "删除参数展示字段自定义排序失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载参数展示字段自定义排序明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("pcmParameterOrderDetailPage.in")
	public ModelAndView pcmParameterOrderDetailPage(String paramClass) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("pcmParameterOrder/pcmParameterOrderDetail");
			view.addObject("units",productUnitService.getProductUnitsMap().entrySet()
					.stream().collect(Collectors.toMap(entity->entity.getValue().getUnitClass(), entity->entity.getValue().getUnitNameCn())));
			  List<BPcmParameterOrder> map = pcmParameterOrderSurface.findPcmParameterOrderByParamClass(paramClass);
			  Map<Object, Object> fileds = fetchFileds( map.get(0).getParamClass());
			  view.addObject("fileds",fileds);
			  view.addObject("pcmParameterOrdersJson",KC.json.serializerNoType(map));
			view.addObject("pcmParameterOrders", map);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmParameterOrder.pcmParameterOrderDetailPageFail", "加载参数展示字段自定义排序详情页面失败");
		}
	}
	
	
	
	/**
	 * 获取某一个参数下的所有字段
	 */
	@ResponseBody
	@RequestMapping("/getFileds.in")
	public Map<Object, Object> getFileds(String paramClass) {
		try {
			return fetchFileds(paramClass);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "pcmParameterOrder.pcmParameterOrderDetailPageFail", "加载参数展示字段自定义排序详情页面失败");
		}
	}
	
	
	
	private Map<Object, Object> fetchFileds(String paramClass) throws Exception{
		Class<?> paramClazz = Class.forName(paramClass);
		 List<Field> fields = Arrays.asList(paramClazz.getFields());
		 return  fields.parallelStream().collect(
				 	Collectors.toMap(
						 k->k.getName(),
						 v->v.getDeclaredAnnotation(cn.sunline.common.annotation.paramdef.PropertyInfo.class).name()
						 ));
	}
	
	
	
}