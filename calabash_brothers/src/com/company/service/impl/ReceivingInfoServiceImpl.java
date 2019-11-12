package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.ReceivingInformation;
import com.company.dao.IReceivingInfoDao;
import com.company.dao.impl.ReceivingInfoDaoImpl;
import com.company.service.IReceivingInfoService;

public class ReceivingInfoServiceImpl implements IReceivingInfoService {
	@Test
	public void test(){
		/*System.out.println(save("熊嘉琪","12345678910","湖北","大悟城关镇",3));*/
		/*ReceivingInformation rinfo=new ReceivingInformation(8,"熊心", "1324453111", "湖北-孝感", "大悟城关镇", 1);
		System.out.println(update(rinfo));*/
		/*System.out.println(delete(10));*/
		/*System.out.println(findAll(2));*/
		/*System.out.println(find(9));*/
		
	}
	IReceivingInfoDao receivingInfoDao=new ReceivingInfoDaoImpl();
	@Override
	public boolean save(String rusername, String tel, String area, String addres, int uid) {
		ReceivingInformation rinfo=new ReceivingInformation(rusername, tel,area,addres, uid);
		return receivingInfoDao.save(rinfo)>0?true:false;
	}
	@Override
	public boolean delete(int id) {
		return receivingInfoDao.delete(id)>0?true:false;
	}
	@Override
	public ReceivingInformation find(int id) {
		return receivingInfoDao.find(id);
	}
	@Override
	public List<ReceivingInformation> findAll(int uid) {
		return receivingInfoDao.findAll(uid);
	}
	@Override
	public boolean update(ReceivingInformation rinfo) {
		return receivingInfoDao.update(rinfo)>0?true:false;
	}
}
