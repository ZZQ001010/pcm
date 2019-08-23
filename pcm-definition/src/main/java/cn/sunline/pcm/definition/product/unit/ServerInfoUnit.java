package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 服务方基本信息
 * @author zzq
 * @date 2019年8月2日
 *
 */
public class ServerInfoUnit implements IProductUnit {
    private final  String MODULE_NAME  ="serverInfo";


    private final  String MODULE_NAME_ZH="服务方基本信息";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            ServerInfo.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
