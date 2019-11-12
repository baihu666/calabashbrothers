package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.Goodskind;
import com.company.dao.IGoodskindDao;
import com.company.dao.impl.GoodskindDaoImpl;
import com.company.service.IGoodskindService;

/**
 * @author Administrator
 *
 */
public class GoodskindServiceImpl implements IGoodskindService {

	@Test
	public void test(){
		System.out.println(findAll().size());
	}
	
	
	private IGoodskindDao goodskindDao = new GoodskindDaoImpl();

	public List<Goodskind> findAll() {
		return goodskindDao.findAll();
	}

	public Goodskind find(int id) {
		return goodskindDao.find(id);
	}

}
