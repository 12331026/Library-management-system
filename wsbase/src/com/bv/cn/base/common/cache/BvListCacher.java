package com.bv.cn.base.common.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.bv.cn.base.common.utils.AssertUtils;

public class BvListCacher<E> extends BvAbstractCacher<E> implements BvICache<E> {
	protected final List<E> list;

	public BvListCacher() {
		this(new LinkedList<E>());
	}

	public BvListCacher(List<E> list) {
		AssertUtils.isNotNull(list);
		this.list = list;
	}

	@Override
	public void addAll(Collection<E> coll) {
		list.addAll(coll);
	}

	@Override
	public void put(E e) {
		boolean b = hasElement(e);
		if (!b) {
			list.add(e);
		} else {
			list.remove(e);
			list.add(e);
		}
	}

	@Override
	public E getFirst() {
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<E> get(BvICacheMultiFilter<E> filter) {
		List<E> innerlist = filter.filter(list);
		if (null == innerlist) {
			innerlist = new ArrayList<E>();
		}
		return innerlist;
	}

	@Override
	public E popFirst() {
		if (!list.isEmpty()) {
			E e = list.get(0);
			list.remove(e);
			return e;
		} else {
			return null;
		}
	}

	@Override
	public List<E> getAndRemove(BvICacheMultiFilter<E> filter) {
		List<E> rtnList = get(filter);
		list.removeAll(rtnList);
		return rtnList;
	}

	@Override
	public boolean hasElement(final E e) {
		if (!list.isEmpty()) {
			Iterator<E> it = list.iterator();
			while (it.hasNext()) {
				E e1 = it.next();
				if (null != e1 && e1.equals(e)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasElements(BvICacheSingleFilter<E> filter) {
		if (!list.isEmpty()) {
			Iterator<E> it = list.iterator();
			while (it.hasNext()) {
				E e1 = it.next();
				if (null != e1 && filter.filter(e1)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(E e) {
		return list.remove(e);
	}

	@Override
	public int remove(BvICacheMultiFilter<E> filter) {
		List<E> innerlist = get(filter);
		list.removeAll(innerlist);
		return innerlist.size();
	}

	@Override
	public void purge(BvICachePurger purger) {
		purger.purge(list);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
