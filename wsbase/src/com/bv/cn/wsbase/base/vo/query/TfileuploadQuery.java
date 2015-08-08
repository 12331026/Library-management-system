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
 * @module 附件上传
 * @email tigerchen2004@126.com
 */
public class TfileuploadQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	/** 模块ID */
	private java.lang.String moduleid;
	
	
	
	/** 工单ID */
	private java.lang.String formid;
	
	
	
	/** 文件名称 */
	private java.lang.String filename;
	
	
	
	/** 文件后缀 */
	private java.lang.String fileext;
	
	
	
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
	
	
	
	public java.lang.String getFormid() {
		return this.formid;
	}
	
	public void setFormid(java.lang.String value) {
		this.formid = value;
	}
	
	
	
	public java.lang.String getFilename() {
		return this.filename;
	}
	
	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	
	
	public java.lang.String getFileext() {
		return this.fileext;
	}
	
	public void setFileext(java.lang.String value) {
		this.fileext = value;
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

