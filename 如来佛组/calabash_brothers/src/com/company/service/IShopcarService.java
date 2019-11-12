package com.company.service;

import java.util.List;

import com.company.bean.Shopcar;
import com.company.vo.ShopcarVO;

/**
 * @author xll
 * @category 购物车业务逻辑层接口
 */
public interface IShopcarService {
	/**
	 * @param uid
	 * @return
	 * @category 根据用户id查询所有购物车商品
	 */
	public List<ShopcarVO> findAll(int uid);
	
	
	/**
	 * @category  根据购物车对象添加商品
	 * @param shopcar
	 * @return
	 */
	public boolean add(int gid,int uid,int ccount);
	
	/**
	 * @category  根据购物车id查询商品
	 * @param id
	 * @return
	 */
	public Shopcar find(int id);
	
	/**
	 * @category  根据购物车id删除商品
	 * @param id
	 * @return
	 */
	public boolean delate(int id);
	
	/**
	 * @category  根据购物车对象更新商品
	 * @param shopcar
	 * @return
	 */
	public boolean update(int id ,int gid,int uid,int ccount);
	
	/**
	 * 根据用户删除所有购物车商品
	 * @param uid
	 * @return
	 */
	public boolean deleteByUser(int uid);
	/**
	 * @category 根据商品id删除商品
	 * @param id
	 * @return
	 */

	public boolean deleteByGood(int gid);
}
