package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.FinancialOrg;
import cn.sunline.pcm.definition.FundSideInfo;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;


/** 
 * <p>
 * 合作机构组件
 * </p>
 * @version 1.0 2018年8月12日 Zcoup 修改内容:初版
 */
public class FinancialOrgUnit implements IProductUnit {

	 private final  String MODULE_NAME  ="financialOrg";


	    private final  String MODULE_NAME_ZH="合作机构";


	    @Override
	    public ProductUnitInfo getUnitInfo() {
	            return new ProductUnitInfo(
	                            MODULE_NAME.toUpperCase(),
	                            MODULE_NAME,
	                            MODULE_NAME_ZH,
	                            ""+MODULE_URI_PREFIX+unitConfigURI,
	                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
	                            MODULE_URI_PREFIX+unitBaseURI,
	                            FinancialOrg.class.getName()
	                            );
	    }

	    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;

}
