package cn.sunline.pcm.surface.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;
import cn.sunline.pcm.infrastructure.server.repos.RPcmProductRel;
import cn.sunline.pcm.infrastructure.shared.model.PcmProductRel;
import cn.sunline.pcm.infrastructure.shared.model.QPcmProductRel;
import cn.sunline.pcm.surface.ProductCURDSurface;

@org.springframework.transaction.annotation.Transactional
@Service
public class ProductCURDSurfaceImpl implements ProductCURDSurface {

	@Autowired
	EntityManager em; 
	QPcmProductRel qPcmProductRel = QPcmProductRel.pcmProductRel ; 
	@Autowired
	RPcmProductRel rPcmProductRel;
	
	
	@Override
	public void delNode(String productCode, String unitParamKey,String  parentId) {
		new JPAQueryFactory(em)
		.delete(qPcmProductRel).where(	qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()),
										qPcmProductRel.productCode.eq(productCode)
										.and(qPcmProductRel.paramKey.eq(unitParamKey)).and(qPcmProductRel.parentId.eq(parentId)))
		.execute();
	}

	@Override
	public void updNode(String id,String paramKey) {
		 new JPAQueryFactory(em).update(qPcmProductRel)
		.set(qPcmProductRel.paramKey, paramKey)
		.where(qPcmProductRel.org.eq(KC.threadLocal.getCurrentOrg()).and(qPcmProductRel.id.eq(id))).execute();
	}

	@Override
	public String  addNode(BPcmProductRel pcmProductRel) {
		// TODO Auto-generated method stub
		PcmProductRel save = rPcmProductRel.save(new PcmProductRel(pcmProductRel));
		return save.getId().toString();
	}

	
}
