package com.bv.cn.base.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BvEncodeFilter implements Filter {

	protected Log logger = LogFactory.getLog(this.getClass());

	@Override
	public void destroy() {
		logger.debug(this.getClass().getName() + " destroy...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
//		res.setContentType("text/html;charset=GBK");
		fc.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.debug(this.getClass().getName() + " init...");
	}

}
