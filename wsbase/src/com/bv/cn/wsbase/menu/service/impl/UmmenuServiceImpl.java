/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.service.impl.BvBaseServiveImpl;
import com.bv.cn.wsbase.menu.dao.UmmenuDAO;
import com.bv.cn.wsbase.menu.dao.UmmenuitemDAO;
import com.bv.cn.wsbase.menu.model.Ummenu;
import com.bv.cn.wsbase.menu.model.Ummenuitem;
import com.bv.cn.wsbase.menu.service.UmmenuService;
import com.bv.cn.wsbase.user.dao.UmroleDAO;
import com.bv.cn.wsbase.user.dao.UmrolerightDAO;
import com.bv.cn.wsbase.user.dao.UmuserroleDAO;
import com.bv.cn.wsbase.user.model.Umrole;
import com.bv.cn.wsbase.user.model.Umroleright;
import com.bv.cn.wsbase.user.model.Umuserrole;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UmmenuServiceImpl extends BvBaseServiveImpl<Ummenu> implements
		UmmenuService<Ummenu> {

	public Class getEntityClass() {
		return Ummenu.class;
	}

	private UmmenuDAO<Ummenu> ummenuDAO;

	@Autowired
	private UmmenuitemDAO<Ummenuitem> ummenuitemDAO;

	@Autowired
	private UmuserroleDAO<Umuserrole> umuserroleDAO;

	@Autowired
	private UmroleDAO<Umrole> umroleDAO;

	@Autowired
	private UmrolerightDAO<Umroleright> umrolerightDAO;

	@Autowired
	public void setUmmenuDAO(UmmenuDAO<Ummenu> dao) {
		this.ummenuDAO = dao;
		super.setAppBaseHibernateDAO(dao);
	}

	@Override
	public Ummenu[] getUserMenus(String syscode, String userid) {
		Assert.notNull(syscode);
		Assert.notNull(userid);
		// String hql = "from " + getEntityClass().getName() + " t where t." +
		// Ummenu.ALIAS_SYSCODE + " = ? and t." + Ummenu.alias_
		// super.getListByHql(hql, params)
		Umuserrole userrole = umuserroleDAO._getEntityById(userid);
		String roleids = userrole.getRoleids();
		String[] roleidArray = roleids.split(",");
		Umrole roles[] = new Umrole[roleidArray.length];
		for (int i = 0; i < roleidArray.length; i++) {
			roles[i] = umroleDAO._getEntityById(roleidArray[i]);
		}
		List<Umrole> rolelist = new ArrayList<Umrole>();
		for (Umrole umrole : roles) {
			if (umrole != null || syscode.equals(umrole.getSyscode())) {
				rolelist.add(umrole);
			}
		}
		Set<String> menuidset = new HashSet<String>();
		Set<String> menuitemset = new HashSet<String>();
		Set<Umroleright> rolerightSet = new HashSet<Umroleright>();
		for (int i = 0; i < roles.length; i++) {
			Umrole umrole = roles[i];
			List<Umroleright> umrolerightlist = umrolerightDAO._find("from "
					+ Umroleright.class.getName() + " t where t."
					+ Umroleright.ALIAS_SYSCODE + " = ? and t."
					+ Umroleright.ALIAS_ROLEID + " = ? ",
					new String[] { syscode, umrole.getResourceid() });
			rolerightSet.addAll(umrolerightlist);
			for (Umroleright umroleright : umrolerightlist) {
				menuidset.add(umroleright.getMenuid());
				menuitemset.add(umroleright.getMenuitemid());
			}
		}
		// 顶级菜单
		List<Ummenu> ummenulist = ummenuDAO._find(
				"from " + Ummenu.class.getName() + " t where t."
						+ Ummenu.ALIAS_SYSCODE + " = ? and t."
						+ Ummenu.ALIAS_PARENTID + " is null ",
				new String[] { syscode });
		Set<Ummenu> ummenuSet = new HashSet<Ummenu>();
		for (int i = 0; i < ummenulist.size(); i++) {
			Ummenu ummenu = ummenulist.get(i);
			if (menuidset.contains(ummenu.getResourceid())) {
				ummenuSet.add(ummenu);
			}

		}
		for (Ummenu ummenu : ummenuSet) {
			setChildrenMenu(ummenu, syscode, menuidset, menuitemset, rolerightSet);
		}
		return null;
	}

	private void setChildrenMenu(Ummenu ummenu, String syscode, Set<String> menuidset,
			Set<String> menuitemset, Set<Umroleright> rolerightSet) {
		// 设置menuitems
		List<Ummenuitem> menuitemlist = ummenuitemDAO._find("from "
				+ Ummenuitem.class.getName() + " t where t."
				+ Ummenuitem.ALIAS_MENUID + " = ? ",
				new String[] { ummenu.getResourceid() });
		Set<Ummenuitem> menuitems = new HashSet<Ummenuitem>();
		for (Ummenuitem ummenuitem : menuitemlist) {
			if (menuitemset.contains(ummenuitem.getResourceid())) {
				menuitems.add(ummenuitem);
			}
		}
		ummenu.setUmmenuitems(menuitems);

		if(!WSConstants.LEAF.equals(ummenu.getLeaf()) ){
			//非叶子菜单
			List<Ummenu> childmenulist = ummenuDAO._find("from " + Ummenu.class.getName() + " t where t."
					+ Ummenu.ALIAS_SYSCODE + " = ? and t." + Ummenu.ALIAS_PARENTID
					+ " = ? ", new String[] { syscode, ummenu.getResourceid() });
			Set<Ummenu> ummenuSet = new HashSet<Ummenu>();
			for (int i = 0; i < childmenulist.size(); i++) {
				Ummenu tempummenu = childmenulist.get(i);
				if (menuidset.contains(tempummenu.getResourceid())) {
					ummenuSet.add(tempummenu);
				}
			}
			ummenu.setChildren(ummenuSet.toArray(new Ummenu[0]));
		}
		
	}

	@Override
	public Ummenu getUserMenu(String syscode, String userid, String menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ummenu getMenuByMenucode(String menuCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
