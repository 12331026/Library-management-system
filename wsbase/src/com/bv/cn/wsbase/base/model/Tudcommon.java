package com.bv.cn.wsbase.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
 * @module 用户部门基表
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "T_UDCOMMON")
public class Tudcommon extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String TABLE_ALIAS_COMMON = "T_UDCOMMON";
	public static final String ALIAS_PARENTID = "parentid";
	public static final String ALIAS_PARENT = "tudcommon";
	public static final String ALIAS_VCNAME = "vcname";
	public static final String ALIAS_COMMONTYPE = "commontype";
	public static final String ALIAS_VCCODE = "vccode";
	public static final String ALIAS_FULLPATH = "fullpath";
	public static final String ALIAS_BELONGPATH = "belongpath";
	public static final String ALIAS_ISSHOW = "isshow";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";
	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 上级部门（所属部门） db_column: PARENTID
	 */
	// private java.lang.String parentid;
	/**
	 * 名称 db_column: VCNAME
	 */
	private java.lang.String vcname;
	/**
	 * 类别 db_column: COMMONTYPE
	 */
	private java.lang.String commontype;
	/**
	 * 编码： 部门为部门编码 用户为用户logonid db_column: VCCODE
	 */
	private java.lang.String vccode;
	/**
	 * 全路径 db_column: FULLPATH
	 */
	private java.lang.String fullpath;
	/**
	 * 从属全路径 db_column: BELONGPATH
	 */
	private java.lang.String belongpath;
	/**
	 * 是否可见： V：可见 NV：不可见 db_column: ISSHOW
	 */
	private java.lang.String isshow;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.lang.Integer showorder;
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

	@Column(name = "VCNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getVcname() {
		return this.vcname;
	}

	public void setVcname(java.lang.String value) {
		this.vcname = value;
	}

	@Column(name = "COMMONTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getCommontype() {
		return this.commontype;
	}

	public void setCommontype(java.lang.String value) {
		this.commontype = value;
	}

	@Column(name = "VCCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getVccode() {
		return this.vccode;
	}

	public void setVccode(java.lang.String value) {
		this.vccode = value;
	}

	@Column(name = "BELONGPATH", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getBelongpath() {
		return this.belongpath;
	}

	public void setBelongpath(java.lang.String value) {
		this.belongpath = value;
	}

	@Column(name = "FULLPATH", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getFullpath() {
		return this.fullpath;
	}

	public void setFullpath(java.lang.String value) {
		this.fullpath = value;
	}

	@Column(name = "ISSHOW", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(java.lang.String value) {
		this.isshow = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.lang.Integer value) {
		this.showorder = value;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENTID")
	@OrderBy("showorder asc")
	private Set<Tudcommon> tudcomons = new HashSet(0);

	public void setTudcommons(Set<Tudcommon> tudcomon) {
		this.tudcomons = tudcomon;
	}

	public Set<Tudcommon> getTudcommons() {
		return tudcomons;
	}

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER, optional = true)
	@JoinColumns( { @JoinColumn(name = "PARENTID", nullable = true, insertable = false, updatable = false) })
	private Tudcommon tudcommon;

	public void setTudcommon(Tudcommon tudcommon) {
		this.tudcommon = tudcommon;
	}

	public Tudcommon getTudcommon() {
		return tudcommon;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append(
						"Parentid",
						getTudcommon() == null ? "" : getTudcommon()
								.getResourceid()).append("Vcname", getVcname())
				.append("Commontype", getCommontype()).append("Vccode",
						getVccode()).append("Fullpath", getFullpath()).append(
						"Belongpath", getBelongpath()).append("Isshow",
						getIsshow()).append("Showorder", getShoworder())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tudcommon == false)
			return false;
		if (this == obj)
			return true;
		Tudcommon other = (Tudcommon) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
