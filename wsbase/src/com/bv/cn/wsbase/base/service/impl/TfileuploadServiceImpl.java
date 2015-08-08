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
 * @module 附件上传
 */

@Service
@Transactional
public class TfileuploadServiceImpl extends BvBaseServiveImpl<Tfileupload> implements
	TfileuploadService<Tfileupload> {
		
	public Class<?> getEntityClass() {
		return Tfileupload.class;
	}
	
	private TfileuploadDAO<Tfileupload> tfileuploadDAO;
	
	@Autowired
	public void setTfileuploadDAO(TfileuploadDAO<Tfileupload> dao) {
		this.tfileuploadDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}
	
}
