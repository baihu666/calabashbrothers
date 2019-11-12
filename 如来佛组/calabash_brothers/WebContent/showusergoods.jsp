
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>展示个人主页</title>

		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">

		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
		
		<link rel="stylesheet" href="css/login.css" />
		
		<link rel="shortcut icon" href="">
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/html5shiv.js"></script>
		<script type="text/javascript" src="js/respond.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	</head>

	<body>
		<!-- 头部 -->
		<div class="header-bar">
		<div class="header-inner">
			<ul class="father">
				<li>
					<a>北京</a>
				</li>
				<li>|</li>
				<li class="city">
					<a>
						切换城市
						<span class="arrow-down-logo"></span>
					</a>
					<%-- <div class="city-drop-down">
                        <h3>热门城市</h3>
                        <ul class="son">
                        	<c:forEach items="list" var="city">
                            	<li><a href="">${city.province }</a></li>
                            </c:forEach>
                        </ul>
                        
                    </div> --%>
				</li>
				<c:if test="${current_user.id==null }">
					<li>
						<a href="register.jsp">注册</a>
					</li>
					<li>|</li>
					<li>
						<a href="login.jsp">登录</a>
					</li>
					<li>|</li>
				</c:if>
				<c:if test="${current_user.id!=null }">
					<li>
						<a href="index.action">首页</a>
					</li>
					<li>|</li>
					<li>
						<a href="showshoplist.action">购物车</a>
					</li>
					<li>|</li>
					<li>
						<a href="attention.action?type=1">关注</a>
					</li>
					<li>|</li>
					<li>
						<a href="order.action?type=1">订单页面</a>
					</li>
					<li>|</li>
					<li>
						<a href="addgoods.action?type=1">添加商品</a>
					</li>
					<li>|</li>
					<li>
						<a href="logout.action">退出</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	
		<!-- 头部结束 -->
		 <div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<table>
						<tr>
							<td><h5>商品图片</h5></td>
							<td><h5>商品名字</h5></td>
							<td><h5>商品描述</h5></td>
						</tr>
						<c:forEach items="${list}" var="goods">
							<!-- <a href="goodslist.action"> -->
							<tr>
								
									<td style="valign: middle; height: 100px;"><img src="${goods.imgSrc }" style="height: 100px; width: 90px;"></img></td>
									<td style="width: 250px; text-align: center; valign: middle;">${goods.name }</td>
									<td>${goods.desc }</td> 
									<td><a href="editgoods.action?type=2&id=${goods.id} ">编辑</a></td>
									<td><a href="editgoods.action?type=1&id=${goods.id }">删除</a></td>
							</tr>
							<!-- </a> -->
						</c:forEach>
					</table>
				</div>
				<!-- 底部 -->
				<c:import url="footer.jsp"></c:import>
				<!-- 底部结束 -->
			</div> 

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="index.html">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人信息</a>
						<ul>
							<li> <a href="updateUserInfo.jsp">个人资料</a></li>
							<li> <a href="updateUserInfo.jsp">信息更改</a></li>
							<li> <a href="safety.html">信息更改</a></li>
							<li> <a href="safety.html">信息更改</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
							<li><a href="order.action?type=1">订单管理</a></li>
							<li> <a href="attention.action?type=1">我的关注</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的商品</a>
						<ul>
							<li> <a href="persongoodslist.action?uid=${current_user.id }">我的商品 </a></li>
							<li> <a href="addgoods.action?type=1">添加商品</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="#">我的小窝</a>
						<ul>
							<li> <a href="collection.html">收藏</a></li>
							<li> <a href="foot.html">足迹</a></li>
							<li> <a href="comment.html">评价</a></li>
							<li> <a href="news.html">消息</a></li>
						</ul>
					</li>

				</ul>

			</aside>
		</div>

	</body>

</html>