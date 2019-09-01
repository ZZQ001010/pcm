package cn.sunline.pcm.controller.vo;

public class VProductZtree {
	private String keyId;
	private String id;
	private String pid;
	private String name;
	private String nameCn;
	private String productKind;
	private Integer index;
	private Boolean isParentNode;
	public static final String P_INDEX = "index";
	public static final String P_KEYID = "keyId";
	public static final String P_PRODUCTKIND = "productKind";
	public static final String P_ID = "id";
	public static final String P_PID = "pid";
	public static final String P_NAME = "name";
	public static final String P_NAMECN = "nameCn";
	public static final Boolean P_ISPARENTNODE = true;
	
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public Boolean getIsParentNode() {
		return isParentNode;
	}
	public void setIsParentNode(Boolean isParentNode) {
		this.isParentNode = isParentNode;
	}
	public String getProductKind() {
		return productKind;
	}
	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
