/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.bv.cn.base.model.BaseQuery;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */
public class UmmenuitemQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** menuid */
	private java.lang.String menuid;
	
	
	
	/** caption */
	private java.lang.String caption;
	
	
	
	/** showtype */
	private java.lang.String showtype;
	
	
	
	/** pagetype */
	private java.lang.String pagetype;
	
	
	
	/** jsfunction */
	private java.lang.String jsfunction;
	
	
	
	/** objectid */
	private java.lang.String objectid;
	
	
	
	/** iconfile */
	private java.lang.String iconfile;
	
	
	
	/** showorder */
	private java.math.BigDecimal showorder;
	
	
	
	/** paramap */
	private java.lang.String paramap;
	
	
	
	/** target */
	private java.lang.String target;
	
	
	
	/** refmenuid */
	private java.lang.String refmenuid;
	

	
	public java.lang.String getMenuid() {
		return this.menuid;
	}
	
	public void setMenuid(java.lang.String value) {
		this.menuid = value;
	}
	
	
	
	public java.lang.String getCaption() {
		return this.caption;
	}
	
	public void setCaption(java.lang.String value) {
		this.caption = value;
	}
	
	
	
	public java.lang.String getShowtype() {
		return this.showtype;
	}
	
	public void setShowtype(java.lang.String value) {
		this.showtype = value;
	}
	
	
	
	public java.lang.String getPagetype() {
		return this.pagetype;
	}
	
	public void setPagetype(java.lang.String value) {
		this.pagetype = value;
	}
	
	
	
	public java.lang.String getJsfunction() {
		return this.jsfunction;
	}
	
	public void setJsfunction(java.lang.String value) {
		this.jsfunction = value;
	}
	
	
	
	public java.lang.String getObjectid() {
		return this.objectid;
	}
	
	public void setObjectid(java.lang.String value) {
		this.objectid = value;
	}
	
	
	
	public java.lang.String getIconfile() {
		return this.iconfile;
	}
	
	public void setIconfile(java.lang.String value) {
		this.iconfile = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getParamap() {
		return this.paramap;
	}
	
	public void setParamap(java.lang.String value) {
		this.paramap = value;
	}
	
	
	
	public java.lang.String getTarget() {
		return this.target;
	}
	
	public void setTarget(java.lang.String value) {
		this.target = value;
	}
	
	
	
	public java.lang.String getRefmenuid() {
		return this.refmenuid;
	}
	
	public void setRefmenuid(java.lang.String value) {
		this.refmenuid = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

