package com.bv.cn.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.dao.BvAppBaseHibernateDAO;

@Transactional
public class BvAppBaseServiceImpl<T> extends BvBasicServiceImpl<T> implements
		BvAppBaseService<T> {
	/**
	 * @param appBaseHibernateDAO
	 *            the appBaseHibernateDAO to set
	 */
	public void setAppBaseHibernateDAO(
			BvAppBaseHibernateDAO<T> appBaseHibernateDAO) {
		this.appBaseHibernateDAO = appBaseHibernateDAO;
		super.setBaseHibernateDAO(appBaseHibernateDAO);
	}

	BvAppBaseHibernateDAO<T> appBaseHibernateDAO;

	public <X> List<X> getListsByHql(String hql, List<Object> params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getListByHql(hql, params.toArray());

		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListsBySql(String className, String sql,
			List<Object> params) throws BvBaseServiceException {
		try {
			if (StringUtils.isNotEmpty(className)) {
				return appBaseHibernateDAO.getListBySql(className, sql,
						params.toArray());
			}
			return appBaseHibernateDAO.getListBySql(sql, params.toArray());

		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListsBySql(T t, String sql, List<Object> params)
			throws BvBaseServiceException {
		try {
			if (t != null) {
				return appBaseHibernateDAO.getListBySql(t, sql,
						params.toArray());
			}
			return appBaseHibernateDAO.getListBySql(sql, params.toArray());

		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListsBySql(String sql, List<Object> params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getListBySql(sql, params.toArray());

		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListByNamedSql(String className, String sql,
			Map<String, Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO
					.getListByNamedSql(className, sql, params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListByNamedSql(T t, String sql,
			Map<String, Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getListByNamedSql(t, sql, params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListsByHql(String hql, Object... params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getListByHql(hql, params);

		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public <X> List<X> getListByNamedHql(String hql, Map<String, Object> params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getListByNamedHql(hql, params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("查询操作失败！");
		}
	}

	public Pagelet findPageByHql(String hql, int pageSize, int startIndex,
			List<Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageByHql(hql, pageSize, startIndex,
					params.toArray());
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageByNamedHql(String hql, int pageSize, int startIndex,
			Map<String, Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageByNamedHql(hql, pageSize,
					startIndex, params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageByNamedSql(String className, String sql,
			int pageSize, int startIndex, Map<String, Object> params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageByNamedSql(className, sql,
					pageSize, startIndex, params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageBySql(String className, String sql, int pageSize,
			int startIndex, List<Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageBySql(className, sql, pageSize,
					startIndex, params.toArray());
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageBySql(T t, String sql, int pageSize, int startIndex,
			List<Object> params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageBySql(t, sql, pageSize,
					startIndex, params.toArray());
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageByHql(String hql, int pageSize, int startIndex,
			Object... params) throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageByHql(hql, pageSize, startIndex,
					params);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public Pagelet findPageByHql(String hql, int pageSize, int startIndex)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.findPageByHql(hql, pageSize, startIndex);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			throw new BvBaseServiceException("分页查询操作失败！");
		}
	}

	public void saveOrUpdate(T t) throws BvBaseServiceException {
		try {
			appBaseHibernateDAO._saveOrUpdate(t);
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("保存或更新操作失败！");
		}
	}

	public <X> X getUniqueByHql(String hql, Object... params)
			throws BvBaseServiceException {
		try {
			return appBaseHibernateDAO.getUniqueByHql(hql, params);
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("查询对象操作失败！");
		}
	}

	public void deleteByIds(Serializable... ids) throws BvBaseServiceException {
		try {
			Assert.notNull(ids, "待删除的ID不能为空！");

			for (Serializable id : ids) {
				appBaseHibernateDAO._deleteById(id);
			}

		} catch (IllegalArgumentException e) {
			throw new BvBaseServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("删除对象操作失败！");
		}
	}

	public void batchExecuteSave(List<T> list) throws BvBaseServiceException {
		try {
			Assert.notNull(list, "批量操作数据不能为空！");

			appBaseHibernateDAO.batchExecuteSave(list);
		} catch (IllegalArgumentException e) {
			throw new BvBaseServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("批量操作数据失败！");
		}
	}

	public void batchExecuteUpdate(List<T> list) throws BvBaseServiceException {
		try {
			Assert.notNull(list, "批量操作数据不能为空！");

			appBaseHibernateDAO.batchExecuteUpdate(list);
		} catch (IllegalArgumentException e) {
			throw new BvBaseServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BvBaseServiceException("批量操作数据失败！");
		}
	}

	public void updateByField(String[] idArray, String[] fieldName,
			Object[] value) {
		Assert.notEmpty(idArray, "resourceId 数组不能为空！");
		Assert.notEmpty(fieldName, "更新的字段名称数组不能为空！");
		Assert.notEmpty(value, "更新的目标值数组不能为空！");
		appBaseHibernateDAO.updateByField(idArray, fieldName, value);
	}

	public void execHql(String hql, Object... params)
			throws BvBaseServiceException {
		try {

			Assert.hasText(hql, "操作的HQL不能为空！");

			appBaseHibernateDAO.execHql(hql, params);

		} catch (IllegalArgumentException e) {
			throw new BvBaseServiceException(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();

			throw new BvBaseServiceException("执行批量操作失败！");
		}
	}

}
