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
 * @module 按钮资源-角色模块关系表
 */

@Entity
@Table(name = "T_BUTTON_ROLE_MODULE")
public class TbuttonRoleModule extends BassResModle implements
		java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_BUTTON_ROLE_MODULE";
	public static final String ALIAS_BUTTONID = "buttonid";
	public static final String ALIAS_BUTTONMODULE = "tbuttonModule";
	public static final String ALIAS_ROLEMODULEID = "rolemoduleid";
	public static final String ALIAS_ROLEMODULE = "trolemodule";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 按钮资源ID db_column: BUTTONID
	 */
	// private java.lang.String buttonid;
	/**
	 * 角色模块ID db_column: ROLEMODULEID
	 */
	// private java.lang.String rolemoduleid;
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

	public TbuttonRoleModule() {
	}

	public TbuttonRoleModule(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "BUTTONID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getButtonid() {
	// return this.buttonid;
	// }
	//		
	// public void setButtonid(java.lang.String value) {
	// this.buttonid = value;
	// }

	// @Column(name = "ROLEMODULEID", unique = false, nullable = true,
	// insertable = true, updatable = true, length = 32)
	// public java.lang.String getRolemoduleid() {
	// return this.rolemoduleid;
	// }
	//		
	// public void setRolemoduleid(java.lang.String value) {
	// this.rolemoduleid = value;
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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "BUTTONID", nullable = false, insertable = false, updatable = false) })
	private TbuttonModule tbuttonModule;

	public void setTbuttonModule(TbuttonModule tbuttonModule) {
		this.tbuttonModule = tbuttonModule;
	}

	public TbuttonModule getTbuttonModule() {
		return tbuttonModule;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ROLEMODULEID", nullable = false, insertable = false, updatable = false) })
	private Trolemodule trolemodule;

	public void setTrolemodule(Trolemodule trolemodule) {
		this.trolemodule = trolemodule;
	}

	public Trolemodule getTrolemodule() {
		return trolemodule;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Buttonid",
						this.getTbuttonModule().getResourceid()).append(
						"Rolemoduleid", this.getTrolemodule().getResourceid())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TbuttonRoleModule == false)
			return false;
		if (this == obj)
			return true;
		TbuttonRoleModule other = (TbuttonRoleModule) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
