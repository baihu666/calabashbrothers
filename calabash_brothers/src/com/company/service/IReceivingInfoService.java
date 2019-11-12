package com.company.service;

import java.util.List;

import com.company.bean.ReceivingInformation;
/**
 * @author 张游
 *@category 收货信息业务逻辑层
 */
public interface IReceivingInfoService {
	/**
	 * 根据前端接受的信息给收货信息表中添加信息
	 * @param rusername
	 * @param tel
	 * @param area
	 * @param addres
	 * @param uid
	 * @return
	 */
	public boolean save(String rusername,String tel,String area,String addres,int uid);
	/**
	 * 删除收货信息表中一条信息
	 * @param id 评论的id
	 * @return
	 */
	public boolean delete(int id);
	/**
	 * 根据id查询该人的一条收货地址
	 * @param id
	 * @return
	 */
	public ReceivingInformation find(int id);
	/**
	 * 根据uid查询该人的所有收货地址
	 * @param uid
	 * @return
	 */
	public List<ReceivingInformation> findAll(int uid);
	/**
	 * 编辑个人收货信息
	 * @param rinfo
	 * @return
	 */
	public boolean update(ReceivingInformation rinfo);
	
}
