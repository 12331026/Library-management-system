/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tdepartment;
import com.bv.cn.wsbase.base.model.Tudcommon;
import com.bv.cn.wsbase.base.service.TdepartmentService;
import com.bv.cn.wsbase.base.service.TudcommonService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 部门
 */

@Controller
public class TdepartmentController extends AS1BaseController<Tdepartment> {
	@Resource
	private TdepartmentService<Tdepartment> tdepartmentService;

	@Resource(name = "tudcommonService")
	private TudcommonService<Tudcommon> tudcommonService;

	@Override
	public BvAppBaseService<Tdepartment> getBaseService() {
		return tdepartmentService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tdepartment/Tdepartment_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tdepartment/Tdepartment_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tdepartment/Tdepartment_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tdepartment/Tdepartment_form");
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
	protected void exeBeforeSave(Tdepartment t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String resourceid = StringUtils.trimToEmpty(getResid(t, request));
		Tdepartment d = getBaseService().getEntityById(resourceid);
		if (null != d) {
			t.setTudcommons(d.getTudcommons());
		}
		String tudcommonresourceid = StringUtils.trimToEmpty(request
				.getParameter("tudcommonresourceid"));
		if (!"".equals(tudcommonresourceid)) {
			Tudcommon udc = tudcommonService.getEntityById(tudcommonresourceid);
			t.setTudcommon(udc);
			udc.getTudcommons().add(t);
		}
	}

	@Override
	protected void exeAfterSave(Tdepartment t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
		// t = getBaseService().getEntityById(t.getResourceid());
		StringBuffer[] sbArr = new StringBuffer[2];
		sbArr[0] = new StringBuffer();
		sbArr[1] = new StringBuffer();
		String[] strArr = getFullPath(t, sbArr);
		t.setFullpath(strArr[0]);
		t.setBelongpath(strArr[1]);
		t = getBaseService().mergeEntity(t);
	}
}
