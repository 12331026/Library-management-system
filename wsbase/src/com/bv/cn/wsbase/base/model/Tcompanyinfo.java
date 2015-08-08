/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.common.utils.DateConvertUtils;
import java.util.*;


import com.bv.cn.wsbase.base.model.*;
import com.bv.cn.wsbase.base.dao.*;
import com.bv.cn.wsbase.base.dao.impl.*;
import com.bv.cn.wsbase.base.service.*;
import com.bv.cn.wsbase.base.service.impl.*;
import com.bv.cn.wsbase.base.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 企业信息
 */


@Entity
@Table(name = "T_COMPANYINFO")
public class Tcompanyinfo extends BaseModel implements java.io.Serializable{
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//alias
	public static final String TABLE_ALIAS = "T_COMPANYINFO";
			public static final String ALIAS_COMPNAME = "compname";
			public static final String ALIAS_COMPTYPE = "comptype";
			public static final String ALIAS_COMPBELONE = "compbelone";
			public static final String ALIAS_COMPADDRESS = "compaddress";
			public static final String ALIAS_COMPTELE = "comptele";
			public static final String ALIAS_COMPREMARK = "compremark";
			public static final String ALIAS_COMPPORT = "compport";
			public static final String ALIAS_COMPWEBSITE = "compwebsite";
			public static final String ALIAS_SHOWORDER = "showorder";
			public static final String ALIAS_EXT1 = "ext1";
			public static final String ALIAS_EXT2 = "ext2";
			public static final String ALIAS_EXT3 = "ext3";
	
	//date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	

	
	//columns START
		    /**
		     * 企业名称       db_column: COMPNAME 
		     */ 
			private java.lang.String compname;
		    /**
		     * 客户分类       db_column: COMPTYPE 
		     */ 
			private java.lang.String comptype;
		    /**
		     * 企业所属国家地区       db_column: COMPBELONE 
		     */ 
			private java.lang.String compbelone;
		    /**
		     * 企业地址       db_column: COMPADDRESS 
		     */ 
			private java.lang.String compaddress;
		    /**
		     * 商务电话       db_column: COMPTELE 
		     */ 
			private java.lang.String comptele;
		    /**
		     * 备注       db_column: COMPREMARK 
		     */ 
			private java.lang.String compremark;
		    /**
		     * 商务传真       db_column: COMPPORT 
		     */ 
			private java.lang.String compport;
		    /**
		     * 网站       db_column: COMPWEBSITE 
		     */ 
			private java.lang.String compwebsite;
		    /**
		     * 显示顺序       db_column: SHOWORDER 
		     */ 
			private java.math.BigDecimal showorder;
		    /**
		     * 扩展字段1       db_column: EXT1 
		     */ 
			private java.lang.String ext1;
		    /**
		     * 扩展字段2       db_column: EXT2 
		     */ 
			private java.lang.String ext2;
		    /**
		     * 扩展字段3       db_column: EXT3 
		     */ 
			private java.lang.String ext3;
	//columns END


	public Tcompanyinfo(){
	}

	public Tcompanyinfo(
		java.lang.String resourceid
	){
		this.setResourceid(resourceid);
	}

	
	
	
	
	
	
	
	
	
	
	
		
		@Column(name = "COMPNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
		public java.lang.String getCompname() {
			return this.compname;
		}
		
		public void setCompname(java.lang.String value) {
			this.compname = value;
		}
	
			
	
		
		@Column(name = "COMPTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getComptype() {
			return this.comptype;
		}
		
		public void setComptype(java.lang.String value) {
			this.comptype = value;
		}
	
			
	
		
		@Column(name = "COMPBELONE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getCompbelone() {
			return this.compbelone;
		}
		
		public void setCompbelone(java.lang.String value) {
			this.compbelone = value;
		}
	
			
	
		
		@Column(name = "COMPADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
		public java.lang.String getCompaddress() {
			return this.compaddress;
		}
		
		public void setCompaddress(java.lang.String value) {
			this.compaddress = value;
		}
	
			
	
		
		@Column(name = "COMPTELE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getComptele() {
			return this.comptele;
		}
		
		public void setComptele(java.lang.String value) {
			this.comptele = value;
		}
	
			
	
		
		@Column(name = "COMPREMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
		public java.lang.String getCompremark() {
			return this.compremark;
		}
		
		public void setCompremark(java.lang.String value) {
			this.compremark = value;
		}
	
			
	
		
		@Column(name = "COMPPORT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
		public java.lang.String getCompport() {
			return this.compport;
		}
		
		public void setCompport(java.lang.String value) {
			this.compport = value;
		}
	
			
	
		
		@Column(name = "COMPWEBSITE", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
		public java.lang.String getCompwebsite() {
			return this.compwebsite;
		}
		
		public void setCompwebsite(java.lang.String value) {
			this.compwebsite = value;
		}
	
			
	
		
		@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
		public java.math.BigDecimal getShoworder() {
			return this.showorder;
		}
		
		public void setShoworder(java.math.BigDecimal value) {
			this.showorder = value;
		}
	
			
	
		
		@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getExt1() {
			return this.ext1;
		}
		
		public void setExt1(java.lang.String value) {
			this.ext1 = value;
		}
	
			
	
		
		@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getExt2() {
			return this.ext2;
		}
		
		public void setExt2(java.lang.String value) {
			this.ext2 = value;
		}
	
			
	
		
		@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
		public java.lang.String getExt3() {
			return this.ext3;
		}
		
		public void setExt3(java.lang.String value) {
			this.ext3 = value;
		}
	
			
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANYINFOID") 
    @OrderBy("showorder asc")
	private Set<Tcustlink> tcustlinks = new HashSet(0);
	
	public void setTcustlinks(Set<Tcustlink> tcustlink){
		this.tcustlinks = tcustlink;
	}
	
	
	public Set<Tcustlink> getTcustlinks() {
		return tcustlinks;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Resourceid",getResourceid())
			.append("Createdate",getCreatedate())
			.append("Creater",getCreater())
			.append("Createusername",getCreateusername())
			.append("Updatedate",getUpdatedate())
			.append("Updater",getUpdater())
			.append("Updateusername",getUpdateusername())
			.append("FlgDeleted",getFlgDeleted())
			.append("Compname",getCompname())
			.append("Comptype",getComptype())
			.append("Compbelone",getCompbelone())
			.append("Compaddress",getCompaddress())
			.append("Comptele",getComptele())
			.append("Compremark",getCompremark())
			.append("Compport",getCompport())
			.append("Compwebsite",getCompwebsite())
			.append("Showorder",getShoworder())
			.append("Ext1",getExt1())
			.append("Ext2",getExt2())
			.append("Ext3",getExt3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResourceid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Tcompanyinfo == false) return false;
		if(this == obj) return true;
		Tcompanyinfo other = (Tcompanyinfo)obj;
		return new EqualsBuilder()
			.append(getResourceid(),other.getResourceid())
			.isEquals();
	}
}

