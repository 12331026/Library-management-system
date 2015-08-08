package com.bv.cn.base.common.taglib.bean;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ImagelinkListBean {
	private String divid;
	private String arrange = "column";// column/row
	private String isModelless = "true";
	private String imagetype;
	private String modulebelong;
	private String basepath;
	private String requseturi;
	private String resourceids;
	private String isMultiple = "false";
	private String writebackDivid;
	private String itemWidth = "120px";
	private String itemHeight = "120px";
	private String itemArrange = "column";// column/row
	private String fieldId = "imageid";// column/row

	public String getDivid() {
		return divid;
	}

	public void setDivid(String divid) {
		this.divid = divid;
	}

	public String getArrange() {
		return arrange;
	}

	public void setArrange(String arrange) {
		this.arrange = arrange;
	}

	public String getIsModelless() {
		return isModelless;
	}

	public void setIsModelless(String isModelless) {
		this.isModelless = isModelless;
	}

	public String getImagetype() {
		return imagetype;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public String getModulebelong() {
		return modulebelong;
	}

	public void setModulebelong(String modulebelong) {
		this.modulebelong = modulebelong;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getRequseturi() {
		return requseturi;
	}

	public void setRequseturi(String requseturi) {
		this.requseturi = requseturi;
	}

	public String getResourceids() {
		return resourceids;
	}

	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}

	public String getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(String isMultiple) {
		this.isMultiple = isMultiple;
	}

	public String getWritebackDivid() {
		return writebackDivid;
	}

	public void setWritebackDivid(String writebackDivid) {
		this.writebackDivid = writebackDivid;
	}

	public String getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	public String getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	public String getItemArrange() {
		return itemArrange;
	}

	public void setItemArrange(String itemArrange) {
		this.itemArrange = itemArrange;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceids", getResourceids()).append("Divid",
						getDivid()).toString();
	}
}
