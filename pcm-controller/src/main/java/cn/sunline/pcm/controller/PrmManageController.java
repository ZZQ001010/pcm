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
import cn.sunline.pcm.definition.PrmManage;
/**
 * <p>
 * 参数管理
 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-12 修改内容:初版
 */
@Controller
@RequestMapping("prmManage")
public class PrmManageController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 参数管理
     列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("prmManageQueryPage.in")
    public ModelAndView prmManageQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("prmManage/prmManageQuery");

            view.addObject("prmManage", new PrmManage());

            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"prmManage.prmManageQueryPageFail","加载参数管理列表页面失败");
        }
    }

    /**
     * <p>
     * 查询参数管理
     列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryPrmManageList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryPrmManageList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, PrmManage.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"prmManage.queryPrmManageListFail","查询参数管理列表失败");
        }
    }

    /**
     * <p>
     * 加载新增参数管理
     页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("prmManageAddPage.in")
    public ModelAndView prmManageAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("prmManage/prmManageAdd");
            view.addObject("prmManage", new PrmManage());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"prmManage.prmManageAddPageFail","加载新增参数管理页面异常");
        }
    }

    /**
     * <p>
     * 新增参数管理

     * </p>
     * @param prmManage
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addPrmManage.in", method = { RequestMethod.POST })
    public void addPrmManage(PrmManage prmManage) throws FlatException {
        try {
            parameterSurface.addNewParameter(prmManage.getId(), prmManage);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "prmManage.addPrmManageFail", "新增参数管理失败");
        }
    }

    /**
     * <p>
     * 加载修改参数管理
     页面
     * </p>
     * @param id
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("prmManageEditPage.in")
    public ModelAndView prmManageEditPage(String id, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("prmManage/prmManageEdit");
            PrmManage prmManage = parameterSurface.getParameterObject(id, PrmManage.class);
            view.addObject("prmManage", prmManage);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"prmManage.prmManageEditPageFail","加载修改参数管理页面失败");
        }
    }

    /**
     * <p>
     * 修改参数管理

     * </p>
     * @param prmManage
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updPrmManage.in", method = { RequestMethod.POST })
    public void updPrmManage(PrmManage prmManage) throws FlatException {
        try {
            parameterSurface.updateParameterObject(prmManage.getId(), prmManage);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), prmManage.getId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "prmManage.updPrmManageFail", "修改参数管理失败");
        }
    }

    /**
     * <p>
     * 删除参数管理

     * </p>
     * @param ids
     */
    @ResponseBody
    @RequestMapping(value = "delPrmManage.in", method = { RequestMethod.POST })
    public void delPrmManages(@RequestBody List<String> ids) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(ids, PrmManage.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "prmManage.delPrmManageFail", "删除参数管理失败");
        }
    }

    /**
     * <p>
     * 加载参数管理
     明细页面
     * </p>
     * @param id
     * @return
     * @throws FlatException
     */
    @RequestMapping("prmManageDetailPage.in")
    public ModelAndView prmManageDetailPage(String id,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("prmManage/prmManageDetail");
            view.addObject("factory",id==null);
            PrmManage prmManage = parameterSurface.getParameterObject(
                    id==null?code:id, PrmManage.class);
            view.addObject("prmManage", prmManage);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "prmManage.prmManageDetailPageFail", "加载参数管理详情页面失败");
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
            parameterSurface.getParameterObject(PrmManage.class).forEach(
                    item->resMap.put(item.getId(),item.getName()));
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
        PrmManage parameterObject = parameterSurface.getParameterObject(code,PrmManage.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getId());
        list.add(parameterObject.getName());
        return list;
    }


}