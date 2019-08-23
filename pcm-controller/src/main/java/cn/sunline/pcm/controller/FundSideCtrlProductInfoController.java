package cn.sunline.pcm.controller;

import java.util.*;
import java.util.stream.Collectors;

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
import cn.sunline.common.address.AddressHelperFacility;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.FundSideProductCtrlInfo;
import cn.sunline.pcm.definition.enums.FundSideBusinessScope;
import cn.sunline.pcm.definition.enums.FundSideProfessionScope;
/**
 * <p>
 * 资金方产品经营控制
 Controller 层
 * </p>
 * @author fgy
 * @version 1.0 2019-07-28 修改内容:初版
 */
@Controller
@RequestMapping("fundSideProductCtrlInfo")
public class FundSideCtrlProductInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;

    @Autowired
    private AddressHelperFacility addressHelperFacility;

    /**
     * <p>
     * 资金方产品经营控制
     列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("fundSideProductCtrlInfoQueryPage.in")
    public ModelAndView fundSideProductCtrlInfoQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("fundSideProductCtrlInfo/fundSideProductCtrlInfoQuery");
            view.addObject("fundSideBusinessScopeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FundSideBusinessScope.class));
            view.addObject("fundSideProfessionScopeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FundSideProfessionScope.class));
            view.addObject("fundSideProductCtrlInfo", new FundSideProductCtrlInfo());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"fundSideProductCtrlInfo.fundSideProductCtrlInfoQueryPageFail","加载资金方产品经营控制列表页面失败");
        }
    }

    /**
     * <p>
     * 查询资金方产品经营控制
     列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryFundSideProductCtrlInfoList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryFundSideProductCtrlInfoList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, FundSideProductCtrlInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"fundSideProductCtrlInfo.queryFundSideProductCtrlInfoListFail","查询资金方产品经营控制列表失败");
        }
    }

    /**
     * <p>
     * 加载新增资金方产品经营控制
     页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("fundSideProductCtrlInfoAddPage.in")
    public ModelAndView fundSideProductCtrlInfoAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("fundSideProductCtrlInfo/fundSideProductCtrlInfoAdd");
            view.addObject("fundSideBusinessScopes", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideBusinessScope.class));
            view.addObject("fundSideProfessionScopes", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideProfessionScope.class));
            view.addObject("fundSideCreditCardCode", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditCardCode.class));
            TreeMap<String, String> map = addressHelperFacility.loadProvince();
            view.addObject("fundSideProv", map);
            view.addObject("fundSideCity", new LinkedHashMap<String, String>());
            //资金方
            HashMap<String, String> codeMap = new HashMap<>();
            parameterSurface.getParameterObject(FundSideInfo.class).forEach(
                            item->codeMap.put(item.getFundSideCode(),item.getFundSideDesc()));
            view.addObject("fundSideCode", codeMap);
            //资产方
            HashMap<String, String> assetMap = new HashMap<>();
            parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                    item->assetMap.put(item.getAssetSideCode(),item.getAssetSideDesc()));
            view.addObject("assetFundSideCode", assetMap);
            view.addObject("fundSideProductCtrlInfo", new FundSideProductCtrlInfo());
            Map<Boolean,String> map1 = new java.util.HashMap<>();
            map1.put(true, "是");map1.put(false, "否");
            view.addObject("fundSidePartRepay",map1);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"fundSideProductCtrlInfo.fundSideProductCtrlInfoAddPageFail","加载新增资金方产品经营控制页面异常");
        }
    }

    /**
     * <p>
     * 新增资金方产品经营控制

     * </p>
     * @param fundSideProductCtrlInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addFundSideProductCtrlInfo.in", method = { RequestMethod.POST })
    public void addFundSideProductCtrlInfo(FundSideProductCtrlInfo fundSideProductCtrlInfo) throws FlatException {
        try {
            parameterSurface.addNewParameter(fundSideProductCtrlInfo.getFundSideCtrlCode(), fundSideProductCtrlInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "fundSideProductCtrlInfo.addFundSideProductCtrlInfoFail", "新增资金方产品经营控制失败");
        }
    }

    /**
     * <p>
     * 加载修改资金方产品经营控制
     页面
     * </p>
     * @param id
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("fundSideProductCtrlInfoEditPage.in")
    public ModelAndView fundSideProductCtrlInfoEditPage(String fundSideCtrlCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("fundSideProductCtrlInfo/fundSideProductCtrlInfoEdit");
            FundSideProductCtrlInfo fundSideProductCtrlInfo = parameterSurface.getParameterObject(fundSideCtrlCode, FundSideProductCtrlInfo.class);
            view.addObject("fundSideBusinessScopes", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideBusinessScope.class));
            view.addObject("fundSideProfessionScopes", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideProfessionScope.class));
            view.addObject("fundSideCreditCardCode", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FundSideCreditCardCode.class));
            view.addObject("fundSideProv", addressHelperFacility.loadProvince());
            
            if (KC.string.isNotBlank(fundSideProductCtrlInfo.getFundSideProv())) {
                view.addObject("fundSideCity", addressHelperFacility.loadCity(fundSideProductCtrlInfo.getFundSideProv()));
            }
            //资金方
            HashMap<String, String> codeMap = new HashMap<>();
            parameterSurface.getParameterObject(FundSideInfo.class).forEach(
                            item->codeMap.put(item.getFundSideCode(),item.getFundSideDesc()));
            view.addObject("fundSideCode", codeMap);
            //资产方
            HashMap<String, String> assetMap = new HashMap<>();
            parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                    item->assetMap.put(item.getAssetSideCode(),item.getAssetSideDesc()));
            view.addObject("assetFundSideCode", assetMap);
            Map<Boolean,String> map = new java.util.HashMap<>();
            map.put(true, "是");map.put(false, "否");
            view.addObject("fundSidePartRepay",map);
            view.addObject("fundSideProductCtrlInfo", fundSideProductCtrlInfo);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"fundSideProductCtrlInfo.fundSideProductCtrlInfoEditPageFail","加载修改资金方产品经营控制页面失败");
        }
    }

    /**
     * <p>
     * 修改资金方产品经营控制

     * </p>
     * @param fundSideProductCtrlInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updFundSideProductCtrlInfo.in", method = { RequestMethod.POST })
    public void updFundSideProductCtrlInfo(FundSideProductCtrlInfo fundSideProductCtrlInfo) throws FlatException {
        try {
            parameterSurface.updateParameterObject(fundSideProductCtrlInfo.getFundSideCtrlCode(), fundSideProductCtrlInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideProductCtrlInfo.getFundSideCtrlCode());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "fundSideProductCtrlInfo.updFundSideProductCtrlInfoFail", "修改资金方产品经营控制失败");
        }
    }

    /**
     * <p>
     * 删除资金方产品经营控制

     * </p>
     * @param ids
     */
    @ResponseBody
    @RequestMapping(value = "delFundSideProductCtrlInfo.in", method = { RequestMethod.POST })
    public void delFundSideProductCtrlInfos(@RequestBody List<String> fundSideCtrlCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(fundSideCtrlCodes, FundSideProductCtrlInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "fundSideProductCtrlInfo.delFundSideProductCtrlInfoFail", "删除资金方产品经营控制失败");
        }
    }

    /**
     * <p>
     * 加载资金方产品经营控制
     明细页面
     * </p>
     * @param id
     * @return
     * @throws FlatException
     */
    @RequestMapping("fundSideProductCtrlInfoDetailPage.in")
    public ModelAndView fundSideProductCtrlInfoDetailPage(String fundSideCtrlCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("fundSideProductCtrlInfo/fundSideProductCtrlInfoDetail");
            view.addObject("factory",fundSideCtrlCode==null);
            FundSideProductCtrlInfo fundSideProductCtrlInfo = parameterSurface.getParameterObject(
                    fundSideCtrlCode==null?code:fundSideCtrlCode, FundSideProductCtrlInfo.class);
            view.addObject("fundSideProductCtrlInfo", fundSideProductCtrlInfo);
            view.addObject("fundSidePartRepay",fundSideProductCtrlInfo.getFundSidePartRepay()?"是":"否");
    		String province = addressHelperFacility.loadProvince().get(fundSideProductCtrlInfo.getFundSideProv());
    		String city = addressHelperFacility.loadCity(fundSideProductCtrlInfo.getFundSideProv()).get(fundSideProductCtrlInfo.getFundSideCity());
    		//市
            view.addObject("FundSideProv",province);
            view.addObject("fundSideCity", city);
            List<FundSideBusinessScope> fundSideBusinessScopes = fundSideProductCtrlInfo.getFundSideBusinessScope();
            view.addObject("fundSideBusinessScopes",fundSideBusinessScopes.stream().map(n->KC.Enum.getI18nLabel(n)).collect(Collectors.toList()));
            List<FundSideProfessionScope> fundSideProfessionScopes = fundSideProductCtrlInfo.getFundSideProfessionScope();
            view.addObject("fundSideProfessionScopes",fundSideProfessionScopes.stream().map(n->KC.Enum.getI18nLabel(n)).collect(Collectors.toList()));
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "fundSideProductCtrlInfo.fundSideProductCtrlInfoDetailPageFail", "加载资金方产品经营控制详情页面失败");
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
            parameterSurface.getParameterObject(FundSideProductCtrlInfo.class).forEach(
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
        FundSideProductCtrlInfo parameterObject = parameterSurface.getParameterObject(code,FundSideProductCtrlInfo.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getFundSideCtrlCode());
        list.add(parameterObject.getFundSideCtrlDesc());
        return list;
    }

}
