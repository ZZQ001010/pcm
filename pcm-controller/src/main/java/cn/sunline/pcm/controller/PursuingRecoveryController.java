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
import cn.sunline.common.KC.map;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.common.constent.ParameterFlags;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.PursuingRecovery;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PcmSettleAccMan;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelFeeCollectionMethod;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FrequencyOfChannel;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 追偿 Controller 层
 * </p>
 * @version 1.0 2019-08-27 修改内容:初版
 */
@Controller
@RequestMapping("pursuingRecovery")

public class PursuingRecoveryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 追偿 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("pursuingRecoveryQueryPage.in")
    public ModelAndView pursuingRecoveryQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("pursuingRecovery/pursuingRecoveryQuery");
           view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
            view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
            //所属机构
            FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
            List<PcmOrgParameter> list = response.getRows();
            Map<String,String> orgMap = new HashMap<String,String>();
            for (PcmOrgParameter pcmOrgParameter : list) {
                orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            }
            view.addObject("orgJson",new JSONObject(orgMap));
            /**
             * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
             */
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo fundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(fundSideInfo.getFundSideCode(),
                        fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoJson",new JSONObject(fundSideInfoMap));
            //资产方
            List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
            Map<String,String> assetSideInfoMap = new HashMap<String,String>();
            for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
                assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
                        AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
            }
            view.addObject("assetSideInfoJson",new JSONObject(assetSideInfoMap));
            //渠道方  
            List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
            Map<String,String> channelInfoMap = new HashMap<String,String>();
            for (ChannelInfo channelInfo : channelInfoList) {
                channelInfoMap.put(channelInfo.getChannelCode(),
                        channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
            }
            view.addObject("channelInfoJson",new JSONObject(channelInfoMap));
            //服务方  
            List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
            Map<String,String> serverInfoMap = new HashMap<String,String>();
            for (ServerInfo serverInfo : serverInfoList) {
                serverInfoMap.put(serverInfo.getServerCode(),
                        serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
            }
            view.addObject("serverInfoJson",new JSONObject(serverInfoMap));
            view.addObject("pursuingRecovery", new PursuingRecovery());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"pursuingRecovery.pursuingRecoveryQueryPageFail","加载追偿列表页面失败");
        }
    }

    /**
     * <p>
     * 查询追偿列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryPursuingRecoveryList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryPursuingRecoveryList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, PursuingRecovery.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"pursuingRecovery.queryPursuingRecoveryListFail","查询追偿列表失败");
        }
    }

    /**
     * <p>
     * 加载新增追偿页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("pursuingRecoveryAddPage.in")
    public ModelAndView pursuingRecoveryAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("pursuingRecovery/pursuingRecoveryAdd");
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            
            view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
            view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
            //所属机构
            FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
            List<PcmOrgParameter> list = response.getRows();
            Map<String,String> orgMap = new HashMap<String,String>();
            for (PcmOrgParameter pcmOrgParameter : list) {
                orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            }
            view.addObject("orgMap",orgMap);
            /**
             * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
             */
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo fundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(fundSideInfo.getFundSideCode(),
                        fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoMap",new JSONObject(fundSideInfoMap));
            //资产方
            List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
            Map<String,String> assetSideInfoMap = new HashMap<String,String>();
            for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
                assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
                        AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
            }
            view.addObject("assetSideInfoMap",new JSONObject(assetSideInfoMap));
            //渠道方  
            List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
            Map<String,String> channelInfoMap = new HashMap<String,String>();
            for (ChannelInfo channelInfo : channelInfoList) {
                channelInfoMap.put(channelInfo.getChannelCode(),
                        channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
            }
            view.addObject("channelInfoMap",new JSONObject(channelInfoMap));
            //服务方  
            List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
            Map<String,String> serverInfoMap = new HashMap<String,String>();
            for (ServerInfo serverInfo : serverInfoList) {
                serverInfoMap.put(serverInfo.getServerCode(),
                        serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
            }
            view.addObject("serverInfoMap",new JSONObject(serverInfoMap));
            view.addObject("pursuingRecovery", new PursuingRecovery());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"pursuingRecovery.pursuingRecoveryAddPageFail","加载新增追偿页面异常");
        }
    }

    /**
     * <p>
     * 新增追偿
     * </p>
     * @param pursuingRecovery
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addPursuingRecovery.in", method = { RequestMethod.POST })
    public void addPursuingRecovery(PursuingRecovery pursuingRecovery) throws FlatException {
        try {
            parameterSurface.addNewParameter(pursuingRecovery.getPursuingRecoveryCode(), pursuingRecovery);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "pursuingRecovery.addPursuingRecoveryFail", "新增追偿失败");
        }
    }

    /**
     * <p>
     * 加载修改追偿页面
     * </p>
     * @param pursuingRecoveryCode
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("pursuingRecoveryEditPage.in")
    public ModelAndView pursuingRecoveryEditPage(String pursuingRecoveryCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("pursuingRecovery/pursuingRecoveryEdit");
           view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
           view.addObject("pcmSettleAccMan",
           		parameterSurface.getParameterObject(PcmSettleAccMan.class)
           		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
           				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
            view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
            //所属机构
            FetchResponse response = parameterSurface.getFetchResponse(null, PcmOrgParameter.class);
            List<PcmOrgParameter> list = response.getRows();
            Map<String,String> orgMap = new HashMap<String,String>();
            for (PcmOrgParameter pcmOrgParameter : list) {
                orgMap.put(pcmOrgParameter.orgCode, pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            }
            view.addObject("orgMap",orgMap);
            /**
             * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
             */
            //资金方
            List<FundSideInfo> fundSideInfoList = parameterSurface.getFetchResponse(null, FundSideInfo.class).getRows();
            Map<String,String> fundSideInfoMap = new HashMap<String,String>();
            for (FundSideInfo fundSideInfo : fundSideInfoList) {
                fundSideInfoMap.put(fundSideInfo.getFundSideCode(),
                        fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
            }
            view.addObject("fundSideInfoMap",new JSONObject(fundSideInfoMap));
            //资产方
            List<AssetSideInfo> assetSideInfoList = parameterSurface.getFetchResponse(null, AssetSideInfo.class).getRows();
            Map<String,String> assetSideInfoMap = new HashMap<String,String>();
            for (AssetSideInfo AssetSideInfo : assetSideInfoList) {
                //key,防止key值相同
                assetSideInfoMap.put(AssetSideInfo.getAssetSideCode(),
                        AssetSideInfo.getAssetSideCode()+"-"+AssetSideInfo.getAssetSideDesc());
            }
            view.addObject("assetSideInfoMap",new JSONObject(assetSideInfoMap));
            //渠道方  
            List<ChannelInfo> channelInfoList = parameterSurface.getFetchResponse(null, ChannelInfo.class).getRows();
            Map<String,String> channelInfoMap = new HashMap<String,String>();
            for (ChannelInfo channelInfo : channelInfoList) {
                channelInfoMap.put(channelInfo.getChannelCode(),
                        channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
            }
            view.addObject("channelInfoMap",new JSONObject(channelInfoMap));
            //服务方  
            List<ServerInfo> serverInfoList = parameterSurface.getFetchResponse(null, ServerInfo.class).getRows();
            Map<String,String> serverInfoMap = new HashMap<String,String>();
            for (ServerInfo serverInfo : serverInfoList) {
                serverInfoMap.put(serverInfo.getServerCode(),
                        serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
            }
            view.addObject("serverInfoMap",new JSONObject(serverInfoMap));
            PursuingRecovery pursuingRecovery = parameterSurface.getParameterObject(pursuingRecoveryCode, PursuingRecovery.class);
            view.addObject("pursuingRecovery", pursuingRecovery);
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"pursuingRecovery.pursuingRecoveryEditPageFail","加载修改追偿页面失败");
        }
    }

    /**
     * <p>
     * 修改追偿
     * </p>
     * @param pursuingRecovery
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updPursuingRecovery.in", method = { RequestMethod.POST })
    public void updPursuingRecovery(PursuingRecovery pursuingRecovery) throws FlatException {
        try {
            parameterSurface.updateParameterObject(pursuingRecovery.getPursuingRecoveryCode(), pursuingRecovery);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), pursuingRecovery.getPursuingRecoveryCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "pursuingRecovery.updPursuingRecoveryFail", "修改追偿失败");
        }
    }

    /**
     * <p>
     * 删除追偿
     * </p>
     * @param pursuingRecoveryCodes
     */
    @ResponseBody
    @RequestMapping(value = "delPursuingRecovery.in", method = { RequestMethod.POST })
    public void delPursuingRecoverys(@RequestBody List<String> pursuingRecoveryCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(pursuingRecoveryCodes, PursuingRecovery.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "pursuingRecovery.delPursuingRecoveryFail", "删除追偿失败");
        }
    }

    /**
     * <p>
     * 加载追偿明细页面
     * </p>
     * @param pursuingRecoveryCode
     * @return
     * @throws FlatException
     */
    @RequestMapping("pursuingRecoveryDetailPage.in")
    public ModelAndView pursuingRecoveryDetailPage(String pursuingRecoveryCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("pursuingRecovery/pursuingRecoveryDetail");
            view.addObject("factory", pursuingRecoveryCode == null);
            PursuingRecovery pursuingRecovery = parameterSurface.getParameterObject(pursuingRecoveryCode==null?code:pursuingRecoveryCode, PursuingRecovery.class);
            if(pursuingRecovery!=null){
            	 if(BillingCycle.Z.equals(pursuingRecovery.getBillingCycle())){
                     view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(pursuingRecovery.balanceDate));
                 }else{
                     view.addObject("balanceDate", pursuingRecovery.getBalanceDate() );
                 }
                 view.addObject("pursuingRecovery", pursuingRecovery);
                 view.addObject("partnerType", KC.Enum.getI18nLabel(pursuingRecovery.getPartnerType()));
                 view.addObject("billingCycle", KC.Enum.getI18nLabel(pursuingRecovery.getBillingCycle()));
                 //所属机构
                 PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(pursuingRecovery.getOrganization(),PcmOrgParameter.class);
                 view.addObject("org",pcmOrgParameter==null?"":pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
                 ChannelPartnerType type = pursuingRecovery.getPartnerType();
                	Map<String, String> collect = parameterSurface.getParameterObject(PcmSettleAccMan.class)
                 		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
                 				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())) ;
                	if(null!=collect){
                		pursuingRecovery.setTransferAccount(collect.get(pursuingRecovery.getTransferAccount()));
                    	pursuingRecovery.setTransferToAccount(collect.get(pursuingRecovery.getTransferToAccount()));
                	}
                	
                 if(type!=null){
                     //资产方
                     if(ChannelPartnerType.ZC.equals(type)){
                         AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(pursuingRecovery.getPartnerCode(),AssetSideInfo.class);
                         view.addObject("partner", assetSideInfo==null?"":assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
                     }
                     //资金方
                     if(ChannelPartnerType.ZJ.equals(type)){
                         FundSideInfo fundSideInfo = parameterSurface.getParameterObject(pursuingRecovery.getPartnerCode(),FundSideInfo.class);
                         view.addObject("partner", fundSideInfo==null?"":fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
                     }
                     //服务方
                     if(ChannelPartnerType.FW.equals(type)){
                         ServerInfo serverInfo = parameterSurface.getParameterObject(pursuingRecovery.getPartnerCode(),ServerInfo.class);
                         view.addObject("partner", serverInfo==null?"":serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
                     }
                     //渠道方 
                     if(ChannelPartnerType.QD.equals(type)){
                         ChannelInfo channelInfo = parameterSurface.getParameterObject(pursuingRecovery.getPartnerCode(),ChannelInfo.class);
                         view.addObject("partner", channelInfo==null?"":channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
                     }
                 }
            }
           
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "pursuingRecovery.pursuingRecoveryDetailPageFail", "加载追偿详情页面失败");
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
            parameterSurface.getParameterObject(PursuingRecovery.class)
                    .stream().collect(Collectors.toMap(
                    PursuingRecovery::getPursuingRecoveryCode, PursuingRecovery::getPursuingRecoveryDesc));
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
        PursuingRecovery parameterObject = parameterSurface.getParameterObject(code,PursuingRecovery.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getPursuingRecoveryCode());
        list.add(parameterObject.getPursuingRecoveryDesc());
        return list;
    }
}
