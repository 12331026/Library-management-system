/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.bv.cn.back.base.model.Tpublishtype;
import com.bv.cn.back.base.service.TpublishtypeService;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.controller.AS1BaseController;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告类型
 */

@Controller
public class TpublishtypeController extends AS1BaseController<Tpublishtype> {
	@Resource
	private TpublishtypeService<Tpublishtype> tpublishtypeService;

	@Override
	public BvAppBaseService<Tpublishtype> getBaseService() {
		return tpublishtypeService;
	}

	public void setListPagePath() {
		super.setListPagePath("back/Tpublishtype/Tpublishtype_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("back/Tpublishtype/Tpublishtype_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("back/Tpublishtype/Tpublishtype_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("back/Tpublishtype/Tpublishtype_form");
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
}
