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
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.BasicInfoOfPremium;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 保费基本信息 Controller 层
 * </p>
 * @version 1.0 2019-07-15 修改内容:初版
 */ 
@Controller
@RequestMapping("basicInfoOfPremium")
public class BasicInfoOfPremiumController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 保费基本信息 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("basicInfoOfPremiumQueryPage.in")
	public ModelAndView basicInfoOfPremiumQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("basicInfoOfPremium/basicInfoOfPremiumQuery");
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
			view.addObject("feePayMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeePayMethod.class));
			view.addObject("basicInfoOfPremium", new BasicInfoOfPremium());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"basicInfoOfPremium.basicInfoOfPremiumQueryPageFail","加载保费基本信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询保费基本信息列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryBasicInfoOfPremiumList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryBasicInfoOfPremiumList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, BasicInfoOfPremium.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"basicInfoOfPremium.queryBasicInfoOfPremiumListFail","查询保费基本信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增保费基本信息页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("basicInfoOfPremiumAddPage.in")
	public ModelAndView basicInfoOfPremiumAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("basicInfoOfPremium/basicInfoOfPremiumAdd");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));				
			view.addObject("feePayMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeePayMethod.class));
			view.addObject("basicInfoOfPremium", new BasicInfoOfPremium());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"basicInfoOfPremium.basicInfoOfPremiumAddPageFail","加载新增保费基本信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增保费基本信息
	 * </p>
	 * @param basicInfoOfPremium
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addBasicInfoOfPremium.in", method = { RequestMethod.POST })
	public void addBasicInfoOfPremium(BasicInfoOfPremium basicInfoOfPremium) throws FlatException {
		try {
			parameterSurface.addNewParameter(basicInfoOfPremium.getCode(),basicInfoOfPremium);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "basicInfoOfPremium.addBasicInfoOfPremiumFail", "新增保费基本信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改保费基本信息页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("basicInfoOfPremiumEditPage.in")
	public ModelAndView basicInfoOfPremiumEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("basicInfoOfPremium/basicInfoOfPremiumEdit");
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));				
			view.addObject("feePayMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeePayMethod.class));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
			BasicInfoOfPremium basicInfoOfPremium = parameterSurface.getParameterObject(code,BasicInfoOfPremium.class);
			view.addObject("basicInfoOfPremium", basicInfoOfPremium);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"basicInfoOfPremium.basicInfoOfPremiumEditPageFail","加载修改保费基本信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改保费基本信息
	 * </p>
	 * @param basicInfoOfPremium
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updBasicInfoOfPremium.in", method = { RequestMethod.POST })
	public void updBasicInfoOfPremium(BasicInfoOfPremium bBasicInfoOfPremium) throws FlatException {
		try {
			parameterSurface.updateParameterObject(bBasicInfoOfPremium.getCode(),bBasicInfoOfPremium);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bBasicInfoOfPremium.getCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "basicInfoOfPremium.updBasicInfoOfPremiumFail", "修改保费基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除保费基本信息
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delBasicInfoOfPremium.in", method = { RequestMethod.POST })
	public void delBasicInfoOfPremiums(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes,BasicInfoOfPremium.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "basicInfoOfPremium.delBasicInfoOfPremiumFail", "删除保费基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载保费基本信息明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("basicInfoOfPremiumDetailPage.in")
	public ModelAndView basicInfoOfPremiumDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("basicInfoOfPremium/basicInfoOfPremiumDetail");
			 view.addObject("factory",dcode==null);
			 
			BasicInfoOfPremium basicInfoOfPremium = parameterSurface.getParameterObject(
					code==null?dcode:code, BasicInfoOfPremium.class);
			view.addObject("basicInfoOfPremium", basicInfoOfPremium);
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(basicInfoOfPremium.getFeeCollectionMethod()));
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(basicInfoOfPremium.getFrequencyOfCharge()));
			view.addObject("feePayMethod", KC.Enum.getI18nLabel(basicInfoOfPremium.getFeePayMethod()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "basicInfoOfPremium.basicInfoOfPremiumDetailPageFail", "加载保费基本信息详情页面失败");
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
                    parameterSurface.getParameterObject(BasicInfoOfPremium.class).forEach(
                                    item->resMap.put(item.getCode(),item.getDesc()));
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
	   BasicInfoOfPremium parameterObject = parameterSurface.getParameterObject(code,BasicInfoOfPremium.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCode());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeCollectionMethod()));
                   return list;
   }
	
	
	
	
	
	
	
	
	
	
	
}