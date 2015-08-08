package com.bv.cn.base.hessian;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.collection.PersistentSet;

import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.AbstractSerializer;
import com.caucho.hessian.io.CollectionSerializer;

public class HibernateSerializer extends AbstractSerializer {

	CollectionSerializer collectionSerializer = new CollectionSerializer();
	@Override
	public void writeObject(Object obj, AbstractHessianOutput out)
			throws IOException {
		// boolean isinit = Hibernate.isInitialized(obj);

		// if(isinit) {
		// if(out.addRef(obj) ) {
		// return;
		// }

		// }

		if (PersistentSet.class.isAssignableFrom(obj.getClass())) {
			PersistentSet pset = (PersistentSet) obj;
			Set set = new HashSet(pset);
			collectionSerializer.writeObject(set, out);
		}
	}

}
