/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.read.biff.BiffException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.LogonVOUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.excel.AbstractExcelParser;
import com.bv.cn.base.excel.ItemModel;
import com.bv.cn.base.excel.TuserExcelParser;
import com.bv.cn.base.exception.BvActionException;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.tsjylib.base.model.Tbookinfo;
import com.bv.cn.wsbase.base.model.Tarticle;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.model.Trole;
import com.bv.cn.wsbase.base.model.Trolemodule;
import com.bv.cn.wsbase.base.model.Tudcommon;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TroleService;
import com.bv.cn.wsbase.base.service.TudcommonService;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 用户表
 */

@Controller
public class TuserController extends AS1BaseController<Tuser> {
	public static final String topResid = "USER-00001";
	@Resource
	private TuserService<Tuser> tuserService;
	@Resource
	private TroleService<Trole> troleService;
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "tudcommonService")
	private TudcommonService<Tudcommon> tudcommonService;
	@Override
	public BvAppBaseService<Tuser> getBaseService() {
		return tuserService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tuser/Tuser_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tuser/Tuser_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tuser/Tuser_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tuser/Tuser_form");
	}

	@RequestMapping(value = "logonurl", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView logonurl(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = new ModelAndView("wsbase/Tuser/logon");
		return mav;
	}
	
	@RequestMapping(value = "registerurl", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView registerurl(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = new ModelAndView("wsbase/Tuser/register");
		return mav;
	}


	@RequestMapping(value = "login", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			String usercode = StringUtils.trimToEmpty(request
					.getParameter("usercode"));
			String password = StringUtils.trimToEmpty(request
					.getParameter("password"));
			String hql = "from " + Tuser.class.getName() + " t where t."
					+ Tuser.ALIAS_VCCODE + " = ?";

			Tuser user = tuserService.getUniqueByHql(hql,
					new Object[] { usercode });
			if (password.equals(StringUtils.trimToEmpty(user.getPassword()))) {
				request.getSession().setAttribute(Constants.LOGONVO,
						LogonVOUtils.user2logonvo(user));
				mav = new ModelAndView("main/mainFrame");
			} else {
				throw new BaseActionException("用户名或密码错误！请重新登陆。",
						"/tuser/logonurl.bvw");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			if (e instanceof BaseActionException) {
				throw e;
			} else {
				throw new BaseActionException("登陆出错！请联系管理员。", e);
			}
		}
		return mav;
	}

	@RequestMapping(value = "exit", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView exit(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			request.getSession().removeAttribute(Constants.LOGONVO);
			LogonVOUtils.setLogonVO(null);
			mav = new ModelAndView("forward:/tuser/logonurl.bvw");
		} catch (Exception e) {
			logger.error(e.toString());
			if (e instanceof BaseActionException) {
				throw e;
			} else {
				throw new BaseActionException("登出出错！请联系管理员。", e);
			}
		}
		return mav;
	}

	@RequestMapping(value = "resetpw", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView resetpw(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		ModelAndView mav = null;
		try {
			String userid = StringUtils.trimToEmpty(request
					.getParameter("userid"));
			String password = StringUtils.trimToEmpty(request
					.getParameter("password"));
			Tuser user = tuserService.getEntityById(userid);
			JSONObject json = new JSONObject();
			if (null != user) {
				tuserService.updateByField(new String[] { userid },
						new String[] { Tuser.ALIAS_PASSWORD },
						new String[] { password });
				request.getSession().setAttribute(Constants.LOGONVO,
						LogonVOUtils.user2logonvo(user));
				json.put("success", true);
			} else {
				json.put("success", false);
				json.put("msg", "所选用户不存在");
			}
			Writer w = response.getWriter();
			json.write(w);
		} catch (Exception e) {
			logger.error(e.toString());
			if (e instanceof BaseActionException) {
				throw e;
			} else {
				throw new BaseActionException("重置密码出错！请联系管理员。", e);
			}
		}
		// return null
		return mav;
	}

	@RequestMapping(value = "getModules", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void getModules(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		logger.debug("step into getModules...");
		try {
			String userid = StringUtils.trimToEmpty(request
					.getParameter("userid"));
			Tuser user = tuserService.getEntityById(userid);
			String sRole = StringUtils.trimToEmpty(user.getRoles());
			String[] sRoleArr = sRole.split(",");
			String rhql = "from " + Trole.class.getName() + " t where t."
					+ Trole.ALIAS_ROLECODE + " = ? ";
			Set<Tmodule> mset = new HashSet<Tmodule>();
			for (String ritem : sRoleArr) {
				Trole role = troleService.getUniqueByHql(rhql, ritem);
				if (null != role) {
					Set<Trolemodule> rmSet = role.getTrolemodules();
					for (Trolemodule rm : rmSet) {
						mset.add(rm.getTmodule());
					}
				}
			}
			JSONObject json = new JSONObject();
			json = getModuleInfo(new ArrayList<Tmodule>(mset));
			logger.info(json.toString());
			super.setContentType4Json(request, response);
			Writer w = response.getWriter();
			json.write(w);
		} catch (Exception e) {
			logger.error(e.toString());
			if (e instanceof BaseActionException) {
				throw e;
			} else {
				throw new BaseActionException("getModules error！请联系管理员。", e);
			}
		}
		// return null
	}

	@Override 
	protected void exeAfterEdit(Tuser t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String hql = "from " + Trole.class.getName() + " t";
		List<Trole> roles = troleService.getListsByHql(hql, new Object[0]);
		request.setAttribute("sublist", roles);
	}

	@Override
	protected void exeBeforeSave(Tuser t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		String tudcommonresourceid = StringUtils.trimToEmpty(request
				.getParameter("tudcommonresourceid"));
		if (!"".equals(tudcommonresourceid)) {
			Tudcommon udc = tudcommonService.getEntityById(tudcommonresourceid);
			t.setTudcommon(udc);
			udc.getTudcommons().add(t);
		}
		if (null == t.getShoworder()) {
			String sql = "select max(t.showorder) from " + Tudcommon.TABLE_ALIAS_COMMON
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
		
//		String comefromflag = StringUtils.trimToEmpty(request.getParameter("flag"));
//		if(comefromflag.equals("registerurl")){
//			super.setEditPagePath("wsbase/Tuser/registersucceed");
//		}else {
//			super.setEditPagePath("wsbase/Tuser/logon");
//		}
		logger.debug("...");
	}

	@Override
	protected void exeAfterSave(Tuser t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
		//t = getBaseService().getEntityById(t.getResourceid());
		StringBuffer[] sbArr = new StringBuffer[2];
		sbArr[0] = new StringBuffer();
		sbArr[1] = new StringBuffer();
		String[] strArr = getFullPath(t, sbArr);
		t.setFullpath(strArr[0]);
		t.setBelongpath(strArr[1]);
		t = getBaseService().mergeEntity(t);
	}

	public static JSONObject getModuleInfo(List<Tmodule> items) {
		JSONArray array = new JSONArray();
		JSONObject temp = null;
		for (Tmodule m : items) {
			temp = new JSONObject();
			temp.put("resourceid", m.getResourceid());
			temp.put("modulecode", m.getModulecode());
			temp.put("modulelevel", m.getModulelevel());
			temp.put("modulename", m.getModulename());
			temp.put("moduletype", m.getModuletype());
			temp.put("parentmoduleid", m.getTmodule() == null ? "" : m
					.getTmodule().getResourceid());
			array.add(temp);
		}
		JSONObject json = new JSONObject();
		json.put(SUCCESS, true);
		json.put(DATA, array.toString());
		json.put(TOTAL, items.size());
		return json;
	}

	@Override
	protected AbstractExcelParser<Tuser> getExcelParser(
			CommonsMultipartFile file, ItemModel item,
			HttpServletRequest request) throws IOException, BiffException {
		return new TuserExcelParser(file.getInputStream(), item, "用户导入",
				request);
	}

	@Override
	/**
	 * import 才需要继承此方法
	 */
	protected Tuser checkNewOrExists(Tuser t, HttpServletRequest request) {
		logger.debug("step into checkNewOrExists...");
		String hql = "from " + clazzName + " t where t." + Tuser.ALIAS_VCCODE
				+ " = ?";
		Tuser t1 = getBaseService().getUniqueByHql(hql, t.getVccode());
		if (null != t1) {
			// 存在vccode相同的用户， 为更新操作
			if (!StringUtils.trimToEmpty(t.getEmployeeno()).equals(
					StringUtils.trimToEmpty(t1.getEmployeeno()))) {
				// employeeno 不同
				String hql2 = "from " + clazzName + " t where t."
						+ Tuser.ALIAS_EMPLOYEENO + " = ?";
				Tuser t2 = getBaseService().getUniqueByHql(hql2,
						StringUtils.trimToEmpty(t.getEmployeeno()));
				if (null != t2) {
					throw new BvActionException("用户[" + t.getVccode() + ","
							+ t.getEmployeeno() + "] 已经存在！请删除或者修改后再次导入。");
				}
			}
			String resid = super.getResid(t1, request);
			t.setResourceid(resid);
			return t;
		} else {
			return t;
		}
	}

	
	@RequestMapping(value={"register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public final ModelAndView register(@ModelAttribute("custForm") Tuser t, HttpServletRequest request, HttpServletResponse response, SessionStatus sessionStatus, ModelMap modelMap)
	    throws Exception
	  {
	    String resourceid = "";
	    try {
	      resourceid = getResid(t, request);

	      
	      exeBeforeSave(t, request, response, sessionStatus, modelMap);

	      exeSave(t, request, response, sessionStatus, modelMap);

	      exeAfterSave(t, request, response, sessionStatus, modelMap);
	      resourceid = getResid(t, request);
	    } catch (Exception e) {
	      this.logger.error("", e);
	      throw e;
	    }
	    return new ModelAndView("wsbase/Tuser/registersucceed");
	  }
	
	@Override
	protected void exeBeforeDelete(String[] resourceIds,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		super.exeBeforeDelete(resourceIds, request, response, sessionStatus,
				modelMap);
		try {
			String[] ids = resourceIds;
			if ((ids == null) || (ids.length <= 0))
				return;
			for (String id : ids) {
				Tuser u = this.getBaseService().getEntityById(id);
				if (null != u) {
					if (u.getTborrowbooks().size() > 0) {
						throw new com.bv.cn.base.controller.BaseActionException(
								"该用户存在借阅信息，现在不能删除。请在删除了借阅信息后尝试删除用户信息。");
					}
				}
			}
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}
}
