package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.Img;
import com.company.dao.IImgDao;
import com.company.dao.impl.ImgDaoImpl;
import com.company.service.IImgService;

/**
 * @author dl
 * @category 业务逻辑实现类
 *
 */

public class ImgServiceImpl implements IImgService{
	
	IImgDao imgDao = new ImgDaoImpl();
	@Override
	public Img findImg(int id) {
		Img img = null;
		int imgId = Integer.valueOf(id);
		img = imgDao.findImg(imgId);
		return img;
	}
	
	@Test
	public void test(){
		addImg("lll.jpg");
	}
	
	@Override
	public List<Img> findAllImg(int id) {
		return imgDao.findAllImg(id);
	}

	@Override
	public boolean addImg(String src) {
		if(src != null){
			Img img = new Img(src);
			return imgDao.addImg(img)>0?true:false;
		}
		return false;
	}

}
