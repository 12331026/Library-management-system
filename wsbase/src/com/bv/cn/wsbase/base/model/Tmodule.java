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
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
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
 * @module 模块
 */

@Entity
@Table(name = "T_MODULE")
public class Tmodule extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_MODULE";
	public static final String ALIAS_TMODULE = "tmodule";
	public static final String ALIAS_MODULELEVEL = "modulelevel";
	public static final String ALIAS_MODULENAME = "modulename";
	public static final String ALIAS_MODULECODE = "modulecode";
	public static final String ALIAS_MODULETYPE = "moduletype";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 上级模块ID db_column: PARENTMODULEID
	 */
	// private java.lang.String parentmoduleid;
	/**
	 * 模块级别: 1 2 db_column: MODULELEVEL
	 */
	private java.lang.String modulelevel;
	/**
	 * 模块名称 db_column: MODULENAME
	 */
	private java.lang.String modulename;
	/**
	 * 模块代码 db_column: MODULECODE
	 */
	private java.lang.String modulecode;
	/**
	 * 模块类型：附加属性，只标识，没有完整性作用 LIST EDIT db_column: MODULETYPE
	 */
	private java.lang.String moduletype;
	/**
	 * 显示顺序
	 */
	private java.lang.String showorder;
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

	public Tmodule() {
	}

	public Tmodule(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "PARENTMODULEID", unique = false, nullable = true,
	// insertable = true, updatable = true, length = 32)
	// public java.lang.String getParentmoduleid() {
	// return this.parentmoduleid;
	// }
	//
	// public void setParentmoduleid(java.lang.String value) {
	// this.parentmoduleid = value;
	// }

	@Column(name = "MODULELEVEL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getModulelevel() {
		return this.modulelevel;
	}

	public void setModulelevel(java.lang.String value) {
		this.modulelevel = value;
	}

	@Column(name = "MODULENAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getModulename() {
		return this.modulename;
	}

	public void setModulename(java.lang.String value) {
		this.modulename = value;
	}

	@Column(name = "MODULECODE", unique = true, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getModulecode() {
		return this.modulecode;
	}

	public void setModulecode(java.lang.String value) {
		this.modulecode = value;
	}

	@Column(name = "MODULETYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getModuletype() {
		return this.moduletype;
	}

	public void setModuletype(java.lang.String value) {
		this.moduletype = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.String getShoworder() {
		return showorder;
	}

	public void setShoworder(java.lang.String showorder) {
		this.showorder = showorder;
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
	@JoinColumn(name = "PARENTMODULEID")
	@OrderBy("resourceid asc")
	private Set<Tmodule> tmodules = new HashSet(0);

	public void setTmodules(Set<Tmodule> tmodule) {
		this.tmodules = tmodule;
	}

	public Set<Tmodule> getTmodules() {
		return tmodules;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULEID")
	@OrderBy("showorder asc")
	private Set<TbuttonModule> tbuttonModules = new HashSet(0);

	public void setTbuttonModules(Set<TbuttonModule> tbuttonModule) {
		this.tbuttonModules = tbuttonModule;
	}

	public Set<TbuttonModule> getTbuttonModules() {
		return tbuttonModules;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULEID")
	@OrderBy("showorder asc")
	private Set<Tformvalidate> tformvalidates = new HashSet(0);

	public void setTformvalidates(Set<Tformvalidate> tformvalidate) {
		this.tformvalidates = tformvalidate;
	}

	public Set<Tformvalidate> getTformvalidates() {
		return tformvalidates;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULEID")
	private Set<Trolemodule> trolemodules = new HashSet(0);

	public void setTrolemodules(Set<Trolemodule> trolemodule) {
		this.trolemodules = trolemodule;
	}

	public Set<Trolemodule> getTrolemodules() {
		return trolemodules;
	}

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER, optional = true)
	@JoinColumns( { @JoinColumn(name = "PARENTMODULEID", nullable = true, insertable = false, updatable = false) })
	private Tmodule tmodule;

	public void setTmodule(Tmodule tmodule) {
		this.tmodule = tmodule;
	}

	public Tmodule getTmodule() {
		return tmodule;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append(
						"Parentmoduleid",
						this.getTmodule() == null ? "" : this.getTmodule()
								.getResourceid()).append("Modulelevel",
						getModulelevel()).append("Modulename", getModulename())
				.append("Modulecode", getModulecode()).append("Moduletype",
						getModuletype()).append("Showorder", getShoworder())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tmodule == false)
			return false;
		if (this == obj)
			return true;
		Tmodule other = (Tmodule) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
