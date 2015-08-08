package com.bv.cn.base.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.security.model.LogonVO;

public class BvBaseHibernateDAOImpl<T> extends HibernateDaoSupport implements
		BvBaseHibernateDAO<T> {
	protected Log logger = LogFactory.getLog(getClass());
	protected Class<T> entityClass;

	public Long _count() throws DataAccessException {
		String hql = "select count(*) from " + this.entityClass.getName();
		this.logger.info("count([ " + this.entityClass.getName() + " ])");
		return ((Long) getHibernateTemplate().find(hql).iterator().next());
	}

	public Long _count(String queryString) throws DataAccessException {
		this.logger.info("count([ " + this.entityClass.getName() + " ])");
		return ((Long) getHibernateTemplate().find(queryString).iterator()
				.next());
	}

	public void _delete(T persistentObject) throws DataAccessException {
		this.logger.info("delete([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().delete(persistentObject);
	}

	public void _delete(T persistentObject, LockMode lockMode)
			throws DataAccessException {
		this.logger.info("delete([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().delete(persistentObject, lockMode);
	}

	public void _deleteAll(Collection<T> entities) throws DataAccessException {
		this.logger.info("deleteAll([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().deleteAll(entities);
	}

	public void _deleteById(Serializable id) {
		_delete(_getEntityById(id));
	}

	public int _executeHql(String hql) {
		this.logger.info("executeHql([ " + hql + " ])");
		Session session = getSession();
		Query query = session.createQuery(hql);
		int iCount = query.executeUpdate();
		releaseSession(session);
		return iCount;
	}

	public List<?> _find(String queryString, Object value)
			throws DataAccessException {
		this.logger.info("find([ " + queryString + " ])");
		return getHibernateTemplate().find(queryString, value);
	}

	public List<?> _find(String queryString, Object[] values)
			throws DataAccessException {
		this.logger.info("find([ " + queryString + " ])");
		return getHibernateTemplate().find(queryString, values);
	}

	public List<?> _find(String queryString) throws DataAccessException {
		this.logger.info("find([ " + queryString + " ])");
		return getHibernateTemplate().find(queryString);
	}

	public List<?> _find(final Integer firstResult, final Integer maxResults)
			throws DataAccessException {
		this.logger.info("find([ " + this.entityClass.getName() + " ])");
		final String hql = "from " + this.entityClass.getName();
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(firstResult.intValue());
				query.setMaxResults(maxResults.intValue());
				return query.list();
			}
		});
	}

	private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
		if (queryArgs != null)
			for (int i = 0; i < queryArgs.length; ++i)
				namedQuery.setParameter(i, queryArgs[i]);
	}

	public List<?> _find(final String queryString, final Integer firstResult,
			final Integer maxResults, final Object[] values)
			throws DataAccessException {
		this.logger.info("find([ " + queryString + " ])");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				BvBaseHibernateDAOImpl.this.setPositionalParams(values, query);
				query.setFirstResult(firstResult.intValue());
				query.setMaxResults(maxResults.intValue());
				return query.list();
			}
		});
	}

	public List<?> _findByNamedParam(String queryString, String paramName,
			Object value) throws DataAccessException {
		this.logger.info("findByNamedParam([ " + queryString + " ])");
		return getHibernateTemplate().findByNamedParam(queryString, paramName,
				value);
	}

	public List<?> _findByNamedParam(String queryString, String[] paramNames,
			Object[] values) throws DataAccessException {
		this.logger.info("findByNamedParam([ " + queryString + " ])");
		return getHibernateTemplate().findByNamedParam(queryString, paramNames,
				values);
	}

	public List<?> _findByNamedParam(final Map<String, Object> filterMap)
			throws DataAccessException {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from "
						+ BvBaseHibernateDAOImpl.this.entityClass.getName());
				for (String paramName : filterMap.keySet())
					query.setParameter(paramName, filterMap.get(paramName));

				return query.list();
			}
		});
	}

	public List<?> _findByNamedParam(final String queryString,
			final Map<String, Object> filterMap) throws DataAccessException {
		this.logger.info("findByNamedParam([ " + queryString + " ])");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				for (String paramName : filterMap.keySet())
					query.setParameter(paramName, filterMap.get(paramName));

				return query.list();
			}
		});
	}

	public Pagelet _findPageByCriteria(final DetachedCriteria detachedCriteria,
			final int pageSize, final int startIndex)
			throws DataAccessException {
		this.logger.info("findPageByCriteria([ " + this.entityClass.getName()
				+ " ])");
		return ((Pagelet) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						long totalCount = ((Long) criteria.setProjection(
								Projections.rowCount()).uniqueResult())
								.longValue();
						criteria.setProjection(null);
						List items = criteria
								.setFirstResult(pageSize * (startIndex - 1))
								.setMaxResults(pageSize).list();
						Pagelet pl = new Pagelet();
						pl.setPageList(items);
						pl.setTotalRecord(totalCount);
						return pl;
					}
				}));
	}

	private String formatQuerySql2CountSql(String querySql) {
		StringBuffer buffer = new StringBuffer();
		String lower = querySql.toLowerCase();
		buffer.append("SELECT COUNT(*) ");
		if (lower.indexOf("from") != -1) {
			int start = lower.indexOf("from");
			if (lower.indexOf("order by") != -1) {
				int end = lower.indexOf("order by");
				buffer.append(querySql.substring(start, end));
			} else {
				buffer.append(querySql.substring(start));
			}
		}
		return buffer.toString();
	}

	public Pagelet _findPageByQuery(String hql, int pageSize, int startIndex)
			throws DataAccessException {
		this.logger.info("handlePageBySupport([ " + this.entityClass.getName()
				+ " ] -- [" + hql + "])");
		String countHSql = formatQuerySql2CountSql(hql);
		Session session = getSession();
		Query query = session.createQuery(countHSql);
		long totalCount = ((Long) query.iterate().next()).longValue();
		query = session.createQuery(hql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize);
		List resultList = query.list();
		releaseSession(session);
		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);
		return pl;
	}

	public Pagelet _findPageByQuery(final String hql, final String countHql,
			final int pageSize, final int startIndex)
			throws DataAccessException {
		this.logger.info("findPageByQuery([ " + this.entityClass.getName()
				+ " ])");
		return ((Pagelet) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						long totalCount = ((Long) session.createQuery(countHql)
								.iterate().next()).longValue();
						Query query = session.createQuery(hql);
						query.setFirstResult(pageSize * (startIndex - 1));
						query.setMaxResults(pageSize);
						List items = query.list();
						Pagelet pl = new Pagelet();
						pl.setPageList(items);
						pl.setTotalRecord(totalCount);
						return pl;
					}
				}));
	}

	public T _getEntityById(Serializable id) throws DataAccessException {
		this.logger.info("read([ " + this.entityClass.getName() + " ])");
		return getHibernateTemplate().get(this.entityClass, id);
	}

	public T _get(String queryString, Object value) throws DataAccessException {
		List resultList = _find(queryString, value);
		if ((resultList != null) && (resultList.size() > 0))
			return (T) resultList.get(0);

		return null;
	}

	public T _get(String queryString, Object[] values)
			throws DataAccessException {
		List resultList = _find(queryString, values);
		if ((resultList != null) && (resultList.size() > 0))
			return (T) resultList.get(0);

		return null;
	}

	public T _get(String queryString) throws DataAccessException {
		List resultList = _find(queryString);
		if ((resultList != null) && (resultList.size() > 0))
			return (T) resultList.get(0);

		return null;
	}

	public List<T> _getAll() throws DataAccessException {
		this.logger.info("list([ " + this.entityClass.getName() + " ])");
		return getHibernateTemplate().loadAll(this.entityClass);
	}

	public T _load(Serializable id) throws DataAccessException {
		this.logger.info("load([ " + this.entityClass.getName() + " ])");
		return getHibernateTemplate().load(this.entityClass, id);
	}

	public void _merge(T transientObject) throws DataAccessException {
		this.logger.info("merge([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().merge(transientObject);
	}

	public List<?> _queryByNamedQuery(String queryName)
			throws DataAccessException {
		this.logger.info("queryByNamedQuery([ " + queryName + " ])");
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

	public List<?> _queryByNamedQuery(final String queryName,
			final Integer firstResult, final Integer maxResults)
			throws DataAccessException {
		this.logger.info("queryByNamedQuery([ " + queryName + " ])");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(queryName);
				query.setFirstResult(firstResult.intValue());
				query.setMaxResults(maxResults.intValue());
				return query.list();
			}
		});
	}

	public List<?> _queryByNamedQuery(String queryName, Object value)
			throws DataAccessException {
		this.logger.info("queryByNamedQuery([ " + queryName + " ])");
		return getHibernateTemplate().findByNamedQuery(queryName, value);
	}

	public List<?> _queryByNamedQuery(String queryName, Object[] values)
			throws DataAccessException {
		this.logger.info("queryByNamedQuery([ " + queryName + " ])");
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List<?> _queryByNamedQuery(final String queryName,
			final Integer firstResult, final Integer maxResults,
			final Object[] values) throws DataAccessException {
		this.logger.info("queryByNamedQuery([ " + queryName + " ])");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery(queryName);
				BvBaseHibernateDAOImpl.this.setPositionalParams(values, query);
				query.setFirstResult(firstResult.intValue());
				query.setMaxResults(maxResults.intValue());
				return query.list();
			}
		});
	}

	public Serializable _save(T t) throws DataAccessException {
		this.logger.info("save([ " + this.entityClass.getName() + " ])");
		return getHibernateTemplate().save(t);
	}

	public void _saveOrUpdate(T t) throws DataAccessException {
		this.logger
				.info("saveOrUpdate([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().saveOrUpdate(t);
	}

	public void _saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException {
		this.logger.info("saveOrUpdateAll([ " + this.entityClass.getName()
				+ " ])");
		for(T entity : entities) {
			getHibernateTemplate().saveOrUpdate(entity);
		}
	}

	public void _update(T transientObject) throws DataAccessException {
		this.logger.info("update([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().update(transientObject);
	}

	public void _update(T transientObject, LockMode lockMode)
			throws DataAccessException {
		this.logger.info("update([ " + this.entityClass.getName() + " ])");
		getHibernateTemplate().update(transientObject, lockMode);
	}

	public Pagelet findEntity(int pageIndex, int pageSize, LogonVO logon,
			Map filterPropertyMap, Object[] values) {
		Pagelet pagelet = new Pagelet();
		String fromHsql = getFindEntityFromHsql(filterPropertyMap, logon,
				values);
		pagelet.setTotalRecord(getTotalRows(fromHsql).intValue());
		List pageList = findEntityWithPage(pageIndex, pageSize, logon, fromHsql);
		pagelet.setPageList(pageList);
		return pagelet;
	}

	public String getFindEntityFromHsql(Map filterPropertyMap, LogonVO logon,
			Object[] values) {
		StringBuffer bufSql = new StringBuffer();
		String userId = logon.getUserid();
		if ((userId != null) && (userId.trim().length() > 0))
			bufSql.append(" FROM ").append(getEntityClass().getName())
					.append(" as a WHERE 1=1 ");
		else {
			bufSql.append(" FROM ").append(getEntityClass().getName())
					.append(" as a WHERE 1=1 ");
		}

		bufSql.append(getWhereHsql(filterPropertyMap, logon, values));
		return bufSql.toString();
	}

	public Integer getTotalRows(String formHsql) {
		Integer totalRows = Integer.valueOf(0);
		Session session = super.getSession();
		Query query = session.createQuery(getCountHsql(formHsql));
		List returnValue = query.list();
		if ((returnValue != null) && (!(returnValue.isEmpty())))
			totalRows = Integer.valueOf(((Long) returnValue.get(0)).intValue());
		return totalRows;
	}

	public String getCountHsql(String fromHsql) {
		return "select count(distinct a.resourceId) " + fromHsql;
	}

	public String getWhereHsql(Map filterPropertyMap, LogonVO logon,
			Object[] values) {
		StringBuffer whereHsql = new StringBuffer(" ");
		return whereHsql.toString();
	}

	public List findEntityWithPage(int pageIndex, int pageSize, LogonVO logon,
			String fromHsql) {
		this.logger.info("DAO开始分页查询" + getEntityClass() + "表数据，查询起点："
				+ pageIndex + "   查询行数：" + pageSize);
		Session session = super.getSession();
		Query query = session.createQuery(getSelectHsql(fromHsql));
		query.setMaxResults(pageSize);
		query.setFirstResult((pageIndex - 1) * pageSize);
		List returnValue = query.list();
		this.logger.info("DAO分页查询结束，结果集行数：" + returnValue.size());
		return returnValue;
	}

	public String getSelectHsql(String fromHsql) {
		return "select  distinct(a) " + fromHsql;
	}

	public Class<T> getEntityClass() {
		return this.entityClass;
	}

	public BvBaseHibernateDAOImpl() {
		this.entityClass = GenericsUtils.getGenericClass(getClass());
	}

	@Autowired
	public void exeBaseHibernateDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
