package cn.sunline.pcm.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.controller.common.Fee;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.PcmOrgParameter;
import cn.sunline.pcm.definition.PlatformCoupon;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.enums.BanceDate;
import cn.sunline.pcm.definition.enums.BillingCycle;
import cn.sunline.pcm.definition.enums.ChannelPartnerType;

/** 
 * <p>
 * 平台优惠券 Controller 层
 * </p>
 * @version 1.0 2019-08-13 修改内容:初版
 */ 
@Controller
@RequestMapping("platformCoupon")
public class PlatformCouponController extends Fee {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	

	/** 
	 * <p>
	 * 平台优惠券 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("platformCouponQueryPage.in")
	public ModelAndView platformCouponQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("platformCoupon/platformCouponQuery");
			view.addObject("partnerTypeJson", KC.Enum.getI18nLabelMapJson(ChannelPartnerType.class));
			view.addObject("billingCycleJson", KC.Enum.getI18nLabelMapJson(BillingCycle.class));
			//所属机构
			view.addObject("orgMap",parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream().collect(Collectors.toMap(PcmOrgParameter::getOrgCode,x->{
						return x.getOrgCode()+ '-' +x.getOrgName(); 
					})));
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
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
			view.addObject("platformCoupon", new PlatformCoupon());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"platformCoupon.platformCouponQueryPageFail","加载平台优惠券列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询平台优惠券 列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPlatformCouponList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPlatformCouponList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PlatformCoupon.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"platformCoupon.queryPlatformCouponListFail","查询平台优惠券列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增平台优惠券 页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("platformCouponAddPage.in")
	public ModelAndView platformCouponAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("platformCoupon/platformCouponAdd");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			//所属机构
			view.addObject("orgMap",parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream().collect(Collectors.toMap(PcmOrgParameter::getOrgCode,x->{
						return x.getOrgCode()+ '-' +x.getOrgName(); 
					})));
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			view.addObject("fundSideInfoMap",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-' +x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoMap",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方
			view.addObject("channelInfoMap",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoMap",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			view.addObject("platformCoupon", new PlatformCoupon());
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"platformCoupon.platformCouponAddPageFail","加载新增平台优惠券页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增平台优惠券 
	 * </p>
	 * @param platformCoupon
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPlatformCoupon.in", method = { RequestMethod.POST })
	public void addPlatformCoupon(PlatformCoupon platformCoupon) throws FlatException {
		try {
			parameterSurface.addNewParameter(platformCoupon.getCouponCode(), platformCoupon);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "platformCoupon.addPlatformCouponFail", "新增平台优惠券失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改平台优惠券 页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("platformCouponEditPage.in")
	public ModelAndView platformCouponEditPage(String couponCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("platformCoupon/platformCouponEdit");
			view.addObject("partnerType", KC.Enum.getI18nLabelMap(ChannelPartnerType.class));				
			view.addObject("billingCycle", KC.Enum.getI18nLabelMap(BillingCycle.class));
			view.addObject("banceDate", KC.Enum.getI18nLabelMap(BanceDate.class));
			view.addObject("pcmSettleAccMan", getPcmSettleAccManList());
			//所属机构
			view.addObject("orgMap",parameterSurface.getParameterObject(PcmOrgParameter.class)
					.stream().collect(Collectors.toMap(PcmOrgParameter::getOrgCode,x->{
						return x.getOrgCode()+ '-' +x.getOrgName(); 
					})));
			/**
			 * 合作编码，四个map都要返回，根据合作类型来确定展示那个map值
			 */
			//资金方
			view.addObject("fundSideInfoMap",new JSONObject(parameterSurface.getParameterObject(FundSideInfo.class)
					.stream().collect(Collectors.toMap(FundSideInfo::getFundSideCode,x->{
						return x.getFundSideCode()+ '-' +x.getFundSideDesc();
					}))));
			//资产方
			view.addObject("assetSideInfoMap",new JSONObject(parameterSurface.getParameterObject(AssetSideInfo.class)
					.stream().collect(Collectors.toMap(AssetSideInfo::getAssetSideCode,x->{
						return x.getAssetSideCode()+ '-' +x.getAssetSideDesc();
					}))));
			//渠道方
			view.addObject("channelInfoMap",new JSONObject(parameterSurface.getParameterObject(ChannelInfo.class)
					.stream().collect(Collectors.toMap(ChannelInfo::getChannelCode,x->{
						return x.getChannelCode()+ '-' +x.getChannelDesc();
					}))));
			//服务方  
			view.addObject("serverInfoMap",new JSONObject(parameterSurface.getParameterObject(ServerInfo.class)
					.stream().collect(Collectors.toMap(ServerInfo::getServerCode,x->{
						return x.getServerCode()+ '-' +x.getServerDesc();
					}))));
			PlatformCoupon platformCoupon = parameterSurface.getParameterObject(couponCode, PlatformCoupon.class);
			view.addObject("platformCoupon", platformCoupon);
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"platformCoupon.platformCouponEditPageFail","加载修改平台优惠券页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改平台优惠券 
	 * </p>
	 * @param platformCoupon
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPlatformCoupon.in", method = { RequestMethod.POST })
	public void updPlatformCoupon(PlatformCoupon platformCoupon) throws FlatException {
		try {
			parameterSurface.updateParameterObject(platformCoupon.getCouponCode(), platformCoupon);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), platformCoupon.getCouponCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "platformCoupon.updPlatformCouponFail", "修改平台优惠券失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除平台优惠券 
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPlatformCoupon.in", method = { RequestMethod.POST })
	public void delPlatformCoupons(@RequestBody List<String> couponCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(couponCodes, PlatformCoupon.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "platformCoupon.delPlatformCouponFail", "删除平台优惠券失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载平台优惠券 明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("platformCouponDetailPage.in")
	public ModelAndView platformCouponDetailPage(String couponCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("platformCoupon/platformCouponDetail");
			view.addObject("factory",couponCode == null);
			PlatformCoupon platformCoupon = parameterSurface.getParameterObject(couponCode==null?code:couponCode, PlatformCoupon.class);
			platformCoupon.setTransferAccount(getPcmSettleAccMan(platformCoupon.getTransferAccount()));
			platformCoupon.setTransferToAccount(getPcmSettleAccMan(platformCoupon.getTransferToAccount()));
			view.addObject("platformCoupon", platformCoupon);
			view.addObject("partnerType", KC.Enum.getI18nLabel(platformCoupon.getPartnerType()));
			view.addObject("billingCycle", KC.Enum.getI18nLabel(platformCoupon.getBillingCycle()));
			if(platformCoupon.getBillingCycle().equals(BillingCycle.Z)){
				view.addObject("balanceDate",KC.Enum.getI18nLabelMap(BanceDate.class).get(platformCoupon.balanceDate));
			}else{
				view.addObject("balanceDate", platformCoupon.getBalanceDate() );
			}
			
			//所属机构
			PcmOrgParameter pcmOrgParameter = parameterSurface.getParameterObject(platformCoupon.getOrganization(),PcmOrgParameter.class);
			if (pcmOrgParameter!=null) {
				view.addObject("org",pcmOrgParameter.orgCode+"-"+pcmOrgParameter.getOrgName());
			}else {
				view.addObject("org","");
			}
			
			ChannelPartnerType type = platformCoupon.getPartnerType();
			if(type!=null){
				//资产方
				if(type.equals(ChannelPartnerType.ZC)){
					AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(platformCoupon.getPartnerCode(),AssetSideInfo.class);
					view.addObject("partner", assetSideInfo.getAssetSideCode()+"-"+assetSideInfo.getAssetSideDesc());
				}
				//资金方
				if(type.equals(ChannelPartnerType.ZJ)){
					FundSideInfo fundSideInfo = parameterSurface.getParameterObject(platformCoupon.getPartnerCode(),FundSideInfo.class);
					view.addObject("partner", fundSideInfo.getFundSideCode()+"-"+fundSideInfo.getFundSideDesc());
				}
				//服务方
				if(type.equals(ChannelPartnerType.FW)){
					ServerInfo serverInfo = parameterSurface.getParameterObject(platformCoupon.getPartnerCode(),ServerInfo.class);
					view.addObject("partner", serverInfo.getServerCode()+"-"+serverInfo.getServerDesc());
				}
				//渠道方 
				if(type.equals(ChannelPartnerType.QD)){
					ChannelInfo channelInfo = parameterSurface.getParameterObject(platformCoupon.getPartnerCode(),ChannelInfo.class);
					view.addObject("partner", channelInfo.getChannelCode()+"-"+channelInfo.getChannelDesc());
				}
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "platformCoupon.platformCouponDetailPageFail", "加载平台优惠券详情页面失败");
		}
	}
	
}