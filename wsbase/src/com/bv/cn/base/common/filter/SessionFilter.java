package com.bv.cn.base.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bv.cn.base.common.config.WebHelper;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.security.model.Online;

public class SessionFilter implements Filter {
	Log logger = LogFactory.getLog(SessionFilter.class);
	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String noFilterURI = this.filterConfig.getInitParameter("noFilterURI");

		if ((noFilterURI == null) || (noFilterURI.length() == 0)) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		String path = request.getServletPath();

		if (noFilterURI.indexOf(path) >= 0) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		HttpSession session = request.getSession(false);
		LogonVO webLogon = WebHelper.getLogon(session);

		boolean alive = (session != null) && (webLogon != null);
		if (!(alive)) {
			this.logger.debug("no valid session: " + path);
			String errorPage = this.filterConfig.getInitParameter("errorPage");
			errorPage = ((errorPage == null) || (errorPage.trim().equals(""))) ? "/bpaf/error/error_ses.jsp"
					: errorPage;
			request.setAttribute("errorInfo", " 会话已经失效，请重新登录。");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return;
		}

//		LogonVO logon = Online.getBySessionid(session.getId());
//		if (logon == null) {
//			this.logger.debug("no in Online: " + webLogon.getUsername() + "("
//					+ webLogon.getLoginip() + ")");
//			String errorPage = "/bpaf/error/error_ses.jsp";
//			request.setAttribute("errorInfo", " 会话已经失效，请重新登录。");
//			request.setAttribute("noInOnline", "Y");
//			request.getRequestDispatcher(errorPage).forward(request, response);
//			return;
//		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		this.filterConfig = null;
	}
}
