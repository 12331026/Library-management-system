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
import com.bv.cn.wsbase.base.dao.TbuttonModuleDAO;
import com.bv.cn.wsbase.base.model.TbuttonModule;
import com.bv.cn.wsbase.base.service.TbuttonModuleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 按钮资源表
 */

@Service(value = "tbuttonModuleService")
@Transactional
public class TbuttonModuleServiceImpl extends BvBaseServiveImpl<TbuttonModule>
		implements TbuttonModuleService<TbuttonModule> {

	public Class<?> getEntityClass() {
		return TbuttonModule.class;
	}

	private TbuttonModuleDAO<TbuttonModule> tbuttonModuleDAO;

	@Autowired
	public void setTbuttonModuleDAO(TbuttonModuleDAO<TbuttonModule> dao) {
		this.tbuttonModuleDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
