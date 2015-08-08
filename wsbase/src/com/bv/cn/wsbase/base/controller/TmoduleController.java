/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.service.TmoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 模块
 */

@Controller
public class TmoduleController extends AS1BaseController<Tmodule> {
	@Resource
	private TmoduleService<Tmodule> tmoduleService;

	@Override
	public BvAppBaseService<Tmodule> getBaseService() {
		return tmoduleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tmodule/tmodule_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tmodule/tmodule_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tmodule/tmodule_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tmodule/tmodule_form");
	}

	@RequestMapping(value = "listmodule", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView listmodule(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			try {
				int pageSize = getPageSize(request);
				int pageIndex = getPageIndex(request);

				String hql = "from " + clazzName + " t where t."
						+ Tmodule.ALIAS_TMODULE + "."
						+ Tmodule.ALIAS_RESOURCEID + " is not null";
				String orderBy = " order by t." + Tmodule.ALIAS_SHOWORDER;
				List<Tmodule> list = getBaseService().getListsByHql(
						hql + orderBy, new Object[0]);

				request.setAttribute("list", list);
				mav = new ModelAndView("wsbase/Tmodule/listmodule");
			} catch (Exception exp) {
				this.logger.error(exp.getMessage());
				throw exp;
			}

		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}

	@RequestMapping(value = "listmodule4button", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView listmodule4button(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			try {

				String hql = "from " + clazzName + " t where t."
						+ Tmodule.ALIAS_TMODULE + "."
						+ Tmodule.ALIAS_RESOURCEID + " is not null";
				String orderBy = " order by t." + Tmodule.ALIAS_SHOWORDER;
				List<Tmodule> list = getBaseService().getListsByHql(
						hql + orderBy, new Object[0]);

				request.setAttribute("list", list);
				mav = new ModelAndView("wsbase/Tmodule/listmodule4button");
			} catch (Exception exp) {
				this.logger.error(exp.getMessage());
				throw exp;
			}

		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}

	@RequestMapping(value = "listmodule4formvalidate", method = {
			RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listmodule4formvalidate(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			try {

				String hql = "from " + clazzName + " t where t."
						+ Tmodule.ALIAS_TMODULE + "."
						+ Tmodule.ALIAS_RESOURCEID + " is not null";
				String orderBy = " order by t." + Tmodule.ALIAS_SHOWORDER;
				List<Tmodule> list = getBaseService().getListsByHql(
						hql + orderBy, new Object[0]);

				request.setAttribute("list", list);
				mav = new ModelAndView("wsbase/Tmodule/listmodule4formvalidate");
			} catch (Exception exp) {
				this.logger.error(exp.getMessage());
				throw exp;
			}

		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}
}
