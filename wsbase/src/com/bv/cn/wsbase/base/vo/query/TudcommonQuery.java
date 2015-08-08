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
 * @module 用户部门Common
 * @email tigerchen2004@126.com
 */
public class TudcommonQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 上级部门（所属部门） */
	private java.lang.String parentid;
	
	
	
	/** 名称 */
	private java.lang.String vcname;
	
	
	
	/** 类别 */
	private java.lang.String commontype;
	
	
	
	/** 编码：
部门为部门编码
用户为用户logonid */
	private java.lang.String vccode;
	
	
	
	/** 是否可见：
V：可见
NV：不可见 */
	private java.lang.String isshow;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	
	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}
	
	
	
	public java.lang.String getVcname() {
		return this.vcname;
	}
	
	public void setVcname(java.lang.String value) {
		this.vcname = value;
	}
	
	
	
	public java.lang.String getCommontype() {
		return this.commontype;
	}
	
	public void setCommontype(java.lang.String value) {
		this.commontype = value;
	}
	
	
	
	public java.lang.String getVccode() {
		return this.vccode;
	}
	
	public void setVccode(java.lang.String value) {
		this.vccode = value;
	}
	
	
	
	public java.lang.String getIsshow() {
		return this.isshow;
	}
	
	public void setIsshow(java.lang.String value) {
		this.isshow = value;
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

