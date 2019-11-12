package com.company.bean;

import java.sql.Timestamp;

/**
 * @author hzm
 * @category 购买记录
 *
 */
public class Recording {

	private int id;
	/**
	 * 商品编号
	 */
	private int gid;
	/**
	 * 用户编号
	 */
	private int uid;
	/**
	 * 购买时间
	 */
	private Timestamp datetime;

	public Recording() {
		super();
	}
	
	public Recording(int gid, int uid, Timestamp datetime) {
		super();
		this.gid = gid;
		this.uid = uid;
		this.datetime = datetime;
	}
	
	public Recording(int id, int gid, int uid, Timestamp datetime) {
		super();
		this.id = id;
		this.gid = gid;
		this.uid = uid;
		this.datetime = datetime;
	}

	public Recording(int gid) {
		super();
		this.gid = gid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
