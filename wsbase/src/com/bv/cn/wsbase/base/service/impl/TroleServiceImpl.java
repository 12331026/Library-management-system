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
import com.bv.cn.wsbase.base.dao.TroleDAO;
import com.bv.cn.wsbase.base.model.Trole;
import com.bv.cn.wsbase.base.service.TroleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 角色表
 */

@Service(value = "troleService")
@Transactional
public class TroleServiceImpl extends BvBaseServiveImpl<Trole> implements
	TroleService<Trole> {
		
	public Class<?> getEntityClass() {
		return Trole.class;
	}
	
	private TroleDAO<Trole> troleDAO;
	
	@Autowired
	public void setTroleDAO(TroleDAO<Trole> dao) {
		this.troleDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
