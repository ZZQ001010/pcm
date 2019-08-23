package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sunline.common.KC;
import cn.sunline.common.KC.Null;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.vo.VProductUnitTree;
import cn.sunline.pcm.controller.vo.VProductZtree;
import cn.sunline.pcm.definition.product.ProductUnitInfo;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnit;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnit;
import cn.sunline.pcm.service.ProductUnitService;
import cn.sunline.pcm.surface.ProductGroupSurface;
import cn.sunline.pcm.surface.ProductUnitSurface;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import net.bytebuddy.asm.Advice.This;

/**
 * <p>
 * 产品组件表 Controller 层（Reform版本）
 * </p>
 * 
 * @version 1.0 2018年8月17日 Zcoup 修改内容:初版
 * @version zzq 2019年7月22日
 */
@Controller
@RequestMapping("productUnit")
public class ProductUnitController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductUnitSurface productUnitSurface;

	private ProductUnitService productUnitService;
	
	
	@Autowired
	private ProductGroupSurface productGroupSurface; 

	/**
	 * <p>
	 * 产品页面组件表 列表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitQueryPage.in")
	public ModelAndView productUnitQueryPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnit/productUnitQuery");
			view.addObject("units", KC.json.serializerNoType(this.getProductUnitService().getProductUnitsMap()));
			view.addObject("unitOptions",getProductUnitService().getProductUnitOptions());
			view.addObject("productUnit", new BPcmProductUnit());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.productUnitQueryPageFail", "加载产品组件表列表页面失败");
		}
	}

	
	@ResponseBody
	@RequestMapping(value = {"/loadProductTree.in"}, method = {RequestMethod.POST})
	public List<PcmProductGroup> loadProductTree() throws FlatException {
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
		return KC.Enum.getI18nLabelMap(ProductType.class)
				.entrySet().stream().map(this::createVproductTreeRootNode).collect(Collectors.toList());
	}
	
	/**
	 * 封装根节点
	 * @return
	 */
	private PcmProductGroup createVproductTreeRootNode(java.util.Map.Entry<String, String> entity){
		String key = entity.getKey();
		String val=entity.getValue();
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
	 * 查询产品页面组件表列表
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@SuppressWarnings("all")
	@ResponseBody
	@RequestMapping(value = "queryProductUnitList.in", method = {RequestMethod.POST})
	public List<VProductUnitTree>  queryproductUnitList(String groupCode,String productType) throws FlatException {
		try {
				//获取所有的关联组件
			 List<BPcmProductUnit> units = productUnitSurface.queryProductUnitList(groupCode,productType);
			 

			//把units 转换为tree需要的节点
			List<VProductUnitTree> vProductUnitTrees = units.parallelStream().map(x->BPcmProductUnit2VProductZtree(x)).collect(Collectors.toList());
			 
			//排序
			vProductUnitTrees.sort(Comparator.comparing(VProductUnitTree::getUnitParamId));
			
			
			 return vProductUnitTrees ; 
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.queryProductUnitListFail", "查询产品组件表列表失败");
		}
	}

	
	private VProductUnitTree BPcmProductUnit2VProductZtree(BPcmProductUnit unit){

		ObjectMapper objectMapper = new ObjectMapper();
		VProductUnitTree vProductUnitTree = new VProductUnitTree();
		vProductUnitTree.setId(unit.getId());
		vProductUnitTree.setValue(unit.getUnitCode());
		vProductUnitTree.setUnitName(unit.getUnitName());
		vProductUnitTree.setUnitNameCn(unit.getUnitNameCn());
		vProductUnitTree.setUnitParamId(unit.getUnitIndex()); //新增排序功能
		try {
			vProductUnitTree.setChildren(objectMapper.readValue(unit.getUnitRelations(), new TypeReference<List<VProductUnitTree>>() {}));
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e.toString());
			e.printStackTrace();
		}
		return vProductUnitTree ;
	}
	
	
	
	/**
	 * <p>
	 * 加载新增产品页面组件表页面
	 * </p>
	 * 
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitAddPage.in")
	public ModelAndView productUnitAddPage(ProductType productType) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnit/productUnitAdd");
			view.addObject("unitModule", this.getProductUnitService().getProductUnitOptions());
			view.addObject("units", KC.json.serializerNoType(this.getProductUnitService().getProductUnitsMap()));
			view.addObject("indicator", KC.Enum.getI18nLabelMap(Indicator.class));
			BPcmProductUnit unit = new BPcmProductUnit();
			unit.setProductType(productType);
			view.addObject("bPcmProductUnit", unit);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.productUnitAddPageFail", "加载新增产品组件表页面异常");
		}
	}

	/**
	 * <p>
	 * 私有方法：获取产品组件服务
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
	 * 新增产品页面组件表
	 * </p>
	 * 
	 * @param bPcmProductUnit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addProductUnit.in", method = {RequestMethod.POST})
	public void addProductUnit(HttpServletRequest request, BPcmProductUnit bPcmProductUnit) throws FlatException {
		try {
			productUnitSurface.addProductUnit(bPcmProductUnit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.addProductUnitFail", "新增产品组件表失败");
		}
	}

	/**
	 * <p>
	 * 加载修改产品页面组件表页面
	 * </p>
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitEditPage.in")
	public ModelAndView productUnitEditPage(String id, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnit/productUnitEdit");
			view.addObject("unitModule", this.getProductUnitService().getProductUnitOptions());
			view.addObject("units", KC.json.serializerNoType(this.getProductUnitService().getProductUnitsMap()));
			view.addObject("indicator", KC.Enum.getI18nLabelMap(Indicator.class));
			BPcmProductUnit unit = productUnitSurface.findProductUnitById(id);
			view.addObject("unitRelations", unit.getUnitRelations());
			view.addObject("bPcmProductUnit", unit);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.productUnitEditPageFail", "加载修改产品组件表页面失败");
		}
	}

	/**
	 * <p>
	 * 修改产品页面组件表
	 * </p>
	 * 
	 * @param bPcmProductUnit
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updProductUnit.in", method = {RequestMethod.POST})
	public void updProductUnit(HttpServletRequest request, BPcmProductUnit bPcmProductUnit) throws FlatException {
		try {
			productUnitSurface.updProductUnit(bPcmProductUnit);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bPcmProductUnit.getId().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.updProductUnitFail", "修改产品组件表失败");
		}
	}

	/**
	 * <p>
	 * 删除产品页面组件表
	 * </p>
	 * 
	 * @param ids
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "delProductUnit.in", method = {RequestMethod.POST})
	public void delProductUnit(@RequestBody List<String> ids) throws FlatException {
		try {
			productUnitSurface.delProductUnitByIds(ids);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.delProductUnitFail", "删除产品组件表失败");
		}
	}

	/**
	 * <p>
	 * 加载产品页面组件表明细页面
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitDetailPage.in")
	public ModelAndView productUnitDetailPage(String id) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnit/productUnitDetail");
			view.addObject("units", KC.json.serializerNoType(this.getProductUnitService().getProductUnitsMap()));
			BPcmProductUnit unit = productUnitSurface.findProductUnitById(id);
			view.addObject(	"unitModuleStr",
							this.getProductUnitService().getProductUnitOptions().get(unit.getUnitModule()));
			view.addObject("unitModule", this.getProductUnitService().getProductUnitOptions());
			view.addObject("mltipleStr", KC.Enum.getI18nLabel(unit.getMultiple()));
			view.addObject("unitRelations", unit.getUnitRelations());
			view.addObject("bPcmProductUnit", unit);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnit.productUnitDetailPageFail", "加载产品组件表详情页面失败");
		}
	}
	
	
	/**
	 * 保存产品模板
	 */
	@ResponseBody
	@PostMapping(value="/saveProductTemplate.in")
	public void saveProductTemplate(@RequestBody VProductUnitTree vProductUnitTree) throws FlatException{
			//将producttemplate 拆分为
		List<BPcmProductUnit> list =new ArrayList<>();
			String groupCode = vProductUnitTree.getValue();
			if (vProductUnitTree.getChildren()!=null) {
				 list = vProductUnitTree.getChildren().stream().map(v->{
					BPcmProductUnit bPcmProductUnit = new BPcmProductUnit();
					bPcmProductUnit.setCreateTime(new Date());
					bPcmProductUnit.setCreateUser(KC.threadLocal.getUserId().toString());
//					bPcmProductUnit.setId(id);
					bPcmProductUnit.setOrg(KC.threadLocal.getCurrentOrg().toString());
					bPcmProductUnit.setProductUnitGroup(groupCode);
					bPcmProductUnit.setUnitCode(v.getValue());
					bPcmProductUnit.setUnitName(this.getProductUnitService().getProductUnitsMap().get(v.getValue()).getUnitName());
					bPcmProductUnit.setUnitNameCn(v.getUnitNameCn());
					bPcmProductUnit.setUnitIndex(v.getUnitParamId());
					ObjectMapper objectMapper = new ObjectMapper();
					String relationsJsonStr;
					try {
						relationsJsonStr = objectMapper.writeValueAsString(v.getChildren());
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new FlatException(e, null, "关联组件json解析失败!");	
					}
					bPcmProductUnit.setUnitRelations(relationsJsonStr);
					return bPcmProductUnit;
				}).collect(Collectors.toList()); 
			}else{
				productUnitSurface.deleteAllByGroupId(vProductUnitTree.getValue());
			}
			try {
				productUnitSurface.addAllProductUnits(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FlatException(e, null, "添加组件失败!");	
			}
			
	}

}