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
 * @module 角色权限
 */


@Entity
@Table(name = "UMROLERIGHT")
public class Umroleright extends BaseModel implements java.io.Serializable{
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//alias
	public static final String TABLE_ALIAS = "UMROLERIGHT";
			public static final String ALIAS_SYSCODE = "syscode";
			public static final String ALIAS_ROLEID = "roleid";
			public static final String ALIAS_MENUID = "menuid";
			public static final String ALIAS_MENUITEMID = "menuitemid";
			public static final String ALIAS_IS_ADMIN = "isAdmin";
	
	//date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	

	
	//columns START
		    /**
		     * 系统代码       db_column: SYSCODE 
		     */ 
			private java.lang.String syscode;
		    /**
		     * 角色ID       db_column: ROLEID 
		     */ 
			private java.lang.String roleid;
		    /**
		     * 菜单ID       db_column: MENUID 
		     */ 
			private java.lang.String menuid;
		    /**
		     * 菜单功能点ID       db_column: MENUITEMID 
		     */ 
			private java.lang.String menuitemid;
		    /**
		     * 是否管理       db_column: IS_ADMIN 
		     */ 
			@Column(name = "IS_ADMIN", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
			private java.lang.String isAdmin;
	//columns END


	public Umroleright(){
	}

	public Umroleright(
		java.lang.String resourceid
	){
		this.setResourceid(resourceid);
	}

	
	
	
	
	
	
	
	
	
	
	
		
		@Column(name = "SYSCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getSyscode() {
			return this.syscode;
		}
		
		public void setSyscode(java.lang.String value) {
			this.syscode = value;
		}
	
			
	
		
		@Column(name = "ROLEID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getRoleid() {
			return this.roleid;
		}
		
		public void setRoleid(java.lang.String value) {
			this.roleid = value;
		}
	
			
	
		
		@Column(name = "MENUID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getMenuid() {
			return this.menuid;
		}
		
		public void setMenuid(java.lang.String value) {
			this.menuid = value;
		}
	
			
	
		
		@Column(name = "MENUITEMID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
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
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Resourceid",getResourceid())
			.append("Creater",getCreater())
			.append("Createusername",getCreateusername())
			.append("Createdate",getCreatedate())
			.append("Updater",getUpdater())
			.append("Updateusername",getUpdateusername())
			.append("Updatedate",getUpdatedate())
			.append("FlgDeleted",getFlgDeleted())
			.append("Syscode",getSyscode())
			.append("Roleid",getRoleid())
			.append("Menuid",getMenuid())
			.append("Menuitemid",getMenuitemid())
			.append("IsAdmin",getIsAdmin())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResourceid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Umroleright == false) return false;
		if(this == obj) return true;
		Umroleright other = (Umroleright)obj;
		return new EqualsBuilder()
			.append(getResourceid(),other.getResourceid())
			.isEquals();
	}
}

