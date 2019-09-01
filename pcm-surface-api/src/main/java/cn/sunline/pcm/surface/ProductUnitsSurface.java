package cn.sunline.pcm.surface;

import java.util.List;
import java.util.Map;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits;

/** 
 * <p>
 * 产品页面组件表 Surface 接口
 * </p>
 * @version 1.0 2017-12-05 修改内容:初版
 */ 
public interface ProductUnitsSurface {

	/** 
	 * <p>
	 * 查询产品页面组件表列表
	 * </p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	FetchResponse<?> queryProductUnitsList(FetchRequest request) throws Exception;
	
	/** 
	 * <p>
	 * 查询所有产品页面组件表
	 * </p>
	 * @return
	 * @throws Exception
	 */
	List<BPcmProductUnits> findAllProductUnits() throws Exception;

	/** 
	 * <p>
	 * 查询产品页面组件表详情
	 * </p>
	 * @return
	 * @throws Exception
	 */
	BPcmProductUnits findProductUnitsById(String id) throws Exception;

	/** 
	 * <p>
	 * 新增产品页面组件表
	 * </p>
	 * @param tmProductUnits
	 * @throws Exception
	 */
	void addProductUnits(BPcmProductUnits tmProductUnits) throws Exception;

	/** 
	 * <p>
	 * 修改产品页面组件表
	 * </p>
	 * @param tmProductUnits
	 * @throws Exception
	 */
	void updProductUnits(BPcmProductUnits tmProductUnits) throws Exception;
	
	/**
	 * <P>
	 * 根据分组编码查询页面组件
	 * @param String
	 * @throws Exception
	 */
	String findProductUnitsByCode(String groupCode) throws Exception;
	
	/** 
	 * <p>
	 * 根据ids删除产品页面组件表s
	 * </p>
	 * @throws Exception
	 */
	void delProductUnitsByIds(List<String> ids) throws Exception;
	/** 
	 * <p>
	 * 过滤增加页面的组件
	 * </p>
	 * @throws Exception
	 */
	 Map<String,String> findUpdateUnitsAddPage(String productType,String groupCode) throws Exception;
	 /** 
		 * <p>
		 * 过滤编辑页面的组件
		 * </p>
		 * @throws Exception
		 */
	 Map<String,String> findUpdateUnitsEditPage(String productType,String groupCode,String unitCode) throws Exception;

	 /** 
	 * <p>
	 * 根据产品类参数映射表
	 * </p>
	 * @param productType
	 * @param productCode
	 * @return
	 * @throws Exception
	 */
	 Map<String, BPcmProductData> findByClass(String paramClass)throws Exception;
}
