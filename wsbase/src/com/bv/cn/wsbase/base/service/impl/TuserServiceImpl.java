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
import com.bv.cn.wsbase.base.dao.TuserDAO;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 用户表
 */

@Service(value = "tuserService")
@Transactional
public class TuserServiceImpl extends TudcommonServiceImpl<Tuser> implements
		TuserService<Tuser> {

	public Class<?> getEntityClass() {
		return Tuser.class;
	}

	private TuserDAO<Tuser> tuserDAO;

	@Autowired
	public void setTuserDAO(TuserDAO<Tuser> dao) {
		this.tuserDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
