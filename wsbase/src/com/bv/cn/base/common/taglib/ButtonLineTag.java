package com.bv.cn.base.common.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.base.model.TbuttonModule;
import com.bv.cn.wsbase.base.model.TbuttonRoleModule;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.model.Trole;
import com.bv.cn.wsbase.base.model.Trolemodule;
import com.bv.cn.wsbase.base.service.TbuttonRoleModuleService;
import com.bv.cn.wsbase.base.service.TmoduleService;
import com.bv.cn.wsbase.base.service.TroleService;
import com.bv.cn.wsbase.base.service.TrolemoduleService;

public final class ButtonLineTag extends BodyTagSupport {
	protected Log logger = LogFactory.getLog(getClass());

	private String showmodel;// 页面表现类型
	private String modulecode;// 模块代码
	private String rolecode = "";// 角色代码

	protected TroleService<Tdict> troleService = SpringHelper.getBean(
			"troleService", TroleService.class);
	protected TmoduleService<Tmodule> tmoduleService = SpringHelper.getBean(
			"tmoduleService", TmoduleService.class);
	protected TrolemoduleService<Trolemodule> trolemoduleService = SpringHelper
			.getBean("trolemoduleService", TrolemoduleService.class);

	protected TbuttonRoleModuleService<TbuttonRoleModule> tbuttonRoleModuleService = SpringHelper
			.getBean("tbuttonRoleModuleService", TbuttonRoleModuleService.class);

	@Override
	public int doEndTag() throws JspException {
		try {
			LogonVO logonVO = (LogonVO) super.pageContext.getSession()
					.getAttribute(Constants.LOGONVO);
			if ("".equals(StringUtils.trimToEmpty(getRolecode()))) {
				// 如果没配置角色代码， 则默认为当前登陆用户的角色
				this.setRolecode(logonVO.getLogonRole());
			}
			if (this.getRolecode().startsWith(",")) {
				this.setRolecode(this.getRolecode().substring(1));
			}
			if (this.getRolecode().endsWith(",")) {
				this.setRolecode(this.getRolecode().substring(0,
						this.getRolecode().length() - 1));
			}
			String[] roleArr = this.getRolecode().split(",");
			if (roleArr.length > 0) {
			} else {
				return EVAL_PAGE;
			}
			String rmhql = "from " + TbuttonRoleModule.class.getName()
					+ " t where t." + TbuttonRoleModule.ALIAS_BUTTONMODULE
					+ "." + TbuttonModule.ALIAS_SHOWMODEL + " = ? and t."
					+ TbuttonRoleModule.ALIAS_BUTTONMODULE + "."
					+ TbuttonModule.ALIAS_MODULE + "."
					+ Tmodule.ALIAS_MODULECODE + " = ? and t."
					+ TbuttonRoleModule.ALIAS_ROLEMODULE + "."
					+ Trolemodule.ALIAS_ROLE + "." + Trole.ALIAS_ROLECODE
					+ " in (";
			List<String> params = new ArrayList<String>();
			for (int i = 0; i < roleArr.length; i++) {
				if (!StringUtils.trimToEmpty(roleArr[i]).equals("")) {
					if (i == roleArr.length - 1) {
						rmhql += "'" + roleArr[i] + "'";
					} else {
						rmhql += "'" + roleArr[i] + "',";
					}
				}
			}
			rmhql += ")";
			String orderBy = " order by t."
					+ TbuttonRoleModule.ALIAS_BUTTONMODULE + "."
					+ TbuttonModule.ALIAS_SHOWORDER;
			List<TbuttonRoleModule> brmlist = tbuttonRoleModuleService
					.getListsByHql(rmhql + orderBy, new String[] { showmodel,
							modulecode });
			logger.info("find brm.size()=" + brmlist.size());

			StringBuffer sb = new StringBuffer("");
//			String hql = "from " + Tmodule.class.getName() + " t where t."
//					+ Tmodule.ALIAS_MODULECODE + " = ?";
//			Tmodule m = tmoduleService.getUniqueByHql(hql,
//					new String[] { StringUtils.trimToEmpty(modulecode) });
//			sb
//					.append("<input type=\"hidden\" name=\"moduleid\" id=\"moduleid\" value=\""
//							+ StringUtils.trimToEmpty(m.getResourceid())
//							+ "\" />");
//			sb
//					.append("<input type=\"hidden\" name=\"modulecode\" id=\"modulecode\" value=\""
//							+ StringUtils.trimToEmpty(modulecode) + "\" />");
			for (int i = 0; i < brmlist.size(); i++) {
				TbuttonRoleModule brm = brmlist.get(i);
				TbuttonModule bm = brm.getTbuttonModule();
				String btnStr = "<div class=\""
						+ StringUtils.trimToEmpty(bm.getStyleclass())
						+ "\" style=\""
						+ StringUtils.trimToEmpty(bm.getStyle()) + "\" id=\""
						+ bm.getRbcode() + "\"><a href=\"#\" onclick=\""
						+ bm.getOnclick() + "\" >" + bm.getRbname()
						+ "</a></div>";
				sb.append(btnStr + "\r\n");
			}
			sb.append("<div style=\"clear:both;\"></div>");
			pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
			logger.error("", e);
		}

		return EVAL_PAGE;
	}

	public String getShowmodel() {
		return showmodel;
	}

	public void setShowmodel(String showmodel) {
		this.showmodel = showmodel;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

}
