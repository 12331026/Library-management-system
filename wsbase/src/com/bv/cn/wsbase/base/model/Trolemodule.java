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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * @module 角色权限表
 */

@Entity
@Table(name = "T_ROLEMODULE")
public class Trolemodule extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_ROLEMODULE";
	public static final String ALIAS_ROLE = "trole";
	public static final String ALIAS_ROLEID = "roleid";
	public static final String ALIAS_MODULEID = "moduleid";
	public static final String ALIAS_MODULE = "tmodule";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 角色ID db_column: ROLEID
	 */
	// private java.lang.String roleid;
	/**
	 * 模块ID db_column: MODULEID
	 */
	// private java.lang.String moduleid;
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

	public Trolemodule() {
	}

	public Trolemodule(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "ROLEID", unique = false, nullable = true, insertable =
	// true,
	// updatable = true, length = 32)
	// public java.lang.String getRoleid() {
	// return this.roleid;
	// }
	//
	// public void setRoleid(java.lang.String value) {
	// this.roleid = value;
	// }

	// @Column(name = "MODULEID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getModuleid() {
	// return this.moduleid;
	// }
	//
	// public void setModuleid(java.lang.String value) {
	// this.moduleid = value;
	// }

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
	@JoinColumn(name = "ROLEMODULEID") 
    @OrderBy("resourceid asc")
	private Set<TbuttonRoleModule> tbuttonRoleModules = new HashSet(0);
	
	public void setTbuttonRoleModules(Set<TbuttonRoleModule> tbuttonRoleModule){
		this.tbuttonRoleModules = tbuttonRoleModule;
	}
	
	
	public Set<TbuttonRoleModule> getTbuttonRoleModules() {
		return tbuttonRoleModules;
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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ROLEID", nullable = false, insertable = false, updatable = false) })
	private Trole trole;

	public void setTrole(Trole trole) {
		this.trole = trole;
	}

	public Trole getTrole() {
		return trole;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append(
						"Roleid",
						this.getTrole() == null ? "" : this.getTrole()
								.getResourceid()).append(
						"Moduleid",
						this.getTmodule() == null ? "" : this.getTmodule()
								.getResourceid()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Trolemodule == false)
			return false;
		if (this == obj)
			return true;
		Trolemodule other = (Trolemodule) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
