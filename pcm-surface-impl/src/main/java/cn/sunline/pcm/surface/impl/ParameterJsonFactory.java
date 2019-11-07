package cn.sunline.pcm.surface.impl;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.facility.ParameterManage;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 *  使用json 作为参数管理工厂
 */
public class ParameterJsonFactory extends AbstractParameterFactory {


    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String GLOBAL_KEY = "*";

    @Autowired
    private ParameterManage parameterManage;


    private DateConverter dateConverter;

    private final String SPLIT_COMMA = ",";

    @Override
    public void addNewParameter(String key, Object param) throws ProcessException {
        if (key == null){key = GLOBAL_KEY;}
        String org = KC.threadLocal.getCurrentOrg();
        PcmPrmObject object = new PcmPrmObject();
        object.setOrg(org);
        object.setParamClass(param.getClass().getCanonicalName());
        object.setParamKey(key);
        object.setParamObject(KC.json.serializer(param));
        object.setLstUpdUser(KC.threadLocal.getUserId());
		object.setCreateUser(KC.threadLocal.getUserId());
        parameterManage.save(object);
        //TODO 操作参数要有日志 del add upd
    }

    @Override
    public <T> void updateParameterObject(String key, T obj) throws ProcessException {

    }



    @Override
    public <T> void deleteParameterObjects(List<String> key, Class<T> clazz) throws ProcessException {

    }



    @Override
    public <T> List<T> getParameterObjects(Class<T> clazz) {
        List<T> result = new ArrayList();
        for (PcmPrmObject o : parameterManage.getParameterObject(clazz.getCanonicalName())) {
            T obj = KC.json.reSerializer(new String(o.getParamObject()), clazz);
            result.add(obj);
        }
        return result;
    }




    @Override
    public Object decode(String data,String canonicalName)  throws  Exception{
        return KC.json.reSerializer(data, Class.forName(canonicalName));
    }

    @Override
    public String encode(Object obj) {
        return KC.json.serializer(obj);
    }

