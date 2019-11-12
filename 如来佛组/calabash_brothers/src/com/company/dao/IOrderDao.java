package com.company.dao;

import java.util.List;

import com.company.bean.Order;

/**
 * @author Administrator
 * @category 订单数据访问接口类
 */
public interface IOrderDao {
	/**
	 * @category 查询出来订单
	 * @param orderNo
	 * @return
	 */
	public Order selectByOrderNo(int orderNo);
	/**
	 * @category 创建订单
	 * @param order
	 * @return
	 */
	public int insert(Order order);
	/**
	 * @category 根据订单id删除订单
	 * @param orderNo
	 * @param buyerId
	 * @return
	 */
	public int cancel(int id);
	/**
	 * @category 根据订单id更改订单状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int update(int id,int status);
	/**
	 * 根据用户ID查询用户id 的所有订单
	 * @param uid
	 * @return
	 */
	public List<Order> find(int uid);
	/**
	 * @category 根据uid和status查询所有订单
	 * @param uid
	 * @param status
	 * @return
	 */
	public List<Order> find(int uid,int status);
}
