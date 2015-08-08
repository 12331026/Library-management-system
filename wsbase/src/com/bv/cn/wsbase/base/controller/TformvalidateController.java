/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.AbstractXMLConfig;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.excel.ExcelParserFactory;
import com.bv.cn.base.excel.FormField;
import com.bv.cn.base.excel.FormvalidateCfgModel;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tformvalidate;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.service.TformvalidateService;
import com.bv.cn.wsbase.base.service.TmoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 表单验证
 */

@Controller
public class TformvalidateController extends AS1BaseController<Tformvalidate> {
	@Resource
	private TformvalidateService<Tformvalidate> tformvalidateService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;

	@Override
	public BvAppBaseService<Tformvalidate> getBaseService() {
		return tformvalidateService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tformvalidate/Tformvalidate_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tformvalidate/Tformvalidate_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tformvalidate/Tformvalidate_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tformvalidate/Tformvalidate_form");
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

	@RequestMapping(value = "listframe", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView listframe(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			String isFrame = StringUtils.trimToEmpty(request
					.getParameter("isFrame"));
			exeBeforeList(request, response, sessionStatus, modelMap);
			if (isFrame.equals("Y")) {
				mav = new ModelAndView(
						"wsbase/Tformvalidate/Tformvalidate_list_frame");
			}
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String module = StringUtils.trimToEmpty(request.getParameter("module"));
		String hql = "from " + clazzName + " t ";
		String orderBy = " order by t.showorder ";
		List<String> params = new ArrayList<String>();
		if (!"".equals(module)) {
			hql += " where t." + Tformvalidate.ALIAS_MODULE + "."
					+ Tmodule.ALIAS_MODULECODE + " = ?";
			params.add(module);
		}
		request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
		request.setAttribute(BvConstants.QUERY_PARAM, params);
		if (isNewlink(request)) {
			request.setAttribute("module", module);
		}
	}

	@Override
	protected void exeAfterEdit(Tformvalidate t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		if (null == t.getTmodule()) {
			String module = StringUtils.trimToEmpty(request
					.getParameter("module"));
			if (!"".equals(module)) {
				String hql = "from " + Tmodule.class.getName() + " t where t."
						+ Tmodule.ALIAS_MODULECODE + " = ?";
				Tmodule m = tmoduleService.getUniqueByHql(hql,
						new String[] { module });
				t.setTmodule(m);
			}
		}
	}

	@Override
	protected void exeBeforeSave(Tformvalidate t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String moduleid = StringUtils.trimToEmpty(request
				.getParameter("moduleid"));
		Tmodule m = tmoduleService.getEntityById(moduleid);
		t.setTmodule(m);
		m.getTformvalidates().add(t);
	}

	@RequestMapping(value = "openuploadxml", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView openuploadxml(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		return new ModelAndView("wsbase/Tformvalidate/uploadxml");
	}

	@RequestMapping(value = "uploadxml", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void uploadxml(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			// request.setCharacterEncoding("UTF-8");
			this.setContentType4Html(request, response);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile cFile = (CommonsMultipartFile) multipartRequest
					.getFile("file1");
			AbstractXMLConfig<FormvalidateCfgModel> parser = ExcelParserFactory
					.getFormvalidateParser();
			// String itemName = StringUtils.trimToEmpty(request
			// .getParameter("itemName"));
			FormvalidateCfgModel model = parser.parse(cFile.getInputStream(),
					"UTF-8");
			if (null != model) {
				String hql = "from " + Tmodule.class.getName() + " t where t."
						+ Tmodule.ALIAS_MODULECODE + " = '" + model.getModule()
						+ "' ";

				Tmodule m = tmoduleService.getUniqueByHql(hql, new Object[0]);

				if (m != null) {
					Set<Tformvalidate> subset = m.getTformvalidates();
					Set<Tformvalidate> fset = new HashSet<Tformvalidate>();
					m.setTformvalidates(fset);
//					java.util.Collections.copy(fset, subset);
					for (Tformvalidate fv : subset) {
//						subset.remove(fv);
						getBaseService().delete(fv);
					}
					// m.getTformvalidates().clear();
					tmoduleService.updateEntity(m);
					Set<FormField> ffs = model.getFields();
					Set<Tformvalidate> fs = new HashSet<Tformvalidate>();
					for (FormField ff : ffs) {
						Tformvalidate fv = new Tformvalidate();
						fv.setFieldid(StringUtils.trimToEmpty(ff.getFieldid()));
						fv.setFieldisrequired(StringUtils.trimToEmpty(ff
								.getFieldisrequired()));
						fv.setFieldmaxlen(Integer.parseInt(ff.getFieldmaxlen()));
						fv.setFieldminlen(Integer.parseInt(ff.getFieldminlen()));
						fv.setFieldname(StringUtils.trimToEmpty(ff
								.getFieldname()));
						fv.setFieldpattern(StringUtils.trimToEmpty(ff
								.getFieldpattern()));
						fv.setFieldtype(StringUtils.trimToEmpty(ff
								.getFieldtype()));
						fv.setShoworder(Integer.parseInt(ff.getShoworder()));
						fv.setFieldchinesename(ff.getFieldchinesename());
						fv.setTmodule(m);
						fv = getBaseService().saveEntity(fv);
//						logger.info("fv=" + fv.toString());
						fs.add(fv);

					}
					m.setTformvalidates(fs);
					tmoduleService.updateEntity(m);
				}
			}
			response.getWriter()
					.write("<script type=\"text/javascript\">alert(\"导入成功\");window.returnValue=\"true\";window.close();</script>");
		} catch (Exception e) {
			logger.error("", e);
			response.getWriter().write("导入出错，" + e.getMessage());
		}
	}
}
