/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.service.impl.BvBaseServiveImpl;

import java.util.*;


import com.bv.cn.tsjylib.base.model.*;
import com.bv.cn.tsjylib.base.dao.*;
import com.bv.cn.tsjylib.base.dao.impl.*;
import com.bv.cn.tsjylib.base.service.*;
import com.bv.cn.tsjylib.base.service.impl.*;
import com.bv.cn.tsjylib.base.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 
 */

@Service
@Transactional
public class TborrowbookServiceImpl extends BvBaseServiveImpl<Tborrowbook> implements
	TborrowbookService<Tborrowbook> {
		
	public Class<?> getEntityClass() {
		return Tborrowbook.class;
	}
	
	private TborrowbookDAO<Tborrowbook> tborrowbookDAO;
	
	@Autowired
	public void setTborrowbookDAO(TborrowbookDAO<Tborrowbook> dao) {
		this.tborrowbookDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
