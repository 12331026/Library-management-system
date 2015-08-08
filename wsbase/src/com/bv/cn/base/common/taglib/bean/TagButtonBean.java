package com.bv.cn.base.common.taglib.bean;

import com.bv.cn.base.common.consts.WSConstants;

public class TagButtonBean {
	private String id;// td id属性
	private String name;// td name属性
	private String func;
	private String paras;
	private String target;
	private String caption;// 显示名称
	private String isOnAction = WSConstants.NO;// 是否有触发事件
	private String isHide = WSConstants.NO;// 是否隐藏
	private String buttionClass = "bvweb-table-icon-T";// 按钮class文件
	private String wfButtom = WSConstants.NO;// 是否流程按钮
	private String containParam = WSConstants.NO; // 是否含有参数
	private Float showOrder; // 排序

	public String getContainParam() {
		return containParam;
	}

	public void setContainParam(String containParam) {
		this.containParam = containParam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getParas() {
		return paras;
	}

	public void setParas(String paras) {
		this.paras = paras;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getIsOnAction() {
		return isOnAction;
	}

	public void setIsOnAction(String isOnAction) {
		this.isOnAction = isOnAction;
	}

	public String getButtionClass() {
		return buttionClass;
	}

	public void setButtionClass(String buttionClass) {
		this.buttionClass = buttionClass;
	}

	public String getWfButtom() {
		return wfButtom;
	}

	public void setWfButtom(String wfButtom) {
		this.wfButtom = wfButtom;
	}

	public String getIsHide() {
		return isHide;
	}

	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}

	public Float getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Float showOrder) {
		this.showOrder = showOrder;
	}
}
