package cn.sunline.pcm.surface.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.sunline.pcm.surface.api.ParameterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQuery;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.enums.ProductUnitsURL;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductData;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnits;
import cn.sunline.pcm.infrastructure.server.repos.RPcmPrmObject;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductUnits;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductData;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnits;
import cn.sunline.pcm.surface.api.ParameterSurface;

/**
 * <p>
 * 参数服务，仅限于参数页面编辑参数使用
 * </p>
 * 
 * @version 1.0 2017年5月27日 linxiaocheng 修改内容:初版
 */
@Service
public class ParameterSurfaceImpl implements ParameterSurface {

//	@Autowired
//	private ParameterFetchResponseFacility parameterFetchResponseFacility;

	@Autowired
	private ParameterFactory parameterFacility;

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmProductData rPcmProductData;

	@Autowired
	private RPcmPrmObject rPcmPrmObject;

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#getParameterObject(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> T getParameterObject(String key, Class<T> clazz)  {
		return parameterFacility.getParameterObject(key, clazz);
	}

//	/*
//	 * (non-Javadoc)
//	 * @see cn.sunline.pcm.surface.api.ParameterSurface#retrieveParameterObject(java.lang.Class)
//	 */
//	@Override
//	public <T extends Serializable> Map<String, T> retrieveParameterObject(Class<T> paramClazz) {
//		return parameterFacility.retrieveParameterObject(paramClazz);
//	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#getParameterObject(java.lang.Class)
	 */
	@Override
	public <T> List<T> getParameterObject(Class<T> clazz) {
		return parameterFacility.getParameterObjects(clazz);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#updateParameterObject(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> void updateParameterObject(String key, Object obj) throws ProcessException {
		parameterFacility.updateParameterObject(key, obj);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#deleteParameterObject(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> void deleteParameterObject(String key, Class<T> clazz) throws Exception {
		//TODO 检查该参数是否关联
		
		parameterFacility.deleteParameterObject(key, clazz);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#addNewParameter(java.lang.String, java.lang.Object)
	 */
	@Override
	public void addNewParameter(String key, Object param) throws ProcessException {
		parameterFacility.addNewParameter(key, param);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.api.ParameterSurface#getFetchResponse(cn.sunline.common.shared.query.FetchRequest,
	 * java.lang.Class)
	 */
	@SuppressWarnings({"unchecked" })
	@Override
	public <T> FetchResponse<T> getFetchResponse(FetchRequest request, Class<T> clazz) {
//		return parameterFetchResponseFacility.getFetchResponse(request, clazz);
		return  parameterFacility.getFetchResponse(request,clazz);

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * cn.sunline.pcm.surface.api.ParameterSurface#getLoanFetchResponse(cn.sunline.common.shared.query.FetchRequest,
	 * java.lang.Class, java.lang.String)
	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public <T> FetchResponse<T> getLoanFetchResponse(FetchRequest request, Class<T> clazz, String loanType) {
//		return parameterFetchResponseFacility.getLoanFetchResponse(request, clazz, loanType);
//	}

	@Override
	@Transactional
	public <T> void deleteParameterObjectList(List<String> keys, Class<T> clazz) throws Exception {
		for (String key : keys) {
			this.deleteParameterObject(key, clazz);
		}
	}

	@Override
	@Transactional
	public <T> void delAllRel(List<String> keys, Class<T> clazz) throws Exception {
		QPcmProductData tmproductdata = QPcmProductData.pcmProductData;
		QPcmPrmObject qPcmPrmObject = QPcmPrmObject.pcmPrmObject;
		String org = KC.threadLocal.getCurrentOrg();
		for (String key : keys) {
			// 根据paramkey查询映射表中的数据
			Iterable<PcmProductData> findAll =
					rPcmProductData.findAll(tmproductdata.productCode.eq(key).and(tmproductdata.org.eq(org)));
			// 删除关于该产品下的obj数据 paramkey==key
			for (PcmProductData datas : findAll) {
				String paramKey = datas.getParamKey();
				if (paramKey.equals(key)) {
					Iterable<PcmPrmObject> findAll2 = rPcmPrmObject.findAll(qPcmPrmObject.paramKey.eq(paramKey)
							.and(qPcmPrmObject.org.eq(org)).and(qPcmPrmObject.paramClass.eq(datas.getParamClass())));
					rPcmPrmObject.deleteAll(findAll2);
				}
			}
			rPcmProductData.deleteAll(findAll);
			this.deleteParameterObject(key, clazz);
		}
	}

	@Override
	public List<BPcmProductGroup> getProGroup(String productType) throws ProcessException {
		JPAQuery<BPcmProductGroup> query = new JPAQuery<BPcmProductGroup>(em);
		QPcmProductGroup group = QPcmProductGroup.pcmProductGroup;
		List<PcmProductGroup> fetch = query.select(group).from(group).where(group.productType.eq(productType))
				.orderBy(group.groupIndex.asc()).fetch();
		return PcmProductGroup.convertToBOList(fetch);
	}

	@Override
	public List<Map<String, Serializable>> getProUnits(String groupCode) throws ProcessException {
		JPAQuery<BPcmProductUnits> query = new JPAQuery<BPcmProductUnits>(em);
		QPcmProductUnits units = QPcmProductUnits.pcmProductUnits;
		List<PcmProductUnits> fetch = query.select(units).from(units).where(units.groupCode.eq(groupCode))
				.orderBy(units.unitIndex.asc()).fetch();
		List<Map<String, Serializable>> listMap = new ArrayList<Map<String, Serializable>>();
		for (PcmProductUnits unit : fetch) {
			ProductUnitsURL unitModule = unit.getUnitModule();
			Map<String, Serializable> convertToMap = unit.convertToMap();
			convertToMap.put("unitDetailUrl", unitModule.getUnitDetaiUrl());
			convertToMap.put("unitConfigUrl", unitModule.getUnitConfigUrl());
			convertToMap.put("unitClass", unitModule.getUnitClass());
			convertToMap.put("unitBaseUrl", unitModule.getUnitBaseUrl());
			listMap.add(convertToMap);
		}
		return listMap;
	}
	
	@Transactional
	@Override
	public void saveProductData(List<BPcmProductData> productDatas) throws ProcessException {
		// 根据产品编号和产品类型查询映射数据
		if (productDatas.size() == 0) {
			return;
		}
		deleteData(productDatas);
		addData(productDatas);
	}
	
	private void deleteData(List<BPcmProductData> productDatas){
		String org = KC.threadLocal.getCurrentOrg();
		BPcmProductData prodData = productDatas.get(0);
		JPAQuery<PcmProductData> query = new JPAQuery<PcmProductData>(em);
		QPcmProductData qproData = QPcmProductData.pcmProductData;
		List<PcmProductData> fetch = query.select(qproData).from(qproData)
				.where(qproData.productCode.eq(prodData.getProductCode()).and(qproData.org.eq(org))).fetch();
		rPcmProductData.deleteInBatch(fetch);
	}
	private  void  addData(List<BPcmProductData> productDatas){
		String org = KC.threadLocal.getCurrentOrg();
		String userId = KC.threadLocal.getUserId();
		for (BPcmProductData bPcmProductData : productDatas) {
			PcmProductData proData = new PcmProductData();
			proData.setOrg(org);
			proData.setCreateTime(new Date());
			proData.setCreateUser(userId);
			proData.setLstUpdTime(new Date());
			proData.setLstUpdUser(userId);
			proData.updateValueFromBO(bPcmProductData);
			rPcmProductData.save(proData);
		}
		
	}
	@Override
	public List<BPcmProductData> loadProductDatas(String productCode, String productType) throws ProcessException {
		String org = KC.threadLocal.getCurrentOrg();
		JPAQuery<PcmProductData> query = new JPAQuery<PcmProductData>(em);
		QPcmProductData qproData = QPcmProductData.pcmProductData;
		List<PcmProductData> fetch = query.select(qproData).from(qproData)
				.where(qproData.productCode.eq(productCode).and(qproData.org.eq(org))).fetch();
		return PcmProductData.convertToBOList(fetch);
	}

	@Override
	public List<BPcmProductData> loadMappings(String paramKey, String paramClass, String productCode)
			throws ProcessException {
		String org = KC.threadLocal.getCurrentOrg();
		JPAQuery<PcmProductData> query = new JPAQuery<PcmProductData>(em);
		QPcmProductData qproData = QPcmProductData.pcmProductData;
		query.select(qproData).from(qproData).where(qproData.paramClass.eq(paramClass).and(qproData.org.eq(org)));
		query.where(qproData.paramKey.eq(paramKey));
		if (KC.string.isNotBlank(productCode)) {
			query.where(qproData.productCode.ne(productCode));
		}
		List<PcmProductData> fetch = query.fetch();
		return PcmProductData.convertToBOList(fetch);
	}


}
