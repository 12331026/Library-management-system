/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.model;

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

import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告信息管理
 */

@Entity
@Table(name = "T_PUBLISHMESSAGE")
public class Tpublishmessage extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_PUBLISHMESSAGE";
	public static final String ALIAS_PUBLISHTYPEID = "publishtypeid";
	public static final String ALIAS_PUBLISHTYPE = "tpublishtype";
	public static final String ALIAS_VCTITLE = "vctitle";
	public static final String ALIAS_VCCONTENT = "vccontent";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 公告类型ID db_column: PUBLISHTYPEID
	 */
	// private java.lang.String publishtypeid;
	/**
	 * 公告标题 db_column: VCTITLE
	 */
	private java.lang.String vctitle;
	/**
	 * 公告内容 db_column: VCCONTENT
	 */
	private java.lang.String vccontent;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.lang.Integer showorder;
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

	public Tpublishmessage() {
	}

	public Tpublishmessage(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "PUBLISHTYPEID", unique = false, nullable = true,
	// insertable = true, updatable = true, length = 32)
	// public java.lang.String getPublishtypeid() {
	// return this.publishtypeid;
	// }
	//
	// public void setPublishtypeid(java.lang.String value) {
	// this.publishtypeid = value;
	// }

	@Column(name = "VCTITLE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getVctitle() {
		return this.vctitle;
	}

	public void setVctitle(java.lang.String value) {
		this.vctitle = value;
	}

	@Column(name = "VCCONTENT", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getVccontent() {
		return this.vccontent;
	}

	public void setVccontent(java.lang.String value) {
		this.vccontent = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.lang.Integer value) {
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
	@JoinColumns( { @JoinColumn(name = "PUBLISHTYPEID", nullable = false, insertable = false, updatable = false) })
	private Tpublishtype tpublishtype;

	public void setTpublishtype(Tpublishtype tpublishtype) {
		this.tpublishtype = tpublishtype;
	}

	public Tpublishtype getTpublishtype() {
		return tpublishtype;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append(
						"Publishtypeid",
						getTpublishtype() == null ? "" : getTpublishtype()
								.getResourceid()).append("Vctitle",
						getVctitle()).append("Vccontent", getVccontent())
				.append("Showorder", getShoworder()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tpublishmessage == false)
			return false;
		if (this == obj)
			return true;
		Tpublishmessage other = (Tpublishmessage) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
