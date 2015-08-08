/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.common.utils.DateConvertUtils;
import java.util.*;

import com.bv.cn.tsjylib.base.model.*;
import com.bv.cn.tsjylib.base.dao.*;
import com.bv.cn.tsjylib.base.dao.impl.*;
import com.bv.cn.tsjylib.base.service.*;
import com.bv.cn.tsjylib.base.service.impl.*;
import com.bv.cn.tsjylib.base.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module
 */

@Entity
@Table(name = "t_bookinfo")
public class Tbookinfo extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "t_bookinfo";
	public static final String ALIAS_BOOKTYPE = "booktype";
	public static final String ALIAS_BOOKCODE = "bookcode";
	public static final String ALIAS_BOOKNAME = "bookname";
	public static final String ALIAS_BOOKSHELF = "bookshelf";
	public static final String ALIAS_TOTALCOUNT = "totalcount";
	public static final String ALIAS_LEFTCOUNT = "leftcount";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 所属类别 db_column: BOOKTYPE
	 */
	private java.lang.String booktype;
	/**
	 * 书目编号 db_column: BOOKCODE
	 */
	private java.lang.String bookcode;
	/**
	 * 书目名 db_column: BOOKNAME
	 */
	private java.lang.String bookname;
	/**
	 * 所在书架 db_column: BOOKSHELF
	 */
	private java.lang.String bookshelf;
	/**
	 * 总数量 db_column: TOTALCOUNT
	 */
	private Integer totalcount;
	/**
	 * 剩余数量 db_column: LEFTCOUNT
	 */
	private Integer leftcount;
	/**
	 * 剩余数量 db_column: showorder
	 */
	private Integer showorder;
	/**
	 * 扩展字段1 db_column: EXT1
	 */
	private java.lang.String ext1;
	/**
	 * 扩展字段2 db_column: EXT2
	 */
	private java.lang.String ext2;
	/**
	 * 扩展字段3 db_column: EXT3
	 */
	private java.lang.String ext3;

	// columns END

	public Tbookinfo() {
	}

	public Tbookinfo(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "BOOKTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getBooktype() {
		return this.booktype;
	}

	public void setBooktype(java.lang.String value) {
		this.booktype = value;
	}

	@Column(name = "BOOKCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getBookcode() {
		return this.bookcode;
	}

	public void setBookcode(java.lang.String value) {
		this.bookcode = value;
	}

	@Column(name = "BOOKNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public java.lang.String getBookname() {
		return this.bookname;
	}

	public void setBookname(java.lang.String value) {
		this.bookname = value;
	}

	@Column(name = "BOOKSHELF", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getBookshelf() {
		return this.bookshelf;
	}

	public void setBookshelf(java.lang.String value) {
		this.bookshelf = value;
	}

	@Column(name = "TOTALCOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getTotalcount() {
		return this.totalcount;
	}

	public void setTotalcount(Integer value) {
		this.totalcount = value;
	}

	@Column(name = "LEFTCOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getLeftcount() {
		return this.leftcount;
	}

	public void setLeftcount(Integer value) {
		this.leftcount = value;
	}
	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(Integer value) {
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)//,mappedBy="tbookinfo"
	@JoinColumn(name = "BOOKID")
	@OrderBy("showorder asc")
	private Set<Tborrowbook> tborrowbooks = new HashSet(0);

	public void setTborrowbooks(Set<Tborrowbook> tborrowbook) {
		this.tborrowbooks = tborrowbook;
	}

	public Set<Tborrowbook> getTborrowbooks() {
		return tborrowbooks;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid())
				.append("Createdate", getCreatedate())
				.append("Creater", getCreater())
				.append("Createusername", getCreateusername())
				.append("Updatedate", getUpdatedate())
				.append("Updater", getUpdater())
				.append("Updateusername", getUpdateusername())
				.append("FlgDeleted", getFlgDeleted())
				.append("Booktype", getBooktype())
				.append("Bookcode", getBookcode())
				.append("Bookname", getBookname())
				.append("Bookshelf", getBookshelf())
				.append("Totalcount", getTotalcount())
				.append("Leftcount", getLeftcount()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tbookinfo == false)
			return false;
		if (this == obj)
			return true;
		Tbookinfo other = (Tbookinfo) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
