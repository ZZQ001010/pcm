package cn.sunline.pcm.service.api;

import java.io.Serializable;

public class UnifiedParameter implements Serializable {
	private static final long serialVersionUID = 8661012229808177026L;

	private String parameterXML;
	
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 参数对应的XStream版的XML字符串
	 */
	public String getParameterXML() {
		return parameterXML;
	}

	public void setParameterXML(String parameterXML) {
		this.parameterXML = parameterXML;
	}
}
