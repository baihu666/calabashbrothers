<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<link rel="stylesheet" href="css/css.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/new_file.js">
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>商城网上商城</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var region = $("#region");
		var address = $("#address");
		var number_this = $("#number_this");
		var name = $("#name_");
		var phone = $("#phone");
		$("#sub_setID").click(function() {
			var input_out = $(".input_style");
			for (var i = 0; i <= input_out.length; i++) {
				if ($(input_out[i]).val() == "") {
					$(input_out[i]).css("border", "1px solid red");

					return false;
				} else {
					$(input_out[i]).css("border", "1px solid #cccccc");
				}
			}
		});
		var span_momey = $(".span_momey");
		var b = 0;
		for (var i = 0; i < span_momey.length; i++) {
			b += parseFloat($(span_momey[i]).html());
		}
		var out_momey = $(".out_momey");
		out_momey.html(b);
		$(".shade_content").hide();
		$(".shade").hide();
		$('.nav_mini ul li').hover(function() {
			$(this).find('.two_nav').show(100);
		}, function() {
			$(this).find('.two_nav').hide(100);
		})
		$('.left_nav').hover(function() {
			$(this).find('.nav_mini').show(100);
		}, function() {
			$(this).find('.nav_mini').hide(100);
		})
		$('#jia').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
		})
		$('#jian').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
		})
		$('.Caddress .add_mi').click(
				function() {
					$(this).css('background',
							'url("images/mail_1.jpg") no-repeat').siblings(
							'.add_mi').css('background',
							'url("images/mail.jpg") no-repeat')
				})
	})
	var x = Array();

	function func(a, b) {
		x[b] = a.html();
		alert(x)
		a.css('border', '2px solid #f00').siblings('.min_mx').css('border',
				'2px solid #ccc');
	}

	function onclick_close() {
		var shade_content = $(".shade_content");
		var shade = $(".shade");
		if (confirm("确认关闭么！此操作不可恢复")) {
			shade_content.hide();
			shade.hide();
		}
	}

	function onclick_open() {
		$(".shade_content").show();
		$(".shade").show();
		var input_out = $(".input_style");
		for (var i = 0; i <= input_out.length; i++) {
			if ($(input_out[i]).val() != "") {
				$(input_out[i]).val("");
			}
		}
	}

	function onclick_remove(r) {
		if (confirm("确认删除么！此操作不可恢复")) {
			var out_momey = $(".out_momey");
			var input_val = $(r).parent().prev().children().eq(1).val();
			var span_html = $(r).parent().prev().prev().children().html();
			var out_add = parseFloat(input_val).toFixed(2)
					* parseFloat(span_html).toFixed(2);
			var reduce = parseFloat(out_momey.html()).toFixed(2)
					- parseFloat(out_add).toFixed(2);
			console.log(parseFloat(reduce).toFixed(2));
			out_momey.text(parseFloat(reduce).toFixed(2))
			$(r).parent().parent().remove();
		}
	}

	function onclick_btnAdd(a) {
		var out_momey = $(".out_momey");
		var input_ = $(a).prev();
		var input_val = $(a).prev().val();
		var input_add = parseInt(input_val) + 1;
		input_.val(input_add);
		var btn_momey = parseFloat($(a).parent().prev().children().html());
		var out_momey_float = parseFloat(out_momey.html()) + btn_momey;
		out_momey.text(out_momey_float.toFixed(2));
	}

	function onclick_reduce(b) {
		var out_momey = $(".out_momey");
		var input_ = $(b).next();
		var input_val = $(b).next().val();
		if (input_val <= 1) {
			alert("商品个数不能小于1！")
		} else {
			var input_add = parseInt(input_val) - 1;
			input_.val(input_add);
			var btn_momey = parseFloat($(b).parent().prev().children().html());
			var out_momey_float = parseFloat(out_momey.html()) - btn_momey;
			out_momey.text(out_momey_float.toFixed(2));
		}
	}
</script>
</head>

