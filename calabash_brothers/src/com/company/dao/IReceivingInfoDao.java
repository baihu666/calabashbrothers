package com.company.dao;

import java.util.List;

import com.company.bean.ReceivingInformation;

/**
 * @author 张游
 *@category 收货信息数据访问层
 */
public interface IReceivingInfoDao {
	/**
	 * 新建用户的收货信息
	 * @param rinfo
	 * @return
	 */
	public int save(ReceivingInformation rinfo);
	/**
	 * 删除收货信息表中一条信息
	 * @param id
	 * @return
	 */
	public int delete(int id);
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
	public int update(ReceivingInformation rinfo);
	
}
