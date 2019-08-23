package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 币种参数
 * 主键 - currencyCd
* @author alen
 *
 */
@SuppressWarnings("serial")
public class CurrencyCd implements Serializable {

	/**
	 * 币种数字代码
	 */
	@PropertyInfo(name="数字代码", length=3)
	public String currencyCd;
	
	/**
	 * 币种英文代码
	 */
	@PropertyInfo(name="英文代码", length=3)
	public String alphaCd;

	/**
     * 描述
     */
    @PropertyInfo(name="描述", length=20)
    public String description;
	
	/**
	 * 币种保留小数位数
	 */
	@PropertyInfo(name="小数位数", length=1)
	public Integer exponent;
	
	/**
     * 兑换汇率
     */
    @PropertyInfo(name="兑换汇率", length=9, precision=4)
    public BigDecimal conversionRt;

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getAlphaCd() {
		return alphaCd;
	}

	public void setAlphaCd(String alphaCd) {
		this.alphaCd = alphaCd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExponent() {
		return exponent;
	}

	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}

	public BigDecimal getConversionRt() {
		return conversionRt;
	}

	public void setConversionRt(BigDecimal conversionRt) {
		this.conversionRt = conversionRt;
	}
    
    
}
