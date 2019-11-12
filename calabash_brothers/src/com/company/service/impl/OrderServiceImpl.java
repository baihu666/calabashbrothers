package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Goodsinfo;
import com.company.bean.Order;
import com.company.bean.ReceivingInformation;
import com.company.bean.User;
import com.company.dao.IGoodsinfoDao;
import com.company.dao.IOrderDao;
import com.company.dao.IReceivingInfoDao;
import com.company.dao.IUserDao;
import com.company.dao.impl.GoodsinfoDaoImpl;
import com.company.dao.impl.OrderDaoImpl;
import com.company.dao.impl.ReceivingInfoDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.service.IGoodsinfoService;
import com.company.service.IOrderService;
import com.company.service.IUserService;
import com.company.util.OrderStatusEnum;
import com.company.vo.OrderVO;

public class OrderServiceImpl implements IOrderService {
	@Test
	public void test(){
		System.out.println(findVO(1).size()); 
	}
	private IReceivingInfoDao receivingInfoDao=new ReceivingInfoDaoImpl();
    private IOrderDao orderDao=new OrderDaoImpl();
    IUserDao userDao=new UserDaoImpl();
    IGoodsinfoDao goodsinfoDao=new GoodsinfoDaoImpl();
    IGoodsinfoService goodinfoservice=new GoodsinfoServiceImpl();
    @Override
	public boolean insert(Order order) {
    	IUserService userservice=new UserServiceImpl();
		int uid=order.getUid();//买的人的ID
		int gid=order.getGid();//商品ID
		Goodsinfo goodsinfo= goodsinfoDao.find(gid);//获得商品对象
		boolean temp=false;
		if(userservice.updateMoney(goodsinfo.getUid(), goodsinfo.getPrice(),true)){
			if(userservice.updateMoney(uid, goodsinfo.getPrice(),false)){
				if(userservice.updateIntegral(uid,goodsinfo.getPrice(),true)){
					boolean flag1=goodinfoservice.update(goodsinfo.getId(),""+goodsinfo.getKid(), goodsinfo.getName(), goodsinfo.getDesc(), goodsinfo.getPrice(), goodsinfo.getCount()-1, goodsinfo.getWeight());
					if(flag1){
						temp=orderDao.insert(order)>0?true:false;
					}
				}
			}
		}
		return temp;
		
		
	}
    @Override
	public boolean cancel(int orderNo) {
		return orderDao.cancel(orderNo)>0?true:false;
	}

	@Override
	public boolean update(int id, int status) {
		
		return orderDao.update(id, status)>0?true:false;
	}
    public Order query(int orderNo) {
        Order order = orderDao.selectByOrderNo(orderNo);
        //这里可以写个vo看到更多关于订单的信息
		return order;
    }
    @Override
	public List<Order> find(int uid) {
		return orderDao.find(uid);
		 
	}
    @Override
	public List<OrderVO> findVO(int uid) {
    	List<OrderVO> ListOrderVO=new ArrayList<>();
    	List<Order> list=orderDao.find(uid);
    	for (Order order : list) {
    			User user=userDao.find(order.getUid());//购买的人
    			Goodsinfo goodInfo=goodsinfoDao.find(order.getGid());
    			
    			User user1=userDao.find(goodInfo.getUid());//卖的人
    			ReceivingInformation rinfo=receivingInfoDao.find(order.getRid());
    			OrderVO orderVO=new OrderVO(order.getId(),goodInfo.getName(),goodInfo.getImgSrc(), user.getName(), rinfo.getAddres(), order.getTotalprice(),OrderStatusEnum.codeOf(order.getStatus()).getValue(), user1.getName());
    			ListOrderVO.add(orderVO);
    	}
		return ListOrderVO;
	}
	@Override
	public List<OrderVO> findVO(int uid, int status) {
		List<OrderVO> ListOrderVO=new ArrayList<>();
    	List<Order> list=orderDao.find(uid,status);
    	for (Order order : list) {
    			User user=userDao.find(order.getUid());//购买的人
    			Goodsinfo goodInfo=goodsinfoDao.find(order.getGid());
    			User user1=userDao.find(goodInfo.getUid());//卖的人
    			ReceivingInformation rinfo=receivingInfoDao.find(order.getRid());
    			OrderVO orderVO=new OrderVO(order.getId(),goodInfo.getName()/*,goodInfo.getImg()*/, user.getName(), rinfo.getAddres(), order.getTotalprice(),OrderStatusEnum.codeOf(order.getStatus()).getValue(), user1.getName());
    			ListOrderVO.add(orderVO);
    	}
		return ListOrderVO;
	}
	
}
