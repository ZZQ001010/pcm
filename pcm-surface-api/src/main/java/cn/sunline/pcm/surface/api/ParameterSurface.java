package cn.sunline.pcm.surface.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;

/** 
 * <p>
 * 参数服务，仅限于参数页面编辑参数使用
 * </p>
 * @version 1.0 2017年5月27日 linxiaocheng 修改内容:初版
 */ 
public interface ParameterSurface {

	public <T> T getParameterObject(String key, Class<T> clazz);
	
//	public <T extends Serializable> Map<String, T> retrieveParameterObject(Class<T> paramClazz);
	
	public <T> List<T> getParameterObject(Class<T> clazz)  ;
	
	public <T> void updateParameterObject(String key, Object obj) throws ProcessException;
	
	public <T> void deleteParameterObject(String key, Class<T> clazz) throws Exception;
	
	public <T> void deleteParameterObjectList(List<String> key, Class<T> clazz) throws Exception;
	
	public void addNewParameter(String key, Object param) throws ProcessException;
	
	/**
	 * 由于unifiedParameterService.getFetchResponse查询数据是返回所有记录<br>
	 * 目前处理逻辑：从数据库获取某Class的所有List，在此处进行分页或表单条件查询【暂不支持排序】<br>
	 *
	 * @param request
	 * @param clazz
	 * @return
	 * @throws Exception
	 * @see [类、类#方法、类#成员]
	 */
	public <T> FetchResponse<T> getFetchResponse(FetchRequest request, Class<T> clazz);
	
	/**
	 * 区分分期产品和贷款参数定义列表
	 * 
	 * @param request
	 * @param clazz
	 * @param loanType
	 * @return
	 */
//	public <T> FetchResponse<T> getLoanFetchResponse(FetchRequest request, Class<T> clazz, String loanType);
//
//
	/** 
	 * <p>
	 * 获取产品分组
	 * </p>
	 * @param productType
	 * @return
	 * @throws ProcessException
	 */
	public List<BPcmProductGroup> getProGroup(String productType)throws ProcessException;
	
	/** 
	 * <p>
	 * 获取产品主键
	 * </p>
	 * @param productType
	 * @return
	 * @throws ProcessException
	 */
	public List<Map<String, Serializable>>  getProUnits(String groupCode)throws ProcessException;
	
	
	/** 
	 * <p>
	 * 保存映射数据
	 * </p>
	 * @param productDatas
	 * @throws ProcessException
	 */
	public void saveProductData(List<BPcmProductData> productDatas)throws ProcessException;
	
	
	
	/** 
	 * <p>
	 * 根据产品配置编号和产品配置类型
	 * </p>
	 * @param productCode
	 * @param productType
	 * @return
	 * @throws ProcessException
	 */
	public List<BPcmProductData> loadProductDatas(String productCode,String productType)throws ProcessException;

	/** 
	 * <p>
	 * 删除产品的相关映射数据
	 * </p>
	 * @param keys
	 * @param clazz
	 * @throws ProcessException
	 */
	public <T>  void  delAllRel(List<String> keys , Class<T> clazz) throws Exception;
	
	
	/** 
	 * <p>
	 * 根据paramkey 和 class  查询
	 * </p>
	 * @param paramKey
	 * @param paramClass
	 * @return
	 * @throws ProcessException
	 */
	public  List<BPcmProductData> loadMappings(String paramKey,String paramClass,String productCode)throws ProcessException;
}
