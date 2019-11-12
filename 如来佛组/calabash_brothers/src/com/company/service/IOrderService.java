package com.company.service;

import java.util.List;

import com.company.bean.Order;
import com.company.vo.OrderVO;

public interface IOrderService {
	
	/**
	 * @category 插入订单
	 * @param order
	 * @return
	 */
	public boolean insert(Order order);
	
	/**
	 * @category 通过订单号以及买者id删除订单
	 * @param orderNo
	 * @param buyerId
	 * @return
	 */
	public boolean cancel(int orderNo);

	/**
	 * @category 后台查询订单管理
	 * @param orderNo
	 * @return
	 */
	public Order query(int orderNo);
	/**
	 * @category 分页显示订单
	 * @param buyerId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Order> find(int buyerId);
	/**
	 * @category 根据订单id更改订单状态
	 * @param id
	 * @param status
	 * @return
	 */
	public boolean update(int id,int status);
	/**
	 * @category 根据获得的列表将列表转换成VO视图
	 * @param order
	 * @return
	 */
	public List<OrderVO> findVO(int uid);
	/**
	 * @category 根据uid和status查询该状态下的所有订单
	 * @param uid
	 * @param status
	 * @return
	 */
	public List<OrderVO> findVO(int uid, int status);
}
