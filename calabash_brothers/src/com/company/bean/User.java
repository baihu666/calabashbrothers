package com.company.bean;

/**
 * @author hzm
 * @category 用户
 *
 */
public class User {

	private int id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pass;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 电话号码
	 */
	private String tel;
	/**
	 * 用户余额
	 */
	private int money;    
	/**
	 * 用户积分
	 */
	private int integral;
	/**
	 * 头像的映射地址
	 */
	private String headimg;
	
	/**
	 * IP地址
	 */
	private String ip;
	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public User() {
		super();
	}
	

	public User(String name, String pass, String sex, int age, String tel, String ip) {
		super();
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.ip = ip;
	}


	public User(int id, String name, String pass, String sex, int age, String addr, String tel, int money, int integral,
			String headimg) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
		this.money = money;
		this.integral = integral;
		this.headimg = headimg;
	}



	public User(int id, String name, String pass, String sex, int age, String addr, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

}
