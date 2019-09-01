package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.BasicInfoOfPremium;
import cn.sunline.pcm.definition.BasicNetPremium;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 
 * @author zzq
 * @date 2019年7月16日
 *
 */
public class BasicInfoOfPremiumUnit  implements IProductUnit{


    private final  String MODULE_NAME  ="basicInfoOfPremium";


    private final  String MODULE_NAME_ZH="保费基本信息";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            BasicInfoOfPremium.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
