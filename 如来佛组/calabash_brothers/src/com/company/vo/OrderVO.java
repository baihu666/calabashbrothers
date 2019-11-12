package com.company.vo;

/**
 * @author Administrator
 * @category 订单视图类
 */
public class OrderVO {
	
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 商品名称
	 */
	private String gname;
	/**
	 * 商品图片
	 */
	private String gimg;
	
	/**
	 * 购买者姓名
	 */
	private String uname;
	/**
	 * 收货信息
	 */
	private String raddress;
	/**
	 * 商品的总价格
	 */
	private int totalprice;
	/**
	 * 订单状态
	 */
	private String status;
	/**
	 * 商品卖者id
	 */
	private String sellname;
	
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	
	public OrderVO(int id, String gname, String gimg, String uname, String raddress, int totalprice, String status,
			String sellname) {
		super();
		this.id = id;
		this.gname = gname;
		this.gimg = gimg;
		this.uname = uname;
		this.raddress = raddress;
		this.totalprice = totalprice;
		this.status = status;
		this.sellname = sellname;
	}
	public OrderVO(int id, String gname, String uname, String raddress, int totalprice, String status,
			String sellname) {
		super();
		this.id = id;
		this.gname = gname;
		this.uname = uname;
		this.raddress = raddress;
		this.totalprice = totalprice;
		this.status = status;
		this.sellname = sellname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getSellname() {
		return sellname;
	}
	public void setSellname(String sellname) {
		this.sellname = sellname;
	}
	public OrderVO(int id, String uname, String raddress, int totalprice, String status, String sellname) {
		super();
		this.id = id;
		this.uname = uname;
		this.raddress = raddress;
		this.totalprice = totalprice;
		this.status = status;
		this.sellname = sellname;
	}
	public OrderVO(int id, String uname, String raddress, int totalprice, String status) {
		super();
		this.id = id;
		this.uname = uname;
		this.raddress = raddress;
		this.totalprice = totalprice;
		this.status = status;
	}
	public OrderVO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
