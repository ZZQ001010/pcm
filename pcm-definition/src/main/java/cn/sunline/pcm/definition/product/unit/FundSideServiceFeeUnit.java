package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.FundSideServiceFee;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 资金方技术服务费
 * @author zzq
 *
 */
public class FundSideServiceFeeUnit implements IProductUnit {
	private final  String MODULE_NAME  ="fundSideServiceFee";


    private final  String MODULE_NAME_ZH="资金方技术服务费";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            FundSideServiceFee.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
