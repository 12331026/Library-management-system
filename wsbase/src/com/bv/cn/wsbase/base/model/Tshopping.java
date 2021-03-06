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

import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 购物管理
 */

@Entity
@Table(name = "T_SHOPPING")
public class Tshopping extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_SHOPPING";
	public static final String ALIAS_ORDERID = "orderid";
	public static final String ALIAS_GOODSID = "goodsid";
	public static final String ALIAS_ORDER = "torder";
	public static final String ALIAS_GOODS = "tgoods";
	public static final String ALIAS_GOODSNUM = "goodsnum";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 商品数量 db_column: GOODSNUM
	 */
	private java.lang.Integer goodsnum;
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

	public Tshopping() {
	}

	public Tshopping(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "GOODSNUM", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getGoodsnum() {
		return this.goodsnum;
	}

	public void setGoodsnum(java.lang.Integer value) {
		this.goodsnum = value;
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

	// 所属订单
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ORDERID", nullable = false, insertable = false, updatable = false) })
	private Torder torder;

	public void setTorder(Torder torder) {
		this.torder = torder;
	}

	public Torder getTorder() {
		return torder;
	}

	// 所属商品
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "GOODSID", nullable = false, insertable = false, updatable = false) })
	private Tgoods tgoods;

	public void setTgoods(Tgoods tgoods) {
		this.tgoods = tgoods;
	}

	public Tgoods getTgoods() {
		return tgoods;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Orderid",
						getTorder().getResourceid()).append("Goodsid",
						getTgoods().getResourceid()).append("Goodsnum",
						getGoodsnum()).append("Ext1", getExt1()).append("Ext2",
						getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tshopping == false)
			return false;
		if (this == obj)
			return true;
		Tshopping other = (Tshopping) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
