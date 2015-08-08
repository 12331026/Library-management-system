/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BassResModle;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 表单验证
 */

@Entity
@Table(name = "T_FORMVALIDATE")
public class Tformvalidate extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_FORMVALIDATE";
	public static final String ALIAS_FIELDNAME = "fieldname";
	public static final String ALIAS_FIELDID = "fieldid";
	public static final String ALIAS_FIELDTYPE = "fieldtype";
	public static final String ALIAS_FIELDPATTERN = "fieldpattern";
	public static final String ALIAS_FIELDMAXLEN = "fieldmaxlen";
	public static final String ALIAS_FIELDMINLEN = "fieldminlen";
	public static final String ALIAS_FIELDISREQUIRED = "fieldisrequired";
	public static final String ALIAS_MODULEID = "moduleid";
	public static final String ALIAS_MODULE = "tmodule";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_FIELDCHINESENAME = "fieldchinesename";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 页面字段名称 db_column: FIELDNAME
	 */
	private java.lang.String fieldname;
	/**
	 * 页面字段ID db_column: FIELDID
	 */
	private java.lang.String fieldid;
	/**
	 * 页面字段类型 db_column: FIELDTYPE
	 */
	private java.lang.String fieldtype;
	/**
	 * 页面字段正则表达式 db_column: FIELDPATTERN
	 */
	private java.lang.String fieldpattern;
	/**
	 * 页面字段最大长度 db_column: FIELDMAXLEN
	 */
	private java.lang.Integer fieldmaxlen;
	/**
	 * 页面字段最小长度 db_column: FIELDMINLEN
	 */
	private java.lang.Integer fieldminlen;
	/**
	 * 页面字段是否必须填写 db_column: FIELDISREQUIRED
	 */
	private java.lang.String fieldisrequired;
	/**
	 * 模块ID db_column: MODULEID
	 */
	// private java.lang.String moduleid;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.lang.Integer showorder;
	/**
	 * 显示顺序 db_column: FIELDCHINESENAME
	 */
	private java.lang.String fieldchinesename;
	/**
	 * 扩展字段1 db_column: EXT1
	 */
	private java.lang.String ext1;
	/**
	 * 扩展字段2 db_column: EXT2
	 */
	private java.lang.String ext2;
	/**
	 * 扩展字段3 db_column: EXT3
	 */
	private java.lang.String ext3;

	// columns END

	public Tformvalidate() {
	}

	public Tformvalidate(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "FIELDNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getFieldname() {
		return this.fieldname;
	}

	public void setFieldname(java.lang.String value) {
		this.fieldname = value;
	}

	@Column(name = "FIELDID", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(java.lang.String value) {
		this.fieldid = value;
	}

	@Column(name = "FIELDTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFieldtype() {
		return this.fieldtype;
	}

	public void setFieldtype(java.lang.String value) {
		this.fieldtype = value;
	}

	@Column(name = "FIELDPATTERN", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getFieldpattern() {
		return this.fieldpattern;
	}

	public void setFieldpattern(java.lang.String value) {
		this.fieldpattern = value;
	}

	@Column(name = "FIELDMAXLEN", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getFieldmaxlen() {
		return this.fieldmaxlen;
	}

	public void setFieldmaxlen(java.lang.Integer value) {
		this.fieldmaxlen = value;
	}

	@Column(name = "FIELDMINLEN", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getFieldminlen() {
		return this.fieldminlen;
	}

	public void setFieldminlen(java.lang.Integer value) {
		this.fieldminlen = value;
	}

	@Column(name = "FIELDISREQUIRED", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getFieldisrequired() {
		return this.fieldisrequired;
	}

	public void setFieldisrequired(java.lang.String value) {
		this.fieldisrequired = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getShoworder() {
		return showorder;
	}

	public void setShoworder(java.lang.Integer showorder) {
		this.showorder = showorder;
	}

	@Column(name = "FIELDCHINESENAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getFieldchinesename() {
		return fieldchinesename;
	}

	public void setFieldchinesename(java.lang.String fieldchinesename) {
		this.fieldchinesename = fieldchinesename;
	}

	@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt1() {
		return this.ext1;
	}

	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}

	@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt2() {
		return this.ext2;
	}

	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}

	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt3() {
		return this.ext3;
	}

	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "MODULEID", nullable = false, insertable = false, updatable = false) })
	private Tmodule tmodule;

	public void setTmodule(Tmodule tmodule) {
		this.tmodule = tmodule;
	}

	public Tmodule getTmodule() {
		return tmodule;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Fieldname",
						getFieldname()).append("Fieldid", getFieldid()).append(
						"Fieldtype", getFieldtype()).append("Fieldpattern",
						getFieldpattern()).append("Fieldmaxlen",
						getFieldmaxlen()).append("Fieldminlen",
						getFieldminlen()).append("Fieldisrequired",
						getFieldisrequired()).append("Modulecode",
						getTmodule().getModulecode()).append(
						"Fieldchinesename", getFieldchinesename()).append(
						"Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tformvalidate == false)
			return false;
		if (this == obj)
			return true;
		Tformvalidate other = (Tformvalidate) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
