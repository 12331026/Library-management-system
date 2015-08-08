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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.back.base.model.Tmessage;
import com.bv.cn.tsjylib.base.model.Tborrowbook;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 用户表
 */

@Entity
@Table(name = "T_USER")
@PrimaryKeyJoinColumn(name = "RESOURCEID")
public class Tuser extends Tudcommon implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_USER";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_EMPLOYEENO = "employeeno";
	public static final String ALIAS_ROLES = "roles";
	public static final String ALIAS_VCLEVER = "vclever";
	public static final String ALIAS_TELEPHONE = "telephone";
	public static final String ALIAS_MOBILE = "mobile";
	public static final String ALIAS_EMAIL = "email";

	// columns START
	/**
	 * 密码 db_column: PASSWORD
	 */
	private java.lang.String password;
	/**
	 * 工号 db_column: EMPLOYEENO
	 */
	private java.lang.String employeeno;
	/**
	 * 角色组，用,分开 db_column: ROLES
	 */
	private java.lang.String roles;
	/**
	 * 用户级别： ADMIN：超级用户 USER：普通用户 db_column: VCLEVER
	 */
	private java.lang.String vclever;
	/**
	 * 联系电话 db_column: TELEPHONE
	 */
	private java.lang.String telephone;
	/**
	 * 手机号码 db_column: MOBILE
	 */
	private java.lang.String mobile;
	/**
	 * 邮箱地址 db_column: EMAIL
	 */
	private java.lang.String email;

	/**
	 * 是否可见： V：可见 NV：不可见 db_column: ISSHOW
	 */

	// columns END
	public Tuser() {
	}

	public Tuser(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	@Column(name = "EMPLOYEENO", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getEmployeeno() {
		return this.employeeno;
	}

	public void setEmployeeno(java.lang.String value) {
		this.employeeno = value;
	}

	@Column(name = "ROLES", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRoles() {
		return this.roles;
	}

	public void setRoles(java.lang.String value) {
		this.roles = value;
	}

	@Column(name = "VCLEVER", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getVclever() {
		return this.vclever;
	}

	public void setVclever(java.lang.String value) {
		this.vclever = value;
	}

	@Column(name = "TELEPHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}

	@Column(name = "MOBILE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	@Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String value) {
		this.email = value;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERBELONGID")
	@OrderBy("createdate desc")
	private Set<Torder> torders = new HashSet(0);

	public void setTorders(Set<Torder> torder) {
		this.torders = torder;
	}

	public Set<Torder> getTorders() {
		return torders;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "MSGSRCID")
	@OrderBy("showorder asc")
	private Set<Tmessage> tmessagesrcs = new HashSet(0);

	public void setTmessagesrcs(Set<Tmessage> tmessage) {
		this.tmessagesrcs = tmessage;
	}

	public Set<Tmessage> getTmessagesrcs() {
		return tmessagesrcs;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "MSGDESTID")
	@OrderBy("showorder asc")
	private Set<Tmessage> tmessagedests = new HashSet(0);

	public void setTmessagedests(Set<Tmessage> tmessage) {
		this.tmessagedests = tmessage;
	}

	public Set<Tmessage> getTmessagedests() {
		return tmessagedests;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)//,mappedBy="tuser"
	@JoinColumn(name = "BORROWUSERID")
	@OrderBy("showorder asc")
	private Set<Tborrowbook> tborrowbooks = new HashSet(0);

	public void setTborrowbooks(Set<Tborrowbook> tborrowbook) {
		this.tborrowbooks = tborrowbook;
	}

	public Set<Tborrowbook> getTborrowbooks() {
		return tborrowbooks;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Password",
						getPassword()).append("Roles", getRoles()).append(
						"Vclever", getVclever()).append("Telephone",
						getTelephone()).append("Mobile", getMobile()).append(
						"Email", getEmail()).append(
						"Tudcommon" + super.toString()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tuser == false)
			return false;
		if (this == obj)
			return true;
		Tuser other = (Tuser) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