<body>
	<div id="top">
		<div id="top_main">
			<ul class="topu">
				<li>
					<div class="xing"></div> <a href="#">收藏商城</a>
				</li>
			</ul>
			<div id="hello">
				<span>您好，欢迎来到商城！ <a href="login.html">[登陆]</a><a
					href="login.html">[免费注册]</a>
				</span>
			</div>
			<div class="topright">
				<ul>
					<li>
						<div class="cun">
							<a href="#">我的订单</a>
						</div>
					</li>
					<li class="kefu">
						<div class="cun">
							<div class="a1">
								<div class="kefuhide">
									<span>客户服务</span>
									<div class="downjian1"></div>
									<ul>
										<li><a href="#">帮助中心</a></li>
										<li><a href="#">售后服务</a></li>
										<li><a href="#">在线客服</a></li>
										<li><a href="#">投诉中心</a></li>
										<li><a href="#">客服邮箱</a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
					<li class="wangzhan">
						<div class="cun">
							<span>网站导航</span>
							<div class="downjian1"></div>
						</div>
						<div class="wangzhanhide">
							<div class="tese">
								<span>特色栏目</span>
							</div>
							<div class="tesemain">
								<a href="#">商城通信</a> <a href="#">校园之星</a> <a href="#">视频购物</a> <a
									href="#">商城社区</a> <a href="#">在线读书</a> <a href="#">装机大师</a> <a
									href="#">商城E卡 </a> <a href="#">家装城</a> <a href="#">搭配购 </a> <a
									href="#">我喜欢 </a> <a href="#">游戏社区</a>
							</div>
							<div class="tese">
								<span>企业服务</span>
							</div>
							<div class="tesemain1">
								<a href="#">企业采购</a> <a href="#">办公直通车</a>
							</div>
							<div class="tese">
								<span>旗下网站</span>
							</div>
							<div class="tesemain2">
								<a href="#">English Site</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 搜索区域开始 -->
	<div id="serach">
		<div class="logo">
			<a href="index.html"> <img src="images/logo.png" alt="" /></a>
			<div class="dongtu"></div>
		</div>
		<div class="sou">
			<div class="sousuo">
				<input type="text" class="kuang" value="跨界"
					style="color: #999; font-size: 14px" />
				<div class="souzi">
					<a href="#">搜索</a>
				</div>
			</div>
			<div class="reci">
				<span>热门搜索:</span> <a href="#" style="color: red">校园之星</a> <a
					href="#">影院到家</a> <a href="#">JD制暖节</a> <a href="#">腕表领券</a> <a
					href="#">自营满减</a> <a href="#">N3抢购</a> <a href="#">图书换购</a> <a
					href="#">12.12</a>
			</div>
		</div>
		<div class="myjd">
			<div class="mytu"></div>
			<a href="#">我的商城</a>
			<div class="jiantou"></div>
			<div class="myjdhide">
				<div class="hello">
					<span>您好，请</span> <a href="#">登录</a>
				</div>
				<div class="hey">
					<div class="heyleft">
						<ul>
							<li><a href="#">待处理订单</a></li>
							<li><a href="#">咨询回复</a></li>
							<li><a href="#">降价商品</a></li>
							<li><a href="#">返修退换货</a></li>
							<li><a href="#">优惠券</a></li>
						</ul>
					</div>
					<div class="heyright">
						<ul>
							<li><a href="#">我的关注></a></li>
							<li><a href="#">我的京豆></a></li>
							<li><a href="#">我的理财></a></li>
							<li><a href="#">我的白条></a></li>
						</ul>
					</div>
				</div>
				<div class="hidebot">
					<div class="bottop">
						<span>最近浏览的商品:</span> <a href="#">查看浏览历史></a>
					</div>
					<div class="botdown">
						<span>「暂无数据」</span>
					</div>
				</div>
			</div>
		</div>
		<div class="gouwuche">
			<div class="chetu"></div>
			<a href="#">去购物车结算</a>
			<div class="jianleft"></div>
			<div class="num">
				<div class="numright"></div>
				<div class="numzi">
					<span>0</span>
				</div>
			</div>
			<div class="hideche">
				<div class="kongche"></div>
				<span>购物车中还没有商品，赶紧选购吧！</span>
			</div>
		</div>
		<div class="jubao"></div>
	</div>
	<div class="Caddress">
		<div class="open_new">
			<button class="open_btn" onclick="javascript:onclick_open();">使用新地址</button>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
		<div class="add_mi">
			<p style="border-bottom: 1px dashed #ccc; line-height: 28px;">浙江杭州(爸爸收)</p>
			<p>萧山 北干 明怡花苑53幢3单元 13735683918</p>
		</div>
	</div>

	<!--
        	作者：z@163.com
        	时间：2016-03-04
        	描述：商品内容
        -->
	<div class="shopping_content">
		<div class="shopping_table">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;">
				<tr>
					<th>商品图片</th>
					<th>商品名称</th>
					<th>商品属性</th>
					<th>商品价格</th>
					<th>商品数量</th>
					<th>商品操作</th>
				</tr>
				<c:forEach items="${list }" var="shopcarVo">
					<tr>
						<td><a><img src="images/2f1.jpg" /></a></td>
						<td><span>小消息下</span></td>
						<td>
							<div class="">
								<span id="">颜色</span>：<span>白色</span>
							</div>
							<div class="">
								<span id="">尺码</span>：<span>L</span>
							</div>
						</td>
						<td><span class="span_momey">11.10</span></td>
						<td>
							<button class="btn_reduce"
								onclick="javascript:onclick_reduce(this);">-</button> <input
							class="momey_input" type="" name="" id="" value="1"
							disabled="disabled" />
							<button class="btn_add"
								onclick="javascript:onclick_btnAdd(this);">+</button>
						</td>
						<td>
							<button class="btn_r" onclick="javascript:onclick_remove(this);">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class=""
				style="width: 100%; text-align: right; margin-top: 10px;">
				<div class="div_outMumey" style="float: left;">
					总价：<span class="out_momey">11</span>
				</div>
				<button class="btn_closing">结算</button>
			</div>
		</div>
	</div>

	<!--
        	作者：z@163.com
        	时间：2016-03-01
        	描述：shade 遮罩层
        -->
	<div class="shade"></div>
	<!--
        	作者：z@163.com
        	时间：2016-03-02
        	描述：shade_content
        -->
	<div class="shade_content">
		<div class="col-xs-12 shade_colse">
			<button onclick="javascript:onclick_close();">x</button>
		</div>
		<div class="nav shade_content_div">
			<div class="col-xs-12 shade_title">新增收货地址</div>
			<div class="col-xs-12 shade_from">
				<form action="" method="post">
					<div class="col-xs-12">
						<span class="span_style" id="">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区</span>
						<input class="input_style" type="" name="" id="region" value=""
							placeholder="&nbsp;&nbsp;请输入您的所在地区" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">详细地址</span> <input
							class="input_style" type="" name="" id="address" value=""
							placeholder="&nbsp;&nbsp;请输入您的详细地址" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">邮政编号</span> <input
							class="input_style" type="" name="" id="number_this" value=""
							placeholder="&nbsp;&nbsp;请输入您的邮政编号" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" class="span_sty" id="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
						<input class="input_style" type="" name="" id="name_" value=""
							placeholder="&nbsp;&nbsp;请输入您的姓名" />
					</div>
					<div class="col-xs-12">
						<span class="span_style" id="">手机号码</span> <input
							class="input_style" type="" name="" id="phone" value=""
							placeholder="&nbsp;&nbsp;请输入您的手机号码" />
					</div>
					<div class="col-xs-12">
						<input class="btn_remove" type="button" id=""
							onclick="javascript:onclick_close();" value="取消" /> <input
							type="submit" class="sub_set" id="sub_setID" value="提交" />
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 底部引入 -->
    <c:import url="footer.jsp"></c:import>
</body>

</html>