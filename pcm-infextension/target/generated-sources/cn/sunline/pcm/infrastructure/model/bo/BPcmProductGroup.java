package cn.sunline.pcm.infrastructure.model.bo;

import cn.sunline.pcm.definition.enums.Position;
import java.io.Serializable;
import java.util.Date;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 产品页面分组表
 */
@SuppressWarnings("serial")
@LogicalName("产品页面分组表")
public class BPcmProductGroup implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("父节点代码")
    private String productParentId;
    
	@LogicalName("所属机构")
    private String org;
    
	@LogicalName("分组编码")
    private String groupCode;
    
	@LogicalName("产品大类")
    private String productType;
    
	@LogicalName("分组国际化名称")
    private String groupName;
    
	@LogicalName("分组中文名称")
    private String name;
    
	@LogicalName("分组序号 ")
    private Integer groupIndex;
    
	@LogicalName("分组位置")
    private Position groupPosition;
    
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
	
	public static final String P_PRODUCT_PARENT_ID = "productParentId";
	
	public static final String P_ORG = "org";
	
	public static final String P_GROUP_CODE = "groupCode";
	
	public static final String P_PRODUCT_TYPE = "productType";
	
	public static final String P_GROUP_NAME = "groupName";
	
	public static final String P_NAME = "name";
	
	public static final String P_GROUP_INDEX = "groupIndex";
	
	public static final String P_GROUP_POSITION = "groupPosition";
	
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
	 * <p>父节点代码</p>
	 * <p>父节点代码</p>
	 */
	public String getProductParentId() {
		return productParentId;
	}
	
	/**
	 * <p>父节点代码</p>
	 * <p>父节点代码</p>
	 */
	public void setProductParentId(String productParentId) {
		this.productParentId = productParentId;
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
	 * <p>分组编码</p>
	 */
	public String getGroupCode() {
		return groupCode;
	}
	
	/**
	 * <p>分组编码</p>
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	/**
	 * <p>产品大类</p>
	 */
	public String getProductType() {
		return productType;
	}
	
	/**
	 * <p>产品大类</p>
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	/**
	 * <p>分组国际化名称</p>
	 */
	public String getGroupName() {
		return groupName;
	}
	
	/**
	 * <p>分组国际化名称</p>
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/**
	 * <p>分组中文名称</p>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <p>分组中文名称</p>
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <p>分组序号 </p>
	 */
	public Integer getGroupIndex() {
		return groupIndex;
	}
	
	/**
	 * <p>分组序号 </p>
	 */
	public void setGroupIndex(Integer groupIndex) {
		this.groupIndex = groupIndex;
	}
	
	/**
	 * <p>分组位置</p>
	 */
	public Position getGroupPosition() {
		return groupPosition;
	}
	
	/**
	 * <p>分组位置</p>
	 */
	public void setGroupPosition(Position groupPosition) {
		this.groupPosition = groupPosition;
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