package cn.sunline.pcm.surface.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductGroup;
import cn.sunline.pcm.surface.ProductGroupSurface;
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;

/** 
 * <p>
 * 产品页面分组表 Surface 实现类
 * </p>
 * @version 1.0 2017-12-05 修改内容:初版
 */
@Service
public class ProductGroupSurfaceImpl implements ProductGroupSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmProductGroup rPcmProductGroup;
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#queryProductGroupList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	public FetchResponse<?> queryProductGroupList(FetchRequest request) throws Exception {
		QPcmProductGroup qPcmProductGroup = QPcmProductGroup.pcmProductGroup;
		JPAQuery<PcmProductGroup> query = new JPAQueryFactory(em).select(qPcmProductGroup).from(qPcmProductGroup);
		query.where(qPcmProductGroup.org.eq(KC.threadLocal.getCurrentOrg()));
		return new JPAQueryFetchResponseBuilder(request, query).addFieldMapping(qPcmProductGroup).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#findAllProductGroup()
	 */
	@Override
	public List<BPcmProductGroup> findAllProductGroup() throws Exception {
		QPcmProductGroup qPcmProductGroup = QPcmProductGroup.pcmProductGroup;
		return PcmProductGroup.convertToBOList(rPcmProductGroup.findAll(qPcmProductGroup.org.eq(KC.threadLocal.getCurrentOrg())));
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#findProductGroupById(String id)
	 */
	@Override
	public BPcmProductGroup findProductGroupById(String id) throws Exception {
		PcmProductGroup tmProductGroup = rPcmProductGroup.findOne(
				QPcmProductGroup.pcmProductGroup.id.eq(id)).orElse(null);
		return tmProductGroup == null ? null : tmProductGroup.toBO();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#addProductGroup(cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup)
	 */
	@Override
	public void addProductGroup(BPcmProductGroup bPcmProductGroup) throws Exception {
		PcmProductGroup groupD =
				rPcmProductGroup.findByOrgAndGroupCode(KC.threadLocal.getCurrentOrg(), bPcmProductGroup.getGroupCode());
		if (groupD != null) {
			throw new ProcessException("productUnits.group.notexist", "该分组编码已经存在");
		}
		PcmProductGroup tmProductGroup = new PcmProductGroup();
		tmProductGroup.updateValueFromBO(bPcmProductGroup);
		tmProductGroup.setCreateTime(new Date());
		tmProductGroup.setCreateUser(KC.threadLocal.getUserId());
//		tmProductGroup.setGroupCode(UUID.randomUUID().toString().replaceAll("-", ""));
		tmProductGroup.setOrg(KC.threadLocal.getCurrentOrg());
		rPcmProductGroup.save(tmProductGroup );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#updProductGroup(cn.sunline.pcm.infrastructure.model.bo.BPcmProductGroup)
	 */
	@Override
	@Transactional
	public void updProductGroup(BPcmProductGroup bPcmProductGroup) throws Exception {
		PcmProductGroup tmProductGroup = rPcmProductGroup.findById(bPcmProductGroup.getId()).orElseThrow(new ProcessException("kite.web.common.notexist", "该数据不存在[{0}]"));
		tmProductGroup.updateValueFromBO(bPcmProductGroup);
		tmProductGroup.setLstUpdTime(new Date());
		tmProductGroup.setLstUpdUser(KC.threadLocal.getUserId());
		rPcmProductGroup.save(tmProductGroup );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.ProductGroupSurface#delProductGroupByIds(List<String> ids)
	 */
	@Override
	@Transactional
	public void delProductGroupById(String id) throws Exception {
		
		 rPcmProductGroup.deleteById(id);
	}

	@Override
	public List<BPcmProductGroup> findProductUnitsByType(String id) {
		QPcmProductGroup qPcmProductGroup = QPcmProductGroup.pcmProductGroup;
		JPAQuery<PcmProductGroup> query = new JPAQueryFactory(em).select(qPcmProductGroup).from(qPcmProductGroup);
		query.where(qPcmProductGroup.org.eq(KC.threadLocal.getCurrentOrg()));
		List<PcmProductGroup> list=query.where(qPcmProductGroup.productType.equalsIgnoreCase(id)).fetch();
		return PcmProductGroup.convertToBOList(list);
	}
	@Override
	public BPcmProductGroup findProductGroupByGroupCode(String groupCode){
		PcmProductGroup group = rPcmProductGroup.findByOrgAndGroupCode(KC.threadLocal.getCurrentOrg(), groupCode);
		return group.toBO();
	}
}
