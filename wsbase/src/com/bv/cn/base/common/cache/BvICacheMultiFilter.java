package com.bv.cn.base.common.cache;

import java.util.List;

public interface BvICacheMultiFilter<E> {

	/**
	 * ���� �� public List<E> get(ICacheFilter<E> filter) �� 
	 * public int remove(ICacheFilter<E> filter)��������
	 * 
	 * @param list
	 * @return
	 */
	public List<E> filter(List<E> list);

}
