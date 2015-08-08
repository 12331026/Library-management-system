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
 * @module 菜单功能点
 */

@Entity
@Table(name = "UMMENUITEM")
public class Ummenuitem extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "UMMENUITEM";
	public static final String ALIAS_MENUID = "menuid";
	public static final String ALIAS_CAPTION = "caption";
	public static final String ALIAS_SHOWTYPE = "showtype";
	public static final String ALIAS_PAGETYPE = "pagetype";
	public static final String ALIAS_JSFUNCTION = "jsfunction";
	public static final String ALIAS_OBJECTID = "objectid";
	public static final String ALIAS_ICONFILE = "iconfile";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_PARAMAP = "paramap";
	public static final String ALIAS_TARGET = "target";
	public static final String ALIAS_REFMENUID = "refmenuid";
	public static final String ALIAS_MEMO = "memo";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 菜单ID db_column: MENUID
	 */
	private java.lang.String menuid;
	/**
	 * 功能点名称 db_column: CAPTION
	 */
	private java.lang.String caption;
	/**
	 * 显示类型 db_column: SHOWTYPE
	 */
	private java.lang.String showtype;
	/**
	 * 页面类型 db_column: PAGETYPE
	 */
	private java.lang.String pagetype;
	/**
	 * JS 方法/URL 链接 db_column: JSFUNCTION
	 */
	private java.lang.String jsfunction;
	/**
	 * 功能点编码 db_column: OBJECTID
	 */
	private java.lang.String objectid;
	/**
	 * 图标文件 db_column: ICONFILE
	 */
	private java.lang.String iconfile;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * 参数 db_column: PARAMAP
	 */
	private java.lang.String paramap;
	/**
	 * 打开目标 db_column: TARGET
	 */
	private java.lang.String target;
	/**
	 * 关联菜单ID db_column: REFMENUID
	 */
	private java.lang.String refmenuid;
	/**
	 * 备注 db_column: MEMO
	 */
	private java.lang.String memo;

	// columns END

	public Ummenuitem() {
	}

	public Ummenuitem(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "MENUID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(java.lang.String value) {
		this.menuid = value;
	}

	@Column(name = "CAPTION", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCaption() {
		return this.caption;
	}

	public void setCaption(java.lang.String value) {
		this.caption = value;
	}

	@Column(name = "SHOWTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getShowtype() {
		return this.showtype;
	}

	public void setShowtype(java.lang.String value) {
		this.showtype = value;
	}

	@Column(name = "PAGETYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getPagetype() {
		return this.pagetype;
	}

	public void setPagetype(java.lang.String value) {
		this.pagetype = value;
	}

	@Column(name = "JSFUNCTION", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsfunction() {
		return this.jsfunction;
	}

	public void setJsfunction(java.lang.String value) {
		this.jsfunction = value;
	}

	@Column(name = "OBJECTID", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getObjectid() {
		return this.objectid;
	}

	public void setObjectid(java.lang.String value) {
		this.objectid = value;
	}

	@Column(name = "ICONFILE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getIconfile() {
		return this.iconfile;
	}

	public void setIconfile(java.lang.String value) {
		this.iconfile = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	@Column(name = "PARAMAP", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getParamap() {
		return this.paramap;
	}

	public void setParamap(java.lang.String value) {
		this.paramap = value;
	}

	@Column(name = "TARGET", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getTarget() {
		return this.target;
	}

	public void setTarget(java.lang.String value) {
		this.target = value;
	}

	@Column(name = "REFMENUID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getRefmenuid() {
		return this.refmenuid;
	}

	public void setRefmenuid(java.lang.String value) {
		this.refmenuid = value;
	}

	@Column(name = "MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String value) {
		this.memo = value;
	}

	private Ummenu ummenu;

	public void setUmmenu(Ummenu ummenu) {
		this.ummenu = ummenu;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "REFMENUID", nullable = false, insertable = false, updatable = false) })
	public Ummenu getUmmenu() {
		return ummenu;
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
				.append("Menuid", getMenuid()).append("Caption", getCaption())
				.append("Showtype", getShowtype())
				.append("Pagetype", getPagetype())
				.append("Jsfunction", getJsfunction())
				.append("Objectid", getObjectid())
				.append("Iconfile", getIconfile())
				.append("Showorder", getShoworder())
				.append("Paramap", getParamap()).append("Target", getTarget())
				.append("Refmenuid", getRefmenuid()).append("Memo", getMemo())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Ummenuitem == false)
			return false;
		if (this == obj)
			return true;
		Ummenuitem other = (Ummenuitem) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
