package cn.sunline.pcm.infrastructure.model.bo;

import java.io.Serializable;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 机构参数表
 */
@SuppressWarnings("serial")
@LogicalName("机构参数表")
public class BPcmOrgParametter implements Serializable {
		
	@LogicalName("机构编码")
    private String orgCode;
    
	@LogicalName("机构名称")
    private String orgName;
    
	@LogicalName("机构地址")
    private String orgAddress;
    
	@LogicalName("机构级别")
    private String orgLevel;
    
	@LogicalName("上级机构编码")
    private String parentOrgCode;
    
	@LogicalName("机构联系电话")
    private String orgContactPhone;
    
	public static final String P_ORG_CODE = "orgCode";
	
	public static final String P_ORG_NAME = "orgName";
	
	public static final String P_ORG_ADDRESS = "orgAddress";
	
	public static final String P_ORG_LEVEL = "orgLevel";
	
	public static final String P_PARENT_ORG_CODE = "parentOrgCode";
	
	public static final String P_ORG_CONTACT_PHONE = "orgContactPhone";
	
	
	/**
	 * <p>机构编码</p>
	 */
	public String getOrgCode() {
		return orgCode;
	}
	
	/**
	 * <p>机构编码</p>
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	/**
	 * <p>机构名称</p>
	 */
	public String getOrgName() {
		return orgName;
	}
	
	/**
	 * <p>机构名称</p>
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	/**
	 * <p>机构地址</p>
	 */
	public String getOrgAddress() {
		return orgAddress;
	}
	
	/**
	 * <p>机构地址</p>
	 */
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	
	/**
	 * <p>机构级别</p>
	 */
	public String getOrgLevel() {
		return orgLevel;
	}
	
	/**
	 * <p>机构级别</p>
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	
	/**
	 * <p>上级机构编码</p>
	 */
	public String getParentOrgCode() {
		return parentOrgCode;
	}
	
	/**
	 * <p>上级机构编码</p>
	 */
	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}
	
	/**
	 * <p>机构联系电话</p>
	 */
	public String getOrgContactPhone() {
		return orgContactPhone;
	}
	
	/**
	 * <p>机构联系电话</p>
	 */
	public void setOrgContactPhone(String orgContactPhone) {
		this.orgContactPhone = orgContactPhone;
	}
	
}