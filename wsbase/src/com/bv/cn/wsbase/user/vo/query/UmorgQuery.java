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
 * @module ��֯
 */
public class UmorgQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** ��֯���� */
	private java.lang.String orgname;
	
	
	
	/** ��� */
	private java.lang.String shortname;
	
	
	
	/** ��֯���� */
	private java.lang.String orgtype;
	
	
	
	/** ��֯���� */
	private java.lang.String orgcode;
	
	
	
	/** ��֯���� */
	private java.lang.String orgattribute;
	
	
	
	/** ����֯ID */
	private java.lang.String parentid;
	
	
	
	/** ��ע */
	private java.lang.String memo;
	
	
	
	/** ��ʾ˳�� */
	private java.math.BigDecimal showorder;
	
	
	
	/** ȫ����ID */
	private java.lang.String parentids;
	
	
	
	/** ȫ�������� */
	private java.lang.String parentnames;
	
	
	
	/** ȫ������֯���� */
	private java.lang.String parenttypes;
	
	
	
	/** �Ƿ�Ϊ�ӽڵ� */
	private java.lang.String leaf;
	
	
	
	/** �쵼�� */
	private java.lang.String leader;
	
	
	
	/** ������ */
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

