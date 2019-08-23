package cn.sunline.pcm.surface.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.KC.Null;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductUnit;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductRel;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductUnit;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductRel;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnit;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductRel;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductUnit;
import cn.sunline.pcm.surface.ProductUnitSurface;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.pcm.surface.model.VPcmProductRel;
import cn.sunline.pcm.surface.model.VProductCombination;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;
import scala.annotation.meta.param;
import vo.VProductUnitTree;

/**
 * <p>
 * 产品页面组件表 Surface 实现类
 * </p>
 * 
 * @version 1.0 2017-12-05 修改内容:初版
 * @author zzq
 */
@Service
public class ProductUnitSurfaceImpl implements ProductUnitSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private ParameterSurface parameterSurface;

	@Autowired
	private RPcmProductRel rPcmProductRel;

	@Autowired
	private RPcmProductUnit rPcmProductUnit;

	private QPcmProductUnit qPcmProductUnit = QPcmProductUnit.pcmProductUnit;
	
	private QPcmProductRel qPcmProductRel = QPcmProductRel.pcmProductRel;

	/*
	 * (non-Javadoc)
	 * @see
	 * cn.sunline.pcm.surface.ProductUnitsSurface#queryProductUnitsList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	
//		String groupCode = request.getParameter(BPcmProductGroup.P_GROUP_CODE);
//		 PcmProductUnit pcmProductUnit = new JPAQueryFactory(em).selectFrom(qPcmProductUnit)
//				.where(qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg())
//						.and(qPcmProductUnit.productUnitGroup.eq(groupCode))).fetchOne();
//		//获取当前组件
//		VProductUnitTree vProductUnitTree = new VProductUnitTree();
//		vProductUnitTree.setId(pcmProductUnit.getId());
//		vProductUnitTree.setUnitName(pcmProductUnit.getUnitName());
//		vProductUnitTree.setUnitNameCn(pcmProductUnit.getUnitNameCn());
//		//获取所有的关联节点进行封装
//		List<PcmProductUnit> childlist = getChild(groupCode);
//		
//		List<VProductUnitTree> vs = childlist.stream().map(x->{
//			VProductUnitTree v = new VProductUnitTree();
//			v.setId(x.getId());
//			v.setUnitName(x.getUnitName());
//			v.setUnitNameCn(x.getUnitNameCn());
//			//解析xml
//			List<PcmProductUnit> relations = parseChildNodeJson2Object(x.getUnitRelations());
//			relations.stream().map(y->{
//				VProductUnitTree relationsV = new VProductUnitTree();
//				relationsV.setId(y.getId());
//				relationsV.setUnitName(y.getUnitName());
//				relationsV.setUnitNameCn(y.getUnitNameCn());
//  				return null;
//			}).collect(Collectors.toList());
//			return v ; 
//		}).collect(Collectors.toList());
//		
		
		
//		vProductUnitTree.setvProductUnitTrees(vs);	
	public List<BPcmProductUnit> queryProductUnitList(String groupCode,String productType) throws Exception {
		JPAQuery<PcmProductUnit> query = new JPAQueryFactory(em).selectFrom(qPcmProductUnit)
				.where(qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg()));
		//如果 有组件分类就按照组件的分类查询，如果没有组件的分类就按照组件的类型查询
		if (StringUtils.isNotBlank(groupCode)) {
			query.where(qPcmProductUnit.productUnitGroup.eq(groupCode).or(qPcmProductUnit.productType.eq(ProductType.valueOf(productType))));
		}
		
		List<PcmProductUnit> units = query.fetch();
		return PcmProductUnit.convertToBOList(units);
	}
	
	
	
	/**
	 *把子节点从json 字符串中解析出来 
	 */
	private List<PcmProductUnit> parseChildNodeJson2Object(String json) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		return  objectMapper.readValue(json,new TypeReference<List<PcmProductUnit>>() {});
	}
	
	/**
	 * 获取子节点
	 * @return
	 */
	private List<PcmProductUnit> getChild(String groupCode){
		if (StringUtils.isBlank(groupCode)) 
			return null ; 
		return new JPAQueryFactory(em).selectFrom(qPcmProductUnit)
				.where(qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg())
						.and(qPcmProductUnit.productUnitGroup.eq(groupCode))
				).fetch();
		
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#findProductUnitsById(String id)
	 */
	@Override
	public BPcmProductUnit findProductUnitById(String id) throws Exception {
		PcmProductUnit unit = rPcmProductUnit.findById(id).orElse(null);
		return null == unit ? null : unit.toBO();
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#addProductUnits(cn.sunline.pcm.infrastructure.model.bo.
	 * BPcmProductUnits)
	 */
	@Override
	@Transactional
	public void addProductUnit(BPcmProductUnit bPcmProductUnit) throws Exception {
		PcmProductUnit bUnit = rPcmProductUnit.findByOrgAndProductTypeAndUnitCode(	KC.threadLocal.getCurrentOrg(),
																					bPcmProductUnit.getProductType(),
																					bPcmProductUnit.getUnitCode());
		if (null != bUnit) {
			throw new ProcessException("productUnits.productUnit.exit", "该产品组件已经存在");
		}
		PcmProductUnit unit = new PcmProductUnit();
		unit.updateValueFromBO(bPcmProductUnit);
		unit.setOrg(KC.threadLocal.getCurrentOrg());
		unit.setCreateUser(KC.threadLocal.getUserId());
		unit.setCreateTime(new Date());
		unit.setLstUpdUser(KC.threadLocal.getUserId());
		unit.setLstUpdTime(new Date());
		rPcmProductUnit.save(unit);
	}
	
	/**
	 * 保存所有的组件 ,及组件的关联
	 * @param bPcmProductUnits 组件列表
	 * @throws Exception
	 */
	@Transactional
	public void addAllProductUnits(List<BPcmProductUnit> bPcmProductUnits) throws Exception{
		  new JPAQueryFactory(em).delete(qPcmProductUnit).where(qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg())
				  .and(qPcmProductUnit.productUnitGroup.eq(bPcmProductUnits.get(0).getProductUnitGroup()))).execute();
		 bPcmProductUnits.forEach(bo->{
			 rPcmProductUnit.save(new PcmProductUnit().updateValueFromBO(bo));
		});
		
	}
	
	
	
	

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#updProductUnits(cn.sunline.pcm.infrastructure.model.bo.
	 * BPcmProductUnits)
	 */
	@Override
	@Transactional
	public void updProductUnit(BPcmProductUnit bPcmProductUnit) throws Exception {
		PcmProductUnit unit = rPcmProductUnit.findById(bPcmProductUnit.getId()).orElse(null);
		if (null == unit) {
			throw new ProcessException("kite.web.common.notexist", "该数据不存在[{0}]");
		}
		unit.updateValueFromBO(bPcmProductUnit);
		unit.setLstUpdTime(new Date());
		unit.setLstUpdUser(KC.threadLocal.getUserId());
		rPcmProductUnit.save(unit);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitsSurface#delProductUnitsByIds(List<String> ids)
	 */
	@Override
	@Transactional
	public void delProductUnitByIds(List<String> ids) throws Exception {
		for (String id : ids) {
			rPcmProductUnit.deleteById(id);
		}
	}


	/* (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitSurface#addProductAssemble(cn.sunline.pcm.surface.model.VProductCombination)
	 */
	@Override
	@Transactional
	public String productAssemble(VProductCombination vpc, boolean isUpdate) throws Exception {
		if (isUpdate) {
			// 先删除现有的关联数据
			new JPAQueryFactory(em)
					.delete(qPcmProductRel).where(	qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()),
													qPcmProductRel.productCode.eq(vpc.getProduct().getProductCode()))
					.execute();
			
			// 保存产品
			parameterSurface.updateParameterObject(vpc.getProduct().getProductCode(), vpc.getProduct());
		}else{
			parameterSurface.addNewParameter(vpc.getProduct().getProductCode(), vpc.getProduct());
		}
		// 保存新的关联数据
		if (null != vpc.getProductRels() && !vpc.getProductRels().isEmpty()) {
			for (int i = 0; i < vpc.getProductRels().size(); i++) {
				// 保存当前
				BPcmProductRel bRel = vpc.getProductRels().get(i);
				PcmProductRel rel = new PcmProductRel(bRel);
				rel.setId(null);
				rel.setCreateTime(new Date());
				rel.setCreateUser(KC.threadLocal.getUserId());
				rel.setLstUpdTime(new Date());
				rel.setLstUpdUser(KC.threadLocal.getUserId());
				rel.setOrg(KC.threadLocal.getCurrentOrg());
				rPcmProductRel.save(rel);
				// 排除当前，减少遍历次数
				vpc.getProductRels().remove(i);
				i--;
				// 遍历更正parentId
				for (BPcmProductRel bRela : vpc.getProductRels()) {
					if (bRel.getId().equals(bRela.getParentId())) {
						bRela.setParentId(rel.getId());
					}
				}
			}
		}
		return vpc.getProduct().getProductCode();
	}

	/* (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitSurface#productShow(java.lang.String)
	 */
	@Override
	public List<BPcmProductRel> queryProductRel(String productCode) throws Exception {
		List<PcmProductRel> rels =
				new JPAQueryFactory(em)
						.selectFrom(qPcmProductRel).where(	qPcmProductRel.productCode.eq(productCode),
															qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()))
						.fetch();
		return null == rels ? new ArrayList<BPcmProductRel>() : PcmProductRel.convertToBOList(rels);
	}

	/* (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductUnitSurface#buildProductRel(java.lang.String)
	 */
	@Override
	public Map<String, List<VPcmProductRel>> buildProductRel(String productCode) throws Exception {
		Map<String, List<VPcmProductRel>> relsMap = new LinkedHashMap<String, List<VPcmProductRel>>();
		List<BPcmProductRel> list = this.queryProductRel(productCode);
		if (list.isEmpty()) {
			return relsMap;
		}
		List<VPcmProductRel> rels = new ArrayList<VPcmProductRel>();
		// 转换
		for (BPcmProductRel rel : list) {
			rels.add(new VPcmProductRel(rel));
		}
		// 组装
		for (VPcmProductRel rel : rels) {
			if (null == rel.getParentId() || null == rel.getParentParamClass() || null == rel.getParentParamKey()) {
				continue;
			}
			for (VPcmProductRel re : rels) {
				if (rel.getParentId().equals(re.getId()) && rel.getParentParamClass().equals(re.getParamClass())
						&& rel.getParentParamKey().equals(re.getParamKey())) {
					re.getChildren().add(rel);
					break;
				}
			}
		}
		// 排除
		for (int i = 0; i < rels.size(); i++) {
			if (KC.string.isNotBlank(	rels.get(i).getParentId(), rels.get(i).getParentParamKey(),
										rels.get(i).getParentParamClass())) {
				rels.remove(i);
				i--;
			}
		}
		// 返回map的构造
		for (VPcmProductRel rel : rels) {
			if (!relsMap.containsKey(rel.getUnitCode())) {
				List<VPcmProductRel> temp = new ArrayList<VPcmProductRel>();
				temp.add(rel);
				relsMap.put(rel.getUnitCode(), temp);
			} else {
				relsMap.get(rel.getUnitCode()).add(rel);
			}
		}
		return relsMap;
	}



	/**
	 * 通过产品组件类型查询
	 */
	@Override
	public List<BPcmProductUnit> findProductUnitByGroupType(String groupCode) throws Exception {
		List<PcmProductUnit> units = new JPAQueryFactory(em).selectFrom(qPcmProductUnit)
				.where(	qPcmProductUnit.productUnitGroup.eq(groupCode),
						qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg()))
				.orderBy(qPcmProductUnit.unitIndex.asc()).fetch();
		return null == units ? new ArrayList<BPcmProductUnit>() : PcmProductUnit.convertToBOList(units);
	}


	@Transactional
	@Override
	public void deleteAllByGroupId(String value) {
		// TODO Auto-generated method stub
		  new JPAQueryFactory(em).delete(qPcmProductUnit).where(qPcmProductUnit.org.eq(KC.threadLocal.getCurrentOrg())
				  .and(qPcmProductUnit.productUnitGroup.eq(value))).execute();
	}

}
