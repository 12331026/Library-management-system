/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.common.utils.DateConvertUtils;
import com.bv.cn.base.model.BassResModle;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 性能日志表
 */

@Entity
@Table(name = "T_PERF_STAT")
public class TperfStat extends BassResModle implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_PERF_STAT";
	public static final String ALIAS_STARTTIME = "starttime";
	public static final String ALIAS_CLASSNAME = "classname";
	public static final String ALIAS_METHODNAME = "methodname";
	public static final String ALIAS_PARAM = "param";
	public static final String ALIAS_RETURNVALUE = "returnvalue";
	public static final String ALIAS_DURATION = "duration";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_STARTTIME = DATE_FORMAT;

	// columns START
	@Column(name = "CREATEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;


	@Column(name = "FLG_DELETED")
	private String flgDeleted;
	
	/**
	 * 开始时间 db_column: STARTTIME
	 */
	private java.sql.Timestamp starttime;
	/**
	 * 类名 db_column: CLASSNAME
	 */
	private java.lang.String classname;
	/**
	 * 方法名 db_column: METHODNAME
	 */
	private java.lang.String methodname;
	/**
	 * 参数 db_column: PARAM
	 */
	private java.lang.String param;
	/**
	 * 返回值 db_column: RETURNVALUE
	 */
	private java.lang.String returnvalue;
	/**
	 * 消耗时间 db_column: DURATION
	 */
	private java.math.BigDecimal duration;
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

	public TperfStat() {
	}

	public TperfStat(String resourceid) {
		this.setResourceid(resourceid);
	}

	@Transient
	public String getStarttimeString() {
		return DateConvertUtils.format(getStarttime(), FORMAT_STARTTIME);
	}

	@Column(name = "STARTTIME", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public java.sql.Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(java.sql.Timestamp value) {
		this.starttime = value;
	}

	@Column(name = "CLASSNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getClassname() {
		return this.classname;
	}

	public void setClassname(java.lang.String value) {
		this.classname = value;
	}

	@Column(name = "METHODNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 128)
	public java.lang.String getMethodname() {
		return this.methodname;
	}

	public void setMethodname(java.lang.String value) {
		this.methodname = value;
	}

	@Column(name = "PARAM", unique = false, nullable = true, insertable = true, updatable = true, length = 2048)
	public java.lang.String getParam() {
		return this.param;
	}

	public void setParam(java.lang.String value) {
		this.param = value;
	}

	@Column(name = "RETURNVALUE", unique = false, nullable = true, insertable = true, updatable = true, length = 2048)
	public java.lang.String getReturnvalue() {
		return this.returnvalue;
	}

	public void setReturnvalue(java.lang.String value) {
		this.returnvalue = value;
	}

	@Column(name = "DURATION", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.math.BigDecimal getDuration() {
		return this.duration;
	}

	public void setDuration(java.math.BigDecimal value) {
		this.duration = value;
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

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getFlgDeleted() {
		return flgDeleted;
	}

	public void setFlgDeleted(String flgDeleted) {
		this.flgDeleted = flgDeleted;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("FlgDeleted", getFlgDeleted())
				.append("Starttime", getStarttime()).append("Classname",
						getClassname()).append("Methodname", getMethodname())
				.append("Param", getParam()).append("Returnvalue",
						getReturnvalue()).append("Duration", getDuration())
				.append("Ext1", getExt1()).append("Ext2", getExt2()).append(
						"Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TperfStat == false)
			return false;
		if (this == obj)
			return true;
		TperfStat other = (TperfStat) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
