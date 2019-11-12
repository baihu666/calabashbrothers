<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title></title>
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<script charset="utf-8" src="kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<link href="css/style.css" rel="stylesheet" />
<script src="js/regist.js"></script>
<script>
	function check() {
		var name = $("#name").val();
		var tel = $("#tel").val();
		var area = $("#area").val();
		var area1 = $("#area1").val();
		if (name == "please input your name") {
			alert("用户名字不能为空");
			return false;
		}
		if (tel == "") {
			alert("电话不能为空");
			return false;
		}
		if (area == "") {
			alert("不能为空");
			return false;
		}
		if (area1 == "") {
			alert("不能为空");
			return false;
		}
		document.getElementsByTagName("form").item(0).submit();

	}
	
</script>

<link href="css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>

<body>
	<!-- 头部  -->
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
				</c:if>
			</ul>
		</div>
	</div>

	<div class="search">
		<img src="image/logo.png" />

	</div>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="widthtwo regist">
			<h1>收&nbsp;货&nbsp;地&nbsp;址</h1>
			<form id="form1" action="addraddress.action" method="post">
				<input type="hidden" name="gid" value="${gid }">
				<input type="hidden" name="id" value="${current_user.id }">
				<input type="hidden" name="type" value="2">
				<table class="t1">
					<tr>
						<td>收货人姓名:<input id="name" onblur="nameBlur()" type="text"
							class="form-control" name="name" placeholder="收货人姓名" /> <span
							id="name_exit" style="color: red;"></span>
						</td>
					</tr>
					<tr>
						<td>收货人电话:<input id="tel" type="text" class="form-control"
							name="tel" /></td>
					</tr>
					<tr>
						<td>收货地区:<input id="area" type="text" class="form-control"
							name="area" /></td>
					</tr>
					<tr>
						<td>收货地址:<input id="area1" type="text" class="form-control"
							name="area1" /></td>
					</tr>

					<tr class="button1">
						<td align="center">
							<button type="button" onclick="check()" class="btn btn-success">submit</button>
							<button type="reset" class="btn btn-info">reset</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>



	<!--内容部分结束-->

	<!-- 脚部 -->
	<c:import url="footer.jsp"></c:import>
	<!-- 脚部结束 -->
</body>

</html>