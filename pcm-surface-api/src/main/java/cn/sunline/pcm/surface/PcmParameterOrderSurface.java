package cn.sunline.pcm.surface;

import java.util.List;
import java.util.Map;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmParameterOrder;

/** 
 * <p>
 * 参数展示字段自定义排序 Surface 接口
 * </p>
 * @version 1.0 2019-09-17 修改内容:初版
 */ 
public interface PcmParameterOrderSurface {

	/** 
	 * <p>
	 * 查询参数展示字段自定义排序列表
	 * </p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	FetchResponse<?> queryPcmParameterOrderList(FetchRequest request) throws Exception;
	
	/** 
	 * <p>
	 * 查询所有参数展示字段自定义排序
	 * </p>
	 * @return
	 * @throws Exception
	 */
	List<BPcmParameterOrder> findAllPcmParameterOrder() throws Exception;

	/** 
	 * <p>
	 * 查询参数展示字段自定义排序详情
	 * </p>
	 * @return
	 * @throws Exception
	 */
	BPcmParameterOrder findPcmParameterOrderById(String id) throws Exception;

	/** 
	 * <p>
	 * 新增参数展示字段自定义排序
	 * </p>
	 * @param pcmParameterOrder
	 * @throws Exception
	 */
	void addPcmParameterOrder(BPcmParameterOrder pcmParameterOrder) throws Exception;

	/** 
	 * <p>
	 * 修改参数展示字段自定义排序
	 * </p>
	 * @param pcmParameterOrder
	 * @throws Exception
	 */
	void updPcmParameterOrder(BPcmParameterOrder pcmParameterOrder) throws Exception;

	/** 
	 * <p>
	 * 根据ids删除参数展示字段自定义排序s
	 * </p>
	 * @throws Exception
	 */
	void delPcmParameterOrderByIds(List<String> ids) throws Exception;

	/**
	 * 根据paramClass 查询对应的参数
	 * @param paramClass
	 * @return
	 */
	List<BPcmParameterOrder> findPcmParameterOrderByParamClass(String paramClass);
	
	/**
	 * 更新pcmparameter
	 * cmParameterOrder
	 */
	void updPcmParameterOrders(List<BPcmParameterOrder> bPcmParameterOrder) throws Exception;

	/**
	 * 通过paramClass 批量删除
	 * @param ids
	 */
	void delPcmParameterOrderByParamClasses(List<String> ids);

}
