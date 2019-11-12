package com.company.service.impl;

import java.util.List;

import org.junit.Test;

import com.company.bean.User;
import com.company.dao.IAttentionDao;
import com.company.dao.ICommentDao;
import com.company.dao.IRecordingDao;
import com.company.dao.IShopcarDao;
import com.company.dao.IUserDao;
import com.company.dao.impl.AttentionDaoImpl;
import com.company.dao.impl.CommentDaoImpl;
import com.company.dao.impl.RecordingDaoImpl;
import com.company.dao.impl.ShopcarDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.service.IUserService;

/**
 * @author rjw
 * @category 企业内购用户逻辑实现类
 *
 */
public class UserServiceImpl implements IUserService {
	// 创建dao层对象
	IUserDao userDao = new UserDaoImpl();

	// @Test
	// public void test(){
	// User user = new User(4,"Alan","111","男",21,"西安碑林体育场路","18300112299");
	// System.out.println(update(user));
	// }
	@Test
	public void test() {
		System.out.println(findByName("al1an"));
//		System.out.println(find("2").getIntegral());
	}

	@Override
	public User find(String name, String pass) {
		User user = null;
		if ((name != null && !name.equals("")) || (pass != null && !pass.equals(""))) {
			user = userDao.find(name, pass);
		}
		return user;
	}

	@Override
	public boolean add(User user) {
		if (user != null) {
			return userDao.add(user) > 0 ? true : false;
		}
		return false;

	}

	@Override
	public boolean update(User user) {
		System.out.println(user.getName());
		return userDao.update(user) > 0 ? true : false;
	}

	@Override
	public User find(String id) {
		User user = null;
		if (id != null && !id.equals("")) {
			int id_int = Integer.valueOf(id);
			user = userDao.find(id_int);
		}
		return user;
	}

	@Override
	public List<User> findList() {
		return userDao.findList();
	}

	@Override
	public boolean delete(int id) {
		IRecordingDao recordingDao = new RecordingDaoImpl();
		IShopcarDao shopcarDao = new ShopcarDaoImpl();
		IAttentionDao attentionDao = new AttentionDaoImpl();
		ICommentDao commentDao = new CommentDaoImpl();
		if (id != 1) {
			recordingDao.delete(id);
			shopcarDao.deleteByUser(id);
			attentionDao.deleteByUser(id);
			commentDao.deleteByUserId(id);
			return userDao.delete(id) > 0 ? true : false;
		}
		return false;
	}

	@Override
	public boolean updateMoney(int id, String money, boolean flag) {
		int num = 0;
		int money_int = Integer.valueOf(money);
		int moeyNow = userDao.find(id).getMoney();// 用户充值/提现前的余额
		if (flag) {// 充值
			int money1 = moeyNow + money_int;
			num = userDao.updateMoney(id, money1);
		} else {// 提现
			if (moeyNow >= money_int) {// 判断提现金额是否在余额范围内
				int money2 = moeyNow - money_int;
				num = userDao.updateMoney(id, money2);
			} else {
				return false;
			}
		}
		return num > 0 ? true : false;
	}

	@Override
	public boolean updateIntegral(int id, String integral, boolean flag) {
		int num = 0;
		int integral_int = Integer.valueOf(integral);
		int integralNow = userDao.find(id).getIntegral();// 用户充值/提现前的余额
		if (flag) {// 充值
			int integral1 = integralNow + integral_int;
			num = userDao.updateIntegral(id, integral1);
		} else {// 提现
			if (integralNow >= integral_int) {// 判断提现金额是否在余额范围内
				int integral2 = integralNow - integral_int;
				num = userDao.updateIntegral(id, integral2);
			} else {
				return false;
			}
		}
		return num > 0 ? true : false;
	}

	@Override
	public boolean updateHeadimg(int id, String headimg) {
		return userDao.updateHeadimg(id, headimg)>0?true:false;
	}

	@Override
	public boolean findByName(String name) {
		User user = null;
		if (name!=null&&!name.equals("")) {
			user = userDao.findByName(name);
			if (user!=null) {
				return true;
			}
		}
		return false;
	}

}
