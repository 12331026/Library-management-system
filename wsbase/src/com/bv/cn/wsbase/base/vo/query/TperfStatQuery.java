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
 * @module 性能日志表
 * @email tigerchen2004@126.com
 */
public class TperfStatQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	/** 开始时间 */
	private java.sql.Timestamp starttimeBegin;
	private java.sql.Timestamp starttimeEnd;
	
	
	
	/** 类名 */
	private java.lang.String classname;
	
	
	
	/** 方法名 */
	private java.lang.String methodname;
	
	
	
	/** 参数 */
	private java.lang.String param;
	
	
	
	/** 返回值 */
	private java.lang.String returnvalue;
	
	
	
	/** 消耗时间 */
	private java.math.BigDecimal duration;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.sql.Timestamp getStarttimeBegin() {
		return this.starttimeBegin;
	}
	
	public void setStarttimeBegin(java.sql.Timestamp value) {
		this.starttimeBegin = value;
	}	
	
	public java.sql.Timestamp getStarttimeEnd() {
		return this.starttimeEnd;
	}
	
	public void setStarttimeEnd(java.sql.Timestamp value) {
		this.starttimeEnd = value;
	}
	
	
	
	public java.lang.String getClassname() {
		return this.classname;
	}
	
	public void setClassname(java.lang.String value) {
		this.classname = value;
	}
	
	
	
	public java.lang.String getMethodname() {
		return this.methodname;
	}
	
	public void setMethodname(java.lang.String value) {
		this.methodname = value;
	}
	
	
	
	public java.lang.String getParam() {
		return this.param;
	}
	
	public void setParam(java.lang.String value) {
		this.param = value;
	}
	
	
	
	public java.lang.String getReturnvalue() {
		return this.returnvalue;
	}
	
	public void setReturnvalue(java.lang.String value) {
		this.returnvalue = value;
	}
	
	
	
	public java.math.BigDecimal getDuration() {
		return this.duration;
	}
	
	public void setDuration(java.math.BigDecimal value) {
		this.duration = value;
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

