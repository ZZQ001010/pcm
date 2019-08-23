package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 非金融控制字段定义
* @author fanghj
 *
 */
public class NfControlField implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 字段编码
	 */
	@PropertyInfo(name="字段编码", length=30)
	public String fieldCode;
	/*
	 * 字段名称
	 */
	@PropertyInfo(name="字段名称", length=80)
	public String fieldName;
	/*
	 * 优先级
	 */
	@PropertyInfo(name="优先级", length=3)
	public Integer priority;
	
	public String getFieldCode() {
		return fieldCode;
	}
	
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public Integer getPriority() {
		return priority;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
