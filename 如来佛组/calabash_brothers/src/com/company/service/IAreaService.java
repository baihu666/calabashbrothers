package com.company.service;

import java.util.List;

import com.company.bean.Area;

/**
 * @author hzm
 * @category 区/县的业务逻辑层
 *
 */
public interface IAreaService {
	/**
	 * 根据城市id，查询相对应的区县列表
	 * @param cityId
	 * @return
	 */
	public List<Area> findAreasByCid(String cityId);

	/**
	 * 根据区县id，查询对应的区县对象
	 * @param areaId
	 * @return
	 */
	public Area findObject(String areaId);
}
