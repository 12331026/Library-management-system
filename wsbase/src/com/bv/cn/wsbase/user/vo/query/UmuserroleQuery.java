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
 * @module �û���ɫ������
 */
public class UmuserroleQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** Ԫ������ */
	private java.lang.String elemType;
	
	
	
	/** ��ɫIDs */
	private java.lang.String roleids;
	
	
	
	/** ��֯��Χ */
	private java.lang.String orgrange;
	
	
	
	/** ϵͳ���� */
	private java.lang.String systems;
	

	
	public java.lang.String getElemType() {
		return this.elemType;
	}
	
	public void setElemType(java.lang.String value) {
		this.elemType = value;
	}
	
	
	
	public java.lang.String getRoleids() {
		return this.roleids;
	}
	
	public void setRoleids(java.lang.String value) {
		this.roleids = value;
	}
	
	
	
	public java.lang.String getOrgrange() {
		return this.orgrange;
	}
	
	public void setOrgrange(java.lang.String value) {
		this.orgrange = value;
	}
	
	
	
	public java.lang.String getSystems() {
		return this.systems;
	}
	
	public void setSystems(java.lang.String value) {
		this.systems = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

