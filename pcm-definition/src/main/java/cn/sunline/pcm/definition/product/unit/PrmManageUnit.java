package cn.sunline.pcm.definition.product.unit;


import cn.sunline.pcm.definition.PrmManage;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

public class PrmManageUnit implements IProductUnit{

	private final  String MODULE_NAME  ="prmManage";


    private final  String MODULE_NAME_ZH="参数管理";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            PrmManage.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
