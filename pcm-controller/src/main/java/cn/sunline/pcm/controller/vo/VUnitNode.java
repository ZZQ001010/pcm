package cn.sunline.pcm.controller.vo;

/**
 * 用来接收前端 产品工厂组件的修改
 * @author zzq
 * @date 2019年8月8日
 *
 */
public class VUnitNode {
	/**
	 * 产品名称
	 */
	private String  productCode;
	/**
	 * 当前组件的主键
	 */
	private String paramKey;
	/**
	 * 当前组件编码
	 */
	private String unitCode;
	/**
	 * 当前组件父组件编码
	 */
	private String parentUnitCode;

	/**
	 * 父关联组件的id
	 * 
	 */
	private String  parentId ;
	
	/**
	 * 当前组件父组件的主键
	 */
	private String  parentParamKey;
	
	
	/**
	 * ture 产品组件添加关联项目, false null 产品添加组件
	 * @return
	 */
	private Boolean root ; 	
	
	
	
	
 
	public Boolean getRoot() {
		return root;
	}
	public void setRoot(Boolean root) {
		this.root = root;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getParamKey() {
		return paramKey;
	}
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getParentUnitCode() {
		return parentUnitCode;
	}
	public void setParentUnitCode(String parentUnitCode) {
		this.parentUnitCode = parentUnitCode;
	}
	@Override
	public String toString() {
		return "VUnitNode [productCode=" + productCode + ", paramKey=" + paramKey + ", unitCode=" + unitCode
				+ ", parentUnitCode=" + parentUnitCode + ", parentParamKey=" + parentParamKey + "]";
	}
	public String getParentParamKey() {
		return parentParamKey;
	}
	public void setParentParamKey(String parentParamKey) {
		this.parentParamKey = parentParamKey;
	}
	
	
	
}
