package cn.sunline.pcm.definition.product.unit;


import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 *	保费滞纳金
 * @author zzq
 * @date 2019年7月31日
 *
 */
public class PremiumLatePaymentFeeUnit implements IProductUnit {
	private final  String MODULE_NAME  ="premiumLatePaymentFee";


    private final  String MODULE_NAME_ZH="保费滞纳金";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            PremiumLatePaymentFee.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
