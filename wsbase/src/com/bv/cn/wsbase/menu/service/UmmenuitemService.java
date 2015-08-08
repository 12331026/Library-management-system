/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.service;

import com.bv.cn.base.service.BvBaseService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

public interface UmmenuitemService<Ummenuitem> extends BvBaseService<Ummenuitem>{

	public Ummenuitem[] queryMenuitems(String userid, String menuCode, String pageType);
	
	
}
