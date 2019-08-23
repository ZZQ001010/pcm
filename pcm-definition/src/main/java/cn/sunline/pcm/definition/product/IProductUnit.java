package cn.sunline.pcm.definition.product;

/**
 * <p>
 * 产品组件接口定义
 * </p>
 * 
 * @version 1.0 2018年8月9日 Zcoup 修改内容:初版
 */
public interface IProductUnit {

    static  String unitConfigURI  ="/unitConfig.in";

    static String detailPageURI = "DetailPage.in";

    static String unitBaseURI = "/unitBase.in";



    
	/**
	 * <p>
	 * 获取产品组件信息
	 * </p>
	 * 
	 * @return
	 */
	public abstract ProductUnitInfo getUnitInfo();

	
}