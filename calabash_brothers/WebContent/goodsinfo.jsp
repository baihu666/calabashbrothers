<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>商品详情展示页</title>

<link rel="shortcut icon" href="//www.nuomi.com/static/common/img/favicon.ico">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/detail.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/goodsinfo.js"></script>
<script type="text/javascript">
	$(function() {
		var current_user_id = $("#current_user_id").val();
		if (current_user_id == "") {
			return false;
		} else {
			$.post("selectaddress.action", {}, function(result) {
				var html = "<option value='0'>-prov-</option>";
				$.each(result.list, function(i, data) {
					html += "<option value='" + data.id + "'>收货人："
							+ data.rusername + "电话" + data.tel + "地址"
							+ data.area + "-" + data.addres + "</option>"
				});
				$("#address").html(html);
			}, "json");
		}
	});
	function sub() {
		var address = $("#address").val();
		var current_user_id = $("#current_user_id").val();
		if (current_user_id == "") {
			alert("请先进行登录！");
			return false;
		}
		if (address == "0") {
			alert("请选择收货地址");
			return false;
		} else {
			$("#form").submit();
		}
	}
	function att() {
		var current_user_id = $("#current_user_id").val();
		if (current_user_id == "") {
			alert("请先进行登录！");
			return false;
		} else {
			window.location = "attention.action?type=2&&gid=${goodsinfo.id }";
		}
	}
	function addr() {
		var current_user_id = $("#current_user_id").val();
		if (current_user_id == "") {
			alert("请先进行登录！");
			return false;
		} else {
			window.location = "addraddress.action?type=1&&gid=${goodsinfo.id }";
		}
	}
</script>
<style type="text/css">
.d1 {
	width: 980px;
	height: 600px;
	margin: 0 auto;
}
</style>

</head>
<body>
	<div class="header-bar">
		<div class="header-inner">
			<ul class="father">
				<li><a>北京</a></li>
				<li>|</li>
				<li class="city"><a> 切换城市 <span class="arrow-down-logo"></span>
				</a>
					<div class="city-drop-down">
						<h3>热门城市</h3>
						<ul class="son">
							<%-- <c:forEach items="" var="">
                             	<li><a href="">北京</a></li>
                            </c:forEach> --%>
						</ul>
						<a href="" class="morelink ">更多城市 &gt;</a>
					</div></li>
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
					<li><a href="attention.action?type=1">关注</a></li>
					<li>|</li>
					<li><a href="order.action?type=1">订单页面</a></li>
					<li>|</li>
					<li><a href="addgoods.action?type=1">添加商品</a></li>
					<li>|</li>
					<li><a href="logout.action">退出</a></li>
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
				<li class="nav-item"><span class="item">全部分类</span> <span class="arrow-down"></span>
					</li>
				<li class="nav-item"><a href="index.action" class="item first">首页</a></li>
				<li class="nav-item"><a class="item">团购</a></li>
				<li class="nav-item"><a class="item">商户</a></li>
			</ul>
		</div>
	</div>

	<div class="p-detail">
		<div class="p-bread-crumb">
			<div class="w-bread-crumb">
				<ul class="crumb-list">
					<li class="crumb"><a href="goodslist.action">首页</a> <span class="ico-gt">&gt;</span></li>
					<li class="crumb"><a>${goodskind.name }</a></li>
				</ul>
			</div>
		</div>
		<div class="static-hook-real static-hook-id-5"></div>
		<input type="hidden" name="gid" value="${goodsinfo.id }">
		<div class="p-item-info">
			<div class="w-item-info">
				<h2>${goodsinfo.name }</h2>
				<div class="item-title">
					<span class="text-main">${goodsinfo.desc }</span>
				</div>
				<div class="ii-images static-hook-real static-hook-id-6">
					<div class="w-item-images">
						<div class="images-board">
							<div class="item-status ">
								<span class="ico-status ico-

jingxuan"></span>
							</div>
							<img src="${goodsinfo.imgSrc }" class="item-

