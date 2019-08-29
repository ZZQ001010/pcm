package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmProductUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmProductUnits extends JpaRepository<PcmProductUnits, String>, QuerydslPredicateExecutor<PcmProductUnits> {
	
	public PcmProductUnits findByUnitCodeAndOrg(String unitCode, String org);
}