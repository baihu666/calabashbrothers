package com.company.service;

import java.util.List;

import com.company.bean.Goodsinfo;
import com.company.vo.GoodsinfoVO;

/**
 * @author Vimi
 * @category 商品业务逻辑接口
 */
public interface IGoodsinfoService {
	
	/**
	 * 查询所有商品列表
	 */
	public List<GoodsinfoVO> findList();
	
	/**
	 * 根据商品id展示某个商品信息
	 */
	public Goodsinfo find(int id);
	
	/**
	 * @param kid
	 * 根据kid展示商品列表
	 */
	public List<GoodsinfoVO> findKindList(int kid);
	
	/**
	 * @param uid
	 * 根据uid展示商品列表
	 */
	public List<GoodsinfoVO> findList(int uid);
	
	/**
	 * @param goodsinfo
	 * 添加商品对象
	 */
	public boolean add(String kind,String name,String desc,String price,int count,String weight,String imgSrc,int uid);
	
	/**
	 * @param id
	 * 根据商品id删除商品
	 */
	public boolean delete(int id);
	
	/**
	 * @param goodsinfo
	 * 根据商品对象修改商品信息
	 */
	public boolean update(int id,String kind,String name,String desc,String price,int count,String weight);
	
	/**
	 * @param id
	 * @param imgSrc
	 * 修改图片
	 */
	public boolean update(int id,String imgSrc);
}
