/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Type;

import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 文章编辑管理
 */

@Entity
@Table(name = "T_ARTICLE")
public class Tarticle extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_ARTICLE";
	public static final String ALIAS_AMSTYPE = "amstype";
	public static final String ALIAS_ARTICLETITLE = "articletitle";
	public static final String ALIAS_ARTICLECONTENT = "articlecontent";
	public static final String ALIAS_ISSHOW = "isshow";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 文章所属分类 db_column: AMSTYPE
	 */
	private java.lang.String amstype;
	/**
	 * 文章标题 db_column: ARTICLETITLE
	 */
	private java.lang.String articletitle;
	/**
	 * 文章内容 db_column: ARTICLECONTENT
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "org.springframework.orm.hibernate3.support.ClobStringType")
	@Column(name = "ARTICLECONTENT", columnDefinition = "CLOB", length = 1048576000)
	private java.lang.String articlecontent;
	/**
	 * 是否显示 db_column: ISSHOW
	 */
	private java.lang.String isshow;
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

	public Tarticle() {
	}

	public Tarticle(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "AMSTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getAmstype() {
		return this.amstype;
	}

	public void setAmstype(java.lang.String value) {
		this.amstype = value;
	}

	@Column(name = "ARTICLETITLE", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getArticletitle() {
		return this.articletitle;
	}

	public void setArticletitle(java.lang.String value) {
		this.articletitle = value;
	}

	// @Column(name = "ARTICLECONTENT", unique = false, nullable = true,
	// insertable = true, updatable = true, length = 4000)
	public java.lang.String getArticlecontent() {
		return this.articlecontent;
	}

	public void setArticlecontent(java.lang.String value) {
		this.articlecontent = value;
	}

	@Column(name = "ISSHOW", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(java.lang.String value) {
		this.isshow = value;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLEID")
	@OrderBy("resourceid asc")
	private Set<Tareaarticle> tareaarticles = new HashSet(0);

	public void setTareaarticles(Set<Tareaarticle> tareaarticle) {
		this.tareaarticles = tareaarticle;
	}

	public Set<Tareaarticle> getTareaarticles() {
		return tareaarticles;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Amstype", getAmstype())
				.append("Articletitle", getArticletitle()).append(
						"Articlecontent", getArticlecontent()).append("Isshow",
						getIsshow()).append("Showorder", getShoworder())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tarticle == false)
			return false;
		if (this == obj)
			return true;
		Tarticle other = (Tarticle) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
