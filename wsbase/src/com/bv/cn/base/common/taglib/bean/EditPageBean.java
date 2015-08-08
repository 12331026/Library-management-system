package com.bv.cn.base.common.taglib.bean;

import com.bv.cn.base.common.consts.WSConstants;

public class EditPageBean {
//	private String runFlow;// 是否跑流程（Y:N）
	private String resourceId;// 表单ResourceId
//	private String appType;// 页面类型
	private String hiddenHtml = null;// 流程隐藏域
	private String formTitle = null;// 标题
	private String tabPaneTitle = null;// 表单TAB名
	private String form = null;// form头HTML--弃用
	private String debug = WSConstants.NO;// 路由信息;
	private String addAttachment = WSConstants.NO;// 是否添加附件
	private String formPage;// form页面

	private String method;// form method
	private String action;// form action
	private String enctype;// form enctype
	private String target;// form target
	private String style;// form style=xxx
	private String modulecode;// modulecode

//	public String getRunFlow() {
//		return runFlow;
//	}
//
//	public void setRunFlow(String runFlow) {
//		this.runFlow = runFlow;
//	}

	public String getHiddenHtml() {
		return hiddenHtml;
	}

	public void setHiddenHtml(String hiddenHtml) {
		this.hiddenHtml = hiddenHtml;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getTabPaneTitle() {
		return tabPaneTitle;
	}

	public void setTabPaneTitle(String tabPaneTitle) {
		this.tabPaneTitle = tabPaneTitle;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getAddAttachment() {
		return addAttachment;
	}

	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

//	public String getAppType() {
//		return appType;
//	}
//
//	public void setAppType(String appType) {
//		this.appType = appType;
//	}

	public String getFormPage() {
		return formPage;
	}

	public void setFormPage(String formPage) {
		this.formPage = formPage;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}
	
	
}
