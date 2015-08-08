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
 * @module 商品管理
 */

@Entity
@Table(name = "T_GOODS")
public class Tgoods extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_GOODS";
	public static final String ALIAS_GOODSNAME = "goodsname";
	public static final String ALIAS_GOODSREMARK = "goodsremark";
	public static final String ALIAS_MENBERPRICE = "menberprice";
	public static final String ALIAS_MARKETPRICE = "marketprice";
	public static final String ALIAS_POSTPRICE = "postprice";
	public static final String ALIAS_IMAGEID = "imageid";
	// public static final String ALIAS_IMAGE = "timage";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 商品名称 db_column: GOODSNAME
	 */
	private java.lang.String goodsname;
	/**
	 * 说明 db_column: GOODSREMARK
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "org.springframework.orm.hibernate3.support.ClobStringType")
	@Column(name = "GOODSREMARK", columnDefinition = "CLOB", length = 1048576000)
	private java.lang.String goodsremark;
	/**
	 * 会员价格 db_column: MENBERPRICE
	 */
	private java.math.BigDecimal menberprice;
	/**
	 * 市场价格 db_column: MARKETPRICE
	 */
	private java.math.BigDecimal marketprice;
	/**
	 * 邮费 db_column: POSTPRICE
	 */
	private java.math.BigDecimal postprice;
	/**
	 * 图片ID db_column: IMAGEID
	 */
	private java.lang.String imageid;
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

	public Tgoods() {
	}

	public Tgoods(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "GOODSNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(java.lang.String value) {
		this.goodsname = value;
	}

	
	public java.lang.String getGoodsremark() {
		return this.goodsremark;
	}

	public void setGoodsremark(java.lang.String value) {
		this.goodsremark = value;
	}

	@Column(name = "MENBERPRICE", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.math.BigDecimal getMenberprice() {
		return this.menberprice;
	}

	public void setMenberprice(java.math.BigDecimal value) {
		this.menberprice = value;
	}

	@Column(name = "MARKETPRICE", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.math.BigDecimal getMarketprice() {
		return this.marketprice;
	}

	public void setMarketprice(java.math.BigDecimal value) {
		this.marketprice = value;
	}

	@Column(name = "POSTPRICE", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.math.BigDecimal getPostprice() {
		return this.postprice;
	}

	public void setPostprice(java.math.BigDecimal value) {
		this.postprice = value;
	}

	@Column(name = "IMAGEID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getImageid() {
		return this.imageid;
	}

	public void setImageid(java.lang.String value) {
		this.imageid = value;
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
	@JoinColumn(name = "GOODSID")
	@OrderBy("createdate asc")
	private Set<Tshopping> tshoppings = new HashSet(0);

	public void setTshoppings(Set<Tshopping> tshopping) {
		this.tshoppings = tshopping;
	}

	public Set<Tshopping> getTshoppings() {
		return tshoppings;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Goodsname", getGoodsname())
				.append("Goodsremark", getGoodsremark()).append("Menberprice",
						getMenberprice()).append("Marketprice",
						getMarketprice()).append("Postprice", getPostprice())
				.append("Imageid", getImageid()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tgoods == false)
			return false;
		if (this == obj)
			return true;
		Tgoods other = (Tgoods) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
