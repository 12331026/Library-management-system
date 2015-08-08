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
 * @module 附件上传
 */

@Entity
@Table(name = "T_FILEUPLOAD")
public class Tfileupload extends BassCreateModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_FILEUPLOAD";
	public static final String ALIAS_MODULECODE = "modulecode";
	public static final String ALIAS_FORMID = "formid";
	public static final String ALIAS_FILENAME = "filename";
	public static final String ALIAS_FILEEXT = "fileext";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 模块ID db_column: MODULEID
	 */
	private java.lang.String modulecode;
	/**
	 * 工单ID db_column: FORMID
	 */
	private java.lang.String formid;
	/**
	 * 文件名称 db_column: FILENAME
	 */
	private java.lang.String filename;
	/**
	 * 文件后缀 db_column: FILEEXT
	 */
	private java.lang.String fileext;
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

	public Tfileupload() {
	}

	public Tfileupload(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	@Column(name = "MODULEID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getModulecode() {
		return this.modulecode;
	}

	public void setModulecode(java.lang.String value) {
		this.modulecode = value;
	}

	@Column(name = "FORMID", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getFormid() {
		return this.formid;
	}

	public void setFormid(java.lang.String value) {
		this.formid = value;
	}

	@Column(name = "FILENAME", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getFilename() {
		return this.filename;
	}

	public void setFilename(java.lang.String value) {
		this.filename = value;
	}

	@Column(name = "FILEEXT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFileext() {
		return this.fileext;
	}

	public void setFileext(java.lang.String value) {
		this.fileext = value;
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
						"FlgDeleted", getFlgDeleted()).append("Modulecode",
						getModulecode()).append("Formid", getFormid()).append(
						"Filename", getFilename()).append("Fileext",
						getFileext()).append("Ext1", getExt1()).append("Ext2",
						getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tfileupload == false)
			return false;
		if (this == obj)
			return true;
		Tfileupload other = (Tfileupload) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
