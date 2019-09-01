package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
/**
 *罚息列表
 *
 */
@SuppressWarnings("serial")
public class MulctDef implements Serializable {

    /**
     * 罚金-逾期天数
     */
    @PropertyInfo(name="罚金-逾期天数", length=3)
    public Integer mulctOverDays;

    /**
     * CPD-逾期天数
     */
    @PropertyInfo(name="CPD-逾期天数", length=3)
    public Integer cpdOverDays;
    
    /**
     * 罚金列表-罚金金额
     */
    @PropertyInfo(name="罚金列表-罚金金额", length=15,precision=2)
    public BigDecimal mulctOverAmt;
    
    /**
     * 罚金列表-罚金费率
     */
    @PropertyInfo(name="罚金列表-罚金费率", length=6,precision=4)
    public BigDecimal mulctOverRate;

	public Integer getMulctOverDays() {
		return mulctOverDays;
	}

	public void setMulctOverDays(Integer mulctOverDays) {
		this.mulctOverDays = mulctOverDays;
	}

	public Integer getCpdOverDays() {
		return cpdOverDays;
	}

	public void setCpdOverDays(Integer cpdOverDays) {
		this.cpdOverDays = cpdOverDays;
	}

	public BigDecimal getMulctOverAmt() {
		return mulctOverAmt;
	}

	public void setMulctOverAmt(BigDecimal mulctOverAmt) {
		this.mulctOverAmt = mulctOverAmt;
	}

	public BigDecimal getMulctOverRate() {
		return mulctOverRate;
	}

	public void setMulctOverRate(BigDecimal mulctOverRate) {
		this.mulctOverRate = mulctOverRate;
	}


 
}
