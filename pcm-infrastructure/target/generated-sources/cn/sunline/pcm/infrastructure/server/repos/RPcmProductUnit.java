package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnit;
import cn.sunline.ppy.dictionary.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmProductUnit extends JpaRepository<PcmProductUnit, String>, QuerydslPredicateExecutor<PcmProductUnit> {
	
	public PcmProductUnit findByOrgAndProductTypeAndUnitCode(String org, ProductType productType, String unitCode);
}