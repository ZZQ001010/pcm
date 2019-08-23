package cn.sunline.pcm.surface.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.StringUtils;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmAudit;
import cn.sunline.pcm.infrastructure.server.repos.RPcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmAudit;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmAudit;
import cn.sunline.pcm.surface.PrmAuditSurface;
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;

/** 
 * <p>
 * 参数变更日志 Surface 实现类
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */
@Service
public class PrmAuditSurfaceImpl implements PrmAuditSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmPrmAudit rPcmPrmAudit;
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmAuditSurface#queryPrmAuditList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	public FetchResponse<?> queryPrmAuditList(FetchRequest request) throws Exception {
		String className=KC.string.isBlank(request.getParameter(PcmPrmAudit.P_PARAM_CLASS)) ? null : request.getParameter(PcmPrmAudit.P_PARAM_CLASS);
		
		Date beginDate = null;
		Date endDate = null;
		String tmp = null;
		if (KC.string.isNotBlank(request.getParameter(PcmPrmAudit.P_JPA_TIMESTAMP))) {
			tmp = request.getParameter(PcmPrmAudit.P_JPA_TIMESTAMP);
			if (StringUtils.isNotBlank(tmp)) {
				String[] dates = tmp.split(",");
				if(KC.string.isNotBlank(dates[0])){
					beginDate = KC.date.parse(dates[0], KC.datetimePattern.DATE_LINE);
				}
				if(KC.string.isNotBlank(dates[1])){
					endDate = KC.date.addDays(KC.date.getDateForZeroTime(KC.date.parse(dates[1], KC.datetimePattern.DATE_LINE)), 1);
				}
			}
		}
		
		String mtnUser=KC.string.isBlank(request.getParameter(PcmPrmAudit.P_MTN_USER)) ? null : request.getParameter(PcmPrmAudit.P_MTN_USER);
		String paramKey=KC.string.isBlank(request.getParameter(PcmPrmAudit.P_PARAM_KEY)) ? null : request.getParameter(PcmPrmAudit.P_PARAM_KEY);
		ParamOperationDef paramOperation=KC.string.isBlank(request.getParameter(PcmPrmAudit.P_PARAM_OPERATION)) ? null : ParamOperationDef.valueOf(request.getParameter("paramOperation"));

		QPcmPrmAudit q = QPcmPrmAudit.pcmPrmAudit;
		JPAQuery<PcmPrmAudit> query = new JPAQueryFactory(em).select(q).from(q).where(q.org.eq(KC.threadLocal.getCurrentOrg()));
		//KylinWeb Page存在不修改也会保存到日志的问题
		query = query.where(q.paramOperation.eq(ParamOperationDef.DELETE)
				.or(q.paramOperation.eq(ParamOperationDef.INSERT))
				.or(q.paramOperation.eq(ParamOperationDef.UPDATE).and(q.updateLog.isNotNull())));
		if (className!=null) {
			query = query.where(q.paramClass.like("%"+className+"%"));
		}
		
		if (beginDate != null) {
			query = query.where(q.jpaTimestamp.goe(beginDate));
		}
		if (endDate != null) {
			query = query.where(q.jpaTimestamp.lt(endDate));
		}

		if (mtnUser!=null) {
			query = query.where(q.mtnUser.eq(mtnUser));
		}
		
		if (paramKey !=null) {
			query = query.where(q.paramKey.eq(paramKey));
		}
		
		if (paramOperation != null) {
			query = query.where(q.paramOperation.eq(paramOperation));
		}
		
		if(request.getSortname()==null){
			query=query.orderBy(q.jpaTimestamp.desc());
		}
		return new JPAQueryFetchResponseBuilder(request, query).addFieldMapping(q).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmAuditSurface#findPrmAuditById(BigDecimal id)
	 */
	@Override
	public BPcmPrmAudit findPrmAuditById(String id) throws Exception {
		PcmPrmAudit tmPrmAudit = rPcmPrmAudit.findById(id).orElse(null);
		return tmPrmAudit == null ? null : tmPrmAudit.toBO();
	}
	
}
