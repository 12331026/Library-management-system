package com.bv.cn.base.common.cache;

import java.util.List;

public interface BvICachePurger<E> {

	public void purge(List<E> list);

	public List<E> get();
}
