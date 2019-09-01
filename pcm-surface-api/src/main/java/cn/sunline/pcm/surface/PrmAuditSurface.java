package cn.sunline.pcm.surface;

import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmAudit;

/** 
 * <p>
 * 参数变更日志 Surface 接口
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */ 
public interface PrmAuditSurface {

	/** 
	 * <p>
	 * 查询参数变更日志列表
	 * </p>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	FetchResponse<?> queryPrmAuditList(FetchRequest request) throws Exception;

	/** 
	 * <p>
	 * 查询参数变更日志详情
	 * </p>
	 * @return
	 * @throws Exception
	 */
	BPcmPrmAudit findPrmAuditById(String id) throws Exception;


}
