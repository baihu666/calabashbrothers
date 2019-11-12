
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>购物车展示</title>

<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/pay.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
var sum=0;

function delete_shop(param) {
	
	var del=confirm("delete blog id:"+param+", are you sure?");
	if(del){
		window.location="deleteShopcarBygid.action?gid="+param;
	}
}
function delete_id(param) {
	var del=confirm("确定删除该商品吗");
	if(del){
		window.location="deleteShopcar.action?id="+param;
	}
}
/* function minus(param) {
		window.location="updateShopcar.cation?id="+param;
}
function plus(param) {
	
	    window.location="updateShopcar.cation?id="+param;
} */
function onclick_btnAdd(a,param1,param2) {
	
	var input_ = $(a).prev();
	var input_val = $(a).prev().val();
	var input_add = parseInt(input_val) + 1;
	//input_.val(input_add); 
	
	
	$.getJSON("updateShopcar.action",{ccount:input_add,gid:param1,id:param2},function(data){
		var flag=data.flag;
		if(flag){
			window.location="showshoplist.action";
		}else{
			window.location="404.jsp";
		}
	});
	window.location="showshoplist.action";
}

function onclick_reduce(b,param1,param2) {
	
	var input_ = $(b).next();
	var input_val = $(b).next().val();
	if (input_val <= 1) {
		alert("商品个数不能小于1！")
	} else {
		var input_add = parseInt(input_val) - 1;
		//input_.val(input_add);
		$.getJSON("updateShopcar.action",{ccount:input_add,gid:param1,id:param2},function(data){
			var flag=data.flag;
			confirm("flag");
			if(flag){
				window.location="showshoplist.action";
			}else{
				window.location="404.jsp";
			}
		});
		window.location="showshoplist.action";
	}
}
function boxchange() {
	sum=0;
	var num=0;
	$("input[type='checkbox']").each(function (i, item) {
		if ($(item).is(":checked")) {
			var num1=parseInt($(item).prev().val());
			var sum1=parseInt($(item).val());
			sum+=sum1;
			num+=num1;
		}
		});
	$("#checkedtprice1").text(num+"个");
	$("#checkedtprice2").text(sum);
	
}
function pay() {
	var flag=confirm("确认结账吗");
		if(flag){
			   var idstr = "";
               $("input[type='checkbox']").each(function (i, item) {
				if ($(item).is(":checked")) {
					
					var id=$(item).next().val();
					idstr += id+"/";
				}
				});
              /*  $.getJSON("pay.action",{id:idstr,money:sum},function(data){
            	   window.location="showshoplist.action";
       			}); */
       		   var money=$("#checkedtprice2").text();
       			
               window.location="pay.action?id="+idstr+"&money="+money;
		}	
			
}
var flag=true;
function checkAll() {
	if(flag){
		$(":checkbox").prop("checked",true);
	    var sum=0;
		var num=0;
		$("input[type='checkbox']").each(function (i, item) {
			if ($(item).is(":checked")) {
				var num1=parseInt($(item).prev().val());
				var sum1=parseInt($(item).val());
				sum+=sum1;
				num+=num1;
			}
			});
	
		flag=false;
		$("#checkall").text("全不选");
		$("#checkedtprice1").text(num+"个");
		$("#checkedtprice2").text(sum);
	}else{	
		$(":checkbox").prop("checked",false);
		var sum=0;
		var num=0;
		$("#checkall").text("全选");
		$("#checkedtprice1").text(num+"个");
		$("#checkedtprice2").text(sum);
		flag=true;
	}
	
}
function deleteShopcarByuid() {
	var flag1=confirm("确认清空吗?")
	if(flag1){
		window.location="deleteShopcarByuid.action";
	}
}
</script>
</head>
<body>
	<div class="header-bar">
		<div class="header-inner">
			<ul class="father">
				<li><a>北京</a></li>
				<li>|</li>
				<li class="city"><a>切换城市<span class="arrow-down-logo"></span></a>
					<div class="city-drop-down">
						<h3>热门城市</h3>
						<ul class="son">
							<li><a href="">北京</a></li>
							<li><a href="">上海</a></li>
							<li><a href="">广州</a></li>
							<li><a href="">深圳</a></li>
							<li><a href="">天津</a></li>
							<li><a href="">杭州</a></li>
							<li><a href="">西安</a></li>
							<li><a href="">成都</a></li>
							<li><a href="">郑州</a></li>
							<li><a href="">厦门</a></li>
							<li><a href="">青岛</a></li>
							<li><a href="">太原</a></li>
							<li><a href="">重庆</a></li>
							<li><a href="">武汉</a></li>
							<li><a href="">南京</a></li>
							<li><a href="">沈阳</a></li>
							<li><a href="">济南</a></li>
							<li><a href="">哈尔滨</a></li>
						</ul>
						<a href="" class="morelink ">更多城市 &gt;</a>
					</div></li>
				<li><a href="index.action">返回首页</a></li>
				<li>|</li>
				<li><a href="register.jsp">注册</a></li>
			</ul>
		</div>
	</div>

	<!--支付第一步-->
	<div class="firstly">
		<div class="bindmobile-wrap">
			采用<span style="color: red">微信支付</span>，购买成功后，团购券将发到您的注册邮箱：<span
				class="mobile">tracywxh0830@126.com</span><a class="link"></a>
		</div>

		<table class="table table-goods" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<th width="50"></th>
					<th class="first">商品</th>
					<th width="120">单价</th>
					<th width="190">数量</th>
					<th width="140" class="last">小计</th>
					<th width="50"></th>
				</tr>

				<!--  <td class="vtop">
                        <div class="title-area" title="【好伦哥】精选自助餐1位！免费WiFi！">
                            <div class="img-wrap">
                                <a href="" target="_blank"><img src="image/faf2b2119313b07eadf19d880bd7912396dd8ce6.jpg" width="130" height="79"></a>
                            </div>
                            <div class="title-wrap">
                                <div class="title">
                                    <a href="" class="link">【好伦哥】精选自助餐1位！免费WiFi！</a>
                                </div>
                                <div class="attrs"></div>
                            </div>
                        </div>
                    </td>
                    <td>￥<span class="font14">55.00</span></td>
                    <td class="j-cell">
                        <div class="buycount-ctrl">
                            <a class="j-ctrl ctrl minus disabled"><span class="horizontal"></span></a>
                            <input type="text" value="1" maxlength="10">
                            <a class="ctrl j-ctrl plus"><span class="horizontal"></span><span class="vertical"></span></a>
                        </div>
                        <span class="err-wrap j-err-wrap"></span>
                    </td>
                    <td class="j-cellActivity">-￥<span>1.40</span><br></td>
                    <td class="price font14">¥<span class="j-sumPrice">53.60</span></td> -->

				<c:forEach items="${list }" var="shopcarVo" varStatus="status">
					<c:set var="sum" value="${sum }"></c:set>
					<tr class="j-row">
						<td><input style="display: none;"
							value="${shopcarVo.ccount }"><input onclick="boxchange()"
							type="checkbox" name="${shopcarVo.id }"
							value="${shopcarVo.tprice }"><input
							style="display: none;" value="${shopcarVo.id }"></td>
						<td class="vtop">
							<div class="title-area" title="【好伦哥】精选自助餐1位！免费WiFi！">
								<div class="img-wrap">
									<a href="" target="_blank"><img src="${shopcarVo.img}"
										width="130" height="79"></a>
								</div>
								<div class="title-wrap">
									<div class="title">
										<a href="" class="link">${shopcarVo.desc}</a>
									</div>
									<div class="attrs"></div>
								</div>
							</div>
						</td>
						<td>￥<span class="font14">${shopcarVo.price}</span></td>
						<td class="j-cell">
							<div class="buycount-ctrl">
								<a id="${shopcarVo.gid }" class="j-ctrl ctrl minus disabled"
									onclick="javascript:onclick_reduce(this,${shopcarVo.gid },${shopcarVo.id });"
									style="font-size: 25px">- </a> <input id="" type="text"
									value="${shopcarVo.ccount}" maxlength="10"> <a
									id="${shopcarVo.gid }" class="ctrl j-ctrl plus"
									onclick="javascript:onclick_btnAdd(this,${shopcarVo.gid },${shopcarVo.id });"
									style="font-size: 25px">+</a>
							</div> <span class="err-wrap j-err-wrap"></span>
						</td>
						<td class="price font14">¥<span class="j-sumPrice">${shopcarVo.tprice}</span></td>
						<td class="price font14"><a
							onclick="delete_id(${shopcarVo.id})">移除</a></td>

					</tr>

				</c:forEach>
				<tr>
					<td>总计：</td>
					<td id="checkedtprice1">${sum=0}个</td>

				</tr>
			</tbody>
		</table>



		<div class="final-price-area">
			<a style="text-align: left;" onclick="deleteShopcarByuid()">清空购物车</a>
			<button id="checkall" onclick="checkAll()" style="margin-left: 15px">全选</button>

			<div style="text-align: right;">
				<span>${mes}</span> 应付总额：<span class="sum">￥<span
					id="checkedtprice2" class="price">${sum}</span></span>
			</div>
		</div>

		<div class="page-button-wrap">
			<a onclick="pay()" class="btn btn-primary"
				style="margin-top: 15px">确认</a>

		</div>

		<div style="width: 100%; min-width: 1200px; height: 1px; background: #dbdbdb; margin: 50px 0 20px;"></div>
	</div>

	<!--支付第二步-->
	<!-- <div class="secondly">
		<div class="search">
			<img src="https://passport.baidu.com/export/reg/logo-nuomi.png" />
			<div class="w-order-nav-new">
				<ul class="nav-wrap">
					<li>
						<div class="no">
							<span>1</span>
						</div> <span class="text">确认订单</span>
					</li>
					<li class="to-line "></li>
					<li class="current">
						<div class="no">
							<span>2</span>
						</div> <span class="text">选择支付方式</span>
					</li>
					<li class="to-line "></li>
					<li class="">
						<div class="no">
							<span>3</span>
						</div> <span class="text">购买成功</span>
					</li>
				</ul>
			</div>
		</div>

		<div class="order_infor_module">
			<div class="order_details">
				<table width="100%">
					<tbody>
						<tr>
							<td class="fl_left ">
								<ul class="order-list">
									<li><span class="order-list-no">订单1:</span> <span
										class="order-list-name">好伦哥6店单人自助</span><span
										class="order-list-number">2份</span></li>
								</ul>
							</td>
							<td class="fl_right">
								<dl>
									<dt>应付金额：</dt>
									<dd class="money">
										<span>107.2元</span>
									</dd>
								</dl>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<h1 class="title">选择支付方式</h1>

		<div class="pay">第三方账户支付</div>
		<div class="paychoose">
			<input type="radio" checked />百度钱包 <input type="radio" />支付宝 <input
				type="radio" />支付宝扫码
		</div>

		<div class="pay">银行卡直接支付</div>
		<div class="paychoose">
			<input type="checkbox" />农业银行 <input type="checkbox" />招商银行 <input
				type="checkbox" />工商银行
		</div>
		<button>立即支付</button>

	</div>

	支付第三步
	<div class="third">
		<div class="search">
			<img src="https://passport.baidu.com/export/reg/logo-nuomi.png" />
			<div class="w-order-nav-new">
				<ul class="nav-wrap">
					<li>
						<div class="no">
							<span>1</span>
						</div> <span class="text">确认订单</span>
					</li>
					<li class="to-line "></li>
					<li>
						<div class="no">
							<span>2</span>
						</div> <span class="text">选择支付方式</span>
					</li>
					<li class="to-line "></li>
					<li class="current">
						<div class="no">
							<span>3</span>
						</div> <span class="text">购买成功</span>
					</li>
				</ul>
			</div>
		</div>

		<div
			style="width: 980px; height: 300px; margin: 0 auto; text-align: center; line-height: 300px; font-size: 36px;">恭喜，购买成功！</div>
	</div> -->

	<!-- 底部引入 -->
    <c:import url="footer.jsp"></c:import>

</body>
</html>