package com.bv.cn.base.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bv.cn.base.common.utils.SpringHelper;

public class BvServletContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		SpringHelper.bindSessionContext(servletContext);
		SpringHelper.getSpringContext();
//		System.out.println("Spring started ... ");
		// XXX 待提升
		// Java2Js.jsBean(UrmsAdaptor.class, "gdcn.UrmsAdaptor", "urmsAdaptor");
		// Java2Js.jsBean(WfeAdaptor.class, "gdcn.WfeAdaptor", "wfeAdaptor");
		
	}

}
