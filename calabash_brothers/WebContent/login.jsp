<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>登录</title>

<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<link rel="shortcut icon" href="">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
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
						<a href="updateUserInfo.jsp">我的主页</a>
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

	<div class="wrapper">
		<div class="head">
			<ul>
				<li>
					<a href="index.html">
						<img src="image/logo.png" alt="logo">
					</a>
				</li>
				<li class="divider"></li>
				<li>登录</li>
			</ul>
			<div class="login-link">
				<span>还没o2o团购网帐号</span>
				<a href="register.jsp">注册</a>
			</div>
		</div>

		<div class="content">
			<div class="wrap">
				<div class="login-logo"></div>
				<div class="login-area">
					<div class="title">登录</div>
					<div class="login">
						<form action="login.action">
							<div class="ordinaryLogin">

								<p class="pass-form-item">
									<label class="pass-label">用户名</label>
									<input type="text" name="userName" id="userName" class="pass-text-input" placeholder="用户名">
								</p>
								<p class="pass-form-item">
									<label class="pass-label">密码</label>
									<input type="password" name="password" id="password" class="pass-text-input" placeholder="密码">
								</p>

							</div>

							<div class="commonLogin">
								<p class="pass-form-item">
									<button type="submit" value="登录" class="pass-button" name="denglu" onclick="denglu()">登录
								</p>
								<el style="color:red">${mess }</el>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="footer">
			<ul class="first">

			</ul>
			<ul class="second">


			</ul>
		</div>
	</div>

	<%-- <!-- 底部引入 -->
    <c:import url="footer.jsp"></c:import> --%>

	<script>
		$(".pass-sms-btn").click(function() {
			$(".ordinaryLogin").css({
				display : "none"
			});
			$(".messageLogin,.question").css({
				display : "block"
			});
		});
		$(".pass-sms-link").click(function() {
			$(".messageLogin,.question").css({
				display : "none"
			});
			$(".ordinaryLogin").css({
				display : "block"
			});
		});
	</script>
</body>
</html>