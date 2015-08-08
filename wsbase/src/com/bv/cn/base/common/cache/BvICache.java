package com.bv.cn.base.common.cache;

import java.util.Collection;
import java.util.List;

/**
 * ����ӿ� 1.LinkedQueueCacher: LinkedQueue ��ݽṹ 2.ArrayList ��ݽṹ 3.Stack ��ݽṹ
 * 
 * ע�� �� Ԫ��E����ʵ�� equals����
 * 
 * @author john
 * 
 */
public interface BvICache<E> {

	public void addAll(Collection<E> coll);

	public void put(E e);

	public E getFirst();

	public List<E> get(BvICacheMultiFilter<E> filter);

	public E popFirst();

	public List<E> getAndRemove(BvICacheMultiFilter<E> filter);

	public boolean hasElement(E e);

	public boolean hasElements(BvICacheSingleFilter<E> filter);

	public boolean remove(E e);

	public int remove(BvICacheMultiFilter<E> filter);

	public void purge(BvICachePurger purger);

	public boolean isEmpty();
}
