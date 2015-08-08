/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.common.utils.DateConvertUtils;
import java.util.*;

import com.bv.cn.wsbase.user.model.*;
import com.bv.cn.wsbase.user.dao.*;
import com.bv.cn.wsbase.user.dao.impl.*;
import com.bv.cn.wsbase.user.service.*;
import com.bv.cn.wsbase.user.service.impl.*;
import com.bv.cn.wsbase.user.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 角色
 */

@Entity
@Table(name = "UMROLE")
public class Umrole extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "UMROLE";
	public static final String ALIAS_ROLENAME = "rolename";
	public static final String ALIAS_SYSCODE = "syscode";
	public static final String ALIAS_MEMO = "memo";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_ORGRANGE = "orgrange";
	public static final String ALIAS_ROLECODE = "rolecode";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 角色名称 db_column: ROLENAME
	 */
	private java.lang.String rolename;
	/**
	 * 系统代码 db_column: SYSCODE
	 */
	private java.lang.String syscode;
	/**
	 * 备注 db_column: MEMO
	 */
	private java.lang.String memo;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * 组织范围 db_column: ORGRANGE
	 */
	private java.lang.String orgrange;
	/**
	 * 角色代码 db_column: ROLECODE
	 */
	private java.lang.String rolecode;

	// columns END

	public Umrole() {
	}

	public Umrole(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "ROLENAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getRolename() {
		return this.rolename;
	}

	public void setRolename(java.lang.String value) {
		this.rolename = value;
	}

	@Column(name = "SYSCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSyscode() {
		return this.syscode;
	}

	public void setSyscode(java.lang.String value) {
		this.syscode = value;
	}

	@Column(name = "MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String value) {
		this.memo = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	@Column(name = "ORGRANGE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrgrange() {
		return this.orgrange;
	}

	public void setOrgrange(java.lang.String value) {
		this.orgrange = value;
	}

	@Column(name = "ROLECODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getRolecode() {
		return this.rolecode;
	}

	public void setRolecode(java.lang.String value) {
		this.rolecode = value;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid())
				.append("Creater", getCreater())
				.append("Createusername", getCreateusername())
				.append("Createdate", getCreatedate())
				.append("Updater", getUpdater())
				.append("Updateusername", getUpdateusername())
				.append("Updatedate", getUpdatedate())
				.append("FlgDeleted", getFlgDeleted())
				.append("Rolename", getRolename())
				.append("Syscode", getSyscode()).append("Memo", getMemo())
				.append("Showorder", getShoworder())
				.append("Orgrange", getOrgrange())
				.append("Rolecode", getRolecode()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Umrole == false)
			return false;
		if (this == obj)
			return true;
		Umrole other = (Umrole) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
