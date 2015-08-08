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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.bv.cn.base.model.BaseModel;
import com.bv.cn.wsbase.base.model.Tuser;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 留言消息
 */

@Entity
@Table(name = "T_MESSAGE")
public class Tmessage extends BaseModel implements java.io.Serializable {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// alias
	public static final String TABLE_ALIAS = "T_MESSAGE";
	public static final String ALIAS_MSGSRCID = "msgsrcid";
	public static final String ALIAS_MSGSRC = "tusersrc";
	public static final String ALIAS_MSGDESTID = "msgdestid";
	public static final String ALIAS_MSGDEST = "tuserdest";
	public static final String ALIAS_PARENTID = "parentid";
	public static final String ALIAS_PARENT = "tmessage";
	public static final String ALIAS_MESSAGEBODY = "messagebody";
	public static final String ALIAS_RESSTATUS = "resstatus";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_SHOWORDER = "showorder";
	public static final String ALIAS_EXT1 = "ext1";
	public static final String ALIAS_EXT2 = "ext2";
	public static final String ALIAS_EXT3 = "ext3";

	// date formats
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;

	// columns START
	/**
	 * 消息来源人ID db_column: MSGSRCID
	 */
	// private java.lang.String msgsrcid;
	/**
	 * 消息目标人ID db_column: MSGDESTID
	 */
	// private java.lang.String msgdestid;
	/**
	 * 父消息ID db_column: PARENTID
	 */
	// private java.lang.String parentid;
	/**
	 * 消息内容 db_column: MESSAGEBODY
	 */
	private java.lang.String messagebody;
	/**
	 * 回复状态: DHF：待回复 YHF：已回复 DEL：删除 db_column: RESSTATUS
	 */
	private java.lang.String resstatus;
	/**
	 * 备注 db_column: REMARK
	 */
	private java.lang.String remark;
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

	public Tmessage() {
	}

	public Tmessage(java.lang.String resourceid) {
		this.setResourceid(resourceid);
	}

	// @Column(name = "MSGSRCID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getMsgsrcid() {
	// return this.msgsrcid;
	// }
	//
	// public void setMsgsrcid(java.lang.String value) {
	// this.msgsrcid = value;
	// }
	//
	// @Column(name = "MSGDESTID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getMsgdestid() {
	// return this.msgdestid;
	// }
	//
	// public void setMsgdestid(java.lang.String value) {
	// this.msgdestid = value;
	// }
	//
	// @Column(name = "PARENTID", unique = false, nullable = true, insertable =
	// true, updatable = true, length = 32)
	// public java.lang.String getParentid() {
	// return this.parentid;
	// }
	//
	// public void setParentid(java.lang.String value) {
	// this.parentid = value;
	// }

	@Column(name = "MESSAGEBODY", unique = false, nullable = true, insertable = true, updatable = true, length = 2048)
	public java.lang.String getMessagebody() {
		return this.messagebody;
	}

	public void setMessagebody(java.lang.String value) {
		this.messagebody = value;
	}

	@Column(name = "RESSTATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 5)
	public java.lang.String getResstatus() {
		return this.resstatus;
	}

	public void setResstatus(java.lang.String value) {
		this.resstatus = value;
	}

	@Column(name = "REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String value) {
		this.remark = value;
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
	@JoinColumn(name = "PARENTID")
	@OrderBy("showorder desc")
	private Set<Tmessage> tmessages = new HashSet(0);

	public void setTmessages(Set<Tmessage> tmessage) {
		this.tmessages = tmessage;
	}

	public Set<Tmessage> getTmessages() {
		return tmessages;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "MSGSRCID", nullable = false, insertable = false, updatable = false) })
	private Tuser tusersrc;

	public void setTusersrc(Tuser tuser) {
		this.tusersrc = tuser;
	}

	public Tuser getTusersrc() {
		return tusersrc;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "MSGDESTID", nullable = false, insertable = false, updatable = false) })
	private Tuser tuserdest;

	public void setTuserdest(Tuser tuser) {
		this.tuserdest = tuser;
	}

	public Tuser getTuserdest() {
		return tuserdest;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumns( { @JoinColumn(name = "PARENTID", nullable = false, insertable = false, updatable = false) })
	private Tmessage tmessage;

	public void setTmessage(Tmessage tmessage) {
		this.tmessage = tmessage;
	}

	public Tmessage getTmessage() {
		return tmessage;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Resourceid", getResourceid()).append("Createdate",
						getCreatedate()).append("Creater", getCreater())
				.append("Createusername", getCreateusername()).append(
						"Updatedate", getUpdatedate()).append("Updater",
						getUpdater()).append("Updateusername",
						getUpdateusername()).append("FlgDeleted",
						getFlgDeleted()).append(
						"Msgsrcid",
						getTusersrc() == null ? "" : getTusersrc()
								.getResourceid()).append(
						"Msgdestid",
						getTuserdest() == null ? "" : getTuserdest()
								.getResourceid()).append(
						"Parentid",
						getTmessage() == null ? "" : getTmessage()
								.getResourceid()).append("Messagebody",
						getMessagebody()).append("Resstatus", getResstatus())
				.append("Remark", getRemark()).append("Showorder",
						getShoworder()).append("Ext1", getExt1()).append(
						"Ext2", getExt2()).append("Ext3", getExt3()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getResourceid()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tmessage == false)
			return false;
		if (this == obj)
			return true;
		Tmessage other = (Tmessage) obj;
		return new EqualsBuilder().append(getResourceid(),
				other.getResourceid()).isEquals();
	}
}
