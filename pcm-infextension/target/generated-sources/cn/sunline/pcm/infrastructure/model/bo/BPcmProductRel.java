package cn.sunline.pcm.infrastructure.model.bo;

import java.io.Serializable;
import java.util.Date;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 产品数据关联表
 */
@SuppressWarnings("serial")
@LogicalName("产品数据关联表")
public class BPcmProductRel implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("所属机构")
    private String org;
    
	@LogicalName("产品组件编码")
    private String unitCode;
    
	@LogicalName("产品编码")
    private String productCode;
    
	@LogicalName("参数类别")
    private String paramClass;
    
	@LogicalName("参数主键")
    private String paramKey;
    
	@LogicalName("父ID")
    private String parentId;
    
	@LogicalName("父参数类型")
    private String parentParamClass;
    
	@LogicalName("父参数主键")
    private String parentParamKey;
    
	@LogicalName("创建时间")
    private Date createTime;
    
	@LogicalName("创建人")
    private String createUser;
    
	@LogicalName("最后修改时间")
    private Date lstUpdTime;
    
	@LogicalName("最后修改人")
    private String lstUpdUser;
    
	@LogicalName("JPA_VERSION")
    private Integer jpaVersion;
    
	public static final String P_ID = "id";
	
	public static final String P_ORG = "org";
	
	public static final String P_UNIT_CODE = "unitCode";
	
	public static final String P_PRODUCT_CODE = "productCode";
	
	public static final String P_PARAM_CLASS = "paramClass";
	
	public static final String P_PARAM_KEY = "paramKey";
	
	public static final String P_PARENT_ID = "parentId";
	
	public static final String P_PARENT_PARAM_CLASS = "parentParamClass";
	
	public static final String P_PARENT_PARAM_KEY = "parentParamKey";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	
	/**
	 * <p>ID</p>
	 * <p>///@UuidSeq</p>
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * <p>ID</p>
	 * <p>///@UuidSeq</p>
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * <p>所属机构</p>
	 */
	public String getOrg() {
		return org;
	}
	
	/**
	 * <p>所属机构</p>
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	
	/**
	 * <p>产品组件编码</p>
	 */
	public String getUnitCode() {
		return unitCode;
	}
	
	/**
	 * <p>产品组件编码</p>
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	/**
	 * <p>产品编码</p>
	 */
	public String getProductCode() {
		return productCode;
	}
	
	/**
	 * <p>产品编码</p>
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * <p>参数类别</p>
	 * <p>参数类别，使用参数类对应的全名来区分</p>
	 */
	public String getParamClass() {
		return paramClass;
	}
	
	/**
	 * <p>参数类别</p>
	 * <p>参数类别，使用参数类对应的全名来区分</p>
	 */
	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}
	
	/**
	 * <p>参数主键</p>
	 * <p>参数主键，可以为空，表示机构级全局参数</p>
	 */
	public String getParamKey() {
		return paramKey;
	}
	
	/**
	 * <p>参数主键</p>
	 * <p>参数主键，可以为空，表示机构级全局参数</p>
	 */
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	
	/**
	 * <p>父ID</p>
	 */
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * <p>父ID</p>
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * <p>父参数类型</p>
	 */
	public String getParentParamClass() {
		return parentParamClass;
	}
	
	/**
	 * <p>父参数类型</p>
	 */
	public void setParentParamClass(String parentParamClass) {
		this.parentParamClass = parentParamClass;
	}
	
	/**
	 * <p>父参数主键</p>
	 */
	public String getParentParamKey() {
		return parentParamKey;
	}
	
	/**
	 * <p>父参数主键</p>
	 */
	public void setParentParamKey(String parentParamKey) {
		this.parentParamKey = parentParamKey;
	}
	
	/**
	 * <p>创建时间</p>
	 * <p>///@create</p>
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * <p>创建时间</p>
	 * <p>///@create</p>
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * <p>创建人</p>
	 */
	public String getCreateUser() {
		return createUser;
	}
	
	/**
	 * <p>创建人</p>
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	/**
	 * <p>最后修改时间</p>
	 * <p>///@update</p>
	 */
	public Date getLstUpdTime() {
		return lstUpdTime;
	}
	
	/**
	 * <p>最后修改时间</p>
	 * <p>///@update</p>
	 */
	public void setLstUpdTime(Date lstUpdTime) {
		this.lstUpdTime = lstUpdTime;
	}
	
	/**
	 * <p>最后修改人</p>
	 */
	public String getLstUpdUser() {
		return lstUpdUser;
	}
	
	/**
	 * <p>最后修改人</p>
	 */
	public void setLstUpdUser(String lstUpdUser) {
		this.lstUpdUser = lstUpdUser;
	}
	
	/**
	 * <p>JPA_VERSION</p>
	 */
	public Integer getJpaVersion() {
		return jpaVersion;
	}
	
	/**
	 * <p>JPA_VERSION</p>
	 */
	public void setJpaVersion(Integer jpaVersion) {
		this.jpaVersion = jpaVersion;
	}
	
}