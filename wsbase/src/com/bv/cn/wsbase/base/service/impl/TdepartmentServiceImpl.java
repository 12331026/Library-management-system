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
 * @module 部门
 */

@Service(value = "tdepartmentService")
@Transactional
public class TdepartmentServiceImpl extends TudcommonServiceImpl<Tdepartment>
		implements TdepartmentService<Tdepartment> {

	public Class<?> getEntityClass() {
		return Tdepartment.class;
	}

	private TdepartmentDAO<Tdepartment> tdepartmentDAO;

	@Autowired
	public void setTdepartmentDAO(TdepartmentDAO<Tdepartment> dao) {
		this.tdepartmentDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
