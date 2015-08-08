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
 * @module 字典明细
 */

@Entity
@Table(name = "T_DICTDETAIL")
public class Tdictdetail extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_DICTDETAIL";
	public static final String ALIAS_DETAILCODE = "detailcode";
	public static final String ALIAS_DETAILNAME = "detailname";
	public static final String ALIAS_ISINUSE = "isinuse";
	public static final String ALIAS_ISDEFAULT = "isdefault";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_TDICT = "tdict";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 明细代码 db_column: DETAILCODE
	 */
	private java.lang.String detailcode;
	/**
	 * 明细名称（显示字符） db_column: DETAILNAME
	 */
	private java.lang.String detailname;
	/**
	 * 是否有效 db_column: ISINUSE
	 */
	private java.lang.String isinuse;
	/**
	 * 是否默认 db_column: ISDEFAULT
	 */
	private java.lang.String isdefault;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * 所属字典定义 db_column: DICTID
	 */
	// private java.lang.String dictid;
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

	public Tdictdetail() {
	}

	public Tdictdetail(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "DETAILCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getDetailcode() {
		return this.detailcode;
	}

	public void setDetailcode(java.lang.String value) {
		this.detailcode = value;
	}

	@Column(name = "DETAILNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDetailname() {
		return this.detailname;
	}

	public void setDetailname(java.lang.String value) {
		this.detailname = value;
	}

	@Column(name = "ISINUSE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getIsinuse() {
		return this.isinuse;
	}

	public void setIsinuse(java.lang.String value) {
		this.isinuse = value;
	}

	@Column(name = "ISDEFAULT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(java.lang.String value) {
		this.isdefault = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	// @Column(name = "DICTID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getDictid() {
	// return this.dictid;
	// }
	//		
	// public void setDictid(java.lang.String value) {
	// this.dictid = value;
	// }

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
	@JoinColumns( { @JoinColumn(name = "DICTID", nullable = false, insertable = false, updatable = false) })
	private Tdict tdict;

	public void setTdict(Tdict tdict) {
		this.tdict = tdict;
	}

	public Tdict getTdict() {
		return tdict;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Detailcode",
						getDetailcode()).append("Detailname", getDetailname())
				.append("Isinuse", getIsinuse()).append("Isdefault",
						getIsdefault()).append("Showorder", getShoworder())
				.append("Dictid", this.getTdict().getResourceid()).append(
						"Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tdictdetail == false)
			return false;
		if (this == obj)
			return true;
		Tdictdetail other = (Tdictdetail) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
