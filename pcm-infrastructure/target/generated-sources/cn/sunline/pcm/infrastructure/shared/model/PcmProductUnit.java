package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.enums.Indicator;
import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnit;
import cn.sunline.ppy.dictionary.enums.ProductType;
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
import javax.persistence.Lob;
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
 * 产品组件表
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("产品组件表")
@Table(name="PCM_PRODUCT_UNIT",uniqueConstraints = {@UniqueConstraint(columnNames={"ORG","PRODUCT_TYPE","UNIT_CODE"})})
public class PcmProductUnit implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRODUCT_UNIT";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmProductUnit")
	@GenericGenerator(name = "idGeneratorPcmProductUnit", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRODUCT_UNIT")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("产品组件所属分组")
	@Column(name="PRODUCT_UNIT_GROUP", nullable=false, length=100)
	private String productUnitGroup;
		
	@LogicalName("所属机构")
	@Column(name="ORG", nullable=false, length=12)
	private String org;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("产品类型")
	@Column(name="PRODUCT_TYPE", nullable=false)
	private ProductType productType;
		
	@LogicalName("产品组件编码")
	@Column(name="UNIT_CODE", nullable=false, length=32)
	private String unitCode;
		
	@LogicalName("产品组件类型")
	@Column(name="UNIT_MODULE", nullable=false, length=30)
	private String unitModule;
		
	@LogicalName("产品组件国际化名称")
	@Column(name="UNIT_NAME", nullable=false, length=200)
	private String unitName;
		
	@LogicalName("产品组件中文名称")
	@Column(name="UNIT_NAME_CN", nullable=true, length=200)
	private String unitNameCn;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("是否允许多选")
	@Column(name="MULTIPLE", nullable=true)
	private Indicator multiple;
		
	@LogicalName("产品组件序号")
	@Column(name="UNIT_INDEX", nullable=false)
	private Integer unitIndex;
		
	@Lob
	@LogicalName("关联组件")
	@Column(name="UNIT_RELATIONS", nullable=true, length=0)
	private String unitRelations;
		
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
	@Column(name="JPA_VERSION", nullable=true)
	@Version
	private Integer jpaVersion;
		
	public static final String P_ID = "id";
	
	public static final String P_PRODUCT_UNIT_GROUP = "productUnitGroup";
	
	public static final String P_ORG = "org";
	
	public static final String P_PRODUCT_TYPE = "productType";
	
	public static final String P_UNIT_CODE = "unitCode";
	
	public static final String P_UNIT_MODULE = "unitModule";
	
	public static final String P_UNIT_NAME = "unitName";
	
	public static final String P_UNIT_NAME_CN = "unitNameCn";
	
	public static final String P_MULTIPLE = "multiple";
	
	public static final String P_UNIT_INDEX = "unitIndex";
	
	public static final String P_UNIT_RELATIONS = "unitRelations";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	public PcmProductUnit () {};
	
	public PcmProductUnit (BPcmProductUnit bPcmProductUnit) {
		this.fillValueFromBO(bPcmProductUnit);
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
	 * <p>产品组件所属分组</p>
	 * <p>产品组件所属分组</p>
	 */
	public String getProductUnitGroup() {
		return productUnitGroup;
	}
	
	/**
	 * <p>产品组件所属分组</p>
	 * <p>产品组件所属分组</p>
	 */
	public void setProductUnitGroup(String productUnitGroup) {
		this.productUnitGroup = productUnitGroup;
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
	 * <p>产品类型</p>
	 */
	public ProductType getProductType() {
		return productType;
	}
	
	/**
	 * <p>产品类型</p>
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
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
	 * <p>产品组件类型</p>
	 */
	public String getUnitModule() {
		return unitModule;
	}
	
	/**
	 * <p>产品组件类型</p>
	 */
	public void setUnitModule(String unitModule) {
		this.unitModule = unitModule;
	}
	
	/**
	 * <p>产品组件国际化名称</p>
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * <p>产品组件国际化名称</p>
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
	 * <p>产品组件中文名称</p>
	 */
	public String getUnitNameCn() {
		return unitNameCn;
	}
	
	/**
	 * <p>产品组件中文名称</p>
	 */
	public void setUnitNameCn(String unitNameCn) {
		this.unitNameCn = unitNameCn;
	}
	
	/**
	 * <p>是否允许多选</p>
	 */
	public Indicator getMultiple() {
		return multiple;
	}
	
	/**
	 * <p>是否允许多选</p>
	 */
	public void setMultiple(Indicator multiple) {
		this.multiple = multiple;
	}
	
	/**
	 * <p>产品组件序号</p>
	 */
	public Integer getUnitIndex() {
		return unitIndex;
	}
	
	/**
	 * <p>产品组件序号</p>
	 */
	public void setUnitIndex(Integer unitIndex) {
		this.unitIndex = unitIndex;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public String getUnitRelations() {
		return unitRelations;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public void setUnitRelations(String unitRelations) {
		this.unitRelations = unitRelations;
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
		map.put(P_PRODUCT_UNIT_GROUP, productUnitGroup);
		map.put(P_ORG, org);
		map.put(P_PRODUCT_TYPE, productType == null ? null : productType.toString());
		map.put(P_UNIT_CODE, unitCode);
		map.put(P_UNIT_MODULE, unitModule);
		map.put(P_UNIT_NAME, unitName);
		map.put(P_UNIT_NAME_CN, unitNameCn);
		map.put(P_MULTIPLE, multiple == null ? null : multiple.toString());
		map.put(P_UNIT_INDEX, unitIndex);
		map.put(P_UNIT_RELATIONS, unitRelations);
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
		if (map.containsKey(P_PRODUCT_UNIT_GROUP)) { this.setProductUnitGroup(DataTypeUtils.getStringValue(map.get(P_PRODUCT_UNIT_GROUP))); }
		if (map.containsKey(P_ORG)) { this.setOrg(DataTypeUtils.getStringValue(map.get(P_ORG))); }
		if (map.containsKey(P_PRODUCT_TYPE)) { this.setProductType(DataTypeUtils.getEnumValue(map.get(P_PRODUCT_TYPE), ProductType.class)); }
		if (map.containsKey(P_UNIT_CODE)) { this.setUnitCode(DataTypeUtils.getStringValue(map.get(P_UNIT_CODE))); }
		if (map.containsKey(P_UNIT_MODULE)) { this.setUnitModule(DataTypeUtils.getStringValue(map.get(P_UNIT_MODULE))); }
		if (map.containsKey(P_UNIT_NAME)) { this.setUnitName(DataTypeUtils.getStringValue(map.get(P_UNIT_NAME))); }
		if (map.containsKey(P_UNIT_NAME_CN)) { this.setUnitNameCn(DataTypeUtils.getStringValue(map.get(P_UNIT_NAME_CN))); }
		if (map.containsKey(P_MULTIPLE)) { this.setMultiple(DataTypeUtils.getEnumValue(map.get(P_MULTIPLE), Indicator.class)); }
		if (map.containsKey(P_UNIT_INDEX)) { this.setUnitIndex(DataTypeUtils.getIntegerValue(map.get(P_UNIT_INDEX))); }
		if (map.containsKey(P_UNIT_RELATIONS)) { this.setUnitRelations(DataTypeUtils.getStringValue(map.get(P_UNIT_RELATIONS))); }
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
		if (productUnitGroup == null) { productUnitGroup = ""; }
		if (org == null) { org = ""; }
		if (productType == null) { productType = null; }
		if (unitCode == null) { unitCode = ""; }
		if (unitModule == null) { unitModule = ""; }
		if (unitName == null) { unitName = ""; }
		if (unitNameCn == null) { unitNameCn = ""; }
		if (multiple == null) { multiple = null; }
		if (unitIndex == null) { unitIndex = 0; }
		if (unitRelations == null) { unitRelations = ""; }
		if (createTime == null) { createTime = new Date(); }
		if (createUser == null) { createUser = ""; }
		if (lstUpdTime == null) { lstUpdTime = new Date(); }
		if (lstUpdUser == null) { lstUpdUser = ""; }
		if (jpaVersion == null) { jpaVersion = 0; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmProductUnit toBO() {
		BPcmProductUnit bPcmProductUnit = new BPcmProductUnit();
		bPcmProductUnit.setId(this.getId());
		bPcmProductUnit.setProductUnitGroup(this.getProductUnitGroup());
		bPcmProductUnit.setOrg(this.getOrg());
		bPcmProductUnit.setProductType(this.getProductType());
		bPcmProductUnit.setUnitCode(this.getUnitCode());
		bPcmProductUnit.setUnitModule(this.getUnitModule());
		bPcmProductUnit.setUnitName(this.getUnitName());
		bPcmProductUnit.setUnitNameCn(this.getUnitNameCn());
		bPcmProductUnit.setMultiple(this.getMultiple());
		bPcmProductUnit.setUnitIndex(this.getUnitIndex());
		bPcmProductUnit.setUnitRelations(this.getUnitRelations());
		bPcmProductUnit.setCreateTime(this.getCreateTime());
		bPcmProductUnit.setCreateUser(this.getCreateUser());
		bPcmProductUnit.setLstUpdTime(this.getLstUpdTime());
		bPcmProductUnit.setLstUpdUser(this.getLstUpdUser());
		bPcmProductUnit.setJpaVersion(this.getJpaVersion());
		return bPcmProductUnit;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmProductUnit fillValueFromBO(BPcmProductUnit bPcmProductUnit) {
		this.setId(bPcmProductUnit.getId());
		this.setProductUnitGroup(bPcmProductUnit.getProductUnitGroup());
		this.setOrg(bPcmProductUnit.getOrg());
		this.setProductType(bPcmProductUnit.getProductType());
		this.setUnitCode(bPcmProductUnit.getUnitCode());
		this.setUnitModule(bPcmProductUnit.getUnitModule());
		this.setUnitName(bPcmProductUnit.getUnitName());
		this.setUnitNameCn(bPcmProductUnit.getUnitNameCn());
		this.setMultiple(bPcmProductUnit.getMultiple());
		this.setUnitIndex(bPcmProductUnit.getUnitIndex());
		this.setUnitRelations(bPcmProductUnit.getUnitRelations());
		this.setCreateTime(bPcmProductUnit.getCreateTime());
		this.setCreateUser(bPcmProductUnit.getCreateUser());
		this.setLstUpdTime(bPcmProductUnit.getLstUpdTime());
		this.setLstUpdUser(bPcmProductUnit.getLstUpdUser());
		this.setJpaVersion(bPcmProductUnit.getJpaVersion());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmProductUnit updateValueFromBO(BPcmProductUnit bPcmProductUnit) {
		if(bPcmProductUnit.getProductUnitGroup() != null){
			this.setProductUnitGroup(bPcmProductUnit.getProductUnitGroup());
		}
		if(bPcmProductUnit.getOrg() != null){
			this.setOrg(bPcmProductUnit.getOrg());
		}
		if(bPcmProductUnit.getProductType() != null){
			this.setProductType(bPcmProductUnit.getProductType());
		}
		if(bPcmProductUnit.getUnitCode() != null){
			this.setUnitCode(bPcmProductUnit.getUnitCode());
		}
		if(bPcmProductUnit.getUnitModule() != null){
			this.setUnitModule(bPcmProductUnit.getUnitModule());
		}
		if(bPcmProductUnit.getUnitName() != null){
			this.setUnitName(bPcmProductUnit.getUnitName());
		}
		if(bPcmProductUnit.getUnitNameCn() != null){
			this.setUnitNameCn(bPcmProductUnit.getUnitNameCn());
		}
		if(bPcmProductUnit.getMultiple() != null){
			this.setMultiple(bPcmProductUnit.getMultiple());
		}
		if(bPcmProductUnit.getUnitIndex() != null){
			this.setUnitIndex(bPcmProductUnit.getUnitIndex());
		}
		if(bPcmProductUnit.getUnitRelations() != null){
			this.setUnitRelations(bPcmProductUnit.getUnitRelations());
		}
		if(bPcmProductUnit.getLstUpdTime() != null){
			this.setLstUpdTime(bPcmProductUnit.getLstUpdTime());
		}
		if(bPcmProductUnit.getLstUpdUser() != null){
			this.setLstUpdUser(bPcmProductUnit.getLstUpdUser());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmProductUnit> convertToBOList(Iterable<PcmProductUnit> pcmProductUnitList) {
		if (pcmProductUnitList != null) {
			List<BPcmProductUnit> boList = new ArrayList<BPcmProductUnit>();
			for (PcmProductUnit pcmProductUnit : pcmProductUnitList) {
				boList.add(pcmProductUnit.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmProductUnit> convertToEntityList(Iterable<BPcmProductUnit> bPcmProductUnitList) {
		if (bPcmProductUnitList != null) {
			List<PcmProductUnit> pcmProductUnitList = new ArrayList<PcmProductUnit>();
			for (BPcmProductUnit bPcmProductUnit : bPcmProductUnitList) {
				pcmProductUnitList.add(new PcmProductUnit(bPcmProductUnit));
			}
			return pcmProductUnitList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}