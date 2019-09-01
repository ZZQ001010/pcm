package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.common.enums.Indicator;

/**
 * 通知模板管理
 * @author zhengyp
 *
 */
public class NotifyTemplate implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
     * 通知代码
     */
    @PropertyInfo(name="通知代码", length=80)
    public String notifyCode;
    

    /**
     * 合作机构
     */
    @PropertyInfo(name="合作机构", length=80)
    public String cooperationChannel;
    
    /**
     * 发送地址
     */
    @PropertyInfo(name="发送地址", length=80)
    public String sendUrl;
    
    /**
     * 报文类型
     */
    @PropertyInfo(name="报文类型", length=80)
    public String messageType;
    
    /**
     * 是否需要重发
     */
    @PropertyInfo(name="是否需要重发", length=80)
    public Indicator isRepeat;
    
    /**
     * 重发时间间隔
     */
    @PropertyInfo(name="重发时间间隔", length=5)
    public Integer repeatInterval;
    
    /**
     * 重发次数上限
     */
    @PropertyInfo(name="重发次数上限", length=5)
    public Integer maxRepeat;
    
    /**
     * 通知模板
     */
    @PropertyInfo(name="通知模板", length=8000)
    public String notifyTemplate;
   
    /**
     * 发送延时时间
     */
    @PropertyInfo(name="发送延时时间", length=5)
    public Integer sendTimeLapse;
    
    /**
     * 传输协议
     */
    @PropertyInfo(name="传输协议", length=80)
    public String  transportProtocol;
    
    /**
     * 响应码
     */
    @PropertyInfo(name="响应码", length=1200)
    public String  respCode;
    
    /**
     * 响应值
     */
    @PropertyInfo(name="响应值", length=80)
    public String  respValue;
    
    /**
     * 通知名称
     */
    @PropertyInfo(name="通知名称", length=80)
    public String  noticeName;
    
    /**
     * 包含请求头
     */
    @PropertyInfo(name="包含请求头", length=80)
    public Indicator isHeaders;
    
    /**
     * 请求类型
     */
    @PropertyInfo(name="请求类型", length=80)
    public String requestType;
    
    /**
     * 报文长度位数
     */
    @PropertyInfo(name="报文长度位数", length=8)
    public Integer lengthSize;
    
    /**
     * 是否内部通知
     */
    @PropertyInfo(name="是否内部通知", length=8)
    public Indicator isInternalNotice;
    
    /**
     * 通知服务id
     */
    @PropertyInfo(name="服务id", length=30)
    public String noticeServiceId;

	public String getNotifyCode() {
		return notifyCode;
	}

	public void setNotifyCode(String notifyCode) {
		this.notifyCode = notifyCode;
	}

	public String getCooperationChannel() {
		return cooperationChannel;
	}

	public void setCooperationChannel(String cooperationChannel) {
		this.cooperationChannel = cooperationChannel;
	}

	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Indicator getIsRepeat() {
		return isRepeat;
	}

	public void setIsRepeat(Indicator isRepeat) {
		this.isRepeat = isRepeat;
	}

	public Integer getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public Integer getMaxRepeat() {
		return maxRepeat;
	}

	public void setMaxRepeat(Integer maxRepeat) {
		this.maxRepeat = maxRepeat;
	}

	public String getNotifyTemplate() {
		return notifyTemplate;
	}

	public void setNotifyTemplate(String notifyTemplate) {
		this.notifyTemplate = notifyTemplate;
	}

	public Integer getSendTimeLapse() {
		return sendTimeLapse;
	}

	public void setSendTimeLapse(Integer sendTimeLapse) {
		this.sendTimeLapse = sendTimeLapse;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespValue() {
		return respValue;
	}

	public void setRespValue(String respValue) {
		this.respValue = respValue;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public Indicator getIsHeaders() {
		return isHeaders;
	}

	public void setIsHeaders(Indicator isHeaders) {
		this.isHeaders = isHeaders;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Integer getLengthSize() {
		return lengthSize;
	}

	public void setLengthSize(Integer lengthSize) {
		this.lengthSize = lengthSize;
	}
    
    
}
