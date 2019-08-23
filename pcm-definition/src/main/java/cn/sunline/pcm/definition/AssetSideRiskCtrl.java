package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.RiskCtrlWay;

/**
 *  
 * @author zzq
 *
 * 资产方风险管理
 * 主键 =编码
 */
public class AssetSideRiskCtrl implements Serializable {


	/**
	 * 编码 （主键)
	 */
	@PropertyInfo(name="编码", length=32)
	public  String aId ; 
	
	
	/**
	 * 描述
	 */
	@PropertyInfo(name="描述", length=100)
	public  String desc ; 
	
	/**
	 * 风管方式
	 */
	@PropertyInfo(name="风管方式")
	public  java.util.List<RiskCtrlWay> riskCtrlWays; 
	
	
	/**
	 * 保证金基数
	 */
	@PropertyInfo(name="保证金基数")
	public  cn.sunline.pcm.definition.enums.MarginBase MarginBase;
	
	/**
	 * 保证金比例
	 */
	@PropertyInfo(name="保证金比例")
	public  String marginProportion; 
	
	/**
	 * 保证金预警比例
	 */
	@PropertyInfo(name="保证金预警比例")
	public  String marginWarningProportion;

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public java.util.List<RiskCtrlWay> getRiskCtrlWays() {
		return riskCtrlWays;
	}

	public void setRiskCtrlWays(java.util.List<RiskCtrlWay> riskCtrlWays) {
		this.riskCtrlWays = riskCtrlWays;
	}

	public cn.sunline.pcm.definition.enums.MarginBase getMarginBase() {
		return MarginBase;
	}

	public void setMarginBase(cn.sunline.pcm.definition.enums.MarginBase marginBase) {
		MarginBase = marginBase;
	}

	public String getMarginProportion() {
		return marginProportion;
	}

	public void setMarginProportion(String marginProportion) {
		this.marginProportion = marginProportion;
	}

	public String getMarginWarningProportion() {
		return marginWarningProportion;
	}

	public void setMarginWarningProportion(String marginWarningProportion) {
		this.marginWarningProportion = marginWarningProportion;
	}
	
	
	
	
	
	
	
}
