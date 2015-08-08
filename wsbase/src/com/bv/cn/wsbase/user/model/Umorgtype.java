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
 * @module 组织类型
 */


@Entity
@Table(name = "UMORGTYPE")
public class Umorgtype extends BaseModel implements java.io.Serializable{
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//alias
	public static final String TABLE_ALIAS = "UMORGTYPE";
			public static final String ALIAS_TYPECODE = "typecode";
			public static final String ALIAS_TYPENAME = "typename";
			public static final String ALIAS_SMALLICON = "smallicon";
			public static final String ALIAS_LARGEICON = "largeicon";
			public static final String ALIAS_SHOWORDER = "showorder";
	
	//date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	

	
	//columns START
		    /**
		     * 组织类型编码       db_column: TYPECODE 
		     */ 
			private java.lang.String typecode;
		    /**
		     * 组织类型名称       db_column: TYPENAME 
		     */ 
			private java.lang.String typename;
		    /**
		     * 小图标       db_column: SMALLICON 
		     */ 
			private java.lang.String smallicon;
		    /**
		     * 大图标       db_column: LARGEICON 
		     */ 
			private java.lang.String largeicon;
		    /**
		     * 显示顺序       db_column: SHOWORDER 
		     */ 
			private java.math.BigDecimal showorder;
	//columns END


	public Umorgtype(){
	}

	public Umorgtype(
		java.lang.String resourceid
	){
		this.setResourceid(resourceid);
	}

	
	
	
	
	
	
	
	
	
	
	
		
		@Column(name = "TYPECODE", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
		public java.lang.String getTypecode() {
			return this.typecode;
		}
		
		public void setTypecode(java.lang.String value) {
			this.typecode = value;
		}
	
			
	
		
		@Column(name = "TYPENAME", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getTypename() {
			return this.typename;
		}
		
		public void setTypename(java.lang.String value) {
			this.typename = value;
		}
	
			
	
		
		@Column(name = "SMALLICON", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getSmallicon() {
			return this.smallicon;
		}
		
		public void setSmallicon(java.lang.String value) {
			this.smallicon = value;
		}
	
			
	
		
		@Column(name = "LARGEICON", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getLargeicon() {
			return this.largeicon;
		}
		
		public void setLargeicon(java.lang.String value) {
			this.largeicon = value;
		}
	
			
	
		
		@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
		public java.math.BigDecimal getShoworder() {
			return this.showorder;
		}
		
		public void setShoworder(java.math.BigDecimal value) {
			this.showorder = value;
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
			.append("Typecode",getTypecode())
			.append("Typename",getTypename())
			.append("Smallicon",getSmallicon())
			.append("Largeicon",getLargeicon())
			.append("Showorder",getShoworder())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResourceid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Umorgtype == false) return false;
		if(this == obj) return true;
		Umorgtype other = (Umorgtype)obj;
		return new EqualsBuilder()
			.append(getResourceid(),other.getResourceid())
			.isEquals();
	}
}

