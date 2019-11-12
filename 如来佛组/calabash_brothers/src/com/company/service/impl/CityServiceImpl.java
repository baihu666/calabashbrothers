package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.City;
import com.company.dao.ICityDao;
import com.company.dao.impl.CityDaoImpl;
import com.company.service.ICityService;

/**
 * @author hzm
 * @category 城市业务逻辑实现类
 *
 */
public class CityServiceImpl implements ICityService {

	
	@Test
	public void test(){
		System.out.println(findObject("110100").getCity());
	}
	
	private ICityDao cityDao = new CityDaoImpl(); 
	public List<City> findCitiesByPid(String provinceId) {
		List<City> list = null;
		if (provinceId!= null) {
			list = cityDao.findCitiesByPid(provinceId);
		}
		return list;
	}

	public City findObject(String cityId) {
		return cityDao.findObject(cityId);
	}

}
