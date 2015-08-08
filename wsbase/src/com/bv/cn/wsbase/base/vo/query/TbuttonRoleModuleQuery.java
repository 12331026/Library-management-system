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
 * @module 按钮资源-角色模块关系表
 * @email tigerchen2004@126.com
 */
public class TbuttonRoleModuleQuery extends BaseQuery implements Serializable {
    

	
	
	
	/** 按钮资源ID */
	private java.lang.String 按钮资源id;
	
	
	
	/** 角色模块ID */
	private java.lang.String 角色模块id;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String get按钮资源id() {
		return this.按钮资源id;
	}
	
	public void set按钮资源id(java.lang.String value) {
		this.按钮资源id = value;
	}
	
	
	
	public java.lang.String get角色模块id() {
		return this.角色模块id;
	}
	
	public void set角色模块id(java.lang.String value) {
		this.角色模块id = value;
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

