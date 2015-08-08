package com.bv.cn.base.common.utils;

import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.base.model.Tuser;

public abstract class LogonVOUtils {
	private static LogonVO logonVO;

	public static LogonVO currLogonVO() {
		return logonVO;
	}

	public static void setLogonVO(LogonVO vo) {
		logonVO = vo;
	}

	public static LogonVO user2logonvo(Tuser user) {
		LogonVO logonVO = new LogonVO();
		logonVO.setUserid(user.getResourceid());
		logonVO.setUserCode(user.getVccode());
		logonVO.setUserName(user.getVcname());
		logonVO.setPassword(user.getPassword());
		logonVO.setEndpointtype(user.getVclever());
		logonVO.setLogonRole(user.getRoles());
		setLogonVO(logonVO);
		return logonVO;
	}
}
