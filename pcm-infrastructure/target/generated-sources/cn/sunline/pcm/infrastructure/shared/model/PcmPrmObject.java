package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * PCM_PRM_OBJECT
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("PCM_PRM_OBJECT")
@Table(name="PCM_PRM_OBJECT",uniqueConstraints = {@UniqueConstraint(columnNames={"ORG","PARAM_CLASS","PARAM_KEY"})})
public class PcmPrmObject implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRM_OBJECT";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmPrmObject")
	@GenericGenerator(name = "idGeneratorPcmPrmObject", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRM_OBJECT")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("所属机构")
	@Column(name="ORG", nullable=false, length=12)
	private String org;
		
	@LogicalName("参数类别")
	@Column(name="PARAM_CLASS", nullable=false, length=128)
	private String paramClass;
		
	@LogicalName("参数主键")
	@Column(name="PARAM_KEY", nullable=false, length=64)
	private String paramKey;
		
	@Lob
	@LogicalName("PARAM_OBJECT")
	@Column(name="PARAM_OBJECT", nullable=false, length=0)
	private String paramObject;
		
	@Temporal(value=TemporalType.TIMESTAMP)
	@LogicalName("创建时间")
	@Column(name="CREATE_TIME", nullable=true, updatable = false)
	private Date createTime;
		
	@LogicalName("创建人")
	@Column(name="CREATE_USER", nullable=true, updatable = false, length=30)
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
	
	public static final String P_ORG = "org";
	
	public static final String P_PARAM_CLASS = "paramClass";
	
	public static final String P_PARAM_KEY = "paramKey";
	
	public static final String P_PARAM_OBJECT = "paramObject";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	public PcmPrmObject () {};
	
	public PcmPrmObject (BPcmPrmObject bPcmPrmObject) {
		this.fillValueFromBO(bPcmPrmObject);
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
	 * <p>PARAM_OBJECT</p>
	 */
	public String getParamObject() {
		return paramObject;
	}
	
	/**
	 * <p>PARAM_OBJECT</p>
	 */
	public void setParamObject(String paramObject) {
		this.paramObject = paramObject;
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
		map.put(P_ORG, org);
		map.put(P_PARAM_CLASS, paramClass);
		map.put(P_PARAM_KEY, paramKey);
		map.put(P_PARAM_OBJECT, paramObject);
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
		if (map.containsKey(P_ORG)) { this.setOrg(DataTypeUtils.getStringValue(map.get(P_ORG))); }
		if (map.containsKey(P_PARAM_CLASS)) { this.setParamClass(DataTypeUtils.getStringValue(map.get(P_PARAM_CLASS))); }
		if (map.containsKey(P_PARAM_KEY)) { this.setParamKey(DataTypeUtils.getStringValue(map.get(P_PARAM_KEY))); }
		if (map.containsKey(P_PARAM_OBJECT)) { this.setParamObject(DataTypeUtils.getStringValue(map.get(P_PARAM_OBJECT))); }
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
		if (org == null) { org = ""; }
		if (paramClass == null) { paramClass = ""; }
		if (paramKey == null) { paramKey = ""; }
		if (paramObject == null) { paramObject = ""; }
		if (createTime == null) { createTime = new Date(); }
		if (createUser == null) { createUser = ""; }
		if (lstUpdTime == null) { lstUpdTime = new Date(); }
		if (lstUpdUser == null) { lstUpdUser = ""; }
		if (jpaVersion == null) { jpaVersion = 0; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmPrmObject toBO() {
		BPcmPrmObject bPcmPrmObject = new BPcmPrmObject();
		bPcmPrmObject.setId(this.getId());
		bPcmPrmObject.setOrg(this.getOrg());
		bPcmPrmObject.setParamClass(this.getParamClass());
		bPcmPrmObject.setParamKey(this.getParamKey());
		bPcmPrmObject.setParamObject(this.getParamObject());
		bPcmPrmObject.setCreateTime(this.getCreateTime());
		bPcmPrmObject.setCreateUser(this.getCreateUser());
		bPcmPrmObject.setLstUpdTime(this.getLstUpdTime());
		bPcmPrmObject.setLstUpdUser(this.getLstUpdUser());
		bPcmPrmObject.setJpaVersion(this.getJpaVersion());
		return bPcmPrmObject;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmPrmObject fillValueFromBO(BPcmPrmObject bPcmPrmObject) {
		this.setId(bPcmPrmObject.getId());
		this.setOrg(bPcmPrmObject.getOrg());
		this.setParamClass(bPcmPrmObject.getParamClass());
		this.setParamKey(bPcmPrmObject.getParamKey());
		this.setParamObject(bPcmPrmObject.getParamObject());
		this.setCreateTime(bPcmPrmObject.getCreateTime());
		this.setCreateUser(bPcmPrmObject.getCreateUser());
		this.setLstUpdTime(bPcmPrmObject.getLstUpdTime());
		this.setLstUpdUser(bPcmPrmObject.getLstUpdUser());
		this.setJpaVersion(bPcmPrmObject.getJpaVersion());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmPrmObject updateValueFromBO(BPcmPrmObject bPcmPrmObject) {
		if(bPcmPrmObject.getOrg() != null){
			this.setOrg(bPcmPrmObject.getOrg());
		}
		if(bPcmPrmObject.getParamClass() != null){
			this.setParamClass(bPcmPrmObject.getParamClass());
		}
		if(bPcmPrmObject.getParamKey() != null){
			this.setParamKey(bPcmPrmObject.getParamKey());
		}
		if(bPcmPrmObject.getParamObject() != null){
			this.setParamObject(bPcmPrmObject.getParamObject());
		}
		if(bPcmPrmObject.getLstUpdTime() != null){
			this.setLstUpdTime(bPcmPrmObject.getLstUpdTime());
		}
		if(bPcmPrmObject.getLstUpdUser() != null){
			this.setLstUpdUser(bPcmPrmObject.getLstUpdUser());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmPrmObject> convertToBOList(Iterable<PcmPrmObject> pcmPrmObjectList) {
		if (pcmPrmObjectList != null) {
			List<BPcmPrmObject> boList = new ArrayList<BPcmPrmObject>();
			for (PcmPrmObject pcmPrmObject : pcmPrmObjectList) {
				boList.add(pcmPrmObject.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmPrmObject> convertToEntityList(Iterable<BPcmPrmObject> bPcmPrmObjectList) {
		if (bPcmPrmObjectList != null) {
			List<PcmPrmObject> pcmPrmObjectList = new ArrayList<PcmPrmObject>();
			for (BPcmPrmObject bPcmPrmObject : bPcmPrmObjectList) {
				pcmPrmObjectList.add(new PcmPrmObject(bPcmPrmObject));
			}
			return pcmPrmObjectList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}