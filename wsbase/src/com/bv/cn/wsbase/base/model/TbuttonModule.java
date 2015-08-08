/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BassResModle;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module ��ť��Դ��
 */

@Entity
@Table(name = "T_BUTTON_MODULE")
public class TbuttonModule extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_BUTTON_MODULE";
	public static final String ALIAS_MODULEID = "moduleid";
	public static final String ALIAS_MODULE = "tmodule";
	public static final String ALIAS_RBCODE = "rbcode";
	public static final String ALIAS_RBNAME = "rbname";
	public static final String ALIAS_SHOWMODEL = "showmodel";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_ONCLICK = "onclick";
	public static final String ALIAS_STYLECLASS = "styleclass2";
	public static final String ALIAS_STYLE = "style";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats

	// columns START
	/**
	 * ģ��ID db_column: MODULEID
	 */
	// private java.lang.String moduleid;
	/**
	 * ��ť���� db_column: RBCODE
	 */
	private java.lang.String rbcode;
	/**
	 * ��ť��� db_column: RBNAME
	 */
	private java.lang.String rbname;
	/**
	 * ��ť���� db_column: SHOWMODEL
	 */
	private java.lang.String showmodel;
	/**
	 * ��ʾ˳�� db_column: SHOWORDER
	 */
	private java.math.BigDecimal showorder;
	/**
	 * �¼� db_column: ONCLICK
	 */
	private java.lang.String onclick;
	/**
	 * ��ʽclass db_column: styleclass
	 */
	@Column(name = "STYLECLASS2", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	private java.lang.String styleclass;
	/**
	 * ��ʽ db_column: style
	 */
	private java.lang.String style;
	/**
	 * )չ�ֶ�1 db_column: EXT1
	 */
	private java.lang.String ext1;
	/**
	 * )չ�ֶ�2 db_column: EXT2
	 */
	private java.lang.String ext2;
	/**
	 * )չ�ֶ�3 db_column: EXT3
	 */
	private java.lang.String ext3;

	// columns END

	public TbuttonModule() {
	}

	public TbuttonModule(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "MODULEID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getModuleid() {
	// return this.moduleid;
	// }
	//		
	// public void setModuleid(java.lang.String value) {
	// this.moduleid = value;
	// }

	@Column(name = "RBCODE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getRbcode() {
		return this.rbcode;
	}

	public void setRbcode(java.lang.String value) {
		this.rbcode = value;
	}

	@Column(name = "RBNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getRbname() {
		return this.rbname;
	}

	public void setRbname(java.lang.String value) {
		this.rbname = value;
	}

	@Column(name = "SHOWMODEL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getShowmodel() {
		return this.showmodel;
	}

	public void setShowmodel(java.lang.String value) {
		this.showmodel = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.math.BigDecimal value) {
		this.showorder = value;
	}

	@Column(name = "ONCLICK", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getOnclick() {
		return this.onclick;
	}

	public void setOnclick(java.lang.String value) {
		this.onclick = value;
	}
	
	
	public java.lang.String getStyleclass() {
		return styleclass;
	}

	public void setStyleclass(java.lang.String styleclass) {
		this.styleclass = styleclass;
	}
	
	@Column(name = "STYLE", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getStyle() {
		return style;
	}

	public void setStyle(java.lang.String style) {
		this.style = style;
	}

	@Column(name = "EXT1", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt1() {
		return this.ext1;
	}

	public void setExt1(java.lang.String value) {
		this.ext1 = value;
	}

	@Column(name = "EXT2", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt2() {
		return this.ext2;
	}

	public void setExt2(java.lang.String value) {
		this.ext2 = value;
	}

	@Column(name = "EXT3", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getExt3() {
		return this.ext3;
	}

	public void setExt3(java.lang.String value) {
		this.ext3 = value;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "BUTTONID")
	@OrderBy("resourceid asc")
	private Set<TbuttonRoleModule> tbuttonRoleModules = new HashSet(0);

	public void setTbuttonRoleModules(Set<TbuttonRoleModule> tbuttonRoleModule) {
		this.tbuttonRoleModules = tbuttonRoleModule;
	}

	public Set<TbuttonRoleModule> getTbuttonRoleModules() {
		return tbuttonRoleModules;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumns( { @JoinColumn(name = "MODULEID", nullable = false, insertable = false, updatable = false) })
	private Tmodule tmodule;

	public void setTmodule(Tmodule tmodule) {
		this.tmodule = tmodule;
	}

	public Tmodule getTmodule() {
		return tmodule;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Moduleid",
						this.getTmodule().getResourceid()).append("Rbcode",
						getRbcode()).append("Rbname", getRbname()).append(
						"Showmodel", getShowmodel()).append("Showorder",
						getShoworder()).append("Onclick", getOnclick()).append(
						"Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TbuttonModule == false)
			return false;
		if (this == obj)
			return true;
		TbuttonModule other = (TbuttonModule) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
