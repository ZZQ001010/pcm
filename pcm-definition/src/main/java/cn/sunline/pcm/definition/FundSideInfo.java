/**
* @ClassName: fundSideBaseInfo
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月11日
*
*/
package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.CompanyType;

/**
 * @author fgy
 * 2019年7月29日
 * 资金方基本信息
 */
@SuppressWarnings("serial")
public class FundSideInfo implements Serializable{

	
	
	/**
	 * 资金方编码
	 */
	@PropertyInfo(name="资金方编码", length=32)
	public String  fundSideCode ;
	
	/**
	 * 资金方描述
	 */
	@PropertyInfo(name="资金方描述", length=32)
	public String  fundSideDesc ;
	
	/**
	 * 联系电话
	 */
	@PropertyInfo(name="联系电话", length=11)
	public String   phone;
	
	
	/**
	 * 联系人
	 */
	@PropertyInfo(name="联系人", length=32)
	public String   linkman;
	
	/**
	 * 传真
	 */
	@PropertyInfo(name="传真", length=8)
	public String   fax;
	
	
	/**
	 * 电子邮箱
	 */
	@PropertyInfo(name="电子邮箱", length=50)
	public String  email;

    /**
     * 邮政编码
     */
    @PropertyInfo(name="邮政编码", length=50)
    public String  postalCode;
    /**
     * 资金方技术服务方
     */
    @PropertyInfo(name="资金方技术服务方", length=50)
    public String  fundSeverSide;
    /**
     * 总行机构代码
     */
    @PropertyInfo(name="总行机构代码", length=50)
    public String  headOrgCode;
    /**
     * 分行机构代码
     */
    @PropertyInfo(name="分行机构代码", length=50)
    public String  branchOrgCode;
    /**
     * 支行机构代码
     */
    @PropertyInfo(name="支行机构代码", length=50)
    public String  subOrgCode;
    /**
     * 征信机构代码
     */
    @PropertyInfo(name="征信机构代码", length=50)
    public String  creditOrgCode;
    /**
     * 结算账号
     */
    @PropertyInfo(name="结算账号", length=50)
    public String  settlementAccount;
    
    @PropertyInfo(name="资金方技术服务费结算账号", length=50)
    public String  jishuService;
    
    @PropertyInfo(name="理赔结算账号", length=50)
    public String  lipeiAccount;
    
    

	

	

	public String getJishuService() {
		return jishuService;
	}

	public void setJishuService(String jishuService) {
		this.jishuService = jishuService;
	}

	public String getLipeiAccount() {
		return lipeiAccount;
	}

	public void setLipeiAccount(String lipeiAccount) {
		this.lipeiAccount = lipeiAccount;
	}

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

    public String getFundSideCode() {
        return fundSideCode;
    }

    public void setFundSideCode(String fundSideCode) {
        this.fundSideCode = fundSideCode;
    }

    public String getFundSideDesc() {
        return fundSideDesc;
    }

    public void setFundSideDesc(String fundSideDesc) {
        this.fundSideDesc = fundSideDesc;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFundSeverSide() {
        return fundSeverSide;
    }

    public void setFundSeverSide(String fundSeverSide) {
        this.fundSeverSide = fundSeverSide;
    }

    public String getHeadOrgCode() {
        return headOrgCode;
    }

    public void setHeadOrgCode(String headOrgCode) {
        this.headOrgCode = headOrgCode;
    }

    public String getBranchOrgCode() {
        return branchOrgCode;
    }

    public void setBranchOrgCode(String branchOrgCode) {
        this.branchOrgCode = branchOrgCode;
    }

    public String getSubOrgCode() {
        return subOrgCode;
    }

    public void setSubOrgCode(String subOrgCode) {
        this.subOrgCode = subOrgCode;
    }

    public String getCreditOrgCode() {
        return creditOrgCode;
    }

    public void setCreditOrgCode(String creditOrgCode) {
        this.creditOrgCode = creditOrgCode;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }

    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }

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
}
