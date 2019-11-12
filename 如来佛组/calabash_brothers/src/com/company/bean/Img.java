package com.company.bean;

/**
 * @author Vimi
 * @category 图片类
 */
public class Img {
	
	/**
	 * 图片id
	 */
	private int id;
	/**
	 * 图片路径
	 */
	private String src;
	
	public Img() {
		super();
	}

	public Img(String src) {
		super();
		this.src = src;
	}

	public Img(int id, String src) {
		super();
		this.id = id;
		this.src = src;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	
}
