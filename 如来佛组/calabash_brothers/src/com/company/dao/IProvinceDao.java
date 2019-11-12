package com.company.dao;

import java.util.List;

import com.company.bean.Province;

/**
 * @author hzm
 * @category 省的数据访问接口
 */
public interface IProvinceDao {

	/**
	 * 查询所有省份
	 * @return 省份列表
	 */
	public List<Province> findAll();

	/**
	 * 根据省份ID查询省份对象
	 * @param provinceId
	 * @return
	 */
	public Province findObject(String provinceId);
}
