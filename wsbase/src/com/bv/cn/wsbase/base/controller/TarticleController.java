/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tareaarticle;
import com.bv.cn.wsbase.base.model.Tarticle;
import com.bv.cn.wsbase.base.model.Tshowarea;
import com.bv.cn.wsbase.base.service.TareaarticleService;
import com.bv.cn.wsbase.base.service.TarticleService;
import com.bv.cn.wsbase.base.service.TshowareaService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 文章编辑管理
 */

@Controller
public class TarticleController extends AS1BaseController<Tarticle> {
	@Resource
	private TarticleService<Tarticle> tarticleService;
	@Resource
	private TareaarticleService<Tareaarticle> tareaarticleService;
	@Resource
	private TshowareaService<Tshowarea> tshowareaService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tarticle> getBaseService() {
		return tarticleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tarticle/Tarticle_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tarticle/Tarticle_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tarticle/Tarticle_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tarticle/Tarticle_form");
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
	protected void exeAfterEdit(Tarticle t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String hql = "from " + Tshowarea.class.getName() + " t where t."
				+ Tshowarea.ALIAS_FLG_DELETED + " = 'N' ";
		String orderBy = " order by t." + Tshowarea.ALIAS_SHOWORDER;
		List<Tshowarea> sublist = tshowareaService.getListsByHql(hql + orderBy,
				new Object[0]);
		request.setAttribute("sublist", sublist);
		// List<Trolemodule> rmlist = new ArrayList<Trolemodule>();
		// if (null != t &&
		// !StringUtils.trimToEmpty(t.getRolecode()).equals("")) {
		// String hql2 = "from " + Trolemodule.class.getName() + " t where t."
		// + Trolemodule.ALIAS_ROLE + "." + Trole.ALIAS_ROLECODE
		// + " = ?";
		// rmlist = trolemoduleService.getListsByHql(hql2,
		// new String[] { StringUtils.trimToEmpty(t.getRolecode()) });
		// }
		// request.setAttribute("rmlist", rmlist);
	}

	@Override
	protected void exeBeforeSave(Tarticle t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			Tarticle t2 = getBaseService().getEntityById(
					StringUtils.trimToEmpty(t.getResourceid()));
			Set<Tareaarticle> aas = new HashSet<Tareaarticle>(t2
					.getTareaarticles());
			aas.size();
			t.setTareaarticles(aas);
		}
		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from " + Tarticle.TABLE_ALIAS
					+ " t";
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

	@RequestMapping(value = "view", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			String resourceid = StringUtils.trimToEmpty(request
					.getParameter("resourceid"));
			String areacode = StringUtils.trimToEmpty(request
					.getParameter("areacode"));
			if (!areacode.isEmpty()) {
				Tarticle t = exeEdit(request, resourceid);
				// exeAfterEdit(t, request, response, sessionStatus, modelMap);
				mav = new ModelAndView("wsbase/Tarticle/Tarticle_showarea_"
						+ areacode + "_view");
				mav.addObject("custForm", t);
			}
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查看出错！", e);
		}
		return mav;
	}

	@RequestMapping(value = "testareacode01", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView testareacode01(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			// exeAfterEdit(t, request, response, sessionStatus, modelMap);
			mav = new ModelAndView(
					"wsbase/Tarticle/Tarticle_showarea_test_areacode01");
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}
}
