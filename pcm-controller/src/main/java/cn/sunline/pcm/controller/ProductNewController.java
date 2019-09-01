package cn.sunline.pcm.controller;

import cn.sunline.common.KC;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.Product;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.Brand;
import cn.sunline.ppy.dictionary.enums.CardClass;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/** 
 * <p>
 * 产品参数管理 Controller 层
 * </p>
 * @version 1.0 2017-12-04 xiongyuanyuan 修改内容:初版
 */ 
@Controller
@RequestMapping("productNew")
public class ProductNewController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	/** 
	 * <p>
	 * 产品参数管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productQueryNewPage.in")
	public ModelAndView productQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("productNew/productQueryNew");
			view.addObject("brandJson", KC.Enum.getI18nLabelMapJson(Brand.class));
			view.addObject("brand", KC.Enum.getI18nLabelMap(Brand.class));				
			view.addObject("productTypeJson", KC.Enum.getI18nLabelMapJson(ProductType.class));
			view.addObject("productType", KC.Enum.getI18nLabelMap(ProductType.class));				
			view.addObject("cardClassJson", KC.Enum.getI18nLabelMapJson(CardClass.class));
			view.addObject("cardClass", KC.Enum.getI18nLabelMap(CardClass.class));				
			view.addObject("fabricationIndJson", KC.Enum.getI18nLabelMapJson(Indicator.class));
			view.addObject("fabricationInd", KC.Enum.getI18nLabelMap(Indicator.class));				
			view.addObject("product", new Product());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.productQueryPageFail","加载产品参数管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询产品参数管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryProductNewList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryProductList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, Product.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.queryProductListFail","查询产品参数管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增产品参数管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productAddPage.in")
	public ModelAndView productAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("product/productAdd");
			view.addObject("brand", KC.Enum.getI18nLabelMap(Brand.class));				
			view.addObject("productType", KC.Enum.getI18nLabelMap(ProductType.class));				
			view.addObject("cardClass", KC.Enum.getI18nLabelMap(CardClass.class));	
			Map<String, String> map = KC.Enum.getI18nLabelMap(Indicator.class);
			view.addObject("fabricationInd", map);	
			view.addObject("isPbocInfoMerged", map);	
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap);	
			view.addObject("product", new Product());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.productAddPageFail","加载新增产品参数管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增产品参数管理
	 * </p>
	 * @param product
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addProduct.in", method = { RequestMethod.POST })
	public void addProduct(Product product) throws FlatException {
		try {
			parameterSurface.addNewParameter(product.getProductCode(), product);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.addProductFail", "新增产品参数管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改产品参数管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productEditPage.in")
	public ModelAndView productEditPage(String productCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("product/productEdit");
			view.addObject("brand", KC.Enum.getI18nLabelMap(Brand.class));				
			view.addObject("productType", KC.Enum.getI18nLabelMap(ProductType.class));				
			view.addObject("cardClass", KC.Enum.getI18nLabelMap(CardClass.class));				
			Map<String, String> map = KC.Enum.getI18nLabelMap(Indicator.class);
			view.addObject("fabricationInd", map);	
			view.addObject("isPbocInfoMerged", map);			
			Product product = parameterSurface.getParameterObject(productCode, Product.class);
			//语言环境
			Locale locale = LocaleContextHolder.getLocale();
			boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
			//根据产品类型查到产品大类已经大类下的产品和子产品
			List<BPcmProductGroup> groupList = parameterSurface.getProGroup(product.getProductType().name());
			Map<String, List<Map<String,Serializable>>> unitsMap=new HashMap<String, List<Map<String,Serializable>>>();
			int count =1;
			for (int i = 0; i < groupList.size(); i++) {
				BPcmProductGroup group =groupList.get(i);
				List<Map<String,Serializable>> utisList = parameterSurface.getProUnits(group.getGroupCode());
				if(utisList.size()==0){
					groupList.remove(group);
					i--;
					continue;
				}
				for (Map<String,Serializable> units : utisList) {
					units.put("unitIndex", count++);
					if(!isChinese){
						units.put("unitNameCn", units.get("unitName"));
					}
				}
				if(!isChinese){
					group.setName(group.getGroupName());
				}
				unitsMap.put(group.getGroupCode(), utisList);
			}
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap);
			view.addObject("groupList", groupList);
			view.addObject("unitsMap", unitsMap);
			view.addObject("product", product);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.productEditPageFail","加载修改产品参数管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改产品参数管理
	 * </p>
	 * @param product
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updProduct.in", method = { RequestMethod.POST })
	public void updProduct(@RequestBody Product product) throws FlatException {
		try {
			parameterSurface.updateParameterObject(product.getProductCode(), product);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), product.getProductCode());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.updProductFail", "修改产品参数管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除产品参数管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delProduct.in", method = { RequestMethod.POST })
	public void delProducts(@RequestBody List<String> productCodes) throws FlatException {
		try {
			parameterSurface.delAllRel(productCodes, Product.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.delProductFail", "删除产品参数管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载产品参数管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productDetailPage.in")
	public ModelAndView productDetailPage(String productCode) throws FlatException {
		try {
			//语言环境
			Locale locale = LocaleContextHolder.getLocale();
			boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
			ModelAndView view = KW.mvc.forwardView("product/productDetail");
			Product product = parameterSurface.getParameterObject(productCode, Product.class);
			//根据产品类型查到产品大类已经大类下的产品和子产品
			List<BPcmProductGroup> groupList = parameterSurface.getProGroup(product.getProductType().name());
			Map<String, List<Map<String,Serializable>>> unitsMap=new HashMap<String,List<Map<String,Serializable>>>();
			int count =1;
			for (int i = 0; i < groupList.size(); i++) {
				BPcmProductGroup group =groupList.get(i);
				List<Map<String,Serializable>> utisList = parameterSurface.getProUnits(group.getGroupCode());
				if(utisList.size()==0){
					groupList.remove(group);
					i--;
					continue;
				}
				for (Map<String,Serializable> units : utisList) {
					units.put("unitIndex", count++);
					if(!isChinese){
						units.put("unitNameCn", units.get("unitName"));
					}
				}
				if(!isChinese){
					group.setName(group.getGroupName());
				}
				unitsMap.put(group.getGroupCode(), utisList);
			}
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap.get(product.getCurrency()));
			view.addObject("groupList", groupList);
			view.addObject("unitsMap", unitsMap);
			view.addObject("product", product);
			view.addObject("brand", KC.Enum.getI18nLabel(product.getBrand()));
			view.addObject("productType", KC.Enum.getI18nLabel(product.getProductType()));
			view.addObject("cardClass", KC.Enum.getI18nLabel(product.getCardClass()));
			view.addObject("fabricationInd", KC.Enum.getI18nLabel(product.getFabricationInd()));
			view.addObject("isPbocInfoMerged", KC.Enum.getI18nLabel(product.getIsPbocInfoMerged()));	
			//映射表中的数据
			List<BPcmProductData> productData = parameterSurface.loadProductDatas(product.getProductCode(), product.getProductType().name());
			Map<String, String>  dataMap=new HashMap<String, String>();
			for (BPcmProductData data : productData) {
				dataMap.put(data.getUnitCode(),data.getParamKey());
			}
			view.addObject("dataMap", dataMap);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.productDetailPageFail", "加载产品参数管理详情页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 保存产品参数与配置的映射数据
	 * </p>
	 * @param productDatas
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "saveProductData.in", method = { RequestMethod.POST })
	public void saveProductData(@RequestBody List<BPcmProductData> productDatas)throws FlatException{
		try {
			parameterSurface.saveProductData(productDatas);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.saveProductDataFail", "保存产品参数与配置的映射数据失败");
		}
	}
	
	
	/** 
	 * <p>
	 * 加载修改产品参数管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productConfigEditPage.in")
	public ModelAndView productConfigEditPage(String productCode, HttpServletRequest request) throws FlatException {
		try {
			//语言环境
			Locale locale = LocaleContextHolder.getLocale();
			boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
			ModelAndView view = KW.mvc.forwardView("product/productConfigEdit");
			view.addObject("brand", KC.Enum.getI18nLabelMap(Brand.class));				
			view.addObject("productType", KC.Enum.getI18nLabelMap(ProductType.class));				
			view.addObject("cardClass", KC.Enum.getI18nLabelMap(CardClass.class));				
			Map<String, String> map = KC.Enum.getI18nLabelMap(Indicator.class);
			view.addObject("fabricationInd", map);	
			view.addObject("isPbocInfoMerged", map);				
			Product product = parameterSurface.getParameterObject(productCode, Product.class);
			//根据产品类型查到产品大类已经大类下的产品和子产品
			List<BPcmProductGroup> groupList = parameterSurface.getProGroup(product.getProductType().name());
			Map<String, List<Map<String,Serializable>>> unitsMap=new HashMap<String,List<Map<String,Serializable>>>();
			int count =1;
			for (int i = 0; i < groupList.size(); i++) {
				BPcmProductGroup group =groupList.get(i);
				List<Map<String,Serializable>> utisList = parameterSurface.getProUnits(group.getGroupCode());
				if(utisList.size()==0){
					groupList.remove(group);
					i--;
					continue;
				}
				for (Map<String,Serializable> units : utisList) {
					units.put("unitIndex", count++);
					if(!isChinese){
						units.put("unitNameCn", units.get("unitName"));
					}
				}
				if(!isChinese){
					group.setName(group.getGroupName());
				}
				unitsMap.put(group.getGroupCode(), utisList);
			}
			view.addObject("groupList", groupList);
			view.addObject("unitsMap", unitsMap);
			view.addObject("product", product);
			//映射表中的数据
			List<BPcmProductData> productData = parameterSurface.loadProductDatas(product.getProductCode(), product.getProductType().name());
			Map<String, String>  dataMap=new HashMap<String, String>();
			for (BPcmProductData data : productData) {
				dataMap.put(data.getUnitCode(),data.getParamKey());
			}
			view.addObject("dataMap", dataMap);
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.productEditPageFail","加载修改产品参数管理页面失败");
		}
	}

	
	/** 
	 * <p>
	 * 交易参数是否已经被引用
	 * </p>
	 * @param productCode
	 * @param paramClass
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "commonValidParam.in", method = { RequestMethod.POST })
	public String commonValidParam(String productCode,String paramClass,String paramKey)throws Exception{
		try {
			//根据code 和 class 去映射表中查询
			List<BPcmProductData> loadMappings = parameterSurface.loadMappings(paramKey, paramClass,productCode);
			String str="";
			for (BPcmProductData bPcmProductData : loadMappings) {
				str=str+bPcmProductData.getProductCode()+" ";
			}
			str=str.trim().replace(" ", ",");
			return  KC.string.isNotBlank(str)?str:"not";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.commonValidParam","加载修改产品参数管理页面失败");
		}
	}
	
}