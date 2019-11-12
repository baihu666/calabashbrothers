package com.company.service;

import java.util.List;

import com.company.bean.Attention;
import com.company.vo.AttentionVO;

/**
 * @author 张游
 *@category 关注业务逻辑层
 */
public interface IAttentionService {
	/**
	 * 根据用户uid,查询用户关注的所有商品
	 * @param uid
	 * @return	所有商品的VO集合
	 */
	public List<AttentionVO> findAll(int uid);
	/**
	 *根据商品gid添加商品到购物车中
	 * @param gid
	 * @return true or false
	 */
	public boolean addAttention(Attention attention);
	/**
	 * 根据商品关注id删除购物车中的该商品
	 * @param gid
	 * @return true or false
	 */
	public boolean deleteAttention(int id);
	/**
	 * @category 根据商品id删除该商品的所有关注
	 * @param gid
	 * @return true or false
	 */
	public boolean deleteByGid(int gid);
	/**
	 * 根据用户uid删除该用户所有关注信息
	 * @param uid
	 * @return true or false
	 */
	public boolean deleteByUser(int uid);
	
}
