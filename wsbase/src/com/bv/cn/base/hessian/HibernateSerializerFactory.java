package com.bv.cn.base.hessian;

import org.hibernate.collection.PersistentCollection;

import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import com.caucho.hessian.io.SerializerFactory;

public class HibernateSerializerFactory extends SerializerFactory {

	@Override
	public Serializer getSerializer(Class cl) throws HessianProtocolException {
		if(PersistentCollection.class.isAssignableFrom(cl)){
			return new HibernateSerializer();
		}
		return super.getSerializer(cl);
	}

}
