package com.company.dao;

import java.util.List;

import com.company.bean.Attention;

/**
 * @author 张游
 *@category Attention关注数据访问层
 */
public interface IAttentionDao {
	/**
	 * 根据用户uid,查询用户关注的所有商品
	 * @param uid
	 * @return	查询用户关注的所有商品
	 */
	public List<Attention> findAll(int uid);
	/**
	 *根据商品gid添加商品到购物车中
	 * @param gid
	 * @return true or false
	 */
	public int addAttention(Attention attention);
	/**
	 * 根据商品gid删除关注的商品
	 * @param gid
	 * @return
	 */
	public int deleteAttention(int gid);
	/**
	 * @category 根据商品id删除该商品的所有关注
	 * @param gid
	 * @return
	 */
	public int deleteByGid(int gid);
	/**
	 * 根据用户uid删除该用户所有关注信息
	 * @param uid
	 * @return
	 */
	public int deleteByUser(int uid);
}
