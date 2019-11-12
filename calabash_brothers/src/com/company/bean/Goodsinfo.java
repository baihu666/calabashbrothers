package com.company.bean;

/**
 * @author hzm
 * @category 商品信息
 *
 */
public class Goodsinfo {
	/**
	 * 商品编号
	 */
	private int id;
	/**
	 * 商品分类id
	 */
	private int kid;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 商品描述
	 */
	private String desc;
	/**
	 * 价格
	 */
	private String price;
	/**
	 * 数量
	 */
	private int count;
	/**
	 * 重量
	 */
	private String weight;
	/**
	 * 图片路径
	 */
	private String imgSrc;
	/**
	 * 用户id
	 */
	private int uid;
	

	public Goodsinfo() {
		super();
	}
	
	
	
	public Goodsinfo(int id, String imgSrc) {
		super();
		this.id = id;
		this.imgSrc = imgSrc;
	}

	

	public Goodsinfo(int kid, String name, String desc, String price, int count, String weight) {
		super();
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.weight = weight;
	}



	public Goodsinfo(int kid, String name, String desc, String price, int count, String weight, int uid) {
		super();
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.weight = weight;
		this.uid = uid;
	}



	public Goodsinfo(int kid, String name, String desc, String price, int count, String weight, String imgSrc,
			int uid) {
		super();
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.weight = weight;
		this.imgSrc = imgSrc;
		this.uid = uid;
	}

	public Goodsinfo(int id, int kid, String name, String desc, String price, int count, String weight, String imgSrc,
			int uid) {
		super();
		this.id = id;
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.weight = weight;
		this.imgSrc = imgSrc;
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
