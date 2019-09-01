package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.CompanyType;

/**
 * 服务方基本信息
 * @author 杨贵博
 *
 */
public class ServerInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PropertyInfo(name="服务方编码", length=15)
	public String  serverCode;
	
	@PropertyInfo(name="服务方描述", length=50)
	public String  serverDesc;
	
	@PropertyInfo(name="联系电话", length=11)
	public String  phone;
	
	@PropertyInfo(name="联系人", length=32)
	public String  linkman;
	
	@PropertyInfo(name="传真", length=8)
	public String  fax;
	
	@PropertyInfo(name="电子邮箱", length=50)
	public String  email;
	
	/*************************营业执照信息************************/
	/**
	 * 名称
	 */
	@PropertyInfo(name="名称", length=50)
	public String  companyName;
	
	/**
	 * 登记机关
	 */
	@PropertyInfo(name="登记机关",length=30)
	public String registrationAuthority; 
	
	/**
	 * 成立时间
	 */
	@PropertyInfo(name="成立时间")
	public Date registerDate; 
	
	/**
	 * 统一社会信用代码
	 */
	@PropertyInfo(name="统一社会信用代码")
	public String unifySocialCreditCode ; 
	
	/**
	 * 类型
	 */
	@PropertyInfo(name="类型")
	public CompanyType companyType;
	
	
	/**
	 * 营业期限有限期起始日期
	 */
	@PropertyInfo(name="营业期限有限期起始日期")
	public Date businessBeginDate ; 
	
	/**
	 * 营业期限有限期截止日期
	 */
	@PropertyInfo(name="营业期限有限期截止日期")
	public Date businessEndDate ;
	
	/**
	 * 营业执照号码
	 */
	@PropertyInfo(name="营业执照号码",length=15)
	public String businessLicenseNumber; 
	
	/**
	 * 实收资本 （此处需要关联币种，在全段页面显示币种）
	 */
	@PropertyInfo(name="实收资本")
	public Sum  paidInCapital; 
	
	/**
	 * 法定代表人
	 */
	@PropertyInfo(name="法定代表人",length=15)
	public String  legalPerson; 
	
	/**
	 * 注册资金 （此处需要关联币种，在全段页面显示币种）
	 */
	@PropertyInfo(name="注册资本")
	public Sum registerMoney;
	
	/**
	 * 登记时间
	 */
	@PropertyInfo(name="登记时间")
	public Date register; 
	
	/**
	 * 住所
	 */
	@PropertyInfo(name="住所")
	public Address  residence; 
	
	
	/**
	 * 经营范围
	 */
	@PropertyInfo(name="经营范围",length=200)
	public String businessScope;
	
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegistrationAuthority() {
		return registrationAuthority;
	}

	public void setRegistrationAuthority(String registrationAuthority) {
		this.registrationAuthority = registrationAuthority;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUnifySocialCreditCode() {
		return unifySocialCreditCode;
	}

	public void setUnifySocialCreditCode(String unifySocialCreditCode) {
		this.unifySocialCreditCode = unifySocialCreditCode;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public Date getBusinessBeginDate() {
		return businessBeginDate;
	}

	public void setBusinessBeginDate(Date businessBeginDate) {
		this.businessBeginDate = businessBeginDate;
	}

	public Date getBusinessEndDate() {
		return businessEndDate;
	}

	public void setBusinessEndDate(Date businessEndDate) {
		this.businessEndDate = businessEndDate;
	}

	public String getBusinessLicenseNumber() {
		return businessLicenseNumber;
	}

	public void setBusinessLicenseNumber(String businessLicenseNumber) {
		this.businessLicenseNumber = businessLicenseNumber;
	}

	public Sum getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(Sum paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public Sum getRegisterMoney() {
		return registerMoney;
	}

	public void setRegisterMoney(Sum registerMoney) {
		this.registerMoney = registerMoney;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}

	public Address getResidence() {
		return residence;
	}

	public void setResidence(Address residence) {
		this.residence = residence;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getServerDesc() {
		return serverDesc;
	}

	public void setServerDesc(String serverDesc) {
		this.serverDesc = serverDesc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
