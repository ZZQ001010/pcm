package cn.sunline.pcm.controller.vo;

import java.util.List;


/**
 *产品组件树 (产品模板)
 * @author zzq
 * @date 2019年7月22日
 *
 */
public class VProductUnitTree {

	private String unitCode ; 
	
	
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * 产品组件id
	 */
	private String id;
	
	/**
	 * 子组件
	 */
	private List<VProductUnitTree> children;
	
	/**
	 * 组件的唯一id
	 */
	
	private String value ; 
	
	/**
	 * 国际化名称
	 */
	private String unitName;
	
	/**
	 * 中文名称
	 */
	private String unitNameCn;
	
	/**
	 * 这个属性主要是为了兼容前端框架
	 * 这个字段的意思是组件的序号,如果不为空，说明此组件为产品关联组件， 组件可以实现排序，如果为空，说明是组件关联的组件
	 */
	private Integer unitParamId; 

	
	public Integer getUnitParamId() {
		return unitParamId;
	}

	public void setUnitParamId(Integer unitParamId) {
		this.unitParamId = unitParamId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public List<VProductUnitTree> getChildren() {
		return children;
	}

	public void setChildren(List<VProductUnitTree> children) {
		this.children = children;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnitNameCn() {
		return unitNameCn;
	}

	public void setUnitNameCn(String unitNameCn) {
		this.unitNameCn = unitNameCn;
	}
	
	
	
	
	
	
	
	
}
