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
import cn.sunline.common.address.AddressHelperFacility;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.Sum;
import cn.sunline.pcm.surface.api.ParameterSurface;

/** 
 * <p>
 * 渠道方基本信息 Controller 层
 * </p>
 * @version 1.0 2019-08-01 修改内容:初版
 */ 
@Controller
@RequestMapping("channelInfo")
public class ChannelInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private AddressHelperFacility addressHelperFacility;

	/** 
	 * <p>
	 * 渠道方基本信息 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelInfoQueryPage.in")
	public ModelAndView channelInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("channelInfo/channelInfoQuery");
			view.addObject("assetSideWarrantWayJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));
			view.addObject("companyTypeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.CompanyType.class));
			view.addObject("channelInfo", new ChannelInfo());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelInfo.channelInfoQueryPageFail","加载渠道方基本信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询渠道方基本信息列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryChannelInfoList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryChannelInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, ChannelInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelInfo.queryChannelInfoListFail","查询渠道方基本信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增渠道方基本信息页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelInfoAddPage.in")
	public ModelAndView channelInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("channelInfo/channelInfoAdd");
			view.addObject("assetSideWarrantWay", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			view.addObject("channelInfo", new ChannelInfo());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelInfo.channelInfoAddPageFail","加载新增渠道方基本信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增渠道方基本信息
	 * </p>
	 * @param channelInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addChannelInfo.in", method = { RequestMethod.POST })
	public void addChannelInfo(ChannelInfo channelInfo) throws FlatException {
		try {
			parameterSurface.addNewParameter(channelInfo.getChannelCode(), channelInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelInfo.addChannelInfoFail", "新增渠道方基本信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改渠道方基本信息页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelInfoEditPage.in")
	public ModelAndView channelInfoEditPage(String channelCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("channelInfo/channelInfoEdit");
			view.addObject("assetSideWarrantWay", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));
			ChannelInfo channelInfo = parameterSurface.getParameterObject(channelCode, ChannelInfo.class);
			view.addObject("channelInfo", channelInfo);
			
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			view.addObject("city",addressHelperFacility.loadCity(channelInfo.getResidence().getProvince()));
			view.addObject("microdistrict",addressHelperFacility.loadDistricts(channelInfo.getResidence().getCity()));
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"channelInfo.channelInfoEditPageFail","加载修改渠道方基本信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改渠道方基本信息
	 * </p>
	 * @param channelInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updChannelInfo.in", method = { RequestMethod.POST })
	public void updChannelInfo(ChannelInfo channelInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(channelInfo.getChannelCode(), channelInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), channelInfo.getChannelCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelInfo.updChannelInfoFail", "修改渠道方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除渠道方基本信息
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delChannelInfo.in", method = { RequestMethod.POST })
	public void delChannelInfos(@RequestBody List<String> channelCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(channelCodes, ChannelInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelInfo.delChannelInfoFail", "删除渠道方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载渠道方基本信息明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("channelInfoDetailPage.in")
	public ModelAndView channelInfoDetailPage(String channelCode,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("channelInfo/channelInfoDetail");
			view.addObject("factroy",code==null);
			ChannelInfo channelInfo = parameterSurface.getParameterObject(channelCode==null?code:channelCode, ChannelInfo.class);
			view.addObject("channelInfo", channelInfo);
			//实收资本
			Sum paidInCapital = channelInfo.getPaidInCapital();
			String currencyCd = paidInCapital.getCurrencyCd();
			CurrencyCd currency = parameterSurface.getParameterObject(paidInCapital.getCurrencyCd(),CurrencyCd.class);
			
			String paidInCapitalStr = paidInCapital.getSumNum()+" "+currency.getDescription();
			view.addObject("paidInCapital", paidInCapitalStr);
			//注册资本
			Sum registerMoney = channelInfo.getRegisterMoney();
			
			String registerMoneyStr = registerMoney.getSumNum()
						+" "+parameterSurface.getParameterObject(
								registerMoney.getCurrencyCd(),CurrencyCd.class).getDescription(); 
			
			view.addObject("registerMoney",registerMoneyStr);
			//地址
			view.addObject("addr",channelInfo.getResidence().toString(addressHelperFacility));
			view.addObject("companyType", KC.Enum.getI18nLabel(channelInfo.getCompanyType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "channelInfo.channelInfoDetailPageFail", "加载渠道方基本信息详情页面失败");
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
                    parameterSurface.getParameterObject(ChannelInfo.class).forEach(
                                    item->resMap.put(item.getChannelCode(),item.getChannelDesc()));
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
	   ChannelInfo parameterObject = parameterSurface.getParameterObject(code,ChannelInfo.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getChannelCode());
                   list.add(parameterObject.getChannelDesc());
                   //list.add(KC.Enum.getI18nLabel(parameterObject.getAssetSideType()));
                   return list;
   }
}