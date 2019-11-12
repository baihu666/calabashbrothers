<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面-人员列表</title>
<meta name="Copyright" content="Douco Design." />
<link href="css/public.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
</head>

<body>
	<div id="dcWrap">
		<div id="dcHead">
			<div id="head">
				<div class="logo">
					<a href="index.html"><img src="images/dclogo.gif" alt="logo"></a>
				</div>
				<div class="nav">
					<ul>
						<li><a href="goodslist.action" target="_blank">查看官网</a></li>
					</ul>
					<ul class="navRight">
						<li class="M noLeft"><a href="JavaScript:void(0);">您好，${current_user.name }</a>
						</li>
						<li class="noRight"><a href="logout.action">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- dcHead 结束 -->
		<div id="dcLeft">
			<div id="menu">

				<ul>
					<li class="cur"><a><i class="product"></i><em>商品列表</em></a></li>
					<li><a><i class="productCat"></i><em>会员列表</em></a></li>
			</div>
		</div>
		<!--内容-->
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">
				DouPHP 管理中心<b>></b><strong>商品列表</strong>
			</div>
			<div class="mainBox"
				style="height: auto !important; height: 550px; min-height: 550px;">
				<h3>
					<a href="addproduct.html?rec=add" class="actionBtn add">添加商品</a>商品列表
				</h3>
				<div class="filter">

					<select id="goodskid" name="cat_id" onchange="">
						<option value="0">商品分类</option>
					</select>

					<form action="product.php" method="post">
						<input name="keyword" type="text" class="inpMain" value=""
							size="20" /> <input name="submit" class="btnGray" type="submit"
							value="筛选" />
					</form>


				</div>
				<div id="list">
					
						<table id="alllist" width="100%" border="0" cellpadding="8"
							cellspacing="0" class="tableBasic">

							<!-- <tr>
									<th width="22" align="center"><input name='chkall' type='checkbox' id='chkall' onclick='selectcheckbox(this.form)' value='check'></th>
									<th width="40" align="center">编号</th>
									<th width="300" align="center">种类</th>
									<th width="80" align="center">商品名称</th>
									<th width="150" align="center">价格/元</th>
									<th width=align="left">简介</th>
									<th width="40" align="center">库存/个</th>
									<th width="80" align="center">操作</th>
								</tr>
								
								<tr>
									<td align="center"><input type="checkbox" name="checkbox[]" value="15" /></td>
									<td align="center">编号</td><td align="center">种类</td>
									<td><a href="product.php?rec=edit&id=15">商品名称</a></td>
									<td align="center"><a href="product.php?cat_id=3">价格</a></td>
									<td align="center">简介</td>
									<td align='center'><a href='product.php?cat_id=3'>库存</a></td>
									<td align="center">
										<a href="product.php?rec=edit&id=15">编辑</a> |
										<a href="product.php?rec=del&id=15">删除</a>
									</td>
								</tr> -->

						</table>

					
				</div>

				<div class="clear"></div>
				<div class="pager">
					总计 15 个记录，共 1 页，当前第 1 页 | <a href="product.php?page=1">第一页</a> 上一页
					下一页 <a href="product.php?page=1">最末页</a>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div id="dcFooter">
			<div id="footer">
				<div class="line"></div>
				<ul>版权所有 © 2013-2015 漳州豆壳网络科技有限公司，并保留所有权利。
				</ul>
			</div>
		</div>
		<!-- dcFooter 结束 -->
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
		//显示商品类别列表
		$(function() {
			$.post("goods.action", {
				type : 1
			}, function(result) {
				console.log("列表" + result);
				var html = "<option value= '0'>-商品类型-</option>";
				$.each(result.klist, function(i, data) {
					html += "<option value="+data.id+"> " + data.name
							+ "</option>"
				});
				$("#goodskid").html(html)
			}, "json")
		})
		//展示排序列表
		$(function() {
			$
					.post(
							"goods.action",
							{type:2},
							function(result) {
								console.log("内容" + result);
								var html = "<tr><th width='22' align='center'><input name='chkall' type='checkbox' id='chkall' "
										+ "onclick='selectcheckbox(this.form)' value='check'></th><th width='40' align='center'>编号"
										+ "</th><th width='80' align='center'>种类</th><th width='200' align='center'>商品名称</th><th width=" +
						"'80' align='center'>价格</th><th align='center'>简介</th><th width='80' align='center'>库存/个</th><th width='80' align='center'>操作</th></tr>";
								$.each(result.list,function(i, data) {
													html += "<tr><td align='center'><input type='checkbox' name='checkbox[]' value='15' /></td><td align='center'>"
															+ data.id
															+ "</td>"
															+ "<td align='center'>"
															+ data.kname
															+ "</td><td><a href='product.php?rec=edit&id=15'>"
															+ data.name
															+ "</a></td>"
															+ "<td align='center'><a href='product.php?cat_id=3'>"
															+ data.price
															+ "</a></td><td align='left'>"
															+ data.desc
															+ "</td><td align='center'><a href='product.php?cat_id=3'>"
															+ data.count
															+ "</a></td>"
															+ "<td align='center'><a href='product.php?rec=edit&id=15'>编辑</a> |<a href='product.php?rec=del&id=15'>删除</a></td></tr>";
												});
								$("#alllist").html(html);
							}, "json")
		})
		onload = function() {
			document.forms['action'].reset();
		}

		function douAction() {
			var frm = document.forms['action'];
			frm.elements['new_cat_id'].style.display = frm.elements['action'].value == 'category_move' ? ''
					: 'none';
		}
	</script>
</body>

</html>