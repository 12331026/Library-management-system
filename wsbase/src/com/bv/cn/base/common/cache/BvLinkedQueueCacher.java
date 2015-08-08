package com.bv.cn.base.common.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.bv.cn.base.common.utils.AssertUtils;

public class BvLinkedQueueCacher<E> extends BvAbstractCacher<E> implements
		BvICache<E> {

	protected final Queue<E> queue;

	/*
	 * protected class BvICacheMultiFilterImpl1 implements
	 * BvICacheMultiFilter<E> {
	 * 
	 * private E e;
	 * 
	 * public BvICacheMultiFilterImpl1(E e) { this.e = e; }
	 * 
	 * @Override public List<E> filter(List<E> list) { List<E> innerList = new
	 * ArrayList<E>(); int size = list.size(); for (int i = 0; i < size; i++) {
	 * E m = list.get(i); if (m.equals(e)) { innerList.add(m); return innerList;
	 * } } return innerList; }
	 * 
	 * };
	 */

	public BvLinkedQueueCacher() {
		this(new ConcurrentLinkedQueue<E>());
	}

	public BvLinkedQueueCacher(Queue<E> queue) {
		AssertUtils.isNotNull(queue);
		this.queue = queue;
	}

	@Override
	public void addAll(Collection<E> coll) {
		Iterator<E> it = coll.iterator();
		while (it.hasNext()) {
			put(it.next());
		}
	}

	@Override
	public void put(E e) {
		boolean b = hasElement(e);
		if (!b) {
			queue.add(e);
		} else {
			queue.remove(e);
			queue.add(e);
		}
	}

	@Override
	public E getFirst() {
		return queue.peek();
	}

	@Override
	public List<E> get(BvICacheMultiFilter<E> filter) {
		List<E> list = filter.filter(new ArrayList<E>(queue));
		if (null == list) {
			list = new ArrayList<E>();
		}
		return list;
	}

	@Override
	public E popFirst() {
		return queue.poll();
	}

	@Override
	public List<E> getAndRemove(BvICacheMultiFilter<E> filter) {
		List<E> list = get(filter);
		queue.removeAll(list);
		return list;
	}

	@Override
	public boolean hasElement(E e) {
		if (!queue.isEmpty()) {
			Iterator<E> it = queue.iterator();
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
		if (!queue.isEmpty()) {
			Iterator<E> it = queue.iterator();
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
		return queue.remove(e);
	}

	@Override
	public int remove(BvICacheMultiFilter<E> filter) {
		List<E> list = get(filter);
		queue.removeAll(list);
		return list.size();
	}

	@Override
	public void purge(BvICachePurger purger) {
		purger.purge(new ArrayList<E>(queue));
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
