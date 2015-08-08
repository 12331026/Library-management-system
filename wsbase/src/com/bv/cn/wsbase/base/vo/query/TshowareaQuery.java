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
 * @module 显示区域管理
 * @email tigerchen2004@126.com
 */
public class TshowareaQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 区域编码 */
	private java.lang.String areacode;
	
	
	
	/** 区域名称 */
	private java.lang.String areaname;
	
	
	
	/** 区域描述 */
	private java.lang.String areadesc;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getAreacode() {
		return this.areacode;
	}
	
	public void setAreacode(java.lang.String value) {
		this.areacode = value;
	}
	
	
	
	public java.lang.String getAreaname() {
		return this.areaname;
	}
	
	public void setAreaname(java.lang.String value) {
		this.areaname = value;
	}
	
	
	
	public java.lang.String getAreadesc() {
		return this.areadesc;
	}
	
	public void setAreadesc(java.lang.String value) {
		this.areadesc = value;
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

