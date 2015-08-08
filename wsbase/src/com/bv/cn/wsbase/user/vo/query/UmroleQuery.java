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
 * @module 角色
 */
public class UmroleQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 角色名称 */
	private java.lang.String rolename;
	
	
	
	/** 系统代码 */
	private java.lang.String syscode;
	
	
	
	/** 备注 */
	private java.lang.String memo;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 组织范围 */
	private java.lang.String orgrange;
	
	
	
	/** 角色代码 */
	private java.lang.String rolecode;
	

	
	public java.lang.String getRolename() {
		return this.rolename;
	}
	
	public void setRolename(java.lang.String value) {
		this.rolename = value;
	}
	
	
	
	public java.lang.String getSyscode() {
		return this.syscode;
	}
	
	public void setSyscode(java.lang.String value) {
		this.syscode = value;
	}
	
	
	
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getOrgrange() {
		return this.orgrange;
	}
	
	public void setOrgrange(java.lang.String value) {
		this.orgrange = value;
	}
	
	
	
	public java.lang.String getRolecode() {
		return this.rolecode;
	}
	
	public void setRolecode(java.lang.String value) {
		this.rolecode = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

