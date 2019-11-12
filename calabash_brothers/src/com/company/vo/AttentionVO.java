package com.company.vo;

/**
 * @author 张游
 *@category 关注视图类
 */
public class AttentionVO {
	/**
	 * 商品编号
	 */
	private int id;
	/**
	 * 商品id
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
	 * 图片id
	 */
	private String imgSrc;
	/**
	 * 商品评论总数
	 */
	private int commentNum;
	public AttentionVO(int id, int kid, String name, String desc, String price, int count, String weight, String imgSrc,
			int commentNum) {
		super();
		this.id = id;
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.weight = weight;
		this.imgSrc = imgSrc;
		this.commentNum = commentNum;
	}
	
	public AttentionVO(int id, int kid, String name, String desc, String price, int count, String imgSrc,
			int commentNum) {
		super();
		this.id = id;
		this.kid = kid;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.count = count;
		this.imgSrc = imgSrc;
		this.commentNum = commentNum;
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
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
}
