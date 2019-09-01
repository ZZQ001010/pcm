//package cn.sunline.pcm.service.api;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public interface UnifiedParameterExtendService {
//	
//	/**
//	 * 通过主键获取一条产品参数
//	 * 
//	 * @param productCode
//	 * @return
//	 */
//	LinkedHashMap<String, UnifiedParameter> getProductCredit(String productCode);
//	
//	
//	/**
//	 * 获取所有产品参数
//	 * 
//	 * @param paramClass
//	 * @return
//	 */
//	Map<String, LinkedHashMap<String, UnifiedParameter>> getProductCredits();
//	
//	
//	/** 
//	 * <p>
//	 * 通过产品编码获取loanplan
//	 * </p>
//	 * @param productKey
//	 * @param paramClazzName
//	 * @return
//	 */
//	LinkedHashMap<String, UnifiedParameter> getLoanPlan(String productCode, String paramClazzName);
//	
//	/** 
//	 * <p>
//	 * 获取所有的LoanPlan
//	 * </p>
//	 * @param paramClazzName
//	 * @return
//	 */
//	Map<String, LinkedHashMap<String, UnifiedParameter>> getLoanPlans(String paramClazzName);
//	
//	/**
//	 * 通过产品编码获取loanplan
//	 * @param productCode
//	 * @param paramClazzName
//	 * @return
//	 */
//	UnifiedParameter getLoanPlanByProductCode(String productCode, String paramClazzName);
//	
//	
//}
