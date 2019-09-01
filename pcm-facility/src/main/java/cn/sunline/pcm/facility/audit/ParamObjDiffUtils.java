package cn.sunline.pcm.facility.audit;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sunline.common.StringUtils;
import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 参数对象对比工具
 * 
 * @author alen
 */
public class ParamObjDiffUtils {
	private static Logger logger = LoggerFactory.getLogger(ParamObjDiffUtils.class);

	private static Set<Class<?>> SIMPLE_CLAZZS = new HashSet<Class<?>>();
	static {
		SIMPLE_CLAZZS.add(Integer.class);
		SIMPLE_CLAZZS.add(Long.class);
		SIMPLE_CLAZZS.add(Boolean.class);
		SIMPLE_CLAZZS.add(Short.class);
		SIMPLE_CLAZZS.add(Double.class);
		SIMPLE_CLAZZS.add(Character.class);
		SIMPLE_CLAZZS.add(Float.class);
		SIMPLE_CLAZZS.add(Byte.class);
		SIMPLE_CLAZZS.add(BigDecimal.class);
		SIMPLE_CLAZZS.add(Date.class);
		SIMPLE_CLAZZS.add(String.class);
		SIMPLE_CLAZZS.add(Object.class);
		SIMPLE_CLAZZS.add(Class.class);
	}

