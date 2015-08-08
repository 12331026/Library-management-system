/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.image.AbstractImageUploader;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Timagelink;
import com.bv.cn.wsbase.base.service.TimagelinkService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 引用图片管理
 */

@Controller
public class TimagelinkController extends AS1BaseController<Timagelink> {
	@Resource
	private TimagelinkService<Timagelink> timagelinkService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Timagelink> getBaseService() {
		return timagelinkService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Timagelink/Timagelink_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Timagelink/Timagelink_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Timagelink/Timagelink_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Timagelink/Timagelink_form");
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
	protected void exeAfterEdit(Timagelink t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);

	}

	@RequestMapping(value = "openupload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView openupload(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		String imagetype = StringUtils.trimToEmpty(request
				.getParameter("imagetype"));
		String modulebelong = StringUtils.trimToEmpty(request
				.getParameter("modulebelong"));
		request.setAttribute("imagetype", imagetype);
		request.setAttribute("modulebelong", modulebelong);

		return new ModelAndView("wsbase/Timagelink/Timagelink_form");
	}

	@RequestMapping(value = "show", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void show(@RequestParam(value = "resourceid", required = false)
	String resourceid, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		Timagelink t = timagelinkService.getEntityById(resourceid);
		if (null != t) {
			String path = request.getSession().getServletContext().getRealPath(
					t.getImagepath() + File.separator + t.getResourceid()
							+ t.getFileextname());
			FileInputStream fis = null;
			OutputStream os = null;
			try {
				fis = new FileInputStream(new File(path));
				os = response.getOutputStream();
				int len = 0;
				byte[] buffer = new byte[2048];
				while ((len = fis.read(buffer)) > 0) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException fnfe) {
				logger.error("file [" + path + "] not found!", fnfe);
				throw fnfe;
			} catch (IOException ioe) {
				logger.error("read/write [" + path + "] error!", ioe);
				throw ioe;
			} finally {
				if (null != fis) {
					try {
						fis.close();
					} catch (Exception e1) {
					}
				}
				if (null != os) {
					try {
						os.close();
					} catch (Exception e1) {
					}
				}
			}
		}
	}

	protected void exeBeforeInnerlist(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

	}

	protected void exeInnerlist(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		int pageSize = getPageSize(request);
		int pageIndex = getPageIndex(request);

		Pagelet pagelet = null;

		String imagetype = StringUtils.trimToEmpty(request
				.getParameter("imagetype"));
		String modulebelong = StringUtils.trimToEmpty(request
				.getParameter("modulebelong"));
		String resourceids = StringUtils.trimToEmpty(request
				.getParameter("resourceids"));
		String isMultiple = StringUtils.trimToEmpty(request
				.getParameter("isMultiple"));
		String writebackDivid = StringUtils.trimToEmpty(request
				.getParameter("writebackDivid"));
		try {
			List<Timagelink> list = new ArrayList<Timagelink>();
			List<Object> params = new ArrayList<Object>();
			String hql = "from " + clazzName + " t where t."
					+ Timagelink.ALIAS_FLG_DELETED + " = 'N' ";
			String orderBy = " order by t." + Timagelink.ALIAS_SHOWORDER
					+ " desc ";
			if (!imagetype.isEmpty()) {
				hql += " and t." + Timagelink.ALIAS_IMAGETYPE + " = ? ";
				params.add(imagetype);
			}
			if (!modulebelong.isEmpty()) {
				hql += " and t." + Timagelink.ALIAS_MODULEBELONG + " = ? ";
				params.add(modulebelong);
			}
			// list = getBaseService().getListsByHql(hql + orderBy, params);
			pagelet = getBaseService().findPageByHql(hql + orderBy, pageSize,
					pageIndex, params);
			request.setAttribute("totalRecord", String.valueOf(pagelet
					.getTotalRecord()));
			request.setAttribute("sublist", pagelet.getPageList());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

	@RequestMapping(value = "innerlist", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView innerlist(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		String imagetype = StringUtils.trimToEmpty(request
				.getParameter("imagetype"));
		String modulebelong = StringUtils.trimToEmpty(request
				.getParameter("modulebelong"));
		String resourceids = StringUtils.trimToEmpty(request
				.getParameter("resourceids"));
		String isMultiple = StringUtils.trimToEmpty(request
				.getParameter("isMultiple"));
		String writebackDivid = StringUtils.trimToEmpty(request
				.getParameter("writebackDivid"));
		String basepath = StringUtils.trimToEmpty(request
				.getParameter("basepath"));
		String requseturi = StringUtils.trimToEmpty(request
				.getParameter("requseturi"));

		request.setAttribute("imagetype", imagetype);
		request.setAttribute("modulebelong", modulebelong);
		request.setAttribute("resourceids", resourceids);
		request.setAttribute("isMultiple", isMultiple);
		request.setAttribute("writebackDivid", writebackDivid);
		request.setAttribute("basepath", basepath);
		request.setAttribute("requseturi", requseturi);
		ModelAndView mav = null;
		try {
			exeBeforeInnerlist(request, response, sessionStatus, modelMap);
			if (isNewlink(request)) {
				// exeAfterList(request, response, sessionStatus, modelMap);
				mav = new ModelAndView(
						"wsbase/Timagelink/Timagelink_inner_list");
			} else {
				exeInnerlist(request, response, sessionStatus, modelMap);
				mav = new ModelAndView(
						"wsbase/Timagelink/Timagelink_inner_list_child");
			}
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("imagelinklist！" + e.getMessage(), e);
		}
		return mav;
	}

	@RequestMapping(value = "uploadimage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void uploadimage(final HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			this.setContentType4Html(request, response);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile cFile = (CommonsMultipartFile) multipartRequest
					.getFile("file1");
			String imagetype = StringUtils.trimToEmpty(request
					.getParameter("imagetype"));
			String modulebelong = StringUtils.trimToEmpty(request
					.getParameter("modulebelong"));
			String imagefilecnname = StringUtils.trimToEmpty(request
					.getParameter("imagefilecnname"));
			String filename = StringUtils.trimToEmpty(cFile.getFileItem().getName());
			if(filename.isEmpty()) {
				throw new BaseActionException("未知的上传文件名称");
			}
			long lsize = cFile.getSize();
			if (lsize > 2 * 1024 * 1024 || lsize == 0) {
				throw new BaseActionException("图片大小需小于2M,且大于0B");
			}
			String filenameext = "";
			if (filename.lastIndexOf(".") > 0) {
				filenameext = filename.substring(filename.lastIndexOf("."));
			}
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			AbstractImageUploader uploader = new AbstractImageUploader(logonVO) {

				@Override
				protected String saveTimagelink(Map modelMap)
						throws BvBaseServiceException {
					String imagefilecnname = (String) modelMap
							.get("imagefilecnname");
					String imagetype = (String) modelMap.get("imagetype");
					String modulebelong = (String) modelMap.get("modulebelong");
					String filenameext = (String) modelMap.get("filenameext");
					String imagepath = (String) modelMap.get("imagepath");
					Timagelink t = new Timagelink();
					TimagelinkController.this.setBaseModel(t,
							Constants.TODO_CREATE, request,
							Constants.EXEACTION_SAVE);
					t.setImagetype(imagetype);
					t.setModulebelong(modulebelong);
					t.setFileextname(filenameext);
					t.setImagefilecnname(imagefilecnname);
					t.setImagepath(imagepath);// 相对路径
					if (null == t.getShoworder()) {
						String sql = "select max(t.showorder) from "
								+ Timagelink.TABLE_ALIAS + " t";
						Integer maxShoworder = jdbcTemplate.query(sql,
								new ResultSetExtractor<Integer>() {

									@Override
									public Integer extractData(ResultSet rs)
											throws SQLException,
											DataAccessException {
										if (rs.next()) {
											return rs.getInt(1);
										}
										return 0;
									}

								});
						t.setShoworder(maxShoworder + 1);
					}
					t = TimagelinkController.this.timagelinkService
							.saveEntity(t);
					return t.getResourceid();
				}

			};
			Map paramMap = new HashMap();
			uploader.process(paramMap, cFile.getInputStream(), imagefilecnname,
					imagetype, modulebelong, filenameext, request.getSession()
							.getServletContext());
			response
					.getWriter()
					.write(
							"<script type=\"text/javascript\">alert(\"上传成功\");window.returnValue={\"success\":true,\"upload\":\"uploaded\",\"resourceid\":\""
									+ paramMap.get("resourceid")
									+ "\"};window.close();</script>");
		} catch (Exception e) {
			response
					.getWriter()
					.write(
							"<script type=\"text/javascript\">alert(\"上传出错,"
									+ e.getMessage()
									+ "\");window.returnValue={\"success\":false};window.close();</script>");
		}

	}


//	@RequestMapping(value = "hide", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
//	public final void hide(HttpServletRequest request,
//			HttpServletResponse response, SessionStatus sessionStatus,
//			ModelMap modelMap) throws Exception {
//		String resids = StringUtils.trimToEmpty(request.getParameter("resids"));
//		JSONObject json = new JSONObject();
//		try {
//			String[] idArr = resids.split(",");
//			for (String resid : idArr) {
//				if (!StringUtils.trimToEmpty(resid).isEmpty()) {
//					Timagelink t = getBaseService().getEntityById(
//							StringUtils.trimToEmpty(resid));
//					t.setFlgDeleted(Constants.FLGDELETED_YES);
//					getBaseService().updateEntity(t);
//				}
//			}
//			json.put("success", "true");
//		} catch (Exception e) {
//			logger.error("隐藏图片出错!", e);
//			json.put("success", "false");
//			throw e;
//		} finally {
//			json.write(response.getWriter());
//		}
//	}
}
