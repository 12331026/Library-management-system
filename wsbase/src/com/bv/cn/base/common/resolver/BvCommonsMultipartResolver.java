package com.bv.cn.base.common.resolver;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class BvCommonsMultipartResolver extends CommonsMultipartResolver {

	public BvCommonsMultipartResolver() {
		// TODO Auto-generated constructor stub
	}

	public BvCommonsMultipartResolver(ServletContext servletContext) {
		super(servletContext);
		// TODO Auto-generated constructor stub
	}

}
