/**
* @ClassName: PcmSettleAccMan
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月10日
*
*/
package cn.sunline.pcm.definition;


import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.AccountOwner;
import cn.sunline.pcm.definition.enums.OrganizationAccountType;

/**
 * @author zzq
 * 2019年7月10日
 * 结算账号管理
 */
@SuppressWarnings("serial")
public class PcmSettleAccMan implements Serializable{

	/**
	 * 结算账号编码
	 */
	@PropertyInfo(name="结算账号编码",length=100)
	public String settleAccCode;
	
	/**
	 * 结算账号描述
	 */
	@PropertyInfo(name="结算账号描述",length=200)
	public String settleAccDes;
	

	/**
	 * 账号归属
	 */
	@PropertyInfo(name="账号归属")
	public AccountOwner accountOwner;
	
	
	/**
	 * 机构账号类型
	 */
	@PropertyInfo(name="机构账号类型",length=32)
	public OrganizationAccountType organizationAccountType;
	
	/**
	 *  ------------------实体账号信息------------                     	
	 */
	
	/**
	 * 单位名称
	 */
	@PropertyInfo(name="单位名称",length=32)
	public String  unitName;
	
	
	/**
	 * 开户银行编码
	 */
	@PropertyInfo(name="开户银行编码",length=32)
	public String openBankCode;
	
	/**
	 * 银行账户
	 */
	@PropertyInfo(name="银行账户",length=32)
	public String bankAccount;
		
 
		
		
	/**
	 * 开户银行
	 */
	@PropertyInfo(name="开户银行",length=100)
	public String openBank;
		
	
	/**
	 * 开户行省份
	 */
	@PropertyInfo(name="开户行省份",length=32)
	public String openBankProv;
		
	/**
	 * 开户行城市
	 */
	@PropertyInfo(name="开户行城市",length=32)
	public String openBankCity;
	
    /**
     * 资金方支持展业区、县
     */
    @PropertyInfo(name="资金方支持展业区、县")
    public String  district;
   
	
	
		
	/**
	 * 开户行支行
	 */
	@PropertyInfo(name="开户行支行",length=100)
	public String openBankBranch;
	
	
	
	
	/**
	 *  --------------虚拟账号信息-------------
	 */
	
	/**
	 * 单位名称
	 */
	@PropertyInfo(name="单位名称",length=32)
	public String  vUnitName;
	
	
	/**
	 * 银行账户
	 */
	@PropertyInfo(name="银行账户",length=32)
	public String vBankAccount;
		
 
		
		
	/**
	 * 开户银行
	 */
	@PropertyInfo(name="开户银行",length=100)
	public String vOpenBank;
		
	
	/**
	 * 开户行省份
	 */
	@PropertyInfo(name="开户行省份",length=32)
	public String vOpenBankProv;
		
	/**
	 * 开户行城市
	 */
	@PropertyInfo(name="开户行城市",length=32)
	public String vOpenBankCity;
	
    /**
     * 资金方支持展业区、县
     */
    @PropertyInfo(name="资金方支持展业区、县")
    public String  vDistrict;
   
	
	
		
	/**
	 * 开户行支行
	 */
	@PropertyInfo(name="开户行支行",length=100)
	public String vOpenBankBranch;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the settleAccCode
	 */
	public String getSettleAccCode() {
		return settleAccCode;
	}

	/**
	 * @param settleAccCode the settleAccCode to set
	 */
	public void setSettleAccCode(String settleAccCode) {
		this.settleAccCode = settleAccCode;
	}

	/**
	 * @return the settleAccDes
	 */
	public String getSettleAccDes() {
		return settleAccDes;
	}

	/**
	 * @param settleAccDes the settleAccDes to set
	 */
	public void setSettleAccDes(String settleAccDes) {
		this.settleAccDes = settleAccDes;
	}

	/**
	 * @return the accountOwner
	 */
	public AccountOwner getAccountOwner() {
		return accountOwner;
	}

	/**
	 * @param accountOwner the accountOwner to set
	 */
	public void setAccountOwner(AccountOwner accountOwner) {
		this.accountOwner = accountOwner;
	}

	 

	public String getvUnitName() {
		return vUnitName;
	}

	public void setvUnitName(String vUnitName) {
		this.vUnitName = vUnitName;
	}

	public String getvBankAccount() {
		return vBankAccount;
	}

	public void setvBankAccount(String vBankAccount) {
		this.vBankAccount = vBankAccount;
	}

	public String getvOpenBank() {
		return vOpenBank;
	}

	public void setvOpenBank(String vOpenBank) {
		this.vOpenBank = vOpenBank;
	}

	public String getvOpenBankProv() {
		return vOpenBankProv;
	}

	public void setvOpenBankProv(String vOpenBankProv) {
		this.vOpenBankProv = vOpenBankProv;
	}

	public String getvOpenBankCity() {
		return vOpenBankCity;
	}

	public void setvOpenBankCity(String vOpenBankCity) {
		this.vOpenBankCity = vOpenBankCity;
	}

	public String getvDistrict() {
		return vDistrict;
	}

	public void setvDistrict(String vDistrict) {
		this.vDistrict = vDistrict;
	}

	public String getvOpenBankBranch() {
		return vOpenBankBranch;
	}

	public void setvOpenBankBranch(String vOpenBankBranch) {
		this.vOpenBankBranch = vOpenBankBranch;
	}

	/**
	 * @return the openBank
	 */
	public String getOpenBank() {
		return openBank;
	}

	/**
	 * @param openBank the openBank to set
	 */
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}

	/**
	 * @return the openBankProv
	 */
	public String getOpenBankProv() {
		return openBankProv;
	}

	/**
	 * @param openBankProv the openBankProv to set
	 */
	public void setOpenBankProv(String openBankProv) {
		this.openBankProv = openBankProv;
	}
	
	
	

	/**
	 * @return the openBankCity
	 */
	public String getOpenBankCity() {
		return openBankCity;
	}

	/**
	 * @param openBankCity the openBankCity to set
	 */
	public void setOpenBankCity(String openBankCity) {
		this.openBankCity = openBankCity;
	}

	/**
	 * @return the openBankBranch
	 */
	public String getOpenBankBranch() {
		return openBankBranch;
	}

	/**
	 * @param openBankBranch the openBankBranch to set
	 */
	public void setOpenBankBranch(String openBankBranch) {
		this.openBankBranch = openBankBranch;
	}
 

	public OrganizationAccountType getOrganizationAccountType() {
		return organizationAccountType;
	}

	public void setOrganizationAccountType(OrganizationAccountType organizationAccountType) {
		this.organizationAccountType = organizationAccountType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getOpenBankCode() {
		return openBankCode;
	}

	public void setOpenBankCode(String openBankCode) {
		this.openBankCode = openBankCode;
	}
	
	
}
