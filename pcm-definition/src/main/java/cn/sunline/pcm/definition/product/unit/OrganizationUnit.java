package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.Organization;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * 机构属性
 * @author zzq
 * @date 2019年8月2日
 *
 */
public class OrganizationUnit implements IProductUnit{
	
	 private final  String MODULE_NAME  ="organization";


	    private final  String MODULE_NAME_ZH="机构属性";


	    @Override
	    public ProductUnitInfo getUnitInfo() {
	            return new ProductUnitInfo(
	                            MODULE_NAME.toUpperCase(),
	                            MODULE_NAME,
	                            MODULE_NAME_ZH,
	                            ""+MODULE_URI_PREFIX+unitConfigURI,
	                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
	                            MODULE_URI_PREFIX+unitBaseURI,
	                            Organization.class.getName()
	                            );
	    }

	    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;

}
