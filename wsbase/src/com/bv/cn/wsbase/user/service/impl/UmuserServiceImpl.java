/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bv.cn.base.common.utils.MD5Helper;
import com.bv.cn.base.service.BvBaseServiceException;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;
import com.bv.cn.wsbase.user.dao.UmuserDAO;
import com.bv.cn.wsbase.user.model.Umuser;
import com.bv.cn.wsbase.user.service.UmuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UmuserServiceImpl extends BvBaseServiveImpl<Umuser> implements
		UmuserService<Umuser> {

	public Class getEntityClass() {
		return Umuser.class;
	}

	private UmuserDAO<Umuser> umuserDAO;

	@Autowired
	public void setUmuserDAO(UmuserDAO<Umuser> dao) {
		this.umuserDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

	@Override
	public Umuser getLogonInfo(String logonid, String password)
			throws BvBaseServiceException {
		return super.getUniqueByHql("from " + getEntityClass().getName()
				+ " t where t." + Umuser.ALIAS_LOGONID + " = ? and t."
				+ Umuser.ALIAS_PASSWORD + " = ? ", logonid,
				MD5Helper.MD5Encode(password));
	}

	@Override
	public List<Umuser> getUmuserList(String mulriple)
			throws BvBaseServiceException {
		List<Umuser> userlist = new ArrayList<Umuser>(0);
		if (StringUtils.trimToEmpty(mulriple).equals("")) {
			return userlist;
		}
		String hql = "from " + getEntityClass().getName() + " t where t."
				+ Umuser.ALIAS_RESOURCEID + " in (";
		String[] userids = mulriple.split(",");
		if (null == userids || userids.length == 0) {
			return userlist;
		}
		for (String userid : userids) {
			hql += "?,";
		}
		hql = hql.substring(0, hql.length() - 1);
		hql += ")";
		return super.getListsByHql(hql, userids);
	}

}
