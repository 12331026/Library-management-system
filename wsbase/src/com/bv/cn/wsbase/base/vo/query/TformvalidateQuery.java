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
 * @module 表单验证
 * @email tigerchen2004@126.com
 */
public class TformvalidateQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 页面字段名称 */
	private java.lang.String fieldname;
	
	
	
	/** 页面字段ID */
	private java.lang.String fieldid;
	
	
	
	/** 页面字段类型 */
	private java.lang.String fieldtype;
	
	
	
	/** 页面字段正则表达式 */
	private java.lang.String fieldpattern;
	
	
	
	/** 页面字段最大长度 */
	private java.math.BigDecimal fieldmaxlen;
	
	
	
	/** 页面字段最小长度 */
	private java.math.BigDecimal fieldminlen;
	
	
	
	/** 页面字段是否必须填写 */
	private java.lang.String fieldisrequired;
	
	
	
	/** 模块ID */
	private java.lang.String moduleid;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getFieldname() {
		return this.fieldname;
	}
	
	public void setFieldname(java.lang.String value) {
		this.fieldname = value;
	}
	
	
	
	public java.lang.String getFieldid() {
		return this.fieldid;
	}
	
	public void setFieldid(java.lang.String value) {
		this.fieldid = value;
	}
	
	
	
	public java.lang.String getFieldtype() {
		return this.fieldtype;
	}
	
	public void setFieldtype(java.lang.String value) {
		this.fieldtype = value;
	}
	
	
	
	public java.lang.String getFieldpattern() {
		return this.fieldpattern;
	}
	
	public void setFieldpattern(java.lang.String value) {
		this.fieldpattern = value;
	}
	
	
	
	public java.math.BigDecimal getFieldmaxlen() {
		return this.fieldmaxlen;
	}
	
	public void setFieldmaxlen(java.math.BigDecimal value) {
		this.fieldmaxlen = value;
	}
	
	
	
	public java.math.BigDecimal getFieldminlen() {
		return this.fieldminlen;
	}
	
	public void setFieldminlen(java.math.BigDecimal value) {
		this.fieldminlen = value;
	}
	
	
	
	public java.lang.String getFieldisrequired() {
		return this.fieldisrequired;
	}
	
	public void setFieldisrequired(java.lang.String value) {
		this.fieldisrequired = value;
	}
	
	
	
	public java.lang.String getModuleid() {
		return this.moduleid;
	}
	
	public void setModuleid(java.lang.String value) {
		this.moduleid = value;
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

