/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.tsjylib.base.model.Tbookinfo;
import com.bv.cn.tsjylib.base.model.Tborrowbook;
import com.bv.cn.tsjylib.base.service.TbookinfoService;
import com.bv.cn.tsjylib.base.service.TborrowbookService;
import com.bv.cn.wsbase.base.controller.AS1BaseController;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module
 */

@Controller
public class TborrowbookController extends AS1BaseController<Tborrowbook> {
	@Resource
	private TborrowbookService<Tborrowbook> tborrowbookService;
	@Resource
	private TuserService<Tuser> tuserService;
	@Resource
	private TbookinfoService<Tbookinfo> tbookinfoService;

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tborrowbook> getBaseService() {
		return tborrowbookService;
	}

	public void setListPagePath() {
		super.setListPagePath("tsjylib/Tborrowbook/Tborrowbook_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("tsjylib/Tborrowbook/Tborrowbook_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("tsjylib/Tborrowbook/Tborrowbook_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("tsjylib/Tborrowbook/Tborrowbook_form");
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
	protected void exeBeforeSave(Tborrowbook t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// TODO Auto-generated method stub
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);

		String borrowuserid = StringUtils.trimToEmpty(request
				.getParameter("borrowuserid"));
		String bookinfoid = StringUtils.trimToEmpty(request
				.getParameter("bookinfoid"));
		Tuser u = tuserService.getEntityById(borrowuserid);
		Tbookinfo bi = tbookinfoService.getEntityById(bookinfoid);
		String resid = StringUtils.trimToEmpty(getResid(t, request));
		modelMap.put("tuser", u);
		modelMap.put("tbookinfo", bi);

		if (resid.isEmpty()) {
			// 新增
			if(u.getTborrowbooks().size()>=4) {
				throw new com.bv.cn.base.controller.BaseActionException(
						"该学生已经借了4本书，暂时不能再借阅新书籍！");
			}
			t.setTuser(u);
			if(bi.getLeftcount()<=0) {
				throw new com.bv.cn.base.controller.BaseActionException(
						"书籍剩余数量为0！");
			}
			bi.setLeftcount(bi.getLeftcount() - 1);
			
			t.setTbookinfo(bi);
			u.getTborrowbooks().add(t);
			bi.getTborrowbooks().add(t);
		}/* else {
			t = getBaseService().getEntityById(resid);
			t.setTuser(u);
			t.setTbookinfo(bi);
			u.getTborrowbooks().add(t);
			bi.getTborrowbooks().add(t);
		}*/

		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from "
					+ Tborrowbook.TABLE_ALIAS + " t";
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

	@Override
	protected void exeAfterSave(Tborrowbook t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// TODO Auto-generated method stub
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
		//
		// Tuser u = (Tuser) modelMap.get("tuser");
		 Tbookinfo bi = (Tbookinfo) modelMap.get("tbookinfo");
		//
		// t.setTuser(u);
		// t.setTbookinfo(bi);
		// u.getTborrowbooks().add(t);
		// bi.getTborrowbooks().add(t);
		// tuserService.mergeEntity(u);
		 tbookinfoService.updateEntity(bi);
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// TODO Auto-generated method stub
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String borrowuserlogonid = StringUtils.trimToEmpty(request
				.getParameter("borrowuserlogonid"));
		String booktype = StringUtils.trimToEmpty(request
				.getParameter("booktype"));
		String bookcode = StringUtils.trimToEmpty(request
				.getParameter("bookcode"));
		String bookname = StringUtils.trimToEmpty(request
				.getParameter("bookname"));
		String hql = "from " + clazzName + " t where 1=1 ";
		String orderBy = " order by t." + Tborrowbook.ALIAS_SHOWORDER
				+ " desc ";
		List<Object> params = new ArrayList<Object>();
		if (!borrowuserlogonid.isEmpty()) {
			Tuser u = tuserService.getUniqueByHql(
					"from " + Tuser.class.getName() + " t where t."
							+ Tuser.ALIAS_VCCODE + " = ?",
					new String[] { borrowuserlogonid });
			if (null == u) {
				throw new com.bv.cn.base.controller.BaseActionException(
						"未找到用戶登录ID对应的用户信息");
			}
			if (!borrowuserlogonid.isEmpty()) {
				hql += " and t." + Tborrowbook.ALIAS_BORROWUSER + "."
						+ Tuser.ALIAS_RESOURCEID + " = '" + u.getResourceid()
						+ "' ";
			}
		}
		if (!booktype.isEmpty()) {
			hql += " and t." + Tborrowbook.ALIAS_BOOK + "."
					+ Tbookinfo.ALIAS_BOOKTYPE + " = '" + booktype + "' ";
		}
		if (!bookcode.isEmpty()) {
			hql += " and t." + Tborrowbook.ALIAS_BOOK + "."
					+ Tbookinfo.ALIAS_BOOKCODE + " like '%' || ? || '%' ";
			params.add(bookcode);
		}
		if (!bookname.isEmpty()) {
			hql += " and t." + Tborrowbook.ALIAS_BOOK + "."
					+ Tbookinfo.ALIAS_BOOKNAME + " like '%' || ? || '%' ";
			params.add(bookname);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
		request.setAttribute(BvConstants.QUERY_PARAM, params);

	}
	@Override
	protected void exeBeforeDelete(String[] resourceIds,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		try {
			String[] ids = resourceIds;
			if ((ids == null) || (ids.length <= 0))
				return;
			for(String id : ids) {
				Tborrowbook bb = this.getBaseService().getEntityById(id);
				if(null != bb) {
					Tbookinfo bi = bb.getTbookinfo();
					bi.setLeftcount(bi.getLeftcount()+1);
					tbookinfoService.updateEntity(bi);
				}
			}
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}
}
