/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.model.OptionModel;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.model.Tdictdetail;
import com.bv.cn.wsbase.base.service.TdictService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 字典定义
 */

@Controller
public class TdictController extends AS1BaseController<Tdict> {
	@Resource
	private TdictService<Tdict> tdictService;

	@Override
	public BvAppBaseService<Tdict> getBaseService() {
		return tdictService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tdict/Tdict_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tdict/Tdict_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tdict/Tdict_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tdict/Tdict_form");
	}

	public TdictController() {
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
			// exeBeforeList(request, response, sessionStatus, modelMap);
			if (isFrame.equals("Y")) {
				mav = new ModelAndView("wsbase/Tdict/Tdict_list_frame");
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
			hql += " where t." + Tdict.ALIAS_MODULE + " = ?";
			params.add(module);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
		if (isNewlink(request)) {
			request.setAttribute("module", module);
		}
	}

	@Override
	protected void exeBeforeSave(Tdict t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		// String modulecode = StringUtils.trimToEmpty(request
		// .getParameter("modulecode"));
		// t.setModule(modulecode);
	}

	@Override
	protected void exeAfterEdit(Tdict t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		if (StringUtils.trimToEmpty(t.getModule()).equals("")) {
			String module = StringUtils.trimToEmpty(request
					.getParameter("module"));
			t.setModule(module);
		}
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

			String module = StringUtils.trimToEmpty(request
					.getParameter("module"));
			strPath = editUrl + "?module=" + module;
			strBuf.append(strPath);
			logger.info(strBuf.toString());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}

		return strBuf.toString();
	}

	@RequestMapping(value = "getsubdict", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void getsubdict(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		try {
			super.setContentType4Json(request, response);
			String prefix = StringUtils.trimToEmpty(request
					.getParameter("prefix"));
			String cdictKey = StringUtils.trimToEmpty(request
					.getParameter("cdictKey"));
			String hql = "from " + Tdict.class.getName() + " t where t."
					+ Tdict.ALIAS_DICTCODE + " = ?";
			Tdict cdict = tdictService.getUniqueByHql(hql,
					new String[] { cdictKey });
			Set<Tdictdetail> cdictdetails = cdict.getTdictdetails();
			List<OptionModel> cdictdetaillist = new ArrayList<OptionModel>();
			for (Tdictdetail dd : cdictdetails) {
				if (dd.getDetailcode().startsWith(prefix + "-")) {
					OptionModel m = new OptionModel();
					m.setValue(dd.getDetailcode());
					m.setText(dd.getDetailname());
					cdictdetaillist.add(m);
				}
			}
			jsonArr = JSONArray.fromObject(cdictdetaillist);
			json.put(super.SUCCESS, true);
			json.put(super.DATA, jsonArr);
			logger.debug("getsubdict success");
		} catch (Exception e) {
			logger.error("getsubdict error!", e);
			json.put(super.SUCCESS, false);
		} finally {
			json.write(response.getWriter());
		}
	}

}
