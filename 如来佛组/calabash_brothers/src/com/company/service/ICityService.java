package com.company.service;

import java.util.List;

import com.company.bean.City;

/**
 * @author hzm
 * @category 城市的业务逻辑层
 *
 */
public interface ICityService {

	/**
	 * 根据省的id，查找出市列表
	 * @param provinceId
	 * @return
	 */
	public List<City> findCitiesByPid(String provinceId);

	/**
	 * 根据城市id，查找出对应的市对象
	 * @param cityId
	 * @return
	 */
	public City findObject(String cityId);
}
