/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 客户人员联系方式
 * @email tigerchen2004@126.com
 */
public class TcustlinkQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 所属企业ID */
	private java.lang.String companyinfoid;
	
	
	
	/** 姓名 */
	private java.lang.String cuname;
	
	
	
	/** 部门职务 */
	private java.lang.String cudept;
	
	
	
	/** 电话 */
	private java.lang.String cutele;
	
	
	
	/** 传真 */
	private java.lang.String cuport;
	
	
	
	/** 手机1 */
	private java.lang.String mobile1;
	
	
	
	/** 手机2 */
	private java.lang.String mobile2;
	
	
	
	/** 电子邮箱1 */
	private java.lang.String email1;
	
	
	
	/** 电子邮箱2 */
	private java.lang.String email2;
	
	
	
	/** 即时通信1方式 */
	private java.lang.String im1type;
	
	
	
	/** 即时通信1号码 */
	private java.lang.String im1no;
	
	
	
	/** 即时通信2方式 */
	private java.lang.String im2type;
	
	
	
	/** 即时通信2号码 */
	private java.lang.String im2no;
	
	
	
	/** 个人地址 */
	private java.lang.String address;
	
	
	
	/** 备注 */
	private java.lang.String remark;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getCompanyinfoid() {
		return this.companyinfoid;
	}
	
	public void setCompanyinfoid(java.lang.String value) {
		this.companyinfoid = value;
	}
	
	
	
	public java.lang.String getCuname() {
		return this.cuname;
	}
	
	public void setCuname(java.lang.String value) {
		this.cuname = value;
	}
	
	
	
	public java.lang.String getCudept() {
		return this.cudept;
	}
	
	public void setCudept(java.lang.String value) {
		this.cudept = value;
	}
	
	
	
	public java.lang.String getCutele() {
		return this.cutele;
	}
	
	public void setCutele(java.lang.String value) {
		this.cutele = value;
	}
	
	
	
	public java.lang.String getCuport() {
		return this.cuport;
	}
	
	public void setCuport(java.lang.String value) {
		this.cuport = value;
	}
	
	
	
	public java.lang.String getMobile1() {
		return this.mobile1;
	}
	
	public void setMobile1(java.lang.String value) {
		this.mobile1 = value;
	}
	
	
	
	public java.lang.String getMobile2() {
		return this.mobile2;
	}
	
	public void setMobile2(java.lang.String value) {
		this.mobile2 = value;
	}
	
	
	
	public java.lang.String getEmail1() {
		return this.email1;
	}
	
	public void setEmail1(java.lang.String value) {
		this.email1 = value;
	}
	
	
	
	public java.lang.String getEmail2() {
		return this.email2;
	}
	
	public void setEmail2(java.lang.String value) {
		this.email2 = value;
	}
	
	
	
	public java.lang.String getIm1type() {
		return this.im1type;
	}
	
	public void setIm1type(java.lang.String value) {
		this.im1type = value;
	}
	
	
	
	public java.lang.String getIm1no() {
		return this.im1no;
	}
	
	public void setIm1no(java.lang.String value) {
		this.im1no = value;
	}
	
	
	
	public java.lang.String getIm2type() {
		return this.im2type;
	}
	
	public void setIm2type(java.lang.String value) {
		this.im2type = value;
	}
	
	
	
	public java.lang.String getIm2no() {
		return this.im2no;
	}
	
	public void setIm2no(java.lang.String value) {
		this.im2no = value;
	}
	
	
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getExt1() {
		return this.ext1;
	}
	
	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}
	
	
	
	public java.lang.String getExt2() {
		return this.ext2;
	}
	
	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}
	
	
	
	public java.lang.String getExt3() {
		return this.ext3;
	}
	
	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

