package com.bv.cn.as1sys.as1lib.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerformanceTraceInterceptor extends HandlerInterceptorAdapter {
	protected final Log logger = LogFactory.getLog(this.getClass());

	protected Long startTime;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("step into " + PerformanceTraceInterceptor.class.getName()
				+ ".preHandle() ...");
		startTime = System.currentTimeMillis();
		return super.preHandle(request, response, handler);
	}

	// @Around("execution(@org.springframework.stereotype.Controller *)")
	// @Around("execution(*
	// com.bv.cn.testweb.controller.TestController.checkparm(..))")
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("step into " + PerformanceTraceInterceptor.class.getName()
				+ ".postHandle() ...");
		Long endTime = System.currentTimeMillis();
		Long duration = endTime - startTime;
		logger.info("class:" + handler.getClass().getName() + "."
				+ request.getRequestURI() + " cost time:" + duration);
	}
}