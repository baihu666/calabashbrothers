package com.company.dao;

import java.util.List;

import com.company.bean.Goodskind;

/**
 * @author hzm
 * @category 商品种类数据访问层
 *
 */
public interface IGoodskindDao {

	/**
	 * 查询所有商品种类
	 * 
	 * @return 商品种类
	 */
	public List<Goodskind> findAll();

	/**
	 * 根据id查询商品种类
	 * 
	 * @param name
	 * @return
	 */
	public Goodskind find(int id);
}
