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

import com.bv.cn.back.base.dao.TmessageDAO;
import com.bv.cn.back.base.model.Tmessage;
import com.bv.cn.back.base.service.TmessageService;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 留言消息
 */

@Service
@Transactional
public class TmessageServiceImpl extends BvBaseServiveImpl<Tmessage> implements
		TmessageService<Tmessage> {

	public Class<?> getEntityClass() {
		return Tmessage.class;
	}

	private TmessageDAO<Tmessage> tmessageDAO;

	@Autowired
	public void setTmessageDAO(TmessageDAO<Tmessage> dao) {
		this.tmessageDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
