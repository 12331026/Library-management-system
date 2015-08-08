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
 * @module 角色权限表
 */

@Controller
public class TrolemoduleController extends AS1BaseController<Trolemodule> {
	@Resource
	private TrolemoduleService<Trolemodule> trolemoduleService;
	@Resource
	private TroleService<Trole> troleService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;

	@Override
	public BvAppBaseService<Trolemodule> getBaseService() {
		return trolemoduleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/trolemodule/trolemodule_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/trolemodule/trolemodule_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/trolemodule/trolemodule_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/trolemodule/trolemodule_form");
	}

	@RequestMapping(value = "add", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public final void add(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String roleid = StringUtils.trimToEmpty(request.getParameter("roleid"));
		String moduleid = StringUtils.trimToEmpty(request.getParameter("moduleid"));
		JSONObject json = new JSONObject();
		try {
			Trolemodule rm = new Trolemodule();
			Trole r = troleService.getEntityById(roleid);
			Tmodule m = tmoduleService.getEntityById(moduleid);
			rm.setTmodule(m);
			rm.setTrole(r);
			m.getTrolemodules().add(rm);
			r.getTrolemodules().add(rm);
			trolemoduleService.saveEntity(rm);
			json.put("success", "true");
		} catch (Exception e) {
			logger.error("", e);
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
		String roleid = StringUtils.trimToEmpty(request.getParameter("roleid"));
		String moduleid = StringUtils.trimToEmpty(request.getParameter("moduleid"));
		JSONObject json = new JSONObject();
		try {
			String hql = "from " + Trolemodule.class.getName() + " t where t."
					+ Trolemodule.ALIAS_MODULE + "." + Tmodule.ALIAS_RESOURCEID
					+ "=? and t." + Trolemodule.ALIAS_ROLE + "."
					+ Trole.ALIAS_RESOURCEID + "=?";
			Trolemodule rm = trolemoduleService.getUniqueByHql(hql, new String[]{moduleid,roleid});
			trolemoduleService.delete(rm);
			json.put("success", "true");
		} catch (Exception e) {
			logger.error("", e);
			json.put("success", "false");
			throw e;
		} finally {
			json.write(response.getWriter());
		}
	}

}
