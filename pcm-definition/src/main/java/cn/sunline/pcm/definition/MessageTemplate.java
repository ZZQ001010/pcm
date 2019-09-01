package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.Date;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.ppy.dictionary.enums.MessageSendingMethod;

/**
 * 短信模版，key为{@link #code}
* @author alen
 *
 */
public class MessageTemplate implements Serializable {

	private static final long serialVersionUID = -1332566713825070756L;
	
	@PropertyInfo(name="信息代码", length=20)
	public String code;
	
	@PropertyInfo(name="信息描述", length=40)
	public String desc;

	@PropertyInfo(name="系统类型", length=10)
	public String systemType;
	
	@PropertyInfo(name="信息分类", length=20)
	public String msgCategory;
	
	@PropertyInfo(name="发送方法")
	public MessageSendingMethod sendingMethod;
	
	/**
	 * 内容模版，使用$key的简单形式
	 */
	@PropertyInfo(name="内容模版", length=500)
	public String contentTemplate;
	
	@PropertyInfo(name="发送起始时间")
	public Date startTime;
	
	@PropertyInfo(name="发送结束时间")
	public Date endTime;
	
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
	
	public String getSystemType() {
		return systemType;
	}
	
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	
	public String getMsgCategory() {
		return msgCategory;
	}
	
	public void setMsgCategory(String msgCategory) {
		this.msgCategory = msgCategory;
	}

	public MessageSendingMethod getSendingMethod() {
		return sendingMethod;
	}
	
	public void setSendingMethod(MessageSendingMethod sendingMethod) {
		this.sendingMethod = sendingMethod;
	}
	
	public String getContentTemplate() {
		return contentTemplate;
	}
	
	public void setContentTemplate(String contentTemplate) {
		this.contentTemplate = contentTemplate;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
