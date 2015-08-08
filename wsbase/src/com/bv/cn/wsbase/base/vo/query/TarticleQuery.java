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
 * @module 文章编辑管理
 * @email tigerchen2004@126.com
 */
public class TarticleQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** 文章所属分类 */
	private java.lang.String amstype;
	
	
	
	/** 文章标题 */
	private java.lang.String articletitle;
	
	
	
	/** 文章内容 */
	private java.lang.Object articlecontent;
	
	
	
	/** 是否显示 */
	private java.lang.String isshow;
	
	
	
	/** 显示顺序 */
	private java.math.BigDecimal showorder;
	
	
	
	/** 扩展字段1 */
	private java.lang.String ext1;
	
	
	
	/** 扩展字段2 */
	private java.lang.String ext2;
	
	
	
	/** 扩展字段3 */
	private java.lang.String ext3;
	

	
	public java.lang.String getAmstype() {
		return this.amstype;
	}
	
	public void setAmstype(java.lang.String value) {
		this.amstype = value;
	}
	
	
	
	public java.lang.String getArticletitle() {
		return this.articletitle;
	}
	
	public void setArticletitle(java.lang.String value) {
		this.articletitle = value;
	}
	
	
	
	public java.lang.Object getArticlecontent() {
		return this.articlecontent;
	}
	
	public void setArticlecontent(java.lang.Object value) {
		this.articlecontent = value;
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

