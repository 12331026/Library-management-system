package com.bv.cn.base.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseModel {
	
	public static final String ALIAS_RESOURCEID = "resourceid";
	public static final String ALIAS_CREATEDATE = "createdate";
	public static final String ALIAS_CREATER = "creater";
	public static final String ALIAS_CREATEUSERNAME = "createusername";
	public static final String ALIAS_UPDATEDATE = "updatedate";
	public static final String ALIAS_UPDATER = "updater";
	public static final String ALIAS_UPDATEUSERNAME = "updateusername";
	public static final String ALIAS_FLG_DELETED = "flgDeleted";

	@Id
	@Column(name = "RESOURCEID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String resourceid;

	@Column(name = "CREATEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	@Column(name = "CREATER")
	private String creater;

	@Column(name = "CREATEUSERNAME")
	private String createusername;

	@Column(name = "UPDATEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;

	@Column(name = "UPDATER")
	private String updater;

	@Column(name = "UPDATEUSERNAME")
	private String updateusername;

	@Column(name = "FLG_DELETED")
	private String flgDeleted;

	public String getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateusername() {
		return this.createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateusername() {
		return this.updateusername;
	}

	public void setUpdateusername(String updateusername) {
		this.updateusername = updateusername;
	}

	public String getFlgDeleted() {
		return this.flgDeleted;
	}

	public void setFlgDeleted(String flgDeleted) {
		this.flgDeleted = flgDeleted;
	}
}