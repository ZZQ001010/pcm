package cn.sunline.pcm.service;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.pcm.definition.product.IProductUnit;
import cn.sunline.pcm.definition.product.ProductUnitInfo;

/**
 * <p>
 * 产品组件服务
 * </p>
 * 
 * @version 1.0 2018年8月10日 Zcoup 修改内容:初版
 */
@Service
public class ProductUnitService implements InitializingBean {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 产品组件集合
	 */
	private Map<String, ProductUnitInfo> units = new HashMap<String, ProductUnitInfo>();

	/**
	 * 重复unitCode的存储集合
	 */
	private Map<String, ProductUnitInfo> repeatUnits = new HashMap<String, ProductUnitInfo>();

	/**
	 * 所有unitCode的去重索引
	 */
	private Integer repeatIndex = 0;

	/**
	 * <p>
	 * 获取产品组件的选项值
	 * </p>
	 * 
	 * @return Map&lt;UNITCODE, unitName或unitNameCn&gt;
	 */
	public Map<String, String> getProductUnitOptions() {
		this.repeatCheck();
		Map<String, String> options = new HashMap<String, String>();
		for (String key : units.keySet()) {
			options.put(key, Locale.CHINESE.getLanguage().equals(LocaleContextHolder.getLocale().getLanguage()) ? units
					.get(key).getUnitNameCn() : units.get(key).getUnitName());
		}
		return options;
	}

	/**
	 * <p>
	 * 获取所有产品组件
	 * </p>
	 * 
	 * @return Map&lt;UNITCODE, ProductUnitInfo&gt;
	 */
	public Map<String, ProductUnitInfo> getProductUnitsMap() {
		this.repeatCheck();
		return units;
	}

	/**
	 * <p>
	 * 获取所有产品组件
	 * </p>
	 * 
	 * @return List&lt;ProductUnitInfo&gt;
	 */
	public List<ProductUnitInfo> getProductUnitsList() {
		this.repeatCheck();
		List<ProductUnitInfo> list = new ArrayList<ProductUnitInfo>();
		for (ProductUnitInfo info : units.values()) {
			list.add(info);
		}
		return list;
	}

	/**
	 * <p>
	 * 根据unitCode获取二级组件类型
	 * </p>
	 * 
	 * @param unitCode
	 * @return
	 */
	public Class<? extends Enum<?>> getSubUnitClazz(String unitCode) {
		this.repeatCheck();
		unitCode = KC.string.upperCase(unitCode);
		if (units.containsKey(unitCode)) {
			return units.get(unitCode).getUnitSubClass();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("参数组件: 开始扫描");
		this.scanPackageAndFind();
		logger.debug("参数组件: 扫描结果{}个有效组件，序列化数据{}", units.size(), KC.json.serializerNoType(units));
		logger.debug("参数组件: 完成扫描, 开始校验");
		this.repeatCheck();
		logger.debug("参数组件: 校验完毕..........");
	}

	/**
	 * <p>
	 * 私有方法：重复检查
	 * </p>
	 */
	private void repeatCheck() {
		if (!repeatUnits.isEmpty()) {
			logger.error(	"参数组件: 发现重复组件请修正: KEY值[{}], 完整数据[{}]", KC.json.serializerNoType(repeatUnits.keySet()),
							KC.json.serializerNoType(repeatUnits));
		}
	}

	/**
	 * <p>
	 * 私有方法：扫描指定包和寻找子类
	 * </p>
	 */
	private void scanPackageAndFind() {
		// 递归扫描指定包路径
		List<Class<?>> list = new ArrayList<Class<?>>();
		List<String> packages = Arrays.asList(new String[]{"cn.sunline"});
		for (String pkg : packages) {
			logger.debug("参数组件: 开始扫描{}", pkg);
			List<Class<?>> clazzs = KC.Package.getClassList(pkg, true);
			list.addAll(clazzs);
		}
		if (null == list || list.isEmpty()) {
			return;
		}
		for (Class<?> clazz : list) {
			if (this.isChildClass(clazz, IProductUnit.class)) {
				IProductUnit unit = null;
				try {
					unit = (IProductUnit)clazz.newInstance();
				} catch (Exception e) {
					logger.debug("组件实例[" + clazz.getName() + "]获取异常", e);
					throw new ProcessException("组件实例获取异常", e);
				}
				if (null == unit) {
					continue;
				}
				ProductUnitInfo info = unit.getUnitInfo();
				if (null == info) {
					logger.debug("参数组件: 组件[{}]未配置组件信息, 跳过", clazz.getName());
					continue;
				}
				String key = KC.string.upperCase(info.getUnitCode());
				if (!units.containsKey(key)) {
					units.put(key, info);
				} else {
					this.addRepeatUnit(key, info);
				}
			}
		}
	}

	/**
	 * <p>
	 * 私有方法：添加重复组件
	 * </p>
	 * 
	 * @param key
	 * @param info
	 */
	private void addRepeatUnit(String key, ProductUnitInfo info) {
		// 重复key值去重构建 = 原key + 去重索引repeatIndex
		repeatIndex += 1;
		String repeatSolvedKey = key + repeatIndex;
		if (!repeatUnits.containsKey(repeatSolvedKey)) {
			repeatUnits.put(repeatSolvedKey, info);
		} else {
			// 重复集合里面恰好也有和repeatSolvedKey重复的key存在，则循环执行
			this.addRepeatUnit(key, info);
		}
	}

	/**
	 * <p>
	 * 私有方法：是否为子类
	 * </p>
	 * 
	 * @param clazz
	 * @param parentClazz
	 * @return
	 */
	private boolean isChildClass(Class<?> clazz, Class<IProductUnit> parentClazz) {
		if (clazz == null || null == parentClazz) {
			return false;
		}
		// 忽略抽象类、接口
		if (Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
			return false;
		}
		return parentClazz.isAssignableFrom(clazz);
	}

}
