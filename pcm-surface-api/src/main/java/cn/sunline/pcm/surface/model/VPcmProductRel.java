package cn.sunline.pcm.surface.model;

import java.util.ArrayList;
import java.util.List;

import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;

/**
 * <p>
 * 产品关联数据的携带数据结构定义
 * </p>
 * 
 * @version 1.0 2018年9月4日 Zcoup 修改内容:初版
 */
public class VPcmProductRel extends BPcmProductRel {

	private static final long serialVersionUID = 7280919971719523194L;

	/**
	 * 子级数据集合
	 */
	private List<VPcmProductRel> children = new ArrayList<VPcmProductRel>();

	/** 
	 * <p>
	 * 创建一个新的VPcmProductRel实例. 
	 * </p> 
	 */
	public VPcmProductRel(BPcmProductRel rel) {
		this.setId(rel.getId());
//		this.setOrg(rel.getOrg());
		this.setUnitCode(rel.getUnitCode());
		this.setProductCode(rel.getProductCode());
		this.setParamClass(rel.getParamClass());
		this.setParamKey(rel.getParamKey());
		this.setParentId(rel.getParentId());
		this.setParentParamClass(rel.getParentParamClass());
		this.setParentParamKey(rel.getParentParamKey());
//		this.setCreateTime(rel.getCreateTime());
//		this.setCreateUser(rel.getCreateUser());
//		this.setLstUpdTime(rel.getLstUpdTime());
//		this.setLstUpdUser(rel.getLstUpdUser());
//		this.setJpaVersion(rel.getJpaVersion());
	}

	/**
	 * @see cn.sunline.pcm.surface.model.VPcmProductRel#children
	 * @return children
	 */
	public List<VPcmProductRel> getChildren() {
		return children;
	}

	/**
	 * @see cn.sunline.pcm.surface.model.VPcmProductRel#children
	 * @param children
	 */
	public void setChildren(List<VPcmProductRel> children) {
		this.children = children;
	}

}
