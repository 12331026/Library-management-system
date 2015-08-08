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
import com.bv.cn.wsbase.base.dao.TshoppingDAO;
import com.bv.cn.wsbase.base.model.Tshopping;
import com.bv.cn.wsbase.base.service.TshoppingService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 购物管理
 */

@Service
@Transactional
public class TshoppingServiceImpl extends BvBaseServiveImpl<Tshopping> implements
	TshoppingService<Tshopping> {
		
	public Class<?> getEntityClass() {
		return Tshopping.class;
	}
	
	private TshoppingDAO<Tshopping> tshoppingDAO;
	
	@Autowired
	public void setTshoppingDAO(TshoppingDAO<Tshopping> dao) {
		this.tshoppingDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
