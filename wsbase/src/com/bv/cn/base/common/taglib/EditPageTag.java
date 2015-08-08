package com.bv.cn.base.common.taglib;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bv.cn.base.common.config.WebHelper;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.taglib.bean.EditPageBean;
import com.bv.cn.base.common.taglib.bean.EditPageFormBean;

public class EditPageTag extends BodyTagSupport {
	private Log logger = LogFactory.getLog(getClass());

	private String formTitle;// 表单标题

	private String addAttachment = WSConstants.NO;// 是否需要增加附件控件

	private String tabPaneTitle;// 业务表单tabPane控件div标题

	private String debug = WSConstants.NO;// 是否显示调试路由信息；开发时开启

	private String formPage;// form页面

	private String styleClass;// form class
	private String styleId;// form id
	private String name;// form name
	private String method;// form method
	private String action;// form action
	private String enctype;// form enctype
	private String target;// form target
	private String style;// form style=xxx
	private String modulecode;// modulecode

	@SuppressWarnings("unchecked")
	public int doEndTag() {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();

			EditPageBean editPageBean = new EditPageBean();
//			editPageBean.setRunFlow(runFlow);// 是否跑流程
			editPageBean.setResourceId((String) WebHelper
					.getObjectByWebContainer(request,
							WSConstants.SCOPE_REQUEST,
							WSConstants.FIELD_RESOURCEID));
//			editPageBean.setAppType((String) WebHelper.getObjectByWebContainer(
//					request, WSConstants.SCOPE_REQUEST,
//					WSConstants.FIELD_APPTYPE));

			editPageBean.setModulecode(modulecode);
			editPageBean.setFormTitle(formTitle);// 标题
			editPageBean.setTabPaneTitle(tabPaneTitle);// 表单TAB名
			
			String[] tabPaneTitles = tabPaneTitle.split(",");
			if (null != tabPaneTitles && tabPaneTitles.length > 1) {
				String[] formPages = formPage.split(",");
				request.setAttribute(WSConstants.FIELD_TABPANETITLES,
						Arrays.asList(tabPaneTitles));
				request.setAttribute(WSConstants.FIELD_FORMPAGES,
						Arrays.asList(formPages));
			}

			editPageBean.setAddAttachment(addAttachment);// 是否显示附件控件
			editPageBean.setFormPage(formPage);// form 页面
			editPageBean.setMethod(method);// form 页面
			editPageBean.setAction(action);// form 页面
			editPageBean.setEnctype(enctype);// form 页面
			editPageBean.setTarget(target);// form 页面
			editPageBean.setStyle(style);// form 页面

			EditPageFormBean editPageFormBean = new EditPageFormBean();
			editPageFormBean.setId(styleId);
			editPageFormBean.setName(name);
			editPageFormBean.setAction(action);
			editPageFormBean.setMethod(method);
			editPageFormBean.setStyleClass(styleClass);
			request.setAttribute(WSConstants.FIELD_EDITPAGEFORMBEAN,
					editPageFormBean);
			request.setAttribute(WSConstants.FIELD_EDITPAGEBEAN, editPageBean);
			if (WSConstants.YES.equalsIgnoreCase(debug)) {
				Map editPageBeanMap = BeanUtils.describe(editPageBean);
				Map editPageFormBeanMap = BeanUtils.describe(editPageFormBean);
				logger.debug("editPageBean:" + editPageBeanMap);
				logger.debug("editPageFormBean:" + editPageFormBeanMap);
			}
			pageContext.include("/wsbase/common/tag/EditPageTag.jsp",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (EVAL_PAGE);
	}

	private String setFormHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<form ");
		if (getStyleId() != null && !"".equals(getStyleId()))
			sb.append(" id='" + this.getStyleId() + "'");
		if (getName() != null && !"".equals(getName())) {
			sb.append(" name='" + getName() + "' ");
		}
		if (getAction() != null && !"".equals(getAction()))
			sb.append(" action='" + getAction() + "' ");
		if (getMethod() != null && !"".equals(getMethod()))
			sb.append(" method='" + getMethod() + "' ");
		if (getEnctype() != null && !"".equals(getEnctype()))
			sb.append(" enctype='" + getEnctype() + "' ");
		if (getTarget() != null && !"".equals(getTarget()))
			sb.append(" target='" + getTarget() + "' ");
		if (getStyleClass() != null && !"".equals(getStyleClass()))
			sb.append(" class='" + getStyleClass() + "' ");
		if (getStyle() != null && !"".equals(getStyle()))
			sb.append(" style='" + getStyle() + "' ");
		return sb.toString();
	}

	/**
	 * @return the tabPaneTitle
	 */
	public String getTabPaneTitle() {
		return tabPaneTitle;
	}

	/**
	 * @param tabPaneTitle
	 *            the tabPaneTitle to set
	 */
	public void setTabPaneTitle(String tabPaneTitle) {
		this.tabPaneTitle = tabPaneTitle;
	}

	/**
	 * @return the addAttachment
	 */
	public String getAddAttachment() {
		return addAttachment;
	}

	/**
	 * @param addAttachment
	 *            the addAttachment to set
	 */
	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}

	/**
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * @param formTitle
	 *            the formTitle to set
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEnctype() {
		return enctype;
	}

	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormPage() {
		return formPage;
	}

	public void setFormPage(String formPage) {
		this.formPage = formPage;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

}
