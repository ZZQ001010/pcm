package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.AssetSideLoanCtrl;

/**
 * 
 * @author zzq
 * @date 2019年7月10日
 * 
 *	资产方管控信息
 * 主键 =编码
 */
public class AssetSideCtrlInfo  implements Serializable {


	/**
	 * 资产方管控编码
	 */
	@PropertyInfo(name="资产方管控编码", length=32)
	public  String assetSideCtrlCode ; 
	
	
	/**
	 * 资产方管控描述
	 */
	@PropertyInfo(name="资产方管控描述", length=50)
	public  String assetSideCtrlDesc ; 
	
	/**
	 * 资产方编码
	 */
	@PropertyInfo(name="资产方编码")
	public  String assetSideCode ;
	
	/**
	 * 资产方授信管控
	 */
	@PropertyInfo(name="资产方授信管控")
	public AssetSideLoanCtrl assetSideCreditCtrl;
	
	/**
	 * 资产方额度总控
	 */
	@PropertyInfo(name="资产方额度总控")
	public BigDecimal assetSideAmountGeneralControl; 
	
	/**
	 *授信额度有效期
	 */
	@PropertyInfo(name="授信额度有效期")
	public  Date authorizationAmountUsefulLife; 
	
	/**
	 * 资产方放款管控
	 */
	@PropertyInfo(name="资产方放款管控")
	public AssetSideLoanCtrl assetSideLoanCtrl;
	
	/**
	 * 资产方放款额度总控
	 */
	@PropertyInfo(name="资产方放款额度总控")
	public  BigDecimal assetSideAmountLoanControl; 
	
	
	/**
	 * 放款额度有效期
	 */
	@PropertyInfo(name="放款额度有效期")
	public Date   loanAmountUsefulLife;
	
	/**
	 * 资产方月放款额管控
	 */
	@PropertyInfo(name="资产方月放款额管控")
	public  BigDecimal assetSideControlMonth; 
	
	/**
	 * 资产方月放款额管控
	 */
	@PropertyInfo(name="资产方周放款额管控")
	public  BigDecimal assetSideControlWeek;
	
	/**
	 * 资产方月放款额管控
	 */
	@PropertyInfo(name="资产方日放款额管控")
	public  BigDecimal assetSideControlDay;

	/**
	 * 资产方余额总控
	 */
	@PropertyInfo(name="资产方余额总控")
	public BigDecimal assetSideBalanceControl;
	
	/**
	 * 余额额度有效期
	 */
	@PropertyInfo(name="余额额度有效期")
	public Date balanceAmountUsefulLife;

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public String getAssetSideCtrlCode() {
		return assetSideCtrlCode;
	}

	public void setAssetSideCtrlCode(String assetSideCtrlCode) {
		this.assetSideCtrlCode = assetSideCtrlCode;
	}

	public String getAssetSideCtrlDesc() {
		return assetSideCtrlDesc;
	}

	public void setAssetSideCtrlDesc(String assetSideCtrlDesc) {
		this.assetSideCtrlDesc = assetSideCtrlDesc;
	}

	public String getAssetSideCode() {
		return assetSideCode;
	}

	public void setAssetSideCode(String assetSideCode) {
		this.assetSideCode = assetSideCode;
	}

	public AssetSideLoanCtrl getAssetSideCreditCtrl() {
		return assetSideCreditCtrl;
	}

	public void setAssetSideCreditCtrl(AssetSideLoanCtrl assetSideCreditCtrl) {
		this.assetSideCreditCtrl = assetSideCreditCtrl;
	}

	public BigDecimal getAssetSideAmountGeneralControl() {
		return assetSideAmountGeneralControl;
	}

	public void setAssetSideAmountGeneralControl(BigDecimal assetSideAmountGeneralControl) {
		this.assetSideAmountGeneralControl = assetSideAmountGeneralControl;
	}

	public Date getAuthorizationAmountUsefulLife() {
		return authorizationAmountUsefulLife;
	}

	public void setAuthorizationAmountUsefulLife(Date authorizationAmountUsefulLife) {
		this.authorizationAmountUsefulLife = authorizationAmountUsefulLife;
	}

	public AssetSideLoanCtrl getAssetSideLoanCtrl() {
		return assetSideLoanCtrl;
	}

	public void setAssetSideLoanCtrl(AssetSideLoanCtrl assetSideLoanCtrl) {
		this.assetSideLoanCtrl = assetSideLoanCtrl;
	}

	public BigDecimal getAssetSideAmountLoanControl() {
		return assetSideAmountLoanControl;
	}

	public void setAssetSideAmountLoanControl(BigDecimal assetSideAmountLoanControl) {
		this.assetSideAmountLoanControl = assetSideAmountLoanControl;
	}

	public Date getLoanAmountUsefulLife() {
		return loanAmountUsefulLife;
	}

	public void setLoanAmountUsefulLife(Date loanAmountUsefulLife) {
		this.loanAmountUsefulLife = loanAmountUsefulLife;
	}

	public BigDecimal getAssetSideControlMonth() {
		return assetSideControlMonth;
	}

	public void setAssetSideControlMonth(BigDecimal assetSideControlMonth) {
		this.assetSideControlMonth = assetSideControlMonth;
	}

	public BigDecimal getAssetSideControlWeek() {
		return assetSideControlWeek;
	}

	public void setAssetSideControlWeek(BigDecimal assetSideControlWeek) {
		this.assetSideControlWeek = assetSideControlWeek;
	}

	public BigDecimal getAssetSideControlDay() {
		return assetSideControlDay;
	}

	public void setAssetSideControlDay(BigDecimal assetSideControlDay) {
		this.assetSideControlDay = assetSideControlDay;
	}

	public BigDecimal getAssetSideBalanceControl() {
		return assetSideBalanceControl;
	}

	public void setAssetSideBalanceControl(BigDecimal assetSideBalanceControl) {
		this.assetSideBalanceControl = assetSideBalanceControl;
	}

	public Date getBalanceAmountUsefulLife() {
		return balanceAmountUsefulLife;
	}

	public void setBalanceAmountUsefulLife(Date balanceAmountUsefulLife) {
		this.balanceAmountUsefulLife = balanceAmountUsefulLife;
	}

	
}
