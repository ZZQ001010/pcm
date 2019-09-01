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
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import scala.reflect.internal.Trees.New;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.ChannelParameterInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.InsuranceProductInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.ChannelAttributionType;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.surface.api.ParameterSurface;

/**
 * <p>
 * 渠道参数信息 Controller 层
 * </p>
 * @version 
 */
@Controller
@RequestMapping("channelParameterInfo")
public class ChannelParameterInfoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 渠道参数信息 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("channelParameterInfoQueryPage.in")
    public ModelAndView channelParameterInfoQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("channelParameterInfo/channelParameterInfoQuery");
            view.addObject("channelAttributionType", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.ChannelAttributionType.class));
            view.addObject("channelParameterInfo", new ChannelParameterInfo());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"ChannelParameterInfo.channelParameterInfoQueryPageFail","加载渠道参数信息列表页面失败");
        }
    }

    /**
     * <p>
     * 查询渠道参数信息列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryChannelParameterInfoList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryChannelParameterInfoList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, ChannelParameterInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"channelParameterInfo.queryChannelParameterInfoListFail","查询渠道参数信息列表失败");
        }
    }

    /**
     * <p>
     * 加载新增渠道参数信息页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("channelParameterInfoAddPage.in")
    public ModelAndView channelParameterInfoAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("channelParameterInfo/channelParameterInfoAdd");
            view.addObject("channelAttributionType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.ChannelAttributionType.class));
            view.addObject("channelAttribution",new HashMap<>());
          //资金方
			view.addObject("fundSideInfoJson",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-'+x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoJson",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方  
			view.addObject("channelInfoJson",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoJson",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			//所属机构
			view.addObject("orgMap",KC.json.serializerNoType(parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream().collect(Collectors.toMap(PcmOrgParameter::getOrgCode,x->{
						return x.getOrgCode()+ '-' +x.getOrgName(); 
					}))));
            view.addObject("channelParameterInfo", new ChannelParameterInfo());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"channelParameterInfo.ChannelParameterInfoAddPageFail","加载新增渠道参数信息页面异常");
        }
    }

    /**
     * <p>
     * 新增渠道参数信息
     * </p>
     * @param insuranceProductInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addChannelParameterInfo.in", method = { RequestMethod.POST })
    public void addChannelParameterInfo(ChannelParameterInfo channelParameterInfo) throws FlatException {
        try {
            parameterSurface.addNewParameter(channelParameterInfo.getChannelCode(),channelParameterInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "channelParameterInfo.addChannelParameterInfoFail", "新增渠道参数信息失败");
        }
    }

    /**
     * <p>
     * 加载修改渠道参数信息页面
     * </p>
     * @param id
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("channelParameterInfoEditPage.in")
    public ModelAndView channelParameterInfoEditPage(String channelCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("channelParameterInfo/channelParameterInfoEdit");
            view.addObject("channelAttributionType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.ChannelAttributionType.class));
            ChannelParameterInfo channelParameterInfo = parameterSurface.getParameterObject(channelCode,ChannelParameterInfo.class);
            
            
            //资金方
			view.addObject("fundSideInfoJson",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-'+x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoJson",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方  
			view.addObject("channelInfoJson",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoJson",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			//所属机构
			view.addObject("orgMap",KC.json.serializerNoType(parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream().collect(Collectors.toMap(PcmOrgParameter::getOrgCode,x->{
						return x.getOrgCode()+ '-' +x.getOrgName(); 
					}))));
			
            view.addObject("channelParameterInfo", channelParameterInfo);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"channelParameterInfo.channelParameterInfoEditPageFail","加载修改渠道参数信息页面失败");
        }
    }

    /**
     * <p>
     * 修改渠道参数信息
     * </p>
     * @param channelParameterInfo
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updChannelParameterInfo.in", method = { RequestMethod.POST })
    public void updChannelParameterInfo(ChannelParameterInfo channelParameterInfo) throws FlatException {
        try {
            parameterSurface.updateParameterObject(channelParameterInfo.getChannelCode(),channelParameterInfo);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), channelParameterInfo.getChannelCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "channelParameterInfo.updChannelParameterInfoFail", "修改渠道参数信息失败");
        }
    }

    /**
     * <p>
     * 删除渠道参数信息
     * </p>
     * @param ids
     */
    @ResponseBody
    @RequestMapping(value = "delChannelParameterInfo.in", method = { RequestMethod.POST })
    public void delChannelParameterInfo(@RequestBody List<String> codes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(codes,ChannelParameterInfo.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "channelParameterInfo.delChannelParameterInfoFail", "删除渠道参数信息失败");
        }
    }

    /**
     * <p>
     * 加载渠道参数信息明细页面
     * </p>
     * @param id
     * @return
     * @throws FlatException
     */
    @RequestMapping("channelParameterInfoDetailPage.in")
    public ModelAndView channelParameterInfoDetailPage(String channelCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("channelParameterInfo/channelParameterInfoDetail");
            view.addObject("factory",channelCode==null);

            ChannelParameterInfo channelParameterInfo = parameterSurface.getParameterObject(
                    code==null?channelCode:code, ChannelParameterInfo.class);
            view.addObject("channelParameterInfo", channelParameterInfo);
            view.addObject("channelAttributionType", KC.Enum.getI18nLabel(channelParameterInfo.getChannelAttributionType()));
            if (channelParameterInfo.getChannelAttributionType().equals(ChannelAttributionType.A)) {
				view.addObject("channelAttribution",parameterSurface.getParameterObject(channelParameterInfo.getChannelAttribution(), FundSideInfo.class).getFundSideDesc());
			}else if (channelParameterInfo.getChannelAttributionType().equals(ChannelAttributionType.B)) {
				view.addObject("channelAttribution",parameterSurface.getParameterObject(channelParameterInfo.getChannelAttribution(), AssetSideInfo.class).getAssetSideDesc());
			}else if(channelParameterInfo.getChannelAttributionType().equals(ChannelAttributionType.C)){
				view.addObject("channelAttribution",parameterSurface.getParameterObject(channelParameterInfo.getChannelAttribution(), ChannelInfo.class).getChannelDesc());
			}else if (channelParameterInfo.getChannelAttributionType().equals(ChannelAttributionType.D)) {
				view.addObject("channelAttribution",parameterSurface.getParameterObject(channelParameterInfo.getChannelAttribution(), ServerInfo.class).getServerDesc());
			}else if (channelParameterInfo.getChannelAttributionType().equals(ChannelAttributionType.E)) {
				view.addObject("channelAttribution",parameterSurface.getParameterObject(channelParameterInfo.getChannelAttribution(), PcmOrgParameter.class).getOrgName());
			}
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "channelParameterInfo.channelParameterInfoDetailPageFail", "加载渠道参数信息详情页面失败");
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
            parameterSurface.getParameterObject(ChannelParameterInfo.class).forEach(
                    item->resMap.put(item.getChannelCode(),item.getChannelName()));
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
    	ChannelParameterInfo parameterObject = parameterSurface.getParameterObject(code,ChannelParameterInfo.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getChannelCode());
        list.add(parameterObject.getChannelName());
        list.add(KC.Enum.getI18nLabel(parameterObject.getChannelAttributionType()));
        return list;
    }






}
