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
public class UmmenuQuery extends BaseQuery implements Serializable {
    

	
	
	
	
	
	
	
	
	
	
	/** menucode */
	private java.lang.String menucode;
	
	
	
	/** syscode */
	private java.lang.String syscode;
	
	
	
	/** menuname */
	private java.lang.String menuname;
	
	
	
	/** showtype */
	private java.lang.String showtype;
	
	
	
	/** refurl */
	private java.lang.String refurl;
	
	
	
	/** parentid */
	private java.lang.String parentid;
	
	
	
	/** smallicon */
	private java.lang.String smallicon;
	
	
	
	/** bigicon */
	private java.lang.String bigicon;
	
	
	
	/** apptype */
	private java.lang.String apptype;
	
	
	
	/** showorder */
	private java.math.BigDecimal showorder;
	
	
	
	/** parentids */
	private java.lang.String parentids;
	
	
	
	/** leaf */
	private java.lang.String leaf;
	
	
	
	/** target */
	private java.lang.String target;
	
	
	
	/** refsys */
	private java.lang.String refsys;
	
	
	
	/** processid */
	private java.lang.String processid;
	
	
	
	/** menutype */
	private java.lang.String menutype;
	

	
	public java.lang.String getMenucode() {
		return this.menucode;
	}
	
	public void setMenucode(java.lang.String value) {
		this.menucode = value;
	}
	
	
	
	public java.lang.String getSyscode() {
		return this.syscode;
	}
	
	public void setSyscode(java.lang.String value) {
		this.syscode = value;
	}
	
	
	
	public java.lang.String getMenuname() {
		return this.menuname;
	}
	
	public void setMenuname(java.lang.String value) {
		this.menuname = value;
	}
	
	
	
	public java.lang.String getShowtype() {
		return this.showtype;
	}
	
	public void setShowtype(java.lang.String value) {
		this.showtype = value;
	}
	
	
	
	public java.lang.String getRefurl() {
		return this.refurl;
	}
	
	public void setRefurl(java.lang.String value) {
		this.refurl = value;
	}
	
	
	
	public java.lang.String getParentid() {
		return this.parentid;
	}
	
	public void setParentid(java.lang.String value) {
		this.parentid = value;
	}
	
	
	
	public java.lang.String getSmallicon() {
		return this.smallicon;
	}
	
	public void setSmallicon(java.lang.String value) {
		this.smallicon = value;
	}
	
	
	
	public java.lang.String getBigicon() {
		return this.bigicon;
	}
	
	public void setBigicon(java.lang.String value) {
		this.bigicon = value;
	}
	
	
	
	public java.lang.String getApptype() {
		return this.apptype;
	}
	
	public void setApptype(java.lang.String value) {
		this.apptype = value;
	}
	
	
	
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}
	
	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}
	
	
	
	public java.lang.String getParentids() {
		return this.parentids;
	}
	
	public void setParentids(java.lang.String value) {
		this.parentids = value;
	}
	
	
	
	public java.lang.String getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(java.lang.String value) {
		this.leaf = value;
	}
	
	
	
	public java.lang.String getTarget() {
		return this.target;
	}
	
	public void setTarget(java.lang.String value) {
		this.target = value;
	}
	
	
	
	public java.lang.String getRefsys() {
		return this.refsys;
	}
	
	public void setRefsys(java.lang.String value) {
		this.refsys = value;
	}
	
	
	
	public java.lang.String getProcessid() {
		return this.processid;
	}
	
	public void setProcessid(java.lang.String value) {
		this.processid = value;
	}
	
	
	
	public java.lang.String getMenutype() {
		return this.menutype;
	}
	
	public void setMenutype(java.lang.String value) {
		this.menutype = value;
	}
	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

