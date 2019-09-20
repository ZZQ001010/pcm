package cn.sunline.pcm.surface.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.sunline.common.KC;
import cn.sunline.common.KC.string;
import cn.sunline.common.KC.threadLocal;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.web.core.query.JPAQueryFetchResponseBuilder;
import scala.annotation.meta.param;
import cn.sunline.pcm.infrastructure.model.bo.BPcmParameterOrder;
import cn.sunline.pcm.infrastructure.server.repos.RPcmParameterOrder;
import cn.sunline.pcm.infrastructure.shared.model.PcmParameterOrder;
import cn.sunline.pcm.infrastructure.shared.model.QPcmParameterOrder;
import cn.sunline.pcm.surface.PcmParameterOrderSurface;

/** 
 * <p>
 * 参数展示字段自定义排序 Surface 实现类
 * </p>
 * @version 1.0 2019-09-17 修改内容:初版
 */
@Service
public class PcmParameterOrderSurfaceImpl implements PcmParameterOrderSurface {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext(unitName = "default")
	private EntityManager em;

	@Autowired
	private RPcmParameterOrder rPcmParameterOrder;
	
	
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#queryPcmParameterOrderList(cn.sunline.common.shared.query.FetchRequest)
	 */
	@Override
	public FetchResponse<?> queryPcmParameterOrderList(FetchRequest request) throws Exception {
		QPcmParameterOrder qPcmParameterOrder = QPcmParameterOrder.pcmParameterOrder;
		JPAQuery<String> query = new JPAQueryFactory(em).select(qPcmParameterOrder.paramClass).from(qPcmParameterOrder);
		query.where(qPcmParameterOrder.orgCode.eq(KC.threadLocal.getCurrentOrg()));
		if (KC.string.isNotEmpty(request.getParameter(PcmParameterOrder.P_PARAM_CLASS))) {
			String paramClass = URLDecoder.decode(request.getParameter(PcmParameterOrder.P_PARAM_CLASS),"UTF-8");
			query.where(qPcmParameterOrder.paramClass.like("%" + paramClass + "%"));
		}
		
		query.groupBy(qPcmParameterOrder.paramClass);
		return new JPAQueryFetchResponseBuilder(request, query).addFieldMapping(PcmParameterOrder.P_PARAM_CLASS,qPcmParameterOrder.paramClass).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#findAllPcmParameterOrder()
	 */
	@Override
	public List<BPcmParameterOrder> findAllPcmParameterOrder() throws Exception {
		return PcmParameterOrder.convertToBOList(rPcmParameterOrder.findAll());
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#findPcmParameterOrderById(String id)
	 */
	@Override
	public BPcmParameterOrder findPcmParameterOrderById(String id) throws Exception {
		PcmParameterOrder pcmParameterOrder = rPcmParameterOrder.findById(id).orElse(null);
		return pcmParameterOrder == null ? null : pcmParameterOrder.toBO();
	}
	
	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#addPcmParameterOrder(cn.sunline.pcm.infrastructure.model.bo.BPcmParameterOrder)
	 */
	@Override
	public void addPcmParameterOrder(BPcmParameterOrder bPcmParameterOrder) throws Exception {
		PcmParameterOrder pcmParameterOrder = new PcmParameterOrder();
		pcmParameterOrder.updateValueFromBO(bPcmParameterOrder);
		rPcmParameterOrder.save(pcmParameterOrder );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#updPcmParameterOrder(cn.sunline.pcm.infrastructure.model.bo.BPcmParameterOrder)
	 */
	@Override
	@Transactional
	public void updPcmParameterOrder(BPcmParameterOrder bPcmParameterOrder) throws Exception {
		PcmParameterOrder pcmParameterOrder = rPcmParameterOrder.findById(bPcmParameterOrder.getId()).orElse(null);
		if (pcmParameterOrder == null) {
			throw new ProcessException("kite.web.common.notexist", "该数据存在[{0}]");
		}
		pcmParameterOrder.updateValueFromBO(bPcmParameterOrder);
		rPcmParameterOrder.save(pcmParameterOrder );
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.pcm.surface.PcmParameterOrderSurface#delPcmParameterOrderByIds(List<String> ids)
	 */
	@Override
	@Transactional
	public void delPcmParameterOrderByIds(List<String> ids) throws Exception {
		for (String id : ids) {
			rPcmParameterOrder.deleteById(id);
		}
	}

	/**
	 * key  filedName 
	 * value paramClass 
	 */
	@Override
	public List<BPcmParameterOrder> findPcmParameterOrderByParamClass(String paramClass) {
		QPcmParameterOrder pcmparameterorder = QPcmParameterOrder.pcmParameterOrder;
		List<Tuple> list = new JPAQueryFactory(em)
		.select(pcmparameterorder.paramClass,pcmparameterorder.filedName)
		.from(pcmparameterorder)
		.where(pcmparameterorder.orgCode.eq(KC.threadLocal.getCurrentOrg())
				.and(pcmparameterorder.paramClass.eq(paramClass))
				).fetch();
		 List<BPcmParameterOrder> bPcmParameterOrders = new ArrayList<BPcmParameterOrder>(); 
		for (Tuple tuple : list) {
			BPcmParameterOrder bPcmParameterOrder = new BPcmParameterOrder();
			bPcmParameterOrder.setFiledName(tuple.get(pcmparameterorder.filedName));
			bPcmParameterOrder.setParamClass(tuple.get(pcmparameterorder.paramClass));
			bPcmParameterOrders.add(bPcmParameterOrder);
		}
		return bPcmParameterOrders;
	}

	/**
	 * 更新
	 */
	@Transactional
	@Override 
	public void updPcmParameterOrders(List<BPcmParameterOrder> bPcmParameterOrder) throws Exception {
		QPcmParameterOrder pcmParameterOrder = QPcmParameterOrder.pcmParameterOrder;
		String paramClass = bPcmParameterOrder.get(0).getParamClass();
		new JPAQueryFactory(em).delete(pcmParameterOrder).where(pcmParameterOrder.paramClass.eq(paramClass)).execute();
		
		Integer counter  = 0 ; 
		for (BPcmParameterOrder bPcmParameterOrder2 : bPcmParameterOrder) {
			bPcmParameterOrder2.setOrderIndex(counter.toString());
			bPcmParameterOrder2.setOrgCode(KC.threadLocal.getCurrentOrg());
			addPcmParameterOrder(bPcmParameterOrder2);
			counter++;
		}
		
	}

	@Transactional
	@Override
	public void delPcmParameterOrderByParamClasses(List<String> paramClesses) {
		QPcmParameterOrder pcmParameterOrder = QPcmParameterOrder.pcmParameterOrder;
		// TODO Auto-generated method stub
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
		for (String paramClass : paramClesses) {
				jpaQueryFactory.delete(pcmParameterOrder).where(pcmParameterOrder.paramClass.eq(paramClass)).execute();
		}
	}

	
	
 
}
