package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmProductData extends JpaRepository<PcmProductData, String>, QuerydslPredicateExecutor<PcmProductData> {
	
	public PcmProductData findByOrgAndProductCodeAndParamClassAndParamKey(String org, String productCode, String paramClass, String paramKey);
	
	public PcmProductData findByOrgAndUnitCodeAndProductCode(String org, String unitCode, String productCode);
}