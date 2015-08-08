package com.bv.cn.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.security.model.LogonVO;

public interface BvBaseHibernateDAO<T> {
	public abstract Serializable _save(T paramT) throws DataAccessException;

	public abstract void _saveOrUpdate(T paramT) throws DataAccessException;

	public abstract void _saveOrUpdateAll(Collection<T> paramCollection)
			throws DataAccessException;

	public abstract void _update(T paramT) throws DataAccessException;

	public abstract void _update(T paramT, LockMode paramLockMode)
			throws DataAccessException;

	public abstract void _merge(T paramT) throws DataAccessException;

	public abstract void _deleteById(Serializable paramSerializable);

	public abstract void _delete(T paramT) throws DataAccessException;

	public abstract void _delete(T paramT, LockMode paramLockMode)
			throws DataAccessException;

	public abstract void _deleteAll(Collection<T> paramCollection)
			throws DataAccessException;

	public abstract int _executeHql(String paramString);

	public abstract T _getEntityById(Serializable paramSerializable)
			throws DataAccessException;

	public abstract T _get(String paramString, Object paramObject)
			throws DataAccessException;

	public abstract T _get(String paramString, Object[] paramArrayOfObject)
			throws DataAccessException;

	public abstract T _get(String paramString) throws DataAccessException;

	public abstract List<T> _getAll() throws DataAccessException;

	public abstract T _load(Serializable paramSerializable)
			throws DataAccessException;

	public abstract Long _count() throws DataAccessException;

	public abstract Long _count(String paramString) throws DataAccessException;

	public abstract List<?> _find(String paramString, Object paramObject)
			throws DataAccessException;

	public abstract List<?> _find(String paramString,
			Object[] paramArrayOfObject) throws DataAccessException;

	public abstract List<?> _find(String paramString)
			throws DataAccessException;

	public abstract List<?> _find(Integer paramInteger1, Integer paramInteger2)
			throws DataAccessException;

	public abstract List<?> _find(String paramString, Integer paramInteger1,
			Integer paramInteger2, Object[] paramArrayOfObject)
			throws DataAccessException;

	public abstract List<?> _findByNamedParam(String paramString1,
			String paramString2, Object paramObject) throws DataAccessException;

	public abstract List<?> _findByNamedParam(String paramString,
			String[] paramArrayOfString, Object[] paramArrayOfObject)
			throws DataAccessException;

	public abstract List<?> _findByNamedParam(Map<String, Object> paramMap)
			throws DataAccessException;

	public abstract List<?> _findByNamedParam(String paramString,
			Map<String, Object> paramMap) throws DataAccessException;

	public abstract List<?> _queryByNamedQuery(String paramString)
			throws DataAccessException;

	public abstract List<?> _queryByNamedQuery(String paramString,
			Integer paramInteger1, Integer paramInteger2)
			throws DataAccessException;

	public abstract List<?> _queryByNamedQuery(String paramString,
			Object paramObject) throws DataAccessException;

	public abstract List<?> _queryByNamedQuery(String paramString,
			Object[] paramArrayOfObject) throws DataAccessException;

	public abstract List<?> _queryByNamedQuery(String paramString,
			Integer paramInteger1, Integer paramInteger2,
			Object[] paramArrayOfObject) throws DataAccessException;

	public abstract Pagelet _findPageByCriteria(
			DetachedCriteria paramDetachedCriteria, int paramInt1, int paramInt2)
			throws DataAccessException;

	public abstract Pagelet _findPageByQuery(String paramString, int paramInt1,
			int paramInt2) throws DataAccessException;

	public abstract Pagelet _findPageByQuery(String paramString1,
			String paramString2, int paramInt1, int paramInt2)
			throws DataAccessException;

	public abstract Pagelet findEntity(int paramInt1, int paramInt2,
			LogonVO paramLogonVO, Map paramMap, Object[] paramArrayOfObject);
}
