package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * PCM_PRM_AUDIT
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("PCM_PRM_AUDIT")
@Table(name="PCM_PRM_AUDIT")
public class PcmPrmAudit implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRM_AUDIT";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmPrmAudit")
	@GenericGenerator(name = "idGeneratorPcmPrmAudit", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRM_AUDIT")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("所属机构")
	@Column(name="ORG", nullable=true, length=12)
	private String org;
		
	@LogicalName("参数主键")
	@Column(name="PARAM_KEY", nullable=true, length=64)
	private String paramKey;
		
	@LogicalName("参数类别")
	@Column(name="PARAM_CLASS", nullable=true, length=128)
	private String paramClass;
		
	@Enumerated(EnumType.STRING)
	@LogicalName("操作")
	@Column(name="PARAM_OPERATION", nullable=true)
	private ParamOperationDef paramOperation;
		
	@Lob
	@LogicalName("原参数值")
	@Column(name="OLD_OBJECT", nullable=true, length=0)
	private String oldObject;
		
	@Lob
	@LogicalName("新参数值")
	@Column(name="NEW_OBJECT", nullable=true, length=0)
	private String newObject;
		
	@Lob
	@LogicalName("修改日志")
	@Column(name="UPDATE_LOG", nullable=true, length=0)
	private String updateLog;
		
	@LogicalName("修改用户")
	@Column(name="MTN_USER", nullable=true, length=40)
	private String mtnUser;
		
	@Temporal(value=TemporalType.TIMESTAMP)
	@LogicalName("操作时间")
	@Column(name="JPA_TIMESTAMP", nullable=false)
	@Version
	private Date jpaTimestamp;
		
	public static final String P_ID = "id";
	
	public static final String P_ORG = "org";
	
	public static final String P_PARAM_KEY = "paramKey";
	
	public static final String P_PARAM_CLASS = "paramClass";
	
	public static final String P_PARAM_OPERATION = "paramOperation";
	
	public static final String P_OLD_OBJECT = "oldObject";
	
	public static final String P_NEW_OBJECT = "newObject";
	
	public static final String P_UPDATE_LOG = "updateLog";
	
	public static final String P_MTN_USER = "mtnUser";
	
	public static final String P_JPA_TIMESTAMP = "jpaTimestamp";
	
	public PcmPrmAudit () {};
	
	public PcmPrmAudit (BPcmPrmAudit bPcmPrmAudit) {
		this.fillValueFromBO(bPcmPrmAudit);
	};
	
	
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
	 * <p>操作</p>
	 */
	public ParamOperationDef getParamOperation() {
		return paramOperation;
	}
	
	/**
	 * <p>操作</p>
	 */
	public void setParamOperation(ParamOperationDef paramOperation) {
		this.paramOperation = paramOperation;
	}
	
	/**
	 * <p>原参数值</p>
	 */
	public String getOldObject() {
		return oldObject;
	}
	
	/**
	 * <p>原参数值</p>
	 */
	public void setOldObject(String oldObject) {
		this.oldObject = oldObject;
	}
	
	/**
	 * <p>新参数值</p>
	 */
	public String getNewObject() {
		return newObject;
	}
	
	/**
	 * <p>新参数值</p>
	 */
	public void setNewObject(String newObject) {
		this.newObject = newObject;
	}
	
	/**
	 * <p>修改日志</p>
	 */
	public String getUpdateLog() {
		return updateLog;
	}
	
	/**
	 * <p>修改日志</p>
	 */
	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}
	
	/**
	 * <p>修改用户</p>
	 */
	public String getMtnUser() {
		return mtnUser;
	}
	
	/**
	 * <p>修改用户</p>
	 */
	public void setMtnUser(String mtnUser) {
		this.mtnUser = mtnUser;
	}
	
	/**
	 * <p>操作时间</p>
	 */
	public Date getJpaTimestamp() {
		return jpaTimestamp;
	}
	
	/**
	 * <p>操作时间</p>
	 */
	public void setJpaTimestamp(Date jpaTimestamp) {
		this.jpaTimestamp = jpaTimestamp;
	}
	
	/**
	 * <p>将当前实体对象转化为map返回</p>
	 */
	public Map<String, Serializable> convertToMap() {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		map.put(P_ID, id);
		map.put(P_ORG, org);
		map.put(P_PARAM_KEY, paramKey);
		map.put(P_PARAM_CLASS, paramClass);
		map.put(P_PARAM_OPERATION, paramOperation == null ? null : paramOperation.toString());
		map.put(P_OLD_OBJECT, oldObject);
		map.put(P_NEW_OBJECT, newObject);
		map.put(P_UPDATE_LOG, updateLog);
		map.put(P_MTN_USER, mtnUser);
		map.put(P_JPA_TIMESTAMP, jpaTimestamp);
		return map;
	}

	/**
	 * <p>从map更新当前实体对象</p>
	 */
	public void updateFromMap(Map<String, Serializable> map) {
		if (map.containsKey(P_ID)) { this.setId(DataTypeUtils.getStringValue(map.get(P_ID))); }
		if (map.containsKey(P_ORG)) { this.setOrg(DataTypeUtils.getStringValue(map.get(P_ORG))); }
		if (map.containsKey(P_PARAM_KEY)) { this.setParamKey(DataTypeUtils.getStringValue(map.get(P_PARAM_KEY))); }
		if (map.containsKey(P_PARAM_CLASS)) { this.setParamClass(DataTypeUtils.getStringValue(map.get(P_PARAM_CLASS))); }
		if (map.containsKey(P_PARAM_OPERATION)) { this.setParamOperation(DataTypeUtils.getEnumValue(map.get(P_PARAM_OPERATION), ParamOperationDef.class)); }
		if (map.containsKey(P_OLD_OBJECT)) { this.setOldObject(DataTypeUtils.getStringValue(map.get(P_OLD_OBJECT))); }
		if (map.containsKey(P_NEW_OBJECT)) { this.setNewObject(DataTypeUtils.getStringValue(map.get(P_NEW_OBJECT))); }
		if (map.containsKey(P_UPDATE_LOG)) { this.setUpdateLog(DataTypeUtils.getStringValue(map.get(P_UPDATE_LOG))); }
		if (map.containsKey(P_MTN_USER)) { this.setMtnUser(DataTypeUtils.getStringValue(map.get(P_MTN_USER))); }
		if (map.containsKey(P_JPA_TIMESTAMP)) { this.setJpaTimestamp(DataTypeUtils.getDateValue(map.get(P_JPA_TIMESTAMP))); }
	}

	/**
	 * <p>为当前实体对象除了主键字段之外的值为空的成员变量赋予默认值，字符串=""，数字类型字段=0</p>
	 */
	public void fillDefaultValues() {
		if (id == null) { id = ""; }
		if (org == null) { org = ""; }
		if (paramKey == null) { paramKey = ""; }
		if (paramClass == null) { paramClass = ""; }
		if (paramOperation == null) { paramOperation = null; }
		if (oldObject == null) { oldObject = ""; }
		if (newObject == null) { newObject = ""; }
		if (updateLog == null) { updateLog = ""; }
		if (mtnUser == null) { mtnUser = ""; }
		if (jpaTimestamp == null) { jpaTimestamp = new Date(); }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmPrmAudit toBO() {
		BPcmPrmAudit bPcmPrmAudit = new BPcmPrmAudit();
		bPcmPrmAudit.setId(this.getId());
		bPcmPrmAudit.setOrg(this.getOrg());
		bPcmPrmAudit.setParamKey(this.getParamKey());
		bPcmPrmAudit.setParamClass(this.getParamClass());
		bPcmPrmAudit.setParamOperation(this.getParamOperation());
		bPcmPrmAudit.setOldObject(this.getOldObject());
		bPcmPrmAudit.setNewObject(this.getNewObject());
		bPcmPrmAudit.setUpdateLog(this.getUpdateLog());
		bPcmPrmAudit.setMtnUser(this.getMtnUser());
		bPcmPrmAudit.setJpaTimestamp(this.getJpaTimestamp());
		return bPcmPrmAudit;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmPrmAudit fillValueFromBO(BPcmPrmAudit bPcmPrmAudit) {
		this.setId(bPcmPrmAudit.getId());
		this.setOrg(bPcmPrmAudit.getOrg());
		this.setParamKey(bPcmPrmAudit.getParamKey());
		this.setParamClass(bPcmPrmAudit.getParamClass());
		this.setParamOperation(bPcmPrmAudit.getParamOperation());
		this.setOldObject(bPcmPrmAudit.getOldObject());
		this.setNewObject(bPcmPrmAudit.getNewObject());
		this.setUpdateLog(bPcmPrmAudit.getUpdateLog());
		this.setMtnUser(bPcmPrmAudit.getMtnUser());
		this.setJpaTimestamp(bPcmPrmAudit.getJpaTimestamp());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmPrmAudit updateValueFromBO(BPcmPrmAudit bPcmPrmAudit) {
		if(bPcmPrmAudit.getOrg() != null){
			this.setOrg(bPcmPrmAudit.getOrg());
		}
		if(bPcmPrmAudit.getParamKey() != null){
			this.setParamKey(bPcmPrmAudit.getParamKey());
		}
		if(bPcmPrmAudit.getParamClass() != null){
			this.setParamClass(bPcmPrmAudit.getParamClass());
		}
		if(bPcmPrmAudit.getParamOperation() != null){
			this.setParamOperation(bPcmPrmAudit.getParamOperation());
		}
		if(bPcmPrmAudit.getOldObject() != null){
			this.setOldObject(bPcmPrmAudit.getOldObject());
		}
		if(bPcmPrmAudit.getNewObject() != null){
			this.setNewObject(bPcmPrmAudit.getNewObject());
		}
		if(bPcmPrmAudit.getUpdateLog() != null){
			this.setUpdateLog(bPcmPrmAudit.getUpdateLog());
		}
		if(bPcmPrmAudit.getMtnUser() != null){
			this.setMtnUser(bPcmPrmAudit.getMtnUser());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmPrmAudit> convertToBOList(Iterable<PcmPrmAudit> pcmPrmAuditList) {
		if (pcmPrmAuditList != null) {
			List<BPcmPrmAudit> boList = new ArrayList<BPcmPrmAudit>();
			for (PcmPrmAudit pcmPrmAudit : pcmPrmAuditList) {
				boList.add(pcmPrmAudit.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmPrmAudit> convertToEntityList(Iterable<BPcmPrmAudit> bPcmPrmAuditList) {
		if (bPcmPrmAuditList != null) {
			List<PcmPrmAudit> pcmPrmAuditList = new ArrayList<PcmPrmAudit>();
			for (BPcmPrmAudit bPcmPrmAudit : bPcmPrmAuditList) {
				pcmPrmAuditList.add(new PcmPrmAudit(bPcmPrmAudit));
			}
			return pcmPrmAuditList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}