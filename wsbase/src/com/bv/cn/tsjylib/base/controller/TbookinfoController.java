/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.tsjylib.base.model.Tbookinfo;
import com.bv.cn.tsjylib.base.model.Tborrowbook;
import com.bv.cn.tsjylib.base.service.TbookinfoService;
import com.bv.cn.wsbase.base.controller.AS1BaseController;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module
 */

@Controller
public class TbookinfoController extends AS1BaseController<Tbookinfo> {
	@Resource
	private TbookinfoService<Tbookinfo> tbookinfoService;

	@Override
	public BvAppBaseService<Tbookinfo> getBaseService() {
		return tbookinfoService;
	}

	public void setListPagePath() {
		super.setListPagePath("tsjylib/Tbookinfo/Tbookinfo_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("tsjylib/Tbookinfo/Tbookinfo_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("tsjylib/Tbookinfo/Tbookinfo_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("tsjylib/Tbookinfo/Tbookinfo_form");
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
	protected void exeBeforeSave(Tbookinfo t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			// for 更新
			Tbookinfo tb = getBaseService().getEntityById(t.getResourceid());
			t.setTborrowbooks(new HashSet<Tborrowbook>(tb.getTborrowbooks()));
		}
	}

	@Override
	protected void exeAfterSave(Tbookinfo t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
		// t = getBaseService().getEntityById(t.getResourceid());
		// StringBuffer[] sbArr = new StringBuffer[2];
		// sbArr[0] = new StringBuffer();
		// sbArr[1] = new StringBuffer();
		// String[] strArr = getFullPath(t, sbArr);
		// t.setFullpath(strArr[0]);
		// t.setBelongpath(strArr[1]);
		// t = getBaseService().mergeEntity(t);

	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// TODO Auto-generated method stub
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		String booktype = StringUtils.trimToEmpty(request
				.getParameter("booktype"));
		String bookcode = StringUtils.trimToEmpty(request
				.getParameter("bookcode"));
		String bookname = StringUtils.trimToEmpty(request
				.getParameter("bookname"));
		String hql = "from " + clazzName + " t where 1=1 ";
		String orderBy = " order by t." + Tbookinfo.ALIAS_SHOWORDER + " desc ";
		List<Object> params = new ArrayList<Object>();
		if (!booktype.isEmpty()) {
			hql += " and t." + Tbookinfo.ALIAS_BOOKTYPE + " = '" + booktype
					+ "' ";
		}
		if (!bookcode.isEmpty()) {
			hql += " and t." + Tbookinfo.ALIAS_BOOKCODE
					+ " like '%' || ? || '%' ";
			params.add(bookcode);
		}
		if (!bookname.isEmpty()) {
			hql += " and t." + Tbookinfo.ALIAS_BOOKNAME
					+ " like '%' || ? || '%' ";
			params.add(bookname);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
		if ("select".equals(comefrom)) {
			super.setListPagePath("tsjylib/Tbookinfo/Tbookinfo_select_list");
		} else {
			super.setListPagePath("tsjylib/Tbookinfo/Tbookinfo_list");
		}
	}

	@RequestMapping(value = "getById", method = { RequestMethod.GET })
	public final void getById(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String resid = StringUtils.trimToEmpty(request.getParameter("resid"));
		JSONObject json = new JSONObject();
		try {
			if (!StringUtils.trimToEmpty(resid).isEmpty()) {
				Tbookinfo t = getBaseService().getEntityById(
						StringUtils.trimToEmpty(resid));
				t.setTborrowbooks(new HashSet<Tborrowbook>());
				json.put("data", JSONObject.fromObject(t));
			}
			json.put(SUCCESS, "true");
		} catch (Exception e) {
			logger.error("getById出错!", e);
			json.put(SUCCESS, "false");
			json.put(ERRORMSG, e.getMessage());
		} finally {
			json.write(response.getWriter());
		}
	}

	@Override
	protected void exeBeforeDelete(String[] resourceIds,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		super.exeBeforeDelete(resourceIds, request, response, sessionStatus,
				modelMap);
		try {
			String[] ids = resourceIds;
			if ((ids == null) || (ids.length <= 0))
				return;
			for (String id : ids) {
				Tbookinfo bi = this.getBaseService().getEntityById(id);
				if (null != bi) {
					if (bi.getTborrowbooks().size() > 0) {
						throw new com.bv.cn.base.controller.BaseActionException(
								"该书籍存在借阅信息，现在不能删除。请在删除了借阅信息后尝试删除书籍信息。");
					}
				}
			}
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

}
