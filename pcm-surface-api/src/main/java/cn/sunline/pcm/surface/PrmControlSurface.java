package cn.sunline.pcm.surface;

import java.util.List;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl;

/** 
 * <p>
 * 参数管控 Surface 接口
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */ 
public interface PrmControlSurface {

	/** 
	 * <p>
	 * 查询参数管控列表
	 * </p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	FetchResponse<?> queryPrmControlList(FetchRequest request) throws Exception;
	
	/** 
	 * <p>
	 * 查询所有参数管控
	 * </p>
	 * @return
	 * @throws Exception
	 */
	List<BPcmPrmControl> findAllPrmControl() throws Exception;

	/** 
	 * <p>
	 * 查询参数管控详情
	 * </p>
	 * @return
	 * @throws Exception
	 */
	BPcmPrmControl findPrmControlById(String id) throws Exception;

	/** 
	 * <p>
	 * 新增参数管控
	 * </p>
	 * @param tmPrmControl
	 * @throws Exception
	 */
	void addPrmControl(BPcmPrmControl tmPrmControl) throws Exception;

	/** 
	 * <p>
	 * 修改参数管控
	 * </p>
	 * @param tmPrmControl
	 * @throws Exception
	 */
	void updPrmControl(BPcmPrmControl tmPrmControl) throws Exception;

	/** 
	 * <p>
	 * 根据ids删除参数管控s
	 * </p>
	 * @throws Exception
	 */
	void delPrmControlByIds(List<String> ids) throws Exception;

}
