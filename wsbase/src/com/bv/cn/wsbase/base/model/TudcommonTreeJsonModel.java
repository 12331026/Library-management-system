package com.bv.cn.wsbase.base.model;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TudcommonTreeJsonModel implements java.io.Serializable {

	private String id;
	private String text;
	private String state;
	private Map<String, String> attribute;
	private List<TudcommonTreeJsonModel> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}

	public List<TudcommonTreeJsonModel> getChildren() {
		return children;
	}

	public void setChildren(List<TudcommonTreeJsonModel> children) {
		this.children = children;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId()).append("text", getText()).append(
						"state", getState())
				.append("attribute", getAttribute()).append("children",
						getChildren()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TudcommonTreeJsonModel == false)
			return false;
		if (this == obj)
			return true;
		TudcommonTreeJsonModel other = (TudcommonTreeJsonModel) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

}
