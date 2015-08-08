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

import java.util.*;


import com.bv.cn.wsbase.base.model.*;
import com.bv.cn.wsbase.base.dao.*;
import com.bv.cn.wsbase.base.dao.impl.*;
import com.bv.cn.wsbase.base.service.*;
import com.bv.cn.wsbase.base.service.impl.*;
import com.bv.cn.wsbase.base.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 客户人员联系方式
 */

@Service
@Transactional
public class TcustlinkServiceImpl extends BvBaseServiveImpl<Tcustlink> implements
	TcustlinkService<Tcustlink> {
		
	public Class<?> getEntityClass() {
		return Tcustlink.class;
	}
	
	private TcustlinkDAO<Tcustlink> tcustlinkDAO;
	
	@Autowired
	public void setTcustlinkDAO(TcustlinkDAO<Tcustlink> dao) {
		this.tcustlinkDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
