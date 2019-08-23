package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.FundSideProductCtrlInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
*
* @author zzq
* @date 2019年7月28日
*	资金方产品经营控制
*/
public class FundSideProductCtrlInfoUnit implements IProductUnit {

	 private final  String MODULE_NAME  ="fundSideProductCtrlInfo";


	    private final  String MODULE_NAME_ZH="资金方产品经营控制";


	    @Override
	    public ProductUnitInfo getUnitInfo() {
	            return new ProductUnitInfo(
	                            MODULE_NAME.toUpperCase(),
	                            MODULE_NAME,
	                            MODULE_NAME_ZH,
	                            ""+MODULE_URI_PREFIX+unitConfigURI,
	                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
	                            MODULE_URI_PREFIX+unitBaseURI,
	                            FundSideProductCtrlInfo.class.getName()
	                            );
	    }

	    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;

}
