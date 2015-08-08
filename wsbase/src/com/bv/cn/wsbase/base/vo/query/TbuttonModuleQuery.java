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
 * @module 按钮资源表
 * @email tigerchen2004@126.com
 */
public class TbuttonModuleQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 模块ID */
	private java.lang.String moduleid;
	
	
	
	/** 按钮代码 */
	private java.lang.String rbcode;
	
	
	
	/** 按钮名称 */
	private java.lang.String rbname;
	
	
	
	/** 按钮归属 */
	private java.lang.String showmodel;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getModuleid() {
		return this.moduleid;
	}
	
	public void setModuleid(java.lang.String value) {
		this.moduleid = value;
	}
	
	
	
	public java.lang.String getRbcode() {
		return this.rbcode;
	}
	
	public void setRbcode(java.lang.String value) {
		this.rbcode = value;
	}
	
	
	
	public java.lang.String getRbname() {
		return this.rbname;
	}
	
	public void setRbname(java.lang.String value) {
		this.rbname = value;
	}
	
	
	
	public java.lang.String getShowmodel() {
		return this.showmodel;
	}
	
	public void setShowmodel(java.lang.String value) {
		this.showmodel = value;
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

