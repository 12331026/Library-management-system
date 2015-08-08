/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.Writer;
import java.math.BigDecimal;

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
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Torder;
import com.bv.cn.wsbase.base.model.Tshopping;
import com.bv.cn.wsbase.base.service.TorderService;
import com.bv.cn.wsbase.base.service.TshoppingService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 购物管理
 */

@Controller
public class TshoppingController extends AS1BaseController<Tshopping> {
	@Resource
	private TshoppingService<Tshopping> tshoppingService;
	@Resource
	private TorderService<Torder> torderService;

	@Override
	public BvAppBaseService<Tshopping> getBaseService() {
		return tshoppingService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tshopping/Tshopping_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tshopping/Tshopping_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tshopping/Tshopping_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tshopping/Tshopping_form");
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

	@RequestMapping(value = "del", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void del(HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			String resid = StringUtils.trimToEmpty(request
					.getParameter("resid"));
			Tshopping s = getBaseService().getEntityById(resid);
			if (null != s) {
				getBaseService().delete(s);
			}
			Torder o = s.getTorder();
			o.getTshoppings().remove(s);
			BigDecimal amount = TgoodsController.countOrderAmount(o);
			o.setOrderamount(amount);
			torderService.updateEntity(o);
			json.put(SUCCESS, true);
			Writer w = response.getWriter();
			json.write(w);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			json.put(SUCCESS, false);
			json.put(ERRORMSG, e.toString());
		}
	}
}
