package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.List;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

public class GroupCtrl implements Serializable {

	/** 
	 * 
	 */  
	private static final long serialVersionUID = 9221874280504137374L;

	/**
	 * 控制表ID
	 */
	@PropertyInfo(name="控制表ID", length=4)
	public String groupCtrlId;
	
	/**
	 * 描述
	 */
	@PropertyInfo(name="描述", length=20)
	public String desc;
	
	/**
	 * 终端类型列表
	 * <p>Json格式示例</p>
	 * <p>[{dictionaryCtrlId:"0001","desc":"IOS"},</p>
	 * <p>[{dictionaryCtrlId:"0002","desc":"WeChat"}...]</p>
	 */
	public List<Terminal> subTermialList;

	public String getGroupCtrlId() {
		return groupCtrlId;
	}

	public void setGroupCtrlId(String groupCtrlId) {
		this.groupCtrlId = groupCtrlId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Terminal> getSubTermialList() {
		return subTermialList;
	}

	public void setSubTermialList(List<Terminal> subTermialList) {
		this.subTermialList = subTermialList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * 区域划分列表
	 * <p>Json格式示例(无父节点)</p>
	 * <p>[{areaId:"010000","desc":"重庆市","superiorAreaId:"root"},</p>
	 * <p>[{areaId:"010100","desc":"渝中区","superiorAreaId:"010000"}...]</p>
	 */
//	public List<ChinaDivision> chinaDivisionDef;
}
