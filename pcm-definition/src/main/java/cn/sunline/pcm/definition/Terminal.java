package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

@SuppressWarnings("serial")
public class Terminal implements Serializable {
	
	/**
	 * 终端类型ID,如Wechat
	 */
	@PropertyInfo(name="终端类型ID", length=20)
	public String terminalId;
	
	/**
	 * 描述
	 */
	@PropertyInfo(name="终端描述", length=100)
	public String terminalDesc;

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalDesc() {
		return terminalDesc;
	}

	public void setTerminalDesc(String terminalDesc) {
		this.terminalDesc = terminalDesc;
	}
	
	
}
