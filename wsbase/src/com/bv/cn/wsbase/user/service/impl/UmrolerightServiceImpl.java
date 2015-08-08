/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.service.impl.BvBaseServiveImpl;

import java.util.*;


import com.bv.cn.wsbase.user.model.*;
import com.bv.cn.wsbase.user.dao.*;
import com.bv.cn.wsbase.user.dao.impl.*;
import com.bv.cn.wsbase.user.service.*;
import com.bv.cn.wsbase.user.service.impl.*;
import com.bv.cn.wsbase.user.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UmrolerightServiceImpl extends BvBaseServiveImpl<Umroleright> implements
	UmrolerightService<Umroleright> {
		
	public Class getEntityClass() {
		return Umroleright.class;
	}
	
	private UmrolerightDAO<Umroleright> umrolerightDAO;
	
	@Autowired
	public void setUmrolerightDAO(UmrolerightDAO<Umroleright> dao) {
		this.umrolerightDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
