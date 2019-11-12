package com.company.bean;

/**
 * @author hzm
 * @category 商品种类
 *
 */
public class Goodskind {

	/**
	 * 商品id
	 */
	private int id;
	/**
	 * 种类
	 */
	private String name;

	public Goodskind() {
		super();
	}

	public Goodskind(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
