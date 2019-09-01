package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.ChannelInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 渠道方基本信息
 * @author ww
 * @date 2019年8月1日
 *
 */
public class ChannelInfoUnit implements IProductUnit{

	private final  String MODULE_NAME  ="channelInfo";


    private final  String MODULE_NAME_ZH="渠道方基本信息";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            ChannelInfo.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
