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
	 * 资产方
	 */
	@PropertyInfo(name="资产方",length=32)
	public String asset;
	
	/**
	 * 机构账号类型
	 */
	@PropertyInfo(name="机构账号类型",length=32)
	public OrganizationAccountType organizationAccountType;
	
	/**
	 * 单位名称
	 */
	@PropertyInfo(name="单位名称",length=32)
	public String  unitName;
	
	/**
	 * 账号信息
	 */
	@PropertyInfo(name="账号信息",length=64)
	public String accInfo;
	
	/**
	 * 银行账户
	 */
	@PropertyInfo(name="银行账户",length=32)
	public String bankAccount;
	/**
	 * 统一社会信用代码
	 */
//	@PropertyInfo(name="统一社会信用代码",length=100)
//	public String unifiedSocCreCode;
		
	/**
	 * 机构编号
	 */
	@PropertyInfo(name="机构编号",length=32)
	public String orgCode;
		
		
	/**
	 * 账户备注名
	 */
//	@PropertyInfo(name="账户备注名",length=32)
//	public String accNoteName;
		
	/**
	 * 对公账户的开户行号
	 */
//	@PropertyInfo(name="对公账户的开户行号",length=100)
//	public String pubOpenNum;
		
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
	 * 开户行支行
	 */
	@PropertyInfo(name="开户行支行",length=100)
	public String openBankBranch;

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

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}



	public String getAccInfo() {
		return accInfo;
	}

	public void setAccInfo(String accInfo) {
		this.accInfo = accInfo;
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
	
		
}
