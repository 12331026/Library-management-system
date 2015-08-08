package com.bv.cn.wsbase.frame.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.user.model.Umuser;
import com.bv.cn.wsbase.user.service.UmuserService;

@Controller
public class LogonController {

	private static final String F_ERRORPAGE = "error";
	private static final String F_IDENTITY = "identity";
	private static final String F_MAIN = "/frame/main.bvw";

	protected static final Log logger = LogFactory.getLog(LogonController.class);
	
	@Autowired
	private UmuserService<Umuser> umuserService;

	@RequestMapping(value = "logon", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView logon(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		session = request.getSession();
		String logonid = request.getParameter("logonid");
		String password = request.getParameter("password");
		String userid = request.getParameter("userid");

		if (userid == null && ((logonid == null) || (password == null))) {
			request.setAttribute("err", "用户名或者密码错误，请重新输入。");
			logger.info(F_ERRORPAGE);
			return new ModelAndView(F_ERRORPAGE);
		}

		Umuser umuser = null;
		if (StringUtils.trimToEmpty(userid).equals("")) {
			umuser = this.umuserService.getLogonInfo(logonid, password);
			if (umuser != null) {
				String mulriple = umuser.getMulriple();
				if ((!umuser.isSuper()) && (mulriple != null)
						&& (mulriple.length() >= 0)) {
					mulriple = mulriple + "," + umuser.getResourceid();

					List<Umuser> users = this.umuserService
							.getUmuserList(mulriple);
					request.setAttribute("userlist", users.toArray());
					logger.info(F_ERRORPAGE);
					return new ModelAndView(F_IDENTITY);
				}
			}
		}

		if (null == umuser) {
			umuser = this.umuserService.getEntityById(userid);
		}
		if (umuser == null) {
			request.setAttribute("err", "用户名或者密码错误，请重新输入。");
			logger.info(F_ERRORPAGE);
			return new ModelAndView(F_ERRORPAGE);
		}
		umuser.wrap();
		if (umuser.isOutofdate()) {
			request.setAttribute("err", "用户帐号已经过期。");
			logger.info(F_ERRORPAGE);
			return new ModelAndView(F_ERRORPAGE);
		}

		LogonVO logon = new LogonVO(umuser);
		logon.setRequestValue(request);
		session.setAttribute(WSConstants.LOGONVO, logon);
		// setEventScript(request);

		// ExtManager.execute("LoginAfterExt", new Object[] { request, response
		// });

		// if (!(response.isCommitted())) {
		// String framsetid = logonVO.getFramesetid();
		// if ((framsetid == null) || (framsetid.trim().length() == 0)) {
		// request.setAttribute("err", "未找到您能使用的门户框架！请检查配置！");
		// return mapping.findForward(F_ERRORPAGE);
		// }
		// String url = FramesetHelper.getFrameURL(request, logon);
		// request.getRequestDispatcher(url).forward(request, response);
		// }

		logger.info("forward:" + F_MAIN);
		return new ModelAndView("forward:" + F_MAIN);
	}

}
