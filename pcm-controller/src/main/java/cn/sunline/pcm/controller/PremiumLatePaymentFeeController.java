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
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;

/** 
 * <p>
 * 保费滞纳金
 Controller 层
 * </p>
 * @version 1.0 2019-07-15 修改内容:初版
 */ 
@Controller
@RequestMapping("premiumLatePaymentFee")
public class PremiumLatePaymentFeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 保费滞纳金列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLatePaymentFeeQueryPage.in")
	public ModelAndView premiumLatePaymentFeeQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLatePaymentFee/premiumLatePaymentFeeQuery");
			view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeFrequency.class));
			view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionType.class));
			view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeBasis.class));
			view.addObject("premiumLatePaymentFee", new PremiumLatePaymentFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLatePaymentFee.premiumLatePaymentFeeQueryPageFail","加载保费滞纳金列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询保费滞纳金列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPremiumLatePaymentFeeList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPremiumLatePaymentFeeList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PremiumLatePaymentFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLatePaymentFee.queryPremiumLatePaymentFeeListFail","查询保费滞纳金列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增保费滞纳金页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLatePaymentFeeAddPage.in")
	public ModelAndView premiumLatePaymentFeeAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLatePaymentFee/premiumLatePaymentFeeAdd");
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeFrequency.class));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionType.class));
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			view.addObject("premiumLatePaymentFee", new PremiumLatePaymentFee());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLatePaymentFee.premiumLatePaymentFeeAddPageFail","加载新增保费滞纳金页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增保费滞纳金

	 * </p>
	 * @param premiumLatePaymentFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPremiumLatePaymentFee.in", method = { RequestMethod.POST })
	public void addPremiumLatePaymentFee(PremiumLatePaymentFee premiumLatePaymentFee) throws FlatException {
		try {
			parameterSurface.addNewParameter(premiumLatePaymentFee.getCode(), premiumLatePaymentFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLatePaymentFee.addPremiumLatePaymentFeeFail", "新增保费滞纳金失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改保费滞纳金
页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLatePaymentFeeEditPage.in")
	public ModelAndView premiumLatePaymentFeeEditPage(String code, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("premiumLatePaymentFee/premiumLatePaymentFeeEdit");
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeFrequency.class));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionType.class));
			view.addObject("feeBasis", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeBasis.class));				
			PremiumLatePaymentFee premiumLatePaymentFee = parameterSurface.getParameterObject(code, PremiumLatePaymentFee.class);
			view.addObject("premiumLatePaymentFee", premiumLatePaymentFee);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"premiumLatePaymentFee.premiumLatePaymentFeeEditPageFail","加载修改保费滞纳金页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改保费滞纳金

	 * </p>
	 * @param premiumLatePaymentFee
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPremiumLatePaymentFee.in", method = { RequestMethod.POST })
	public void updPremiumLatePaymentFee(PremiumLatePaymentFee premiumLatePaymentFee) throws FlatException {
		try {
			parameterSurface.updateParameterObject(premiumLatePaymentFee.getCode(), premiumLatePaymentFee);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), premiumLatePaymentFee.getCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLatePaymentFee.updPremiumLatePaymentFeeFail", "修改保费滞纳金失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除保费滞纳金

	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPremiumLatePaymentFee.in", method = { RequestMethod.POST })
	public void delPremiumLatePaymentFees(@RequestBody List<String> codes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(codes, PremiumLatePaymentFee.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLatePaymentFee.delPremiumLatePaymentFeeFail", "删除保费滞纳金失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载保费滞纳金
明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("premiumLatePaymentFeeDetailPage.in")
	public ModelAndView premiumLatePaymentFeeDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("premiumLatePaymentFee/premiumLatePaymentFeeDetail");
			 view.addObject("factory",dcode==null); 
			PremiumLatePaymentFee premiumLatePaymentFee = parameterSurface.getParameterObject(
					dcode==null?code:dcode, PremiumLatePaymentFee.class);
			view.addObject("premiumLatePaymentFee", premiumLatePaymentFee);
			view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(premiumLatePaymentFee.getFrequencyOfCharge()));
			view.addObject("feeCollectionMethod", KC.Enum.getI18nLabel(premiumLatePaymentFee.getFeeCollectionMethod()));
			view.addObject("feeBasis", KC.Enum.getI18nLabel(premiumLatePaymentFee.getFeeBasis()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "premiumLatePaymentFee.premiumLatePaymentFeeDetailPageFail", "加载保费滞纳金详情页面失败");
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
                    parameterSurface.getParameterObject(PremiumLatePaymentFee.class).forEach(
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
	   PremiumLatePaymentFee parameterObject = parameterSurface.getParameterObject(code,PremiumLatePaymentFee.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getCode());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFeeBasis()));
                   return list;
   }

	
}