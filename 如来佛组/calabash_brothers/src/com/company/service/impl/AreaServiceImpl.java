package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.Area;
import com.company.dao.IAreaDao;
import com.company.dao.impl.AreaDaoImpl;
import com.company.service.IAreaService;

/**
 * @author hzm
 * @category 区/县业务逻辑实现类
 *
 */
public class AreaServiceImpl implements IAreaService {

	@Test
	public void test(){
		System.out.println(findAreasByCid("110100").size());
	}
	
	private IAreaDao areaDao = new AreaDaoImpl();
	public List<Area> findAreasByCid(String cityId) {
		List<Area> list = null;
		if (cityId!=null) {
			list = areaDao.findAreasByCid(cityId);
		}
		return list;
	}

	public Area findObject(String areaId) {
		return areaDao.findObject(areaId);
	}

}
