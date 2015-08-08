/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.service;

import java.util.List;

import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.base.service.BvBaseService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

public interface UmuserService<Umuser> extends BvBaseService<Umuser>{

	public Umuser getLogonInfo(String logonid, String password) throws BvBaseServiceException;
	public List<Umuser> getUmuserList(String mulriple) throws BvBaseServiceException;
}
