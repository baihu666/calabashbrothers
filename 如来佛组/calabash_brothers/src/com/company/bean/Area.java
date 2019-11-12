package com.company.bean;

/**
 * @author hzm
 * @category 区数据访问接口类
 *
 */
public class Area {

	private int id;
	/**
	 * 区/县编号
	 */
	private String areaID;
	/**
	 * 区/县
	 */
	private String area;
	/**
	 * 城市编号
	 */
	private String cityID;

	public Area() {
		super();
	}

	public Area(int id, String areaID, String area, String cityID) {
		super();
		this.id = id;
		this.areaID = areaID;
		this.area = area;
		this.cityID = cityID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaID() {
		return areaID;
	}

	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

}
