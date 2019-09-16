package cn.sunline.pcm.controller.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sunline.common.KC;
import cn.sunline.common.StringUtils;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;
import cn.sunline.pcm.surface.ProductUnitSurface;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.service.CodeService;

/**
 * 第一个字段写code，第二个字段写描述
 * @author zzq
 * @date 2019年8月16日
 *
 */
@RestController
@RequestMapping("/paramCommon")
public class ParameterCommonHandler {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParameterSurface parameterSurface; 
	@Autowired
	private CodeService codeService;	

	@Autowired
	private ProductUnitSurface productUnitSurface; 
	
	public static final String BOOLEANDIC = "booleanDic";
	
	/**
	 * 返回对应参数属性的一个集合
	 * @param paramClass  参数的class
	 * @param paramCode paramCode 所在类文件中属性的第几个
	 * @param paramDesc paramDesc 所在类文件中属性的第几个 
	 * @return
	 */
	@RequestMapping("/getParamCollection.in")
	public Map<Object, Object> getParamCollection(
			String paramClass,
			@RequestParam(value="paramCode",defaultValue="0") Integer paramCode,
			@RequestParam(value="paramDesc",defaultValue="1") Integer paramDesc
	) throws FlatException{
		try{
			Class<?> paramClazz = Class.forName(paramClass);
			List<?> parameterObject = parameterSurface.getParameterObject(paramClazz);
		    List<Field> fields = Arrays.asList(paramClazz.getFields());
		    fields.forEach(x->x.setAccessible(true));
		    return  parameterObject.parallelStream().collect(
		    		Collectors.toMap(t -> {
						try {
							return fields.get(paramCode).get(t);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new FlatException(e,"paramType.nodefind.filed","对应的参数未找到!");
						} 
					},x-> {
						try {
							//描述可以为null，但是code不能为null
							return Optional.ofNullable(fields.get(paramDesc).get(x)).orElse("");
						} catch (Exception e) {
							e.printStackTrace();
							throw new FlatException(e,"paramType.nodefind.filed","对应的参数未找到!");
						}  
					}));
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"paramType.nodefind.filed","对应的参数未找到!");
		}
	     
	}
	
	
	/**
	 * 获取参数的基本信息
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping("/getParamBaseInfo.in")
	private Map<Object,Object> getParamBaseInfo(
				String code ,
				String paramClass,
				@RequestParam(name="startAttrIndex",defaultValue="0") Integer startAttrIndex,
				@RequestParam(name="endAttrIndex",defaultValue="5") Integer endAttrIndex
			) throws FlatException{
		try{
		Class<?> paramClazz = Class.forName(paramClass);
		Object obj = parameterSurface.getParameterObject(code, paramClazz);
		 List<Field> fields = Arrays.asList(paramClazz.getFields());
		 if (!(fields.size()<=endAttrIndex)) {
			 fields= fields.subList(startAttrIndex,endAttrIndex);
		}
		return fields.parallelStream().collect(
				 Collectors.toMap(
						 k->k.getDeclaredAnnotation(cn.sunline.common.annotation.paramdef.PropertyInfo.class).name(),
						 v->analysisField(v,obj)
						 ));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"param.notfind.filed","对应的参数未找到!");
		}
		
	}
	
	
	
	/**
	 * 解析字段类型，根据字段类型解析为不同的值
	 * @param field 参数中的字段
	 * @param obj 参数
	 * @return
	 */
	@SuppressWarnings("all")
	private Object  analysisField(Field field,Object obj) {
		Class<?> type = field.getType();
		Object object =null;
		try {
			object = field.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("参数属性获取失败....");
		}
		if (type.isEnum()) {
			//枚举类型
			 return KC.Enum.getI18nLabelMap((Class<? extends Enum<?>>) type).get(object.toString());
		}else if (obj instanceof Boolean) {
			//布尔类型
			 return  codeService.getCodeMapByCodeType("booleanDic").get(obj);
		}else {
			//数组，结构体，string 都按照默认的tostring()
			return object==null?"":object; 
		}
	}
	
	
	
	/**
	 * 检查参数是否已经被产品关联，如果存在参数存在关联返回true，并且返回关联的产品id
	 * @param paramClass 参数的全限类名
	 * @param paramId 参数的业务主键
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkupParamIsExist.in")
	public List<BPcmProductRel> checkupParamIsExist(String paramClass,String ids){
		try{
			if (StringUtils.isEmpty(paramClass)) {
				logger.info("没有配置paramClass 参数，请在资源配置模块进行配置");
				throw new FlatException("product.parameterCommonHandler.clickup.filed","检查参数是否在产品中引用失败");
			}
			return productUnitSurface.checkupParamIsExist( paramClass, Arrays.asList(ids.split(",")));
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"product.parameterCommonHandler.clickup.filed","检查参数是否在产品中引用失败");
		}
	}
	
	
}
