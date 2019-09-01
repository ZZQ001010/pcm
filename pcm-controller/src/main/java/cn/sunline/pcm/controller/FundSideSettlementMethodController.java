package cn.sunline.pcm.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
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
import cn.sunline.pcm.definition.FundSideCtrlInfo;
import cn.sunline.pcm.definition.FundSideSettlementMethod;
import cn.sunline.pcm.definition.enums.SettlementMethod;
import cn.sunline.pcm.definition.FundSideInfo;
/** 
 * <p>
 * 资金方理赔方式
 Controller 层
 * </p>
 * @version 1.0 2019-07-12 修改内容:初版
 */ 
@Controller
@RequestMapping("fundSideSettlementMethod")
public class FundSideSettlementMethodController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 资金方理赔方式
 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideSettlementMethodQueryPage.in")
	public ModelAndView fundSideSettlementMethodQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideSettlementMethod/fundSideSettlementMethodQuery");
			view.addObject("fundSideInfoJson", KC.Enum.getI18nLabelMapJson(SettlementMethod.class));
			view.addObject("fundSideSettlementMethod", new FundSideSettlementMethod());
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo FundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(FundSideInfo.getFundSideCode(),FundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoJson",new JSONObject(fundSideInfoMap));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideSettlementMethod.fundSideSettlementMethodQueryPageFail","加载资金方理赔方式列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资金方理赔方式
列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryFundSideSettlementMethodList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryFundSideSettlementMethodList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, FundSideSettlementMethod.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideSettlementMethod.queryFundSideSettlementMethodListFail","查询资金方理赔方式列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资金方理赔方式
页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideSettlementMethodAddPage.in")
	public ModelAndView fundSideSettlementMethodAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideSettlementMethod/fundSideSettlementMethodAdd");
			view.addObject("fundSideInfo", KC.Enum.getI18nLabelMap(SettlementMethod.class));				
			view.addObject("fundSideSettlementMethod", new FundSideSettlementMethod());
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo FundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(FundSideInfo.getFundSideCode(),FundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoMap",fundSideInfoMap);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideSettlementMethod.fundSideSettlementMethodAddPageFail","加载新增资金方理赔方式页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资金方理赔方式

	 * </p>
	 * @param fundSideSettlementMethod
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addFundSideSettlementMethod.in", method = { RequestMethod.POST })
	public void addFundSideSettlementMethod(FundSideSettlementMethod fundSideSettlementMethod) throws FlatException {
		try {
			parameterSurface.addNewParameter(fundSideSettlementMethod.getFundSideCode(), fundSideSettlementMethod);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideSettlementMethod.addFundSideSettlementMethodFail", "新增资金方理赔方式失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资金方理赔方式
页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideSettlementMethodEditPage.in")
	public ModelAndView fundSideSettlementMethodEditPage(String fundSideCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideSettlementMethod/fundSideSettlementMethodEdit");
			view.addObject("fundSideInfo", KC.Enum.getI18nLabelMap(SettlementMethod.class));				
			FundSideSettlementMethod fundSideSettlementMethod = parameterSurface.getParameterObject(fundSideCode, FundSideSettlementMethod.class);
			view.addObject("fundSideSettlementMethod", fundSideSettlementMethod);
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo FundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(FundSideInfo.getFundSideCode(),FundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoMap",fundSideInfoMap);

            return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideSettlementMethod.fundSideSettlementMethodEditPageFail","加载修改资金方理赔方式页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资金方理赔方式

	 * </p>
	 * @param fundSideSettlementMethod
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updFundSideSettlementMethod.in", method = { RequestMethod.POST })
	public void updFundSideSettlementMethod(FundSideSettlementMethod fundSideSettlementMethod) throws FlatException {
		try {
			parameterSurface.updateParameterObject(fundSideSettlementMethod.getFundSideCode(), fundSideSettlementMethod);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideSettlementMethod.getFundSideCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideSettlementMethod.updFundSideSettlementMethodFail", "修改资金方理赔方式失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资金方理赔方式

	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delFundSideSettlementMethod.in", method = { RequestMethod.POST })
	public void delFundSideSettlementMethods(@RequestBody List<String> fundSideCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(fundSideCodes, FundSideSettlementMethod.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideSettlementMethod.delFundSideSettlementMethodFail", "删除资金方理赔方式失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资金方理赔方式
明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideSettlementMethodDetailPage.in")
	public ModelAndView fundSideSettlementMethodDetailPage(String fundSideCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("fundSideSettlementMethod/fundSideSettlementMethodDetail");
			 view.addObject("factory",fundSideCode==null); 
			FundSideSettlementMethod fundSideSettlementMethod = parameterSurface.getParameterObject(
					fundSideCode==null?code:fundSideCode, FundSideSettlementMethod.class);
			view.addObject("fundSideSettlementMethod", fundSideSettlementMethod);
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo FundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(FundSideInfo.getFundSideCode(),FundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSide",fundSideInfoMap.get(fundSideSettlementMethod.getFundSide()));

            view.addObject("fundSideInfo", KC.Enum.getI18nLabel(fundSideSettlementMethod.getFundSideInfo()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideSettlementMethod.fundSideSettlementMethodDetailPageFail", "加载资金方理赔方式详情页面失败");
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
                    parameterSurface.getParameterObject(FundSideSettlementMethod.class).forEach(
                                    item->resMap.put(item.getFundSideCode(),item.getFundSideDesc()));
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
	   FundSideSettlementMethod parameterObject = parameterSurface.getParameterObject(code,FundSideSettlementMethod.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getFundSideCode());
                   list.add(parameterObject.getFundSideDesc());
                   list.add(KC.Enum.getI18nLabel(parameterObject.getFundSideInfo()));
                   return list;
   }
	
}