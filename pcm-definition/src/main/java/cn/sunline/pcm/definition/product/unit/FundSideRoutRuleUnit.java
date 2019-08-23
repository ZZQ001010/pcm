/**
* @ClassName: FundSideRoutRuleUnit
* @Description: TODO()
* @author BlueMelancholy
* @date 2019年7月11日
*
*/
package cn.sunline.pcm.definition.product.unit;

import cn.sunline.pcm.definition.FundSideRoutRule;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * @author zhaodong
 * 2019年7月11日
 */
public class FundSideRoutRuleUnit implements IProductUnit{

	private final  String MODULE_NAME  ="fundSideRoutRule";


    private final  String MODULE_NAME_ZH="资金方路由规则";
    private final  String MODULE_URI_PREFIX="/"+MODULE_NAME;

    @Override
    public ProductUnitInfo getUnitInfo() {
            return new ProductUnitInfo(
                            MODULE_NAME.toUpperCase(),
                            MODULE_NAME,
                            MODULE_NAME_ZH,
                            ""+MODULE_URI_PREFIX+unitConfigURI,
                            MODULE_URI_PREFIX+MODULE_URI_PREFIX+detailPageURI,
                            MODULE_URI_PREFIX+unitBaseURI,
                            FundSideRoutRule.class.getName()
                            );
    }

    

}