	/**
	 * @param newObj
	 *            新对象
	 * @param oldObj
	 *            原对象
	 * @param fieldInfo
	 *            {@link Field}信息
	 * @param parentId
	 *            父级标签(3.1)
	 * @param seq
	 *            本级标签顺序
	 * @param lv
	 *            缩进层次
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static String diff(Object newObj, Object oldObj, String fieldInfo, String parentId, int seq, int lv) throws IllegalArgumentException,
			IllegalAccessException {
		if (newObj == null && oldObj == null){
			return "";}

		String log = "";
		String id = "";
		String head = "";
		if (seq != 0) {
			id = StringUtils.isBlank(parentId) ? String.valueOf(seq) : parentId + "." + seq;
			if (StringUtils.isNotBlank(fieldInfo)){
				head = tab(lv++) + id + ". " + fieldInfo + ":\r\n";
		} else {
			if (StringUtils.isNotBlank(fieldInfo)){
				head = tab(lv++) + fieldInfo + ":\r\n";
		}
		}

		if (newObj == null) {
			log += head;
			log += tab(lv) + MessageFormat.format("由[{0}]改为null\r\n", oldObj.toString());
			return log;
		}

		if (oldObj == null) {
			log += head;
			log += tab(lv) + MessageFormat.format("由null改为[{0}]\r\n", newObj.toString());
			;
			return log;
		}

		if (logger.isDebugEnabled()){
			logger.debug("原参数与新参数类型不同, oldObj.class[{}], newObj.class[{}]", oldObj.getClass(), newObj.getClass());
		}

		if (ClassUtils.isAssignable(oldObj.getClass(), Map.class) && ClassUtils.isAssignable(newObj.getClass(), Map.class)) {
			Map<?, ?> oldMap = (Map<?, ?>) oldObj;
			Map<?, ?> newMap = (Map<?, ?>) newObj;

			Collection<?> newElementKeys = null;
			Collection<?> removeElementKeys = null;
			Collection<?> updateElementKeys = null;

			if (oldMap != null && newMap != null) {
				removeElementKeys = CollectionUtils.subtract(oldMap.keySet(), newMap.keySet());
				newElementKeys = CollectionUtils.subtract(newMap.keySet(), oldMap.keySet());
				updateElementKeys = CollectionUtils.intersection(oldMap.keySet(), newMap.keySet());

				Set<Object> eqElementKeys = new HashSet<Object>();
				for (Iterator<?> i = updateElementKeys.iterator(); i.hasNext();) {
					Object e = i.next();

					if (oldMap.get(e) == null) {
						if (newMap.get(e) == null){
							eqElementKeys.add(e);
						}
					} else {
						if (oldMap.get(e).equals(newMap.get(e))){
							eqElementKeys.add(e);
					}
				}
				updateElementKeys = CollectionUtils.subtract(updateElementKeys, eqElementKeys);
			}

			String tmpLog = "";

			if (newElementKeys != null && !newElementKeys.isEmpty()) {
				for (Object e : newElementKeys) {
					tmpLog += tab(lv) + MessageFormat.format("新增元素key[{0}]-value[{1}]\r\n", e.toString(), newMap.get(e));
				}
			}

			if (removeElementKeys != null && !removeElementKeys.isEmpty()) {
				for (Object e : removeElementKeys) {
					tmpLog += tab(lv) + MessageFormat.format("删除元素key[{0}]-value[{1}]\r\n", e.toString(), oldMap.get(e));
				}
			}

			if (updateElementKeys != null && !updateElementKeys.isEmpty()) {
				for (Object e : updateElementKeys) {
					String valueUpLog = diff(newMap.get(e), oldMap.get(e), MessageFormat.format("修改元素key[{0}]", e.toString()), "", 0, lv);
					if (StringUtils.isNotBlank(valueUpLog)){
						tmpLog += valueUpLog;
				}
			}

			if (StringUtils.isNotBlank(tmpLog)) {
				log += head;
				log += tmpLog;
			}
		} else if ((ClassUtils.isAssignable(newObj.getClass(), Collection.class) || newObj.getClass().isArray())
				&& (ClassUtils.isAssignable(oldObj.getClass(), Collection.class) || oldObj.getClass().isArray())) {
			Collection<?> newElements = null;
			Collection<?> removeElements = null;

			Collection<?> oldCollection;
			Collection<?> newCollection;

			if (newObj.getClass().isArray()) {
				newCollection = (Collection<?>) (newObj == null ? null : Arrays.asList(newObj));
			} else {
				newCollection = (Collection<?>) newObj;
			}

			if (oldObj.getClass().isArray()) {
				oldCollection = (Collection<?>) (oldObj == null ? null : Arrays.asList(oldObj));
			} else {
				oldCollection = (Collection<?>) oldObj;
			}

			if (oldCollection == null) {
				newElements = newCollection;
				removeElements = null;
			}

			if (newCollection == null) {
				removeElements = oldCollection;
				newElements = null;
			}

			if (oldCollection != null && newCollection != null) {
				removeElements = CollectionUtils.subtract(oldCollection, newCollection);
				newElements = CollectionUtils.subtract(newCollection, oldCollection);
			}

			String tmpLog1 = head;

			if (newElements != null && !newElements.isEmpty()) {
				for (Object e : newElements) {
					tmpLog1 += tab(lv) + MessageFormat.format("增加元素-[{0}]\r\n", e.toString());
				}
			}

			if (removeElements != null && !removeElements.isEmpty()) {
				for (Object e : removeElements) {
					tmpLog1 += tab(lv) + MessageFormat.format("删除元素-[{0}]\r\n", e.toString());
				}
			}

			if (StringUtils.isNotBlank(tmpLog1)) {
				log += head;
				log += tmpLog1;
			}
		} else if (!oldObj.getClass().equals(newObj.getClass())) {
			throw new IllegalArgumentException("类型不同无法比较");
		} else if (isSimpleType(oldObj.getClass())) {
			if (!newObj.equals(oldObj)) {
				log += head;
				log += tab(lv) + MessageFormat.format("由[{0}]改为[{1}]\r\n", oldObj.toString(), newObj.toString());
			}
		} else {
			Class<?> clazz = oldObj.getClass();

			String tmpLog2 = "";
			int i = 1;
			for (Field f : clazz.getFields()) {
				Object newFO = f.get(newObj);
				Object oldFO = f.get(oldObj);

				PropertyInfo pInfo = f.getAnnotation(PropertyInfo.class);
				String tmpFieldInfo = pInfo == null ? f.getName() : MessageFormat.format("{0}({1})", f.getName(), pInfo.name());
				String tmpFieldLog = diff(newFO, oldFO, tmpFieldInfo, id, i++, lv);
				if (StringUtils.isNotBlank(tmpFieldLog)) {
					tmpLog2 += tmpFieldLog;
				} else {
					i--;
				}
			}

			if (StringUtils.isNotBlank(tmpLog2)) {
				log += head;
				log += tmpLog2;
			}
		}
			}}}
		return log;
	}

	public static boolean isSimpleType(Class<?> clazz) {
		if (clazz.isEnum()){
			return true;}
		if (clazz.isPrimitive()){
			return true;}
		if (SIMPLE_CLAZZS.contains(clazz)){
			return true;}

		return false;
	}

	// public static void main(String[] args) {
	// Branch b1 = new Branch();
	// Branch b2 = new Branch();
	// b1.address = "上海市杨高南路由由世纪广场2000号";
	// b1.branchId = "999999999";
	// b1.city = "上海";
	// b1.countryCd = "CN";
	// b1.district = "浦东新区";
	// b1.level = 2;
	// b1.name = "某某银行浦东支行";
	// b1.phone1 = "111111";
	// b1.phone2 = "222222";
	// b1.superiorBranchId = "4434343434";
	//
	// b2.name = "某某银行浦东支行2222";
	// b2.phone1 = "3333333";
	// b2.address = "上海市杨高南路由由世纪广场2000号";
	// b2.branchId = "999999999";
	// b2.city = "上海";
	// b2.countryCd = "CN";
	// b2.district = "浦东新区";
	// b2.level = 2;
	// b2.phone2 = "222222";
	// b2.superiorBranchId = "4434343434";
	//
	// try {
	// System.out.println("---------------------------");
	// System.out.println(ParamObjDiffUtils.diff(b2, b1, "", "", 0, 0));
	// } catch (IllegalArgumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// Organization o1 = new Organization();
	// Organization o2 = new Organization();
	// o1.address = "海南省海口市某条马路某条街多少号";
	// o1.baseCurrencyCode = "156";
	// o1.baseCurrencyExponent = 2;
	// o1.city = "海口";
	// o1.countryCode = "CN";
	// o1.description = "海口农商行";
	// o1.email = "donggangwhy@yahoo.com.cn";
	// o1.fax = "111111111";
	// o1.messageSendingWaySwitch = null;
	// o1.messageTemplates = new HashMap<MessageCategory, String>();
	// o1.name = "海口农商行";
	// o1.phone1 = "12312313123";
	// o1.phone2 = "323232323";
	// o1.state = "海南省";
	// o1.messageTemplates.put(MessageCategory.L01, "1");
	// o1.messageTemplates.put(MessageCategory.L02, "2");
	// o1.messageTemplates.put(MessageCategory.L03, "3");
	// o1.messageTemplates.put(MessageCategory.L04, "4");
	// o1.messageTemplates.put(MessageCategory.M01, "5");
	//
	// o2.address = "海南省海口市某条马路某条街多少号";
	// o2.baseCurrencyCode = "156";
	// o2.baseCurrencyExponent = 3;
	// o2.city = "海口";
	// o2.countryCode = "CN";
	// o2.description = "海口农商行";
	// o2.email = "donggangwhy@sina.com";
	// o2.fax = "111111111";
	// o2.messageSendingWaySwitch = MessageSendingWaySwitch.BatchOnline;
	// o2.messageTemplates = new LinkedHashMap<MessageCategory, String>();
	// o2.name = "海口农商行";
	// o2.phone1 = "12312313123";
	// o2.phone2 = null;
	// o2.state = "海南省";
	// o2.messageTemplates.put(MessageCategory.L01, "1");
	// o2.messageTemplates.put(MessageCategory.L03, "3");
	// o2.messageTemplates.put(MessageCategory.M01, "5");
	// o2.messageTemplates.put(MessageCategory.L04, "2");
	// o2.messageTemplates.put(MessageCategory.M02, "6");
	//
	// try {
	// System.out.println("---------------------------");
	// System.out.println(ParamObjDiffUtils.diff(o2, o1, "", "", 0, 0));
	// } catch (IllegalArgumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	private static String tab(int lv) {
		String h = "";

		for (int i = 0; i < lv; i++) {
			h += "\t";
		}

		return h;
	}
}