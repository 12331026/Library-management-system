/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 用户表
 * @email tigerchen2004@126.com
 */
public class TuserQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 密码 */
	private java.lang.String password;
	
	
	
	/** 角色组，用,分开 */
	private java.lang.String roles;
	
	
	
	/** 用户级别：
ADMIN：超级用户
USER：普通用户 */
	private java.lang.String vclever;
	
	
	
	/** 联系电话 */
	private java.lang.String telephone;
	
	
	
	/** 手机号码 */
	private java.lang.String mobile;
	
	
	
	/** 邮箱地址 */
	private java.lang.String email;
	

	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	
	
	public java.lang.String getRoles() {
		return this.roles;
	}
	
	public void setRoles(java.lang.String value) {
		this.roles = value;
	}
	
	
	
	public java.lang.String getVclever() {
		return this.vclever;
	}
	
	public void setVclever(java.lang.String value) {
		this.vclever = value;
	}
	
	
	
	public java.lang.String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(java.lang.String value) {
		this.telephone = value;
	}
	
	
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

