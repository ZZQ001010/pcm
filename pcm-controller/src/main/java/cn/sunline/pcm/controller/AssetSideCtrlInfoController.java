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
import cn.sunline.pcm.controller.common.constent.ParameterFlags;
import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.Premium;

/** 
 * <p>
 * 资产方管控信息 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-10 修改内容:初版
 */ 
@Controller
@RequestMapping("assetSideCtrlInfo")
public class AssetSideCtrlInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	/** 
	 * <p>
	 * 资产方管控信息 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideCtrlInfoQueryPage.in")
	public ModelAndView assetSideCtrlInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideCtrlInfo/assetSideCtrlInfoQuery");
			view.addObject("assetSideLoanCtrlJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.AssetSideLoanCtrl.class));
			view.addObject("assetSideCtrlInfo", new AssetSideCtrlInfo());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideCtrlInfo.assetSideCtrlInfoQueryPageFail","加载资产方管控信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资产方管控信息列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryAssetSideCtrlInfoList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryAssetSideCtrlInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, AssetSideCtrlInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideCtrlInfo.queryAssetSideCtrlInfoListFail","查询资产方管控信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资产方管控信息页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideCtrlInfoAddPage.in")
	public ModelAndView assetSideCtrlInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideCtrlInfo/assetSideCtrlInfoAdd");
			view.addObject("assetSideLoanCtrl", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideLoanCtrl.class));	
			//资产方
            HashMap<String, String> assetMap = new HashMap<>();
            parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                            item->assetMap.put(item.getAssetSideCode(),item.getAssetSideCode()+ParameterFlags.SHORT_CROSS+item.getAssetSideDesc()));
            view.addObject("assetFundSideCode", assetMap);
			view.addObject("assetSideCtrlInfo", new AssetSideCtrlInfo());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideCtrlInfo.assetSideCtrlInfoAddPageFail","加载新增资产方管控信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资产方管控信息
	 * </p>
	 * @param assetSideCtrlInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addAssetSideCtrlInfo.in", method = { RequestMethod.POST })
	public void addAssetSideCtrlInfo(AssetSideCtrlInfo assetSideCtrlInfo) throws FlatException {
		try {
			parameterSurface.addNewParameter(assetSideCtrlInfo.getAssetSideCtrlCode(), assetSideCtrlInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideCtrlInfo.addAssetSideCtrlInfoFail", "新增资产方管控信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资产方管控信息页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideCtrlInfoEditPage.in")
	public ModelAndView assetSideCtrlInfoEditPage(String assetSideCtrlCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideCtrlInfo/assetSideCtrlInfoEdit");
			view.addObject("assetSideLoanCtrl", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideLoanCtrl.class));				
			AssetSideCtrlInfo assetSideCtrlInfo = parameterSurface.getParameterObject(assetSideCtrlCode, AssetSideCtrlInfo.class);
			//资产方
            HashMap<String, String> assetMap = new HashMap<>();
            parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                    item->assetMap.put(item.getAssetSideCode(),item.getAssetSideCode()+ParameterFlags.SHORT_CROSS+item.getAssetSideDesc()));
            view.addObject("assetFundSideCode", assetMap);
			view.addObject("assetSideCtrlInfo", assetSideCtrlInfo);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideCtrlInfo.assetSideCtrlInfoEditPageFail","加载修改资产方管控信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资产方管控信息
	 * </p>
	 * @param assetSideCtrlInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updAssetSideCtrlInfo.in", method = { RequestMethod.POST })
	public void updAssetSideCtrlInfo(AssetSideCtrlInfo assetSideCtrlInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(assetSideCtrlInfo.getAssetSideCtrlCode(), assetSideCtrlInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), assetSideCtrlInfo.getAssetSideCtrlCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideCtrlInfo.updAssetSideCtrlInfoFail", "修改资产方管控信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资产方管控信息
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delAssetSideCtrlInfo.in", method = { RequestMethod.POST })
	public void delAssetSideCtrlInfos(@RequestBody List<String> assetSideCtrlCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(assetSideCtrlCodes, AssetSideCtrlInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideCtrlInfo.delAssetSideCtrlInfoFail", "删除资产方管控信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资产方管控信息明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideCtrlInfoDetailPage.in")
	public ModelAndView assetSideCtrlInfoDetailPage(String assetSideCtrlCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("assetSideCtrlInfo/assetSideCtrlInfoDetail");
			 view.addObject("factory",code == null);
			AssetSideCtrlInfo assetSideCtrlInfo = parameterSurface.getParameterObject(
						code==null? assetSideCtrlCode:code, AssetSideCtrlInfo.class);
			
			view.addObject("assetSideCtrlInfo", assetSideCtrlInfo);
			view.addObject("assetSideLoanCtrl", KC.Enum.getI18nLabel(assetSideCtrlInfo.getAssetSideLoanCtrl()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideCtrlInfo.assetSideCtrlInfoDetailPageFail", "加载资产方管控信息详情页面失败");
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
                    parameterSurface.getParameterObject(AssetSideCtrlInfo.class).forEach(
                                    item->resMap.put(item.getAssetSideCtrlCode(),item.getAssetSideCtrlDesc()));
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
	   AssetSideCtrlInfo parameterObject = parameterSurface.getParameterObject(code,AssetSideCtrlInfo.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getAssetSideCtrlCode());
                   list.add(parameterObject.getAssetSideCtrlDesc());
                   //TODO 此处需要从另一个模块参数配置中读取
                   list.add(parameterObject.getAssetSideCode());
                   return list;
   }

	
}