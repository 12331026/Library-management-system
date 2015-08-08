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

import com.bv.cn.back.base.dao.TpublishtypeDAO;
import com.bv.cn.back.base.model.Tpublishtype;
import com.bv.cn.back.base.service.TpublishtypeService;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告类型
 */

@Service
@Transactional
public class TpublishtypeServiceImpl extends BvBaseServiveImpl<Tpublishtype>
		implements TpublishtypeService<Tpublishtype> {

	public Class<?> getEntityClass() {
		return Tpublishtype.class;
	}

	private TpublishtypeDAO<Tpublishtype> tpublishtypeDAO;

	@Autowired
	public void setTpublishtypeDAO(TpublishtypeDAO<Tpublishtype> dao) {
		this.tpublishtypeDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
