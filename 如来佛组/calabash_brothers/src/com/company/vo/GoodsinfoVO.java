package com.company.vo;

/**
 * @author Vimi
 * @category 商品VO
 */
public class GoodsinfoVO {
	private int id;
	private int kid;
	private String kname;
	private String name;
	private String desc;
	private String price;
	private int count;
	private String weight;
	private String imgSrc;
	private int uid;
	
	public GoodsinfoVO() {
		super();
	}

	public GoodsinfoVO(int id, int kid, String kname, String name,String desc, String price, int count, String weight,
			String imgSrc, int uid) {
		super();
		this.id = id;
		this.kid = kid;
		this.kname = kname;
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

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public void setDesc(String desc){
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

	public String getimgSrc() {
		return imgSrc;
	}

	public void setimgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
