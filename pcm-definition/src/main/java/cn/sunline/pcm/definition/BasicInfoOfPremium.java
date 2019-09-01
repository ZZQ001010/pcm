package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.FeeCollectionMethod;
import cn.sunline.pcm.definition.enums.FrequencyOfCharge;
import cn.sunline.pcm.definition.enums.FeePayMethod;

/**
 * 保费基本信息
 * @author fgy
 * @date 2019年7月24日
 *
 */
public class BasicInfoOfPremium implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PropertyInfo(name="保费编码",length=12)
	public String code ; 
	
	@PropertyInfo(name="保费描述",length=50)
	public String desc ; 
	
	@PropertyInfo(name="费用收取方式",length=1)
	public FeeCollectionMethod feeCollectionMethod; 
	
	@PropertyInfo(name="保费缴纳频率",length=1)
	public FrequencyOfCharge frequencyOfCharge;
	
	@PropertyInfo(name="保费率",length=12)
	public BigDecimal principalCollectionRatio;
	
	@PropertyInfo(name="保费缴纳方式",length=1)
	public FeePayMethod feePayMethod;

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

	public FeeCollectionMethod getFeeCollectionMethod() {
		return feeCollectionMethod;
	}

	public void setFeeCollectionMethod(FeeCollectionMethod feeCollectionMethod) {
		this.feeCollectionMethod = feeCollectionMethod;
	}

	public FrequencyOfCharge getFrequencyOfCharge() {
		return frequencyOfCharge;
	}

	public void setFrequencyOfCharge(FrequencyOfCharge frequencyOfCharge) {
		this.frequencyOfCharge = frequencyOfCharge;
	}

	public BigDecimal getPrincipalCollectionRatio() {
		return principalCollectionRatio;
	}

	public void setPrincipalCollectionRatio(BigDecimal principalCollectionRatio) {
		this.principalCollectionRatio = principalCollectionRatio;
	}

    public FeePayMethod getFeePayMethod() {
        return feePayMethod;
    }

    public void setFeePayMethod(FeePayMethod feePayMethod) {
        this.feePayMethod = feePayMethod;
    }
}
