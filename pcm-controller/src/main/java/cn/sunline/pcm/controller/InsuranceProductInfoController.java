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
import cn.sunline.pcm.definition.InsuranceProductInfo;
import cn.sunline.pcm.surface.api.ParameterSurface;

/**
 * <p>
 * 保险产品信息 Controller 层
 * </p>
 * @version 1.0 2019-07-25 修改内容:初版
 */
@Controller
@RequestMapping("insuranceProductInfo")
public class InsuranceProductInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 保险产品信息 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("insuranceProductInfoQueryPage.in")
    public ModelAndView insuranceProductInfoQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("insuranceProductInfo/insuranceProductInfoQuery");
            view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
            view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
            view.addObject("feePayMethodJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.FeePayMethod.class));
            view.addObject("insuranceProductInfo", new InsuranceProductInfo());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"insuranceProductInfo.insuranceProductInfoQueryPageFail","加载保险产品信息列表页面失败");
        }
    }

    /**
     * <p>
     * 查询保险产品信息列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryInsuranceProductInfoList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryInsuranceProductInfoList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, InsuranceProductInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"insuranceProductInfo.queryInsuranceProductInfoListFail","查询保费基本信息列表失败");
        }
    }

    /**
     * <p>
     * 加载新增保险产品信息页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("insuranceProductInfoAddPage.in")
    public ModelAndView insuranceProductInfoAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("insuranceProductInfo/insuranceProductInfoAdd");
            view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
            view.addObject("feePayMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeePayMethod.class));
            view.addObject("insuranceProductInfo", new InsuranceProductInfo());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"insuranceProductInfo.insuranceProductInfoAddPageFail","加载新增保险产品信息页面异常");
        }
    }

    /**
     * <p>
     * 新增保险产品信息
     * </p>
     * @param insuranceProductInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addInsuranceProductInfo.in", method = { RequestMethod.POST })
    public void addInsuranceProductInfo(InsuranceProductInfo insuranceProductInfo) throws FlatException {
        try {
            parameterSurface.addNewParameter(insuranceProductInfo.getCode(),insuranceProductInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "insuranceProductInfo.addInsuranceProductInfoFail", "新增保险产品信息失败");
        }
    }

    /**
     * <p>
     * 加载修改保险产品信息页面
     * </p>
     * @param id
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("insuranceProductInfoEditPage.in")
    public ModelAndView insuranceProductInfoEditPage(String code, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("insuranceProductInfo/insuranceProductInfoEdit");
            view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeeCollectionMethod.class));
            view.addObject("feePayMethod", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FeePayMethod.class));
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.FrequencyOfCharge.class));
            InsuranceProductInfo insuranceProductInfo = parameterSurface.getParameterObject(code,InsuranceProductInfo.class);
            view.addObject("insuranceProductInfo", insuranceProductInfo);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"insuranceProductInfo.insuranceProductInfoEditPageFail","加载修改保险产品信息页面失败");
        }
    }

    /**
     * <p>
     * 修改保险产品信息
     * </p>
     * @param insuranceProductInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updInsuranceProductInfo.in", method = { RequestMethod.POST })
    public void updInsuranceProductInfo(InsuranceProductInfo bInsuranceProductInfo) throws FlatException {
        try {
            parameterSurface.updateParameterObject(bInsuranceProductInfo.getCode(),bInsuranceProductInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), bInsuranceProductInfo.getCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "insuranceProductInfo.updInsuranceProductInfoFail", "修改保险产品信息失败");
        }
    }

    /**
     * <p>
     * 删除保险产品信息
     * </p>
     * @param ids
     */
    @ResponseBody
    @RequestMapping(value = "delInsuranceProductInfo.in", method = { RequestMethod.POST })
    public void delBasicInfoOfPremiums(@RequestBody List<String> codes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(codes,InsuranceProductInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "insuranceProductInfo.delInsuranceProductInfoFail", "删除保险产品信息失败");
        }
    }

    /**
     * <p>
     * 加载保险产品信息明细页面
     * </p>
     * @param id
     * @return
     * @throws FlatException
     */
    @RequestMapping("insuranceProductInfoDetailPage.in")
    public ModelAndView insuranceProductInfoDetailPage(String dcode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("insuranceProductInfo/insuranceProductInfoDetail");
            view.addObject("factory",dcode==null);

            InsuranceProductInfo insuranceProductInfo = parameterSurface.getParameterObject(
                    code==null?dcode:code, InsuranceProductInfo.class);
            view.addObject("insuranceProductInfo", insuranceProductInfo);
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(insuranceProductInfo.getFrequencyOfCharge()));
            view.addObject("feePayMethod", KC.Enum.getI18nLabel(insuranceProductInfo.getFeePayMethod()));
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "insuranceProductInfo.insuranceProductInfoDetailPageFail", "加载保险产品信息详情页面失败");
        }
    }

    /**
     *
     * @param:  @return
     * @param:  @throws FlatException
     * @throws
     */
    @ResponseBody
    @PostMapping(value="/unitConfig.in",produces={"application/json"})
    public Map<String,String> unitConfig() throws FlatException{
        try{
            HashMap<String, String> resMap = new HashMap<>();
            parameterSurface.getParameterObject(InsuranceProductInfo.class).forEach(
                    item->resMap.put(item.getCode(),item.getName()));
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
        InsuranceProductInfo parameterObject = parameterSurface.getParameterObject(code,InsuranceProductInfo.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getCode());
        list.add(parameterObject.getName());
        return list;
    }






}
