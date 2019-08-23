package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.FundSideSettlementMethod;
import cn.sunline.pcm.definition.Mulct;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

public class MulctUnit implements IProductUnit{
	private final  String MODULE_NAME  ="mulct";


    private final  String MODULE_NAME_ZH="罚金利率管理";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            Mulct.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
