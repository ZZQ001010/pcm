package cn.sunline.pcm.infrastructure.model.bo;

import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import java.io.Serializable;
import java.util.Date;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * PCM_PRM_AUDIT
 */
@SuppressWarnings("serial")
@LogicalName("PCM_PRM_AUDIT")
public class BPcmPrmAudit implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("所属机构")
    private String org;
    
	@LogicalName("参数主键")
    private String paramKey;
    
	@LogicalName("参数类别")
    private String paramClass;
    
	@LogicalName("操作")
    private ParamOperationDef paramOperation;
    
	@LogicalName("原参数值")
    private String oldObject;
    
	@LogicalName("新参数值")
    private String newObject;
    
	@LogicalName("修改日志")
    private String updateLog;
    
	@LogicalName("修改用户")
    private String mtnUser;
    
	@LogicalName("操作时间")
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
	
}