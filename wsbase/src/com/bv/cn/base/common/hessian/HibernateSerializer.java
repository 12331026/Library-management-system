package com.bv.cn.base.common.hessian;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.collection.PersistentSet;

import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.AbstractSerializer;
import com.caucho.hessian.io.CollectionSerializer;

public class HibernateSerializer extends AbstractSerializer {

	CollectionSerializer collectionSerializer = new CollectionSerializer();

	@Override
	public void writeObject(Object obj, AbstractHessianOutput out)
			throws IOException {

		if (PersistentSet.class.isAssignableFrom(obj.getClass())) {
			boolean isinit = Hibernate.isInitialized(obj);
			if (isinit) {
				PersistentSet pset = (PersistentSet) obj;
				Set set = new HashSet(pset);
				collectionSerializer.writeObject(set, out);
			} else {
				collectionSerializer.writeObject(new HashSet(), out);
			}
		}
	}

}
