/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.tsjylib.base.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module 
 * @email tigerchen2004@126.com
 */
public class TbookinfoQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 所属类别 */
	private java.lang.String booktype;
	
	
	
	/** 书目编号 */
	private java.lang.String bookcode;
	
	
	
	/** 书目名 */
	private java.lang.String bookname;
	
	
	
	/** 所在书架 */
	private java.lang.String bookshelf;
	
	
	
	/** 总数量 */
	private Integer totalcount;
	
	
	
	/** 剩余数量 */
	private Integer leftcount;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getBooktype() {
		return this.booktype;
	}
	
	public void setBooktype(java.lang.String value) {
		this.booktype = value;
	}
	
	
	
	public java.lang.String getBookcode() {
		return this.bookcode;
	}
	
	public void setBookcode(java.lang.String value) {
		this.bookcode = value;
	}
	
	
	
	public java.lang.String getBookname() {
		return this.bookname;
	}
	
	public void setBookname(java.lang.String value) {
		this.bookname = value;
	}
	
	
	
	public java.lang.String getBookshelf() {
		return this.bookshelf;
	}
	
	public void setBookshelf(java.lang.String value) {
		this.bookshelf = value;
	}
	
	
	
	public Integer getTotalcount() {
		return this.totalcount;
	}
	
	public void setTotalcount(Integer value) {
		this.totalcount = value;
	}
	
	
	
	public Integer getLeftcount() {
		return this.leftcount;
	}
	
	public void setLeftcount(Integer value) {
		this.leftcount = value;
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

