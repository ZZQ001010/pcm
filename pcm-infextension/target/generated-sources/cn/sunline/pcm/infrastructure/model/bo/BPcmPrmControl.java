package cn.sunline.pcm.infrastructure.model.bo;

import java.io.Serializable;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 参数范围控制表
 */
@SuppressWarnings("serial")
@LogicalName("参数范围控制表")
public class BPcmPrmControl implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("受控参数")
    private String paramClass;
    
	@LogicalName("参数名称")
    private String paramClassLabel;
    
	@LogicalName("参数属性")
    private String paramField;
    
	@LogicalName("属性名称")
    private String paramFieldLabel;
    
	@LogicalName("最小值")
    private String minValue;
    
	@LogicalName("最大值")
    private String maxValue;
    
	@LogicalName("JPA_VERSION")
    private Integer jpaVersion;
    
	public static final String P_ID = "id";
	
	public static final String P_PARAM_CLASS = "paramClass";
	
	public static final String P_PARAM_CLASS_LABEL = "paramClassLabel";
	
	public static final String P_PARAM_FIELD = "paramField";
	
	public static final String P_PARAM_FIELD_LABEL = "paramFieldLabel";
	
	public static final String P_MIN_VALUE = "minValue";
	
	public static final String P_MAX_VALUE = "maxValue";
	
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
	 * <p>受控参数</p>
	 */
	public String getParamClass() {
		return paramClass;
	}
	
	/**
	 * <p>受控参数</p>
	 */
	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}
	
	/**
	 * <p>参数名称</p>
	 */
	public String getParamClassLabel() {
		return paramClassLabel;
	}
	
	/**
	 * <p>参数名称</p>
	 */
	public void setParamClassLabel(String paramClassLabel) {
		this.paramClassLabel = paramClassLabel;
	}
	
	/**
	 * <p>参数属性</p>
	 */
	public String getParamField() {
		return paramField;
	}
	
	/**
	 * <p>参数属性</p>
	 */
	public void setParamField(String paramField) {
		this.paramField = paramField;
	}
	
	/**
	 * <p>属性名称</p>
	 */
	public String getParamFieldLabel() {
		return paramFieldLabel;
	}
	
	/**
	 * <p>属性名称</p>
	 */
	public void setParamFieldLabel(String paramFieldLabel) {
		this.paramFieldLabel = paramFieldLabel;
	}
	
	/**
	 * <p>最小值</p>
	 */
	public String getMinValue() {
		return minValue;
	}
	
	/**
	 * <p>最小值</p>
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	
	/**
	 * <p>最大值</p>
	 */
	public String getMaxValue() {
		return maxValue;
	}
	
	/**
	 * <p>最大值</p>
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
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