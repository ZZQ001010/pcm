package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.enums.Indicator;
import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.definition.enums.ProductUnitsURL;
import cn.sunline.pcm.definition.enums.WinSize;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits;
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
 * 产品页面组件表
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("产品页面组件表")
@Table(name="PCM_PRODUCT_UNITS",uniqueConstraints = {@UniqueConstraint(columnNames={"UNIT_CODE","ORG"})})
public class PcmProductUnits implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRODUCT_UNITS";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmProductUnits")
	@GenericGenerator(name = "idGeneratorPcmProductUnits", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRODUCT_UNITS")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("所属机构")
	@Column(name="ORG", nullable=false, length=12)
	private String org;
		
	@LogicalName("产品组件编码")
	@Column(name="UNIT_CODE", nullable=false, length=32)
	private String unitCode;
		
	@LogicalName("分组编码")
	@Column(name="GROUP_CODE", nullable=false, length=32)
	private String groupCode;
		
	@LogicalName("产品组件国际化名称")
	@Column(name="UNIT_NAME", nullable=false, length=200)
	private String unitName;
		
	@LogicalName("产品组件中文名称")
	@Column(name="UNIT_NAME_CN", nullable=false, length=200)
	private String unitNameCn;
		
	@LogicalName("产品组件序号")
	@Column(name="UNIT_INDEX", nullable=false)
	private Integer unitIndex;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("必配组件")
	@Column(name="UNIT_REQUIRED", nullable=false)
	private Indicator unitRequired;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("产品组件")
	@Column(name="UNIT_MODULE", nullable=false)
	private ProductUnitsURL unitModule;
		
	@LogicalName("关联组件")
	@Column(name="UPDATE_UNITS", nullable=true, length=200)
	private String updateUnits;
		
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
		
	@LogicalName("二级组件")
	@Column(name="SUB_UNIT", nullable=true, length=32)
	private String subUnit;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("组件配置窗口")
	@Column(name="UNIT_CONFIG", nullable=true)
	private WinSize unitConfig;
		
	public static final String P_ID = "id";
	
	public static final String P_ORG = "org";
	
	public static final String P_UNIT_CODE = "unitCode";
	
	public static final String P_GROUP_CODE = "groupCode";
	
	public static final String P_UNIT_NAME = "unitName";
	
	public static final String P_UNIT_NAME_CN = "unitNameCn";
	
	public static final String P_UNIT_INDEX = "unitIndex";
	
	public static final String P_UNIT_REQUIRED = "unitRequired";
	
	public static final String P_UNIT_MODULE = "unitModule";
	
	public static final String P_UPDATE_UNITS = "updateUnits";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	public static final String P_SUB_UNIT = "subUnit";
	
	public static final String P_UNIT_CONFIG = "unitConfig";
	
	public PcmProductUnits () {};
	
	public PcmProductUnits (BPcmProductUnits bPcmProductUnits) {
		this.fillValueFromBO(bPcmProductUnits);
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
	 * <p>必配组件</p>
	 */
	public Indicator getUnitRequired() {
		return unitRequired;
	}
	
	/**
	 * <p>必配组件</p>
	 */
	public void setUnitRequired(Indicator unitRequired) {
		this.unitRequired = unitRequired;
	}
	
	/**
	 * <p>产品组件</p>
	 */
	public ProductUnitsURL getUnitModule() {
		return unitModule;
	}
	
	/**
	 * <p>产品组件</p>
	 */
	public void setUnitModule(ProductUnitsURL unitModule) {
		this.unitModule = unitModule;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public String getUpdateUnits() {
		return updateUnits;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public void setUpdateUnits(String updateUnits) {
		this.updateUnits = updateUnits;
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
	 * <p>二级组件</p>
	 */
	public String getSubUnit() {
		return subUnit;
	}
	
	/**
	 * <p>二级组件</p>
	 */
	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	
	/**
	 * <p>组件配置窗口</p>
	 */
	public WinSize getUnitConfig() {
		return unitConfig;
	}
	
	/**
	 * <p>组件配置窗口</p>
	 */
	public void setUnitConfig(WinSize unitConfig) {
		this.unitConfig = unitConfig;
	}
	
	/**
	 * <p>将当前实体对象转化为map返回</p>
	 */
	public Map<String, Serializable> convertToMap() {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		map.put(P_ID, id);
		map.put(P_ORG, org);
		map.put(P_UNIT_CODE, unitCode);
		map.put(P_GROUP_CODE, groupCode);
		map.put(P_UNIT_NAME, unitName);
		map.put(P_UNIT_NAME_CN, unitNameCn);
		map.put(P_UNIT_INDEX, unitIndex);
		map.put(P_UNIT_REQUIRED, unitRequired == null ? null : unitRequired.toString());
		map.put(P_UNIT_MODULE, unitModule == null ? null : unitModule.toString());
		map.put(P_UPDATE_UNITS, updateUnits);
		map.put(P_CREATE_TIME, createTime);
		map.put(P_CREATE_USER, createUser);
		map.put(P_LST_UPD_TIME, lstUpdTime);
		map.put(P_LST_UPD_USER, lstUpdUser);
		map.put(P_JPA_VERSION, jpaVersion);
		map.put(P_SUB_UNIT, subUnit);
		map.put(P_UNIT_CONFIG, unitConfig == null ? null : unitConfig.toString());
		return map;
	}

	/**
	 * <p>从map更新当前实体对象</p>
	 */
	public void updateFromMap(Map<String, Serializable> map) {
		if (map.containsKey(P_ID)) { this.setId(DataTypeUtils.getStringValue(map.get(P_ID))); }
		if (map.containsKey(P_ORG)) { this.setOrg(DataTypeUtils.getStringValue(map.get(P_ORG))); }
		if (map.containsKey(P_UNIT_CODE)) { this.setUnitCode(DataTypeUtils.getStringValue(map.get(P_UNIT_CODE))); }
		if (map.containsKey(P_GROUP_CODE)) { this.setGroupCode(DataTypeUtils.getStringValue(map.get(P_GROUP_CODE))); }
		if (map.containsKey(P_UNIT_NAME)) { this.setUnitName(DataTypeUtils.getStringValue(map.get(P_UNIT_NAME))); }
		if (map.containsKey(P_UNIT_NAME_CN)) { this.setUnitNameCn(DataTypeUtils.getStringValue(map.get(P_UNIT_NAME_CN))); }
		if (map.containsKey(P_UNIT_INDEX)) { this.setUnitIndex(DataTypeUtils.getIntegerValue(map.get(P_UNIT_INDEX))); }
		if (map.containsKey(P_UNIT_REQUIRED)) { this.setUnitRequired(DataTypeUtils.getEnumValue(map.get(P_UNIT_REQUIRED), Indicator.class)); }
		if (map.containsKey(P_UNIT_MODULE)) { this.setUnitModule(DataTypeUtils.getEnumValue(map.get(P_UNIT_MODULE), ProductUnitsURL.class)); }
		if (map.containsKey(P_UPDATE_UNITS)) { this.setUpdateUnits(DataTypeUtils.getStringValue(map.get(P_UPDATE_UNITS))); }
		if (map.containsKey(P_CREATE_TIME)) { this.setCreateTime(DataTypeUtils.getDateValue(map.get(P_CREATE_TIME))); }
		if (map.containsKey(P_CREATE_USER)) { this.setCreateUser(DataTypeUtils.getStringValue(map.get(P_CREATE_USER))); }
		if (map.containsKey(P_LST_UPD_TIME)) { this.setLstUpdTime(DataTypeUtils.getDateValue(map.get(P_LST_UPD_TIME))); }
		if (map.containsKey(P_LST_UPD_USER)) { this.setLstUpdUser(DataTypeUtils.getStringValue(map.get(P_LST_UPD_USER))); }
		if (map.containsKey(P_JPA_VERSION)) { this.setJpaVersion(DataTypeUtils.getIntegerValue(map.get(P_JPA_VERSION))); }
		if (map.containsKey(P_SUB_UNIT)) { this.setSubUnit(DataTypeUtils.getStringValue(map.get(P_SUB_UNIT))); }
		if (map.containsKey(P_UNIT_CONFIG)) { this.setUnitConfig(DataTypeUtils.getEnumValue(map.get(P_UNIT_CONFIG), WinSize.class)); }
	}

	/**
	 * <p>为当前实体对象除了主键字段之外的值为空的成员变量赋予默认值，字符串=""，数字类型字段=0</p>
	 */
	public void fillDefaultValues() {
		if (id == null) { id = ""; }
		if (org == null) { org = ""; }
		if (unitCode == null) { unitCode = ""; }
		if (groupCode == null) { groupCode = ""; }
		if (unitName == null) { unitName = ""; }
		if (unitNameCn == null) { unitNameCn = ""; }
		if (unitIndex == null) { unitIndex = 0; }
		if (unitRequired == null) { unitRequired = null; }
		if (unitModule == null) { unitModule = null; }
		if (updateUnits == null) { updateUnits = ""; }
		if (createTime == null) { createTime = new Date(); }
		if (createUser == null) { createUser = ""; }
		if (lstUpdTime == null) { lstUpdTime = new Date(); }
		if (lstUpdUser == null) { lstUpdUser = ""; }
		if (jpaVersion == null) { jpaVersion = 0; }
		if (subUnit == null) { subUnit = ""; }
		if (unitConfig == null) { unitConfig = null; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmProductUnits toBO() {
		BPcmProductUnits bPcmProductUnits = new BPcmProductUnits();
		bPcmProductUnits.setId(this.getId());
		bPcmProductUnits.setOrg(this.getOrg());
		bPcmProductUnits.setUnitCode(this.getUnitCode());
		bPcmProductUnits.setGroupCode(this.getGroupCode());
		bPcmProductUnits.setUnitName(this.getUnitName());
		bPcmProductUnits.setUnitNameCn(this.getUnitNameCn());
		bPcmProductUnits.setUnitIndex(this.getUnitIndex());
		bPcmProductUnits.setUnitRequired(this.getUnitRequired());
		bPcmProductUnits.setUnitModule(this.getUnitModule());
		bPcmProductUnits.setUpdateUnits(this.getUpdateUnits());
		bPcmProductUnits.setCreateTime(this.getCreateTime());
		bPcmProductUnits.setCreateUser(this.getCreateUser());
		bPcmProductUnits.setLstUpdTime(this.getLstUpdTime());
		bPcmProductUnits.setLstUpdUser(this.getLstUpdUser());
		bPcmProductUnits.setJpaVersion(this.getJpaVersion());
		bPcmProductUnits.setSubUnit(this.getSubUnit());
		bPcmProductUnits.setUnitConfig(this.getUnitConfig());
		return bPcmProductUnits;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmProductUnits fillValueFromBO(BPcmProductUnits bPcmProductUnits) {
		this.setId(bPcmProductUnits.getId());
		this.setOrg(bPcmProductUnits.getOrg());
		this.setUnitCode(bPcmProductUnits.getUnitCode());
		this.setGroupCode(bPcmProductUnits.getGroupCode());
		this.setUnitName(bPcmProductUnits.getUnitName());
		this.setUnitNameCn(bPcmProductUnits.getUnitNameCn());
		this.setUnitIndex(bPcmProductUnits.getUnitIndex());
		this.setUnitRequired(bPcmProductUnits.getUnitRequired());
		this.setUnitModule(bPcmProductUnits.getUnitModule());
		this.setUpdateUnits(bPcmProductUnits.getUpdateUnits());
		this.setCreateTime(bPcmProductUnits.getCreateTime());
		this.setCreateUser(bPcmProductUnits.getCreateUser());
		this.setLstUpdTime(bPcmProductUnits.getLstUpdTime());
		this.setLstUpdUser(bPcmProductUnits.getLstUpdUser());
		this.setJpaVersion(bPcmProductUnits.getJpaVersion());
		this.setSubUnit(bPcmProductUnits.getSubUnit());
		this.setUnitConfig(bPcmProductUnits.getUnitConfig());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmProductUnits updateValueFromBO(BPcmProductUnits bPcmProductUnits) {
		if(bPcmProductUnits.getOrg() != null){
			this.setOrg(bPcmProductUnits.getOrg());
		}
		if(bPcmProductUnits.getUnitCode() != null){
			this.setUnitCode(bPcmProductUnits.getUnitCode());
		}
		if(bPcmProductUnits.getGroupCode() != null){
			this.setGroupCode(bPcmProductUnits.getGroupCode());
		}
		if(bPcmProductUnits.getUnitName() != null){
			this.setUnitName(bPcmProductUnits.getUnitName());
		}
		if(bPcmProductUnits.getUnitNameCn() != null){
			this.setUnitNameCn(bPcmProductUnits.getUnitNameCn());
		}
		if(bPcmProductUnits.getUnitIndex() != null){
			this.setUnitIndex(bPcmProductUnits.getUnitIndex());
		}
		if(bPcmProductUnits.getUnitRequired() != null){
			this.setUnitRequired(bPcmProductUnits.getUnitRequired());
		}
		if(bPcmProductUnits.getUnitModule() != null){
			this.setUnitModule(bPcmProductUnits.getUnitModule());
		}
		if(bPcmProductUnits.getUpdateUnits() != null){
			this.setUpdateUnits(bPcmProductUnits.getUpdateUnits());
		}
		if(bPcmProductUnits.getLstUpdTime() != null){
			this.setLstUpdTime(bPcmProductUnits.getLstUpdTime());
		}
		if(bPcmProductUnits.getLstUpdUser() != null){
			this.setLstUpdUser(bPcmProductUnits.getLstUpdUser());
		}
		if(bPcmProductUnits.getSubUnit() != null){
			this.setSubUnit(bPcmProductUnits.getSubUnit());
		}
		if(bPcmProductUnits.getUnitConfig() != null){
			this.setUnitConfig(bPcmProductUnits.getUnitConfig());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmProductUnits> convertToBOList(Iterable<PcmProductUnits> pcmProductUnitsList) {
		if (pcmProductUnitsList != null) {
			List<BPcmProductUnits> boList = new ArrayList<BPcmProductUnits>();
			for (PcmProductUnits pcmProductUnits : pcmProductUnitsList) {
				boList.add(pcmProductUnits.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmProductUnits> convertToEntityList(Iterable<BPcmProductUnits> bPcmProductUnitsList) {
		if (bPcmProductUnitsList != null) {
			List<PcmProductUnits> pcmProductUnitsList = new ArrayList<PcmProductUnits>();
			for (BPcmProductUnits bPcmProductUnits : bPcmProductUnitsList) {
				pcmProductUnitsList.add(new PcmProductUnits(bPcmProductUnits));
			}
			return pcmProductUnitsList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}