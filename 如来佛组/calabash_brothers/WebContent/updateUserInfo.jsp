
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

<style>
.pass-form-item img {
	border-radius: 30px;
}
</style>
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
			<form action="updateuser.action?type=1" method="post"
				enctype="multipart/form-data">
				<label class="pass-label">个人头像</label>
				<p class="pass-form-item">
					<img alt="图片失效" src="${current_user.headimg }"
						style="width: 80px; height: 80px;">
				</p>
				<p>
					<input type="file" name="pic" class="pass-text-input"
						style="width: 70px; height: 20px; border: 0px">
				</p>
				<p>
					<input value="上传头像" type="submit">
				</p>
			</form>
			<form action="updateuser.action?type=2" method="post">
				<p class="pass-form-item">
					<label class="pass-label">用户名</label> <input type="text"
						name="userName" class="pass-text-input"
						value="${current_user.name }">
				</p>
				<p class="pass-form-item">
					<label class="pass-label">地址</label> <select
						class="form-control address" id="provincedId" name="province"
						onchange="showCity(this.value)"><option value='0'>-prov-</option></select>
					<select class="form-control address" id="cityId" name="city"
						onchange="showArea(this.value)"><option value='0'>-city-</option></select>
					<select class="form-control address" id="areaId" name="area"><option
							value='0'>-area-</option></select> <input type="text" name="jiedao"
						class="pass-text-input" placeholder="请输入详细街道地址">
				</p>
				<p class="pass-form-item">
					<label class="pass-label">密码</label> <input type="password"
						name="password" class="pass-text-input"
						value="${current_user.pass }">
				</p>
				<p class="pass-form-item">
					<label class="pass-label">年龄</label> <input type="number"
						name="age" class="pass-text-input" value="${current_user.age }">
				</p>
				<input type="hidden" name="sex" value="${current_user.sex }">
				<!--  
                <p class="pass-form-item">
                    <label class="pass-label">验证码</label>
                    <input type="text" name="verifyCode" class="pass-text-input " placeholder="请输入验证码">
                </p>
                -->
				<p class="pass-form-item">
					<label class="pass-label">联系方式</label> <input type="text"
						name="tel" class="pass-text-input" value="${current_user.tel }">
				</p>
				<p class="pass-form-item">
					<button type="submit" value="注册" class="pass-button">保存</button>
				</p>
			</form>

		</div>

		<div class="foot">
			<div>
				<div>2016&nbsp;©Baidu</div>
			</div>
		</div>
	</div>
	<!-- 底部引入 -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>