package com.company.bean;

/**
 * @author hzm
 * @category 购物车
 *
 */
public class Shopcar {

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
	 * 选购商品数量
	 */
	private int ccount;
	
	public Shopcar() {
		super();
	}


	public Shopcar(int gid, int uid, int ccount) {
		super();
		this.gid = gid;
		this.uid = uid;
		this.ccount = ccount;
	}


	public Shopcar(int id, int gid, int uid, int ccount) {
		super();
		this.id = id;
		this.gid = gid;
		this.uid = uid;
		this.ccount = ccount;
	}

	public int getId() {
		return id;
	}

	public int getCcount() {
		return ccount;
	}

	public void setCcount(int ccount) {
		this.ccount = ccount;
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

}
