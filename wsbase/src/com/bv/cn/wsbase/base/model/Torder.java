/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.common.utils.DateConvertUtils;
import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 订单管理
 */

@Entity
@Table(name = "T_ORDER")
public class Torder extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_ORDER";
	public static final String ALIAS_ORDERBELONGID = "orderbelongid";
	public static final String ALIAS_ORDERBELONG = "orderbelonguser";
	public static final String ALIAS_ORDERAMOUNT = "orderamount";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_BOOKDATE = "bookdate";
	public static final String ALIAS_DETAIL = "detail";
	public static final String ALIAS_PAYMETHOD = "paymethod";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_POSTAMOUNT = "postamount";
	public static final String ALIAS_ORDERTYPE = "ordertype";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	public static final String FORMAT_BOOKDATE = DATE_FORMAT;

	// columns START
	/**
	 * 订单所属人ID db_column: ORDERBELONGID
	 */
	// private java.lang.String orderbelongid;
	/**
	 * 订单总金额 db_column: ORDERAMOUNT
	 */
	private java.math.BigDecimal orderamount;
	/**
	 * 状态: SHOPPING：购物车 --WAITINGPAY：订单待付款 PAYED：订单已付款 SHIPPED：已发货 db_column:
	 * STATUS
	 */
	private java.lang.String status;
	/**
	 * 下单时间 db_column: BOOKDATE
	 */
	@Column(name = "BOOKDATE", unique = false, nullable = true, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date bookdate;
	/**
	 * 订单明细 db_column: DETAIL
	 */
	private java.lang.String detail;
	/**
	 * 支付方式 db_column: PAYMETHOD
	 */
	private java.lang.String paymethod;
	/**
	 * 订单流水号 db_column: SHOWORDER
	 */
	private java.lang.Integer showorder;
	/**
	 * 邮费总计 db_column: POSTAMOUNT
	 */
	private java.math.BigDecimal postamount;
	/**
	 * 类型 db_column: ORDERTYPE
	 */
	private java.lang.String ordertype;
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

	public Torder() {
	}

	public Torder(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "ORDERBELONGID", unique = false, nullable = true,
	// insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getOrderbelongid() {
	// return this.orderbelongid;
	// }
	//
	// public void setOrderbelongid(java.lang.String value) {
	// this.orderbelongid = value;
	// }

	@Column(name = "ORDERAMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.math.BigDecimal getOrderamount() {
		return this.orderamount;
	}

	public void setOrderamount(java.math.BigDecimal value) {
		this.orderamount = value;
	}

	@Column(name = "STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.String value) {
		this.status = value;
	}

	@Transient
	public String getBookdateString() {
		return DateConvertUtils.format(getBookdate(), FORMAT_BOOKDATE);
	}

	
	public java.util.Date  getBookdate() {
		return this.bookdate;
	}

	public void setBookdate(java.util.Date  value) {
		this.bookdate = value;
	}

	@Column(name = "DETAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getDetail() {
		return this.detail;
	}

	public void setDetail(java.lang.String value) {
		this.detail = value;
	}

	@Column(name = "PAYMETHOD", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(java.lang.String value) {
		this.paymethod = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.lang.Integer value) {
		this.showorder = value;
	}

	@Column(name = "POSTAMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 18)
	public java.math.BigDecimal getPostamount() {
		return this.postamount;
	}

	public void setPostamount(java.math.BigDecimal value) {
		this.postamount = value;
	}

	@Column(name = "ORDERTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(java.lang.String value) {
		this.ordertype = value;
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

	// 订单所属人
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "ORDERBELONGID", nullable = false, insertable = false, updatable = false) })
	private Tuser orderbelonguser;

	public void setOrderbelonguser(Tuser tuser) {
		this.orderbelonguser = tuser;
	}

	public Tuser getOrderbelonguser() {
		return orderbelonguser;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERID")
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
						getFlgDeleted()).append(
						"Orderbelongid",
						getOrderbelonguser() == null ? "" : this
								.getOrderbelonguser().getResourceid()).append(
						"Orderamount", getOrderamount()).append("Status",
						getStatus()).append("Bookdate", getBookdate()).append(
						"Detail", getDetail()).append("Paymethod",
						getPaymethod()).append("Showorder", getShoworder())
				.append("Postamount", getPostamount()).append("Ordertype",
						getOrdertype()).append("Ext1", getExt1()).append(
						"Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Torder == false)
			return false;
		if (this == obj)
			return true;
		Torder other = (Torder) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
