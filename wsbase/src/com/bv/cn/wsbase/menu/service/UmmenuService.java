/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.service;

import com.bv.cn.base.service.BvBaseService;

import java.util.*;


import com.bv.cn.wsbase.menu.model.*;
import com.bv.cn.wsbase.menu.dao.*;
import com.bv.cn.wsbase.menu.dao.impl.*;
import com.bv.cn.wsbase.menu.service.*;
import com.bv.cn.wsbase.menu.service.impl.*;
import com.bv.cn.wsbase.menu.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

public interface UmmenuService<Ummenu> extends BvBaseService<Ummenu>{

	public Ummenu[] getUserMenus(String syscode, String userid);

	public Ummenu getUserMenu(String syscode, String userid, String menuId);
	
	public Ummenu getMenuByMenucode(String menuCode);
	
}
