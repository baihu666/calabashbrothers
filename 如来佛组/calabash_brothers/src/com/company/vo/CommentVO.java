package com.company.vo;

import java.util.Date;

/**
 * @author 张杨
 * @category 评论视图类
 */
public class CommentVO {
	
	private int id;
	/**
	 * 用户编号
	 */
	private int uid;
	/**
	 * 商品编号
	 */
	private int gid;
	/**
	 * 用户名称：评论的人
	 */
	private String userName;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 评论时间
	 */
	private Date datetime;
	/**
	 * 评论时间字符串
	 */
	private String dateTimeStr;
	
	public CommentVO() {
		super();
	}
	
	public CommentVO(int id, int uid, int gid, String userName, String content, Date datetime, String dateTimeStr) {
		super();
		this.id = id;
		this.uid = uid;
		this.gid = gid;
		this.userName = userName;
		this.content = content;
		this.datetime = datetime;
		this.dateTimeStr = dateTimeStr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getDateTimeStr() {
		return dateTimeStr;
	}

	public void setDateTimeStr(String dateTimeStr) {
		this.dateTimeStr = dateTimeStr;
	}
	
	
	

}
