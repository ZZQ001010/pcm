package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
/**
 * CPD列表
 *
 */
@SuppressWarnings("serial")
public class CpdDef implements Serializable {

    /**
     * CPD列表-逾期天数
     */
    @PropertyInfo(name="CPD列表-逾期天数", length=3)
    public Integer cpdOverDays;

    /**
     * CPD列表-罚金金额
     */
    @PropertyInfo(name="CPD列表-罚金金额", length=15,precision=2)
    public BigDecimal cpdOverAmt;
    
    /**
     * CPD列表-罚金费率
     */
    @PropertyInfo(name="CPD列表-罚金利率", length=6,precision=4)
    public BigDecimal cpdOverRate;


 
}
