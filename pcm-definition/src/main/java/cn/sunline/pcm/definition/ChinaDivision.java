package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

@SuppressWarnings("serial")
public class ChinaDivision implements Serializable {
	
	/**
	 * 区域Id,建议长度为6位
	 */
	@PropertyInfo(name="区域ID", length=6)
	public String areaId;
	
	/**
	 * 描述
	 */
	@PropertyInfo(name="描述", length=20)
	public String areaDesc;
//	
//	/**
//	 * 分级
//	 */
//	@PropertyInfo(name="分级", length=1)
//	public Integer level;
//	
	/**
	 * 上级区域Id,建议长度为6位
	 */
	@PropertyInfo(name="上级区域ID", length=6)
	public String superiorAreaId;
}
