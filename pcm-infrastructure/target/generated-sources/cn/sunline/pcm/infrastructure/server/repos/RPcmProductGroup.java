package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmProductGroup extends JpaRepository<PcmProductGroup, String>, QuerydslPredicateExecutor<PcmProductGroup> {
	
	public PcmProductGroup findByOrgAndGroupCode(String org, String groupCode);
}