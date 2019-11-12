package com.company.service;

import java.util.List;

import com.company.bean.Province;

/**
 * @author hzm
 * @category 省份业务逻辑层
 *
 */
public interface IProvinceService {

	/**
	 * 查找所有的省份
	 * @return
	 */
	public List<Province> findAll();

	/**
	 * 根据省的id，查找出省的对象
	 * @param provinceId
	 * @return
	 */
	public Province findObject(String provinceId);
}
