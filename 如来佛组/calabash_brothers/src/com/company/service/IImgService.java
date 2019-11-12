package com.company.service;

import java.util.List;

import com.company.bean.Img;
/**
 * @author dl
 * @category 图片业务逻辑接口
 *
 */
public interface IImgService {
	
	
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
	 * @param src
	 * 添加图片
	 */
	public boolean addImg(String src);
		
}
