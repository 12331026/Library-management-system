/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.common.utils.DateConvertUtils;
import java.util.*;

import com.bv.cn.wsbase.base.model.*;
import com.bv.cn.wsbase.base.dao.*;
import com.bv.cn.wsbase.base.dao.impl.*;
import com.bv.cn.wsbase.base.service.*;
import com.bv.cn.wsbase.base.service.impl.*;
import com.bv.cn.wsbase.base.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 显示区域管理
 */

@Entity
@Table(name = "T_SHOWAREA")
public class Tshowarea extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_SHOWAREA";
	public static final String ALIAS_AREACODE = "areacode";
	public static final String ALIAS_AREANAME = "areaname";
	public static final String ALIAS_AREADESC = "areadesc";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 区域编码 db_column: AREACODE
	 */
	private java.lang.String areacode;
	/**
	 * 区域名称 db_column: AREANAME
	 */
	private java.lang.String areaname;
	/**
	 * 区域描述 db_column: AREADESC
	 */
	private java.lang.String areadesc;
	/**
	 * 显示顺序 db_column: SHOWORDER
	 */
	private java.lang.Integer showorder;
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

	public Tshowarea() {
	}

	public Tshowarea(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "AREACODE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(java.lang.String value) {
		this.areacode = value;
	}

	@Column(name = "AREANAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(java.lang.String value) {
		this.areaname = value;
	}

	@Column(name = "AREADESC", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getAreadesc() {
		return this.areadesc;
	}

	public void setAreadesc(java.lang.String value) {
		this.areadesc = value;
	}

	@Column(name = "SHOWORDER", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(java.lang.Integer value) {
		this.showorder = value;
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
	@JoinColumn(name = "AREAID")
	@OrderBy("resourceid asc")
	private Set<Tareaarticle> tareaarticles = new HashSet(0);

	public void setTareaarticles(Set<Tareaarticle> tareaarticle) {
		this.tareaarticles = tareaarticle;
	}

	public Set<Tareaarticle> getTareaarticles() {
		return tareaarticles;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append("Areacode", getAreacode())
				.append("Areaname", getAreaname()).append("Areadesc",
						getAreadesc()).append("Showorder", getShoworder())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tshowarea == false)
			return false;
		if (this == obj)
			return true;
		Tshowarea other = (Tshowarea) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
