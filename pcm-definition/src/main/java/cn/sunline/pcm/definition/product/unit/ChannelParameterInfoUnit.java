package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.ChannelParameterInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 渠道参数信息
 * @author zzq
 * @date 2019年7月31日
 *
 */
public class ChannelParameterInfoUnit implements IProductUnit {
	 private final  String MODULE_NAME  ="channelParameterInfo";


	    private final  String MODULE_NAME_ZH="渠道参数";


	    @Override
	    public ProductUnitInfo getUnitInfo() {
	            return new ProductUnitInfo(
	                            MODULE_NAME.toUpperCase(),
	                            MODULE_NAME,
	                            MODULE_NAME_ZH,
	                            ""+MODULE_URI_PREFIX+unitConfigURI,
	                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
	                            MODULE_URI_PREFIX+unitBaseURI,
	                            ChannelParameterInfo.class.getName()
	                            );
	    }

	    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
	
	
}
