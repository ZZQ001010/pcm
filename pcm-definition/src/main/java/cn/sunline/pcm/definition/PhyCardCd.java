package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.ppy.dictionary.enums.MediaType;

/**
 * 卡面代码参数
 */
public class PhyCardCd implements Serializable {

	private static final long serialVersionUID = 1533398278187114504L;

	/**
     * 卡面代码
     */
    @PropertyInfo(name="卡面代码", length=10)
    public String pyhCd;

    /**
     * 描述
     */
    @PropertyInfo(name="描述", length=40)
    public String description;

    /**
     * 卡面制卡文件
     */
    @PropertyInfo(name="卡面制卡文件", length=40)
    public String embossFileName;

    /**
     * 卡面介质类型
     * I - 芯片卡 
     * M - 磁条卡
     * B - 芯片磁条复合卡
     */
    @PropertyInfo(name="卡面介质类型", length=1)
    public MediaType mediaType;

	public String getPyhCd() {
		return pyhCd;
	}

	public void setPyhCd(String pyhCd) {
		this.pyhCd = pyhCd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmbossFileName() {
		return embossFileName;
	}

	public void setEmbossFileName(String embossFileName) {
		this.embossFileName = embossFileName;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
