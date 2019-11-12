package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.Province;
import com.company.dao.IProvinceDao;
import com.company.dao.impl.ProvinceDaoImpl;
import com.company.service.IProvinceService;

/**
 * @author hzm
 * @category 省业务逻辑实现类
 *
 */
public class ProvinceServiceImpl implements IProvinceService {
	
	@Test
	public void test(){
		System.out.println(findObject("110000").getProvince());
	}
	
	
	
	private IProvinceDao provinceDao = new ProvinceDaoImpl();

	@Override
	public List<Province> findAll() {
		return provinceDao.findAll();
	}

	@Override
	public Province findObject(String provinceId) {
		return provinceDao.findObject(provinceId);
	}

}
