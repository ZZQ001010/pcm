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
import cn.sunline.pcm.definition.BankChargeMorePenaltyInterest;
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
 * 银行多记罚息 Controller 层
 * </p>
 * @version 1.0 2019-08-27 修改内容:初版
 */
@Controller
@RequestMapping("bankChargeMorePenaltyInterest")
public class BankChargeMorePenaltyInterestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 银行多记罚息 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankChargeMorePenaltyInterestQueryPage.in")
    public ModelAndView bankChargeMorePenaltyInterestQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("bankChargeMorePenaltyInterest/bankChargeMorePenaltyInterestQuery");
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
            view.addObject("bankChargeMorePenaltyInterest", new BankChargeMorePenaltyInterest());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestQueryPageFail","加载银行多记罚息列表页面失败");
        }
    }

    /**
     * <p>
     * 查询银行多记罚息列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryBankChargeMorePenaltyInterestList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryBankChargeMorePenaltyInterestList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, BankChargeMorePenaltyInterest.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankChargeMorePenaltyInterest.queryBankChargeMorePenaltyInterestListFail","查询银行多记罚息列表失败");
        }
    }

    /**
     * <p>
     * 加载新增银行多记罚息页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankChargeMorePenaltyInterestAddPage.in")
    public ModelAndView bankChargeMorePenaltyInterestAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("bankChargeMorePenaltyInterest/bankChargeMorePenaltyInterestAdd");
           view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
            view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
            view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
          //结算账号
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
            view.addObject("bankChargeMorePenaltyInterest", new BankChargeMorePenaltyInterest());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestAddPageFail","加载新增银行多记罚息页面异常");
        }
    }

    /**
     * <p>
     * 新增银行多记罚息
     * </p>
     * @param bankChargeMorePenaltyInterest
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addBankChargeMorePenaltyInterest.in", method = { RequestMethod.POST })
    public void addBankChargeMorePenaltyInterest(BankChargeMorePenaltyInterest bankChargeMorePenaltyInterest) throws FlatException {
        try {
            parameterSurface.addNewParameter(bankChargeMorePenaltyInterest.getBankChargeMorePenaltyInterestCode(), bankChargeMorePenaltyInterest);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankChargeMorePenaltyInterest.addBankChargeMorePenaltyInterestFail", "新增银行多记罚息失败");
        }
    }

    /**
     * <p>
     * 加载修改银行多记罚息页面
     * </p>
     * @param bankChargeMorePenaltyInterestCode
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankChargeMorePenaltyInterestEditPage.in")
    public ModelAndView bankChargeMorePenaltyInterestEditPage(String bankChargeMorePenaltyInterestCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("bankChargeMorePenaltyInterest/bankChargeMorePenaltyInterestEdit");
            view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));
            view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
            view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
          //结算账号
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
            BankChargeMorePenaltyInterest bankChargeMorePenaltyInterest = parameterSurface.getParameterObject(bankChargeMorePenaltyInterestCode, BankChargeMorePenaltyInterest.class);
            view.addObject("bankChargeMorePenaltyInterest", bankChargeMorePenaltyInterest);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestEditPageFail","加载修改银行多记罚息页面失败");
        }
    }

    /**
     * <p>
     * 修改银行多记罚息
     * </p>
     * @param bankChargeMorePenaltyInterest
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updBankChargeMorePenaltyInterest.in", method = { RequestMethod.POST })
    public void updBankChargeMorePenaltyInterest(BankChargeMorePenaltyInterest bankChargeMorePenaltyInterest) throws FlatException {
        try {
            parameterSurface.updateParameterObject(bankChargeMorePenaltyInterest.getBankChargeMorePenaltyInterestCode(), bankChargeMorePenaltyInterest);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), bankChargeMorePenaltyInterest.getBankChargeMorePenaltyInterestCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankChargeMorePenaltyInterest.updBankChargeMorePenaltyInterestFail", "修改银行多记罚息失败");
        }
    }

    /**
     * <p>
     * 删除银行多记罚息
     * </p>
     * @param bankChargeMorePenaltyInterestCodes
     */
    @ResponseBody
    @RequestMapping(value = "delBankChargeMorePenaltyInterest.in", method = { RequestMethod.POST })
    public void delBankChargeMorePenaltyInterests(@RequestBody List<String> bankChargeMorePenaltyInterestCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(bankChargeMorePenaltyInterestCodes, BankChargeMorePenaltyInterest.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankChargeMorePenaltyInterest.delBankChargeMorePenaltyInterestFail", "删除银行多记罚息失败");
        }
    }

    /**
     * <p>
     * 加载银行多记罚息明细页面
     * </p>
     * @param bankChargeMorePenaltyInterestCode
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankChargeMorePenaltyInterestDetailPage.in")
    public ModelAndView bankChargeMorePenaltyInterestDetailPage(String bankChargeMorePenaltyInterestCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("bankChargeMorePenaltyInterest/bankChargeMorePenaltyInterestDetail");
            view.addObject("factory", bankChargeMorePenaltyInterestCode == null);
            BankChargeMorePenaltyInterest bankChargeMorePenaltyInterest = parameterSurface.getParameterObject(bankChargeMorePenaltyInterestCode==null?code:bankChargeMorePenaltyInterestCode, BankChargeMorePenaltyInterest.class);
            if(bankChargeMorePenaltyInterest.getBillingCycle().equals(BillingCycle.Z)){
                view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(bankChargeMorePenaltyInterest.balanceDate));
            }else{
                view.addObject("balanceDate", bankChargeMorePenaltyInterest.getBalanceDate() );
            }
            view.addObject("bankChargeMorePenaltyInterest", bankChargeMorePenaltyInterest);
            view.addObject("partnerType", KC.Enum.getI18nLabel(bankChargeMorePenaltyInterest.getPartnerType()));
            view.addObject("billingCycle", KC.Enum.getI18nLabel(bankChargeMorePenaltyInterest.getBillingCycle()));
            //所属机构
            PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(bankChargeMorePenaltyInterest.getOrganization(),PcmOrgParameter.class);
            view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
            ChannelPartnerType type = bankChargeMorePenaltyInterest.getPartnerType();
            if(type!=null){
                //资产方
                if(type.equals(ChannelPartnerType.ZC)){
                    AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(bankChargeMorePenaltyInterest.getPartnerCode(),AssetSideInfo.class);
                    view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
                }
                //资金方
                if(type.equals(ChannelPartnerType.ZJ)){
                    FundSideInfo fundSideInfo = parameterSurface.getParameterObject(bankChargeMorePenaltyInterest.getPartnerCode(),FundSideInfo.class);
                    view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
                }
                //服务方
                if(type.equals(ChannelPartnerType.FW)){
                    ServerInfo serverInfo = parameterSurface.getParameterObject(bankChargeMorePenaltyInterest.getPartnerCode(),ServerInfo.class);
                    view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
                }
                //渠道方 
                if(type.equals(ChannelPartnerType.QD)){
                    ChannelInfo channelInfo = parameterSurface.getParameterObject(bankChargeMorePenaltyInterest.getPartnerCode(),ChannelInfo.class);
                    view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
                }
            }
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankChargeMorePenaltyInterest.bankChargeMorePenaltyInterestDetailPageFail", "加载银行多记罚息详情页面失败");
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
            parameterSurface.getParameterObject(BankChargeMorePenaltyInterest.class)
                    .stream().collect(Collectors.toMap(
                    BankChargeMorePenaltyInterest::getBankChargeMorePenaltyInterestCode, BankChargeMorePenaltyInterest::getBankChargeMorePenaltyInterestDesc));
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
        BankChargeMorePenaltyInterest parameterObject = parameterSurface.getParameterObject(code,BankChargeMorePenaltyInterest.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getBankChargeMorePenaltyInterestCode());
        list.add(parameterObject.getBankChargeMorePenaltyInterestDesc());
        return list;
    }
}