img-large" />
						</div>
						<%-- <ul class="images-list clearfix">
							<li class="images images-last">
								<img src="${goodsinfo.imgSrc }" />
							</li>
						</ul>  --%>

						<div style="display: inline-block;" class="static-

hook-real static-hook-id-12">
							<button onclick="att()" class="btn-buy btn-

buy-qrnew j-btn-buy btn-hit">添加关注</button>
						</div>
						<div class="erweima-share-collect">
							<ul class="item-option clearfix">
								<li class=" ">

									<div class="collect-success">
										<p>收藏成功！</p>
										<a href="//www.nuomi.com/uc/collection/online">去看看我的收藏</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="ii-intro">
					<div class="w-item-intro">
						<div class="price-area-wrap static-hook-real static-

hook-id-8">
							<div class="price-area has-promotion-icon">
								<div class="pic-price-area">
									<span class="unit">¥</span> <span class="priceNum"> ${goodsinfo.price }</span>
								</div>
								<div class="tip-yellow-icon">
									<span>优惠价</span> <i></i>
								</div>
								<div class="market-price-area">
									<div class="price">${goodsinfo.weight }g</div>
									<div class="name">重量</div>
								</div>
								<div class="current-price-area">
									<div class="price">${goodsinfo.count }</div>
									<div class="name">库存量</div>
								</div>

							</div>
						</div>
						<div class="static-hook-real static-hook-id-9">
							<a class="link jingxuan-box" alt="更多精选品

牌特惠">
								<div class="box">
									<div class="jx-more">更多精选 品牌特惠</div>
									<div class="jx-price">
										<span>￥ ${goodsinfo.price }</span>
									</div>
									<div class="jx-update" id="j-jxUpdateTime">
										<span>距结束</span> <span class="jx-

timerbox"> <span>02</span> : <span>08</span> : <span>46</span>
										</span>
									</div>
								</div>
							</a>
						</div>
						<ul class="ugc-strategy-area static-hook-real 

static-hook-id-10">
							<li class="item-bought">
								<div class="sl-wrap">
									<div class="sl-wrap-cnt">
										<div class="item-

bought-num">
											<span class="intro-strong">23221</span> 人已团购
										</div>
									</div>
								</div>
							</li>
						</ul>
						<div class="buy-panel-wrap">
							<div class="buy-panel">
								<div class="validdate-buycount-area 

static-hook-real static-hook-id-11">
									<div class="item-countdown-

row">
										<span class="name">有 效期</span> <span class="value">2099-01-20</span>
									</div>
									<div class="item-buycount-row 

j-item-buycount-row">
										<div class="name">数 &nbsp;&nbsp;&nbsp;量</div>
										<div class="buycount-ctrl">
											<a href="javascript:;" class="j-ctrl ctrl minus disabled"> <span class="horizontal"></span>
											</a> <input type="text" value="1" maxlength="10" autocomplete="off"> <a href="javascript:;" class="ctrl j-ctrl plus "> <span
												class="horizontal"></span> <span class="vertical"></span>
											</a>
										</div>
										<div class="text-

wrap">
											<span class="left-budget">优惠价剩余20份</span> <span class="err-wrap j-err-wrap"></span>
										</div>
									</div>
								</div>
								<div class="item-buy-area">
									<div style="float: left" class="static-hook-real static-hook-id-12">
										<button class="btn-buy btn-buy-qrnew j-btn-buy btn-hit" onclick="sub()">立即抢购</button>
									</div>
									<div style="float: left; margin-left: 10px" class="static-hook-real static-hook-id-12">
										<a href="addShopcar.action?gid=${goodsinfo.id }&ccount=1" class="btn-buy btn-buy-qrnew j-btn-buy btn-

