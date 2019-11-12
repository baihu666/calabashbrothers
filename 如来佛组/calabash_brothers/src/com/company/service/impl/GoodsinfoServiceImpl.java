package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Goodsinfo;
import com.company.bean.Goodskind;
import com.company.dao.IAttentionDao;
import com.company.dao.ICommentDao;
import com.company.dao.IGoodsinfoDao;
import com.company.dao.IGoodskindDao;
import com.company.dao.IImgDao;
import com.company.dao.IShopcarDao;
import com.company.dao.impl.AttentionDaoImpl;
import com.company.dao.impl.CommentDaoImpl;
import com.company.dao.impl.GoodsinfoDaoImpl;
import com.company.dao.impl.GoodskindDaoImpl;
import com.company.dao.impl.ImgDaoImpl;
import com.company.dao.impl.ShopcarDaoImpl;
import com.company.service.IGoodsinfoService;
import com.company.vo.GoodsinfoVO;

/**
 * @author Vimi
 * @category 商品业务逻辑实现类
 */
public class GoodsinfoServiceImpl implements IGoodsinfoService {
	
	IGoodsinfoDao goodsinfoDao = new GoodsinfoDaoImpl();
	IGoodskindDao goodskindDao = new GoodskindDaoImpl();
	IAttentionDao attentionDao = new AttentionDaoImpl();
	ICommentDao commentDao = new CommentDaoImpl();
	IShopcarDao shopcarDao = new ShopcarDaoImpl();
	IImgDao imgDao = new ImgDaoImpl();
	
	@Test
	public void test(){
		add("1","sh","12","32",2,"454","555",1);
	}
	
	
	/**将list转换为volist
	 * @param volist
	 * @param list
	 */
	public void change(List<GoodsinfoVO> volist,List<Goodsinfo> list){
		for(Goodsinfo goodsinfo:list){
			Goodskind goodskind = goodskindDao.find(goodsinfo.getKid());
			String kname = goodskind.getName();
			GoodsinfoVO vo = new GoodsinfoVO(goodsinfo.getId(),goodsinfo.getKid(),kname,goodsinfo.getName(),goodsinfo.getDesc(),goodsinfo.getPrice(),goodsinfo.getCount(),goodsinfo.getWeight(),goodsinfo.getImgSrc(),goodsinfo.getUid());
			volist.add(vo);
		}
		
	}
	
	

	@Override
	public List<GoodsinfoVO> findList() {
		List<GoodsinfoVO> volist = new ArrayList<GoodsinfoVO>();
		List<Goodsinfo> list = goodsinfoDao.findList();
		change(volist,list);
		
		return volist;
	}
	
	@Override
	public List<GoodsinfoVO> findKindList(int kid) {
		List<GoodsinfoVO> volist = new ArrayList<GoodsinfoVO>();
		List<Goodsinfo> list = goodsinfoDao.findKindList(kid);
		change(volist,list);
		return volist;
	}


	@Override
	public List<GoodsinfoVO> findList(int uid) {
		List<GoodsinfoVO> volist = new ArrayList<GoodsinfoVO>();
		List<Goodsinfo> list = goodsinfoDao.findList(uid);
		change(volist,list);
		return volist;
	}

	@Override
	public Goodsinfo find(int id) {
		return goodsinfoDao.find(id);
	}

	@Override
	public boolean add(String kind,String name,String desc,String price,int count,String weight,String imgSrc,int uid) {
		boolean flag = false;
		if (kind != null && !kind.equals("")) {
			int kid = Integer.valueOf(kind);
			Goodsinfo goodsinfo = new Goodsinfo(kid, name, desc, price, count, weight, imgSrc,uid);
			int i = goodsinfoDao.add(goodsinfo);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}
	
	@Override
	public boolean delete(int id) {
		attentionDao.deleteAttention(id);
		commentDao.deleteBygid(id);
		shopcarDao.deleteByGood(id);
		return goodsinfoDao.delete(id) > 0 ? true : false;
	}

	@Override
	public boolean update(int id,String kind,String name,String desc,String price,int count,String weight) {
		int kid = Integer.valueOf(kind);
		Goodsinfo goodsinfo = goodsinfoDao.find(id);
		goodsinfo.setKid(kid);
		goodsinfo.setName(name);
		goodsinfo.setDesc(desc);
		goodsinfo.setPrice(price);
		goodsinfo.setCount(count);
		goodsinfo.setWeight(weight);
		return goodsinfoDao.update(goodsinfo)>0?true:false;
	}


	@Override
	public boolean update(int id, String imgSrc) {
		Goodsinfo goodsinfo = goodsinfoDao.find(id);
		goodsinfo.setImgSrc(imgSrc);
		return goodsinfoDao.updateImg(id, imgSrc)>0?true:false;
	}

}
