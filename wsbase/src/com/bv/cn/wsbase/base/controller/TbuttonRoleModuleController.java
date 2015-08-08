/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.TbuttonModule;
import com.bv.cn.wsbase.base.model.TbuttonRoleModule;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.model.Trole;
import com.bv.cn.wsbase.base.model.Trolemodule;
import com.bv.cn.wsbase.base.service.TbuttonModuleService;
import com.bv.cn.wsbase.base.service.TbuttonRoleModuleService;
import com.bv.cn.wsbase.base.service.TmoduleService;
import com.bv.cn.wsbase.base.service.TrolemoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 按钮资源-角色模块关系表
 */

@Controller
public class TbuttonRoleModuleController extends
		AS1BaseController<TbuttonRoleModule> {
	@Resource
	private TbuttonRoleModuleService<TbuttonRoleModule> tbuttonRoleModuleService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;
	@Resource
	private TrolemoduleService<Trolemodule> trolemoduleService;
	@Resource
	private TbuttonModuleService<TbuttonModule> tbuttonModuleService;

	@Override
	public BvAppBaseService<TbuttonRoleModule> getBaseService() {
		return tbuttonRoleModuleService;
	}

	public void setListPagePath() {
		super
				.setListPagePath("wsbase/TbuttonRoleModule/TbuttonRoleModule_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("wsbase/TbuttonRoleModule/TbuttonRoleModule_list_child");
	}

	public void setEditPagePath() {
		super
				.setEditPagePath("wsbase/TbuttonRoleModule/TbuttonRoleModule_edit");
	}

	public void setFormPagePath() {
		super
				.setFormPagePath("wsbase/TbuttonRoleModule/TbuttonRoleModule_form");
	}

	@Override
	protected void exeAfterEdit(TbuttonRoleModule t,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);

	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String moduleid = StringUtils.trimToEmpty(request
				.getParameter("moduleid"));
		String roleid = StringUtils.trimToEmpty(request.getParameter("roleid"));
		String hql = "from " + Trolemodule.class.getName() + " t where t."
				+ Trolemodule.ALIAS_MODULE + "." + Tmodule.ALIAS_RESOURCEID
				+ " = ? and t." + Trolemodule.ALIAS_ROLE + "."
				+ Trole.ALIAS_RESOURCEID + " = ?";
		Trolemodule rm = trolemoduleService.getUniqueByHql(hql, new String[] {
				moduleid, roleid });
		if (isNewlink(request)) {
			request.setAttribute("rm", rm);
			request.setAttribute("moduleid", moduleid);
			request.setAttribute("roleid", roleid);
		} else {
			Tmodule m = tmoduleService.getEntityById(moduleid);
			request.setAttribute("blist", m.getTbuttonModules());
			request.setAttribute("rm", rm);
			request.setAttribute("brmlist", rm.getTbuttonRoleModules());
		}
	}
	
	

	@Override
	protected void exeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		
	}

	@RequestMapping(value = "add", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public final void add(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String buttonid = StringUtils.trimToEmpty(request.getParameter("buttonid"));
		String rolemoduleid = StringUtils.trimToEmpty(request.getParameter("rolemoduleid"));
		JSONObject json = new JSONObject();
		try {
			TbuttonRoleModule brm = new TbuttonRoleModule();
			TbuttonModule b = tbuttonModuleService.getEntityById(buttonid);
			Trolemodule rm = trolemoduleService.getEntityById(rolemoduleid);
			brm.setTbuttonModule(b);
			brm.setTrolemodule(rm);
			b.getTbuttonRoleModules().add(brm);
			rm.getTbuttonRoleModules().add(brm);
			getBaseService().saveEntity(brm);
			json.put("success", "true");
		} catch (Exception e) {
			logger.error("新增按钮角色模块记录出错!", e);
			json.put("success", "false");
			throw e;
		} finally {
			json.write(response.getWriter());
		}
	}

	@RequestMapping(value = "del", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public final void del(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String buttonid = StringUtils.trimToEmpty(request.getParameter("buttonid"));
		String rolemoduleid = StringUtils.trimToEmpty(request.getParameter("rolemoduleid"));
		JSONObject json = new JSONObject();
		try {
			String hql = "from " + TbuttonRoleModule.class.getName() + " t where t."
					+ TbuttonRoleModule.ALIAS_BUTTONMODULE + "." + TbuttonModule.ALIAS_RESOURCEID
					+ " = ? and t." + TbuttonRoleModule.ALIAS_ROLEMODULE + "."
					+ Trolemodule.ALIAS_RESOURCEID + " = ?";
			TbuttonRoleModule brm = trolemoduleService.getUniqueByHql(hql, new String[]{buttonid,rolemoduleid});
			getBaseService().delete(brm);
			json.put("success", "true");
		} catch (Exception e) {
			logger.error("删除按钮角色模块记录出错!", e);
			json.put("success", "false");
			throw e;
		} finally {
			json.write(response.getWriter());
		}
	}

}
