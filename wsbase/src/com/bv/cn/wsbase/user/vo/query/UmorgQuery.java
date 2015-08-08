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
 * @module 组织
 */
public class UmorgQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 组织名称 */
	private java.lang.String orgname;
	
	
	
	/** 简称 */
	private java.lang.String shortname;
	
	
	
	/** 组织类型 */
	private java.lang.String orgtype;
	
	
	
	/** 组织代码 */
	private java.lang.String orgcode;
	
	
	
	/** 组织属性 */
	private java.lang.String orgattribute;
	
	
	
	/** 父组织ID */
	private java.lang.String parentid;
	
	
	
	/** 备注 */
	private java.lang.String memo;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 全部父ID */
	private java.lang.String parentids;
	
	
	
	/** 全部父名称 */
	private java.lang.String parentnames;
	
	
	
	/** 全部父组织类型 */
	private java.lang.String parenttypes;
	
	
	
	/** 是否为子节点 */
	private java.lang.String leaf;
	
	
	
	/** 领导者 */
	private java.lang.String leader;
	
	
	
	/** 负责人 */
	private java.lang.String principal;
	

	
	public java.lang.String getOrgname() {
		return this.orgname;
	}
	
	public void setOrgname(java.lang.String value) {
		this.orgname = value;
	}
	
	
	
	public java.lang.String getShortname() {
		return this.shortname;
	}
	
	public void setShortname(java.lang.String value) {
		this.shortname = value;
	}
	
	
	
	public java.lang.String getOrgtype() {
		return this.orgtype;
	}
	
	public void setOrgtype(java.lang.String value) {
		this.orgtype = value;
	}
	
	
	
	public java.lang.String getOrgcode() {
		return this.orgcode;
	}
	
	public void setOrgcode(java.lang.String value) {
		this.orgcode = value;
	}
	
	
	
	public java.lang.String getOrgattribute() {
		return this.orgattribute;
	}
	
	public void setOrgattribute(java.lang.String value) {
		this.orgattribute = value;
	}
	
	
	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	
	public void setParentid(java.lang.String value) {
		this.parentid = value;
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
	
	
	
	public java.lang.String getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(java.lang.String value) {
		this.leaf = value;
	}
	
	
	
	public java.lang.String getLeader() {
		return this.leader;
	}
	
	public void setLeader(java.lang.String value) {
		this.leader = value;
	}
	
	
	
	public java.lang.String getPrincipal() {
		return this.principal;
	}
	
	public void setPrincipal(java.lang.String value) {
		this.principal = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

