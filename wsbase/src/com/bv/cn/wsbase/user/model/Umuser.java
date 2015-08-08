/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.common.utils.DateConvertUtils;
import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 用户
 */

@Entity
@Table(name = "UMUSER")
public class Umuser extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "UMUSER";
	public static final String ALIAS_LOGONID = "logonid";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_LIMIT_DATE = "limitDate";
	public static final String ALIAS_EMPLOEEID = "emploeeid";
	public static final String ALIAS_ENNAME = "enname";
	public static final String ALIAS_FULLNAME = "fullname";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_OFFICEPHONE = "officephone";
	public static final String ALIAS_MOBILE = "mobile";
	public static final String ALIAS_FAX = "fax";
	public static final String ALIAS_POSTID = "postid";
	public static final String ALIAS_ORGID = "orgid";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_LEADER = "leader";
	public static final String ALIAS_MULRIPLE = "mulriple";
	public static final String ALIAS_PARENTIDS = "parentids";
	public static final String ALIAS_PARENTNAMES = "parentnames";
	public static final String ALIAS_PARENTTYPES = "parenttypes";
	public static final String ALIAS_LOGINTYPE = "logintype";
	public static final String ALIAS_MEMO = "memo";
	public static final String ALIAS_LASTLOGIN = "lastlogin";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	public static final String FORMAT_LIMIT_DATE = DATE_FORMAT;

	// columns START
	/**
	 * 登陆ID db_column: LOGONID
	 */
	private java.lang.String logonid;
	/**
	 * 用户名称 db_column: USERNAME
	 */
	private java.lang.String username;
	/**
	 * 登录密码 db_column: PASSWORD
	 */
	private java.lang.String password;
	/**
	 * 使用期限 db_column: LIMIT_DATE
	 */
	@Column(name = "LIMIT_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	private java.util.Date limitDate;
	/**
	 * 佣工ID db_column: EMPLOEEID
	 */
	private java.lang.String emploeeid;
	/**
	 * 英文名 db_column: ENNAME
	 */
	private java.lang.String enname;
	/**
	 * 全名 db_column: FULLNAME
	 */
	private java.lang.String fullname;
	/**
	 * 职务 db_column: TITLE
	 */
	private java.lang.String title;
	/**
	 * 邮箱 db_column: EMAIL
	 */
	private java.lang.String email;
	/**
	 * 办公电话 db_column: OFFICEPHONE
	 */
	private java.lang.String officephone;
	/**
	 * 手机 db_column: MOBILE
	 */
	private java.lang.String mobile;
	/**
	 * 传真 db_column: FAX
	 */
	private java.lang.String fax;
	/**
	 * 岗位 db_column: POSTID
	 */
	private java.lang.String postid;
	/**
	 * 组织ID db_column: ORGID
	 */
	private java.lang.String orgid;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * 领导人 db_column: LEADER
	 */
	private java.lang.String leader;
	/**
	 * 多重身份 db_column: MULRIPLE
	 */
	private java.lang.String mulriple;
	/**
	 * 全部父组织ID db_column: PARENTIDS
	 */
	private java.lang.String parentids;
	/**
	 * 全部父组织名称 db_column: PARENTNAMES
	 */
	private java.lang.String parentnames;
	/**
	 * 全部父组织类型 db_column: PARENTTYPES
	 */
	private java.lang.String parenttypes;
	/**
	 * 登陆类型 db_column: LOGINTYPE
	 */
	private java.lang.String logintype;
	/**
	 * 备注 db_column: MEMO
	 */
	private java.lang.String memo;
	/**
	 * 最后登录时间 db_column: LASTLOGIN
	 */
	private java.util.Date lastlogin;
	// columns END

	// 是否超级用户 是：Y，否：N
	transient private String spuser;
	

	// 是否超出有效期  超出：Y，未超粗：N
	transient private String outofdate;

	public boolean isSuper() {
		if (spuser != null && "Y".equals(spuser)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOutofdate() {
		if(null != outofdate && "N".equals(outofdate)) {
			return false;
		} else {
			return true;
		}
	}

	public void wrap() {
		outofdate = "N";
		Date limitDate = this.getLimitDate();
		if(null != limitDate) {
			if(limitDate.before(Calendar.getInstance().getTime())) {
				//有效时间 在 当前时间之前 -- 无效
				outofdate = "Y";
			}
		}
	}
	public Umuser() {
	}

	public Umuser(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "LOGONID", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getLogonid() {
		return this.logonid;
	}

	public void setLogonid(java.lang.String value) {
		this.logonid = value;
	}

	@Column(name = "USERNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getUsername() {
		return this.username;
	}

	public void setUsername(java.lang.String value) {
		this.username = value;
	}

	@Column(name = "PASSWORD", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	@Transient
	public String getLimitDateString() {
		return DateConvertUtils.format(getLimitDate(), FORMAT_LIMIT_DATE);
	}

	
	public java.util.Date getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(java.util.Date value) {
		this.limitDate = value;
	}

	@Column(name = "EMPLOEEID", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getEmploeeid() {
		return this.emploeeid;
	}

	public void setEmploeeid(java.lang.String value) {
		this.emploeeid = value;
	}

	@Column(name = "ENNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getEnname() {
		return this.enname;
	}

	public void setEnname(java.lang.String value) {
		this.enname = value;
	}

	@Column(name = "FULLNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getFullname() {
		return this.fullname;
	}

	public void setFullname(java.lang.String value) {
		this.fullname = value;
	}

	@Column(name = "TITLE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String value) {
		this.title = value;
	}

	@Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String value) {
		this.email = value;
	}

	@Column(name = "OFFICEPHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(java.lang.String value) {
		this.officephone = value;
	}

	@Column(name = "MOBILE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	@Column(name = "FAX", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFax() {
		return this.fax;
	}

	public void setFax(java.lang.String value) {
		this.fax = value;
	}

	@Column(name = "POSTID", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getPostid() {
		return this.postid;
	}

	public void setPostid(java.lang.String value) {
		this.postid = value;
	}

	@Column(name = "ORGID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(java.lang.String value) {
		this.orgid = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	@Column(name = "LEADER", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getLeader() {
		return this.leader;
	}

	public void setLeader(java.lang.String value) {
		this.leader = value;
	}

	@Column(name = "MULRIPLE", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getMulriple() {
		return this.mulriple;
	}

	public void setMulriple(java.lang.String value) {
		this.mulriple = value;
	}

	@Column(name = "PARENTIDS", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getParentids() {
		return this.parentids;
	}

	public void setParentids(java.lang.String value) {
		this.parentids = value;
	}

	@Column(name = "PARENTNAMES", unique = false, nullable = true, insertable = true, updatable = true, length = 400)
	public java.lang.String getParentnames() {
		return this.parentnames;
	}

	public void setParentnames(java.lang.String value) {
		this.parentnames = value;
	}

	@Column(name = "PARENTTYPES", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getParenttypes() {
		return this.parenttypes;
	}

	public void setParenttypes(java.lang.String value) {
		this.parenttypes = value;
	}

	@Column(name = "LOGINTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(java.lang.String value) {
		this.logintype = value;
	}

	@Column(name = "MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String value) {
		this.memo = value;
	}

	public java.util.Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(java.util.Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getSpuser() {
		return spuser;
	}

	public void setSpuser(String spuser) {
		this.spuser = spuser;
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
				.append("Logonid", getLogonid())
				.append("Username", getUsername())
				.append("Password", getPassword())
				.append("LimitDate", getLimitDate())
				.append("Emploeeid", getEmploeeid())
				.append("Enname", getEnname())
				.append("Fullname", getFullname()).append("Title", getTitle())
				.append("Email", getEmail())
				.append("Officephone", getOfficephone())
				.append("Mobile", getMobile()).append("Fax", getFax())
				.append("Postid", getPostid()).append("Orgid", getOrgid())
				.append("Showorder", getShoworder())
				.append("Leader", getLeader())
				.append("Mulriple", getMulriple())
				.append("Parentids", getParentids())
				.append("Parentnames", getParentnames())
				.append("Parenttypes", getParenttypes())
				.append("Logintype", getLogintype()).append("Memo", getMemo())
				.append("Lastlogin", getLastlogin())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Umuser == false)
			return false;
		if (this == obj)
			return true;
		Umuser other = (Umuser) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
