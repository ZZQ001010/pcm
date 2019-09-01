package cn.sunline.pcm.surface;

import java.util.List;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;

/** 
 * <p>
 * 产品页面分组表 Surface 接口
 * </p>
 * @version 1.0 2017-12-05 修改内容:初版
 */ 
public interface ProductGroupSurface {

	/** 
	 * <p>
	 * 查询产品页面分组表列表
	 * </p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	FetchResponse<?> queryProductGroupList(FetchRequest request) throws Exception;
	
	/** 
	 * <p>
	 * 查询所有产品页面分组表
	 * </p>
	 * @return
	 * @throws Exception
	 */
	List<BPcmProductGroup> findAllProductGroup() throws Exception;

	/** 
	 * <p>
	 * 查询产品页面分组表详情
	 * </p>
	 * @return
	 * @throws Exception
	 */
	BPcmProductGroup findProductGroupById(String id) throws Exception;

	/** 
	 * <p>
	 * 新增产品页面分组表
	 * </p>
	 * @param tmProductGroup
	 * @throws Exception
	 */
	void addProductGroup(BPcmProductGroup tmProductGroup) throws Exception;

	/** 
	 * <p>
	 * 修改产品页面分组表
	 * </p>
	 * @param tmProductGroup
	 * @throws Exception
	 */
	void updProductGroup(BPcmProductGroup tmProductGroup) throws Exception;

	/** 
	 * <p>
	 * 根据ids删除产品页面分组表s
	 * </p>
	 * @throws Exception
	 */
	void delProductGroupById(String id) throws Exception;

	List<BPcmProductGroup> findProductUnitsByType(String id) throws Exception;
	
	BPcmProductGroup findProductGroupByGroupCode(String groupCode) throws Exception;
}
