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
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tshowarea;
import com.bv.cn.wsbase.base.service.TshowareaService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 显示区域管理
 */

@Controller
public class TshowareaController extends AS1BaseController<Tshowarea> {
	@Resource
	private TshowareaService<Tshowarea> tshowareaService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tshowarea> getBaseService() {
		return tshowareaService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tshowarea/Tshowarea_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tshowarea/Tshowarea_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tshowarea/Tshowarea_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tshowarea/Tshowarea_form");
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
		String hql = "from " + clazzName + " t where t."
				+ Tshowarea.ALIAS_FLG_DELETED + " = ? ";
		String orderBy = " order by t." + Tshowarea.ALIAS_SHOWORDER + " asc ";

		List<String> params = new ArrayList<String>();
		params.add(Constants.FLGDELETED_NO);
		request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
	}

	@Override
	protected void exeBeforeSave(Tshowarea t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from "
					+ Tshowarea.TABLE_ALIAS + " t";
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
