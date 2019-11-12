package com.company.dao;

import java.util.List;

import com.company.bean.Area;

/**
 * @author hzm
 * @category 区县数据访问层
 *
 */
public interface IAreaDao {
	/**
	 * 根据城市id，查询出所有的区县列表
	 * @param cityId
	 * @return
	 */
	public List<Area> findAreasByCid(String cityId);
	
	/**
	 * 根据区县id查询出对应的区县对象
	 * @param areaId
	 * @return
	 */
	public Area findObject(String areaId);
}
