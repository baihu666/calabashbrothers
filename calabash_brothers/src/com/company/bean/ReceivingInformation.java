package com.company.bean;

/**
 * @author 张游
 * @category 收货信息实体类
 */
public class ReceivingInformation {
	/**
	 * 收货信息id
	 */
	private int id;
	/**
	 * 收货人名字
	 */
	private String rusername;
	/**
	 * 收货人电话
	 */
	private String tel;
	/**
	 * 收货人所在地区
	 */
	private String area;
	/**
	 * 收货人具体地址
	 */
	private String addres;
	/**
	 * 商品购买用户uid
	 */
	private int uid;

	public ReceivingInformation(int id, String rusername, String tel, String area, String addres, int uid) {
		super();
		this.id = id;
		this.rusername = rusername;
		this.tel = tel;
		this.area = area;
		this.addres = addres;
		this.uid = uid;
	}

	public ReceivingInformation(String rusername, String tel, String area, String addres, int uid) {
		super();
		this.rusername = rusername;
		this.tel = tel;
		this.area = area;
		this.addres = addres;
		this.uid = uid;
	}

	public ReceivingInformation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRusername() {
		return rusername;
	}

	public void setRusername(String rusername) {
		this.rusername = rusername;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
