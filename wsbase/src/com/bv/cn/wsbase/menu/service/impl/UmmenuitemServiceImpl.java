/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.service.impl.BvBaseServiveImpl;

import java.util.*;


import com.bv.cn.wsbase.menu.model.*;
import com.bv.cn.wsbase.menu.dao.*;
import com.bv.cn.wsbase.menu.dao.impl.*;
import com.bv.cn.wsbase.menu.service.*;
import com.bv.cn.wsbase.menu.service.impl.*;
import com.bv.cn.wsbase.menu.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UmmenuitemServiceImpl extends BvBaseServiveImpl<Ummenuitem> implements
	UmmenuitemService<Ummenuitem> {
		
	public Class<?> getEntityClass() {
		return Ummenuitem.class;
	}
	
	private UmmenuitemDAO<Ummenuitem> ummenuitemDAO;
	
	@Autowired
	public void setUmmenuitemDAO(UmmenuitemDAO<Ummenuitem> dao) {
		this.ummenuitemDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

	@Override
	public Ummenuitem[] queryMenuitems(String userid, String menuCode,
			String pageType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
