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
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="c1"]', {
			allowFileManager : true
		});
	});

	function check() {
		var name = $("#name").val();
		var desc = $("#desc").val();
		var price = $("#price").val();

		if (name.trim() == "") {
			alert("name must be not null");
			return;
		}
		if (desc.trim() == "") {
			alert("desc must be not null");
			return;
		}
		if (price.trim() == "") {
			alert("price must be not null");
			return;
		}
		if (confirm("save this goods, are you sure?")) {
			$("#form1").submit();
		}
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
					<li>|</li>
					<li><a href="persongoodslist.action?uid=${current_user.id }">个人中心</a></li>
			</ul>
		</div>
	</div>

	<div class="search">
		<img src="image/logo.png" />

	</div>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="create" style="width:800px;float:right;">
			<h1>修改商品</h1>
			<form action="editgoods.action?type=3&id=${goodsinfo.id }" method="post"
				enctype="multipart/form-data">
				<label class="pass-label">商品图片</label>
				<p class="pass-form-item">
					<img alt="图片失效" src="${goodsinfo.imgSrc }"
						style="width: 80px; height: 80px;">
				</p>
				<p>
					<input type="file" name="pic" class="pass-text-input"
						style="width: 70px; height: 20px; border: 0px">
				</p>
				<p>
					<input value="上传图片" type="submit">
				</p>
			</form>
			<form id="form1" action="editgoods.action?type=4&id=${goodsinfo.id }" method="post">
				<input type="hidden" name="type" value="2" />
				<table class="templatemo-container">
					<tr>
						<td>商品名:<input id="name" type="text" class="form-control"
							name="name" value="${goodsinfo.name }" />
						</td>
					</tr>
					<tr>
						<td>商品分类:<br /> <select class="form-control" id="kind"
							name="kind">
								<c:forEach items="${goodskindList }" var="kind">
									<option value="${kind.id }">${kind.name }</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>商品价格:<br /> <input class="form-control" id="price"
								name="price" value="${goodsinfo.price }">
						</td>
					</tr>

					<tr>
						<td>商品数量:<br /> <input class="form-control" id="count"
								name="count" value="${goodsinfo.count }">
						</td>
					</tr>
					<tr>
						<td>商品重量:<br /> <input class="form-control" id="weight"
								name="weight" value="${goodsinfo.weight }">
						</td>
					</tr>
					<tr>
						<td>商品描述:<br /> <input class="form-control" id="desc"
								name="desc" value="${goodsinfo.desc }">
						</td>
					</tr>
					<tr>
						<td align="center"><button type="button" onclick="check()"
								class="btn btn-success">确认修改</button></td>
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