/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BassCreateModle;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 引用图片管理
 */

@Entity
@Table(name = "T_IMAGELINK")
public class Timagelink extends BassCreateModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_IMAGELINK";
	public static final String ALIAS_IMAGETYPE = "imagetype";
	public static final String ALIAS_MODULEBELONG = "modulebelong";
	public static final String ALIAS_IMAGEFILECNNAME = "imagefilecnname";
	public static final String ALIAS_IMAGEPATH = "imagepath";
	public static final String ALIAS_FILEEXTNAME = "fileextname";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 图片所属分类 db_column: IMAGETYPE
	 */
	private java.lang.String imagetype;
	/**
	 * 所属模块 db_column: MODULEBELONG
	 */
	private java.lang.String modulebelong;
	/**
	 * 图片文件中文名称 db_column: IMAGEFILECNNAME
	 */
	private java.lang.String imagefilecnname;
	/**
	 * 图片相对路径 db_column: IMAGEPATH
	 */
	private java.lang.String imagepath;
	/**
	 * 图片扩展名 db_column: FILEEXTNAME
	 */
	private java.lang.String fileextname;
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

	public Timagelink() {
	}

	public Timagelink(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "IMAGETYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getImagetype() {
		return this.imagetype;
	}

	public void setImagetype(java.lang.String value) {
		this.imagetype = value;
	}

	@Column(name = "MODULEBELONG", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getModulebelong() {
		return this.modulebelong;
	}

	public void setModulebelong(java.lang.String value) {
		this.modulebelong = value;
	}

	@Column(name = "IMAGEFILECNNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getImagefilecnname() {
		return this.imagefilecnname;
	}

	public void setImagefilecnname(java.lang.String value) {
		this.imagefilecnname = value;
	}

	@Column(name = "IMAGEPATH", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(java.lang.String value) {
		this.imagepath = value;
	}

	@Column(name = "FILEEXTNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFileextname() {
		return this.fileextname;
	}

	public void setFileextname(java.lang.String value) {
		this.fileextname = value;
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

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"FlgDeleted", getFlgDeleted()).append("Imagetype",
						getImagetype()).append("Modulebelong",
						getModulebelong()).append("Imagefilecnname",
						getImagefilecnname()).append("Imagepath",
						getImagepath()).append("Fileextname", getFileextname())
				.append("Showorder", getShoworder()).append("Ext1", getExt1())
				.append("Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Timagelink == false)
			return false;
		if (this == obj)
			return true;
		Timagelink other = (Timagelink) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
