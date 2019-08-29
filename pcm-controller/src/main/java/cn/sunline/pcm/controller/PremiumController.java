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
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.Premium;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
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
 * 保费 Controller 层
 * </p>
 * @version 1.0 2019-08-26 修改内容:初版
 */
@Controller
@RequestMapping("premium")
public class PremiumController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 保费 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("premiumQueryPage.in")
    public ModelAndView premiumQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("premium/premiumQuery");
            view.addObject("feeCollectionMethodJson", KC.Enum.getI18nLabelMapJson(ChannelFeeCollectionMethod.class));
            view.addObject("feeBasisJson", KC.Enum.getI18nLabelMapJson(FeeBasis.class));
            view.addObject("frequencyOfChargeJson", KC.Enum.getI18nLabelMapJson(FrequencyOfChannel.class));
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
            view.addObject("premium", new Premium());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"premium.premiumQueryPageFail","加载保费列表页面失败");
        }
    }

    /**
     * <p>
     * 查询保费列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryPremiumList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryPremiumList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, Premium.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"premium.queryPremiumListFail","查询保费列表失败");
        }
    }

    /**
     * <p>
     * 加载新增保费页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("premiumAddPage.in")
    public ModelAndView premiumAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("premium/premiumAdd");
            view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));
            view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
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
            view.addObject("premium", new Premium());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"premium.premiumAddPageFail","加载新增保费页面异常");
        }
    }

    /**
     * <p>
     * 新增保费
     * </p>
     * @param premium
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addPremium.in", method = { RequestMethod.POST })
    public void addPremium(Premium premium) throws FlatException {
        try {
            parameterSurface.addNewParameter(premium.getPremiumCode(), premium);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "premium.addPremiumFail", "新增保费失败");
        }
    }

    /**
     * <p>
     * 加载修改保费页面
     * </p>
     * @param premiumCode
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("premiumEditPage.in")
    public ModelAndView premiumEditPage(String premiumCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("premium/premiumEdit");
            view.addObject("feeCollectionMethod", KC.Enum.getI18nLabelMap(ChannelFeeCollectionMethod.class));
            view.addObject("feeBasis", KC.Enum.getI18nLabelMap(FeeBasis.class));
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabelMap(FrequencyOfChannel.class));
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
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
            Premium premium = parameterSurface.getParameterObject(premiumCode, Premium.class);
            view.addObject("premium", premium);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"premium.premiumEditPageFail","加载修改保费页面失败");
        }
    }

    /**
     * <p>
     * 修改保费
     * </p>
     * @param premium
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updPremium.in", method = { RequestMethod.POST })
    public void updPremium(Premium premium) throws FlatException {
        try {
            parameterSurface.updateParameterObject(premium.getPremiumCode(), premium);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), premium.getPremiumCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "premium.updPremiumFail", "修改保费失败");
        }
    }

    /**
     * <p>
     * 删除保费
     * </p>
     * @param premiumCodes
     */
    @ResponseBody
    @RequestMapping(value = "delPremium.in", method = { RequestMethod.POST })
    public void delPremiums(@RequestBody List<String> premiumCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(premiumCodes, Premium.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "premium.delPremiumFail", "删除保费失败");
        }
    }

    /**
     * <p>
     * 加载保费明细页面
     * </p>
     * @param premiumCode
     * @return
     * @throws FlatException
     */
    @RequestMapping("premiumDetailPage.in")
    public ModelAndView premiumDetailPage(String premiumCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("premium/premiumDetail");
            view.addObject("factory", premiumCode == null);
            Premium premium = parameterSurface.getParameterObject(premiumCode==null?code:premiumCode, Premium.class);
            if(premium.getBillingCycle().equals(BillingCycle.Z)){
                view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(premium.balanceDate));
            }else{
                view.addObject("balanceDate", premium.getBalanceDate() );
            }
            view.addObject("premium", premium);
            view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(premium.getFrequencyOfCharge()));
            view.addObject("partnerType", KC.Enum.getI18nLabel(premium.getPartnerType()));
            view.addObject("billingCycle", KC.Enum.getI18nLabel(premium.getBillingCycle()));
            //所属机构
            PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(premium.getOrganization(),PcmOrgParameter.class);
            view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            ChannelPartnerType type = premium.getPartnerType();
            if(type!=null){
                //资产方
                if(type.equals(ChannelPartnerType.ZC)){
                    AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(premium.getPartnerCode(),AssetSideInfo.class);
                    view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
                }
                //资金方
                if(type.equals(ChannelPartnerType.ZJ)){
                    FundSideInfo fundSideInfo = parameterSurface.getParameterObject(premium.getPartnerCode(),FundSideInfo.class);
                    view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
                }
                //服务方
                if(type.equals(ChannelPartnerType.FW)){
                    ServerInfo serverInfo = parameterSurface.getParameterObject(premium.getPartnerCode(),ServerInfo.class);
                    view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
                }
                //渠道方
                if(type.equals(ChannelPartnerType.QD)){
                    ChannelInfo channelInfo = parameterSurface.getParameterObject(premium.getPartnerCode(),ChannelInfo.class);
                    view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
                }
            }
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "premium.premiumDetailPageFail", "加载保费详情页面失败");
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
            parameterSurface.getParameterObject(Premium.class)
                    .stream().collect(Collectors.toMap(
                    Premium::getPremiumCode, Premium::getPremiumDesc));
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
        Premium parameterObject = parameterSurface.getParameterObject(code,Premium.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getPremiumCode());
        list.add(parameterObject.getPremiumDesc());
        return list;
    }
}
