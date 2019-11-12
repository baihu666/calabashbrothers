package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Attention;
import com.company.bean.Goodsinfo;
import com.company.dao.IAttentionDao;
import com.company.dao.IGoodsinfoDao;
import com.company.dao.impl.AttentionDaoImpl;
import com.company.dao.impl.GoodsinfoDaoImpl;
import com.company.service.IAttentionService;
import com.company.service.ICommentService;
import com.company.vo.AttentionVO;

public class AttentionServiceImpl implements IAttentionService {
	@Test
	public void test(){
	/*	Attention attention=new Attention(2,1);
		addAttention(attention);*/
		System.out.println(findAll(1).size());
		/*System.out.println(deleteAttention(1));*/
	}

	IAttentionDao attentionDao =new AttentionDaoImpl();
	@Override
	public List<AttentionVO> findAll(int uid) {
		 List<Attention> list=attentionDao.findAll(uid);
		 List<AttentionVO> attentionVOList=new ArrayList<>();
		 for (Attention attention : list) {
			 //创建商品的dao层对象
			 IGoodsinfoDao goodsinfoDao=new GoodsinfoDaoImpl();
			 //创建评论业务逻辑层对象
			 ICommentService commentService=new CommentServiceImpl();
			 //根据关注里的gid查找商品
			 Goodsinfo goodsInfo= goodsinfoDao.find(attention.getGid());
			 //根据商品id查找评论的总数量
			 int commentNum=commentService.findCommentSumNum(goodsInfo.getId());
			 //创建VO视图对象
			 AttentionVO attentionVO=new AttentionVO(attention.getId(), goodsInfo.getId(), goodsInfo.getName(), goodsInfo.getDesc(), goodsInfo.getPrice(), goodsInfo.getCount(), goodsInfo.getImgSrc(), commentNum);
			 //将关注的VO对象添加在集合中
			 attentionVOList.add(attentionVO);
		 }
		return attentionVOList;
	}

	@Override
	public boolean addAttention(Attention attention) {
		return attentionDao.addAttention(attention)>0?true:false;
	}

	@Override
	public boolean deleteAttention(int id) {
		return attentionDao.deleteAttention(id)>0?true:false;
	}

	@Override
	public boolean deleteByGid(int gid) {
		return attentionDao.deleteByGid(gid)>0?true:false;
	}

	@Override
	public boolean deleteByUser(int uid) {
		return attentionDao.deleteByUser(uid)>0?true:false;
	}
}
