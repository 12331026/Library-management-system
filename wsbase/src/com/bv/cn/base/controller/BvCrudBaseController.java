package com.bv.cn.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.Pagelet;
import com.bv.cn.base.common.config.WSBaseConfig;
import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.script.bean.JsonBean;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.common.utils.JsonHelper;
import com.bv.cn.base.common.utils.StringHelper;
import com.bv.cn.base.common.utils.UtilDatePropertyEditor;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.service.BvBaseServiceException;

public abstract class BvCrudBaseController<T> extends BaseController<T>
		implements BaseControllerInterface {

	public static final String DATA = "data";
	public static final String STATUS = "status";
	public static final String SUCCESS = "success";
	public static final String MSG = "msg";
	public static final String ERRORMSG = "errorMsg";
	public static final String ERRORCODE = "errorcode";
	public static final String TOTAL = "total";
	public static final String JSON = "json";

	public BvCrudBaseController() {
		super();
		this.setListPagePath();
		this.setListChildPagePath();
		this.setEditPagePath();
		this.setFormPagePath();
		this.setDeletePagePath();
	}

	private String saveForwardPath = "";

	public void setSaveForwardPath(String saveForwardPath) {
		this.saveForwardPath = saveForwardPath;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new UtilDatePropertyEditor(
				dateFormat, true));
	}

	/**
	 * 设置编码，按理在过滤器上就应该统一所有请求的编码 暂时苟且的这样了
	 * 
	 * @param response
	 */
	protected void setEncoding(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public final ModelAndView edit(
			@RequestParam(value = "resourceId", required = false)
			String resourceId, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			T t = exeEdit(request, resourceId);
			exeAfterEdit(t, request, response, sessionStatus, modelMap);
			mav = new ModelAndView(getEditPagePath());
			mav.addObject("custForm", t);
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			throw new BaseActionException("按主键查询出错！");
		}

		return mav;
	}

	@RequestMapping(value = "save", method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public final void save(@ModelAttribute("custForm")
	T t, HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		String resourceId = "";
		JSONObject json = new JSONObject();
		try {
			modelMap.put(JSON, json);
			resourceId = getResid(t, request);

			if ((resourceId != null) && (!("".equals(resourceId))))
				setBaseModel(t, Constants.TODO_UPDATE, request,
						Constants.EXEACTION_SAVE);
			else {
				setBaseModel(t, Constants.TODO_CREATE, request,
						Constants.EXEACTION_SAVE);
			}

			exeBeforeSave(t, request, response, sessionStatus, modelMap);

			exeSave(t, request, response, sessionStatus, modelMap);

			exeAfterSave(t, request, response, sessionStatus, modelMap);
		} catch (Exception e) {
			logger.error("", e);
			throw e;
		}
	}

	@RequestMapping(value = "delete", method = { RequestMethod.GET,
			RequestMethod.POST })
	public final ModelAndView delete(String[] resourceIds,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {

		try {
			exeDelete(resourceIds, request, response, sessionStatus, modelMap);
			exeAfterDelete(resourceIds, request, response, sessionStatus,
					modelMap);
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());

			throw new BaseActionException("删除操作出错！");
		}

		return new ModelAndView(this.getDeletePagePath());
	}

	protected String getResid(Object model, HttpServletRequest request) {
		String resid = null;
		try {
			resid = (String) PropertyUtils.getProperty(model, "resourceId");

			if ((resid == null) || ("".equals(resid.trim())))
				resid = request.getParameter("resourceId");
		} catch (Exception localException) {
		}
		return resid;
	}

	protected int getPageIndex(HttpServletRequest request) {
		Integer start = StringHelper.convert2Int(request.getParameter("start"));
		Integer limit = StringHelper.convert2Int(request.getParameter("limit"));
		Integer pageIndex = start / limit + 1;
		logger.info("start=" + start);
		logger.info("limit=" + limit);
		logger.info("pageIndex=" + pageIndex);

		if (pageIndex == 0) {
			pageIndex = 1;
		}

		return pageIndex;
	}

	protected int getPageSize(HttpServletRequest request) {
		int pageSize = StringHelper.convert2Int(request.getParameter("limit"));

		if (pageSize == 0) {
			pageSize = Integer.parseInt(WSBaseConfig.getProperty("PAGE_SIZE"));
		}

		request.setAttribute("pageSize", Integer.valueOf(pageSize));

		return pageSize;
	}

	protected void setPageSize(int pageSize, HttpServletRequest request) {
		request.setAttribute("pageSize", Integer.valueOf(pageSize));
	}

	@SuppressWarnings("unchecked")
	protected T exeEdit(HttpServletRequest request, String resourceId)
			throws Exception {
		T t = null;

		try {
			Class<?> classForName = Class.forName(GenericsUtils
					.getGenericClass(super.getClass()).getName());
			Constructor<?> constructor = classForName
					.getConstructor(new Class[0]);
			t = (T) constructor.newInstance(new Object[0]);

			if ((resourceId != null) && (!("".equals(resourceId)))) {
				t = this.getBaseService().getEntityById(resourceId);
			}

		} catch (Exception e) {
			throw e;
		}

		return t;
	}


	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// try {
		// Map parameterMap = request.getParameterMap();
		// request.setAttribute(TfmsConstants.PARAM_MAP_DEFAULT, parameterMap);
		// } catch (Exception exp) {
		// this.logger.error(exp.getMessage());
		// throw exp;
		// }
	}

	@RequestMapping(value = "list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			exeBeforeList(request, response, sessionStatus, modelMap);
			exeList(request, response, sessionStatus, modelMap);
			mav = new ModelAndView(getListPagePath());
			logger.info(getListPagePath());
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return mav;
	}

	@RequestMapping(value = "listchild", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView listchild(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			JSONObject json = new JSONObject();
			modelMap.put(JSON, json);
			exeBeforeListChild(request, response, sessionStatus, modelMap);
			exeListChild(request, response, sessionStatus, modelMap);
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("查询列表出错！", e);
		}
		return null;
	}

	protected void exeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
	}

	protected void exeBeforeListChild(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		response.setContentType("text/javascript;charset=utf-8");
	}

	protected void setContentType4Json(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/javascript;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
	}

	protected void exeListChild(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			int pageSize = getPageSize(request);
			int pageIndex = getPageIndex(request);
			JSONObject json = (JSONObject) modelMap.get(JSON);
			Pagelet pagelet = null;

			String hql = (String) request.getAttribute(BvConstants.QUERY_HQL);

			if (null == hql || "".equals(hql.trim())) {
				pagelet = getBaseService().findPageByHql("from " + clazzName,
						pageSize, pageIndex);
			} else {
				List<Object> params = (List<Object>) request
						.getAttribute(BvConstants.QUERY_PARAM);

				pagelet = getBaseService().findPageByHql(hql, pageSize,
						pageIndex, params);
			}
			json.put(TOTAL, pagelet.getTotalRecord());
			json.put(DATA, JSONArray.fromObject(pagelet.getPageList()));
			json.write(response.getWriter());
			logger.info("request charset Encode:"
					+ request.getCharacterEncoding());
			logger.info("response charset Encode:"
					+ response.getCharacterEncoding());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

	@RequestMapping(value = "showform", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public final ModelAndView showform(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			exeShowForm(request, response, sessionStatus, modelMap);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
		this.logger.info(getFormPagePath());
		ModelAndView mav = new ModelAndView(getFormPagePath());
		return mav;
	}

	protected void exeShowForm(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
	}

	protected void exeBeforeSave(T t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
	}

	// 处理上传附件的功能
	protected void exeAfterSave(T t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		setContentType4Json(request, response);
		JSONObject json = (JSONObject) modelMap.get(JSON);
		json.put(SUCCESS, true);
		json.put(MSG, "保存成功");
		json.write(response.getWriter());

	}

	protected void exeEndExtend(T t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) {
	}

	protected String getTitle(HttpServletRequest request, Object obj) {
		String title = (String) request.getAttribute("wfTitle");
		if ((title == null) || (title.equals(""))) {
			title = "审批单";
		}
		return title;
	}

	protected void exeSave(@ModelAttribute("custForm")
	T t, HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		try {
			String resid = getResid(t, request);
			if ((resid != null) && (!("".equals(resid)))) {
				this.getBaseService().updateEntity(t);
				return;
			}
			this.getBaseService().saveEntity(t);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

	public String getSaveForwardPath() {
		return saveForwardPath;
	}

	protected void exeAfterEdit(T t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
	}


	protected void exeDelete(String[] resourceIds, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			String[] ids = resourceIds;
			if ((ids == null) || (ids.length <= 0))
				return;
			this.getBaseService().delEntitys(ids);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

	protected void exeAfterDelete(String[] resourceIds,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
	}

	protected void setBaseModel(Object object, String method,
			HttpServletRequest request, String exeAction) {
		HttpSession session = request.getSession();
		LogonVO logonVO = (LogonVO) session.getAttribute("LOGONVO");
		String userId = logonVO.getUserid();
		String userName = logonVO.getUserName();

		try {
			if (object instanceof BaseModel) {
				if (Constants.TODO_CREATE.equals(method)) {
					PropertyUtils.setProperty(object, "flgDeleted",
							Constants.FLGDELETED_NO);
					PropertyUtils.setProperty(object, "creater", userId);
					PropertyUtils.setProperty(object, "createusername",
							userName);
					PropertyUtils.setProperty(object, "createdate", new Date());
				} else if (Constants.TODO_UPDATE.equals(method)) {
					PropertyUtils.setProperty(object, "updater", userId);
					PropertyUtils.setProperty(object, "updateusername",
							userName);
					PropertyUtils.setProperty(object, "updatedate", new Date());
				}
			}
		} catch (IllegalAccessException e) {
			this.logger.error("执行的方法无法访问指定类、字段、方法或构造方法的定义.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			this.logger.error("目标异常.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			this.logger.error("无法找到某一特定方法.");
			e.printStackTrace();
		}

	}

	protected void setSubBaseModel(Object object, String method,
			HttpServletRequest request, String exeAction) {
		HttpSession session = request.getSession();
		LogonVO logonVO = (LogonVO) session.getAttribute("LOGONVO");
		String userId = logonVO.getUserid();
		String userName = logonVO.getUserName();

		try {
			if (object instanceof BaseModel) {
				if (Constants.TODO_CREATE.equals(method)) {
					PropertyUtils.setProperty(object, "flgDeleted",
							Constants.FLGDELETED_NO);
					PropertyUtils.setProperty(object, "creator", userId);
					PropertyUtils.setProperty(object, "creatorUsername",
							userName);
					PropertyUtils.setProperty(object, "createTime", new Date());
				} else if (Constants.TODO_UPDATE.equals(method)) {
					PropertyUtils.setProperty(object, "updater", userId);
					PropertyUtils.setProperty(object, "updaterUsername",
							userName);
					PropertyUtils.setProperty(object, "updateTime", new Date());
				}
			}
		} catch (IllegalAccessException e) {
			this.logger.error("执行的方法无法访问指定类、字段、方法或构造方法的定义.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			this.logger.error("目标异常.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			this.logger.error("无法找到某一特定方法.");
			e.printStackTrace();
		}
	}

	protected final boolean isNewlink(HttpServletRequest request) {
		boolean rtnVal = false;
		if ("Y".equalsIgnoreCase(StringUtils.trimToEmpty(request
				.getParameter(BvConstants.NEWLINK)))) {
			rtnVal = true;
		} else if ("Y".equalsIgnoreCase(StringUtils.trimToEmpty(String
				.valueOf(request.getAttribute(BvConstants.NEWLINK))))) {
			rtnVal = true;
		}
		return rtnVal;
	}

	/**
	 * 异步删除
	 */
	@RequestMapping(value = "deleteByResourceIds", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void deleteByResourceIds(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {

		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");

		JSONObject json = new JSONObject();
		try {
			String sresourceIds = StringUtils.trimToEmpty(request
					.getParameter("resourceIds"));
			logger.info("resourceIds=" + sresourceIds);
			String[] resourceIds = sresourceIds.split(",");
			modelMap.put(JSON, json);
			exeDelete(resourceIds, request, response, sessionStatus, modelMap);
			exeAfterDelete(resourceIds, request, response, sessionStatus,
					modelMap);
			json.put(SUCCESS, true);
			json.put(MSG, "删除操作成功！");
		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			json.put(SUCCESS, false);
			json.put(MSG, "删除操作失败！");
		} finally {
			setContentType4Json(request, response);
			json.write(response.getWriter());
		}
	}

	/**
	 * 显示提示,刷新父窗体,如果关闭当前窗体返回字符串OK,否则当前窗体转至指定URL(绝对路径)
	 * 
	 * @param response
	 * @param tip
	 * @param absoluteUrl
	 * @param close_window
	 * @throws IOException
	 */
	protected void refresh(HttpServletRequest request,
			HttpServletResponse response, JsonBean bean, boolean isClose)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<script>");
			if (bean != null) {
				out.println("  alert(\"" + bean.getMsg() + "!\");");
			}
			if (isClose) {
				out.println("try{window.opener.location.reload();}catch(e){}");
				out.println("window.returnValue = \"ok\";");
				out.println("window.opener = null;");
				out.println("window.close();");
			} else {
				out.println("try{window.opener.location.reload();}catch(e){}");
				out.println("window.location.href = '" + webContext(request)
						+ bean.getReturnURL() + "'");
			}
			out.println("</script>");
		} finally {
			out.close();
		}
	}

	/**
	 * 写JsonBean数据
	 * 
	 * @param response
	 * @param bean
	 * @throws Exception
	 */
	protected void writeJson(PrintWriter out, Object bean) throws Exception {
		try {
			JsonHelper.write(bean, out);
		} finally {
			out.close();
		}
	}

}
