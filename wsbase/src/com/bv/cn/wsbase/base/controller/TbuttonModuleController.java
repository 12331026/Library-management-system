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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.TbuttonModule;
import com.bv.cn.wsbase.base.model.TbuttonRoleModule;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.service.TbuttonModuleService;
import com.bv.cn.wsbase.base.service.TmoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 按钮资源表
 */

@Controller
public class TbuttonModuleController extends AS1BaseController<TbuttonModule> {
	@Resource
	private TbuttonModuleService<TbuttonModule> tbuttonModuleService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;

	@Override
	public BvAppBaseService<TbuttonModule> getBaseService() {
		return tbuttonModuleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/TbuttonModule/TbuttonModule_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("wsbase/TbuttonModule/TbuttonModule_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/TbuttonModule/TbuttonModule_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/TbuttonModule/TbuttonModule_form");
	}

	@RequestMapping(value = "listframe", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView listframe(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			String isFrame = StringUtils.trimToEmpty(request
					.getParameter("isFrame"));
			exeBeforeList(request, response, sessionStatus, modelMap);
			if (isFrame.equals("Y")) {
				mav = new ModelAndView("wsbase/TbuttonModule/Tbuttonmodule_list_frame");
			}
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String module = StringUtils.trimToEmpty(request.getParameter("module"));
		String hql = "from " + clazzName + " t ";
		List<String> params = new ArrayList<String>();
		if (!"".equals(module)) {
			hql += " where t." + TbuttonModule.ALIAS_MODULE + "."
					+ Tmodule.ALIAS_MODULECODE + " = ?";
			params.add(module);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
		if (isNewlink(request)) {
			request.setAttribute("module", module);
		}
	}
	
	@Override
	protected void exeAfterEdit(TbuttonModule t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		if(null == t.getTmodule()) {
			String module = StringUtils.trimToEmpty(request
					.getParameter("module"));
			if(!"".equals(module)) {
			String hql = "from " + Tmodule.class.getName() + " t where t."
					+ Tmodule.ALIAS_MODULECODE + " = ?";
					Tmodule m = tmoduleService.getUniqueByHql(hql, new String[] { module });
					t.setTmodule(m);
			} 
		}
	}
	
	@Override
	protected void exeBeforeSave(TbuttonModule t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String moduleid = StringUtils.trimToEmpty(request.getParameter("moduleid"));
//		String hql = "from " + Tmodule.class.getName() + " t where t."
//				+ Tmodule.ALIAS_RESOURCEID + " = ?";
//		Tmodule m = tmoduleService.getUniqueByHql(hql, new String[] { module });
		Tmodule m = tmoduleService.getEntityById(moduleid);
		t.setTmodule(m);
		m.getTbuttonModules().add(t);
		if(null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			//for 更新
			TbuttonModule tm = getBaseService().getEntityById(t.getResourceid());
			t.setTbuttonRoleModules(new HashSet<TbuttonRoleModule>(tm.getTbuttonRoleModules()));
		}
	}
}
