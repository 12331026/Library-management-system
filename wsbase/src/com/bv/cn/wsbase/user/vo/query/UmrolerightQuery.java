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
 * @module ��ɫȨ��
 */
public class UmrolerightQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** ϵͳ���� */
	private java.lang.String syscode;
	
	
	
	/** ��ɫID */
	private java.lang.String roleid;
	
	
	
	/** �˵�ID */
	private java.lang.String menuid;
	
	
	
	/** �˵����ܵ�ID */
	private java.lang.String menuitemid;
	
	
	
	/** �Ƿ���� */
	private java.lang.String isAdmin;
	

	
	public java.lang.String getSyscode() {
		return this.syscode;
	}
	
	public void setSyscode(java.lang.String value) {
		this.syscode = value;
	}
	
	
	
	public java.lang.String getRoleid() {
		return this.roleid;
	}
	
	public void setRoleid(java.lang.String value) {
		this.roleid = value;
	}
	
	
	
	public java.lang.String getMenuid() {
		return this.menuid;
	}
	
	public void setMenuid(java.lang.String value) {
		this.menuid = value;
	}
	
	
	
	public java.lang.String getMenuitemid() {
		return this.menuitemid;
	}
	
	public void setMenuitemid(java.lang.String value) {
		this.menuitemid = value;
	}
	
	
	
	public java.lang.String getIsAdmin() {
		return this.isAdmin;
	}
	
	public void setIsAdmin(java.lang.String value) {
		this.isAdmin = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

