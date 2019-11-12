<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>头部</title>

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
						<a href="persongoodslist.action?uid=${current_user.id }">个人中心</a>
					</li>
					<li>|</li>
					<li>
						<a href="logout.action">退出</a>
					</li>
					<li>|</li>
					<li>|</li>
					<li>
						<a href="showshoplist.action">购物车</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>

	<div class="search">
		<img src="image/logo.png" />

	</div>

	<div class="nav-bar-header">
		<div class="nav-inner">
			<ul class="nav-list">
				<li class="nav-item">
					<span class="item">全部分类</span>
					<div class="left-menu">
						<div class="level-item">
							<div class="first-level">
								<dl>
									<dt class="title">
										<a href="goodslist.action?kid=1" target="_top">手机</a>
									</dt>
									<dd>
										<a href="" target="_top" class="">苹果</a>
									</dd>
									<dd>
										<a href="" target="_top" class="">OPPO</a>
									</dd>
								</dl>
							</div>
							
						</div>
						<div class="level-item">
							<div class="first-level">
								<dl>
									<dt class="title">
										<a href="goodslist.action?kid=2" target="_top">服装</a>
									</dt>
									<dd>
										<a href="" target="_top" class="">T-shirt</a>
									</dd>
									<dd>
										<a href="" target="_top" class="">外套</a>
									</dd>
								</dl>
							</div>
							
						</div>
						<div class="level-item">
							<div class="first-level">
								<dl>
									<dt class="title">
										<a href="goodslist.action?kid=3" target="_top">休闲娱乐</a>
									</dt>
									<dd>
										<a href="" target="_top" class="">三只松鼠</a>
									</dd>
									<dd>
										<a href="" target="_top" class="">小时候</a>
									</dd>
								</dl>
							</div>
							
						</div>

						<div class="level-item">
							<div class="first-level">
								<dl>
									<dt class="title">
										<a href="goodslist.action?kid=4" target="_top">电脑</a>
									</dt>
									<dd>
										<a href="" target="_top" class="">笔记本</a>
									</dd>
									<dd>
										<a href="" target="_top" class="">游戏本</a>
									</dd>
								</dl>
							</div>
							
						</div>

						<div class="level-item">
							<div class="first-level">
								<dl>
									<dt class="title">
										<a href="" target="_top">美妆</a>
									</dt>
									<dd>
										<a href="" target="_top" class="">口红</a>
									</dd>
									<dd>
										<a href="" target="_top" class="">套妆</a>
									</dd>
								</dl>
							</div>
							
						</div>
					</div>
				</li>
				<li class="nav-item">
					<a class="item first active">首页</a>
				</li>
				<li class="nav-item">
					<a class="item">团购</a>
				</li>
				<li class="nav-item">
					<a class="item">商户</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="top-container">
			<div class="mid-area">
				<div class="slide-holder" id="slide-holder">
					<a href="#" class="slide-prev">
						<i class="slide-arrow-left"></i>
					</a>
					<a href="#" class="slide-next">
						<i class="slide-arrow-right"></i>
					</a>
					<ul class="slideshow">
						<li>
							<a href="" class="item-large">
								<img class="ad-pic" src="image/a1ec08fa513d2697b85e74c35dfbb2fb4216d89b.jpg" />
							</a>
						</li>
						<li>
							<a href="" class="item-large">
								<img class="ad-pic" src="image/63d0f703918fa0ec7c51e2912e9759ee3c6ddb9c.jpg" />
							</a>
						</li>
					</ul>
				</div>
				<div class="list-container"></div>
			</div>
		</div>
		<div class="right-sidebar">
			<div class="right-ad">
				<ul class="slidepic">
					<li>
						<a>
							<img src="image/72f082025aafa40f9205eb43a364034f79f01968.jpg" />
						</a>
					</li>
				</ul>
			</div>

		</div>
</body>
</html>