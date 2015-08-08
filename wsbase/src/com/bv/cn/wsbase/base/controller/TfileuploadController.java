/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.BvFileuplaodUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.wsbase.base.model.Tfileupload;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.service.TfileuploadService;
import com.bv.cn.wsbase.base.service.TmoduleService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 附件上传
 */

@Controller
public class TfileuploadController extends AS1BaseController<Tfileupload> {
	@Resource
	private TfileuploadService<Tfileupload> tfileuploadService;
	@Resource
	private TmoduleService<Tmodule> tmoduleService;

	@Override
	public BvAppBaseService<Tfileupload> getBaseService() {
		return tfileuploadService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tfileupload/Tfileupload_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tfileupload/Tfileupload_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tfileupload/Tfileupload_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tfileupload/Tfileupload_form");
	}

	@Override
	protected String _getDeleteForwardPath(HttpServletRequest request,
			ModelMap modelMap) {
		return null;
	}

	@RequestMapping(value = "openfileuploadlist", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView openfileuploadlist(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		String formid = StringUtils.trimToEmpty(request.getParameter("formid"));
		String modulecode = StringUtils.trimToEmpty(request
				.getParameter("modulecode"));
		try {
			List<Tfileupload> list = new ArrayList<Tfileupload>();
			if (!"".equals(formid) && !"".equals(modulecode)) {
				list = getBaseService().getListsByHql(
						"from " + clazzName + " t where t."
								+ Tfileupload.ALIAS_MODULECODE + " = ? and t."
								+ Tfileupload.ALIAS_FORMID + " = ?",
						new String[] { modulecode, formid });
			}
			request.setAttribute("sublist", list);
			request.setAttribute("modulecode", modulecode);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
		return new ModelAndView("wsbase/Tfileupload/Tfileupload_inner_list");
	}

	@RequestMapping(value = "openupload", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView openupload(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		String formid = StringUtils.trimToEmpty(request.getParameter("formid"));
		String modulecode = StringUtils.trimToEmpty(request
				.getParameter("modulecode"));

		request.setAttribute("formid", formid);
		request.setAttribute("modulecode", modulecode);
		return new ModelAndView("wsbase/Tfileupload/Tfileupload_fileupload");
	}

	@RequestMapping(value = "upload", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void upload(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			this.setContentType4Html(request, response);
			String formid = StringUtils.trimToEmpty(request
					.getParameter("formid"));
			String modulecode = StringUtils.trimToEmpty(request
					.getParameter("modulecode"));
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile cFile = (CommonsMultipartFile) multipartRequest
					.getFile("file1");
			if (!"".equals(modulecode)) {
				String hql = "from " + Tmodule.class.getName() + " t where t."
						+ Tmodule.ALIAS_MODULECODE + " = '" + modulecode + "' ";
				Tmodule m = tmoduleService.getUniqueByHql(hql, new Object[0]);
				if (m != null) {
					FileOutputStream fos = null;
					InputStream is = null;
					try {
						Tfileupload t = new Tfileupload();
						setBaseModel(t, Constants.TODO_CREATE, request,
								Constants.EXEACTION_SAVE);
						t.setModulecode(modulecode);
						t.setFormid(formid);
						t.setFilename(cFile.getOriginalFilename());
						String filename = cFile.getOriginalFilename();
						if (filename.lastIndexOf(".") > 0) {
							t.setFileext(filename.substring(filename
									.lastIndexOf(".")));
						} else {
							t.setFileext("");
						}
						t = getBaseService().saveEntity(t);

						String rootpath = BvFileuplaodUtils
								.getFileuploadRootpath();
						String path = m.getModulecode() + File.separator
								+ formid;
						File rf = new File(rootpath);
						File ff = new File(rf, path);
						if (!ff.exists()) {
							ff.mkdirs();
						}
						File f = new File(ff, t.getResourceid());
						if (f.exists()) {
							f.delete();
						} else {
							f.createNewFile();
						}
						fos = new FileOutputStream(f);
						is = cFile.getInputStream();
						byte[] buf = new byte[2048];
						int len = -1;
						while ((len = is.read(buf)) > 0) {
							fos.write(buf, 0, len);
						}
					} catch (Exception e) {
						logger.error("写入文件出错！", e);
						throw e;
					} finally {
						if (null != is) {
							try {
								is.close();
							} catch (Exception e1) {

							}
						}
						if (null != fos) {
							try {
								fos.close();
							} catch (Exception e2) {

							}
						}
					}

				}
			}
			response
					.getWriter()
					.write(
							"<script type=\"text/javascript\">alert(\"上传成功\");window.returnValue=\"true\";window.close();</script>");
		} catch (Exception e) {
			logger.error("", e);
			response.getWriter().write("文件上传错误，" + e.getMessage());
		}
	}

	@RequestMapping(value = "download", method = { RequestMethod.GET,
			RequestMethod.POST })
	public final void download(String[] resourceids,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		try {
			if (resourceids != null && resourceids.length == 1) {
				Tfileupload t = getBaseService().getEntityById(resourceids[0]);
				doDownload(response, t);
			}
		} catch (Exception e) {
			logger.error("download error", e);
		}

	}

	@RequestMapping(value = "downloadsingle", method = { RequestMethod.GET,
			RequestMethod.POST })
	public final void downloadsingle(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			String resid = StringUtils.trimToEmpty(request
					.getParameter("resourceid"));
			if (!"".equals(resid)) {
				Tfileupload t = getBaseService().getEntityById(resid);
				doDownload(response, t);
			}
		} catch (Exception e) {
			logger.error("download error", e);
		}

	}

	@RequestMapping(value = "deletefile", method = { RequestMethod.GET,
			RequestMethod.POST })
	public final void deletefile(String resourceids,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {

		JSONObject json = new JSONObject();
		try {
			String[] ids = resourceids.split(",");
			if ((ids == null) || (ids.length <= 0))
				return;
			for (String id : ids) {
				Tfileupload t = this.getBaseService().getEntityById(id);
				if (null != t) {
					String rootpath = BvFileuplaodUtils.getFileuploadRootpath();
					String path = t.getModulecode() + File.separator
							+ t.getFormid();
					File rf = new File(rootpath);
					File ff = new File(rf, path);
					File f = new File(ff, t.getResourceid());
					if (f.exists()) {
						f.delete();
					}
					this.getBaseService().delete(t);
				}
			}
			json.put(super.SUCCESS, true);
			json.put(super.DATA, ids);
			logger.debug("deletefile success");
		} catch (Exception e) {
			logger.error("deletefile error!", e);
			json.put(super.SUCCESS, false);
		} finally {
			json.write(response.getWriter());
		}
	}

	protected void doDownload(HttpServletResponse response, Tfileupload t)
			throws Exception {
		if (null != t) {
			String rootpath = BvFileuplaodUtils.getFileuploadRootpath();
			String path = t.getModulecode() + File.separator + t.getFormid();
			File rf = new File(rootpath);
			File ff = new File(rf, path);
			File f = new File(ff, t.getResourceid());
			if (f.exists()) {
				FileInputStream fis = null;
				OutputStream os = null;
				try {
					response.setContentType("application/octet-stream");
					response.setHeader("Content-Disposition",
							"attachment;fileName=" + t.getFilename());
					fis = new FileInputStream(f);
					os = response.getOutputStream();
					byte[] buf = new byte[2048];
					int len = -1;
					while ((len = fis.read(buf)) > 0) {
						os.write(buf, 0, len);
					}
				} catch (Exception e) {
					logger.error("file download error!", e);
					throw e;
				}
			} else {
				logger.warn("file [" + f.getAbsolutePath() + "] not found!");
			}
		}
	}

}
