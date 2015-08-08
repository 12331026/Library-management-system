package com.bv.cn.wsbase.frame.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bv.cn.base.common.config.WSBaseConfig;
import com.bv.cn.base.common.config.WebHelper;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.StringHelper;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.menu.model.Ummenu;
import com.bv.cn.wsbase.menu.service.UmmenuService;

/**
 * 首页展现Controller
 * 
 * @author jim
 * 
 */
@Controller
public class FrameController {

	@Autowired
	private UmmenuService<Ummenu> ummenuService;

	private Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "main", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String main(HttpServletRequest request, HttpSession session)
			throws Exception {

		LogonVO logon = WebHelper.getLogon(session);

		List<Ummenu> menus = (List<Ummenu>) session
				.getAttribute(WSConstants.MENUS);

		if (null == menus) {

			String syscode = StringHelper.doWithNull(request
					.getParameter("syscode"));

			if ("".equals(syscode)) {
				syscode = WSBaseConfig.getProperty("APP_CODE");
			}

			Ummenu[] tmpMenus = ummenuService.getUserMenus(syscode,
					logon.getUserid());

			menus = Arrays.asList(tmpMenus);

			session.setAttribute(WSConstants.MENUS, menus);

			if (logger.isDebugEnabled()) {
				logger.debug("菜单已经放入session中");
			}
		}

		return "frame/index";
	}

	@RequestMapping(value = "leftMenu", method = RequestMethod.GET)
	public String leftMenu(String menuId, HttpServletRequest request,
			HttpSession session) throws Exception {

		LogonVO logon = WebHelper.getLogon(session);

		String syscode = StringHelper.doWithNull(request
				.getParameter("syscode"));

		if ("".equals(syscode)) {
			syscode = WSBaseConfig.getProperty("APP_CODE");
		}

		Ummenu menu = ummenuService.getUserMenu(syscode, logon.getUserid(),
				menuId);

		request.setAttribute(WSConstants.MENU, menu);

		return "frame/left";
	}

	@RequestMapping(value = "contentFrame", method = RequestMethod.GET)
	public String contentFrame(HttpServletRequest request, HttpSession session)
			throws Exception {
		return "frame/contentFrame";
	}

	@RequestMapping(value = "workspace", method = RequestMethod.GET)
	public String workspace(HttpServletRequest request, HttpSession session)
			throws Exception {
		return "frame/workspace";
	}

	@RequestMapping(value = "shrink", method = RequestMethod.GET)
	public String shrink(HttpServletRequest request, HttpSession session)
			throws Exception {
		return "frame/shrink";
	}

}