/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.common.utils.DateConvertUtils;
import java.util.*;

import com.bv.cn.wsbase.menu.model.*;
import com.bv.cn.wsbase.menu.dao.*;
import com.bv.cn.wsbase.menu.dao.impl.*;
import com.bv.cn.wsbase.menu.service.*;
import com.bv.cn.wsbase.menu.service.impl.*;
import com.bv.cn.wsbase.menu.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 菜单
 */

@Entity
@Table(name = "UMMENU")
public class Ummenu extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "UMMENU";
	public static final String ALIAS_MENUCODE = "menucode";
	public static final String ALIAS_SYSCODE = "syscode";
	public static final String ALIAS_MENUNAME = "menuname";
	public static final String ALIAS_SHOWTYPE = "showtype";
	public static final String ALIAS_REFURL = "refurl";
	public static final String ALIAS_PARENTID = "parentid";
	public static final String ALIAS_SMALLICON = "smallicon";
	public static final String ALIAS_BIGICON = "bigicon";
	public static final String ALIAS_APPTYPE = "apptype";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_PARENTIDS = "parentids";
	public static final String ALIAS_LEAF = "leaf";
	public static final String ALIAS_TARGET = "target";
	public static final String ALIAS_REFSYS = "refsys";
	public static final String ALIAS_PROCESSID = "processid";
	public static final String ALIAS_MENUTYPE = "menutype";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 菜单代码 db_column: MENUCODE
	 */
	private java.lang.String menucode;
	/**
	 * 系统代码 db_column: SYSCODE
	 */
	private java.lang.String syscode;
	/**
	 * 菜单名称 db_column: MENUNAME
	 */
	private java.lang.String menuname;
	/**
	 * 显示类型 db_column: SHOWTYPE
	 */
	private java.lang.String showtype;
	/**
	 * 链接地址 db_column: REFURL
	 */
	private java.lang.String refurl;
	/**
	 * 父菜单ID db_column: PARENTID
	 */
	private java.lang.String parentid;
	/**
	 * 小图标 db_column: SMALLICON
	 */
	private java.lang.String smallicon;
	/**
	 * 大图标 db_column: BIGICON
	 */
	private java.lang.String bigicon;
	/**
	 * 业务类型 db_column: APPTYPE
	 */
	private java.lang.String apptype;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * 全部父ID db_column: PARENTIDS
	 */
	private java.lang.String parentids;
	/**
	 * 是否为子节点 db_column: LEAF
	 */
	private java.lang.String leaf;
	/**
	 * 打开目标 db_column: TARGET
	 */
	private java.lang.String target;
	/**
	 * 关联系统 db_column: REFSYS
	 */
	private java.lang.String refsys;
	/**
	 * 流程ID db_column: PROCESSID
	 */
	private java.lang.String processid;
	/**
	 * 菜单类型 db_column: MENUTYPE
	 */
	private java.lang.String menutype;

	// columns END

	transient private Ummenu [] children;
	
	
	public Ummenu() {
	}

	public Ummenu(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "MENUCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getMenucode() {
		return this.menucode;
	}

	public void setMenucode(java.lang.String value) {
		this.menucode = value;
	}

	@Column(name = "SYSCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSyscode() {
		return this.syscode;
	}

	public void setSyscode(java.lang.String value) {
		this.syscode = value;
	}

	@Column(name = "MENUNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(java.lang.String value) {
		this.menuname = value;
	}

	@Column(name = "SHOWTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.String getShowtype() {
		return this.showtype;
	}

	public void setShowtype(java.lang.String value) {
		this.showtype = value;
	}

	@Column(name = "REFURL", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRefurl() {
		return this.refurl;
	}

	public void setRefurl(java.lang.String value) {
		this.refurl = value;
	}

	@Column(name = "PARENTID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getParentid() {
		return this.parentid;
	}

	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}

	@Column(name = "SMALLICON", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getSmallicon() {
		return this.smallicon;
	}

	public void setSmallicon(java.lang.String value) {
		this.smallicon = value;
	}

	@Column(name = "BIGICON", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getBigicon() {
		return this.bigicon;
	}

	public void setBigicon(java.lang.String value) {
		this.bigicon = value;
	}

	@Column(name = "APPTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getApptype() {
		return this.apptype;
	}

	public void setApptype(java.lang.String value) {
		this.apptype = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	@Column(name = "PARENTIDS", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getParentids() {
		return this.parentids;
	}

	public void setParentids(java.lang.String value) {
		this.parentids = value;
	}

	@Column(name = "LEAF", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.String getLeaf() {
		return this.leaf;
	}

	public void setLeaf(java.lang.String value) {
		this.leaf = value;
	}

	@Column(name = "TARGET", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getTarget() {
		return this.target;
	}

	public void setTarget(java.lang.String value) {
		this.target = value;
	}

	@Column(name = "REFSYS", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getRefsys() {
		return this.refsys;
	}

	public void setRefsys(java.lang.String value) {
		this.refsys = value;
	}

	@Column(name = "PROCESSID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getProcessid() {
		return this.processid;
	}

	public void setProcessid(java.lang.String value) {
		this.processid = value;
	}

	@Column(name = "MENUTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getMenutype() {
		return this.menutype;
	}

	public void setMenutype(java.lang.String value) {
		this.menutype = value;
	}
	
	public Ummenu[] getChildren() {
		return children;
	}

	public void setChildren(Ummenu[] children) {
		this.children = children;
	}

	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "ummenu")
	private Set<Ummenuitem> ummenuitems = new HashSet(0);

	public void setUmmenuitems(Set<Ummenuitem> ummenuitem) {
		this.ummenuitems = ummenuitem;
	}

	
	public Set<Ummenuitem> getUmmenuitems() {
		return ummenuitems;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid())
				.append("Creater", getCreater())
				.append("Createusername", getCreateusername())
				.append("Createdate", getCreatedate())
				.append("Updater", getUpdater())
				.append("Updateusername", getUpdateusername())
				.append("Updatedate", getUpdatedate())
				.append("FlgDeleted", getFlgDeleted())
				.append("Menucode", getMenucode())
				.append("Syscode", getSyscode())
				.append("Menuname", getMenuname())
				.append("Showtype", getShowtype())
				.append("Refurl", getRefurl())
				.append("Parentid", getParentid())
				.append("Smallicon", getSmallicon())
				.append("Bigicon", getBigicon())
				.append("Apptype", getApptype())
				.append("Showorder", getShoworder())
				.append("Parentids", getParentids()).append("Leaf", getLeaf())
				.append("Target", getTarget()).append("Refsys", getRefsys())
				.append("Processid", getProcessid())
				.append("Menutype", getMenutype()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Ummenu == false)
			return false;
		if (this == obj)
			return true;
		Ummenu other = (Ummenu) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
