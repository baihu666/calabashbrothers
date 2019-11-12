package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.City;
import com.company.dao.ICityDao;

/**
 * @author hzm
 * @category 城市数据访问实现类
 *
 */
public class CityDaoImpl extends BaseDao implements ICityDao{
	@Test
	public void test(){
		System.out.println(findCitiesByPid("130000").size());
	}
	public List<City> findCitiesByPid(String provinceId) {
		List<City> list = new ArrayList<City>();
		try {
			connection();
			String sql = "select * from city where provinceId = ?";
			getPst(sql);
			pstmt.setString(1, provinceId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt(1));
				city.setCityID(rs.getString(2));
				city.setCity(rs.getString(3));
				city.setProvinceID(rs.getString(4));
				list.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.close();
		}
		return list;
	}

	public City findObject(String cityId) {
		City city = null;
		try {
			connection();
			String sql = "select * from city where cityID = ?";
			getPst(sql);
			pstmt.setString(1, cityId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				city = new City(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.close();
		}
		return city;
	}
	
}
