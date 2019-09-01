package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.BasicNetPremium;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 
 * @author zzq
 * @date 2019年7月16日
 *
 */
public class BasicNetPremiumUnit implements IProductUnit {


    private final  String MODULE_NAME  ="basicNetPremium";


    private final  String MODULE_NAME_ZH="基础净含保费";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            BasicNetPremium.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
