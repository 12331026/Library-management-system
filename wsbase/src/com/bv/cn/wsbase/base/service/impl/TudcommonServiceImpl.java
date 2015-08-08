/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;
import com.bv.cn.wsbase.base.dao.TudcommonDAO;
import com.bv.cn.wsbase.base.service.TudcommonService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 用户部门Common
 */

@Service(value = "tudcommonService")
@Transactional
public class TudcommonServiceImpl<Tudcommon> extends BvBaseServiveImpl<Tudcommon>
		implements TudcommonService<Tudcommon> {

	public Class<?> getEntityClass() {
		return GenericsUtils.getGenericClass(super.getClass());
	}

	private TudcommonDAO<Tudcommon> tudcommonDAO;

	@Resource
	public void setTudcommonDAO(TudcommonDAO<Tudcommon> dao) {
		this.tudcommonDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
}
