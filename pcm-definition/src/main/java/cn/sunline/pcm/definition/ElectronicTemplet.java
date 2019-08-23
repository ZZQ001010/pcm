package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.Map;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 电子资料模板
 * author lisy
 */

@SuppressWarnings("serial")
public class ElectronicTemplet implements Serializable {
	
	/**
	 * 电子资料模板编号
	 */
	@PropertyInfo(name="模板编号", length=3)
	public String templetId;
	
	/**
	 * 电子资料模板描述
	 */
	@PropertyInfo(name="描述", length=20)
	public String templetDesc;
	
	/**
	 * 电子资料模板列表
	 */
	//Json中无法存放Enum
	//电子模板类型名,选项类型
	public Map<String,String> templetList;
//	public List<ElectronicTempletType> templetList;

	public String getTempletId() {
		return templetId;
	}

	public void setTempletId(String templetId) {
		this.templetId = templetId;
	}

	public String getTempletDesc() {
		return templetDesc;
	}

	public void setTempletDesc(String templetDesc) {
		this.templetDesc = templetDesc;
	}

	public Map<String, String> getTempletList() {
		return templetList;
	}

	public void setTempletList(Map<String, String> templetList) {
		this.templetList = templetList;
	}
	
	
	
}
