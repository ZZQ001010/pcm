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
import org.springframework.web.bind.annotation.GetMapping;
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
import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.Sum;
import cn.sunline.pcm.definition.enums.AssetSideType;
import cn.sunline.pcm.definition.enums.AssetSideWarrantWay;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/**
 *  资金方基本信息控制层
 * @author fgy
 * @date 2019年7月29日
 *
 */
@Controller
@RequestMapping("fundSideInfo")
public class FundSideInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private AddressHelperFacility addressHelperFacility;
	
	
	/** 
	 * <p>
	 * 资金方基本信息
 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@GetMapping("query.in")
	public ModelAndView fundSideInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			
			ModelAndView view = KW.mvc.forwardView("fundSideInfo/query");
			view.addObject("fundSideTypeJson",KC.Enum.getI18nLabelMapJson(AssetSideType.class));
			view.addObject("fundSideWarrantWayJson", KC.Enum.getI18nLabelMapJson(AssetSideWarrantWay.class));
			view.addObject("companyTypeJson", KC.Enum.getI18nLabelMapJson(cn.sunline.pcm.definition.enums.CompanyType.class));
			view.addObject("fundSideInfo", new FundSideInfo());

			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideInfo.fundSideInfoQueryPageFail","加载资金方基本信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询资金方基本信息
列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="list.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryfundSideInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, FundSideInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"fundSideInfo.queryfundSideInfoListFail","查询资金方基本信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增资金方基本信息
页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("addPage.in")
	public ModelAndView fundSideInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideInfo/add");
			view.addObject("fundSideType", KC.Enum.getI18nLabelMap(AssetSideType.class));				
			view.addObject("fundSideWarrantWay", KC.Enum.getI18nLabelMap(AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));				
			view.addObject("fundSideInfo", new FundSideInfo());
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
			throw new FlatException(e,"fundSideInfo.fundSideInfoAddPageFail","加载新增资金方基本信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增资金方基本信息

	 * </p>
	 * @param fundSideInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "add.in", method = { RequestMethod.POST })
	public void addfundSideInfo(FundSideInfo fundSideInfo) throws FlatException {
		try {
			
			parameterSurface.addNewParameter(fundSideInfo.getFundSideCode(), fundSideInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideInfo.addfundSideInfoFail", "新增资金方基本信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改资金方基本信息
页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("edit.in")
	public ModelAndView fundSideInfoEditPage(String fundSideCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("fundSideInfo/edit");
			view.addObject("fundSideType", KC.Enum.getI18nLabelMap(AssetSideType.class));				
			view.addObject("fundSideWarrantWay", KC.Enum.getI18nLabelMap(AssetSideWarrantWay.class));				
			view.addObject("companyType", KC.Enum.getI18nLabelMap(cn.sunline.pcm.definition.enums.CompanyType.class));				
			FundSideInfo fundSideInfo = parameterSurface.getParameterObject(fundSideCode, FundSideInfo.class);
			view.addObject("fundSideInfo", fundSideInfo);
			
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			view.addObject("city",addressHelperFacility.loadCity(fundSideInfo.getResidence().getProvince()));
			view.addObject("microdistrict",addressHelperFacility.loadDistricts(fundSideInfo.getResidence().getCity()));
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
			throw new FlatException(e,"fundSideInfo.fundSideInfoEditPageFail","加载修改资金方基本信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改资金方基本信息

	 * </p>
	 * @param fundSideInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "upd.in", method = { RequestMethod.POST })
	public void updfundSideInfo(FundSideInfo fundSideInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(fundSideInfo.getFundSideCode(), fundSideInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), fundSideInfo.getFundSideCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideInfo.updfundSideInfoFail", "修改资金方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除资金方基本信息

	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "del.in", method = { RequestMethod.POST })
	public void delfundSideInfos(@RequestBody List<String> fundSideCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(fundSideCodes, FundSideInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideInfo.delfundSideInfoFail", "删除资金方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载资金方基本信息
明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("fundSideInfoDetailPage.in")
	public ModelAndView fundSideInfoDetailPage(String fundSideCode,String code,ModelAndView view) throws FlatException {
		try {
			 view = KW.mvc.forwardView("fundSideInfo/detail");
			 view.addObject("factroy",code==null);
			FundSideInfo fundSideInfo = parameterSurface.getParameterObject(fundSideCode==null?code:fundSideCode, FundSideInfo.class);
			//实收资本
			Sum paidInCapital = fundSideInfo.getPaidInCapital();
			CurrencyCd currency = parameterSurface.getParameterObject(paidInCapital.getCurrencyCd(),CurrencyCd.class);
			
			String paidInCapitalStr = paidInCapital.getSumNum()+" "+currency.getDescription();
			view.addObject("paidInCapital", paidInCapitalStr);
			//注册资本
			Sum registerMoney = fundSideInfo.getRegisterMoney();
			
			String registerMoneyStr = registerMoney.getSumNum()
						+" "+parameterSurface.getParameterObject(
								registerMoney.getCurrencyCd(),CurrencyCd.class).getDescription(); 
			
			view.addObject("registerMoney",registerMoneyStr);
			//地址
			view.addObject("addr",fundSideInfo.getResidence().toString(addressHelperFacility));
			
			view.addObject("fundSideInfo", fundSideInfo);
			view.addObject("companyType", KC.Enum.getI18nLabel(fundSideInfo.getCompanyType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "fundSideInfo.fundSideInfoDetailPageFail", "加载资金方基本信息详情页面失败");
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
                    parameterSurface.getParameterObject(FundSideInfo.class).forEach(
                                    item->resMap.put(item.getFundSideCode(),item.getFundSideDesc()));
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
	   FundSideInfo parameterObject = parameterSurface.getParameterObject(code,FundSideInfo.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getFundSideCode());
                   list.add(parameterObject.getFundSideDesc());
                   return list;
   }
	
	
}
