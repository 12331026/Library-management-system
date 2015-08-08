/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 字典定义
 */

@Entity
@Table(name = "T_DICT")
public class Tdict extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_DICT";
	public static final String ALIAS_DICTNAME = "dictname";
	public static final String ALIAS_DICTCODE = "dictcode";
	public static final String ALIAS_MODULE = "module";
	public static final String ALIAS_SRCTYPE = "srctype";
	public static final String ALIAS_SRCSQL = "srcsql";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 字典代码名称 db_column: DICTNAME
	 */
	private java.lang.String dictname;
	/**
	 * 字典代码 db_column: DICTCODE
	 */
	private java.lang.String dictcode;
	/**
	 * 所属模块 db_column: MODULE
	 */
	private java.lang.String module;
	/**
	 * 数据来源类型 db_column: SRCTYPE
	 */
	private java.lang.String srctype;
	/**
	 * 数据来源SQL db_column: SRCSQL
	 */
	private java.lang.String srcsql;
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

	public Tdict() {
	}

	public Tdict(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "DICTNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDictname() {
		return this.dictname;
	}

	public void setDictname(java.lang.String value) {
		this.dictname = value;
	}

	@Column(name = "DICTCODE", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(java.lang.String value) {
		this.dictcode = value;
	}

	@Column(name = "MODULE", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getModule() {
		return this.module;
	}

	public void setModule(java.lang.String value) {
		this.module = value;
	}

	@Column(name = "SRCTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSrctype() {
		return this.srctype;
	}

	public void setSrctype(java.lang.String value) {
		this.srctype = value;
	}

	@Column(name = "SRCSQL", unique = false, nullable = true, insertable = true, updatable = true, length = 1024)
	public java.lang.String getSrcsql() {
		return this.srcsql;
	}

	public void setSrcsql(java.lang.String value) {
		this.srcsql = value;
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

	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getExt3() {
		return this.ext3;
	}

	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "DICTID")
	@OrderBy("showorder asc")
	private Set<Tdictdetail> tdictdetails = new HashSet(0);

	public void setTdictdetails(Set<Tdictdetail> tdictdetail) {
		this.tdictdetails = tdictdetail;
	}

	public Set<Tdictdetail> getTdictdetails() {
		return tdictdetails;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Dictname", getDictname())
				.append("Dictcode", getDictcode())
				.append("Module", getModule()).append("Srctype", getSrctype())
				.append("Srcsql", getSrcsql()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tdict == false)
			return false;
		if (this == obj)
			return true;
		Tdict other = (Tdict) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
