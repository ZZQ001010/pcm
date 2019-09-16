package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.FeeBasis;
import cn.sunline.pcm.definition.enums.FeeFrequency;
import cn.sunline.pcm.definition.enums.FeeCollectionType;

/**
 *	保费滞纳金
 * @author fgy
 * @date 2019年7月25日
 *
 */
public class PremiumLatePaymentFee implements Serializable{
	private static final long serialVersionUID = 1L;

	@PropertyInfo(name="编码",length=12)
	public String code ; 
	
	@PropertyInfo(name="描述",length=50)
	public String desc ; 
	
	@PropertyInfo(name="费用收取频次",length=12)
	public FeeFrequency frequencyOfCharge  ;
	
	@PropertyInfo(name="费用收取方式",length=12)
	public FeeCollectionType feeCollectionMethod  ;
	
	@PropertyInfo(name="费用收取基础",length=12)
	public FeeBasis feeBasis; 
	
	/**
	 *  例如 30% 填写 0.3
	 */
	@PropertyInfo(name="收取比例",length=12)
	public BigDecimal chargeRatio; 
	
	@PropertyInfo(name="收取金额",length=12)
	public BigDecimal chargeAmount;
	
	@PropertyInfo(name="滞纳金宽限期",length=12)
	public Integer kuanxianqi;


	 
	public Integer getKuanxianqi() {
		return kuanxianqi;
	}

	public void setKuanxianqi(Integer kuanxianqi) {
		this.kuanxianqi = kuanxianqi;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public FeeFrequency getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(FeeFrequency frequencyOfCharge) {
		this.frequencyOfCharge = frequencyOfCharge;
	}

	public FeeCollectionType getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(FeeCollectionType feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public FeeBasis getFeeBasis() {
		return feeBasis;
	}

	public void setFeeBasis(FeeBasis feeBasis) {
		this.feeBasis = feeBasis;
	}

	public BigDecimal getChargeRatio() {
		return chargeRatio;
	}

	public void setChargeRatio(BigDecimal chargeRatio) {
		this.chargeRatio = chargeRatio;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

    
}
