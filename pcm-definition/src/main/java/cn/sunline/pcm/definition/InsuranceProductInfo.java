package cn.sunline.pcm.definition;

import java.io.Serializable;

import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.FrequencyOfCharge;
import cn.sunline.pcm.definition.enums.FeePayMethod;

/**
 * 保险产品信息
 * @author fgy
 * @date 2019年7月25日
 *
 */
public class InsuranceProductInfo implements Serializable{


	@PropertyInfo(name="保险产品编号",length=12)
    public String code ;

    @PropertyInfo(name="保险产品名称",length=50)
    public String name ;
    

    @PropertyInfo(name="险种",length=50)
    public String insuranceType ;

    @PropertyInfo(name="单证代码（保单)",length=50)
    public String insuranceCode ;

    @PropertyInfo(name="保费率",length=12)
    public BigDecimal principalCollectionRatio;

    @PropertyInfo(name="保费缴纳方式",length=1)
    public FeePayMethod feePayMethod;

    @PropertyInfo(name="保费缴纳频率",length=1)
    public FrequencyOfCharge frequencyOfCharge;

    @PropertyInfo(name="滞纳金宽限期",length=50)
    public String lateFeeGracePeriod ;

    @PropertyInfo(name="滞纳金比率(天)",length=50)
    public String lateFeeRatio ;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
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

    public FrequencyOfCharge getFrequencyOfCharge() {
        return frequencyOfCharge;
    }

    public void setFrequencyOfCharge(FrequencyOfCharge frequencyOfCharge) {
        this.frequencyOfCharge = frequencyOfCharge;
    }

    public String getLateFeeGracePeriod() {
        return lateFeeGracePeriod;
    }

    public void setLateFeeGracePeriod(String lateFeeGracePeriod) {
        this.lateFeeGracePeriod = lateFeeGracePeriod;
    }

    public String getLateFeeRatio() {
        return lateFeeRatio;
    }

    public void setLateFeeRatio(String lateFeeRatio) {
        this.lateFeeRatio = lateFeeRatio;
    }
}
