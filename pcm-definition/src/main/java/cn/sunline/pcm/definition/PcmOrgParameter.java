/**
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月10日
*
*/
package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;


/**
 * @author BlueMelancholy
 * 2019年7月10日
 * 机构参数
 */
@SuppressWarnings("serial")
public class PcmOrgParameter implements Serializable{

	/**
	 * 机构编码（主键）
	 */
	@PropertyInfo(name = "机构编码",length=32)
	public String orgCode;
	
	/**
	 * 机构名称
	 */
	@PropertyInfo(name="机构名称",length=32)
	public String orgName;
	
	/**
	 * 机构地址
	 */
	@PropertyInfo(name="机构地址",length=200)
	public String orgAddress;
		
	/**
	 * 机构级别
	 */
	@PropertyInfo(name="机构级别",length=32)
	public String orgLevel;
		
	/**
	 * 上级机构编码
	 */
	@PropertyInfo(name="上级机构编码",length=32)
	public String parentOrgCode;
		
	/**
	 * 联系电话
	 */
	@PropertyInfo(name="联系电话",length=32)
	public String orgContactPhone;
	
	/**
	 * 机构联系人
	 */
	@PropertyInfo(name="机构联系人",length=32)
	public String orgContactPerson;
	
	/**
	 * 业务范围
	 */
	@PropertyInfo(name="业务范围",length=32)
	public String bussinessScope;
	
	/**
	 * 企业性质代码
	 */
	@PropertyInfo(name="企业性质代码",length=32)
	public String enterpriseNatureCode;
	
	/**
	 * 业务许可有效起期 
	 */
	@PropertyInfo(name="业务许可有效起期 ",length=32)
	public Date businessLicensStartDate;
	
	/**
	 * 业务许可有效止期 
	 */
	@PropertyInfo(name="业务许可有效止期 ",length=32)
	public Date businessLicensEndDate;
	
	
	/**
	 * 注册资本
	 */
	@PropertyInfo(name="注册资本",length=32)
	public String registeredCapital;
	
	/**
	 * 注册资本货币代码 
	 */
	@PropertyInfo(name="注册资本货币代码 ",length=32)
	public String regCapitalCurrencyCod;
	
	/**
	 * 统一社会信用代码
	 */
	@PropertyInfo(name="统一社会信用代码",length=32)
	public String unifiedSocialCreditCode;
	
	/**
	 * 组织机构代码 
	 */
	@PropertyInfo(name="组织机构代码 ",length=32)
	public String organizationCode;
	/**
	 * 税务登记号码 
	 */
	@PropertyInfo(name="税务登记号码 ",length=32)
	public String taxRegNum;
	/**
	 * 营业执照号码 
	 */
	@PropertyInfo(name="营业执照号码 ",length=32)
	public String businessNo;
	/**
	 * 监管辖区代码 
	 */
	@PropertyInfo(name="监管辖区代码 ",length=32)
	public String supervisoryJurisdictionCod;
	/**
	 * 注册地 
	 */
	@PropertyInfo(name="注册地 ",length=32)
	public String registration;
	/**
	 * 经营场所 
	 */
	@PropertyInfo(name="经营场所",length=32)
	public String busPlace;
	/**
	 * 经营场所邮编 
	 */
	@PropertyInfo(name="经营场所邮编 ",length=32)
	public String busPlaceZipCode;
	/**
	 * 传真
	 */
	@PropertyInfo(name="传真",length=32)
	public String fax;
	
	/**
	 * 营业执照有效起期 
	 */
	@PropertyInfo(name="营业执照有效起期 ",length=32)
	public Date  busCertificateStartDate;
	
	/**
	 * 营业执照有效止期 
	 */
	@PropertyInfo(name="营业执照有效止期 ",length=32)
	public Date busCertificateEndDate;
	
	
	public String getValue(){
		return this.getOrgCode()+"-"+this.getOrgName();
	}
	
	
	public String getBussinessScope() {
		return bussinessScope;
	}

	public void setBussinessScope(String bussinessScope) {
		this.bussinessScope = bussinessScope;
	}

	public String getEnterpriseNatureCode() {
		return enterpriseNatureCode;
	}

	public void setEnterpriseNatureCode(String enterpriseNatureCode) {
		this.enterpriseNatureCode = enterpriseNatureCode;
	}

	public Date getBusinessLicensStartDate() {
		return businessLicensStartDate;
	}

	public void setBusinessLicensStartDate(Date businessLicensStartDate) {
		this.businessLicensStartDate = businessLicensStartDate;
	}

	public Date getBusinessLicensEndDate() {
		return businessLicensEndDate;
	}

	public void setBusinessLicensEndDate(Date businessLicensEndDate) {
		this.businessLicensEndDate = businessLicensEndDate;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getRegCapitalCurrencyCod() {
		return regCapitalCurrencyCod;
	}

	public void setRegCapitalCurrencyCod(String regCapitalCurrencyCod) {
		this.regCapitalCurrencyCod = regCapitalCurrencyCod;
	}

	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}

	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getTaxRegNum() {
		return taxRegNum;
	}

	public void setTaxRegNum(String taxRegNum) {
		this.taxRegNum = taxRegNum;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getSupervisoryJurisdictionCod() {
		return supervisoryJurisdictionCod;
	}

	public void setSupervisoryJurisdictionCod(String supervisoryJurisdictionCod) {
		this.supervisoryJurisdictionCod = supervisoryJurisdictionCod;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getBusPlace() {
		return busPlace;
	}

	public void setBusPlace(String busPlace) {
		this.busPlace = busPlace;
	}

	public String getBusPlaceZipCode() {
		return busPlaceZipCode;
	}

	public void setBusPlaceZipCode(String busPlaceZipCode) {
		this.busPlaceZipCode = busPlaceZipCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getBusCertificateStartDate() {
		return busCertificateStartDate;
	}

	public void setBusCertificateStartDate(Date busCertificateStartDate) {
		this.busCertificateStartDate = busCertificateStartDate;
	}

	public Date getBusCertificateEndDate() {
		return busCertificateEndDate;
	}

	public void setBusCertificateEndDate(Date busCertificateEndDate) {
		this.busCertificateEndDate = busCertificateEndDate;
	}

	public String getOrgContactPerson() {
		return orgContactPerson;
	}

	public void setOrgContactPerson(String orgContactPerson) {
		this.orgContactPerson = orgContactPerson;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the orgAddress
	 */
	public String getOrgAddress() {
		return orgAddress;
	}

	/**
	 * @param orgAddress the orgAddress to set
	 */
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	/**
	 * @return the orgLevel
	 */
	public String getOrgLevel() {
		return orgLevel;
	}

	/**
	 * @param orgLevel the orgLevel to set
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	/**
	 * @return the parentOrgCode
	 */
	public String getParentOrgCode() {
		return parentOrgCode;
	}

	/**
	 * @param parentOrgCode the parentOrgCode to set
	 */
	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}

	/**
	 * @return the orgContactPhone
	 */
	public String getOrgContactPhone() {
		return orgContactPhone;
	}

	/**
	 * @param orgContactPhone the orgContactPhone to set
	 */
	public void setOrgContactPhone(String orgContactPhone) {
		this.orgContactPhone = orgContactPhone;
	}
	
}
