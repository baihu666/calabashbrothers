package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Img;
import com.company.dao.IImgDao;

/**
 * @author dl
 * @category 数据访问实现类
 *
 */
public class ImgDaoImpl extends BaseDao implements IImgDao {

	@Test
	public void test() {
		System.out.println(findAllImg(2).size());
	}

	@Override
	public Img findImg(int id) {
		Img img = null;
		try {
			super.regist();
			super.connection();
			String sql = "select `src` from img where id = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			super.rs = pstmt.executeQuery();
			while (rs.next()) {
				img = new Img(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return img;
	}

	@Override
	public List<Img> findAllImg(int id) {
		List<Img> list = new ArrayList<>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from img where id = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			super.rs = pstmt.executeQuery();
			while (rs.next()) {
				Img img = new Img(rs.getString(1));
				list.add(img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}

		return list;
	}

	@Override
	public int addImg(Img img) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "insert into img (src) values (?)";
			super.getPst(sql);
			pstmt.setString(1, img.getSrc());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return i;
	}

}
