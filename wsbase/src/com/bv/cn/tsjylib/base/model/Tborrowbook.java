/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BassCreateModle;
import com.bv.cn.wsbase.base.model.Tuser;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module
 */

@Entity
@Table(name = "t_borrowbook")
public class Tborrowbook extends BassCreateModle implements
		java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "t_borrowbook";
	public static final String ALIAS_BORROWUSER = "tuser";
	public static final String ALIAS_BORROWUSERID = "borrowuserid";
	public static final String ALIAS_BOOK = "tbookinfo";
	public static final String ALIAS_BOOKID = "bookid";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 借书人ID db_column: BORROWUSERID
	 */
	// private java.lang.String borrowuserid;
	/**
	 * 书目ID db_column: BOOKID
	 */
	// private java.lang.String bookid;
	/**
	 * 显示顺序 db_column: SHOWORDER
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

	public Tborrowbook() {
	}

	public Tborrowbook(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "BORROWUSERID", unique = false, nullable = true,
	// insertable = true, updatable = true, length = 32)
	// public java.lang.String getBorrowuserid() {
	// return this.borrowuserid;
	// }
	//
	// public void setBorrowuserid(java.lang.String value) {
	// this.borrowuserid = value;
	// }

	// @Column(name = "BOOKID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getBookid() {
	// return this.bookid;
	// }
	//
	// public void setBookid(java.lang.String value) {
	// this.bookid = value;
	// }

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

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BORROWUSERID", nullable = false, insertable = false, updatable = false) })
	private Tuser tuser;

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	public Tuser getTuser() {
		return tuser;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "BOOKID", nullable = false, insertable = false, updatable = false) })
	// @JoinTable(name = "t_borrowbook", joinColumns = @JoinColumn(name =
	// "BOOKID"), inverseJoinColumns = @JoinColumn(name = "RESOURCEID"))
	private Tbookinfo tbookinfo;

	public void setTbookinfo(Tbookinfo tbookinfo) {
		this.tbookinfo = tbookinfo;
	}

	public Tbookinfo getTbookinfo() {
		return tbookinfo;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid())
				.append("Createdate", getCreatedate())
				.append("Creater", getCreater())
				.append("Createusername", getCreateusername())
				.append("FlgDeleted", getFlgDeleted())
				.append("Borrowuserid",
						this.getTuser() == null ? "" : this.getTuser()
								.getResourceid())
				.append("Bookid",
						this.getTbookinfo() == null ? "" : this.getTbookinfo()
								.getResourceid())
				.append("Showorder", getShoworder()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tborrowbook == false)
			return false;
		if (this == obj)
			return true;
		Tborrowbook other = (Tborrowbook) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
