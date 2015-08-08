package com.bv.cn.base.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.service.BvAppBaseServiceImpl;
import com.bv.cn.base.service.BvBaseService;

@Transactional
public abstract class BvBaseServiveImpl<T> extends BvAppBaseServiceImpl<T>
		implements BvBaseService<T> {

}
