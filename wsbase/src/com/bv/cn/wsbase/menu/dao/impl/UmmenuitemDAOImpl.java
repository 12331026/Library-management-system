/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.dao.impl;

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


import org.springframework.stereotype.Repository;

import com.bv.cn.base.dao.impl.BvBaseDAOImpl;

@Repository
public class UmmenuitemDAOImpl extends BvBaseDAOImpl<Ummenuitem> implements 
	UmmenuitemDAO<Ummenuitem> {

	public Class getEntityClass() {
		return Ummenuitem.class;
	}
	
}
