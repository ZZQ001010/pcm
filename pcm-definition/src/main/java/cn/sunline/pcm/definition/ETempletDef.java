package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ElectronicTempletType;
import cn.sunline.pcm.definition.enums.RequireType;

public class ETempletDef implements Serializable{

	private static final long serialVersionUID = 7340284531060868774L;

	/**
	 * 电子资料类型
	 */
	@PropertyInfo(name="电子资料类型", length=1)
	public ElectronicTempletType eMaterialType;
	
	/**
	 * 填写标识
	 */
	@PropertyInfo(name="填写标识", length=1)
	public RequireType requiredFlag;
	
	/**
	 * 图标Url
	 */
	@PropertyInfo(name="图标Url", length=255)
	public String iconUrl;
	
	/**
	 * 图片Url
	 */
	@PropertyInfo(name="图片Url", length=255)
	public String picUrl;
	
}