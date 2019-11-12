package com.company.dao;

import java.util.List;

import com.company.bean.Goodsinfo;

/**
 * @author Vimi
 * @category 商品详情数据访问层
 */
public interface IGoodsinfoDao {
	
	/**
	 * 查询所有商品列表
	 */
	public List<Goodsinfo> findList();
	
	/**
	 * @param kid
	 * 根据kid查询商品列表
	 */
	public List<Goodsinfo> findKindList(int kid);
	
	/**
	 * @param uid
	 * 根据uid查询商品列表
	 */
	public List<Goodsinfo> findList(int uid);
	
	/**
	 * 根据商品id展示某个商品信息
	 */
	public Goodsinfo find(int id);
	
	/**
	 * @param goodsinfo
	 * 添加商品对象
	 */
	public int add(Goodsinfo goodsinfo);
	
	/**
	 * @param id
	 * 根据商品id删除商品
	 */
	public int delete(int id);
	
	/**
	 * @param goodsinfo
	 * 根据商品对象修改商品信息
	 */
	public int update(Goodsinfo goodsinfo);
	
	/**
	 * @param id
	 * @param imgSrc
	 * 根据商品id修改商品图片
	 */
	public int updateImg(int id,String imgSrc);
}
