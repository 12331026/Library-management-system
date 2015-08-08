/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tcompanyinfo;
import com.bv.cn.wsbase.base.model.Tcustlink;
import com.bv.cn.wsbase.base.service.TcompanyinfoService;
import com.bv.cn.wsbase.base.service.TcustlinkService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 客户人员联系方式
 */

@Controller
public class TcustlinkController extends AS1BaseController<Tcustlink> {
	@Resource
	private TcustlinkService<Tcustlink> tcustlinkService;
	@Resource
	private TcompanyinfoService<Tcompanyinfo> tcompanyinfoService;

	@Override
	public BvAppBaseService<Tcustlink> getBaseService() {
		return tcustlinkService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tcustlink/Tcustlink_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tcustlink/Tcustlink_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tcustlink/Tcustlink_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tcustlink/Tcustlink_form");
	}

	@Override
	protected String _getDeleteForwardPath(HttpServletRequest request,
			ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		try {
			String editUrl = "redirect:/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/list."
					+ Constants.URL_PATTERN;

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
	protected void exeAfterEdit(Tcustlink t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String todo = StringUtils.trimToEmpty(request.getParameter("todo"));
		String comefrom = StringUtils.trimToEmpty(request.getParameter("comefrom"));
		request.setAttribute("comefrom", comefrom);
		if ("create".equals(todo)) {
			String companyinfoid = StringUtils.trimToEmpty(request
					.getParameter("companyinfoid"));
			Tcompanyinfo ci = tcompanyinfoService.getEntityById(companyinfoid);
			t.setTcompanyinfo(ci);
		}
	}

	protected void exeBeforeSave(Tcustlink t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String companyinfoid = StringUtils.trimToEmpty(request
				.getParameter("companyinfoid"));
		String comefrom = StringUtils.trimToEmpty(request.getParameter("comefrom"));
		request.setAttribute("comefrom", comefrom);
		Tcompanyinfo ci = tcompanyinfoService.getEntityById(companyinfoid);
		t.setTcompanyinfo(ci);
	}

	@RequestMapping(value = "updatemainlinker", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void updatemainlinker(String resourceid, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		logger.debug("step into updatemainlinker...");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		JSONObject json = new JSONObject();
		
		try {
			String comefrom = StringUtils.trimToEmpty(request.getParameter("comefrom"));
			Tcustlink t = getBaseService().getEntityById(resourceid);
			Tcompanyinfo ci = t.getTcompanyinfo();
			Set<Tcustlink> clSet = ci.getTcustlinks();
			for (Tcustlink cl : clSet) {
				if (cl.getResourceid().equals(t.getResourceid())) {
					cl.setIsmainlinker("Y");
				} else {
					cl.setIsmainlinker("N");
				}
				getBaseService().updateEntity(cl);
			}
			json.put(super.SUCCESS, true);
			json.put("comefrom", comefrom);
			logger.debug("updatemainlinker success");
		} catch (Exception e) {
			logger.error("updatemainlinker error!", e);
			json.put(super.SUCCESS, false);
		} finally {
			json.write(response.getWriter());
		}
	}

	@RequestMapping(value = "confirm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void confirm(String resourceid, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		logger.debug("step into confirm...");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		JSONObject json = new JSONObject();
		try {
			logger.info("resourceid=" + resourceid);
			Tcustlink t = getBaseService().getEntityById(resourceid);
			Tcustlink t2 = new Tcustlink();
			Tcompanyinfo ci = t.getTcompanyinfo();
			Tcompanyinfo ci2 = new Tcompanyinfo();

			PropertyUtils.copyProperties(ci2, ci);
			PropertyUtils.copyProperties(t2, t);
			
			Set<Tcustlink> set = new HashSet<Tcustlink>();
			set.add(t2);
			ci2.setTcustlinks(set);
			t2.setTcompanyinfo(null);
			json.put(super.SUCCESS, true);
			JSONObject jsobj = new JSONObject();
			jsobj.put("companyinfo", ci2);
			json.put(super.DATA, jsobj);
			logger.debug("confirm success");
		} catch (Exception e) {
			logger.error("confirm error!", e);
			json.put(super.SUCCESS, false);
		} finally {
			json.write(response.getWriter());
		}
	}
}
