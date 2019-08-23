package cn.sunline.pcm.definition;


import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ChannelAttributionType;

/**
 * 渠道参数信息
 * @author fwp
 * @date 2019年7月30日
 *
 */
public class ChannelParameterInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	@PropertyInfo(name="渠道编码",length=12)
    public String channelCode ;

    @PropertyInfo(name="渠道名称",length=50)
    public String channelName ;

    @PropertyInfo(name="渠道归属类型",length=50)
    public ChannelAttributionType channelAttributionType ;

    @PropertyInfo(name="渠道归属",length=50)
    public String channelAttribution ;

    
    
	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}



	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public ChannelAttributionType getChannelAttributionType() {
		return channelAttributionType;
	}

	public void setChannelAttributionType(ChannelAttributionType channelAttributionType) {
		this.channelAttributionType = channelAttributionType;
	}

	public String getChannelAttribution() {
		return channelAttribution;
	}

	public void setChannelAttribution(String channelAttribution) {
		this.channelAttribution = channelAttribution;
	}

   
}
