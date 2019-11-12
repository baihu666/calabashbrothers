package com.company.service;

import java.util.List;

import com.company.bean.User;

public interface IUserService {
	/**
	 * 根据用户名密码登录
	 * @param name
	 * @param pass
	 * @return User
	 */
	public User find(String name,String pass);
	/**
	 * 新增用户
	 * @param user
	 * @return boolean
	 */
	public boolean add(User user); 
	/**
	 * 信息修改
	 * @param user
	 * @return boolean
	 */
	public boolean update(User user);
	/**
	 * @category 查看用户信息
	 * @param id
	 * @return User
	 */
	public User find(String id);
	/**
	 * 查找用户列表，管理员除外
	 * @return List<User>
	 */
	public List<User> findList();
	/**
	 *  删除用户
	 * @param id
	 * @return boolean
	 */
	public boolean delete(int id);
	/**
	 * 更新用户余额
	 * @param id
	 * @param money
	 * @param flag 代表充值/提现
	 * @return boolean
	 */
	public boolean updateMoney(int id,String money,boolean flag);
	/**
	 * 更改用户积分
	 * @param id
	 * @param integral
	 * @param flag
	 * @return
	 */
	public boolean updateIntegral(int id,String integral,boolean flag);
	/**
	 * 更改头像
	 * @param id
	 * @param headimg
	 * @return boolean
	 */
	public boolean updateHeadimg(int id,String headimg);
	/**
	 * 查看用户名是否存在
	 * @param name
	 * @return
	 */
	public boolean findByName(String name);
}
