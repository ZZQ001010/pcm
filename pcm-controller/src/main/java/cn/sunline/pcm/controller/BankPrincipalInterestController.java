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
import cn.sunline.pcm.controller.common.constent.ParameterFlags;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.BankPrincipalInterest;
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
 * 银行本息 Controller 层
 * </p>
 * @version 1.0 2019-08-26 修改内容:初版
 */
@Controller
@RequestMapping("bankPrincipalInterest")
public class BankPrincipalInterestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParameterSurface parameterSurface;


    /**
     * <p>
     * 银行本息 列表页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @SuppressWarnings("all")
    @RequestMapping("bankPrincipalInterestQueryPage.in")
    public ModelAndView bankPrincipalInterestQueryPage(HttpServletRequest request) throws FlatException{
        try {
            ModelAndView view = KW.mvc.forwardView("bankPrincipalInterest/bankPrincipalInterestQuery");
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
            view.addObject("bankPrincipalInterest", new BankPrincipalInterest());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankPrincipalInterest.bankPrincipalInterestQueryPageFail","加载银行本息列表页面失败");
        }
    }

    /**
     * <p>
     * 查询银行本息列表
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value="queryBankPrincipalInterestList.in", method = { RequestMethod.POST })
    public FetchResponse<?> queryBankPrincipalInterestList(FetchRequest request) throws FlatException{
        try {
            return parameterSurface.getFetchResponse(request, BankPrincipalInterest.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankPrincipalInterest.queryBankPrincipalInterestListFail","查询银行本息列表失败");
        }
    }

    /**
     * <p>
     * 加载新增银行本息页面
     * </p>
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankPrincipalInterestAddPage.in")
    public ModelAndView bankPrincipalInterestAddPage(HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("bankPrincipalInterest/bankPrincipalInterestAdd");
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
            
            
            //结算账号
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
            
            view.addObject("serverInfoMap",new JSONObject(serverInfoMap));
            view.addObject("bankPrincipalInterest", new BankPrincipalInterest());
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankPrincipalInterest.bankPrincipalInterestAddPageFail","加载新增银行本息页面异常");
        }
    }

    /**
     * <p>
     * 新增银行本息
     * </p>
     * @param bankPrincipalInterest
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "addBankPrincipalInterest.in", method = { RequestMethod.POST })
    public void addBankPrincipalInterest(BankPrincipalInterest bankPrincipalInterest) throws FlatException {
        try {
            parameterSurface.addNewParameter(bankPrincipalInterest.getBankPrincipalInterestCode(), bankPrincipalInterest);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankPrincipalInterest.addBankPrincipalInterestFail", "新增银行本息失败");
        }
    }

    /**
     * <p>
     * 加载修改银行本息页面
     * </p>
     * @param bankPrincipalInterestCode
     * @param request
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankPrincipalInterestEditPage.in")
    public ModelAndView bankPrincipalInterestEditPage(String bankPrincipalInterestCode, HttpServletRequest request) throws FlatException {
        try {
            ModelAndView view = KW.mvc.forwardView("bankPrincipalInterest/bankPrincipalInterestEdit");
            
            //结算账号
            view.addObject("pcmSettleAccMan",
            		parameterSurface.getParameterObject(PcmSettleAccMan.class)
            		.stream().collect(Collectors.toMap(PcmSettleAccMan::getSettleAccCode,
            				sett->sett.getSettleAccCode()+ParameterFlags.SHORT_CROSS+sett.getSettleAccDes())));
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
            BankPrincipalInterest bankPrincipalInterest = parameterSurface.getParameterObject(bankPrincipalInterestCode, BankPrincipalInterest.class);
            view.addObject("bankPrincipalInterest", bankPrincipalInterest);
            return view;
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e,"bankPrincipalInterest.bankPrincipalInterestEditPageFail","加载修改银行本息页面失败");
        }
    }

    /**
     * <p>
     * 修改银行本息
     * </p>
     * @param bankPrincipalInterest
     * @throws FlatException
     */
    @ResponseBody
    @RequestMapping(value = "updBankPrincipalInterest.in", method = { RequestMethod.POST })
    public void updBankPrincipalInterest(BankPrincipalInterest bankPrincipalInterest) throws FlatException {
        try {
            parameterSurface.updateParameterObject(bankPrincipalInterest.getBankPrincipalInterestCode(), bankPrincipalInterest);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage(), bankPrincipalInterest.getBankPrincipalInterestCode().toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankPrincipalInterest.updBankPrincipalInterestFail", "修改银行本息失败");
        }
    }

    /**
     * <p>
     * 删除银行本息
     * </p>
     * @param bankPrincipalInterestCodes
     */
    @ResponseBody
    @RequestMapping(value = "delBankPrincipalInterest.in", method = { RequestMethod.POST })
    public void delBankPrincipalInterests(@RequestBody List<String> bankPrincipalInterestCodes) throws FlatException {
        try {
            parameterSurface.deleteParameterObjectList(bankPrincipalInterestCodes, BankPrincipalInterest.class);
        } catch (ProcessException e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FlatException(e, "bankPrincipalInterest.delBankPrincipalInterestFail", "删除银行本息失败");
        }
    }

    /**
     * <p>
     * 加载银行本息明细页面
     * </p>
     * @param bankPrincipalInterestCode
     * @return
     * @throws FlatException
     */
    @RequestMapping("bankPrincipalInterestDetailPage.in")
    public ModelAndView bankPrincipalInterestDetailPage(String bankPrincipalInterestCode,String code,ModelAndView view) throws FlatException {
        try {
            view = KW.mvc.forwardView("bankPrincipalInterest/bankPrincipalInterestDetail");
            view.addObject("factory", bankPrincipalInterestCode == null);
            BankPrincipalInterest bankPrincipalInterest = parameterSurface.getParameterObject(bankPrincipalInterestCode==null?code:bankPrincipalInterestCode, BankPrincipalInterest.class);
            if(null != bankPrincipalInterest){
            	if(BillingCycle.Z.equals(bankPrincipalInterest.getBillingCycle())){
                    view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(bankPrincipalInterest.balanceDate));
                }else{
                    view.addObject("balanceDate", bankPrincipalInterest.getBalanceDate() );
                }
                view.addObject("bankPrincipalInterest", bankPrincipalInterest);
               view.addObject("frequencyOfCharge", KC.Enum.getI18nLabel(bankPrincipalInterest.getFrequencyOfCharge()));
                view.addObject("partnerType", KC.Enum.getI18nLabel(bankPrincipalInterest.getPartnerType()));
                view.addObject("billingCycle", KC.Enum.getI18nLabel(bankPrincipalInterest.getBillingCycle()));
                //所属机构
                PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(bankPrincipalInterest.getOrganization(),PcmOrgParameter.class);
                view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
                ChannelPartnerType type = bankPrincipalInterest.getPartnerType();
                if(type!=null){
                    //资产方
                    if(ChannelPartnerType.ZC.equals(type)){
                        AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(bankPrincipalInterest.getPartnerCode(),AssetSideInfo.class);
                        view.addObject("partner", assetSideInfo==null?"":assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
                    }
                    //资金方
                    if(ChannelPartnerType.ZJ.equals(type)){
                        FundSideInfo fundSideInfo = parameterSurface.getParameterObject(bankPrincipalInterest.getPartnerCode(),FundSideInfo.class);
                        view.addObject("partner", fundSideInfo==null?"":fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
                    }
                    //服务方
                    if(ChannelPartnerType.FW.equals(type)){
                        ServerInfo serverInfo = parameterSurface.getParameterObject(bankPrincipalInterest.getPartnerCode(),ServerInfo.class);
                        view.addObject("partner", serverInfo==null?"":serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
                    }
                    //渠道方 
                    if(ChannelPartnerType.QD.equals(type)){
                        ChannelInfo channelInfo = parameterSurface.getParameterObject(bankPrincipalInterest.getPartnerCode(),ChannelInfo.class);
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
            throw new FlatException(e, "bankPrincipalInterest.bankPrincipalInterestDetailPageFail", "加载银行本息详情页面失败");
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
            parameterSurface.getParameterObject(BankPrincipalInterest.class)
                    .stream().collect(Collectors.toMap(
                    BankPrincipalInterest::getBankPrincipalInterestCode, BankPrincipalInterest::getBankPrincipalInterestDesc));
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
        BankPrincipalInterest parameterObject = parameterSurface.getParameterObject(code,BankPrincipalInterest.class);
        List<String> list = new ArrayList<>();
        list.add(parameterObject.getBankPrincipalInterestCode());
        list.add(parameterObject.getBankPrincipalInterestDesc());
        return list;
    }
}
