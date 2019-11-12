package com.company.bean;

/**
 * @author hzm
 * @category 关注
 *
 */
public class Attention {

	private int id;
	/**
	 * 用户编号
	 */
	private int uid;
	/**
	 * 商品编号
	 */
	private int gid;

	public Attention() {
		super();
	}

	public Attention(int id, int uid, int gid) {
		super();
		this.id = id;
		this.uid = uid;
		this.gid = gid;
	}

	public Attention(int uid, int gid) {
		super();
		this.uid = uid;
		this.gid = gid;
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

}
