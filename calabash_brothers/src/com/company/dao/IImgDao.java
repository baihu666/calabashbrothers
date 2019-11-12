package com.company.dao;

import java.util.List;

import com.company.bean.Img;

/**
 * @author dl
 * @category 图片数据访问接口
 *
 */
public interface IImgDao {
	/**
	 * @param id
	 * @return 根据id查找对应图片
	 */
	public Img findImg(int id);
	
	/**
	 * @return
	 * @category 根据id查找照片集
	 */
	public List<Img> findAllImg(int id);
	
	/**
	 * @param img
	 * 添加图片
	 */
	public int addImg(Img img);
}
