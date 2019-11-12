<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>首页 主页面</title>

<link rel="shortcut icon" href="">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<!-- 头部引入 -->
	<c:import url="header.jsp"></c:import>
	<c:if test="${current_user!=null }">
	<!-- <a href="attention.action?type=1"><div class="fixed f1">关注关注啦</div></a>
	<a href="order.action?type=1"><div class="fixed f2">连接到订单页面</div></a> -->
	</c:if>
	<c:if test="${current_user==null }">
	<a href="attention.action?type=1"><div class="fixed f1">没有登录哦！</div></a>
	</c:if>
	<!-- 中间部分 -->
	<div class="content-container">
		<div class="no-recom-container">
			<div class="floor-content-start">

				<div class="floor-content">
					<div class="floor-header">
						<!-- 手机模块 -->
						<h3>手机</h3>
						<ul class="reco-words">
							<li><a href="" target="_blank">oppo</a></li>
							<li><a href="" target="_blank">华为</a></li>
							<li><a href="" target="_blank">小米</a></li>
							<li><a href="" target="_blank">其他</a></li>
							<li><a class="no-right-border no-right-padding"
								target="_blank">全部<span class="all-cate-arrow"></span></a></li>
						</ul>
					</div>
					<ul class="itemlist eight-row-height">
						<c:forEach items="${list1 }" var="goods" end="9">
							<a href="goodsinfo.action?id=${goods.id }">
								<li class="j-card">
										<div class="imgbox">
											<ul class="marketing-label-container">
												<li class="marketing-label marketing-free-appoint"></li>
											</ul>
											<div class="range-area">
												<div class="range-bg"></div>
												<div class="range-inner">
													<span class="white-locate"></span> 安贞 六里桥 丽泽桥 安定门 劲松 昌平镇
													航天桥 通州区 通州北苑
												</div>
											</div>
											<div class="borderbox">
												<img src=${goods.imgSrc } />
											</div>
										</div>
									<div class="contentbox">
										<a href="" target="_blank">
											<div class="header">
												<h4 class="title ">${goods.name }</h4>
											</div>
											<p>${goods.desc }</p>
										</a> 
										<div class="add-info"></div>
										<div class="pinfo">
											<span class="price"><span class="moneyico">￥</span>${goods.price }</span>
											<span class="ori-price">价值<span class="price-line">￥<span>56</span></span></span>
										</div>
										<div class="footer">
											<span class="comment">4.6分</span><span class="sold">已售337334</span>
											<div class="bottom-border"></div>
										</div>
									</div></li>
							</a>
						</c:forEach>
					</ul>
					
					<div class="floor-header">
						<!-- 服装模块 -->
						<h3>服装</h3>
						<ul class="reco-words">
							<li><a href="" target="_blank">精选品牌</a></li>
							<li><a href="" target="_blank">外套</a></li>
							<li><a href="" target="_blank">T-shirt</a></li>
							<li><a href="" target="_blank">其他</a></li>
							<li><a class="no-right-border no-right-padding"
								target="_blank">全部<span class="all-cate-arrow"></span></a></li>
						</ul>
					</div>
					<ul class="itemlist eight-row-height">
						<c:forEach items="${list2 }" var="goods" end="9">
							<a href="goodsinfo.action?id=${goods.id }">
								<li class="j-card">
										<div class="imgbox">
											<ul class="marketing-label-container">
												<li class="marketing-label marketing-free-appoint"></li>
											</ul>
											<div class="range-area">
												<div class="range-bg"></div>
												<div class="range-inner">
													<span class="white-locate"></span> 安贞 六里桥 丽泽桥 安定门 劲松 昌平镇
													航天桥 通州区 通州北苑
												</div>
											</div>
											<div class="borderbox">
												<img src=${goods.imgSrc } />
											</div>
										</div>
									<div class="contentbox">
										<a href="" target="_blank">
											<div class="header">
												<h4 class="title ">${goods.name }</h4>
											</div>
											<p>${goods.desc }</p>
										</a> 
										<div class="add-info"></div>
										<div class="pinfo">
											<span class="price"><span class="moneyico">￥</span>${goods.price }</span>
											<span class="ori-price">价值<span class="price-line">￥<span>56</span></span></span>
										</div>
										<div class="footer">
											<span class="comment">4.6分</span><span class="sold">已售337334</span>
											<div class="bottom-border"></div>
										</div>
									</div></li>
							</a>
						</c:forEach>
					</ul>
					
					<div class="floor-header">
						<!-- 娱乐模块 -->
						<h3>休闲娱乐</h3>
						<ul class="reco-words">
							<li><a href="" target="_blank">精选品牌</a></li>
							<li><a href="" target="_blank">三只松鼠</a></li>
							<li><a href="" target="_blank">小时候</a></li>
							<li><a href="" target="_blank">其他</a></li>
							<li><a class="no-right-border no-right-padding"
								target="_blank">全部<span class="all-cate-arrow"></span></a></li>
						</ul>
					</div>
					<ul class="itemlist eight-row-height">
						<c:forEach items="${list3 }" var="goods" end="9">
							<a href="goodsinfo.action?id=${goods.id }">
								<li class="j-card">
										<div class="imgbox">
											<ul class="marketing-label-container">
												<li class="marketing-label marketing-free-appoint"></li>
											</ul>
											<div class="range-area">
												<div class="range-bg"></div>
												<div class="range-inner">
													<span class="white-locate"></span> 安贞 六里桥 丽泽桥 安定门 劲松 昌平镇
													航天桥 通州区 通州北苑
												</div>
											</div>
											<div class="borderbox">
												<img src=${goods.imgSrc } />
											</div>
										</div>
									<div class="contentbox">
										<a href="" target="_blank">
											<div class="header">
												<h4 class="title ">${goods.name }</h4>
											</div>
											<p>${goods.desc }</p>
										</a> 
										<div class="add-info"></div>
										<div class="pinfo">
											<span class="price"><span class="moneyico">￥</span>${goods.price }</span>
											<span class="ori-price">价值<span class="price-line">￥<span>56</span></span></span>
										</div>
										<div class="footer">
											<span class="comment">4.6分</span><span class="sold">已售337334</span>
											<div class="bottom-border"></div>
										</div>
									</div></li>
							</a>
						</c:forEach>
					</ul>
					
					<div class="floor-header">
						<!-- 电脑模块 -->
						<h3>电脑</h3>
						<ul class="reco-words">
							<li><a href="" target="_blank">戴尔</a></li>
							<li><a href="" target="_blank">小米</a></li>
							<li><a href="" target="_blank">华硕</a></li>
							<li><a href="" target="_blank">其他</a></li>
							<li><a class="no-right-border no-right-padding"
								target="_blank">全部<span class="all-cate-arrow"></span></a></li>
						</ul>
					</div>
					<ul class="itemlist eight-row-height">
						<c:forEach items="${list4 }" var="goods" end="9">
							<a href="goodsinfo.action?id=${goods.id }">
								<li class="j-card">
										<div class="imgbox">
											<ul class="marketing-label-container">
												<li class="marketing-label marketing-free-appoint"></li>
											</ul>
											<div class="range-area">
												<div class="range-bg"></div>
												<div class="range-inner">
													<span class="white-locate"></span> 安贞 六里桥 丽泽桥 安定门 劲松 昌平镇
													航天桥 通州区 通州北苑
												</div>
											</div>
											<div class="borderbox">
												<img src=${goods.imgSrc } />
											</div>
										</div>
									<div class="contentbox">
										<a href="" target="_blank">
											<div class="header">
												<h4 class="title ">${goods.name }</h4>
											</div>
											<p>${goods.desc }</p>
										</a> 
										<div class="add-info"></div>
										<div class="pinfo">
											<span class="price"><span class="moneyico">￥</span>${goods.price }</span>
											<span class="ori-price">价值<span class="price-line">￥<span>56</span></span></span>
										</div>
										<div class="footer">
											<span class="comment">4.6分</span><span class="sold">已售337334</span>
											<div class="bottom-border"></div>
										</div>
									</div></li>
							</a>
						</c:forEach>
					</ul>
					
					
				</div>
			</div>
		</div>
	</div>
	</div>

	<div class="footer-content">
		<div class="copyright-info"></div>
	</div>

	<%-- <!-- 底部引入 -->
    <c:import url="footer.jsp"></c:import> --%>

	<script>
		var width = 800 * $("#slide-holder ul li").length;
		$("#slide-holder ul").css({
			width : width + "px"
		});

		//轮播图自动轮播
		var time = setInterval(moveleft, 5000);

		//轮播图左移
		function moveleft() {
			$("#slide-holder ul").animate({
				marginLeft : "-737px"
			}, 600, function() {
				$("#slide-holder ul li").eq(0).appendTo($("#slide-holder ul"));
				$("#slide-holder ul").css("marginLeft", "0px");
			});
		}

		//轮播图右移
		function moveright() {
			$("#slide-holder ul").css({
				marginLeft : "-737px"
			});
			$("#slide-holder ul li").eq(($("#slide-holder ul li").length) - 1)
					.prependTo($("#slide-holder ul"));
			$("#slide-holder ul").animate({
				marginLeft : "0px"
			}, 600);
		}

		//右滑箭头点击事件
		$(".slide-next").click(function() {
			clearInterval(time);
			moveright();
			time = setInterval(moveleft, 5000);
		});

		//左滑箭头点击事件
		$(".slide-prev").click(function() {
			clearInterval(time);
			moveleft();
			time = setInterval(moveleft, 5000);
		});
	</script>
</body>
</html>