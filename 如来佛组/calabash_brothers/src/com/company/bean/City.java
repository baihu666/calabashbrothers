package com.company.bean;

/**
 * @author hzm
 * @category 城市
 *
 */
public class City {

	private int id;
	/**
	 * 城市编号
	 */
	private String cityID;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 省份编号
	 */
	private String provinceID;

	public City() {
		super();
	}

	public City(int id, String cityID, String city, String provinceID) {
		super();
		this.id = id;
		this.cityID = cityID;
		this.city = city;
		this.provinceID = provinceID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

}
