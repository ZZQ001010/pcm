package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.ppy.dictionary.enums.InputSource;

/**
 * 内部的MCC和银联MCC相同
 */
public class Mcc implements Serializable {

	private static final long serialVersionUID = -1117039260194409992L;

	/**
     * 接入卡组织
     */
    @PropertyInfo(name="接入卡组织", length=8)
    public InputSource inputSource;
    
    /**
     * 国际组织MCC代码
     */
    @PropertyInfo(name="国际组织MCC代码", length=4)
    public String mcc;

    /**
     * MCC大类
     */
    @PropertyInfo(name="MCC大类", length=1)
    public String mccType;

    /**
     * 描述
     */
    @PropertyInfo(name="描述", length=40)
    public String description;
    
    /**
     * @param brand
     * @param mcc
     * @return 组装key
     */
    public static String assemblingMccKey(String mcc, InputSource input) {
    	return mcc + "|" + input;
    }

	public InputSource getInputSource() {
		return inputSource;
	}

	public void setInputSource(InputSource inputSource) {
		this.inputSource = inputSource;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMccType() {
		return mccType;
	}

	public void setMccType(String mccType) {
		this.mccType = mccType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
