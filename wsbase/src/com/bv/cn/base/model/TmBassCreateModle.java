package com.bv.cn.base.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TmBassCreateModle extends BassCreateModle {
	private transient Boolean selected;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
