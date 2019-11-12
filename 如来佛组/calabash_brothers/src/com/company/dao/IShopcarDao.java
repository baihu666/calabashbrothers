package com.company.dao;

import java.util.List;

import com.company.bean.Shopcar;

/**
 * @author xll
 * @category 购物车数据访问接口
 */
public interface IShopcarDao {

	/**
	 * @param uid
	 * @return
	 * @category 根据用户id查询所有购物车商品
	 */
	public List<Shopcar> findAll(int uid);

	/**
	 * @category 根据购物车对象添加商品
	 * @param shopcar
	 * @return
	 */

	public int add(Shopcar shopcar);
	
	/**
	 * @category 根据购物车id查询商品
	 * @param id
	 * @return
	 */
	public Shopcar find(int id);
	
	/**
	 * @category 根据购物车id删除商品
	 * @param id
	 * @return
	 */

	public int delete(int id);
	
	/**
	 * @category 根据购物车对象更新商品
	 * @param shopcar
	 * @return
	 */
	public int update(Shopcar shopcar);
	/**
	 * 根据用户删除所有购物车商品
	 * @param uid
	 * @return
	 */
	public int deleteByUser(int uid);
	
	/**
	 * @category 根据商品id删除商品
	 * @param id
	 * @return
	 */

	public int deleteByGood(int gid);
}
