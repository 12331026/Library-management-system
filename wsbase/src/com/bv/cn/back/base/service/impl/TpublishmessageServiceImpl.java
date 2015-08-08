/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.back.base.dao.TpublishmessageDAO;
import com.bv.cn.back.base.model.Tpublishmessage;
import com.bv.cn.back.base.service.TpublishmessageService;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告信息管理
 */

@Service
@Transactional
public class TpublishmessageServiceImpl extends
		BvBaseServiveImpl<Tpublishmessage> implements
		TpublishmessageService<Tpublishmessage> {

	public Class<?> getEntityClass() {
		return Tpublishmessage.class;
	}

	private TpublishmessageDAO<Tpublishmessage> tpublishmessageDAO;

	@Autowired
	public void setTpublishmessageDAO(TpublishmessageDAO<Tpublishmessage> dao) {
		this.tpublishmessageDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
