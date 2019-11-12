package com.company.bean;

/**
 * @author
 * @category 省
 */
public class Province {

	private int id;
	/**
	 * 省份编号
	 */
	private String provinceId;
	/**
	 * 省份
	 */
	private String province;

	public Province() {
		super();
	}

	public Province(int id, String provinceId, String province) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
