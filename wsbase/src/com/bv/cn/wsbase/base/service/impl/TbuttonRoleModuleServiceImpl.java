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
import com.bv.cn.wsbase.base.dao.TbuttonRoleModuleDAO;
import com.bv.cn.wsbase.base.model.TbuttonRoleModule;
import com.bv.cn.wsbase.base.service.TbuttonRoleModuleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 按钮资源-角色模块关系表
 */

@Service(value = "tbuttonRoleModuleService")
@Transactional
public class TbuttonRoleModuleServiceImpl extends
		BvBaseServiveImpl<TbuttonRoleModule> implements
		TbuttonRoleModuleService<TbuttonRoleModule> {

	public Class<?> getEntityClass() {
		return TbuttonRoleModule.class;
	}

	private TbuttonRoleModuleDAO<TbuttonRoleModule> tbuttonRoleModuleDAO;

	@Autowired
	public void setTbuttonRoleModuleDAO(
			TbuttonRoleModuleDAO<TbuttonRoleModule> dao) {
		this.tbuttonRoleModuleDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

}
