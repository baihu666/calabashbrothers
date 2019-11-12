package com.company.service;

import java.util.List;

import com.company.bean.Recording;

/**
 * @author BH
 * @category 购买记录业务逻辑接口类
 */
public interface IRecordingService {
	
	/**
	 * 根据用户id查询该用户的所有购买记录
	 * @param uid
	 * @return
	 */
	public List<Recording> findAll(int uid);
	/**
	 * 根据购物车ID查询购买记录
	 * @param id
	 * @return
	 */
	public Recording find(int id);
	/**
	 * 增加购买记录
	 * @param recording
	 * @return
	 */
	public boolean add(Recording recording);
	/**
	 * 根据用户ID删除该用户的所有购买记录
	 * @param uid
	 * @return
	 */
	public boolean delete(int uid);
	/**
	 * 根据购物车id删除购买记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id);
}
