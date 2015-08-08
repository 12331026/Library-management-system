package com.bv.cn.base.common.filter;

import java.util.Map;

import com.bv.cn.base.exception.ClientException;

public interface BvClientTemplater<U, K, T> {
	public T execute(U u, K k)
			throws ClientException;
}
