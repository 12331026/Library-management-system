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
 * @module 字典定义
 * @email tigerchen2004@126.com
 */
public class TdictQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 字典代码名称 */
	private java.lang.String dictname;
	
	
	
	/** 字典代码 */
	private java.lang.String dictcode;
	
	
	
	/** 所属模块 */
	private java.lang.String module;
	
	
	
	/** 数据来源类型 */
	private java.lang.String srctype;
	
	
	
	/** 数据来源SQL */
	private java.lang.String srcsql;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getDictname() {
		return this.dictname;
	}
	
	public void setDictname(java.lang.String value) {
		this.dictname = value;
	}
	
	
	
	public java.lang.String getDictcode() {
		return this.dictcode;
	}
	
	public void setDictcode(java.lang.String value) {
		this.dictcode = value;
	}
	
	
	
	public java.lang.String getModule() {
		return this.module;
	}
	
	public void setModule(java.lang.String value) {
		this.module = value;
	}
	
	
	
	public java.lang.String getSrctype() {
		return this.srctype;
	}
	
	public void setSrctype(java.lang.String value) {
		this.srctype = value;
	}
	
	
	
	public java.lang.String getSrcsql() {
		return this.srcsql;
	}
	
	public void setSrcsql(java.lang.String value) {
		this.srcsql = value;
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

