package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 国家代码
 * 主键 - countryCd
 * @author zhengpy
 * 
 * 如中国
 * COUNTRY_CD        为156
 * COUNTRY_CD_SHORT  为CN
 * DESCRIPTION       为中华人民共和国
 * CURRENCY_CD       为156
 */
@SuppressWarnings("serial")
public class CountryCd implements Serializable {
	
	/**
	 * 国家代码， 为ISO 3166-1标准的三位数字代码，参见 http://en.wikipedia.org/wiki/ISO_3166-1
	 */
	@PropertyInfo(name="国家代码", length=3)
	public String countryCd;
	
	/**
	 * 两位字母国家代码缩写，参见ISO 3166-1
	 */
	@PropertyInfo(name="代码缩写", length=2)
	public String countryCdShort;
	
	/**
	 * 国家中文名
	 */
	@PropertyInfo(name="中文名", length=40)
	public String description;
	
	/**
	 * 国家币种
	 */
	@PropertyInfo(name="币种", length=12)
	public String currencyCd;

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getCountryCdShort() {
		return countryCdShort;
	}

	public void setCountryCdShort(String countryCdShort) {
		this.countryCdShort = countryCdShort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	
	
}
