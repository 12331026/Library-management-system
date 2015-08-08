package com.bv.cn.base.common.hessian;

import org.springframework.remoting.caucho.HessianServiceExporter;

import com.caucho.hessian.io.SerializerFactory;

public class BvHessianServiceExporter extends HessianServiceExporter {

	public BvHessianServiceExporter() {
		super();
		SerializerFactory factory = new SerializerFactory();
		factory.addFactory(new HibernateSerializerFactory());
		super.setSerializerFactory(factory);
	}

}
