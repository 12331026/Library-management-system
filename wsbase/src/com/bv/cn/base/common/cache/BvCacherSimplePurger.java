package com.bv.cn.base.common.cache;

import java.util.ArrayList;
import java.util.List;

public class BvCacherSimplePurger<E> extends BvAbstractCacherPurger<E> {

	private List<E> data;

	public BvCacherSimplePurger() {
		data = new ArrayList<E>();
	}

	@Override
	/**
	 *ǳ����
	 */
	public void purge(List<E> list) {
		this.data = list;
	}

	@Override
	public List<E> get() {
		return data;
	}

}
