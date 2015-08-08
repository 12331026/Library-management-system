/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.controller;

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

import com.bv.cn.back.base.model.Tmessage;
import com.bv.cn.back.base.service.TmessageService;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.controller.AS1BaseController;
import com.bv.cn.wsbase.base.controller.TuserController;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 留言消息
 */

@Controller
public class TmessageController extends AS1BaseController<Tmessage> {
	@Resource
	private TuserService<Tuser> tuserService;
	@Resource
	private TmessageService<Tmessage> tmessageService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tmessage> getBaseService() {
		return tmessageService;
	}

	public void setListPagePath() {
		super.setListPagePath("back/Tmessage/Tmessage_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("back/Tmessage/Tmessage_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("back/Tmessage/Tmessage_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("back/Tmessage/Tmessage_form");
	}

	@Override
	protected String _getDeleteForwardPath(HttpServletRequest request,
			ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		String resstatus = StringUtils.trimToEmpty(request
				.getParameter("resstatus"));
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		try {
			String editUrl = "redirect:/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/list."
					+ Constants.URL_PATTERN;
			if (!resstatus.isEmpty()) {
				editUrl += "?resstatus=" + resstatus;
			}
			if (!comefrom.isEmpty()) {
				editUrl += "?comefrom=" + comefrom;
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
			strPath += "&comefrom=" + comefrom;
			strBuf.append(strPath);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}
		// logger.info(strBuf.toString());
		return strBuf.toString();
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String resstatus = StringUtils.trimToEmpty(request
				.getParameter("resstatus"));
		String usersrc = StringUtils.trimToEmpty(request
				.getParameter("usersrc"));
		LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
				Constants.LOGONVO);

		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) {// 前台
			setListPagePath("front/Tmessage/Tmessage_list");
			setListChildPagePath("front/Tmessage/Tmessage_list_child");
			String hql = "from " + clazzName + " t where t."
					+ Tmessage.ALIAS_MSGSRC + "." + Tuser.ALIAS_RESOURCEID
					+ " = ? ";
			String orderBy = " order by t." + Tmessage.ALIAS_SHOWORDER
					+ " desc ";
			List<String> params = new ArrayList<String>();
			params.add(logonVO.getUserid());
			if (!resstatus.isEmpty()) {
				hql += " and t." + Tmessage.ALIAS_RESSTATUS + " = ? ";
				params.add(resstatus);
			}
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);
		} else { // 后台
			setListPagePath("back/Tmessage/Tmessage_list");
			setListChildPagePath("back/Tmessage/Tmessage_list_child");
			String hql = "from " + clazzName + " t where t."
					+ Tmessage.ALIAS_MSGDEST + "." + Tuser.ALIAS_RESOURCEID
					+ " = ? ";
			String orderBy = " order by t." + Tmessage.ALIAS_SHOWORDER
					+ " desc ";
			List<String> params = new ArrayList<String>();
			params.add(logonVO.getUserid());
			if (!resstatus.isEmpty()) {
				hql += " and t." + Tmessage.ALIAS_RESSTATUS + " = ? ";
				params.add(resstatus);
			}
			if (!usersrc.isEmpty()) {
				hql += " and t." + Tmessage.ALIAS_MSGSRC + "."
						+ Tuser.ALIAS_VCCODE + " = ? ";
				params.add(usersrc);
			}
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);
		}
	}

	@Override
	protected void exeAfterEdit(Tmessage t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) { // for frontend
			setEditPagePath("front/Tmessage/Tmessage_edit");
			setFormPagePath("front/Tmessage/Tmessage_form");
		} else { // for backend edit
			setEditPagePath("back/Tmessage/Tmessage_edit");
			setFormPagePath("back/Tmessage/Tmessage_form");
			String replyresourceid = StringUtils.trimToEmpty(request
					.getParameter("replyresourceid"));
			if (!replyresourceid.isEmpty()) {
				Tmessage pmsg = getBaseService().getEntityById(replyresourceid);
				Tuser psrcUser = pmsg.getTusersrc();
				t.setTuserdest(psrcUser);
				// srcUser.getTmessagedests().add(t);
				t.setTmessage(pmsg);
			}
		}

	}

	@Override
	protected void exeBeforeSave(Tmessage t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String resourceid = getResid(t, request);
		modelMap.put("resourceid", resourceid);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) {// 前台
			// String messagebodyfront = StringUtils.trimToEmpty(request
			// .getParameter("messagebodyfront"));
			// t.setMessagebody(messagebodyfront);
			t.setResstatus(WSConstants.TMESSAGE_REPLYSTATUS_DHF);
		} else {// 后台
			t.setResstatus(WSConstants.TMESSAGE_REPLYSTATUS_YHF);
		}
		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from " + Tmessage.TABLE_ALIAS
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

	@Override
	protected void exeAfterSave(Tmessage t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
		String msgdestid = StringUtils.trimToEmpty(request
				.getParameter("msgdestid"));
		String parentid = StringUtils.trimToEmpty(request
				.getParameter("parentid"));
		LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
				Constants.LOGONVO);
		String resourceid = (String) modelMap.get("resourceid");
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) {// 前台 新增
			Tuser destUser = tuserService
					.getEntityById(TuserController.topResid);
			Tuser currUser = tuserService.getEntityById(logonVO.getUserid());
			t.setTuserdest(destUser);
			t.setTusersrc(currUser);
			destUser.getTmessagedests().add(t);
			currUser.getTmessagesrcs().add(t);
			tuserService.updateEntity(currUser);
			tuserService.updateEntity(destUser);
			getBaseService().updateEntity(t);
		} else {// 后台
			if (resourceid == null || "".equals(resourceid)) {// 新增回复
				Tuser currUser = tuserService
						.getEntityById(logonVO.getUserid());
				Tuser userdest = tuserService.getEntityById(msgdestid);
				Tmessage pmsg = getBaseService().getEntityById(parentid);
				t.setTmessage(pmsg);
				pmsg.getTmessages().add(t);
				pmsg.setResstatus(WSConstants.TMESSAGE_REPLYSTATUS_YHF);// 已回复
				t.setTuserdest(userdest);
				userdest.getTmessagedests().add(t);
				t.setTusersrc(currUser);
				currUser.getTmessagesrcs().add(t);
				tuserService.updateEntity(userdest);
				tuserService.updateEntity(currUser);
				getBaseService().updateEntity(pmsg);
				getBaseService().updateEntity(t);
			}
		}
	}

	@Override
	protected void exeDelete(String[] resourceIds, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			String[] ids = resourceIds;
			if ((ids == null) || (ids.length <= 0)) {
				return;
			}
			for (String id : ids) {
				Tmessage m = getBaseService().getEntityById(id);
				m.setResstatus(WSConstants.TMESSAGE_REPLYSTATUS_DEL);
				getBaseService().updateEntity(m);
			}
			// this.getBaseService().delEntitys(ids);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

}
