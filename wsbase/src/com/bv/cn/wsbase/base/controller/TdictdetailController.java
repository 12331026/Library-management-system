/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.model.Tdictdetail;
import com.bv.cn.wsbase.base.service.TdictService;
import com.bv.cn.wsbase.base.service.TdictdetailService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 字典明细
 */

@Controller
public class TdictdetailController extends AS1BaseController<Tdictdetail> {
	@Resource
	private TdictdetailService<Tdictdetail> tdictdetailService;
	@Resource
	private TdictService<Tdict> tdictService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tdictdetail> getBaseService() {
		return tdictdetailService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tdictdetail/Tdictdetail_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tdictdetail/Tdictdetail_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tdictdetail/Tdictdetail_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tdictdetail/Tdictdetail_form");
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String dictid = StringUtils.trimToEmpty(request.getParameter("dictid"));

		String hql = "from " + clazzName + " t ";
		List<String> params = new ArrayList<String>();
		if (!"".equals(dictid)) {
			hql += " where t." + Tdictdetail.ALIAS_TDICT + "."
					+ Tdict.ALIAS_RESOURCEID + " = ?";
			params.add(dictid);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
		if (isNewlink(request)) {
			request.setAttribute("dictid", dictid);
		}
	}

	@Override
	protected void exeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String dictid = StringUtils.trimToEmpty(request.getParameter("dictid"));
		final Tdict dict = tdictService.getEntityById(dictid);
		if ("sql".equals(StringUtils.trimToEmpty(dict.getSrctype()))) {
			try {
				String sql = StringUtils.trimToEmpty(dict.getSrcsql());
				Set<Tdictdetail> dds = jdbcTemplate.query(sql,
						new ResultSetExtractor<Set<Tdictdetail>>() {

							@Override
							public Set<Tdictdetail> extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								Set<Tdictdetail> dds = new HashSet<Tdictdetail>();
								while (rs.next()) {
									Tdictdetail dd = new Tdictdetail();
									dd.setDetailcode(rs.getString(1));
									dd.setDetailname(rs.getString(2));
									dd.setTdict(dict);
								}
								return dds;
							}

						});

				int pageSize = getPageSize(request);
				int pageIndex = getPageIndex(request);
				Pagelet pagelet = new Pagelet();
				List<Tdictdetail> alllist = new ArrayList<Tdictdetail>(dds);
				List<Tdictdetail> list = new ArrayList<Tdictdetail>();
				for (int i = Math.min(alllist.size(), (pageIndex-1) * pageSize); i < Math
						.min(alllist.size(), pageSize * (pageIndex)); i++) {
					list.add(alllist.get(i));
				}
				pagelet.setPageList(list);
				pagelet.setTotalRecord(alllist.size());
				request.setAttribute("totalRecord", String.valueOf(pagelet
						.getTotalRecord()));
				request.setAttribute("sublist", pagelet.getPageList());
			} catch (Exception exp) {
				this.logger.error(exp.getMessage());
				throw exp;
			}
		} else if ("dict".equals(StringUtils.trimToEmpty(dict.getSrctype()))) {
			try {
				int pageSize = getPageSize(request);
				int pageIndex = getPageIndex(request);

				Pagelet pagelet = null;

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

				request.setAttribute("totalRecord", String.valueOf(pagelet
						.getTotalRecord()));
				request.setAttribute("sublist", pagelet.getPageList());
			} catch (Exception exp) {
				this.logger.error(exp.getMessage());
				throw exp;
			}
		}
	}

	@Override
	protected void exeAfterEdit(Tdictdetail t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		if (null != t && null == t.getTdict()) {
			String dictid = StringUtils.trimToEmpty(request
					.getParameter("dictid"));
			Tdict tdict = tdictService.getEntityById(dictid);
			t.setTdict(tdict);
		}
	}

	@Override
	protected void exeBeforeSave(Tdictdetail t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String dictid = StringUtils.trimToEmpty(request.getParameter("dictid"));
		Tdict tdict = tdictService.getEntityById(dictid);
		t.setTdict(tdict);
		tdict.getTdictdetails().add(t);
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

			String dictid = StringUtils.trimToEmpty(request
					.getParameter("dictid"));
			;
			strPath = editUrl + "?dictid=" + dictid;
			strBuf.append(strPath);
			logger.info(strBuf.toString());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}

		return strBuf.toString();
	}

}
