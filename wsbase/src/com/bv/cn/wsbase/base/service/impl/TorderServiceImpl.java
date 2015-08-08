/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.service.impl.BvBaseServiveImpl;
import com.bv.cn.wsbase.base.dao.TorderDAO;
import com.bv.cn.wsbase.base.model.Torder;
import com.bv.cn.wsbase.base.service.TorderService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 订单管理
 */

@Service
@Transactional
public class TorderServiceImpl extends BvBaseServiveImpl<Torder> implements
		TorderService<Torder> {

	public Class<?> getEntityClass() {
		return Torder.class;
	}

	private TorderDAO<Torder> torderDAO;

	@Autowired
	public void setTorderDAO(TorderDAO<Torder> dao) {
		this.torderDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
