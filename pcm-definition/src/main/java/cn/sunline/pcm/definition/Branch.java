package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 *分行表
 * 主键-Branch_id
 */
@SuppressWarnings("serial")
public class Branch implements Serializable {
	/**
     * BRANCH_ID
     */
    @PropertyInfo(name="分支行编号", length=9)
    public String branchId;

    /**
     * 分支行名称
     */
    @PropertyInfo(name="分支行名称", length=80)
    public String name;

    /**
     * 地址
     */
    @PropertyInfo(name="地址", length=200)
    public String address;

    /**
     * 区
     */
    @PropertyInfo(name="区", length=20)
    public String district;

    /**
     * 邮编
     */
    @PropertyInfo(name="邮编", length=10)
    public String zip;

    /**
     * 分支行所在城市
     */
    @PropertyInfo(name="分支行所在城市", length=20)
    public String city;

    /**
     * 分支行所在国家代码
     */
    @PropertyInfo(name="分支行所在国家代码", length=3)
    public String countryCd;

    /**
     * 分支行联系电话1
     */
    @PropertyInfo(name="分支行联系电话1", length=20)
    public String phone1;

    /**
     * 分支行联系电话2
     */
    @PropertyInfo(name="分支行联系电话2", length=20)
    public String phone2;

    /**
     * 上级分行编号
     */
    @PropertyInfo(name="上级分行编号", length=15)
    public String superiorBranchId;
    
    /**
     * 分行级别：
     * 1-5
     */
    @PropertyInfo(name="分行级别", length=1)
    public Integer level;
 
    /**
     * 金融机构代码
     */
    @PropertyInfo(name="金融机构代码", length=20)
    public String financialOrgCode;
    
    //马上贷参数
    /**
     * 银行账号
     */
    @PropertyInfo(name="银行账号", length=30)
    public String settleAcctNbr;
    /**
     * 银行代码
     */
    @PropertyInfo(name="银行代码", length=9)
    public String acctBankId;
    /**
     * 银行名称
     */
    @PropertyInfo(name="银行名称",length=50)
    public String acctBank;
    
    /**
     * 省份
     */
    @PropertyInfo(name="省份",length=20)
    public String acctProvince;
    
    /**
     * 城市
     */
    @PropertyInfo(name="城市",length=40)
    public String acctCity;
    
    /**
     * 所属支行
     */
    @PropertyInfo(name="所属支行",length=9)
    public String acctBranchBankId;
    
    /**
     * 登记机构号
     */
    @PropertyInfo(name="登记机构号",length=10)
    public String inputOrgId;
    
    /**
     * 登记人编号
     */
    @PropertyInfo(name="登记人编号",length=10)
    public String inputUserId;
    
    /**
     * 营销机构号
     */
    @PropertyInfo(name="营销机构号",length=10)
    public String updateOrgId;
    
    /**
     * 营销人员编号
     */
    @PropertyInfo(name="营销人员编号",length=10)
    public String updateUserId;
    
    /**
     * 贷后管户人编号
     */
    @PropertyInfo(name="贷后管户人编号",length=10)
    public String manageUserId;
    
    /**
     * 贷后管户机构号
     */
    @PropertyInfo(name="贷后管户机构号",length=10)
    public String manageOrgId;
    
    /**
     * 机构号
     */
    @PropertyInfo(name="机构号",length=10)
    public String orgId;

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getSuperiorBranchId() {
		return superiorBranchId;
	}

	public void setSuperiorBranchId(String superiorBranchId) {
		this.superiorBranchId = superiorBranchId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getFinancialOrgCode() {
		return financialOrgCode;
	}

	public void setFinancialOrgCode(String financialOrgCode) {
		this.financialOrgCode = financialOrgCode;
	}

	public String getSettleAcctNbr() {
		return settleAcctNbr;
	}

	public void setSettleAcctNbr(String settleAcctNbr) {
		this.settleAcctNbr = settleAcctNbr;
	}

	public String getAcctBankId() {
		return acctBankId;
	}

	public void setAcctBankId(String acctBankId) {
		this.acctBankId = acctBankId;
	}

	public String getAcctBank() {
		return acctBank;
	}

	public void setAcctBank(String acctBank) {
		this.acctBank = acctBank;
	}

	public String getAcctProvince() {
		return acctProvince;
	}

	public void setAcctProvince(String acctProvince) {
		this.acctProvince = acctProvince;
	}

	public String getAcctCity() {
		return acctCity;
	}

	public void setAcctCity(String acctCity) {
		this.acctCity = acctCity;
	}

	public String getAcctBranchBankId() {
		return acctBranchBankId;
	}

	public void setAcctBranchBankId(String acctBranchBankId) {
		this.acctBranchBankId = acctBranchBankId;
	}

	public String getInputOrgId() {
		return inputOrgId;
	}

	public void setInputOrgId(String inputOrgId) {
		this.inputOrgId = inputOrgId;
	}

	public String getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId;
	}

	public String getUpdateOrgId() {
		return updateOrgId;
	}

	public void setUpdateOrgId(String updateOrgId) {
		this.updateOrgId = updateOrgId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getManageUserId() {
		return manageUserId;
	}

	public void setManageUserId(String manageUserId) {
		this.manageUserId = manageUserId;
	}

	public String getManageOrgId() {
		return manageOrgId;
	}

	public void setManageOrgId(String manageOrgId) {
		this.manageOrgId = manageOrgId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
    
    
    
}
