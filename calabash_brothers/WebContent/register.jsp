
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>注册</title>
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/register.css" />
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
<script src="js/a.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div class="header-bar">
		<div class="header-inner">
			<ul class="father">
				<li><a>北京</a></li>
				<li>|</li>
				<li class="city"><a>切换城市<span class="arrow-down-logo"></span></a>
					<%-- <div class="city-drop-down">
                        <h3>热门城市</h3>
                        <ul class="son">
                        	<c:forEach items="list" var="city">
                            	<li><a href="">${city.province }</a></li>
                            </c:forEach>
                        </ul>
                        
                    </div> --%></li>
				<c:if test="${current_user.id==null }">
					<li><a href="register.jsp">注册</a></li>
					<li>|</li>
					<li><a href="login.jsp">登录</a></li>
					<li>|</li>
				</c:if>
				<c:if test="${current_user.id!=null }">
					<li><a href="updateUserInfo.jsp">我的主页</a></li>
					<li>|</li>
					<li><a href="showshoplist.action">购物车</a></li>
					<li>|</li>
					<li><a href="logout.action">退出</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- 头部结束 -->
	<div class="wrapper">
		<div class="head">
			<ul>
				<li><a href="index.html"><img src="image/logo.png"
						alt="logo"></a></li>
				<li class="divider"></li>
				<li><a href="index.html"></a></li>
			</ul>
			<div class="login-link">
				<c:if test="${current_user.id==null }">
					<span>我已注册，现在就</span>
					<a href="login.jsp">登录</a>
				</c:if>
			</div>
		</div>

		<div class="content">
			<form action="register.action" method="post" id="form1">
				<p class="pass-form-item">
					<label class="pass-label">用户名</label> <input type="text"
						name="userName" id="name" class="pass-text-input"
						placeholder="请设置用户名" onblur="nameBlur(this.value)"> <span
						id="n" style="color: red"></span>
				</p>
				<p class="pass-form-item">
					<label class="pass-label">性别</label><br> <input type="radio"
						name="sex" value="男" style="font-size: 14px">男&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="女" style="font-size: 14px">女
				</p>

				<p class="pass-form-item">
					<label class="pass-label">密码</label> <input type="password"
						name="password" id="pass1" class="pass-text-input"
						placeholder="请设置登录密码">
				</p>
				<p class="pass-form-item">
					<label class="pass-label">确认密码</label> <input type="password"
						name="password2" id="pass2" class="pass-text-input"
						placeholder="请设置登录密码">
				</p>
				<p class="pass-form-item">
					<label class="pass-label">年龄</label> <input type="number"
						name="age" id="age" class="pass-text-input" placeholder="请输入您的年龄">
				</p>


				<p class="pass-form-item">
					<label class="pass-label">联系方式</label> <input type="text"
						name="tel" class="pass-text-input" placeholder="请输入手机号">
				</p>
				<p class="pass-form-item">
					<button type="button" onclick="check()" value="注册"
						class="pass-button">注册</button>
				</p>
			</form>

		</div>

		<!-- <div class="foot">
            <div>
                <div>2016&nbsp;©Baidu</div>
            </div>
        </div> -->
	</div>
	<!-- 底部引入 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>