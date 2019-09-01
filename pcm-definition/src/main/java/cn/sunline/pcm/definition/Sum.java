package cn.sunline.pcm.definition;

import java.io.Serializable;

import java.math.BigDecimal;


/**
 * 金额
 * @author zzq
 * @date 2019年7月10日
 *
 */

public class Sum implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 数值
	 */
	public BigDecimal sumNum ; 
	
	/**
	 * 币种类型
	 */
	public String  currencyCd ;

	public BigDecimal getSumNum() {
		return sumNum;
	}

	public void setSumNum(BigDecimal sumNum) {
		this.sumNum = sumNum;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}


	
	
	
}
