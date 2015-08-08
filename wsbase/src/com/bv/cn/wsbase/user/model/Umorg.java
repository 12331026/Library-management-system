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
 * @module ��֯
 */


@Entity
@Table(name = "UMORG")
public class Umorg extends BaseModel implements java.io.Serializable{
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//alias
	public static final String TABLE_ALIAS = "UMORG";
			public static final String ALIAS_ORGNAME = "orgname";
			public static final String ALIAS_SHORTNAME = "shortname";
			public static final String ALIAS_ORGTYPE = "orgtype";
			public static final String ALIAS_ORGCODE = "orgcode";
			public static final String ALIAS_ORGATTRIBUTE = "orgattribute";
			public static final String ALIAS_PARENTID = "parentid";
			public static final String ALIAS_MEMO = "memo";
			public static final String ALIAS_SHOWORDER = "showorder";
			public static final String ALIAS_PARENTIDS = "parentids";
			public static final String ALIAS_PARENTNAMES = "parentnames";
			public static final String ALIAS_PARENTTYPES = "parenttypes";
			public static final String ALIAS_LEAF = "leaf";
			public static final String ALIAS_LEADER = "leader";
			public static final String ALIAS_PRINCIPAL = "principal";
	
	//date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	

	
	//columns START
		    /**
		     * ��֯����       db_column: ORGNAME 
		     */ 
			private java.lang.String orgname;
		    /**
		     * ���       db_column: SHORTNAME 
		     */ 
			private java.lang.String shortname;
		    /**
		     * ��֯����       db_column: ORGTYPE 
		     */ 
			private java.lang.String orgtype;
		    /**
		     * ��֯����       db_column: ORGCODE 
		     */ 
			private java.lang.String orgcode;
		    /**
		     * ��֯����       db_column: ORGATTRIBUTE 
		     */ 
			private java.lang.String orgattribute;
		    /**
		     * ����֯ID       db_column: PARENTID 
		     */ 
			private java.lang.String parentid;
		    /**
		     * ��ע       db_column: MEMO 
		     */ 
			private java.lang.String memo;
		    /**
		     * ��ʾ˳��       db_column: SHOWORDER 
		     */ 
			private java.math.BigDecimal showorder;
		    /**
		     * ȫ����ID       db_column: PARENTIDS 
		     */ 
			private java.lang.String parentids;
		    /**
		     * ȫ��������       db_column: PARENTNAMES 
		     */ 
			private java.lang.String parentnames;
		    /**
		     * ȫ������֯����       db_column: PARENTTYPES 
		     */ 
			private java.lang.String parenttypes;
		    /**
		     * �Ƿ�Ϊ�ӽڵ�       db_column: LEAF 
		     */ 
			private java.lang.String leaf;
		    /**
		     * �쵼��       db_column: LEADER 
		     */ 
			private java.lang.String leader;
		    /**
		     * ������       db_column: PRINCIPAL 
		     */ 
			private java.lang.String principal;
	//columns END


	public Umorg(){
	}

	public Umorg(
		java.lang.String resourceid
	){
		this.setResourceid(resourceid);
	}

	
	
	
	
	
	
	
	
	
	
	
		
		@Column(name = "ORGNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getOrgname() {
			return this.orgname;
		}
		
		public void setOrgname(java.lang.String value) {
			this.orgname = value;
		}
	
			
	
		
		@Column(name = "SHORTNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getShortname() {
			return this.shortname;
		}
		
		public void setShortname(java.lang.String value) {
			this.shortname = value;
		}
	
			
	
		
		@Column(name = "ORGTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
		public java.lang.String getOrgtype() {
			return this.orgtype;
		}
		
		public void setOrgtype(java.lang.String value) {
			this.orgtype = value;
		}
	
			
	
		
		@Column(name = "ORGCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getOrgcode() {
			return this.orgcode;
		}
		
		public void setOrgcode(java.lang.String value) {
			this.orgcode = value;
		}
	
			
	
		
		@Column(name = "ORGATTRIBUTE", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getOrgattribute() {
			return this.orgattribute;
		}
		
		public void setOrgattribute(java.lang.String value) {
			this.orgattribute = value;
		}
	
			
	
		
		@Column(name = "PARENTID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getParentid() {
			return this.parentid;
		}
		
		public void setParentid(java.lang.String value) {
			this.parentid = value;
		}
	
			
	
		
		@Column(name = "MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 250)
		public java.lang.String getMemo() {
			return this.memo;
		}
		
		public void setMemo(java.lang.String value) {
			this.memo = value;
		}
	
			
	
		
		@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
		public java.math.BigDecimal getShoworder() {
			return this.showorder;
		}
		
		public void setShoworder(java.math.BigDecimal value) {
			this.showorder = value;
		}
	
			
	
		
		@Column(name = "PARENTIDS", unique = false, nullable = true, insertable = true, updatable = true, length = 250)
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
	
			
	
		
		@Column(name = "LEAF", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
		public java.lang.String getLeaf() {
			return this.leaf;
		}
		
		public void setLeaf(java.lang.String value) {
			this.leaf = value;
		}
	
			
	
		
		@Column(name = "LEADER", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getLeader() {
			return this.leader;
		}
		
		public void setLeader(java.lang.String value) {
			this.leader = value;
		}
	
			
	
		
		@Column(name = "PRINCIPAL", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
		public java.lang.String getPrincipal() {
			return this.principal;
		}
		
		public void setPrincipal(java.lang.String value) {
			this.principal = value;
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
			.append("Orgname",getOrgname())
			.append("Shortname",getShortname())
			.append("Orgtype",getOrgtype())
			.append("Orgcode",getOrgcode())
			.append("Orgattribute",getOrgattribute())
			.append("Parentid",getParentid())
			.append("Memo",getMemo())
			.append("Showorder",getShoworder())
			.append("Parentids",getParentids())
			.append("Parentnames",getParentnames())
			.append("Parenttypes",getParenttypes())
			.append("Leaf",getLeaf())
			.append("Leader",getLeader())
			.append("Principal",getPrincipal())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResourceid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Umorg == false) return false;
		if(this == obj) return true;
		Umorg other = (Umorg)obj;
		return new EqualsBuilder()
			.append(getResourceid(),other.getResourceid())
			.isEquals();
	}
}

