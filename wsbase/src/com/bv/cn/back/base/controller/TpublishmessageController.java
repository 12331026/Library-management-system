/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.back.base.model.Tpublishmessage;
import com.bv.cn.back.base.model.Tpublishtype;
import com.bv.cn.back.base.service.TpublishmessageService;
import com.bv.cn.back.base.service.TpublishtypeService;
import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.controller.AS1BaseController;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告信息管理
 */

@Controller
public class TpublishmessageController extends
		AS1BaseController<Tpublishmessage> {
	@Resource
	private TpublishmessageService<Tpublishmessage> tpublishmessageService;
	@Resource
	private TpublishtypeService<Tpublishtype> tpublishtypeService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tpublishmessage> getBaseService() {
		return tpublishmessageService;
	}

	public void setListPagePath() {
		super.setListPagePath("back/Tpublishmessage/Tpublishmessage_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("back/Tpublishmessage/Tpublishmessage_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("back/Tpublishmessage/Tpublishmessage_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("back/Tpublishmessage/Tpublishmessage_form");
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
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("frontview".equals(comefrom)) {
			// 前台视图
			super
					.setListPagePath("front/Tpublishmessage/Tpublishmessage_list");
			super
					.setListChildPagePath("front/Tpublishmessage/Tpublishmessage_list_child");
		} else {
			super
					.setListPagePath("back/Tpublishmessage/Tpublishmessage_list");
			super
					.setListChildPagePath("back/Tpublishmessage/Tpublishmessage_list_child");
		}
	}

	@Override
	protected void exeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			int pageSize = getPageSize(request);
			int pageIndex = getPageIndex(request);

			Pagelet pagelet = null;
			String comefrom = StringUtils.trimToEmpty(request
					.getParameter("comefrom"));
			if ("frontview".equals(comefrom)) {
				String hql = "from " + Tpublishtype.class.getName() + " t ";
				String orderBy = " order by t." + Tpublishtype.ALIAS_VCTYPE
						+ " asc, t." + Tpublishtype.ALIAS_RESOURCEID + " asc ";

				pagelet = getBaseService().findPageByHql(hql + orderBy,
						pageSize, pageIndex, new Object[0]);
			} else {
				String hql = (String) request
						.getAttribute(BvConstants.QUERY_HQL);
				if (null == hql || "".equals(hql.trim())) {
					pagelet = getBaseService().findPageByHql(
							"from " + clazzName, pageSize, pageIndex);
				} else {
					List<Object> params = (List<Object>) request
							.getAttribute(BvConstants.QUERY_PARAM);

					pagelet = getBaseService().findPageByHql(hql, pageSize,
							pageIndex, params);
				}
			}
			request.setAttribute("totalRecord", String.valueOf(pagelet
					.getTotalRecord()));
			request.setAttribute("sublist", pagelet.getPageList());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}

	}

	@Override
	protected void exeAfterEdit(Tpublishmessage t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("frontedit".equals(comefrom)) {
			super
					.setEditPagePath("front/Tpublishmessage/Tpublishmessage_edit");
			super
					.setFormPagePath("front/Tpublishmessage/Tpublishmessage_form");
		} else {
			super
					.setEditPagePath("back/Tpublishmessage/Tpublishmessage_edit");
			super
					.setFormPagePath("back/Tpublishmessage/Tpublishmessage_form");
		}
	}

	@Override
	protected void exeBeforeSave(Tpublishmessage t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String publishtypevctype = StringUtils.trimToEmpty(request
				.getParameter("publishtypevctype"));
		String hql = "from " + Tpublishtype.class.getName() + " t where t."
				+ Tpublishtype.ALIAS_VCTYPE + " = ? ";
		Tpublishtype type = tpublishtypeService.getUniqueByHql(hql,
				publishtypevctype);
		t.setTpublishtype(type);
		type.getTpublishmessages().add(t);
		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from "
					+ Tpublishmessage.TABLE_ALIAS + " t";
			Integer maxShoworder = jdbcTemplate.query(sql,
					new ResultSetExtractor<Integer>() {

						@Override
						public Integer extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							if (rs.next()) {
								return rs.getInt(1);
							}
							return 0;
						}

					});
			t.setShoworder(maxShoworder + 1);
		}
	}
}
