package com.bv.cn.wsbase.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.cn.base.controller.BvBaseController;
import com.bv.cn.wsbase.base.model.Tudcommon;
import com.bv.cn.wsbase.base.service.TudcommonService;

public abstract class AS1BaseController<T> extends BvBaseController<T> {

	@Resource(name = "tudcommonService")
	private TudcommonService<Tudcommon> tudcommonService;

	protected String[] getFullPath(Tudcommon udc, StringBuffer[] sbArr) {
		if (null != udc.getTudcommon()) {
			sbArr[0].insert(0, "," + udc.getResourceid());
			sbArr[1].insert(0, "," + udc.getCommontype());
			return getFullPath(udc.getTudcommon(), sbArr);
		} else {
			sbArr[0].insert(0, "," + udc.getResourceid());
			sbArr[1].insert(0, "," + udc.getCommontype());
			String[] strArr = new String[2];
			strArr[0] = sbArr[0].append(",").toString();
			strArr[1] = sbArr[1].append(",").toString();
			return strArr;
		}
	}
}
