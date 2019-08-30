package cn.sunline.pcm.infrastructure.server.repos;

import cn.sunline.pcm.infrastructure.shared.model.PcmOrgParametter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author kite-maven-plugin
 */
public interface RPcmOrgParametter extends JpaRepository<PcmOrgParametter, String>, QuerydslPredicateExecutor<PcmOrgParametter> {
}