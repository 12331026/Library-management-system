package com.bv.cn.base.security.model;

import java.io.Serializable;
import java.util.Calendar;

public class Element implements Serializable {
	private Calendar createTime;
	private Calendar lastModTime;
	private Object value;

	public Element(Object value) {
		this.value = value;
		this.createTime = (this.lastModTime = Calendar.getInstance());
	}

	public Calendar getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public Calendar getLastModTime() {
		return this.lastModTime;
	}

	public void setLastModTime(Calendar lastModTime) {
		this.lastModTime = lastModTime;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
