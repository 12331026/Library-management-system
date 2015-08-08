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
import com.bv.cn.wsbase.base.dao.TgoodsDAO;
import com.bv.cn.wsbase.base.model.Tgoods;
import com.bv.cn.wsbase.base.service.TgoodsService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 商品管理
 */

@Service
@Transactional
public class TgoodsServiceImpl extends BvBaseServiveImpl<Tgoods> implements
	TgoodsService<Tgoods> {
		
	public Class<?> getEntityClass() {
		return Tgoods.class;
	}
	
	private TgoodsDAO<Tgoods> tgoodsDAO;
	
	@Autowired
	public void setTgoodsDAO(TgoodsDAO<Tgoods> dao) {
		this.tgoodsDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
