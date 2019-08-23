package cn.sunline.pcm.definition.product.utils;


/**
 * 
 * @ClassName:  ProductUtils   
 * @Description:TODO(针对产品工厂注册过程中提供的一个util)   
 * @author: zzq 
 * @date:   2019年6月23日 下午1:53:44
 */
public class ProductUtils {

	public  final static String COMMON_SEPARATOR = "()"; 
	
	public final static String COMMON_DETAILPAGE_FLAG="isFactory";
	
	public final static String MERGE_PRIMARY_KEY_FLAG ="|";
	/**
	 *  
	 * @Description:    TODO()   
	 * @param:  @param detailCode
	 * @param:  @param factoryCode
	 * @param:  @return  
	 * @throwsseparator
	 */
	public static boolean  isFactory(String detailCode,String factoryCode){
		if (detailCode==null) {
			return true;
		}if (factoryCode==null) {
			 return false;
		}
		return true;
	}
	
	
}
