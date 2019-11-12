package com.company.service;

import java.util.List;

import com.company.bean.Goodskind;

/**
 * @author hzm
 * @category 商品种类的业务逻辑接口
 *
 */
public interface IGoodskindService {

	/**
	 * 查询商品种类
	 */
	public List<Goodskind> findAll();

	/**
	 * 查询商品类对象
	 * @param id 商品类型对象的ID
	 * @return
	 */
	public Goodskind find(int id);

}
