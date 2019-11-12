package com.company.vo;

/**
 * @author xll
 * @category 购物车Vo
 *
 */
public class ShopcarVO {
	/**
	 * id
	 */
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
	 * 数量
	 */
	private int ccount;
	
	/**
	 * 图片
	 */
	private String img;
	
	/**
	 * 单价
	 */
	private String price;
	
	/**
	 * 某个商品总价
	 */
	private int tprice;
	
	/**
	 * 商品介绍
	 */
	private String desc;
	
	public ShopcarVO() {
		super();
	}
  
	public ShopcarVO(int id, int gid, int uid, int ccount, String img, String price, int tprice, String desc) {
		super();
		this.id = id;
		this.gid = gid;
		this.uid = uid;
		this.ccount = ccount;
		this.img = img;
		this.price = price;
		this.tprice = tprice;
		this.desc = desc;
	}

	public ShopcarVO(int gid, int uid, int ccount, String img, String price, int tprice, String desc) {
		super();
		this.gid = gid;
		this.uid = uid;
		this.ccount = ccount;
		this.img = img;
		this.price = price;
		this.tprice = tprice;
		this.desc = desc;
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

	public int getCcount() {
		return ccount;
	}

	public void setCcount(int ccount) {
		this.ccount = ccount;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