    @Override
    public <T> FetchResponse<T> getFetchResponse(FetchRequest request, Class<T> clazz)
    {

        // 不分页的情况，避免空指针，这里初始化FetchRequest对象
        if (request == null) {
            request = new FetchRequest();
        }

        Iterable<PcmPrmObject> iter = parameterManage.getFetchResponse(request, clazz.getCanonicalName());
        FetchResponse response = new FetchResponse();

        // 获取请求条件
        Map<String, String> requestParam = request.getCriteriaMap();

        /* List<String> fields = request.getFields(); */
        List<Object> data = new ArrayList<Object>();


        try {
        // 如果请求条件参数为空，直接添加到列表
        if (requestParam == null) {
            for (PcmPrmObject prm : iter) {
                Object obj = null;
                try {
                    obj = this.decode(new String(prm.getParamObject()),prm.getParamClass());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                data.add(obj);
            }
        }

        // 对于带条件的查询，满足条件查询才添加到列表
        else {
            for (PcmPrmObject prm : iter) {
                boolean flag = true;
                Object obj = this.decode(new String(prm.getParamObject()),prm.getParamClass());

                for (Map.Entry param : requestParam.entrySet()) {

                        if (null != param.getValue() && null != FieldUtils.getField(clazz, (String)param.getKey()))
                        {
                            Object value = FieldUtils.readField(obj, (String)param.getKey(), true);
                            if (value == null) {
                                value = new String("");
                            }
                            if ((param.getValue() instanceof String) && value.getClass().isEnum()) {
                                value = ((Enum)value).name();
                            }
                            if ((param.getValue() instanceof String) && value.getClass().equals(Date.class)) {
                                // 只支持单字段日期判断
                                if (this.dealDate(param, value)) {
                                    flag = false;
                                    break;
                                }
                                continue;
                            } else {
                                if (!String.valueOf(value)
                                        .contains(URLDecoder.decode(String.valueOf(param.getValue()), "utf-8"))){
                                    flag = false;}
                            }
                        }

                }
                if (flag) {
                    data.add(obj);
                }
            }
        }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (request.getSortorder() != null) {
            final String order = request.getSortorder();
            final String sortName = request.getSortname();
            Collections.sort(data, new Comparator(){

                @Override
                public int compare(Object o1, Object o2) {
                    try {
                        Class type = o1.getClass().getField(sortName).getType();
                        Object f1 = o1.getClass().getField(sortName).get(o1);
                        Object f2 = o2.getClass().getField(sortName).get(o2);
                        // 若有空值,特殊处理
                        if (f1 == null && f2 == null){
                            return 0;
                        }else if (f1 == null && f2 != null){
                            return 1;
                        }else if (f1 != null && f2 == null){
                            return -1;
                        }

                        if (type.equals(Date.class)) {
                            Date d1 = (Date)f1;
                            Date d2 = (Date)f2;
                            if (order.equals("asc")){
                                return d1.compareTo(d2);
                            }else{
                                return d2.compareTo(d1);}
                        } else {
                            if (order.equals("asc")){
                                return (f1.toString()).compareTo(f2.toString());
                            }else{
                                return (f2.toString()).compareTo(f1.toString());}
                        }

                    } catch (Exception e) {
                        throw new ProcessException("字段名[" + sortName + "]排序异常", e);
                    }
                }

            });
        }
        // 数据总长度,
        int dataSize = data.size();

        // 不分页处理
        if (request == null || request.getPage() == null || request.getPageSize() == null) {
            response.setRows(data);
            response.setTotal(dataSize);
        }

        // 分页处理
        else {
            int page = request.getPage();
            int pageSize = request.getPageSize();
            int rowStart = (page - 1) * pageSize;
            int rowEnd = page * pageSize > dataSize ? dataSize : page * pageSize;

            // 如果开始行超出查询记录数，返回无记录
            if (rowStart < dataSize) {
                response.setRows(data.subList(rowStart, rowEnd));
            }
            response.setTotal(dataSize);
        }
        return response;


    }




    /**
     * 检查fetchfequest 是否为null
     * @return
     */
    private  FetchRequest clickFetchRequest(FetchRequest request)
    {
        return request==null? new FetchRequest(): request;
    }



    @Override
    public <T> T getParameterObject(String key, Class<T> clazz) {
        PcmPrmObject prm = parameterManage.getParameterObject(key, clazz.getCanonicalName());
        if (prm == null){
            return null;
        }
        return (T)KC.json.reSerializer(prm.getParamObject(), clazz);
    }




    /**
     * <p>
     * 处理日期的筛选
     * </p>
     *
     * @param param
     * @param value
     * @return
     * @throws UnsupportedEncodingException
     */
    private boolean dealDate(Map.Entry<String, String> param, Object value) throws UnsupportedEncodingException {
        // 只支持单字段日期判断
        if (null == dateConverter) {
            dateConverter = new DateConverter(KC.datetimePattern.DATETIME24_LINE,
                    new String[]{KC.datetimePattern.DATETIME24_BACKSLASH, KC.datetimePattern.DATE_LINE,
                            KC.datetimePattern.DATE, KC.datetimePattern.DATE_BACKSLASH});
        }
        Date valueDate = (Date)value;
        String paramValue = URLDecoder.decode(String.valueOf(param.getValue()), "utf-8");
        if (paramValue.contains(SPLIT_COMMA)) {
            // 含有逗号，是日期范围strs=['2018-12-30', '2018-12-31']
            String[] strs = paramValue.split(SPLIT_COMMA, 2);
            String start = strs[0];
            String end = strs[1];
            if (KC.string.isNotBlank(start)) {
                Date startDate = (Date)dateConverter.fromString(start);
                // startDate=2018-12-30 00:00:00
                startDate = KC.date.getDateForZeroTime(startDate);
                if (startDate.after(valueDate)) {
                    return true;
                }
            }
            if (KC.string.isNotBlank(end)) {
                Date endDate = (Date)dateConverter.fromString(end);
                // endDate=2019-01-01 00:00:00
                endDate = KC.date.addDays(KC.date.getDateForZeroTime(endDate), 1);
                if (endDate.before(valueDate) || endDate.getTime() == valueDate.getTime()) {
                    return true;
                }
            }
        } else {
            // 无逗号，是单个日期，传入2019-01-01则要求在2019-01-01 00:00:00到2019-01-01 23:59:59之间
            if (KC.string.isNotBlank(paramValue)) {
                // date=2019-01-01
                Date date = (Date)dateConverter.fromString(paramValue);
                // startDate=2019-01-01 00:00:00
                Date startDate = KC.date.getDateForZeroTime(date);
                if (startDate.after(valueDate)) {
                    return true;
                }
                // endDate=2019-01-02 00:00:00
                Date endDate = KC.date.addDays(startDate, 1);
                if (endDate.before(valueDate) || endDate.getTime() == valueDate.getTime()) {
                    return true;
                }
            }
        }
        return false;
    }




}
