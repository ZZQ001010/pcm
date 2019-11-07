package cn.sunline.pcm.surface.impl;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.facility.ParameterManage;
import cn.sunline.pcm.facility.audit.ParamObjDiffUtils;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import cn.sunline.pcm.surface.api.ParameterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 基础实现类
 */
public abstract class AbstractParameterFactory implements ParameterFactory {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public static final String GLOBAL_KEY = "*";

    @Autowired
    ParameterManage parameterManage;


    /**
     * 记录参数操作审计日志
     *
     * @param org
     * @param key
     * @param paramClass
     * @param operation
     * @param newObj
     * @param oldObj
     * @param user
     */
    public void auditPrmModify(String org, String key, Class<?> paramClass, ParamOperationDef operation, Object newObj,
                               Object oldObj, String user) {
        PcmPrmAudit prmAudit = new PcmPrmAudit();
        prmAudit.setOrg(org);
        prmAudit.setParamKey(key);
        prmAudit.setParamClass(paramClass.getName());
        prmAudit.setParamOperation(operation);
        prmAudit.setOldObject(encode(oldObj));
        prmAudit.setNewObject(encode(newObj));
        prmAudit.setMtnUser(user);
        switch (operation) {
            case INSERT:
                prmAudit.setUpdateLog("新增参数，详细记录参看xml数据");
                break;
            case DELETE:
                prmAudit.setUpdateLog("删除参数，原记录参看xml数据");
                break;
            case UPDATE:
                try {
                    prmAudit.setUpdateLog(ParamObjDiffUtils.diff(newObj, oldObj, "", "", 0, 0));
                } catch (IllegalArgumentException e) {
                    logger.error("对象对比时异常", e);
                    throw new RuntimeException("记录参数修改审计日志异常");
                } catch (IllegalAccessException e) {
                    logger.error("对象对比时异常", e);
                    throw new RuntimeException("记录参数修改审计日志异常");
                }
                break;
            default:
                break;
        }
        parameterManage.persistPrmAudit(prmAudit);
    }



    @Transactional
    public <T> void deleteParameterObject(String key, Class<T> clazz) throws Exception {
        if (key == null){
            key = GLOBAL_KEY;}
        String org = KC.threadLocal.getCurrentOrg();
        PcmPrmObject param = loadParam(org, clazz, key);
        Object oldObj = decode(new String(param.getParamObject()),param.getParamClass());
        parameterManage.deleteParameterObject(param);


        auditPrmModify(org, key, clazz, ParamOperationDef.DELETE, null, oldObj, KC.threadLocal.getUserId());
    }



    public  PcmPrmObject loadParam(String org, Class<?> paramClass, String key) {
        // PcmPrmObject param = rPrmObject.findByOrgAndParamClassAndParamKey(org, paramClass.getCanonicalName(), key);
        PcmPrmObject param = parameterManage.loadParam(org, paramClass.getCanonicalName(), key);
        if (param == null){
            throw new ProcessException("没找到参数:" + org + "|" + paramClass.getCanonicalName() + "|" + key);}
        return param;
    }

}
