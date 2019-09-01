package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.GuaranteeFee;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;
import cn.sunline.ppy.dictionary.entity.fico.Guarantee;

/**
 * 
 * @author zzq
 * @date 2019年7月16日
 *
 */
public class GuaranteeFeeUnit implements IProductUnit {

    private final  String MODULE_NAME  ="guaranteeFee";


    private final  String MODULE_NAME_ZH="担保费";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            GuaranteeFee.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
