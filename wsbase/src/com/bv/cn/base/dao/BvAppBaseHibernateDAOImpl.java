package com.bv.cn.base.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.util.Assert;

import com.bv.cn.base.common.Pagelet;

public abstract class BvAppBaseHibernateDAOImpl<T> extends
		BvBaseHibernateDAOImpl<T> implements BvBaseHibernateDAO<T> {
	@SuppressWarnings("unchecked")
	public <X> List<X> getListByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListBySql(String className, String sql,
			Object... params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		if (StringUtils.isNotEmpty(className)) {
			return (List<X>) query.addEntity(className).list();
		}
		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListBySql(T t, String sql, Object... params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		if (t != null) {
			return (List<X>) query.addEntity(t.getClass()).list();
		}
		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListBySql(String sql, Object... params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListByNamedSql(String className, String sql,
			Map<String, Object> params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		if (StringUtils.isNotEmpty(className)) {
			return (List<X>) query.addEntity(className).list();
		}
		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListByNamedSql(T t, String sql,
			Map<String, Object> params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		if (t != null) {
			return (List<X>) query.addEntity(t.getClass()).list();
		}
		return (List<X>) query.list();
	}

	@SuppressWarnings("unchecked")
	public <X> X getUniqueByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		return (X) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> getListByNamedHql(String hql, Map<String, Object> params) {

		Query query = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		List<X> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public Pagelet findPageByNamedHql(String hql, int pageSize, int startIndex,
			Map<String, Object> params) {

		Query query = getSession().createQuery(hql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}

		List resultList = query.list();

		long totalCount = countByNamedHql(hql, params);

		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);

		return pl;
	}

	@SuppressWarnings("unchecked")
	public Pagelet findPageByNamedSql(String className, String sql,
			int pageSize, int startIndex, Map<String, Object> params) {

		SQLQuery query = getSession().createSQLQuery(sql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize * startIndex);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}

		List resultList = query.addEntity(className).list();

		long totalCount = countByNamedSql(sql, params);

		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);

		return pl;
	}

	@SuppressWarnings("unchecked")
	public Pagelet findPageByHql(String hql, int pageSize, int startIndex,
			Object... params) {

		Query query = getSession().createQuery(hql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize);

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		List resultList = query.list();

		long totalCount = countByHql(hql, params);

		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);

		return pl;
	}

	@SuppressWarnings("unchecked")
	public Pagelet findPageBySql(String className, String sql, int pageSize,
			int startIndex, Object... params) {

		SQLQuery query = getSession().createSQLQuery(sql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize);

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		List resultList = query.addEntity(className).list();

		long totalCount = countBySql(sql, params);

		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);

		return pl;
	}

	@SuppressWarnings("unchecked")
	public Pagelet findPageBySql(T t, String sql, int pageSize, int startIndex,
			Object... params) {

		SQLQuery query = getSession().createSQLQuery(sql);
		query.setFirstResult(pageSize * (startIndex - 1));
		query.setMaxResults(pageSize);

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		List resultList = query.addEntity(t.getClass()).list();

		long totalCount = countBySql(sql, params);

		Pagelet pl = new Pagelet();
		pl.setPageList(resultList);
		pl.setTotalRecord(totalCount);

		return pl;
	}

	public void batchExecuteUpdate(List<T> list) {
		Long start = System.currentTimeMillis();
		Assert.notNull(list, "批量更新数据不能为空！");

		for (Integer i = 0; i < list.size(); i++) {
			// 忽略缓存
			this.getSession().setCacheMode(CacheMode.IGNORE);

			this.getSession().update(list.get(i));

			if ((i + 1) % 50 == 0) {
				this.getSession().flush();
				this.getSession().clear();
			}
		}

		Long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000 + "s");
	}

	public void batchExecuteSave(List<T> list) {
		Long start = System.currentTimeMillis();
		Assert.notNull(list, "批量更新数据不能为空！");

		for (Integer i = 0; i < list.size(); i++) {
			// 忽略缓存
			this.getSession().setCacheMode(CacheMode.IGNORE);

			this.getSession().save(list.get(i));

			if ((i + 1) % 50 == 0) {
				this.getSession().flush();
				this.getSession().clear();
			}
		}

		Long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000 + "s");
	}

	public Collection<T> batchExecuteSave(Collection<T> datas) {
		Long start = System.currentTimeMillis();
		Assert.notNull(datas, "批量更新数据不能为空！");
		int i = 0;
		try {
			for (T t : datas) {
				this.getSession().setCacheMode(CacheMode.IGNORE);

				String id = (String) this.getSession().save(t);
				try {
					PropertyUtils.setProperty(t, "resourceId", id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if ((i + 1) % 50 == 0) {
					this.getSession().flush();
					this.getSession().clear();
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000 + "s");
		return datas;
	}

	@SuppressWarnings("unchecked")
	protected long countByNamedSql(String sql, Map<String, Object> params) {
		String countSql = "select count(*) as count from (" + sql + ") tmp ";
		SQLQuery query = getSession().createSQLQuery(countSql);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		return (Long) query.addScalar("count", Hibernate.LONG).uniqueResult();
	}

	protected long countByNamedHql(String hql, Map<String, Object> params) {
		String fromHql = hql;

		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");

		String countHql = "select count(*) " + fromHql;

		Query query = getSession().createQuery(countHql);
		if (params != null && !params.isEmpty()) {
			Set<String> keySet = params.keySet();
			for (Iterator<String> iterator = keySet.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				Object value = params.get(key);
				if (value instanceof Collection) {
					query.setParameterList(key, (Collection<Object>) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(key, (Object[]) value);
				} else {
					query.setParameter(key, value);
				}
			}
		}
		if (countHql.indexOf("group by") > 0) {
			return query.list().size();
		} else {
			return (Long) query.uniqueResult();
		}
	}

	protected long countByHql(String hql, Object... params) {
		String fromHql = hql;

		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");

		String countHql = "select count(*) " + fromHql;

		if (countHql.indexOf("group by") > 0) {
			return this.getListByHql(countHql, params).size();
		}

		return getUniqueByHql(countHql, params);

	}

	protected long countBySql(String sql, Object... params) {
		String fromSql = "select count(1) as count from (" + sql + ") tmp ";
		SQLQuery query = getSession().createSQLQuery(fromSql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		return (Long) query.addScalar("count", Hibernate.LONG).uniqueResult();

	}

	public void updateByField(final String[] idArray, final String[] fieldName,
			final Object[] value) {
		int i = (Integer) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "update " + entityClass.getName()
								+ " a set";
						boolean prependStart = true;
						for (int j = 0; j < fieldName.length; j++) {
							if (prependStart) {
								hql += " a." + fieldName[j] + " = ?";
								prependStart = false;
							} else {
								hql += ", a." + fieldName[j] + " = ?";
							}
						}
						hql += " where a.resourceid in (";
						for (int i = 0; i < idArray.length; i++) {
							hql += " ?,";
						}
						hql = hql.substring(0, hql.length() - 1);
						hql += ")";
						logger.info("updateByField() hql = " + hql);
						String paramStr = "";
						Query query = session.createQuery(hql);
						for (int k = 0; k < value.length; k++) {
							query.setParameter(k, value[k]);
							paramStr += fieldName[k] + ":" + value[k] + ",";
						}
						for (int l = 0; l < idArray.length; l++) {
							query.setString(value.length + l, idArray[l]);
						}
						logger.info("updateByField() fieldName:value = "
								+ paramStr);
						return query.executeUpdate();
					}

				});
		logger.info("updateByField() update [" + i + "] records");
	}

	@SuppressWarnings("unchecked")
	public Map<String, BigDecimal> getSummary(String hql, List<Object> list) {
		Query query = getSession().createQuery(hql);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				query.setParameter(i, list.get(i));
			}
		}
		List<Object> ret = query.list();
		Map<String, BigDecimal> map = null;
		if (ret != null && ret.size() > 0) {
			map = new HashMap<String, BigDecimal>();
			for (int i = 0; i < ret.size(); i++) {
				Object[] os = (Object[]) ret.get(i);
				if (os != null && os.length > 1) {
					map.put((String) os[1],
							(BigDecimal) os[0] == null ? BigDecimal
									.valueOf(0.0) : (BigDecimal) os[0]);
				}
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, List<BigDecimal>> getAllSummary(String hql,
			List<Object> list) {
		Query query = getSession().createQuery(hql);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				query.setParameter(i, list.get(i));
			}
		}
		List<Object> ret = query.list();
		Map<String, List<BigDecimal>> map = null;
		if (ret != null && ret.size() > 0) {
			map = new HashMap<String, List<BigDecimal>>();
			for (int i = 0; i < ret.size(); i++) {
				List<BigDecimal> cols = new ArrayList<BigDecimal>();
				Object[] os = (Object[]) ret.get(i);
				if (os != null && os.length > 0) {
					for (int j = 1; j < os.length; j++) {
						cols.add(os[i] == null ? BigDecimal.valueOf(0.0)
								: (BigDecimal) os[j]);
					}
					map.put((String) os[0], cols);
				}
			}
		}
		return map;
	}

	public void flush() {
		this.getSession().flush();
	}

	public void execHql(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);

		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		query.executeUpdate();

	}

	public Session getCurrentSession() {
		return this.getSession(false);
	}
}