hit">加入购物车</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 添加地址栏 -->
		<div style="text-align: center;">
			<div style="text-align: center;">
				<form id="form" action="createorder.action" method="post">
					<input type="hidden" name="current_user_id" id="current_user_id" value="${current_user.id }"> <input type="hidden" name="gid"
						value="${goodsinfo.id }"> 选择收货地址： <select class="form-control address" id="address" name="addressId" style="width: 700px; height: 30px">
						<option value='0'>-prov-</option>
					</select>
					

				</form>
				<button style="background-color: #fe8a4b;" onclick="addr()">添加地址</button>
				&nbsp;&nbsp;&nbsp;
			</div>


		</div>



		<div class="p-item-info-more">
			<div class="iim-wrapper">
				<div class="spec-nav ">
					<div class="nav-bar"></div>
					<div class="w-spec-nav" style="position: static; top: auto; z-index: auto;">
						<ul class="sn-list">
							<li class="spec-nav-current"><i></i> <a> <span>本单详情</span>
							</a></li>
							<li class=""><i></i> <a> <span>用户点评</span>
							</a></li>
							<li class=""><i></i> <a> <span>商家介绍</span>
							</a></li>
						</ul>

					</div>
				</div>
				<ul class="j-info-all">
					<li class="tab">
						<div class="ia-shop-branch">
							<div class="w-shop-branch">
								<h3 class="w-section-header">分店信息</h3>
								<div class="branch-content">
									<div class="shop-map">
										<div class="w-map">
											<div class="map-container"
												style="overflow: hidden; position: relative; z-index: 0; color: rgb(0, 0, 0); text-align: left; background-color: rgb(243, 241, 236);">
												<div
													style="overflow: visible; position: absolute; z-index: 0; left: 0px; top: 0px; cursor: url('https://api.map.baidu.com/images/openhand.cur') 8 8, default;">


													<div class="BMap_mask"
														style="position: absolute; left: 0px; top: 0px; z-index: 9; overflow: hidden; -webkit-user- select: none; width: 325px; height: 325px;"></div>


													<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 200;">


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 800;"></div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 700;">


															<span class="BMap_Marker BMap_noprint"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; cursor: pointer; width: 19px; height: 25px; left: 96px; top: 152px; z-index: -7994158; background: url(&amp;quot; https: //api.map.baidu.com/images/blank.gif&amp;quot;);"
																title=""></span> <span class="BMap_Marker BMap_noprint" unselectable="on"
																"="" style="position: absolute; padding: 0px; margin: 0px; border: 0px; cursor: pointer; width: 19px; height: 25px; left: 65px; top: 147px; z-index: -7998040; background: url(&amp;quot;https://api.map.baidu.com/images/blank.gif&amp;quot;);"
																title=""></span> <span class="BMap_Marker BMap_noprint" unselectable="on"
																"="" style="position: absolute; padding: 0px; margin: 0px; border: 0px; cursor: pointer; width: 19px; height: 25px; left: 240px; top: 101px; z-index: -8030418; background: url(&amp;quot;https://api.map.baidu.com/images/blank.gif&amp;quot;);"
																title=""></span> <span class="BMap_Marker BMap_noprint" unselectable="on"
																"="" style="position: absolute; padding: 0px; margin: 0px; border: 0px; cursor: pointer; width: 19px; height: 25px; left: 143px; top: 174px; z-index: -7979020; background: url(&amp;quot;https://api.map.baidu.com/images/blank.gif&amp;quot;);"
																title=""></span>


														</div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 600;"></div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 500;">


															<label class="BMapLabel" unselectable="on"
																style="position: absolute; display: none; cursor: inherit; border: 1px solid rgb(190, 190, 190); padding: 1px; white-space: nowrap; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: arial, sans-serif; z-index: -20000; color: rgb(190, 190, 190); background-color: rgb(190, 190, 190);">shadow</label>


														</div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 400;">


															<span class="BMap_Marker" unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 0px; height: 0px; left: 96px; top: 152px; z-index: -7994158;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 19px; height: 25px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: 0px; margin-top: 0px;">


																</div>


															</span> <span class="BMap_Marker" unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 0px; height: 0px; left: 65px; top: 147px; z-index: -7998040;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 19px; height: 25px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: 0px; margin-top: 0px;">


																</div>


															</span> <span class="BMap_Marker" unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 0px; height: 0px; left: 240px; top: 101px; z-index: -8030418;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 19px; height: 25px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: 0px; margin-top: 0px;">


																</div>


															</span> <span class="BMap_Marker" unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 0px; height: 0px; left: 143px; top: 174px; z-index: -7979020;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 19px; height: 25px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: 0px; margin-top: 0px;">


																</div>


															</span>


														</div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 300;">


															<span unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 20px; height: 11px; left: 100px; top: 166px;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 20px; height: 11px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: -19px; margin-top: -13px;">


																</div>


															</span> <span unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 20px; height: 11px; left: 69px; top: 161px;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 20px; height: 11px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: -19px; margin-top: -13px;">


																</div>


															</span> <span unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 20px; height: 11px; left: 244px; top: 115px;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 20px; height: 11px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: -19px; margin-top: -13px;">


																</div>


															</span> <span unselectable="on"
																style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 20px; height: 11px; left: 147px; top: 188px;">


																<div style="position: absolute; margin: 0px; padding: 0px; width: 20px; height: 11px; overflow: hidden;">


																	<img src="https://api.map.baidu.com/images/marker_red_sprite.png"
																		style="display: block; border: none; margin-left: -19px; margin-top: -13px;">


																</div>


															</span>


														</div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 201;"></div>


														<div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 200;"></div>


													</div>


													<div style="position: absolute; overflow: visible; top: 0px; left: 0px; z-index: 1;">


														<div
															style="position: absolute; overflow: visible; z-index: -100; left: 162px; top: 162px; display: block; transform: translate3d(0px, 0px, 0px);">


															<img
																src="https://ss0.bdstatic.com/8bo_dTSlR1gBo1vgoIiO_jowehsv/tile/?

qt=tile&amp;x=99&amp;y=36&amp;z=9&amp;styles=pl&amp;scaler=1&amp;udt=20160928"
																style="position: absolute; border: none; width: 256px; height: 256px; left: -31px; top: -15px; max-width: none; opacity: 1;"> <img
																src="https://ss0.bdstatic.com/8bo_dTSlQ1gBo1vgoIiO_jowehsv/tile/?

qt=tile&amp;x=98&amp;y=36&amp;z=9&amp;styles=pl&amp;scaler=1&amp;udt=20160928"
																style="position: absolute; border: none; width: 256px; height: 256px; left: -287px; top: -15px; max-width: none; opacity: 1;"> <img
																src="https://ss0.bdstatic.com/8bo_dTSlR1gBo1vgoIiO_jowehsv/tile/?

qt=tile&amp;x=98&amp;y=37&amp;z=9&amp;styles=pl&amp;scaler=1&amp;udt=20160928"
																style="position: absolute; border: none; width: 256px; height: 256px; left: -287px; top: -271px; max-width: none; opacity: 1;">


															<img
																src="https://ss0.bdstatic.com/8bo_dTSlRMgBo1vgoIiO_jowehsv/tile/?

qt=tile&amp;x=99&amp;y=37&amp;z=9&amp;styles=pl&amp;scaler=1&amp;udt=20160928"
																style="position: absolute; border: none; width: 256px; height: 256px; left: -31px; top: -271px; max-width: none; opacity: 1;">


														</div>


													</div>


													<div style="position: absolute; overflow: visible; top: 0px; left: 0px; z-index: 2; display: none;">


														<div style="position: absolute; overflow: visible; top: 0px; left: 0px; z-index: 0; display: none;"></div>


														<div style="position: absolute; overflow: visible; top: 0px; left: 0px; z-index: 10; display: none;"></div>


													</div>


													<div style="position: absolute; overflow: visible; top: 0px; left: 0px; z-index: 3;"></div>


												</div>
												<div class="pano_close" title="退出全景" style="z-index: 1201; display: none;"></div>
												<a class="pano_pc_indoor_exit" title="退出室内景" style="z-index: 1201; display: none;"> <span style="float: right; margin-right: 12px;">出口</span>
												</a>
												<div class=" anchorBL"
													style="height: 32px; position: absolute; z-index: 30; bottom: 0px; right: auto; top: auto; left: 1px; display: none;">


													<a title="到百度地图查看此区域" target="_blank" href="http://map.baidu.com/?sr=1" style="outline: none;"> <img
														style="border: none; width: 77px; height: 32px" src="https://api.map.baidu.com/images/copyright_logo.png">


													</a>


												</div>
												<div id="zoomer"
													style="position: absolute; z-index: 0; top: 0px; left: 0px; overflow: hidden; visibility: hidden; cursor: url(https://api.map.baidu.com/images/openhand.cur) 8 8, default">


													<div class="BMap_zoomer" style="top: 0; left: 0;"></div>


													<div class="BMap_zoomer" style="top: 0; right: 0;"></div>


													<div class="BMap_zoomer" style="bottom: 0; left: 0;"></div>


													<div class="BMap_zoomer" style="bottom: 0; right: 0;"></div>


												</div>
												<div unselectable="on" class=" BMap_cpyCtrl BMap_noprint anchorBL"
													style="cursor: default; white-space: nowrap; color: black; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 11px; line-height: 15px; font-family: arial, sans-serif; bottom: 2px; right: auto; top: auto; left: 4px; position: absolute; z-index: 10; background: none;">


													<span _cid="1" style="display: inline;"> <span style="font-size: 11px"> © 2016 Baidu&nbsp;- Data © <a target="_blank"
															href="http://www.navinfo.com/" style="display: inline;">NavInfo</a> &amp; <a target="_blank" href="http://www.cennavi.com.cn/"
															style="display: inline;">CenNavi</a> &amp; <a target="_blank" href="http://www.365ditu.com/" style="display: inline;">道道通</a>


													</span>


													</span>


												</div>
											</div>
											<a class="map-zoom"> <span>查看完整地图</span>
											</a>
										</div>
									</div>
									<div class="branch-detail">
										<div>
											<div class="w-area-filter">


												<label>筛选：</label> <select name="city" class="af-content">


													<option value="100010000" selected="">北京市</option>


												</select> <select name="district" class="af-content">


													<option selected="">全部城区</option>


													<option value="307">朝阳区</option>


													<option value="392">海淀区</option>


													<option value="395">丰台区</option>


													<option value="408">通州区</option>


													<option value="6547">平谷区</option>


												</select>
											</div>
											<div class="branch-list-content">
												<div class="w-branch-list">


													<ul class="branch-list-content">


														<li class="branch branch-open"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


														<li class="branch branch-close"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


														<li class="branch branch-close"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


														<li class="branch branch-close"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


														<li class="branch branch-close"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


														<li class="branch branch-close"><a href="//www.nuomi.com/shop/133957" target="_blank" class="branch-name">好伦哥(西坝 河店)</a>


															<p class="branch-address">北京市朝阳区西坝河东里83号商业用楼（国际展览中心对面）</p>


															<p class="branch-tel">01064655007</p>


															<p class="map-travel">


																<a href="javascript:;" class="map"> <span class="icon"></span> <span class="text">查询地图</span>


																</a> <a href="javascript:;" class="travel"> <span class="icon"></span> <span class="text">公交/驾车去这里</span>


																</a>


															</p></li>


													</ul>


												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="ifram">本单详情（此处高度随着填充的内容自 动变化）</div>
					</li>
					<li class="tab">
						<div class="ifram">
							<div class="d1">
								<div class="commentboth">

									<!-- 需要循环的评论内容 -->
									<div id="comment" class="comment"></div>
									<!-- 循环结束 -->
									<div class="ifram">
										<div class="d1">
											<div class="commentboth">
												<h5 class="comment_title">商 品 评论</h5>
												<!-- 需要循环的评论内容 -->
												<div id="comment" class="comment"></div>
												<!-- 循环结束 -->
											</div>
											<!-- 评论结束 -->
											<div class="tocomment">
												<input type="hidden" id="gid" value="${goods.id }"> <input type="hidden" id="current_user_id" value="${current_user.id }">
												<c:if test="${current_user.id!=null }">
													<span>发表评论</span>
													<textarea id="comment_content"></textarea>
													<button onclick="comment_submit()" class="btn btn-success">submit</button>
												</c:if>
												<c:if test="${current_user.id==null }">
													<p>
														尚未登录，请 您 <a href="login.jsp">登录</a>
													</p>
												</c:if>
											</div>
											<!-- 尾部引入 -->
											<c:import url="footer.jsp"></c:import>
										</div>
										<!-- 评论结束 -->
										<div class="tocomment">
											<input type="hidden" id="gid" value="${goods.id }"> <input type="hidden" id="current_user_id" value="${current_user.id }">
											<c:if test="${current_user.id!=null 

}">
												<span>发表评论</span>
												<textarea id="comment_content"></textarea>
												<button onclick="comment_submit()" class="btn btn-success">submit</button>
											</c:if>
											<c:if test="${current_user.id==null 

}">
												<p>
													尚未登录，请您<a href="login.jsp">登录</a>
												</p>
											</c:if>
										</div>
										<!-- 尾部引入 -->
										<c:import url="footer.jsp"></c:import>
									</div>
								</div>

							</div>
					</li>
					<li class="tab">
						<div class="ifram">商家介绍（此处高度随着填充的内容自 动变化）</div>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="footer-content">
		<div class="copyright-info">
			<div class="site-info"></div>
			<div class="icons"></div>
			<div style="width: 200px; margin: 0 auto; padding: 20px 0;"></div>
		</div>
	</div>

	<script>
		//校验正整数
		function isNaN(number) {
			var reg = /^[1-9]\d*$/;
			return reg.test(number);
		}

		function inputChange(num) {
			if (!isNaN(num)) {
				$(".buycount-ctrl input").val("1");
			} else {
				$(".buycount-ctrl input").val(num);
				if (num == 1) {
					$(".buycount-ctrl a").eq(0).addClass("disabled");
				} else {
					$(".buycount-ctrl a").eq(0).removeClass("disabled");
				}
			}
		}

		$(".buycount-ctrl input").keyup(function() {
			var num = $(".buycount-ctrl input").val();
			inputChange(num);
		});
		$(".minus").click(function() {
			var num = $(".buycount-ctrl input").val();
			num--;
			inputChange(num);
		});
		$(".plus").click(function() {
			var num = $(".buycount-ctrl input").val();
			num++;
			inputChange(num);
		});

		var time = setInterval("run()", 1000);
		var h = 23;
		var m = 59;
		var s = 59;
		//进行倒计时显示
		function run() {
			s--;
			if (s < 0) {
				m--;
				s = 59;
			}
			if (m < 0) {
				h--;
				m = 59
			}
			if (h < 0) {
				s = 0;
				m = 0;
			}
			$('.jx-timerbox').html(
					"<span>" + h + "</span>:<span>" + m + "</span>:<span>" + s
							+ "</span>");
		}

		$(".sn-list li").click(function() {
			var index = $(".sn-list li").index(this)
			$(".sn-list li").removeClass("spec-nav-current");
			$(".j-info-all .tab").css({
				display : "none"
			});
			$(this).addClass("spec-nav-current");
			$(".j-info-all .tab").eq(index).css({
				display : "block"
			});
		});

		$(".branch").mouseenter(function() {
			$(".branch").removeClass("branch-open").addClass("branch-close");
			$(this).removeClass("branch-close").addClass("branch-open");
		});
	</script>
</body>
</html>