/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @module ��֯����
 */
public class UmorgtypeQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** ��֯���ͱ��� */
	private java.lang.String typecode;
	
	
	
	/** ��֯�������� */
	private java.lang.String typename;
	
	
	
	/** Сͼ�� */
	private java.lang.String smallicon;
	
	
	
	/** ��ͼ�� */
	private java.lang.String largeicon;
	
	
	
	/** ��ʾ˳�� */
	private java.math.BigDecimal showorder;
	

	
	public java.lang.String getTypecode() {
		return this.typecode;
	}
	
	public void setTypecode(java.lang.String value) {
		this.typecode = value;
	}
	
	
	
	public java.lang.String getTypename() {
		return this.typename;
	}
	
	public void setTypename(java.lang.String value) {
		this.typename = value;
	}
	
	
	
	public java.lang.String getSmallicon() {
		return this.smallicon;
	}
	
	public void setSmallicon(java.lang.String value) {
		this.smallicon = value;
	}
	
	
	
	public java.lang.String getLargeicon() {
		return this.largeicon;
	}
	
	public void setLargeicon(java.lang.String value) {
		this.largeicon = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

