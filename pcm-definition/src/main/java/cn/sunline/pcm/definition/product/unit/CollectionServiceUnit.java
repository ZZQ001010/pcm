package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.AssetSideCtrlInfo;
import cn.sunline.pcm.definition.CollectionService;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 催收服务费
 * @author zzq
 * @date 2019年7月31日
 *
 */
public class CollectionServiceUnit implements IProductUnit{

	private final  String MODULE_NAME  ="collectionService";


    private final  String MODULE_NAME_ZH="催收服务费";


    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            CollectionService.class.getName()
                            );
    }

    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
