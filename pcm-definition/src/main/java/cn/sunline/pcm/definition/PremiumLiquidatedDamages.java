package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.CostCalculationMethod;
import cn.sunline.pcm.definition.enums.AdditionalNPremiums;
import java.util.Date;
/**
 * 提前还款保费收取方式
 * @author fgys
 * @date 2019年7月25日
 *
 */

public class PremiumLiquidatedDamages implements Serializable{

	private static final long serialVersionUID = 1L;

	@PropertyInfo(name = "费用编码", length = 12)
    public String code;

    @PropertyInfo(name = "费用描述", length = 50)
    public String desc;

    @PropertyInfo(name = "费用收取方式", length = 12)
    public CostCalculationMethod costCalculationMethod;

    @PropertyInfo(name = "当期保费是否收取", length = 12)
    public Boolean WhetherToCharge;

    @PropertyInfo(name = "手续费率", length = 12)
    public BigDecimal PercentageRemainingPrincipal;

    @PropertyInfo(name = "加收N期保费", length = 12)
    public AdditionalNPremiums additionalNPremiums;

    @PropertyInfo(name = "收取固定金额", length = 12)
    public BigDecimal ChargeFixedAmount;

    @PropertyInfo(name = "收取起始账期")
    public Date startDate;

    @PropertyInfo(name = "收取终止账期")
    public Date endDate;

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

    public CostCalculationMethod getCostCalculationMethod() {
        return costCalculationMethod;
    }

    public void setCostCalculationMethod(CostCalculationMethod costCalculationMethod) {
        this.costCalculationMethod = costCalculationMethod;
    }

    public Boolean getWhetherToCharge() {
        return WhetherToCharge;
    }

    public void setWhetherToCharge(Boolean whetherToCharge) {
        WhetherToCharge = whetherToCharge;
    }

    public BigDecimal getPercentageRemainingPrincipal() {
        return PercentageRemainingPrincipal;
    }

    public void setPercentageRemainingPrincipal(BigDecimal percentageRemainingPrincipal) {
        PercentageRemainingPrincipal = percentageRemainingPrincipal;
    }

    public AdditionalNPremiums getAdditionalNPremiums() {
        return additionalNPremiums;
    }

    public void setAdditionalNPremiums(AdditionalNPremiums additionalNPremiums) {
        this.additionalNPremiums = additionalNPremiums;
    }

    public BigDecimal getChargeFixedAmount() {
        return ChargeFixedAmount;
    }

    public void setChargeFixedAmount(BigDecimal chargeFixedAmount) {
        ChargeFixedAmount = chargeFixedAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}