package cn.sunline.pcm.controller;

import java.io.Console;

import java.io.Serializable;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;

import cn.sunline.common.KC;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.vo.VProductUnitTree;
import cn.sunline.pcm.controller.vo.VUnitNode;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.Product;
import cn.sunline.pcm.definition.product.ProductUnitInfo;
import cn.sunline.pcm.definition.product.unit.ProductUnit;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnit;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductRel;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnit;
import cn.sunline.pcm.service.ProductUnitService;
import cn.sunline.pcm.surface.ProductCURDSurface;
import cn.sunline.pcm.surface.ProductGroupSurface;
import cn.sunline.pcm.surface.ProductUnitSurface;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.pcm.surface.model.VPcmProductRel;
import cn.sunline.pcm.surface.model.VProductCombination;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import scala.annotation.meta.param;

/**
 * <p>
 * 产品controller -- 产品工厂（Reform版本）
 * </p>
 * 
 * @version 1.0 2018年8月9日 Zcoup 修改内容:初版
 * @version zzq
 */
@Controller
@RequestMapping("productReform")
public class ProductReformController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	private ProductGroupSurface productGroupSurface; 

	@Autowired
	private ProductUnitSurface productUnitSurface;
	
	private ProductUnitService productUnitService;
	
	ObjectMapper mapper  = new ObjectMapper();
	
	@Autowired
	ProductCURDSurface productCURDSurface; 

	/**
	 * <p>
	 * 产品工厂首页
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productQueryPage.in")
	public ModelAndView productQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productReform/productQuery");
			Map<String, String> productTypes = loadProductTree().stream()
			.collect(Collectors.toMap(PcmProductGroup::getGroupCode, PcmProductGroup::getName));
			view.addObject("productTypeJson",KC.json.serializerNoType(productTypes));
			view.addObject("productTypeMap",productTypes);
			view.addObject("product", new Product());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.factoryPageFail", "加载产品工厂页面失败");
		}
	}
	

	
	
	private  List<PcmProductGroup> loadProductTree() throws FlatException {
		try {
			//获取根节点
			List<PcmProductGroup> treeBaseMap = getTreeBaseMap();
			//获取子节点
			List<PcmProductGroup> childTreeNode = getChildTreeNode();
			//追加到一起
			treeBaseMap.addAll(childTreeNode);
			//排序
			List<PcmProductGroup> allTree = sortTree(treeBaseMap);
			return allTree;
		} catch (ProcessException arg1) {
			this.logger.error(arg1.getMessage(), arg1);
			throw new FlatException(arg1.getErrorCode(), arg1.getMessage(), new Object[0]);
		} catch (Exception arg2) {
			this.logger.error("查询产品数据发生异常", arg2);
			throw new FlatException(arg2, "productTree.failed.load", "加载产品树失败", new Object[0]);
		}
	}
	
	
	/**
	 * 给产品树排序
	 * @return
	 */
	private List<PcmProductGroup> sortTree(List<PcmProductGroup> list){
		return  list.stream().sorted(Comparator.comparing(PcmProductGroup::getGroupIndex))
				.collect(Collectors.toList());
	}
	
	/**
	 * 追加树的子节点
	 * @return
	 */
	private List<PcmProductGroup> getChildTreeNode() throws Exception{
		List<PcmProductGroup> list = new ArrayList<>();
		List<BPcmProductGroup> allProductGroup = productGroupSurface.findAllProductGroup();
		allProductGroup.forEach(val->list.add(createVChildTreeNode(val)));
		return list;
	}
	
	/**
	 * 创建子节点
	 * @param tmProductGroup
	 * @return
	 */
	private PcmProductGroup createVChildTreeNode(BPcmProductGroup tmProductGroup){
		PcmProductGroup pcmProductGroup = new PcmProductGroup();
		pcmProductGroup.setGroupCode(tmProductGroup.getGroupCode());
		pcmProductGroup.setGroupIndex(tmProductGroup.getGroupIndex());
		pcmProductGroup.setGroupName(tmProductGroup.getGroupName());
		pcmProductGroup.setName(tmProductGroup.getName());
		pcmProductGroup.setGroupPosition(tmProductGroup.getGroupPosition());
		pcmProductGroup.setId(tmProductGroup.getId());
		pcmProductGroup.setOrg(tmProductGroup.getOrg());
		pcmProductGroup.setProductParentId(tmProductGroup.getProductParentId());
		pcmProductGroup.setProductType(tmProductGroup.getProductType());
		return pcmProductGroup;
	}
		
	/**
	 * 获取产品类型树的根节点
	 * @return
	 */
	private List<PcmProductGroup> getTreeBaseMap(){
		List<PcmProductGroup> productGroups = new ArrayList<>();
		Map<String, String> productMap = KC.Enum.getI18nLabelMap(ProductType.class);
		productMap.forEach((k,v)->productGroups.add(createVproductTreeRootNode(k, v)));
		return productGroups;
	}
	
	/**
	 * 封装根节点
	 * @return
	 */
	private PcmProductGroup createVproductTreeRootNode(String key,String val){
		PcmProductGroup pcmProductGroup = new PcmProductGroup();
		pcmProductGroup.setOrg(KC.threadLocal.ORG);
		pcmProductGroup.setProductType(key);
		pcmProductGroup.setId(key);
		pcmProductGroup.setGroupCode(key);
		pcmProductGroup.setGroupName(val);
		pcmProductGroup.setName(val);
		pcmProductGroup.setGroupIndex(0);
		return pcmProductGroup;
	}
	/**
	 * <p>
	 * 产品工厂列表数据
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@SuppressWarnings("all")
	@ResponseBody
	@RequestMapping(value = "queryProductList.in", method = {RequestMethod.POST})
	public FetchResponse<?> queryProductList(FetchRequest request) throws FlatException {
		try {
			FetchResponse<Product> fetchResponse = parameterSurface.getFetchResponse(request, Product.class);
			List rows =  (List) fetchResponse.getRows().stream().map(product->{
				if(product.getProductType()!=null && product.getGroupType()==null){
					ProductType productType = product.getProductType();
					product.setGroupType(productType.toString());
				}
				return product; 
			}).collect(Collectors.toList());
			fetchResponse.setRows(rows);
			return fetchResponse;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.factoryDataFail", "获取产品数据失败");
		}
	}

	/**
	 * <p>
	 * 添加产品页面
	 * </p>
	 * 
	 * @param request
	 * @param productType
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productAddPage.in")
	public ModelAndView productAddPage(HttpServletRequest request, String productType) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productReform/productAdd");
			view.addObject("productTypeMap", KC.Enum.getI18nLabelMap(ProductType.class));
			view.addObject("currencyMap", this.buildCurrencyOptions());
			view.addObject("indicatorMap", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("product", new Product());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.productAddFail", "加载新增产品页面异常");
		}
	}

	/**
	 * <p>
	 * 产品分步组装起始页面（Ancestor：祖先）
	 * </p>
	 * 
	 * @param productStr
	 * @return
	 */
	@RequestMapping("productStepAncestorPage.in")
	public ModelAndView productStepAncestorPage(String productStr) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productReform/productStepAncestor");
			String encode = URLDecoder.decode(productStr, StandardCharsets.UTF_8.toString());
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap);
			Product product = KC.json.reSerializerNoNull(encode, Product.class);
			
			Map<String, String> map = KC.Enum.getI18nLabelMap(Indicator.class);
			view.addObject("fabricationInd", map);	
			view.addObject("isPbocInfoMerged", map);		
			view.addObject("isEdit",false);
			// 数据携带
			this.ancestorDataCarry(view, product);
			return view;
		} catch (ProcessException e) {
			logger.debug(e.getMessage());
			throw new FlatException(e, e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new FlatException(e, "product.productAncestorPageFail", "产品组装页面跳转失败");
		}
	}

	/**
	 * <p>
	 * 保存产品组装的数据
	 * </p>
	 * 
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addProductAssemble.in", method = {RequestMethod.POST})
	public String addProductAssemble(@RequestBody VProductCombination vpc, Boolean isUpdate) throws FlatException {
		try {
			return productUnitSurface.productAssemble(vpc, null == isUpdate ? false : isUpdate);
		} catch (ProcessException e) {
			logger.debug(e.getMessage());
			throw new FlatException(e, e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new FlatException(e, "product.productAssembleFail", "产品组装数据保存失败");
		}
	};

	/**
	 * <p>
	 * 产品组装数据的展示页面
	 * </p>
	 * 
	 * @param productCode
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productShow.in")
	public ModelAndView productShow(String productCode) throws FlatException { 
		try {
			ModelAndView view = KW.mvc.forwardView("productReform/productShowTreeView");
			// 产品
			Product product = parameterSurface.getParameterObject(productCode, Product.class);
			// 数据关联
			List<BPcmProductRel> rels = productUnitSurface.queryProductRel(productCode);
			// 组件信息
			Map<String, ProductUnitInfo> infos = this.getProductUnitService().getProductUnitsMap();

			// 携带
			view.addObject("product",KC.json.serializerNoType(product));
			view.addObject("rels", KC.json.serializerNoType(rels));
			view.addObject("infos", KC.json.serializerNoType(infos));
			
			view.addObject(	"isChinese",
							LocaleContextHolder.getLocale().getLanguage().equals(Locale.CHINESE.getLanguage()));
			return view;
		} catch (ProcessException e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e, "product.productShowPageFail", "加载产品展示页面异常");
		}
	}

	/**
	 * <p>
	 * 产品修改页面
	 * </p>
	 * 
	 * @param productCode
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productEditPage.in")
	public ModelAndView productEditPage(String productCode) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productReform/productStepAncestor");
			// 产品
			Product product = parameterSurface.getParameterObject(productCode, Product.class);
//			product.setGroupType(productCode);
			// 数据携带
			this.ancestorDataCarry(view, product);
			// 关联数据
//			Map<String, List<VPcmProductRel>> relsMap = productUnitSurface.buildProductRel(productCode);
			List<BPcmProductRel> rels = productUnitSurface.queryProductRel(productCode);
			view.addObject("unitsJson", KC.json.serializerNoNull(rels));
			Map<String, ProductUnitInfo> productUnitsMap = this.getProductUnitService().getProductUnitsMap();
			//步骤是由现有的控制的
			List<VProductUnitTree> units = rels.stream().map(x->{
				VProductUnitTree vProductUnitTree = new VProductUnitTree();
				if(x.getParentId()==null){
					String unitCode = x.getUnitCode();
					vProductUnitTree.setUnitCode(unitCode);
					vProductUnitTree.setUnitName(productUnitsMap.get(unitCode).getUnitName());
					vProductUnitTree.setUnitNameCn(productUnitsMap.get(unitCode).getUnitNameCn());
					return vProductUnitTree ; 
				}else{
					return null ; 
				}
				
			}).collect(Collectors.toList()); 
			units.removeAll(Collections.singleton(null)); 
			
			Map<String, String> map = KC.Enum.getI18nLabelMap(Indicator.class);
			view.addObject("fabricationInd", map);	
			view.addObject("isPbocInfoMerged", map);		
			List<CurrencyCd> currency = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, Object> currencyMap=new LinkedHashMap<String, Object>();
			for (CurrencyCd curr : currency) {
				currencyMap.put(curr.currencyCd, curr.currencyCd+"-"+curr.description);
			}
			view.addObject("currency", currencyMap);
			view.addObject("units",units);
			view.addObject("isEdit", true);
			return view;
		} catch (ProcessException e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e, "product.productEditPageFail", "加载产品修改页面异常");
		}
	}
	
	
	
	/**
	 * <p>
	 * 私有方法：起始页面数据携带
	 * </p>
	 * 
	 * @param view
	 * @throws Exception
	 */
	private void ancestorDataCarry(ModelAndView view, Product product) throws Exception {
		
		view.addObject("product", product);
		// 语言环境
		Locale locale = LocaleContextHolder.getLocale();
		boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
		view.addObject("isChinese", isChinese);
		// 组件信息
		Map<String, ProductUnitInfo> infos = this.getProductUnitService().getProductUnitsMap();
		view.addObject("infos", infos);
		// 组件携带 通过组件的分组查询
		if(product.getGroupType()==null){
			throw new FlatException("未查询到产品对应的类型!");
		}
		List<BPcmProductUnit> units = productUnitSurface.findProductUnitByGroupType(product.getGroupType());
		view.addObject("units", units);
		// ProductStep构建信息
		//组件信息
		view.addObject("unitsJson", KC.json.serializerNoType(units));
		//所有注册组件的信息
		view.addObject("infosJson", KC.json.serializerNoType(infos));
		
	}

	/**
	 * <p>
	 * 获取产品组件服务
	 * </p>
	 * 
	 * @return
	 */
	private ProductUnitService getProductUnitService() {
		if (null == productUnitService) {
			productUnitService = KC.spring.context.getBean(ProductUnitService.class);
		}
		return productUnitService;
	}

	/**
	 * <p>
	 * 构建货币选项
	 * </p>
	 * 
	 * @return
	 */
	private Map<String, String> buildCurrencyOptions() {
		Map<String, String> map = new HashMap<String, String>();
		List<CurrencyCd> currencys = parameterSurface.getParameterObject(CurrencyCd.class);
		if (null != currencys && !currencys.isEmpty()) {
			for (CurrencyCd currency : currencys) {
				map.put(currency.currencyCd, currency.currencyCd + "-" + currency.description);
			}
		}
		return map;
	}

	
	
	/**
	 * 保存产品
	 * @param map
	 */
	@SuppressWarnings("all")
	@ResponseBody
	@PostMapping(value="/saveProductObj.in")
	public String   saveProductObj(@RequestBody Map<Integer,Object> map,Boolean isUpdate) throws Exception{
		try{
		//封装产品信息
		Product product = productBasicInfo((Map<String,String>)map.remove(1));
		String productCode = product.getProductCode();

		//封装关联组件,递归遍历map
		List<BPcmProductRel> allRelating = new ArrayList<>(); 
		map.values().forEach(val->{
			Map<String, Object> baseUnits = (Map<String, Object>)val;
			BPcmProductRel baseproductRel = baseproductRel(baseUnits,productCode);
			if(baseproductRel.getParamKey()!=null){
				allRelating.add(baseproductRel);
			}
			List<Map<String,Object>> childNodes =(List<Map<String,Object>>)baseUnits.get("children");//获取组件关联关系
			if(childNodes!=null){
				//获取子节点
				List<BPcmProductRel> bPcmProductUnits = recursionAllNode(childNodes,baseproductRel,productCode); 
				allRelating.addAll(bPcmProductUnits);
			}
			
		});
		VProductCombination vpc = new VProductCombination();
		vpc.setProduct(product);
		vpc.setProductRels(allRelating);
		//返回productCode
		return productUnitSurface.productAssemble(vpc, isUpdate);
		} catch (ProcessException e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new FlatException(e, "", "系统异常");
		}
	}
	
	
	 
	
	
	/**
	 * 递归所有的节点，转换为list
	 * @return
	 */
	@SuppressWarnings("all")
	private List<BPcmProductRel> recursionAllNode(List<Map<String,Object>> childNodes,
														BPcmProductRel  parentNode,String groupType ){
		List<BPcmProductRel> bPcmProductRels = new ArrayList<>();
		for (Map<String,Object> map : childNodes) {
			//对map的数据进行封装
			BPcmProductRel simpleBpcmProductRel = simpleBpcmProductRel(map,groupType,parentNode);
			if(simpleBpcmProductRel.getParamKey()!=null){
				bPcmProductRels.add(simpleBpcmProductRel); 
			}
			if(map.get("children")!=null){
				return recursionAllNode((List<Map<String,Object>>)map.get("children"),simpleBpcmProductRel,groupType);
			}
		}
		return bPcmProductRels ; 
	}
	
	
	/**
	 * 封装普通节点
	 */
	private BPcmProductRel simpleBpcmProductRel(Map<String,Object> map,String groupType,BPcmProductRel  parentNode ){
		BPcmProductRel bPcmProductRel = new BPcmProductRel();
		bPcmProductRel.setId((String)map.get("id"));
		bPcmProductRel.setProductCode(groupType);
		bPcmProductRel.setParamKey((String)map.get("unitParamId"));
		bPcmProductRel.setParamClass(this.productUnitService.getProductUnitsMap().get(map.get("unitCode")).getUnitClass());
		bPcmProductRel.setParentId(parentNode.getId());
		bPcmProductRel.setParentParamClass(parentNode.getParamClass());
		bPcmProductRel.setParentParamKey(parentNode.getParamKey());
		bPcmProductRel.setUnitCode((String)map.get("unitCode"));
		return bPcmProductRel;
	}
	
	
	
	
	/**
	 * 封装组件关联顶级父节点
	 */
	private BPcmProductRel baseproductRel(Map<String, Object> baseProductRel,String productCode){
		//封装父节点属性
		BPcmProductRel bPcmProductRel = new BPcmProductRel();
		bPcmProductRel.setId((String)baseProductRel.get("id"));
		bPcmProductRel.setProductCode(productCode);
		bPcmProductRel.setParamKey((String)baseProductRel.get("unitParamId"));
		bPcmProductRel.setParamClass(this.productUnitService.getProductUnitsMap()
				.get(baseProductRel.get("unitCode")).getUnitClass());
		bPcmProductRel.setUnitCode((String)baseProductRel.get("unitCode"));
		return bPcmProductRel;
		
	}
	
	/**
	 * 封装产品基本信息
	 * @return
	 */
	private Product productBasicInfo(Map<String,String> productMap){
		Product product = new Product();
		product.setProductCode(productMap.get("productCode"));
		product.setGroupType(productMap.get("groupType"));
		product.setDescription(productMap.get("description"));
		product.setBin(productMap.get("bin"));
		product.setCardnoLen(Integer.valueOf(productMap.get("cardnoLen")));
		product.setCardnoRangeCeil((productMap.get("cardnoRangeCeil")));
		product.setCardnoRangeFlr(productMap.get("cardnoRangeFlr"));
		product.setIsPbocInfoMerged(Indicator.valueOf((productMap.get("isPbocInfoMerged"))));
		product.setCurrency(productMap.get("currency"));
		return product;
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
	@ResponseBody
	@RequestMapping("productDetailPage.in")
	public ModelAndView productDetailPage(String productCode,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("productReform/productDetailTree");
			Product parameterObject = parameterSurface.getParameterObject(productCode, Product.class);
			view.addObject("product",parameterObject);
			String typeName = "" ; 
			Map<String, String> productMap = KC.Enum.getI18nLabelMap(ProductType.class);
			if(productMap.containsKey(parameterObject.getGroupType())){
				 typeName = productMap.get(parameterObject.getGroupType());
			}else {
				 typeName = productGroupSurface.findProductGroupByGroupCode(parameterObject.getGroupType()).getName();
			}
			view.addObject("productType",typeName);
			view.addObject("currency",parameterSurface.getParameterObject(parameterObject.getCurrency(), CurrencyCd.class).getDescription());
			view.addObject("isPbocInfoMerged",KC.Enum.getI18nLabel(parameterObject.getIsPbocInfoMerged()));
			return  view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.productDetailPageFail", "请重建此产品!");
		}
	}
	

	/**
	 * 删除组件节点
	 */
	@ResponseBody
	@GetMapping(value="delUnitRel.in")
	public void delNode(String productCode,String unitParamKey,String parentId){
		productCURDSurface.delNode(productCode,unitParamKey,parentId);
	}
	
	/**
	 * 修改组件关联节点
	 */
	@ResponseBody
	@RequestMapping(value="updUnitRel.in")
	public void updNode(String id,String paramKey){
		productCURDSurface.updNode(id,paramKey);
	}
	
	/**
	 * 添加组件关联节点
	 */
	@ResponseBody
	@RequestMapping(value="addUnitRel.in")
	public String  addNode(VUnitNode vunitNode){
		BPcmProductRel bPcmProductRel = new BPcmProductRel();
		bPcmProductRel.setCreateTime(new Date());
		bPcmProductRel.setCreateUser(KC.threadLocal.getUserId());
		bPcmProductRel.setOrg(KC.threadLocal.getCurrentOrg());
		bPcmProductRel.setParamClass(productUnitService.getProductUnitsMap().get(vunitNode.getUnitCode()).getUnitClass());
		bPcmProductRel.setParamKey(vunitNode.getParamKey());
		

		bPcmProductRel.setProductCode(vunitNode.getProductCode());
		bPcmProductRel.setUnitCode(vunitNode.getUnitCode());
		if(!vunitNode.getRoot()){
			bPcmProductRel.setParentParamClass(productUnitService.getProductUnitsMap().get(vunitNode.getParentUnitCode()).getUnitClass());
			bPcmProductRel.setParentParamKey(vunitNode.getParentParamKey());
			bPcmProductRel.setParentId(vunitNode.getParentId());
		}
		
		//保存到数据库中
		return productCURDSurface.addNode(bPcmProductRel);
	}
	
	
	
	/**
	 * 查询该产品模板下的该组件关联的产品
	 * @param productId 
	 * @param unitCode
	 * TODO 此接口暂时未完成
	 */
	@RequestMapping("getAddunits.in")
	@ResponseBody
	public Set<String> findProduct(String productId,String parentUnitCode,Boolean isRoot){
		try{
			Product product = parameterSurface.getParameterObject(productId, Product.class);
			 List<BPcmProductUnit> units = productUnitSurface.queryProductUnitList(product.getProductGroup(),product.getProductType()==null?null:product.getProductType().toString());
			if (isRoot) {
				return units.parallelStream().map(BPcmProductUnit::getUnitCode).collect(Collectors.toSet());
			}
			
			 
			 //把units 转换为tree需要的节点
			 List<VProductUnitTree> vProductUnitTrees = units.parallelStream().map(x->BPcmProductUnit2VProductZtree(x)).collect(Collectors.toList());
			
			 //把trees 转换为列表
			 return tree2List(vProductUnitTrees,parentUnitCode);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "product.productAddClickFail", "请重建此产品!");
		}
	}
	
	/**
	 * 找到unitcode 子节点下的所有可能去除重复
	 * @return
	 */
	@SuppressWarnings("all")
	private Set<String> tree2List(List<VProductUnitTree> list,String parentUnitCode){
		Set<String> set = new HashSet<>(); 
		for (VProductUnitTree item : list) {
			if (item.getValue().equals(parentUnitCode) && item.getChildren()!=null) {
				List<VProductUnitTree> children = item.getChildren();
				set.addAll(children.parallelStream().map(x->x.getValue()).collect(Collectors.toSet()));
				Set<String> childrenList = tree2List(children, parentUnitCode);
				set.addAll(childrenList);
			}
		}
		return set; 
	}
    
	
	 
	
	private VProductUnitTree BPcmProductUnit2VProductZtree(BPcmProductUnit unit){

		ObjectMapper objectMapper = new ObjectMapper();
		VProductUnitTree vProductUnitTree = new VProductUnitTree();
		vProductUnitTree.setId(unit.getId());
		vProductUnitTree.setValue(unit.getUnitCode());
		vProductUnitTree.setUnitName(unit.getUnitName());
		vProductUnitTree.setUnitNameCn(unit.getUnitNameCn());
		try {
			vProductUnitTree.setChildren(objectMapper.readValue(unit.getUnitRelations(), new TypeReference<List<VProductUnitTree>>() {}));
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e.toString());
			e.printStackTrace();
		}
		return vProductUnitTree ;
	}
	
	
	
	
	
}
