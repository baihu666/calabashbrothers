package com.company.dao;

import java.util.List;

import com.company.bean.City;

/**
 * @author hzm
 * @category 城市数据访问层
 *
 */
public interface ICityDao {
	/**
	 * 根据省份id查询出所有的城市列表
	 * @param provinceId
	 * @return
	 */
	public List<City> findCitiesByPid(String provinceId);
	
	/**
	 * 根据城市id，查询出对应的城市对象
	 * @param cityId
	 * @return
	 */
	public City findObject(String cityId);
}
