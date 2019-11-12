<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">


<title>评论页面</title>
	
		<!-- 引入 Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
		<script src="js/jquery.js"></script>
		<!-- 包括所有已编译的插件 -->
		<script src="js/bootstrap.min.js"></script>
		<link href="css/style.css" rel="stylesheet" />
		<style type="text/css">
		.d1{
		width:980px;
		height:600px;
		margin:0 auto;
		}
		</style>
		
</head>
<body>
	<div class="d1">
	<div class="d2 allwidth"> 
			<table class="table table-hover" >
				<tr>
					<th>作者</th>
					<th>评论内容</th>
					<th>发表时间</th>
					<th>浏览量</th>
				</tr>
				 <c:forEach  items="${list }" var="list"> 
					<tr>
						<%-- <td>
							<a href="">${comm. }</a>
						</td> --%>
						<td>
							<a href="">${list.content }</a>
						</td>
						<td>
							<a href="">${list.datetime }</a>
						</td>
						<%-- <td>
							<a href="">${comm }</a>
						</td> --%>
						
					</tr>
				 </c:forEach>
			</table>
	</div>		
			<!-- 尾部引入 -->
			<c:import url="footer.jsp"></c:import>
	</div>
</body>
</html>