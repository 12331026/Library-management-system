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
 * @module 企业信息
 * @email tigerchen2004@126.com
 */
public class TcompanyinfoQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 企业名称 */
	private java.lang.String compname;
	
	
	
	/** 客户分类 */
	private java.lang.String comptype;
	
	
	
	/** 企业所属国家地区 */
	private java.lang.String compbelone;
	
	
	
	/** 企业地址 */
	private java.lang.String compaddress;
	
	
	
	/** 商务电话 */
	private java.lang.String comptele;
	
	
	
	/** 备注 */
	private java.lang.String compremark;
	
	
	
	/** 商务传真 */
	private java.lang.String compport;
	
	
	
	/** 网站 */
	private java.lang.String compwebsite;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getCompname() {
		return this.compname;
	}
	
	public void setCompname(java.lang.String value) {
		this.compname = value;
	}
	
	
	
	public java.lang.String getComptype() {
		return this.comptype;
	}
	
	public void setComptype(java.lang.String value) {
		this.comptype = value;
	}
	
	
	
	public java.lang.String getCompbelone() {
		return this.compbelone;
	}
	
	public void setCompbelone(java.lang.String value) {
		this.compbelone = value;
	}
	
	
	
	public java.lang.String getCompaddress() {
		return this.compaddress;
	}
	
	public void setCompaddress(java.lang.String value) {
		this.compaddress = value;
	}
	
	
	
	public java.lang.String getComptele() {
		return this.comptele;
	}
	
	public void setComptele(java.lang.String value) {
		this.comptele = value;
	}
	
	
	
	public java.lang.String getCompremark() {
		return this.compremark;
	}
	
	public void setCompremark(java.lang.String value) {
		this.compremark = value;
	}
	
	
	
	public java.lang.String getCompport() {
		return this.compport;
	}
	
	public void setCompport(java.lang.String value) {
		this.compport = value;
	}
	
	
	
	public java.lang.String getCompwebsite() {
		return this.compwebsite;
	}
	
	public void setCompwebsite(java.lang.String value) {
		this.compwebsite = value;
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

