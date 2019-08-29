package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.definition.enums.Position;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 产品页面分组表
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("产品页面分组表")
@Table(name="PCM_PRODUCT_GROUP",uniqueConstraints = {@UniqueConstraint(columnNames={"ORG","GROUP_CODE"})})
public class PcmProductGroup implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRODUCT_GROUP";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmProductGroup")
	@GenericGenerator(name = "idGeneratorPcmProductGroup", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRODUCT_GROUP")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("父节点代码")
	@Column(name="PRODUCT_PARENT_ID", nullable=false, length=100)
	private String productParentId;
		
	@LogicalName("所属机构")
	@Column(name="ORG", nullable=false, length=12)
	private String org;
		
	@LogicalName("分组编码")
	@Column(name="GROUP_CODE", nullable=false, length=32)
	private String groupCode;
		
	@LogicalName("产品大类")
	@Column(name="PRODUCT_TYPE", nullable=false, length=20)
	private String productType;
		
	@LogicalName("分组国际化名称")
	@Column(name="GROUP_NAME", nullable=false, length=200)
	private String groupName;
		
	@LogicalName("分组中文名称")
	@Column(name="NAME", nullable=false, length=200)
	private String name;
		
	@LogicalName("分组序号 ")
	@Column(name="GROUP_INDEX", nullable=false)
	private Integer groupIndex;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("分组位置")
	@Column(name="GROUP_POSITION", nullable=true)
	private Position groupPosition;
		
	@Temporal(value=TemporalType.TIMESTAMP)
	@LogicalName("创建时间")
	@Column(name="CREATE_TIME", nullable=false, updatable = false)
	private Date createTime;
		
	@LogicalName("创建人")
	@Column(name="CREATE_USER", nullable=false, updatable = false, length=30)
	private String createUser;
		
	@Temporal(value=TemporalType.TIMESTAMP)
	@LogicalName("最后修改时间")
	@Column(name="LST_UPD_TIME", nullable=true)
	private Date lstUpdTime;
		
	@LogicalName("最后修改人")
	@Column(name="LST_UPD_USER", nullable=true, length=30)
	private String lstUpdUser;
		
	@LogicalName("JPA_VERSION")
	@Column(name="JPA_VERSION", nullable=false)
	@Version
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
	
	public PcmProductGroup () {};
	
	public PcmProductGroup (BPcmProductGroup bPcmProductGroup) {
		this.fillValueFromBO(bPcmProductGroup);
	};
	
	@PrePersist
	protected void onCreate() {
		this.createTime = new Date();
		this.lstUpdTime = new Date();
		if (this.createUser == null)
			this.createUser = null == cn.sunline.common.KC.threadLocal.getUserId() ? "KITE_SYS" : cn.sunline.common.KC.threadLocal.getUserId();
		if (this.lstUpdUser == null)
			this.lstUpdUser = null == cn.sunline.common.KC.threadLocal.getUserId() ? "KITE_SYS" : cn.sunline.common.KC.threadLocal.getUserId();
		this.jpaVersion = 0;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.lstUpdTime = new Date();
		if (this.lstUpdUser == null)
			this.lstUpdUser = null == cn.sunline.common.KC.threadLocal.getUserId() ? "KITE_SYS" : cn.sunline.common.KC.threadLocal.getUserId();
	}
	
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
	
	/**
	 * <p>将当前实体对象转化为map返回</p>
	 */
	public Map<String, Serializable> convertToMap() {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		map.put(P_ID, id);
		map.put(P_PRODUCT_PARENT_ID, productParentId);
		map.put(P_ORG, org);
		map.put(P_GROUP_CODE, groupCode);
		map.put(P_PRODUCT_TYPE, productType);
		map.put(P_GROUP_NAME, groupName);
		map.put(P_NAME, name);
		map.put(P_GROUP_INDEX, groupIndex);
		map.put(P_GROUP_POSITION, groupPosition == null ? null : groupPosition.toString());
		map.put(P_CREATE_TIME, createTime);
		map.put(P_CREATE_USER, createUser);
		map.put(P_LST_UPD_TIME, lstUpdTime);
		map.put(P_LST_UPD_USER, lstUpdUser);
		map.put(P_JPA_VERSION, jpaVersion);
		return map;
	}

	/**
	 * <p>从map更新当前实体对象</p>
	 */
	public void updateFromMap(Map<String, Serializable> map) {
		if (map.containsKey(P_ID)) { this.setId(DataTypeUtils.getStringValue(map.get(P_ID))); }
		if (map.containsKey(P_PRODUCT_PARENT_ID)) { this.setProductParentId(DataTypeUtils.getStringValue(map.get(P_PRODUCT_PARENT_ID))); }
		if (map.containsKey(P_ORG)) { this.setOrg(DataTypeUtils.getStringValue(map.get(P_ORG))); }
		if (map.containsKey(P_GROUP_CODE)) { this.setGroupCode(DataTypeUtils.getStringValue(map.get(P_GROUP_CODE))); }
		if (map.containsKey(P_PRODUCT_TYPE)) { this.setProductType(DataTypeUtils.getStringValue(map.get(P_PRODUCT_TYPE))); }
		if (map.containsKey(P_GROUP_NAME)) { this.setGroupName(DataTypeUtils.getStringValue(map.get(P_GROUP_NAME))); }
		if (map.containsKey(P_NAME)) { this.setName(DataTypeUtils.getStringValue(map.get(P_NAME))); }
		if (map.containsKey(P_GROUP_INDEX)) { this.setGroupIndex(DataTypeUtils.getIntegerValue(map.get(P_GROUP_INDEX))); }
		if (map.containsKey(P_GROUP_POSITION)) { this.setGroupPosition(DataTypeUtils.getEnumValue(map.get(P_GROUP_POSITION), Position.class)); }
		if (map.containsKey(P_CREATE_TIME)) { this.setCreateTime(DataTypeUtils.getDateValue(map.get(P_CREATE_TIME))); }
		if (map.containsKey(P_CREATE_USER)) { this.setCreateUser(DataTypeUtils.getStringValue(map.get(P_CREATE_USER))); }
		if (map.containsKey(P_LST_UPD_TIME)) { this.setLstUpdTime(DataTypeUtils.getDateValue(map.get(P_LST_UPD_TIME))); }
		if (map.containsKey(P_LST_UPD_USER)) { this.setLstUpdUser(DataTypeUtils.getStringValue(map.get(P_LST_UPD_USER))); }
		if (map.containsKey(P_JPA_VERSION)) { this.setJpaVersion(DataTypeUtils.getIntegerValue(map.get(P_JPA_VERSION))); }
	}

	/**
	 * <p>为当前实体对象除了主键字段之外的值为空的成员变量赋予默认值，字符串=""，数字类型字段=0</p>
	 */
	public void fillDefaultValues() {
		if (id == null) { id = ""; }
		if (productParentId == null) { productParentId = ""; }
		if (org == null) { org = ""; }
		if (groupCode == null) { groupCode = ""; }
		if (productType == null) { productType = ""; }
		if (groupName == null) { groupName = ""; }
		if (name == null) { name = ""; }
		if (groupIndex == null) { groupIndex = 0; }
		if (groupPosition == null) { groupPosition = null; }
		if (createTime == null) { createTime = new Date(); }
		if (createUser == null) { createUser = ""; }
		if (lstUpdTime == null) { lstUpdTime = new Date(); }
		if (lstUpdUser == null) { lstUpdUser = ""; }
		if (jpaVersion == null) { jpaVersion = 0; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmProductGroup toBO() {
		BPcmProductGroup bPcmProductGroup = new BPcmProductGroup();
		bPcmProductGroup.setId(this.getId());
		bPcmProductGroup.setProductParentId(this.getProductParentId());
		bPcmProductGroup.setOrg(this.getOrg());
		bPcmProductGroup.setGroupCode(this.getGroupCode());
		bPcmProductGroup.setProductType(this.getProductType());
		bPcmProductGroup.setGroupName(this.getGroupName());
		bPcmProductGroup.setName(this.getName());
		bPcmProductGroup.setGroupIndex(this.getGroupIndex());
		bPcmProductGroup.setGroupPosition(this.getGroupPosition());
		bPcmProductGroup.setCreateTime(this.getCreateTime());
		bPcmProductGroup.setCreateUser(this.getCreateUser());
		bPcmProductGroup.setLstUpdTime(this.getLstUpdTime());
		bPcmProductGroup.setLstUpdUser(this.getLstUpdUser());
		bPcmProductGroup.setJpaVersion(this.getJpaVersion());
		return bPcmProductGroup;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmProductGroup fillValueFromBO(BPcmProductGroup bPcmProductGroup) {
		this.setId(bPcmProductGroup.getId());
		this.setProductParentId(bPcmProductGroup.getProductParentId());
		this.setOrg(bPcmProductGroup.getOrg());
		this.setGroupCode(bPcmProductGroup.getGroupCode());
		this.setProductType(bPcmProductGroup.getProductType());
		this.setGroupName(bPcmProductGroup.getGroupName());
		this.setName(bPcmProductGroup.getName());
		this.setGroupIndex(bPcmProductGroup.getGroupIndex());
		this.setGroupPosition(bPcmProductGroup.getGroupPosition());
		this.setCreateTime(bPcmProductGroup.getCreateTime());
		this.setCreateUser(bPcmProductGroup.getCreateUser());
		this.setLstUpdTime(bPcmProductGroup.getLstUpdTime());
		this.setLstUpdUser(bPcmProductGroup.getLstUpdUser());
		this.setJpaVersion(bPcmProductGroup.getJpaVersion());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmProductGroup updateValueFromBO(BPcmProductGroup bPcmProductGroup) {
		if(bPcmProductGroup.getProductParentId() != null){
			this.setProductParentId(bPcmProductGroup.getProductParentId());
		}
		if(bPcmProductGroup.getOrg() != null){
			this.setOrg(bPcmProductGroup.getOrg());
		}
		if(bPcmProductGroup.getGroupCode() != null){
			this.setGroupCode(bPcmProductGroup.getGroupCode());
		}
		if(bPcmProductGroup.getProductType() != null){
			this.setProductType(bPcmProductGroup.getProductType());
		}
		if(bPcmProductGroup.getGroupName() != null){
			this.setGroupName(bPcmProductGroup.getGroupName());
		}
		if(bPcmProductGroup.getName() != null){
			this.setName(bPcmProductGroup.getName());
		}
		if(bPcmProductGroup.getGroupIndex() != null){
			this.setGroupIndex(bPcmProductGroup.getGroupIndex());
		}
		if(bPcmProductGroup.getGroupPosition() != null){
			this.setGroupPosition(bPcmProductGroup.getGroupPosition());
		}
		if(bPcmProductGroup.getLstUpdTime() != null){
			this.setLstUpdTime(bPcmProductGroup.getLstUpdTime());
		}
		if(bPcmProductGroup.getLstUpdUser() != null){
			this.setLstUpdUser(bPcmProductGroup.getLstUpdUser());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmProductGroup> convertToBOList(Iterable<PcmProductGroup> pcmProductGroupList) {
		if (pcmProductGroupList != null) {
			List<BPcmProductGroup> boList = new ArrayList<BPcmProductGroup>();
			for (PcmProductGroup pcmProductGroup : pcmProductGroupList) {
				boList.add(pcmProductGroup.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmProductGroup> convertToEntityList(Iterable<BPcmProductGroup> bPcmProductGroupList) {
		if (bPcmProductGroupList != null) {
			List<PcmProductGroup> pcmProductGroupList = new ArrayList<PcmProductGroup>();
			for (BPcmProductGroup bPcmProductGroup : bPcmProductGroupList) {
				pcmProductGroupList.add(new PcmProductGroup(bPcmProductGroup));
			}
			return pcmProductGroupList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}