package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmPrmObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmPrmObject extends JpaRepository<PcmPrmObject, String>, QuerydslPredicateExecutor<PcmPrmObject> {
	
	public PcmPrmObject findByOrgAndParamClassAndParamKey(String org, String paramClass, String paramKey);
}