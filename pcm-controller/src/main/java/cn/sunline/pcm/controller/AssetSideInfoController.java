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
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import net.bytebuddy.description.modifier.ParameterManifestation;
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.AssetSideRiskCtrl;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.Sum;

/** 
 * <p>
 * 资产方基本信息 控制层
 Controller 层
 * </p>
 * @author zzq
 * @version 1.0 2019-07-10 修改内容:初版
 */ 
@Controller
@RequestMapping("assetSideInfo")
public class AssetSideInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private AddressHelperFacility addressHelperFacility;
	
	
	/** 
	 * <p>
	 * 资产方基本信息
 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideInfoQueryPage.in")
	public ModelAndView assetSideInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			
			ModelAndView view = KW.mvc.forwardView("assetSideInfo/assetSideInfoQuery");
			//view.addObject("assetSideTypeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.AssetSideType.class));
			view.addObject("assetSideWarrantWayJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));
			view.addObject("companyTypeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.CompanyType.class));
			view.addObject("assetSideInfo", new AssetSideInfo());

			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideInfo.assetSideInfoQueryPageFail","加载资产方基本信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资产方基本信息
列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryAssetSideInfoList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryAssetSideInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, AssetSideInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"assetSideInfo.queryAssetSideInfoListFail","查询资产方基本信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资产方基本信息
页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideInfoAddPage.in")
	public ModelAndView assetSideInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideInfo/assetSideInfoAdd");
			//view.addObject("assetSideType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideType.class));
			view.addObject("assetSideWarrantWay", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));				
			view.addObject("assetSideInfo", new AssetSideInfo());
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
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
			throw new FlatException(e,"assetSideInfo.assetSideInfoAddPageFail","加载新增资产方基本信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资产方基本信息

	 * </p>
	 * @param assetSideInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addAssetSideInfo.in", method = { RequestMethod.POST })
	public void addAssetSideInfo(AssetSideInfo assetSideInfo) throws FlatException {
		try {
			
			parameterSurface.addNewParameter(assetSideInfo.getAssetSideCode(), assetSideInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideInfo.addAssetSideInfoFail", "新增资产方基本信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资产方基本信息
页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideInfoEditPage.in")
	public ModelAndView assetSideInfoEditPage(String assetSideCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("assetSideInfo/assetSideInfoEdit");
			//view.addObject("assetSideType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideType.class));
			view.addObject("assetSideWarrantWay", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));				
			AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(assetSideCode, AssetSideInfo.class);
			view.addObject("assetSideInfo", assetSideInfo);
			
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			view.addObject("city",addressHelperFacility.loadCity(assetSideInfo.getResidence().getProvince()));
			view.addObject("microdistrict",addressHelperFacility.loadDistricts(assetSideInfo.getResidence().getCity()));
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
			throw new FlatException(e,"assetSideInfo.assetSideInfoEditPageFail","加载修改资产方基本信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资产方基本信息

	 * </p>
	 * @param assetSideInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updAssetSideInfo.in", method = { RequestMethod.POST })
	public void updAssetSideInfo(AssetSideInfo assetSideInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(assetSideInfo.getAssetSideCode(), assetSideInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), assetSideInfo.getAssetSideCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideInfo.updAssetSideInfoFail", "修改资产方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资产方基本信息

	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delAssetSideInfo.in", method = { RequestMethod.POST })
	public void delAssetSideInfos(@RequestBody List<String> assetSideCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(assetSideCodes, AssetSideInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideInfo.delAssetSideInfoFail", "删除资产方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资产方基本信息
明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("assetSideInfoDetailPage.in")
	public ModelAndView assetSideInfoDetailPage(String assetSideCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("assetSideInfo/assetSideInfoDetail");
			 view.addObject("factory",code==null);
			AssetSideInfo assetSideInfo = parameterSurface.getParameterObject(assetSideCode==null?code:assetSideCode, AssetSideInfo.class);
			//实收资本
			Sum paidInCapital = assetSideInfo.getPaidInCapital();
			String currencyCd = paidInCapital.getCurrencyCd();
			CurrencyCd currency = parameterSurface.getParameterObject(paidInCapital.getCurrencyCd(),CurrencyCd.class);
			
			String paidInCapitalStr = paidInCapital.getSumNum()+" "+currency.getDescription();
			view.addObject("paidInCapital", paidInCapitalStr);
			//注册资本
			Sum registerMoney = assetSideInfo.getRegisterMoney();
			
			String registerMoneyStr = registerMoney.getSumNum()
						+" "+parameterSurface.getParameterObject(
								registerMoney.getCurrencyCd(),CurrencyCd.class).getDescription(); 
			
			view.addObject("registerMoney",registerMoneyStr);
			//地址
			view.addObject("addr",assetSideInfo.getResidence().toString(addressHelperFacility));
			
			view.addObject("assetSideInfo", assetSideInfo);
			//view.addObject("assetSideType", KC.Enum.getI18nLabel(assetSideInfo.getAssetSideType()));
			view.addObject("assetSideWarrantWay", KC.Enum.getI18nLabel(assetSideInfo.getAssetSideWarrantWay()));
			view.addObject("companyType", KC.Enum.getI18nLabel(assetSideInfo.getCompanyType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "assetSideInfo.assetSideInfoDetailPageFail", "加载资产方基本信息详情页面失败");
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
                    parameterSurface.getParameterObject(AssetSideInfo.class).forEach(
                                    item->resMap.put(item.getAssetSideCode(),item.getAssetSideDesc()));
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
	   AssetSideInfo parameterObject = parameterSurface.getParameterObject(code,AssetSideInfo.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getAssetSideCode());
                   list.add(parameterObject.getAssetSideDesc());
                   //list.add(KC.Enum.getI18nLabel(parameterObject.getAssetSideType()));
                   return list;
   }
	

}