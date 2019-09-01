package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.PacificInsuranceAgencyDedit;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 太保违约金收入
 * @author zzq
 * @date 2019年8月23日
 *
 */

public class PacificInsuranceAgencyDeditUnit  implements IProductUnit{



    private final  String MODULE_NAME  ="pacificInsuranceAgencyDedit";


    private final  String MODULE_NAME_ZH="太保违约金收入";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            PacificInsuranceAgencyDedit.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
	
}
