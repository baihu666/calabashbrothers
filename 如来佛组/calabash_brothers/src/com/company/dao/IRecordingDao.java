package com.company.dao;

import java.util.List;

import com.company.bean.Recording;

/**
 * @author 白虎
 * @category 购买记录接口类
 */
public interface IRecordingDao {
	/**
	 * 查询所有购买记录
	 * 
	 * @return 购买记录集合
	 */
	public List<Recording> findAll(int id);

	/**
	 * 根据id查询某个购买记录
	 * 
	 * @param id
	 * @return 购买记录对象
	 */
	public Recording find(int id);

	/**
	 * 增加购买记录
	 * 
	 * @param recording
	 * @return 购买记录对象
	 */
	public int add(Recording recording);

	/**
	 * 删除该用户购买记录
	 * 
	 * @param uid
	 * @return
	 */
	public int delete(int uid);

	/**
	 * 根据ID删除购买记录
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(int id);
}
