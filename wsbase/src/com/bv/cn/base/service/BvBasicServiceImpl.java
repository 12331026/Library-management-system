package com.bv.cn.base.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.dao.BvBaseHibernateDAO;
import com.bv.cn.base.security.model.LogonVO;

@Transactional
public class BvBasicServiceImpl<T> implements BvBasicService<T> {
	protected Log logger = LogFactory.getLog(getClass());
	private BvBaseHibernateDAO<T> baseHibernateDAO;

	public BvBasicServiceImpl() {
	}

	public Pagelet findEntity(int pageIndex, int pageSize, LogonVO logon,
			Map filterPropertyMap, Object[] values) {
		return this.baseHibernateDAO.findEntity(pageIndex, pageSize, logon,
				filterPropertyMap, values);
	}

	public T getEntityById(String id) {
		return this.baseHibernateDAO._getEntityById(id);
	}

	public void delete(T o) {
		this.baseHibernateDAO._delete(o);
	}

	public void delEntitys(String[] ids) {
		if ((ids != null) && (ids.length > 0))
			for (int i = 0; i < ids.length; ++i)
				this.baseHibernateDAO._deleteById(ids[i]);
	}

	public T saveEntity(T o) {
		this.baseHibernateDAO._save(o);
		return o;
	}

	public T updateEntity(T o) {
		this.baseHibernateDAO._update(o);
		return o;
	}
	@Transactional
	public T mergeEntity(T o) {
		this.baseHibernateDAO._merge(o);
		return o;
	}

	public void setBaseHibernateDAO(BvBaseHibernateDAO<T> baseHibernateDAO) {
		this.baseHibernateDAO = baseHibernateDAO;
	}
}
