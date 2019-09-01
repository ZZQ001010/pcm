package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.AssetSideInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

public class AssetSideInfoUnit implements IProductUnit {

	  private final  String MODULE_NAME  ="assetSideInfo";


	    private final  String MODULE_NAME_ZH="资产方基本信息";


	    @Override
	    public ProductUnitInfo getUnitInfo() {
	            return new ProductUnitInfo(
	                            MODULE_NAME.toUpperCase(),
	                            MODULE_NAME,
	                            MODULE_NAME_ZH,
	                            ""+MODULE_URI_PREFIX+unitConfigURI,
	                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
	                            MODULE_URI_PREFIX+unitBaseURI,
	                            AssetSideInfo.class.getName()
	                            );
	    }

	    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;
}
