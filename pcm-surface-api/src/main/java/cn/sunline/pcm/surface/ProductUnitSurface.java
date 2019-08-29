package cn.sunline.pcm.surface;

import java.util.List;
import java.util.Map;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnit;
import cn.sunline.pcm.surface.model.VPcmProductRel;
import cn.sunline.pcm.surface.model.VProductCombination;
import cn.sunline.ppy.dictionary.enums.ProductType;

/**
 * <p>
 * 产品页面组件表 Surface 接口
 * </p>
 * 
 * @version 1.0 2017-12-05 修改内容:初版
 */
public interface ProductUnitSurface {

	/**
	 * <p>
	 * 查询产品页面组件表列表  
	 * <p>
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<BPcmProductUnit> queryProductUnitList(String groupCode,String productType) throws Exception;

	/**
	 * <p>
	 * 查询产品页面组件表详情
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	BPcmProductUnit findProductUnitById(String id) throws Exception;

	/**
	 * <p>
	 * 新增产品页面组件表
	 * </p>
	 * 
	 * @param tmProductUnits
	 * @throws Exception
	 */
	void addProductUnit(BPcmProductUnit bPcmProductUnit) throws Exception;

	
	
	/**
	 * 保存所有的组件
	 * @param bPcmProductUnits
	 * @throws Exception
	 */
	public void addAllProductUnits(List<BPcmProductUnit> bPcmProductUnits) throws Exception;
	
	/**
	 * <p>
	 * 修改产品页面组件表
	 * </p>
	 * 
	 * @param tmProductUnits
	 * @throws Exception
	 */
	void updProductUnit(BPcmProductUnit tmProductUnit) throws Exception;

	/**
	 * <p>
	 * 根据ids删除产品页面组件表s
	 * </p>
	 * 
	 * @throws Exception
	 */
	void delProductUnitByIds(List<String> ids) throws Exception;

	
	/**
	 * <p>
	 * 根据产品分组类型，查询当前分组下面的所有组件
	 * </p>
	 * 
	 * @param productType
	 * @return
	 * @throws Exception
	 */
	List<BPcmProductUnit> findProductUnitByGroupType(String  groupType) throws Exception;
	
	
	/** 
	 * <p>
	 * 保存/更新 产品组装的数据
	 * </p>
	 * @param vpc 产品组装数据
	 * @param isUpdate 是否为更新
	 * @return
	 * @throws Exception
	 */
	String productAssemble(VProductCombination vpc, boolean isUpdate) throws Exception;
	
	/** 
	 * <p>
	 * 获取产品关联信息
	 * </p>
	 * @param productCode
	 * @return
	 * @throws Exception
	 */
	List<BPcmProductRel> queryProductRel(String productCode) throws Exception;
	
	/** 
	 * <p>
	 * 构建产品关联数据
	 * </p>
	 * @param productCode
	 * @return
	 * @throws Exception
	 */
	Map<String, List<VPcmProductRel>> buildProductRel(String productCode) throws Exception;

	/**
	 * 删除分组下的所有关联组件
	 * @param value
	 */
	void deleteAllByGroupId(String value);

	/**
	 * 检查该参数是否在产品中已经引用
	 * @param paramClass
	 * @param paramId
	 */
	List<BPcmProductRel> checkupParamIsExist(String paramClass, List<String> ids);
}
