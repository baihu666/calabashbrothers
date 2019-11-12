package com.company.bean;

import java.util.Date;

/**
 * @author hzm
 * @category 评论
 *
 */
public class Comment {

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
	 * 评论内容
	 */
	private String content;
	/**
	 * 评论时间
	 */
	private Date datetime;
	
	
	public Comment() {
		super();
	}
	
	public Comment(int gid, int uid, String content) {
		super();
		this.gid = gid;
		this.uid = uid;
		this.content = content;
	}
	
	

	public Comment(int gid, int uid, String content, Date datetime) {
		super();
		this.gid = gid;
		this.uid = uid;
		this.content = content;
		this.datetime = datetime;
	}

	public Comment(int id, int gid, int uid, String content, Date datetime) {
		super();
		this.id = id;
		this.gid = gid;
		this.uid = uid;
		this.content = content;
		this.datetime = datetime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
