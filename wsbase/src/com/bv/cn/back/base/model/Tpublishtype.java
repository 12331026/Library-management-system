/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.back.base.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 公告类型
 */

@Entity
@Table(name = "T_PUBLISHTYPE")
public class Tpublishtype extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_PUBLISHTYPE";
	public static final String ALIAS_VCTYPE = "vctype";
	public static final String ALIAS_VCNAME = "vcname";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 公告类型编码 db_column: VCTYPE
	 */
	private java.lang.String vctype;
	/**
	 * 公告类型名称 db_column: VCNAME
	 */
	private java.lang.String vcname;
	/**
	 * 扩展字段1 db_column: EXT1
	 */
	private java.lang.String ext1;
	/**
	 * 扩展字段2 db_column: EXT2
	 */
	private java.lang.String ext2;
	/**
	 * 扩展字段3 db_column: EXT3
	 */
	private java.lang.String ext3;

	// columns END

	public Tpublishtype() {
	}

	public Tpublishtype(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "VCTYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getVctype() {
		return this.vctype;
	}

	public void setVctype(java.lang.String value) {
		this.vctype = value;
	}

	@Column(name = "VCNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getVcname() {
		return this.vcname;
	}

	public void setVcname(java.lang.String value) {
		this.vcname = value;
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
	@JoinColumn(name = "PUBLISHTYPEID")
	@OrderBy("showorder desc")
	private Set<Tpublishmessage> tpublishmessages = new HashSet(0);

	public void setTpublishmessages(Set<Tpublishmessage> tpublishmessage) {
		this.tpublishmessages = tpublishmessage;
	}

	public Set<Tpublishmessage> getTpublishmessages() {
		return tpublishmessages;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Vctype", getVctype()).append(
						"Vcname", getVcname()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tpublishtype == false)
			return false;
		if (this == obj)
			return true;
		Tpublishtype other = (Tpublishtype) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
