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
import com.bv.cn.wsbase.base.dao.TdictDAO;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.service.TdictService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 字典定义
 */

@Service(value = "tdictService")
@Transactional
public class TdictServiceImpl extends BvBaseServiveImpl<Tdict> implements
		TdictService<Tdict> {

	public Class<?> getEntityClass() {
		return Tdict.class;
	}

	private TdictDAO<Tdict> tdictDAO;

	@Autowired
	public void setTdictDAO(TdictDAO<Tdict> dao) {
		this.tdictDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
