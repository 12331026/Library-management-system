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
 * @module 客户人员联系方式
 */

@Entity
@Table(name = "T_CUSTLINK")
public class Tcustlink extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_CUSTLINK";
	public static final String ALIAS_COMPANYINFOID = "companyinfoid";
	public static final String ALIAS_ISMAINLINKER = "ismainlinker";
	public static final String ALIAS_CUNAME = "cuname";
	public static final String ALIAS_CUDEPT = "cudept";
	public static final String ALIAS_CUTELE = "cutele";
	public static final String ALIAS_CUPORT = "cuport";
	public static final String ALIAS_MOBILE1 = "mobile1";
	public static final String ALIAS_MOBILE2 = "mobile2";
	public static final String ALIAS_EMAIL1 = "email1";
	public static final String ALIAS_EMAIL2 = "email2";
	public static final String ALIAS_IM1TYPE = "im1type";
	public static final String ALIAS_IM1NO = "im1no";
	public static final String ALIAS_IM2TYPE = "im2type";
	public static final String ALIAS_IM2NO = "im2no";
	public static final String ALIAS_ADDRESS = "address";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * 所属企业ID db_column: COMPANYINFOID
	 */
	private java.lang.String companyinfoid;
	/**
	 * 是否主联系人 db_column: ISMAINLINKER
	 */
	private java.lang.String ismainlinker;
	/**
	 * 姓名 db_column: CUNAME
	 */
	private java.lang.String cuname;
	/**
	 * 部门职务 db_column: CUDEPT
	 */
	private java.lang.String cudept;
	/**
	 * 电话 db_column: CUTELE
	 */
	private java.lang.String cutele;
	/**
	 * 传真 db_column: CUPORT
	 */
	private java.lang.String cuport;
	/**
	 * 手机1 db_column: MOBILE1
	 */
	private java.lang.String mobile1;
	/**
	 * 手机2 db_column: MOBILE2
	 */
	private java.lang.String mobile2;
	/**
	 * 电子邮箱1 db_column: EMAIL1
	 */
	private java.lang.String email1;
	/**
	 * 电子邮箱2 db_column: EMAIL2
	 */
	private java.lang.String email2;
	/**
	 * 即时通信1方式 db_column: IM1TYPE
	 */
	private java.lang.String im1type;
	/**
	 * 即时通信1号码 db_column: IM1NO
	 */
	private java.lang.String im1no;
	/**
	 * 即时通信2方式 db_column: IM2TYPE
	 */
	private java.lang.String im2type;
	/**
	 * 即时通信2号码 db_column: IM2NO
	 */
	private java.lang.String im2no;
	/**
	 * 个人地址 db_column: ADDRESS
	 */
	private java.lang.String address;
	/**
	 * 备注 db_column: REMARK
	 */
	private java.lang.String remark;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
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

	public Tcustlink() {
	}

	public Tcustlink(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "COMPANYINFOID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getCompanyinfoid() {
		return this.companyinfoid;
	}

	public void setCompanyinfoid(java.lang.String value) {
		this.companyinfoid = value;
	}

	@Column(name = "ISMAINLINKER", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getIsmainlinker() {
		return ismainlinker;
	}

	public void setIsmainlinker(java.lang.String ismainlinker) {
		this.ismainlinker = ismainlinker;
	}

	@Column(name = "CUNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCuname() {
		return this.cuname;
	}

	public void setCuname(java.lang.String value) {
		this.cuname = value;
	}

	@Column(name = "CUDEPT", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getCudept() {
		return this.cudept;
	}

	public void setCudept(java.lang.String value) {
		this.cudept = value;
	}

	@Column(name = "CUTELE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCutele() {
		return this.cutele;
	}

	public void setCutele(java.lang.String value) {
		this.cutele = value;
	}

	@Column(name = "CUPORT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCuport() {
		return this.cuport;
	}

	public void setCuport(java.lang.String value) {
		this.cuport = value;
	}

	@Column(name = "MOBILE1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getMobile1() {
		return this.mobile1;
	}

	public void setMobile1(java.lang.String value) {
		this.mobile1 = value;
	}

	@Column(name = "MOBILE2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getMobile2() {
		return this.mobile2;
	}

	public void setMobile2(java.lang.String value) {
		this.mobile2 = value;
	}

	@Column(name = "EMAIL1", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getEmail1() {
		return this.email1;
	}

	public void setEmail1(java.lang.String value) {
		this.email1 = value;
	}

	@Column(name = "EMAIL2", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getEmail2() {
		return this.email2;
	}

	public void setEmail2(java.lang.String value) {
		this.email2 = value;
	}

	@Column(name = "IM1TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getIm1type() {
		return this.im1type;
	}

	public void setIm1type(java.lang.String value) {
		this.im1type = value;
	}

	@Column(name = "IM1NO", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getIm1no() {
		return this.im1no;
	}

	public void setIm1no(java.lang.String value) {
		this.im1no = value;
	}

	@Column(name = "IM2TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getIm2type() {
		return this.im2type;
	}

	public void setIm2type(java.lang.String value) {
		this.im2type = value;
	}

	@Column(name = "IM2NO", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getIm2no() {
		return this.im2no;
	}

	public void setIm2no(java.lang.String value) {
		this.im2no = value;
	}

	@Column(name = "ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getAddress() {
		return this.address;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
	}

	@Column(name = "REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
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
	@JoinColumns( { @JoinColumn(name = "COMPANYINFOID", nullable = false, insertable = false, updatable = false) })
	private Tcompanyinfo tcompanyinfo;

	public void setTcompanyinfo(Tcompanyinfo tcompanyinfo) {
		this.tcompanyinfo = tcompanyinfo;
	}

	public Tcompanyinfo getTcompanyinfo() {
		return tcompanyinfo;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Companyinfoid",
						getCompanyinfoid()).append("Ismainlinker",
						getIsmainlinker()).append("Cuname", getCuname())
				.append("Cudept", getCudept()).append("Cutele", getCutele())
				.append("Cuport", getCuport()).append("Mobile1", getMobile1())
				.append("Mobile2", getMobile2()).append("Email1", getEmail1())
				.append("Email2", getEmail2()).append("Im1type", getIm1type())
				.append("Im1no", getIm1no()).append("Im2type", getIm2type())
				.append("Im2no", getIm2no()).append("Address", getAddress())
				.append("Remark", getRemark()).append("Showorder",
						getShoworder()).append("Ext1", getExt1()).append(
						"Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tcustlink == false)
			return false;
		if (this == obj)
			return true;
		Tcustlink other = (Tcustlink) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
