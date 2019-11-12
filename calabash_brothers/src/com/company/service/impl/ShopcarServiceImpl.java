package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Goodsinfo;

import com.company.bean.Shopcar;
import com.company.dao.IGoodsinfoDao;
import com.company.dao.IImgDao;
import com.company.dao.IShopcarDao;
import com.company.dao.impl.GoodsinfoDaoImpl;
import com.company.dao.impl.ImgDaoImpl;
import com.company.dao.impl.ShopcarDaoImpl;
import com.company.service.IShopcarService;
import com.company.vo.ShopcarVO;
/**
 * @author xll
 * @category 购物车
 */
public class ShopcarServiceImpl implements IShopcarService {
    IShopcarDao shopDao=new ShopcarDaoImpl();
    IGoodsinfoDao goodinfoDao=new GoodsinfoDaoImpl();
    IImgDao imgDao=new ImgDaoImpl();
    @Test
    public void test(){
    	List<Shopcar> list=shopDao.findAll(1);
    	List<ShopcarVO> volist=new ArrayList<ShopcarVO>();
    	change(volist, list);
    	for (ShopcarVO shopcarVO : volist) {
    		System.out.println(shopcarVO.getImg());
		}
    }
    
   
	@Override
	public List<ShopcarVO> findAll(int uid) {
		List<Shopcar> shoplist=shopDao.findAll(uid);
		List<ShopcarVO> shopVOlList=new ArrayList<ShopcarVO>();
		change(shopVOlList, shoplist);
		return shopVOlList;
	}

	@Override
	public boolean add(int gid,int uid,int ccount) {
		boolean flag=false;
		Shopcar shopcar=new Shopcar(gid, uid, ccount);
		if(shopcar!=null){
			if(ccount!=0){
				int i=shopDao.add(shopcar);
				if(i>0){
					flag=true;
				}
			}
			
		}
		return flag;
		
	}

	@Override
	public Shopcar find(int id) {
		
		return shopDao.find(id);
	}

	@Override
	public boolean delate(int id) {
		
		return shopDao.delete(id)>0?true:false;
	}

	@Override
	public boolean update(int id ,int gid,int uid,int ccount) {
		Shopcar shopcar=new Shopcar(id ,gid, uid, ccount);
		return shopDao.update(shopcar)>0?true:false;
	}
	
	public void change(List<ShopcarVO> voList, List<Shopcar> shopList) {
		for (Shopcar shopcar : shopList) {
			//根据gid找到该商品对象
			Goodsinfo goodsinfo= goodinfoDao.find(shopcar.getGid());
			
			//选购商品的数量
			int ccount=shopcar.getCcount();
			//选购商品的单价
			String price=goodsinfo.getPrice();
			String desc=goodsinfo.getDesc();
			//选购商品的总价
			int tprice=(Integer.valueOf(price)*ccount);
			//创建对象
			ShopcarVO shopcarVO=new ShopcarVO(shopcar.getId(), shopcar.getGid(), shopcar.getUid(), ccount, goodsinfo.getImgSrc(), price,tprice,desc);
			voList.add(shopcarVO);
		}

	}

	@Override
	public boolean deleteByUser(int uid) {
		return shopDao.deleteByUser(uid)>0?true:false;
	}

	@Override
	public boolean deleteByGood(int gid) {
		return shopDao.deleteByGood(gid)>0?true:false;
	}
}
