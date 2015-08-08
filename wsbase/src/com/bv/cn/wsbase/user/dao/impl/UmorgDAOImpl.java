/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.dao.impl;

import java.util.*;


import com.bv.cn.wsbase.user.model.*;
import com.bv.cn.wsbase.user.dao.*;
import com.bv.cn.wsbase.user.dao.impl.*;
import com.bv.cn.wsbase.user.service.*;
import com.bv.cn.wsbase.user.service.impl.*;
import com.bv.cn.wsbase.user.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */


import org.springframework.stereotype.Repository;

import com.bv.cn.base.dao.impl.BvBaseDAOImpl;

@Repository
public class UmorgDAOImpl extends BvBaseDAOImpl<Umorg> implements 
	UmorgDAO<Umorg> {

	public Class getEntityClass() {
		return Umorg.class;
	}
	
}
