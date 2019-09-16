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
import cn.sunline.pcm.definition.ClaimSettlement;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PcmSettleAccMan;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 * <p>
 * 理赔 Controller 层
 * </p>
 * @version 1.0 2019-08-27 修改内容:初版
 */
@Controller
@RequestMapping("claimSettlement")
public class ClaimSettlementController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 理赔 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("claimSettlementQueryPage.in")
    public ModelAndView claimSettlementQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("claimSettlement/claimSettlementQuery");
            view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
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
            view.addObject("claimSettlement", new ClaimSettlement());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"claimSettlement.claimSettlementQueryPageFail","加载理赔列表页面失败");
        }
    }

    /**
     * <p>
     * 查询理赔列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryClaimSettlementList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryClaimSettlementList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, ClaimSettlement.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"claimSettlement.queryClaimSettlementListFail","查询理赔列表失败");
        }
    }

    /**
     * <p>
     * 加载新增理赔页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("claimSettlementAddPage.in")
    public ModelAndView claimSettlementAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("claimSettlement/claimSettlementAdd");
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
            
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            
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
            view.addObject("claimSettlement", new ClaimSettlement());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"claimSettlement.claimSettlementAddPageFail","加载新增理赔页面异常");
        }
    }

    /**
     * <p>
     * 新增理赔
     * </p>
     * @param claimSettlement
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addClaimSettlement.in", method = { RequestMethod.POST })
    public void addClaimSettlement(ClaimSettlement claimSettlement) throws FlatException {
        try {
            parameterSurface.addNewParameter(claimSettlement.getClaimSettlementCode(), claimSettlement);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "claimSettlement.addClaimSettlementFail", "新增理赔失败");
        }
    }

    /**
     * <p>
     * 加载修改理赔页面
     * </p>
     * @param claimSettlementCode
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("claimSettlementEditPage.in")
    public ModelAndView claimSettlementEditPage(String claimSettlementCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("claimSettlement/claimSettlementEdit");
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
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
            ClaimSettlement claimSettlement = parameterSurface.getParameterObject(claimSettlementCode, ClaimSettlement.class);
            view.addObject("claimSettlement", claimSettlement);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"claimSettlement.claimSettlementEditPageFail","加载修改理赔页面失败");
        }
    }

    /**
     * <p>
     * 修改理赔
     * </p>
     * @param claimSettlement
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updClaimSettlement.in", method = { RequestMethod.POST })
    public void updClaimSettlement(ClaimSettlement claimSettlement) throws FlatException {
        try {
            parameterSurface.updateParameterObject(claimSettlement.getClaimSettlementCode(), claimSettlement);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), claimSettlement.getClaimSettlementCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "claimSettlement.updClaimSettlementFail", "修改理赔失败");
        }
    }

    /**
     * <p>
     * 删除理赔
     * </p>
     * @param claimSettlementCodes
     */
    @ResponseBody
    @RequestMapping(value = "delClaimSettlement.in", method = { RequestMethod.POST })
    public void delClaimSettlements(@RequestBody List<String> claimSettlementCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(claimSettlementCodes, ClaimSettlement.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "claimSettlement.delClaimSettlementFail", "删除理赔失败");
        }
    }

    /**
     * <p>
     * 加载理赔明细页面
     * </p>
     * @param claimSettlementCode
     * @return
     * @throws FlatException
     */
    @RequestMapping("claimSettlementDetailPage.in")
    public ModelAndView claimSettlementDetailPage(String claimSettlementCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("claimSettlement/claimSettlementDetail");
            view.addObject("factory", claimSettlementCode == null);
            ClaimSettlement claimSettlement = parameterSurface.getParameterObject(claimSettlementCode==null?code:claimSettlementCode, ClaimSettlement.class);

            view.addObject("claimSettlement", claimSettlement);
            view.addObject("partnerType", KC.Enum.getI18nLabel(claimSettlement.getPartnerType()));
            //所属机构
            PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(claimSettlement.getOrganization(),PcmOrgParameter.class);
            view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            ChannelPartnerType type = claimSettlement.getPartnerType();
            if(type!=null){
                //资产方
                if(type.equals(ChannelPartnerType.ZC)){
                    AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(claimSettlement.getPartnerCode(),AssetSideInfo.class);
                    view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
                }
                //资金方
                if(type.equals(ChannelPartnerType.ZJ)){
                    FundSideInfo fundSideInfo = parameterSurface.getParameterObject(claimSettlement.getPartnerCode(),FundSideInfo.class);
                    view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
                }
                //服务方
                if(type.equals(ChannelPartnerType.FW)){
                    ServerInfo serverInfo = parameterSurface.getParameterObject(claimSettlement.getPartnerCode(),ServerInfo.class);
                    view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
                }
                //渠道方 
                if(type.equals(ChannelPartnerType.QD)){
                    ChannelInfo channelInfo = parameterSurface.getParameterObject(claimSettlement.getPartnerCode(),ChannelInfo.class);
                    view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
                }
            }
            
            
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "claimSettlement.claimSettlementDetailPageFail", "加载理赔详情页面失败");
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
            parameterSurface.getParameterObject(ClaimSettlement.class)
                    .stream().collect(Collectors.toMap(
                    ClaimSettlement::getClaimSettlementCode, ClaimSettlement::getClaimSettlementDesc));
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
        ClaimSettlement parameterObject = parameterSurface.getParameterObject(code,ClaimSettlement.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getClaimSettlementCode());
        list.add(parameterObject.getClaimSettlementDesc());
        return list;
    }
}
