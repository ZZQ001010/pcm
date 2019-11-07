package cn.sunline.pcm.surface.api;

import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;

import java.util.List;

/**
 * 产品工厂抽象接口
 * @zzq
 */
public interface ParameterFactory {


    /**
     * 添加新的基础参数
     * @param key 主键
     * @param param 参数实体类
     * @throws ProcessException
     */
    void addNewParameter(String key, Object param) throws ProcessException;


    /**
     * 更新基础参数
     * @param key   主键
     * @param obj   基础参数实体类
     * @param <T>   基础参数类型
     * @throws ProcessException
     */
    <T> void updateParameterObject(String key, T obj) throws ProcessException;


    /**
     * 删除基础参数
     * @param key   主键
     * @param clazz 基础参数实体类
     * @param <T>   基础参数类型
     * @throws ProcessException
     */
    <T> void deleteParameterObject(String key, Class<T> clazz) throws Exception;


    /**
     * 获取基础参数
     * @param key 主键
     * @param clazz 基础参数实体类
     * @param <T>   基础参数类型
     * @return
     */
    <T> T getParameterObject(String key, Class<T> clazz) ;


    /**
     * 取出当前类型的所有基础参数
     * @param clazz 参数类型
     * @param <T>
     * @return
     */
     <T> List<T> getParameterObjects(Class<T> clazz);


    /**
     * 反序列化
     * @param data
     * @param canonicalName
     * @return
     */
    Object decode(String data,String canonicalName) throws  Exception;

    /**
     * 序列化
     * @param obj
     * @return
     */
    String encode(Object obj);


    /**
     * 分页条件查询数据
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    <T> FetchResponse<T> getFetchResponse(FetchRequest request, Class<T> clazz);


    /**
     * 删除相同类型不同主键的参数
     * @param key
     * @param clazz
     * @param <T>
     * @throws ProcessException
     */
    <T> void deleteParameterObjects(List<String> key, Class<T> clazz) throws Exception;


    /**
     * 记录操作日志
     * @param org  操作员机构含
     * @param key  参数的key
     * @param paramClass 参数的全限类名
     * @param operation   操作类型
     * @param newObj   新的obj
     * @param oldObj 旧的obj
     * @param user 操作用户
     */
     void auditPrmModify(String org,
                                String key,
                                Class<?> paramClass,
                                ParamOperationDef operation,
                                Object newObj,
                                Object oldObj,
                                String user);



}
