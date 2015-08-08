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
 * @module 字典明细
 * @email tigerchen2004@126.com
 */
public class TdictdetailQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 明细代码 */
	private java.lang.String detailcode;
	
	
	
	/** 明细名称（显示字符） */
	private java.lang.String detailname;
	
	
	
	/** 是否有效 */
	private java.lang.String isinuse;
	
	
	
	/** 是否默认 */
	private java.lang.String isdefault;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 所属字典定义 */
	private java.lang.String dictid;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getDetailcode() {
		return this.detailcode;
	}
	
	public void setDetailcode(java.lang.String value) {
		this.detailcode = value;
	}
	
	
	
	public java.lang.String getDetailname() {
		return this.detailname;
	}
	
	public void setDetailname(java.lang.String value) {
		this.detailname = value;
	}
	
	
	
	public java.lang.String getIsinuse() {
		return this.isinuse;
	}
	
	public void setIsinuse(java.lang.String value) {
		this.isinuse = value;
	}
	
	
	
	public java.lang.String getIsdefault() {
		return this.isdefault;
	}
	
	public void setIsdefault(java.lang.String value) {
		this.isdefault = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getDictid() {
		return this.dictid;
	}
	
	public void setDictid(java.lang.String value) {
		this.dictid = value;
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

