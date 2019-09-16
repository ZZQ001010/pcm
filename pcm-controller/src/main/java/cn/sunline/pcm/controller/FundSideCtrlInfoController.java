package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import cn.sunline.pcm.controller.common.constent.ParameterFlags;
import cn.sunline.pcm.definition.FundSideCtrlInfo;
import cn.sunline.pcm.definition.FundSideInfo;
/** 
 * <p>
 * 资金方管控信息
 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-12 修改内容:初版
 */ 
@Controller
@RequestMapping("fundSideCtrlInfo")
public class FundSideCtrlInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 资金方管控信息
 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideCtrlInfoQueryPage.in")
	public ModelAndView fundSideCtrlInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideCtrlInfo/fundSideCtrlInfoQuery");
            view.addObject("fundSideCreditLimitJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));
            view.addObject("fundSideLoanLimitJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));

            view.addObject("fundSideCtrlInfo", new FundSideCtrlInfo());
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
			throw new FlatException(e,"fundSideCtrlInfo.fundSideCtrlInfoQueryPageFail","加载资金方管控信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资金方管控信息
列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryFundSideCtrlInfoList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryFundSideCtrlInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, FundSideCtrlInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideCtrlInfo.queryFundSideCtrlInfoListFail","查询资金方管控信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资金方管控信息
页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideCtrlInfoAddPage.in")
	public ModelAndView fundSideCtrlInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideCtrlInfo/fundSideCtrlInfoAdd");
			view.addObject("fundSideCtrlInfo", new FundSideCtrlInfo());
            view.addObject("fundSideCreditLimit", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));
            view.addObject("fundSideLoanLimit", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));
            view.addObject("fundSideInfoMap",parameterSurface.getParameterObject(FundSideInfo.class)
            		.stream().collect(Collectors.toMap(
            				FundSideInfo::getFundSideCode, 
            				fund->fund.getFundSideCode()+ParameterFlags.SHORT_CROSS+fund.getFundSideDesc())
            				)
            		);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideCtrlInfo.fundSideCtrlInfoAddPageFail","加载新增资金方管控信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资金方管控信息

	 * </p>
	 * @param fundSideCtrlInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addFundSideCtrlInfo.in", method = { RequestMethod.POST })
	public void addFundSideCtrlInfo(FundSideCtrlInfo fundSideCtrlInfo) throws FlatException {
		try {
			parameterSurface.addNewParameter(fundSideCtrlInfo.getFundSideCtrlCode(), fundSideCtrlInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideCtrlInfo.addFundSideCtrlInfoFail", "新增资金方管控信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资金方管控信息
页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideCtrlInfoEditPage.in")
	public ModelAndView fundSideCtrlInfoEditPage(String fundSideCtrlCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideCtrlInfo/fundSideCtrlInfoEdit");
			FundSideCtrlInfo fundSideCtrlInfo = parameterSurface.getParameterObject(fundSideCtrlCode, FundSideCtrlInfo.class);
			view.addObject("fundSideCtrlInfo", fundSideCtrlInfo);
            view.addObject("fundSideCreditLimit", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));
            view.addObject("fundSideLoanLimit", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditLimit.class));

            //资金方
            view.addObject("fundSideInfoMap",parameterSurface.getParameterObject(FundSideInfo.class)
            		.stream().collect(Collectors.toMap(
            				FundSideInfo::getFundSideCode, 
            				fund->fund.getFundSideCode()+ParameterFlags.SHORT_CROSS+fund.getFundSideDesc())
            				)
            		);

            return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideCtrlInfo.fundSideCtrlInfoEditPageFail","加载修改资金方管控信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资金方管控信息

	 * </p>
	 * @param fundSideCtrlInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updFundSideCtrlInfo.in", method = { RequestMethod.POST })
	public void updFundSideCtrlInfo(FundSideCtrlInfo fundSideCtrlInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(fundSideCtrlInfo.getFundSideCtrlCode(), fundSideCtrlInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideCtrlInfo.getFundSideCtrlCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideCtrlInfo.updFundSideCtrlInfoFail", "修改资金方管控信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资金方管控信息

	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delFundSideCtrlInfo.in", method = { RequestMethod.POST })
	public void delFundSideCtrlInfos(@RequestBody List<String> fundSideCtrlCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(fundSideCtrlCodes, FundSideCtrlInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideCtrlInfo.delFundSideCtrlInfoFail", "删除资金方管控信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资金方管控信息
明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideCtrlInfoDetailPage.in")
	public ModelAndView fundSideCtrlInfoDetailPage(String fundSideCtrlCode,String code,ModelAndView view) throws FlatException {
		try {	
			view = KW.mvc.forwardView("fundSideCtrlInfo/fundSideCtrlInfoDetail");
			view.addObject("factory",fundSideCtrlCode==null); 
			FundSideCtrlInfo fundSideCtrlInfo = parameterSurface.getParameterObject(
					fundSideCtrlCode==null?code:fundSideCtrlCode, FundSideCtrlInfo.class);
			view.addObject("fundSideCtrlInfo", fundSideCtrlInfo);
            view.addObject("fundSideCreditLimit", KC.Enum.getI18nLabel(fundSideCtrlInfo.getFundSideCreditLimit()));
            view.addObject("fundSideLoanLimit", KC.Enum.getI18nLabel(fundSideCtrlInfo.getFundSideLoanLimit()));

            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo FundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(FundSideInfo.getFundSideCode(),FundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSide",fundSideInfoMap.get(fundSideCtrlInfo.getFundSide()));

            return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideCtrlInfo.fundSideCtrlInfoDetailPageFail", "加载资金方管控信息详情页面失败");
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
                    parameterSurface.getParameterObject(FundSideCtrlInfo.class).forEach(
                                    item->resMap.put(item.getFundSideCtrlCode(),item.getFundSideCtrlDesc()));
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
	   FundSideCtrlInfo parameterObject = parameterSurface.getParameterObject(code,FundSideCtrlInfo.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getFundSideCtrlCode());
                   list.add(parameterObject.getFundSideCtrlDesc());
                   list.add(parameterObject.getFundSideTotalLoanAmount().toString());
                   return list;
   }
	
	
}