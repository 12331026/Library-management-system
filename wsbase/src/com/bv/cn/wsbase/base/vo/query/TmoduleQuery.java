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
 * @module 模块
 * @email tigerchen2004@126.com
 */
public class TmoduleQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 上级模块ID */
	private java.lang.String parentmoduleid;
	
	
	
	/** 模块级别:
1
2 */
	private java.lang.String modulelevel;
	
	
	
	/** 模块名称 */
	private java.lang.String modulename;
	
	
	
	/** 模块代码 */
	private java.lang.String modulecode;
	
	
	
	/** 模块类型：附加属性，只标识，没有完整性作用
LIST
EDIT */
	private java.lang.String moduletype;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getParentmoduleid() {
		return this.parentmoduleid;
	}
	
	public void setParentmoduleid(java.lang.String value) {
		this.parentmoduleid = value;
	}
	
	
	
	public java.lang.String getModulelevel() {
		return this.modulelevel;
	}
	
	public void setModulelevel(java.lang.String value) {
		this.modulelevel = value;
	}
	
	
	
	public java.lang.String getModulename() {
		return this.modulename;
	}
	
	public void setModulename(java.lang.String value) {
		this.modulename = value;
	}
	
	
	
	public java.lang.String getModulecode() {
		return this.modulecode;
	}
	
	public void setModulecode(java.lang.String value) {
		this.modulecode = value;
	}
	
	
	
	public java.lang.String getModuletype() {
		return this.moduletype;
	}
	
	public void setModuletype(java.lang.String value) {
		this.moduletype = value;
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

