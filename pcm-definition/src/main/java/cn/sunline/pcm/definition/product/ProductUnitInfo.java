package cn.sunline.pcm.definition.product;

/**
 * <p>
 * 产品组件信息定义
 * </p>
 * 
 * @version 1.0 2018年8月10日 Zcoup 修改内容:初版
 */
public class ProductUnitInfo {

	/**
	 * 组件代码（要求全大写字母且唯一）
	 */
	private String unitCode;

	/**
	 * 国际化名称
	 */
	private String unitName;

	/**
	 * 中文名称
	 */
	private String unitNameCn;

	/**
	 * 配置URL
	 */
	private String unitConfigUrl;

	/**
	 * 详情URL
	 */
	private String unitDetailUrl;

	/**
	 * 基础URL
	 */
	private String unitBaseUrl;

	/**
	 * 参数类型
	 */
	private String unitClass;

	/**
	 * 二级组件类型（默认为null）
	 */
	private Class<? extends Enum<?>> unitSubClass = null;

	/**
	 * 组件索引
	 */
	private Integer unitIndex;

	public ProductUnitInfo() {
	}

	/**
	 * <p>
	 * 创建一个新的ProductUnitInfo实例.
	 * </p>
	 * 
	 * @param unitCode 组件代码（要求全大写字母且唯一）
	 * @param unitName 国际化名称
	 * @param unitNameCn 中文名称
	 * @param unitConfigUrl 配置URL
	 * @param unitDetailUrl 详情URL
	 * @param unitBaseUrl 基础URL
	 * @param unitClass 参数类型
	 */
	public ProductUnitInfo(String unitCode, String unitName, String unitNameCn, String unitConfigUrl,
			String unitDetailUrl, String unitBaseUrl, String unitClass) {
		this(unitCode, unitName, unitNameCn, unitConfigUrl, unitDetailUrl, unitBaseUrl, unitClass, null);
	}

	/**
	 * <p>
	 * 创建一个新的ProductUnitInfo实例.
	 * </p>
	 * 
	 * @param unitCode 组件代码（要求全大写字母且唯一）
	 * @param unitName 国际化名称
	 * @param unitNameCn 中文名称
	 * @param unitConfigUrl 配置URL
	 * @param unitDetailUrl 详情URL
	 * @param unitBaseUrl 基础URL
	 * @param unitClass 参数类型
	 * @param unitSubClass 二级组件类型（默认为null）
	 */
	public ProductUnitInfo(String unitCode, String unitName, String unitNameCn, String unitConfigUrl,
			String unitDetailUrl, String unitBaseUrl, String unitClass, Class<? extends Enum<?>> unitSubClass) {
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.unitNameCn = unitNameCn;
		this.unitConfigUrl = unitConfigUrl;
		this.unitDetailUrl = unitDetailUrl;
		this.unitBaseUrl = unitBaseUrl;
		this.unitClass = unitClass;
		this.unitSubClass = unitSubClass;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitNameCn() {
		return unitNameCn;
	}

	public void setUnitNameCn(String unitNameCn) {
		this.unitNameCn = unitNameCn;
	}

	public String getUnitConfigUrl() {
		return unitConfigUrl;
	}

	public void setUnitConfigUrl(String unitConfigUrl) {
		this.unitConfigUrl = unitConfigUrl;
	}

	public String getUnitDetailUrl() {
		return unitDetailUrl;
	}

	public void setUnitDetailUrl(String unitDetailUrl) {
		this.unitDetailUrl = unitDetailUrl;
	}

	public String getUnitBaseUrl() {
		return unitBaseUrl;
	}

	public void setUnitBaseUrl(String unitBaseUrl) {
		this.unitBaseUrl = unitBaseUrl;
	}

	public String getUnitClass() {
		return unitClass;
	}

	public void setUnitClass(String unitClass) {
		this.unitClass = unitClass;
	}

	public Class<? extends Enum<?>> getUnitSubClass() {
		return unitSubClass;
	}

	public void setUnitSubClass(Class<? extends Enum<?>> unitSubClass) {
		this.unitSubClass = unitSubClass;
	}

	public Integer getUnitIndex() {
		return unitIndex;
	}

	public void setUnitIndex(Integer unitIndex) {
		this.unitIndex = unitIndex;
	}

}
