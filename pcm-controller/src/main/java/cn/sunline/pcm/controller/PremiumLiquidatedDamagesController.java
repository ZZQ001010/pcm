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
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.PremiumLiquidatedDamages;
import cn.sunline.pcm.definition.enums.AdditionalNPremiums;
import cn.sunline.pcm.definition.enums.CostCalculationMethod;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import scala.collection.mutable.HashMap;

/** 
 * <p>
 * 提前还款保费收取方式 Controller 层
 * </p>
 * @version 1.0 2019-07-15 修改内容:初版
 */ 
@Controller
@RequestMapping("premiumLiquidatedDamages")
public class PremiumLiquidatedDamagesController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 提前还款保费收取方式 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLiquidatedDamagesQueryPage.in")
	public ModelAndView premiumLiquidatedDamagesQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLiquidatedDamages/premiumLiquidatedDamagesQuery");
			view.addObject("costCalculationMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.CostCalculationMethod.class));
			view.addObject("additionalNPremiumsJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.AdditionalNPremiums.class));
			view.addObject("premiumLiquidatedDamages", new PremiumLiquidatedDamages());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLiquidatedDamages.premiumLiquidatedDamagesQueryPageFail","加载提前还款保费收取方式列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询提前还款保费收取方式列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPremiumLiquidatedDamagesList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPremiumLiquidatedDamagesList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PremiumLiquidatedDamages.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLiquidatedDamages.queryPremiumLiquidatedDamagesListFail","查询提前还款保费收取方式列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增提前还款保费收取方式页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLiquidatedDamagesAddPage.in")
	public ModelAndView premiumLiquidatedDamagesAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLiquidatedDamages/premiumLiquidatedDamagesAdd");
			view.addObject("costCalculationMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CostCalculationMethod.class));
            view.addObject("additionalNPremiums", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AdditionalNPremiums.class));
            view.addObject("premiumLiquidatedDamages", new PremiumLiquidatedDamages());
			Map<Boolean,String> map = new java.util.HashMap<>();
			map.put(true, "是");map.put(false, "否");
			view.addObject("whetherToCharge",map);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLiquidatedDamages.premiumLiquidatedDamagesAddPageFail","加载新增提前还款保费收取方式页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增提前还款保费收取方式
	 * </p>
	 * @param premiumLiquidatedDamages
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPremiumLiquidatedDamages.in", method = { RequestMethod.POST })
	public void addPremiumLiquidatedDamages(PremiumLiquidatedDamages premiumLiquidatedDamages) throws FlatException {
		try {
			parameterSurface.addNewParameter(premiumLiquidatedDamages.getCode(), premiumLiquidatedDamages);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLiquidatedDamages.addPremiumLiquidatedDamagesFail", "新增提前还款保费收取方式失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改提前还款保费收取方式页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLiquidatedDamagesEditPage.in")
	public ModelAndView premiumLiquidatedDamagesEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLiquidatedDamages/premiumLiquidatedDamagesEdit");
			view.addObject("costCalculationMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CostCalculationMethod.class));
            view.addObject("additionalNPremiums", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AdditionalNPremiums.class));
            PremiumLiquidatedDamages premiumLiquidatedDamages = parameterSurface.getParameterObject(code, PremiumLiquidatedDamages.class);
			Map<Boolean,String> map = new java.util.HashMap<>();
			map.put(true, "是");map.put(false, "否");
			view.addObject("whetherToCharge",map);
			view.addObject("premiumLiquidatedDamages", premiumLiquidatedDamages);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLiquidatedDamages.premiumLiquidatedDamagesEditPageFail","加载修改提前还款保费收取方式页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改提前还款保费收取方式
	 * </p>
	 * @param premiumLiquidatedDamages
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPremiumLiquidatedDamages.in", method = { RequestMethod.POST })
	public void updPremiumLiquidatedDamages(PremiumLiquidatedDamages premiumLiquidatedDamages) throws FlatException {
		try {
			parameterSurface.updateParameterObject(premiumLiquidatedDamages.getCode(), premiumLiquidatedDamages);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), premiumLiquidatedDamages.getCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLiquidatedDamages.updPremiumLiquidatedDamagesFail", "修改提前还款保费收取方式失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除提前还款保费收取方式
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPremiumLiquidatedDamages.in", method = { RequestMethod.POST })
	public void delPremiumLiquidatedDamagess(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes, PremiumLiquidatedDamages.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLiquidatedDamages.delPremiumLiquidatedDamagesFail", "删除提前还款保费收取方式失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载提前还款保费收取方式明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLiquidatedDamagesDetailPage.in")
	public ModelAndView premiumLiquidatedDamagesDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("premiumLiquidatedDamages/premiumLiquidatedDamagesDetail");
			 view.addObject("factory",dcode==null);
			PremiumLiquidatedDamages premiumLiquidatedDamages = parameterSurface.getParameterObject(
					code==null?dcode:code, PremiumLiquidatedDamages.class);
			AdditionalNPremiums additionalNPremiums = premiumLiquidatedDamages.getAdditionalNPremiums();
			if (additionalNPremiums!=null) {
				view.addObject("additionalNPremiums",KC.Enum.getI18nLabel(additionalNPremiums));
			}else{
				view.addObject("additionalNPremiums",null);
			}
			
			view.addObject("premiumLiquidatedDamages", premiumLiquidatedDamages);
			CostCalculationMethod costCalculationMethod = premiumLiquidatedDamages.getCostCalculationMethod();
			if (costCalculationMethod!=null) {
				view.addObject("costCalculationMethod", KC.Enum.getI18nLabel(costCalculationMethod));
			}else{
				view.addObject("costCalculationMethod", null);
			}
			if (premiumLiquidatedDamages.getWhetherToCharge()!=null) {
				view.addObject("whetherToCharge",premiumLiquidatedDamages.getWhetherToCharge()?"是":"否");
			}else{
				view.addObject("whetherToCharge",null);
			}
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLiquidatedDamages.premiumLiquidatedDamagesDetailPageFail", "加载提前还款保费收取方式详情页面失败");
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
                    parameterSurface.getParameterObject(PremiumLiquidatedDamages.class).forEach(
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
	   PremiumLiquidatedDamages parameterObject = parameterSurface.getParameterObject(code,PremiumLiquidatedDamages.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCode());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getCostCalculationMethod()));
                   return list;
   }
}