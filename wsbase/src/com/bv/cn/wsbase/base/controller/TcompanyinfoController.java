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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tcompanyinfo;
import com.bv.cn.wsbase.base.model.Tcustlink;
import com.bv.cn.wsbase.base.service.TcompanyinfoService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 企业信息
 */

@Controller
public class TcompanyinfoController extends AS1BaseController<Tcompanyinfo> {
	@Resource
	private TcompanyinfoService<Tcompanyinfo> tcompanyinfoService;

	@Override
	public BvAppBaseService<Tcompanyinfo> getBaseService() {
		return tcompanyinfoService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_form");
	}

	@Override
	protected String _getDeleteForwardPath(HttpServletRequest request,
			ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		try {
			String comefrom = StringUtils.trimToEmpty(request
					.getParameter("comefrom"));
			String editUrl = "redirect:/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/list."
					+ Constants.URL_PATTERN;

			if ("select".equals(comefrom)) {
				editUrl += "?comefrom=select";
			}

			strPath = editUrl;
			strBuf.append(strPath);
			logger.info(strBuf.toString());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}

		return strBuf.toString();
	}
	
	@Override
	protected String _getSaveForwardPath(HttpServletRequest request,
			String resourceid, String useType, ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		try {
			String editUrl = "/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/edit."
					+ Constants.URL_PATTERN;
			strPath = editUrl + "?todo=show&resourceid=" + resourceid;
			if ("select".equals(comefrom)) {
				strPath += "&comefrom=select";
			}
			strBuf.append(strPath);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}

		return strBuf.toString();
	}
	
	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String comptype = StringUtils.trimToEmpty(request
				.getParameter("comptype"));
		String compname = StringUtils.trimToEmpty(request
				.getParameter("compname"));
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		logger.info("comptype=" + comptype);
		logger.info("compname=" + compname);
		String hql = "from " + clazzName + " t where 1=1 ";
		List<String> params = new ArrayList<String>();
		if (!"".equals(comptype)) {
			hql += " and t." + Tcompanyinfo.ALIAS_COMPTYPE + " = ? ";
			params.add(comptype);
		}
		if (!"".equals(compname)) {
			hql += " and t." + Tcompanyinfo.ALIAS_COMPNAME
					+ " like '%' || ? || '%' ";
			params.add(compname);
		}
		String orderBy = " order by t." + Tcompanyinfo.ALIAS_SHOWORDER;
		// request.setAttribute(BvConstants.QUERY_HQL, hql+orderBy);
		request.setAttribute(BvConstants.QUERY_HQL, hql);
		request.setAttribute(BvConstants.QUERY_PARAM, params);

		if ("select".equals(comefrom)) {
			super.setListPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_select_list");
			super
					.setListChildPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_select_list_child");
		} else {
			super.setListPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_list");
			super
					.setListChildPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_list_child");

		}

	}

	@Override
	protected void exeAfterEdit(Tcompanyinfo t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		request.setAttribute("sublist", t.getTcustlinks());
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("select".equals(comefrom)) {
			super
					.setEditPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_select_edit");
			super.setFormPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_select_form");
		} else {
			super
					.setEditPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_edit");
			super.setFormPagePath("wsbase/Tcompanyinfo/Tcompanyinfo_form");
		}
	}

	@Override
	protected void exeBeforeSave(Tcompanyinfo t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request.getParameter("comefrom"));
		request.setAttribute("comefrom", comefrom);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			Tcompanyinfo t2 = getBaseService().getEntityById(
					StringUtils.trimToEmpty(t.getResourceid()));
			Set<Tcustlink> cl = new HashSet<Tcustlink>(t2.getTcustlinks());
			t.setTcustlinks(cl);
		}
	}

//	@RequestMapping(value = "selectlist", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
//	public final ModelAndView selectlist(HttpServletRequest request,
//			HttpServletResponse response, SessionStatus sessionStatus,
//			ModelMap modelMap) throws Exception {
//		ModelAndView mav = null;
//		try {
//			exeBeforeList(request, response, sessionStatus, modelMap);
//			if (isNewlink(request)) {
//				mav = new ModelAndView(
//						"wsbase/Tcompanyinfo/Tcompanyinfo_select_list");
//			} else {
//				exeList(request, response, sessionStatus, modelMap);
//				mav = new ModelAndView(
//						"wsbase/Tcompanyinfo/Tcompanyinfo_select_list_child");
//			}
//		} catch (BvBaseServiceException e) {
//			throw e;
//		} catch (Exception e) {
//			logger.error(e.toString());
//			throw new BaseActionException("查询列表出错！", e);
//		}
//		return mav;
//	}

}
