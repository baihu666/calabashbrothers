package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IAreaService;
import com.company.service.ICityService;
import com.company.service.IProvinceService;
import com.company.service.impl.AreaServiceImpl;
import com.company.service.impl.CityServiceImpl;
import com.company.service.impl.ProvinceServiceImpl;

import net.sf.json.JSONObject;

/**
 * @author hzm
 * @category 省市区控制器
 *
 */
@WebServlet("/provcityarea.action")
public class ProvCityAreaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProvCityAreaAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IProvinceService provinceService = new ProvinceServiceImpl();
		ICityService cityService = new CityServiceImpl();
		IAreaService areaService = new AreaServiceImpl();
		// 接收type参数
		String type = request.getParameter("type");
		List list = null;
		if (type.equals("1")) {
			// 省
			list = provinceService.findAll();
		} else if (type.equals("2")) {
			// 市
			String provinceid = request.getParameter("provinceId");
			list = cityService.findCitiesByPid(provinceid);
		} else {
			// 区/县
			String cityID = request.getParameter("cityID");
			list = areaService.findAreasByCid(cityID);
		}
		// 创建JSON对象
		JSONObject json = new JSONObject();
		// 将集合放入json中
		json.put("list", list);
		// 传出json
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
