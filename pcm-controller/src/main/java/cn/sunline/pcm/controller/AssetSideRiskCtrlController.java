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
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.Mcc;
import cn.sunline.pcm.definition.enums.MarginBase;
import cn.sunline.pcm.definition.enums.RiskCtrlWay;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 资产方风险管理 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-10 修改内容:初版
 */ 
@Controller
@RequestMapping("assetSideRiskCtrl")
public class AssetSideRiskCtrlController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 资产方风险管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideRiskCtrlQueryPage.in")
	public ModelAndView assetSideRiskCtrlQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideRiskCtrl/assetSideRiskCtrlQuery");
			view.addObject("assetSideRiskCtrl", new AssetSideRiskCtrl());
			view.addObject("riskCtrlWaysJson",KC.Enum.getI18nLabelMapJson(RiskCtrlWay.class));
			view.addObject("marginBaseJson",KC.Enum.getI18nLabelMapJson(MarginBase.class));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideRiskCtrl.assetSideRiskCtrlQueryPageFail","加载资产方风险管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资产方风险管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryAssetSideRiskCtrlList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryAssetSideRiskCtrlList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, AssetSideRiskCtrl.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideRiskCtrl.queryAssetSideRiskCtrlListFail","查询资产方风险管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资产方风险管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideRiskCtrlAddPage.in")
	public ModelAndView assetSideRiskCtrlAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideRiskCtrl/assetSideRiskCtrlAdd");
			view.addObject("riskCtrlWays", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.RiskCtrlWay.class));				
			view.addObject("marginBase", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.MarginBase.class));				
			view.addObject("assetSideRiskCtrl", new AssetSideRiskCtrl());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideRiskCtrl.assetSideRiskCtrlAddPageFail","加载新增资产方风险管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资产方风险管理
	 * </p>
	 * @param assetSideRiskCtrl
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addAssetSideRiskCtrl.in", method = { RequestMethod.POST })
	public void addAssetSideRiskCtrl(AssetSideRiskCtrl assetSideRiskCtrl) throws FlatException {
		try {
			parameterSurface.addNewParameter(assetSideRiskCtrl.getaId(), assetSideRiskCtrl);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideRiskCtrl.addAssetSideRiskCtrlFail", "新增资产方风险管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资产方风险管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideRiskCtrlEditPage.in")
	public ModelAndView assetSideRiskCtrlEditPage(String aId, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideRiskCtrl/assetSideRiskCtrlEdit");
			view.addObject("riskCtrlWays", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.RiskCtrlWay.class));				
			view.addObject("marginBase", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.MarginBase.class));				
			AssetSideRiskCtrl assetSideRiskCtrl = parameterSurface.getParameterObject(aId, AssetSideRiskCtrl.class);
			view.addObject("assetSideRiskCtrl", assetSideRiskCtrl);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideRiskCtrl.assetSideRiskCtrlEditPageFail","加载修改资产方风险管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资产方风险管理
	 * </p>
	 * @param assetSideRiskCtrl
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updAssetSideRiskCtrl.in", method = { RequestMethod.POST })
	public void updAssetSideRiskCtrl(AssetSideRiskCtrl assetSideRiskCtrl) throws FlatException {
		try {
			parameterSurface.updateParameterObject(assetSideRiskCtrl.getaId(), assetSideRiskCtrl);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), assetSideRiskCtrl.getaId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideRiskCtrl.updAssetSideRiskCtrlFail", "修改资产方风险管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资产方风险管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delAssetSideRiskCtrl.in", method = { RequestMethod.POST })
	public void delAssetSideRiskCtrls(@RequestBody List<String> aIds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(aIds, AssetSideRiskCtrl.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideRiskCtrl.delAssetSideRiskCtrlFail", "删除资产方风险管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资产方风险管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideRiskCtrlDetailPage.in")
	public ModelAndView assetSideRiskCtrlDetailPage(String aId,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("assetSideRiskCtrl/assetSideRiskCtrlDetail");
			 view.addObject("factory",!(code == null));
			AssetSideRiskCtrl assetSideRiskCtrl = parameterSurface.getParameterObject(code ==null ? aId : code, AssetSideRiskCtrl.class);
			view.addObject("assetSideRiskCtrl", assetSideRiskCtrl);
			
			List<RiskCtrlWay> riskCtrlWays = assetSideRiskCtrl.getRiskCtrlWays();
			List<String> i18RiskCtrlWays = new ArrayList<>(); 
			riskCtrlWays.forEach(val->{
				String i18nLabel = KC.Enum.getI18nLabel(val);
				i18RiskCtrlWays.add(i18nLabel);
			});
			view.addObject("riskCtrlWays",i18RiskCtrlWays);
			view.addObject("marginBase", KC.Enum.getI18nLabel(assetSideRiskCtrl.getMarginBase()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideRiskCtrl.assetSideRiskCtrlDetailPageFail", "加载资产方风险管理详情页面失败");
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
                    parameterSurface.getParameterObject(AssetSideRiskCtrl.class).forEach(
                                    item->resMap.put(item.getaId(),item.getDesc()));
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
	   AssetSideRiskCtrl parameterObject = parameterSurface.getParameterObject(code,AssetSideRiskCtrl.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getaId());
                   list.add(parameterObject.getDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getMarginBase()));
                   return list;
   }

	
	
}