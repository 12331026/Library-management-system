/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

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

import com.bv.cn.base.model.BassResModle;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 区域文章关系
 */

@Entity
@Table(name = "T_AREAARTICLE")
public class Tareaarticle extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_AREAARTICLE";
	public static final String ALIAS_AREAID = "areaid";
	public static final String ALIAS_SHOWAREA = "tshowarea";
	public static final String ALIAS_ARTICLEID = "articleid";
	public static final String ALIAS_ARTICLE = "tarticle";
	public static final String ALIAS_ISSHOW = "isshow";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 区域ID db_column: AREAID
	 */
	// private java.lang.String areaid;
	/**
	 * 文章ID db_column: ARTICLEID
	 */
	// private java.lang.String articleid;
	/**
	 * 是否显示 db_column: ISSHOW
	 */
	private java.lang.String isshow;
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

	public Tareaarticle() {
	}

	public Tareaarticle(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "AREAID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getAreaid() {
	// return this.areaid;
	// }
	//
	// public void setAreaid(java.lang.String value) {
	// this.areaid = value;
	// }
	//
	// @Column(name = "ARTICLEID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getArticleid() {
	// return this.articleid;
	// }
	//
	// public void setArticleid(java.lang.String value) {
	// this.articleid = value;
	// }
	@Column(name = "ISSHOW", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(java.lang.String value) {
		this.isshow = value;
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
	@JoinColumns( { @JoinColumn(name = "AREAID", nullable = false, insertable = false, updatable = false) })
	private Tshowarea tshowarea;

	public void setTshowarea(Tshowarea tshowarea) {
		this.tshowarea = tshowarea;
	}

	public Tshowarea getTshowarea() {
		return tshowarea;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ARTICLEID", nullable = false, insertable = false, updatable = false) })
	private Tarticle tarticle;

	public void setTarticle(Tarticle tarticle) {
		this.tarticle = tarticle;
	}

	public Tarticle getTarticle() {
		return tarticle;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append(
						"Areaid",
						getTshowarea() == null ? "" : getTshowarea()
								.getResourceid()).append(
						"Articleid",
						getTarticle() == null ? "" : getTarticle()
								.getResourceid()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tareaarticle == false)
			return false;
		if (this == obj)
			return true;
		Tareaarticle other = (Tareaarticle) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
