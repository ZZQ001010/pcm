package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import cn.sunline.common.KC;
import cn.sunline.common.KC.string;
import cn.sunline.common.enums.Indicator;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.controller.vo.VProductZtree;
import cn.sunline.pcm.definition.enums.ProductUnitsURL;
import cn.sunline.pcm.definition.enums.WinSize;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits;
import cn.sunline.pcm.surface.ProductGroupSurface;
import cn.sunline.pcm.surface.ProductUnitsSurface;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * @author fuliwen
 * <p>
 * 产品页面组件表 Controller 层
 * </p>
 * @version 1.0 2017-12-05 修改内容:初版
 * @author fuliwen
 */ 
@Controller
@RequestMapping("productUnits")
public class ProductUnitsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductUnitsSurface productUnitsSurface;
	
	@Autowired
	private ProductGroupSurface productGroupSurface; 
	

	/** 
	 * <p>
	 * 产品页面组件表 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitsQueryPage.in")
	public ModelAndView productUnitsQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("productUnits/productUnitsQuery");
			Locale locale = LocaleContextHolder.getLocale();
			boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
			List<BPcmProductGroup> list=productGroupSurface.findAllProductGroup();
			Map<String,String> map= new HashMap<String,String>();
			for(BPcmProductGroup tmProductGroup : list){
				if(isChinese){
				map.put(tmProductGroup.getGroupCode(),tmProductGroup.getName());
				}
				else{
				map.put(tmProductGroup.getGroupCode(),tmProductGroup.getGroupName());	
				}
			}
			view.addObject("groupCodeName",KC.json.serializerNoType(map));
			view.addObject("tmProductUnits", new BPcmProductUnits());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productUnits.productUnitsQueryPageFail","加载产品页面组件表列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询产品页面组件表列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryProductUnitsList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryProductUnitsList(FetchRequest request) throws FlatException{
		try {
			return productUnitsSurface.queryProductUnitsList(request);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productUnits.queryProductUnitsListFail","查询产品页面组件表列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增产品页面组件表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitsAddPage.in")
	public ModelAndView productUnitsAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnits/productUnitsAdd");
			String groupCode=request.getParameter(BPcmProductUnits.P_GROUP_CODE);
			String productType=request.getParameter(BPcmProductGroup.P_PRODUCT_TYPE);
			Map<String, String> findUpdateUnits = productUnitsSurface.findUpdateUnitsAddPage(productType, groupCode);
			view.addObject("updateUnits",findUpdateUnits);
			view.addObject("groupCode",groupCode);
			view.addObject("unitModule",KC.Enum.getI18nLabelMap(ProductUnitsURL.class));
			view.addObject("unitConfig",KC.Enum.getI18nLabelMap(WinSize.class));
			view.addObject("unitRequired", KC.Enum.getI18nLabelMap(Indicator.class));	
			BPcmProductUnits bPcmProductUnits=new BPcmProductUnits();
			bPcmProductUnits.setUnitConfig(WinSize.M);
			view.addObject("tmProductUnits", bPcmProductUnits);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productUnits.productUnitsAddPageFail","加载新增产品页面组件表页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增产品页面组件表
	 * </p>
	 * @param tmProductUnits
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addProductUnits.in", method = { RequestMethod.POST })
	public void addProductUnits(HttpServletRequest request,BPcmProductUnits tmProductUnits) throws FlatException {
		try {
			productUnitsSurface.addProductUnits(tmProductUnits);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.addProductUnitsFail", "新增产品页面组件表失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改产品页面组件表页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitsEditPage.in")
	public ModelAndView productUnitsEditPage(String id, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnits/productUnitsEdit");
			view.addObject("unitModule",KC.Enum.getI18nLabelMap(ProductUnitsURL.class));
			view.addObject("unitRequired", KC.Enum.getI18nLabelMap(Indicator.class));
			view.addObject("unitConfig",KC.Enum.getI18nLabelMap(WinSize.class));
			BPcmProductUnits tmProductUnits = productUnitsSurface.findProductUnitsById(id);
			BPcmProductGroup group = productGroupSurface.findProductGroupByGroupCode(tmProductUnits.getGroupCode());
			Map<String, String> findUpdateUnits = productUnitsSurface.findUpdateUnitsEditPage(group.getProductType(), tmProductUnits.getGroupCode(), tmProductUnits.getUnitCode());
			view.addObject("updateUnits",findUpdateUnits);
			view.addObject("updateUnitsName",tmProductUnits.getUpdateUnits());
			view.addObject("tmProductUnits", tmProductUnits);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productUnits.productUnitsEditPageFail","加载修改产品页面组件表页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改产品页面组件表
	 * </p>
	 * @param tmProductUnits
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updProductUnits.in", method = { RequestMethod.POST })
	public void updProductUnits(HttpServletRequest request,BPcmProductUnits bPcmProductUnits) throws FlatException {
		try {
			productUnitsSurface.updProductUnits(bPcmProductUnits);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bPcmProductUnits.getId().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.updProductUnitsFail", "修改产品页面组件表失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除产品页面组件表
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delProductUnits.in", method = { RequestMethod.POST })
	public void delProductUnitss(@RequestBody List<String> ids) throws FlatException {
		try {
			productUnitsSurface.delProductUnitsByIds(ids);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.delProductUnitsFail", "删除产品页面组件表失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载产品页面组件表明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productUnitsDetailPage.in")
	public ModelAndView productUnitsDetailPage(String id) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productUnits/productUnitsDetail");
			BPcmProductUnits tmProductUnits = productUnitsSurface.findProductUnitsById(id); 
			Locale locale = LocaleContextHolder.getLocale();
			boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
			if(isChinese){
				view.addObject("updateUnits",tmProductUnits.getUnitNameCn());
			}else{
				view.addObject("updateUnits",tmProductUnits.getUnitName());
			}
			view.addObject("tmProductUnits", tmProductUnits);						
			view.addObject("unitModule",KC.Enum.getI18nLabel(tmProductUnits.getUnitModule()));
			view.addObject("unitConfig",KC.Enum.getI18nLabel(tmProductUnits.getUnitConfig()));
			
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.productUnitsDetailPageFail", "加载产品页面组件表详情页面失败");
		}
	}
	@ResponseBody
	@RequestMapping(value = {"/loadProductTree.in"}, method = {RequestMethod.POST})
	public List<VProductZtree> loadProductTree() throws FlatException {
		try {
			List<VProductZtree> list = new ArrayList<VProductZtree>();
			List<BPcmProductGroup> listGroup = productGroupSurface.findAllProductGroup();
			Map<String, String> productType = KC.Enum.getI18nLabelMap(ProductType.class);
			for (Map.Entry<String, String> entry : productType.entrySet()) {
				VProductZtree vProductZtree = new VProductZtree();
				vProductZtree.setId(entry.getKey());
				vProductZtree.setPid("all");
				vProductZtree.setNameCn(entry.getValue());
				vProductZtree.setName(entry.getKey());
				vProductZtree.setProductKind("type");
				vProductZtree.setIndex(0);
				list.add(vProductZtree);
			}
			for (BPcmProductGroup tmProductGroup : listGroup) {
				VProductZtree vProductZtree = new VProductZtree();
				vProductZtree.setKeyId(tmProductGroup.getId());
				vProductZtree.setId(tmProductGroup.getGroupCode());
				vProductZtree.setPid(tmProductGroup.getProductType());
				vProductZtree.setName(tmProductGroup.getGroupName());
				vProductZtree.setNameCn(tmProductGroup.getName());
				vProductZtree.setIndex(tmProductGroup.getGroupIndex());
				vProductZtree.setProductKind("group");
				vProductZtree.setIsParentNode(false);
				list.add(vProductZtree);
			}

			Collections.sort(list, new Comparator<VProductZtree>(){

				@Override
				public int compare(VProductZtree o1, VProductZtree o2) {
					int i = o1.getIndex() - o2.getIndex();
					if (i == 0) {
						return 0;
					}
					if (i > 0) {
						return 1;
					}
					return -1;
				}
			});
			return list;
		} catch (ProcessException arg1) {
			this.logger.error(arg1.getMessage(), arg1);
			throw new FlatException(arg1.getErrorCode(), arg1.getMessage(), new Object[0]);
		} catch (Exception arg2) {
			this.logger.error("查询产品数据发生异常", arg2);
			throw new FlatException(arg2, "productTree.failed.load", "加载产品树失败", new Object[0]);
		}
	}
	@ResponseBody
	@RequestMapping(value = {"/loadProductGroupInfo.in"}, method = {RequestMethod.POST})
	public BPcmProductGroup loadProductGroupInfo(String id) throws FlatException {
		try {
			BPcmProductGroup e = this.productGroupSurface.findProductGroupById(id);
			return e;
		} catch (ProcessException arg2) {
			this.logger.error(arg2.getMessage(), arg2);
			throw new FlatException(arg2.getErrorCode(), arg2.getMessage(), new Object[0]);
		} catch (Exception arg3) {
			this.logger.error("查询产品分组数据发生异常", arg3);
			throw new FlatException(arg3, "productTree.loadProductGroupFail", "加载产品分组详情失败", new Object[0]);
		}
	}
	/** 
	 * <p>
	 * 加载新增产品页面分组表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productGroupAddPage.in")
	public ModelAndView productGroupAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productGroup/productGroupAdd");
			String productType=request.getParameter(BPcmProductGroup.P_PRODUCT_TYPE);
			String id = request.getParameter(BPcmProductGroup.P_ID);
			BPcmProductGroup bPcmProductGroup = new BPcmProductGroup();
			bPcmProductGroup.setProductParentId(id);
			bPcmProductGroup.setProductType(productType);
			view.addObject("tmProductGroup", bPcmProductGroup );
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productGroup.productGroupAddPageFail","加载新增产品页面分组表页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增产品页面分组表
	 * </p>
	 * @param tmProductGroup
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addProductGroup.in", method = { RequestMethod.POST })
	public void addProductGroup(BPcmProductGroup tmProductGroup) throws FlatException {
		try {
			productGroupSurface.addProductGroup(tmProductGroup);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productGroup.addProductGroupFail", "新增产品页面分组表失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改产品页面分组表页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("productGroupEditPage.in")
	public ModelAndView productGroupEditPage(String id, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("productGroup/productGroupEdit");
			BPcmProductGroup tmProductGroup = productGroupSurface.findProductGroupById(id);
			view.addObject("tmProductGroup", tmProductGroup);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"productGroup.productGroupEditPageFail","加载修改产品页面分组表页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改产品页面分组表
	 * </p>
	 * @param tmProductGroup
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updProductGroup.in", method = { RequestMethod.POST })
	public void updProductGroup(BPcmProductGroup bPcmProductGroup) throws FlatException {
		try {
			productGroupSurface.updProductGroup(bPcmProductGroup);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), bPcmProductGroup.getId().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productGroup.updProductGroupFail", "修改产品页面分组表失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除产品页面分组表
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delProductGroup.in", method = { RequestMethod.POST })
	public void delProductGroups(String  id) throws FlatException {
		try {
			productGroupSurface.delProductGroupById(id);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.delProductGroupFail", "删除产品页面分组表失败");
		}
	}
	/**
	 *
	 * <p>
	 * TODO 查询是否有值
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "checkInfo.in", method = { RequestMethod.POST })
	public String checkInfo(String id) throws FlatException{
		try {
			return productUnitsSurface.findProductUnitsByCode(id);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.checkInfoFail", "查询是否存在此信息失败");
		}
	}
	/**
	 * 
	 * <p>
	 * TODO 查询二级组件信息
	 * </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	 
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "checkProductUnitSub.in", method = { RequestMethod.POST })
	public Map<String,String> checkProductUnitSub(String id) throws Exception{
		try {
			ProductUnitsURL unitUrl = ProductUnitsURL.valueOf(id);
			if(unitUrl!=null){
			Class<?> enum1 = unitUrl.getEnum();
			return KC.Enum.getI18nLabelMap((Class<? extends Enum<?>>)enum1);
			}
			return null;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.checkProductUnitSubFail", "查询二级组件信息失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "checkEditInfo.in", method = { RequestMethod.POST })
	public String checkEditInfo(String id) throws Exception{
		try {
			BPcmProductUnits findProductUnitsById = productUnitsSurface.findProductUnitsById(id);
			if(findProductUnitsById!=null){
				return findProductUnitsById.getSubUnit();
			}else{
			return null;
			}
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "productUnits.checkEditInfoFail", "查询信用计划信息二级组件失败");
		}
	}
	
}