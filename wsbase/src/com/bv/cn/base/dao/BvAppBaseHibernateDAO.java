package com.bv.cn.base.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.bv.cn.base.common.Pagelet;

public interface BvAppBaseHibernateDAO<T> extends BvBaseHibernateDAO<T> {

	public <X> List<X> getListByHql(String hql, Object... params);

	public <X> List<X> getListBySql(String sql, Object... params);

	public <X> List<X> getListBySql(String className, String sql,
			Object... params);

	public <X> List<X> getListBySql(T t, String sql, Object... params);

	public <X> List<X> getListByNamedSql(String className, String sql,
			Map<String, Object> params);

	public <X> List<X> getListByNamedSql(T t, String sql,
			Map<String, Object> params);

	public <X> X getUniqueByHql(String hql, Object... params);

	public <X> List<X> getListByNamedHql(String hql, Map<String, Object> params);

	public Pagelet findPageBySql(String className, String sql, int pageSize,
			int startIndex, Object... params);

	public Pagelet findPageBySql(T t, String sql, int pageSize, int startIndex,
			Object... params);

	/**
	 * 根据命名sql分页查询
	 * 
	 * @param className
	 * @param sql
	 * @param pageSize
	 * @param startIndex
	 * @param params
	 * @return
	 */
	public Pagelet findPageByNamedSql(String className, String sql,
			int pageSize, int startIndex, Map<String, Object> params);

	public Pagelet findPageByNamedHql(String hql, int pageSize, int startIndex,
			Map<String, Object> params);

	public Pagelet findPageByHql(String hql, int pageSize, int startIndex,
			Object... params);

	public void batchExecuteSave(List<T> list);

	public void batchExecuteUpdate(List<T> list);

	/**
	 * 批量更新
	 * 
	 * @param datas
	 * @return
	 */
	public Collection<T> batchExecuteSave(Collection<T> datas);

	/**
	 * 更新fieldName指定的字段
	 * 
	 * @param idArray
	 * @param fieldName
	 * @param value
	 */
	public void updateByField(String[] idArray, String[] fieldName,
			Object[] value);

	public Map<String, BigDecimal> getSummary(String hql, List<Object> list);

	public Map<String, List<BigDecimal>> getAllSummary(String hql,
			List<Object> list);

	public void flush();

	public void execHql(String hql, Object... params);

	public Session getCurrentSession();
}
