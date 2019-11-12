package com.company.bean;

/**
 * @author 张游
 * @category 订单实体表
 */
public class Order {
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 购买者uid
	 */
	private int uid;
	/**
	 * 收货信息rid
	 */
	private int rid;
	/**
	 * 商品的总价格
	 */
	private int totalprice;
	/**
	 * 订单状态
	 */
	private int status;
	/**
	 * 商品id
	 */
	private int gid;

	public Order(int id, int uid, int rid, int totalprice, int status, int gid) {
		super();
		this.id = id;
		this.uid = uid;
		this.rid = rid;
		this.totalprice = totalprice;
		this.status = status;
		this.gid = gid;
	}

	public Order(int uid, int rid, int totalprice, int status, int gid) {
		super();
		this.uid = uid;
		this.rid = rid;
		this.totalprice = totalprice;
		this.status = status;
		this.gid = gid;
	}

	public Order() {
		super();
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

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}
}
