package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.ElectronicTemplet;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

public class ElectronicTempletUnit implements IProductUnit{
	private final  String MODULE_NAME  ="electronicTemplet";

    private final  String MODULE_NAME_ZH="电子资料模板";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            ElectronicTemplet.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
	
}
