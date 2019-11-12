package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Goodskind;
import com.company.dao.IGoodskindDao;

/**
 * @author hzm
 * @category 商品种类的数据访问实现类
 *
 */
public class GoodskindDaoImpl extends BaseDao implements IGoodskindDao {


	
	@Test
	public void test(){
		System.out.println(findAll().size());
	}
	
	
	public List<Goodskind> findAll() {
		List<Goodskind> list = new ArrayList<Goodskind>();
		try {
			regist();
			connection();
			String sql = "select * from goodskind";
			super.getPst(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Goodskind goodskind = new Goodskind(rs.getInt(1), rs.getString(2));
				list.add(goodskind);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	public Goodskind find(int id) {
		Goodskind goodskind = null;
		try {
			regist();
			super.connection();
			String sql = "select *from Goodskind where id = ?";
			super.getPst(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				goodskind = new Goodskind(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.close();
		}
		return goodskind;
	}

}
