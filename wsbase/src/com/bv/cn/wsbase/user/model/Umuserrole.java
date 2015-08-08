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
 * @module 用户角色关联表
 */

@Entity
@Table(name = "UMUSERROLE")
public class Umuserrole extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "UMUSERROLE";
	public static final String ALIAS_ELEM_TYPE = "elemType";
	public static final String ALIAS_ROLEIDS = "roleids";
	public static final String ALIAS_ORGRANGE = "orgrange";
	public static final String ALIAS_SYSTEMS = "systems";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 元素类型 db_column: ELEM_TYPE
	 */
	@Column(name = "ELEM_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	private java.lang.String elemType;
	/**
	 * 角色IDs db_column: ROLEIDS
	 */
	private java.lang.String roleids;
	/**
	 * 组织范围 db_column: ORGRANGE
	 */
	private java.lang.String orgrange;
	/**
	 * 系统代码 db_column: SYSTEMS
	 */
	private java.lang.String systems;

	// columns END

	public Umuserrole() {
	}

	public Umuserrole(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	
	public java.lang.String getElemType() {
		return this.elemType;
	}

	public void setElemType(java.lang.String value) {
		this.elemType = value;
	}

	@Column(name = "ROLEIDS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRoleids() {
		return this.roleids;
	}

	public void setRoleids(java.lang.String value) {
		this.roleids = value;
	}

	@Column(name = "ORGRANGE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrgrange() {
		return this.orgrange;
	}

	public void setOrgrange(java.lang.String value) {
		this.orgrange = value;
	}

	@Column(name = "SYSTEMS", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getSystems() {
		return this.systems;
	}

	public void setSystems(java.lang.String value) {
		this.systems = value;
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
				.append("ElemType", getElemType())
				.append("Roleids", getRoleids())
				.append("Orgrange", getOrgrange())
				.append("Systems", getSystems()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Umuserrole == false)
			return false;
		if (this == obj)
			return true;
		Umuserrole other = (Umuserrole) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
