package cn.sunline.pcm.surface.impl;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductData;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductUnits;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductUnits;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnits;
import cn.sunline.pcm.surface.ProductUnitsSurface;
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;

/** 
 * <p>
 * 产品页面组件表 Surface 实现类
 * </p>
 * @version 1.0 2017-12-05 修改内容:初版
 */
@Service
public class ProductUnitsSurfaceImpl implements ProductUnitsSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmProductUnits rPcmProductUnits;
	
	@Autowired
	private RPcmProductData rPcmProductData;
	
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#queryProductUnitsList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	public FetchResponse<?> queryProductUnitsList(FetchRequest request) throws Exception {
		QPcmProductUnits qPcmProductUnits = QPcmProductUnits.pcmProductUnits;
		QPcmProductGroup qPcmProductGroup=  QPcmProductGroup.pcmProductGroup;
		JPAQuery<PcmProductUnits> query = new JPAQueryFactory(em).select(qPcmProductUnits).from(qPcmProductUnits,qPcmProductGroup);
		query.where(qPcmProductUnits.groupCode.eq(qPcmProductGroup.groupCode));
		query.where(qPcmProductUnits.org.eq(KC.threadLocal.getCurrentOrg()));
		if (KC.string.isNotEmpty(request.getParameter(PcmProductUnits.P_GROUP_CODE))) {
			String groupCode = URLDecoder.decode(request.getParameter(PcmProductUnits.P_GROUP_CODE),"UTF-8");
			query.where(qPcmProductUnits.groupCode.like("%" + groupCode + "%"));
		}
		if (KC.string.isNotEmpty(request.getParameter(PcmProductUnits.P_UNIT_CODE))) {
			String unitCode = URLDecoder.decode(request.getParameter(PcmProductUnits.P_UNIT_CODE),"UTF-8");
			query.where(qPcmProductUnits.unitCode.like("%" + unitCode + "%"));
		}
		if (KC.string.isNotEmpty(request.getParameter(PcmProductUnits.P_UNIT_INDEX))) {
			String unitIndex = URLDecoder.decode(request.getParameter(PcmProductUnits.P_UNIT_INDEX),"UTF-8");
			query.where(qPcmProductUnits.unitIndex.like("%" + unitIndex + "%"));
		}
		if(KC.string.isNotEmpty(request.getParameter("type"))){
			String type=request.getParameter("type");
			query.where(qPcmProductGroup.productType.eq(type));
		}
		return new JPAQueryFetchResponseBuilder(request, query).addFieldMapping(qPcmProductUnits).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#findAllProductUnits()
	 */
	@Override
	public List<BPcmProductUnits> findAllProductUnits() throws Exception {
		QPcmProductUnits qPcmProductUnits = QPcmProductUnits.pcmProductUnits;
		return PcmProductUnits.convertToBOList(rPcmProductUnits.findAll(qPcmProductUnits.org.eq(KC.threadLocal.getCurrentOrg())));
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#findProductUnitsById(String id)
	 */
	@Override
	public BPcmProductUnits findProductUnitsById(String id) throws Exception {
		PcmProductUnits tmProductUnits = rPcmProductUnits.findById(id).orElse(null);
		return tmProductUnits == null ? null : tmProductUnits.toBO();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#addProductUnits(cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits)
	 */
	@Override
	public void addProductUnits(BPcmProductUnits bPcmProductUnits) throws Exception {
		PcmProductUnits tm =  rPcmProductUnits.findByUnitCodeAndOrg(bPcmProductUnits.getUnitCode(), KC.threadLocal.getCurrentOrg());
		if(tm!=null){
			throw new ProcessException("productUnits.productUnit.exit", "该产品组件已经存在");
		}
		PcmProductUnits tmProductUnits = new PcmProductUnits();
		tmProductUnits.updateValueFromBO(bPcmProductUnits);
		tmProductUnits.setUnitCode(UUID.randomUUID().toString().replaceAll("-", ""));
		tmProductUnits.setCreateUser(KC.threadLocal.getUserId());
		tmProductUnits.setLstUpdUser(KC.threadLocal.getUserId());
		tmProductUnits.setCreateTime(new Date());
		tmProductUnits.setOrg(KC.threadLocal.getCurrentOrg());
		rPcmProductUnits.save(tmProductUnits);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#updProductUnits(cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits)
	 */
	@Override
	@Transactional
	public void updProductUnits(BPcmProductUnits bPcmProductUnits) throws Exception {
		PcmProductUnits tmProductUnits = rPcmProductUnits.findById(bPcmProductUnits.getId())
				.orElseThrow(new ProcessException("kite.web.common.notexist", "该数据不存在[{0}]"));
		tmProductUnits.updateValueFromBO(bPcmProductUnits);
		tmProductUnits.setLstUpdUser(KC.threadLocal.getUserId());
		tmProductUnits.setLstUpdTime(new Date());
		rPcmProductUnits.save(tmProductUnits);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#delProductUnitsByIds(List<String> ids)
	 */
	@Override
	@Transactional
	public void delProductUnitsByIds(List<String> ids) throws Exception {
		QPcmProductData qPcmProductData=QPcmProductData.pcmProductData;
		String org = KC.threadLocal.getCurrentOrg();
		for (String id : ids) {
			//根据id查询出对应得组件 根据组件查找到映射表中的数据 并删除
			PcmProductUnits findOne = rPcmProductUnits.findById(id).get();
			Iterable<PcmProductData> findAll = rPcmProductData.findAll(qPcmProductData.org.eq(org).and(qPcmProductData.unitCode.eq(findOne.getUnitCode())));
			rPcmProductData.deleteAll(findAll);
			rPcmProductUnits.deleteById(id);
		}
	}

	@Override
	public String findProductUnitsByCode(String groupCode) throws Exception {
		QPcmProductUnits qPcmProductUnits = QPcmProductUnits.pcmProductUnits;
		JPAQuery<PcmProductUnits> query = new JPAQueryFactory(em).select(qPcmProductUnits).from(qPcmProductUnits);
		List<PcmProductUnits> list=query.where(qPcmProductUnits.groupCode.equalsIgnoreCase(groupCode)).fetch();
		if(list.size()>0){
		return "have";
		}else{
		return null;
		}
	}
	@Override
	public Map<String,String> findUpdateUnitsAddPage(String productType,String groupCode) throws Exception{
		QPcmProductUnits qPcmProductUnits = QPcmProductUnits.pcmProductUnits;
		QPcmProductGroup qPcmProductGroup=  QPcmProductGroup.pcmProductGroup;
		Locale locale = LocaleContextHolder.getLocale();
		boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
		JPAQuery<PcmProductUnits> query = new JPAQueryFactory(em).select(qPcmProductUnits).from(qPcmProductUnits,qPcmProductGroup);
		query.where(qPcmProductUnits.groupCode.eq(qPcmProductGroup.groupCode));
		query.where(qPcmProductUnits.org.eq(KC.threadLocal.getCurrentOrg()));
		List<PcmProductUnits> list = query.where(qPcmProductGroup.productType.eq(productType)).fetch();
		Map<String,String> map= new HashMap<String,String>();
		for(PcmProductUnits units:list){
			if(isChinese){
				map.put(units.getUnitCode(),units.getUnitNameCn());
			}
			else{
				map.put(units.getUnitCode(),units.getUnitName());
			}
		}
		return map;
	}

	@Override
	public Map<String, String> findUpdateUnitsEditPage(String productType, String groupCode, String unitCode)
			throws Exception {
		QPcmProductUnits qPcmProductUnits = QPcmProductUnits.pcmProductUnits;
		QPcmProductGroup qPcmProductGroup=  QPcmProductGroup.pcmProductGroup;
		Locale locale = LocaleContextHolder.getLocale();
		boolean isChinese = Locale.CHINESE.getLanguage().equals(locale.getLanguage());
		JPAQuery<PcmProductUnits> query = new JPAQueryFactory(em).select(qPcmProductUnits).from(qPcmProductUnits,qPcmProductGroup);
		query.where(qPcmProductUnits.groupCode.eq(qPcmProductGroup.groupCode));
		 query.where(qPcmProductUnits.unitCode.ne(unitCode));
		 query.where(qPcmProductUnits.org.eq(KC.threadLocal.getCurrentOrg()));
		List<PcmProductUnits> list = query.where(qPcmProductGroup.productType.eq(productType)).fetch();
		Map<String,String> map= new HashMap<String,String>();
		for(PcmProductUnits units:list){
			if(isChinese){
				map.put(units.getUnitCode(),units.getUnitNameCn());
			}
			else{
				map.put(units.getUnitCode(),units.getUnitName());
			}
		}
		return map;
	}

	@Override
	public Map<String, BPcmProductData> findByClass(String paramClass) throws Exception {
		JPAQuery<PcmProductData> query=new JPAQuery<PcmProductData>(em);
		QPcmProductData qtmProductData=QPcmProductData.pcmProductData;
		query.select(qtmProductData).from(qtmProductData);
		query.where(qtmProductData.org.eq(KC.threadLocal.getCurrentOrg()));
		query.where(qtmProductData.paramClass.eq(paramClass));
		List<PcmProductData> fetch = query.fetch();
		Map<String, BPcmProductData> dataMap=new HashMap<String, BPcmProductData>();
		for (int i = 0; i < fetch.size(); i++) {
			PcmProductData prodata = fetch.get(i);
			dataMap.put(prodata.getParamKey(),prodata.toBO());
		}
		return dataMap;
	}

	
}
