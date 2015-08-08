/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.TperfStat;
import com.bv.cn.wsbase.base.service.TperfStatService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 性能日志表
 */

@Controller
public class TperfStatController extends AS1BaseController<TperfStat> {
	@Resource
	private TperfStatService<TperfStat> tperfStatService;

	@Override
	public BvAppBaseService<TperfStat> getBaseService() {
		return tperfStatService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/tperfStat/tperfStat_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/tperfStat/tperfStat_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/tperfStat/tperfStat_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/tperfStat/tperfStat_form");
	}

}
