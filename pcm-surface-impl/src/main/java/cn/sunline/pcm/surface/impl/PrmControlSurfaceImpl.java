package cn.sunline.pcm.surface.impl;

import java.net.URLDecoder;
import java.util.List;

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
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl;
import cn.sunline.pcm.infrastructure.server.repos.RPcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.PcmPrmControl;
import cn.sunline.pcm.infrastructure.shared.model.QPcmPrmControl;
import cn.sunline.pcm.surface.PrmControlSurface;

/** 
 * <p>
 * 参数管控 Surface 实现类
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */
@Service
public class PrmControlSurfaceImpl implements PrmControlSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmPrmControl rPcmPrmControl;
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#queryPrmControlList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	public FetchResponse<?> queryPrmControlList(FetchRequest request) throws Exception {
		QPcmPrmControl qPcmPrmControl = QPcmPrmControl.pcmPrmControl;
		JPAQuery<PcmPrmControl> query = new JPAQueryFactory(em).select(qPcmPrmControl).from(qPcmPrmControl);
		if (KC.string.isNotEmpty(request.getParameter(PcmPrmControl.P_PARAM_CLASS_LABEL))) {
			String paramClassLabel = URLDecoder.decode(request.getParameter(PcmPrmControl.P_PARAM_CLASS_LABEL),"UTF-8");
			query.where(qPcmPrmControl.paramClassLabel.like("%" + paramClassLabel + "%"));
		}
		return new JPAQueryFetchResponseBuilder(request, query).addFieldMapping(qPcmPrmControl).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#findAllPrmControl()
	 */
	@Override
	public List<BPcmPrmControl> findAllPrmControl() throws Exception {
		return PcmPrmControl.convertToBOList(rPcmPrmControl.findAll());
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#findPrmControlById(Long id)
	 */
	@Override
	public BPcmPrmControl findPrmControlById(String id) throws Exception {
		PcmPrmControl tmPrmControl = rPcmPrmControl.findById(id).orElse(null);
		return tmPrmControl == null ? null : tmPrmControl.toBO();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#addPrmControl(cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl)
	 */
	@Override
	public void addPrmControl(BPcmPrmControl bPcmPrmControl) throws Exception {
		PcmPrmControl tmPrmControl = new PcmPrmControl();
		tmPrmControl.updateValueFromBO(bPcmPrmControl);
		rPcmPrmControl.save(tmPrmControl );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#updPrmControl(cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl)
	 */
	@Override
	@Transactional
	public void updPrmControl(BPcmPrmControl bPcmPrmControl) throws Exception {
		PcmPrmControl tmPrmControl = rPcmPrmControl.findById(bPcmPrmControl.getPid()).orElseThrow(new ProcessException("kite.web.common.notexist", "该数据不存在[{0}]"));
		tmPrmControl.updateValueFromBO(bPcmPrmControl);
		rPcmPrmControl.save(tmPrmControl );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PrmControlSurface#delPrmControlByIds(List<Long> ids)
	 */
	@Override
	@Transactional
	public void delPrmControlByIds(List<String> ids) throws Exception {
		for (String id : ids) {
			rPcmPrmControl.deleteById(id);
		}
	}
}
