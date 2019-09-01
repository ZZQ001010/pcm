package vo;

import java.util.List;


/**
 *产品组件树 (产品模板)
 * @author zzq
 * @date 2019年7月22日
 *
 */
public class VProductUnitTree {

	private String unitCode;
	
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
	
	private String name ; 
	
	/**
	 * 国际化名称
	 */
	private String unitName;
	
	/**
	 * 中文名称
	 */
	private String content;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	
	
	
	
	
	
	
	
}
