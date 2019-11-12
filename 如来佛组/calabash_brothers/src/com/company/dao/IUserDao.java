package com.company.dao;

import java.util.List;

import com.company.bean.User;

/**
 * @author 任佳伟
 * @category 用户数据访问接口
 */
public interface IUserDao {
	/**
	 * 根据用户名密码登录
	 * 
	 * @param name
	 * @param pass
	 * @return User
	 */
	public User find(String name, String pass);

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return boolean
	 */
	public int add(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return boolean
	 */
	public int update(User user);

	/**
	 * 查找用户
	 * 
	 * @param id
	 * @return User
	 */
	public User find(int id);

	/**
	 * 查找用户列表，管理员除外
	 * 
	 * @return List<User>
	 */
	public List<User> findList();

	/**
	 * 删除该用户
	 * 
	 * @param id
	 * @return boolean
	 */
	public int delete(int id);
	/**
	 * 更改用户余额
	 * @param money
	 * @return	int
	 */
	public int updateMoney(int id,int money);
	/**
	 * 更改用户积分
	 * @param id
	 * @param Integral
	 * @return Int
	 */
	public int updateIntegral(int id,int integral);
	/**	上传更改头像
	 * @param id
	 * @param headimg
	 * @return
	 */
	public int updateHeadimg(int id,String headimg);
	/**
	 *  根据用户姓名查找user
	 * @param name
	 * @return User
	 */
	public User findByName(String name);
}
