/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
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
import com.bv.cn.wsbase.base.model.Tudcommon;
import com.bv.cn.wsbase.base.model.TudcommonTreeJsonModel;
import com.bv.cn.wsbase.base.service.TudcommonService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 用户部门Common
 */

@Controller
public class TudcommonController extends AS1BaseController<Tudcommon> {
	@Resource
	private TudcommonService<Tudcommon> tudcommonService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tudcommon> getBaseService() {
		return tudcommonService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tudcommon/Tudcommon_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tudcommon/Tudcommon_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tudcommon/Tudcommon_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tudcommon/Tudcommon_form");
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

	@RequestMapping(value = "showallframe", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showallframe(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String showall = StringUtils.trimToEmpty(request
				.getParameter("showall"));
		request.setAttribute("showall", showall);
		String isFrame = StringUtils.trimToEmpty(request
				.getParameter("isFrame"));
		exeBeforeList(request, response, sessionStatus, modelMap);
		ModelAndView mav = null;
		if (isFrame.equals("Y")) {
			mav = new ModelAndView("wsbase/Tudcommon/Tudcommon_showall_frame");
		}
		return mav;
	}

	@RequestMapping(value = "showalllist", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showalllist(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String showall = StringUtils.trimToEmpty(request
				.getParameter("showall"));
		request.setAttribute("showall", showall);
		ModelAndView mav = null;
		mav = new ModelAndView("wsbase/Tudcommon/Tudcommon_showall_list");
		return mav;
	}

	@RequestMapping(value = "showdept", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showdept(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String showall = StringUtils.trimToEmpty(request
				.getParameter("showall"));
		String nonyg = StringUtils.trimToEmpty(request.getParameter("nonyg"));
		request.setAttribute("showall", showall);
		request.setAttribute("nonyg", nonyg);
		ModelAndView mav = null;
		mav = new ModelAndView("wsbase/Tudcommon/Tudcommon_showdept");
		return mav;
	}

	@RequestMapping(value = "loadtree", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void loadtree(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		Writer writer = null;
		try {
			String resourceid = StringUtils.trimToEmpty(request
					.getParameter("id"));
			String showall = StringUtils.trimToEmpty(request
					.getParameter("showall"));
			String nonyg = StringUtils.trimToEmpty(request
					.getParameter("nonyg"));
			logger.info("resid=" + resourceid);
			logger.info("showall=" + showall);
			logger.info("nonyg=" + nonyg);
			super.setContentType4Json(request, response);
			writer = response.getWriter();
			String hql = "";
			if ("".equals(resourceid)) {
				hql += "from " + Tudcommon.class.getName() + " t where t."
						+ Tudcommon.ALIAS_PARENT + "."
						+ Tudcommon.ALIAS_RESOURCEID + " is null ";
			} else {
				hql += "from " + Tudcommon.class.getName() + " t where t."
						+ Tudcommon.ALIAS_PARENT + "."
						+ Tudcommon.ALIAS_RESOURCEID + " = '" + resourceid
						+ "'";
			}
			// if ("true".equals(nonyg)) {
			// hql += " and t." + Tudcommon.ALIAS_COMMONTYPE + " <> 'YG' ";
			// }
			Tudcommon udc = getBaseService().getUniqueByHql(hql, new Object[0]);
			// StringBuffer sb = new StringBuffer();
			// String data = "";
			Boolean isForcechildshow = true;
			if (null != udc) {
				// sb.append("[");
				if ("true".equals(nonyg)) {
					if (!"YG".equals(udc.getCommontype())) {
						TudcommonTreeJsonModel jm = new TudcommonTreeJsonModel();
						// 不是员工才appendNode
						appendNode(udc, jm, showall, isForcechildshow, nonyg);
						JSONArray json = JSONArray.fromObject(jm);
						logger.info("data=" + json.toString());
						json.write(writer);
					}
				} else {
					TudcommonTreeJsonModel jm = new TudcommonTreeJsonModel();
					appendNode(udc, jm, showall, isForcechildshow, nonyg);
					JSONArray json = JSONArray.fromObject(jm);
					logger.info("data=" + json.toString());
					json.write(writer);
				}
				// if (sb.length() > 1) {
				// data = sb.substring(0, sb.length() - 1);
				//
				// }
				// data += "]";
				// sb.append("]");
			}
			// writer.write(sb.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			if (e instanceof BaseActionException) {
				throw e;
			} else {
				throw new BaseActionException("出错！请联系管理员。", e);
			}
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (Exception e1) {
				}
			}
		}
	}

	@RequestMapping(value = "movedept", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void movedept(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String resourceid = StringUtils.trimToEmpty(request
				.getParameter("resourceid"));
		String pid = StringUtils.trimToEmpty(request.getParameter("pid"));
		logger.info("resourceid=" + resourceid);
		logger.info("pid=" + pid);
		Tudcommon t = tudcommonService.getEntityById(pid);
		String sql = "update " + Tudcommon.TABLE_ALIAS_COMMON + " t set t."
				+ Tudcommon.ALIAS_PARENTID + " = '" + pid + "'";
		JSONObject json = new JSONObject();
		if (null == t) {
			json.put(SUCCESS, false);
			json.put(ERRORMSG, "上级部门未找到");
		}
		String type = t.getCommontype();
		String newtype = "";
		if ("ZGS".equals(type)) {
			newtype = "GS";
		} else if ("GS".equals(type)) {
			newtype = "BM";
		} else if ("BM".equals(type)) {
			newtype = "KS";
		} else if ("KS".equals(type)) {
			json.put(SUCCESS, false);
			json.put(ERRORMSG, "上级部门不能为科室级别");
		} else {
			json.put(SUCCESS, false);
			json.put(ERRORMSG, "上级部门级别未知");
		}
		if (newtype.length() > 0) {
			sql += ", t." + Tudcommon.ALIAS_COMMONTYPE + " = '" + newtype + "'";
			sql += " where t." + Tudcommon.ALIAS_RESOURCEID + " = '"
					+ resourceid + "'";
			jdbcTemplate.execute(sql);
			json.put(SUCCESS, true);
		}
		setContentType4Json(request, response);
		json.write(response.getWriter());
	}

	@RequestMapping(value = "zhenglisxj", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void zhenglisxj(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			String hql = "from " + Tudcommon.class.getName() + " t where t."
					+ Tudcommon.ALIAS_PARENT + "." + Tudcommon.ALIAS_RESOURCEID
					+ " is null ";
			Tudcommon t = tudcommonService.getUniqueByHql(hql, new Object[0]);
			if (null == t) {
				json.put(SUCCESS, false);
				json.put(ERRORMSG, "顶级部门未找到");
			}
			setReleationship(t);
			json.put(SUCCESS, true);
		} catch (Exception e) {
			json.put(SUCCESS, false);
			json.put(ERRORMSG, "出错！" + e.getMessage());
		}
		setContentType4Json(request, response);
		json.write(response.getWriter());
	}

	private void setReleationship(Tudcommon t) {
		logger.debug("zhengli :" + t.getVcname());
		StringBuffer[] sbArr = new StringBuffer[2];
		sbArr[0] = new StringBuffer();
		sbArr[1] = new StringBuffer();
		String[] strArr = getFullPath(t, sbArr);
		t.setFullpath(strArr[0]);
		t.setBelongpath(strArr[1]);
		tudcommonService.mergeEntity(t);
		Set<Tudcommon> udcSet = t.getTudcommons();
		int size = udcSet.size();
		Tudcommon[] udcArr = new Tudcommon[size];
		udcArr = udcSet.toArray(udcArr);
		for (int i=0;i<size;i++) {
			logger.debug(t.getVcname()+ "--" + i);
			setReleationship(udcArr[i]);
		}
	}

	protected void appendChildNode(Tudcommon udc, TudcommonTreeJsonModel jm,
			String showall, Boolean isForcechildshow, String nonyg) {
		// boolean hasNonYG = false;
		// for (Tudcommon tempudc : udc.getTudcommons()) {
		// if ("ZGS".equals(tempudc.getCommontype())
		// || "GS".equals(tempudc.getCommontype())
		// || "BM".equals(tempudc.getCommontype())) {
		// hasNonYG = true;
		// break;
		// }
		// }
		Boolean bFcs = true;
		if ("ZGS".equals(udc.getCommontype())
				|| "GS".equals(udc.getCommontype())) {
			// 总公司、公司 强制显示下属员工
			// isForcechildshow = true;
			bFcs = true;
		} else {
			// isForcechildshow = false;
			bFcs = false;
		}
		List<TudcommonTreeJsonModel> childs = new ArrayList<TudcommonTreeJsonModel>();
		if ("true".equals(showall)) {
			// show all child
			if (udc.getTudcommons().size() > 0) {
				Set<Tudcommon> udcs = udc.getTudcommons();
				for (Tudcommon child : udcs) {
					if ("true".equals(nonyg)) {
						if (!"YG".equals(child.getCommontype())) {
							TudcommonTreeJsonModel childjm = new TudcommonTreeJsonModel();
							// 不是员工才appendNode
							appendNode(child, childjm, showall, bFcs, nonyg);
							childs.add(childjm);
						}
					} else {
						TudcommonTreeJsonModel childjm = new TudcommonTreeJsonModel();
						appendNode(child, childjm, showall, bFcs, nonyg);
						childs.add(childjm);
					}
				}
			}
		} else {
			if (udc.getTudcommons().size() > 0) {
				Set<Tudcommon> udcs = udc.getTudcommons();
				for (Tudcommon child : udcs) {
					if (isForcechildshow) {
						// force show child
						if ("true".equals(nonyg)) {
							if (!"YG".equals(child.getCommontype())) {
								// 不是员工才appendNode
								TudcommonTreeJsonModel childjm = new TudcommonTreeJsonModel();
								appendNode(child, childjm, showall, bFcs, nonyg);
								childs.add(childjm);
							}
						} else {
							TudcommonTreeJsonModel childjm = new TudcommonTreeJsonModel();
							appendNode(child, childjm, showall, bFcs, nonyg);
							childs.add(childjm);
						}
					} else {
						// non force child， 则不显示员工的叶子节点
						if (!"YG".equals(child.getCommontype())) {
							TudcommonTreeJsonModel childjm = new TudcommonTreeJsonModel();
							appendNode(child, childjm, showall, bFcs, nonyg);
							childs.add(childjm);
						}
					}
				}
			}
		}
		jm.setChildren(childs);
	}

	protected void appendNode(Tudcommon udc, TudcommonTreeJsonModel jm,
			String showall, Boolean isForcechildshow, String nonyg) {
		Boolean bFcs = true;
		if ("ZGS".equals(udc.getCommontype())
				|| "GS".equals(udc.getCommontype())) {
			// 总公司、公司 强制显示下属员工
			bFcs = true;
		} else {
			bFcs = false;
		}
		// String str = "";
		if (udc != null) {
			if ("true".equals(showall)) {
				// showall
				if ("BM".equals(udc.getCommontype())) {
					jm.setId(udc.getResourceid());
					jm.setText(udc.getVcname());
					jm.setState("closed");
					Map<String, String> attrMap = new HashMap<String, String>();
					attrMap.put("code", udc.getVccode());
					attrMap.put("commontype", udc.getCommontype());
					jm.setAttribute(attrMap);
				} else {
					jm.setId(udc.getResourceid());
					jm.setText(udc.getVcname());
					jm.setState("");
					Map<String, String> attrMap = new HashMap<String, String>();
					attrMap.put("code", udc.getVccode());
					attrMap.put("commontype", udc.getCommontype());
					jm.setAttribute(attrMap);
				}
				if (udc.getTudcommons().size() > 0) {
					appendChildNode(udc, jm, showall, bFcs, nonyg);
				}
			} else {
				// non show all
				if (isForcechildshow) {
					// force show child
					if ("BM".equals(udc.getCommontype())) {
						jm.setId(udc.getResourceid());
						jm.setText(udc.getVcname());
						jm.setState("closed");
						Map<String, String> attrMap = new HashMap<String, String>();
						attrMap.put("code", udc.getVccode());
						attrMap.put("commontype", udc.getCommontype());
						jm.setAttribute(attrMap);
					} else {
						jm.setId(udc.getResourceid());
						jm.setText(udc.getVcname());
						jm.setState("");
						Map<String, String> attrMap = new HashMap<String, String>();
						attrMap.put("code", udc.getVccode());
						attrMap.put("commontype", udc.getCommontype());
						jm.setAttribute(attrMap);
					}
					if (udc.getTudcommons().size() > 0) {
						appendChildNode(udc, jm, showall, bFcs, nonyg);
					}
				} else {
					// non force show child, non show all
					if ("BM".equals(udc.getCommontype())) {
						jm.setId(udc.getResourceid());
						jm.setText(udc.getVcname());
						jm.setState("closed");
						Map<String, String> attrMap = new HashMap<String, String>();
						attrMap.put("code", udc.getVccode());
						attrMap.put("commontype", udc.getCommontype());
						jm.setAttribute(attrMap);
					} else if (!"YG".equals(udc.getCommontype())) {
						jm.setId(udc.getResourceid());
						jm.setText(udc.getVcname());
						jm.setState("");
						Map<String, String> attrMap = new HashMap<String, String>();
						attrMap.put("code", udc.getVccode());
						attrMap.put("commontype", udc.getCommontype());
						jm.setAttribute(attrMap);
					}
					if (udc.getTudcommons().size() > 0) {
						appendChildNode(udc, jm, showall, bFcs, nonyg);
					}
				}
			}
		}
	}
}
