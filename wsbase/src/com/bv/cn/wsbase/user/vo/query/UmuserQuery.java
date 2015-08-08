/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 用户
 */
public class UmuserQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 登陆ID */
	private java.lang.String logonid;
	
	
	
	/** 用户名称 */
	private java.lang.String username;
	
	
	
	/** 登录密码 */
	private java.lang.String password;
	
	
	
	/** 使用期限 */
	private java.util.Date limitDateBegin;
	private java.util.Date limitDateEnd;
	
	
	
	/** 佣工ID */
	private java.lang.String emploeeid;
	
	
	
	/** 英文名 */
	private java.lang.String enname;
	
	
	
	/** 全名 */
	private java.lang.String fullname;
	
	
	
	/** 职务 */
	private java.lang.String title;
	
	
	
	/** 邮箱 */
	private java.lang.String email;
	
	
	
	/** 办公电话 */
	private java.lang.String officephone;
	
	
	
	/** 手机 */
	private java.lang.String mobile;
	
	
	
	/** 传真 */
	private java.lang.String fax;
	
	
	
	/** 岗位 */
	private java.lang.String postid;
	
	
	
	/** 组织ID */
	private java.lang.String orgid;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 领导人 */
	private java.lang.String leader;
	
	
	
	/** 多重身份 */
	private java.lang.String mulriple;
	
	
	
	/** 全部父组织ID */
	private java.lang.String parentids;
	
	
	
	/** 全部父组织名称 */
	private java.lang.String parentnames;
	
	
	
	/** 全部父组织类型 */
	private java.lang.String parenttypes;
	
	
	
	/** 登陆类型 */
	private java.lang.String logintype;
	
	
	
	/** 备注 */
	private java.lang.String memo;
	

	
	public java.lang.String getLogonid() {
		return this.logonid;
	}
	
	public void setLogonid(java.lang.String value) {
		this.logonid = value;
	}
	
	
	
	public java.lang.String getUsername() {
		return this.username;
	}
	
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	
	
	public java.util.Date getLimitDateBegin() {
		return this.limitDateBegin;
	}
	
	public void setLimitDateBegin(java.util.Date value) {
		this.limitDateBegin = value;
	}	
	
	public java.util.Date getLimitDateEnd() {
		return this.limitDateEnd;
	}
	
	public void setLimitDateEnd(java.util.Date value) {
		this.limitDateEnd = value;
	}
	
	
	
	public java.lang.String getEmploeeid() {
		return this.emploeeid;
	}
	
	public void setEmploeeid(java.lang.String value) {
		this.emploeeid = value;
	}
	
	
	
	public java.lang.String getEnname() {
		return this.enname;
	}
	
	public void setEnname(java.lang.String value) {
		this.enname = value;
	}
	
	
	
	public java.lang.String getFullname() {
		return this.fullname;
	}
	
	public void setFullname(java.lang.String value) {
		this.fullname = value;
	}
	
	
	
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	
	
	public java.lang.String getOfficephone() {
		return this.officephone;
	}
	
	public void setOfficephone(java.lang.String value) {
		this.officephone = value;
	}
	
	
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	
	
	public java.lang.String getFax() {
		return this.fax;
	}
	
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	
	
	public java.lang.String getPostid() {
		return this.postid;
	}
	
	public void setPostid(java.lang.String value) {
		this.postid = value;
	}
	
	
	
	public java.lang.String getOrgid() {
		return this.orgid;
	}
	
	public void setOrgid(java.lang.String value) {
		this.orgid = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getLeader() {
		return this.leader;
	}
	
	public void setLeader(java.lang.String value) {
		this.leader = value;
	}
	
	
	
	public java.lang.String getMulriple() {
		return this.mulriple;
	}
	
	public void setMulriple(java.lang.String value) {
		this.mulriple = value;
	}
	
	
	
	public java.lang.String getParentids() {
		return this.parentids;
	}
	
	public void setParentids(java.lang.String value) {
		this.parentids = value;
	}
	
	
	
	public java.lang.String getParentnames() {
		return this.parentnames;
	}
	
	public void setParentnames(java.lang.String value) {
		this.parentnames = value;
	}
	
	
	
	public java.lang.String getParenttypes() {
		return this.parenttypes;
	}
	
	public void setParenttypes(java.lang.String value) {
		this.parenttypes = value;
	}
	
	
	
	public java.lang.String getLogintype() {
		return this.logintype;
	}
	
	public void setLogintype(java.lang.String value) {
		this.logintype = value;
	}
	
	
	
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

