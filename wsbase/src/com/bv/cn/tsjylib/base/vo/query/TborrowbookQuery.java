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
public class TborrowbookQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	/** 借书人ID */
	private java.lang.String borrowuserid;
	
	
	
	/** 书目ID */
	private java.lang.String bookid;
	
	
	
	/** 显示顺序 */
	private Integer showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getBorrowuserid() {
		return this.borrowuserid;
	}
	
	public void setBorrowuserid(java.lang.String value) {
		this.borrowuserid = value;
	}
	
	
	
	public java.lang.String getBookid() {
		return this.bookid;
	}
	
	public void setBookid(java.lang.String value) {
		this.bookid = value;
	}
	
	
	
	public Integer getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(Integer value) {
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

