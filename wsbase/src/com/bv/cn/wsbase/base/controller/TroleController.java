/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.model.Trole;
import com.bv.cn.wsbase.base.model.Trolemodule;
import com.bv.cn.wsbase.base.service.TmoduleService;
import com.bv.cn.wsbase.base.service.TroleService;
import com.bv.cn.wsbase.base.service.TrolemoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 角色表
 */

@Controller
public class TroleController extends AS1BaseController<Trole> {
	@Resource
	private TroleService<Trole> troleService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;
	@Resource
	private TrolemoduleService<Trolemodule> trolemoduleService;

	@Override
	public BvAppBaseService<Trole> getBaseService() {
		return troleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Trole/Trole_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Trole/Trole_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Trole/Trole_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Trole/Trole_form");
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);

	}

	@Override
	protected void exeAfterEdit(Trole t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String hql = "from " + Tmodule.class.getName() + " t";
		String orderBy = " order by t." + Tmodule.ALIAS_SHOWORDER;
		List<Tmodule> mlist = tmoduleService.getListsByHql(hql + orderBy, new Object[0]);
		request.setAttribute("sublist", mlist);
		List<Trolemodule> rmlist = new ArrayList<Trolemodule>();
		if (null != t && !StringUtils.trimToEmpty(t.getRolecode()).equals("")) {
			String hql2 = "from " + Trolemodule.class.getName() + " t where t."
					+ Trolemodule.ALIAS_ROLE + "." + Trole.ALIAS_ROLECODE
					+ " = ?";
			rmlist = trolemoduleService.getListsByHql(hql2,
					new String[] { StringUtils.trimToEmpty(t.getRolecode()) });
		}
		request.setAttribute("rmlist", rmlist);
	}

	@Override
	protected void exeBeforeSave(Trole t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			Trole t2 = getBaseService().getEntityById(
					StringUtils.trimToEmpty(t.getResourceid()));
			Set<Trolemodule> rms = new HashSet<Trolemodule>(t2
					.getTrolemodules());
			rms.size();
			t.setTrolemodules(rms);
		}
	}

}
