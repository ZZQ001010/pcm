package cn.sunline.pcm.surface;

import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;

/**
 * 提供已经生产产品的curd 操作
 * @author zzq
 * @date 2019年8月7日
 *
 */
public interface ProductCURDSurface {

	/**
	 * 删除组件节点关联
	 * @param unitParamKey 
	 * @param productCode 
	 */
	 void delNode(String productCode, String unitParamKey,String parentId);
	
	 /**
	  * 修改组件节点关联
	  * @param pcmProductRel
	  */
	 void updNode(String id,String paramKey);
	 
	 /**
	  * 新增组件节点关联
	  * @param pcmProductRel
	  * @return id
	  */
	 String  addNode(BPcmProductRel pcmProductRel); 
}
