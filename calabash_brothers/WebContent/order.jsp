<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单管理</title>

<link href="css/admin.css" rel="stylesheet" type="text/css">
<link href="css/amazeui.css" rel="stylesheet" type="text/css">

<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/orstyle.css" rel="stylesheet" type="text/css">

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.js"></script>
<script src="js/order.js" type="text/javascript"></script>

</head>

<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<c:if test="${current_user.id==null }">
								</c:if>
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="index.action" target="_top" class="h">商城首页</a>
							</div>
						</div>
						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>
						<div class="topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="showshoplist.action" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h">0</strong></a>
							</div>
						</div>
						<div class="topMessage favorite">
							<div class="menu-hd">
								<a href="#" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
							</div>
							<div class="menu-hd">
								<a href="logout.action" target="_top"><i
									class="am-icon-heart am-icon-fw"></i><span>退出</span></a>
							</div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="image/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text"
								placeholder="搜索" autocomplete="off"> <input
								id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
								type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="index.action">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i
					class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-order">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
						</div>
					</div>
					<hr />

					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">所有订单</a></li>
							<!-- <li><a onclick="serch1()">待付款</a></li> -->
							<!-- <li><a href="order.action?type=2&&type=20"><span>待发货</span></a></li>
							<li><a onclick="serch1()">待收货</a></li>
							<li><a onclick="serch2()">待评价</a></li> -->
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">-</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">-</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">-</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>
								<c:forEach items="${listVO }" var="mylistvo">
									<div class="order-main">
										<div class="order-list">

											<!--交易成功-->
											<div class="order-status5">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<a href="javascript:;">${mylistvo.id }</a>
													</div>
													<!--    <em>店铺：小桔灯</em>-->
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <img
																		src="${mylistvo.gimg }"
																		class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p>${mylistvo.gname }</p>
																		</a>
																	</div>
																</div>
															</li>
														</ul>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																<span>合计：</span>${mylistvo.totalprice }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																	<p class="Mystatus">${mylistvo.status }</p>
																	<p class="order-info">
																		<a href="orderinfo.html">订单详情</a>
																	</p>
																	<p class="order-info">
																		<a href="logistics.html">查看物流</a>
																	</p>
																</div>
															</li>
															<c:if test="${mylistvo.status=='已付款' }">
																<li class="td td-change"><a
																	href="order.action?type=30&&oid=${mylistvo.id }"><div
																			class="am-btn am-btn-danger anniu">催发货</div></a></li>


															</c:if>
															<c:if test="${mylistvo.status=='已发货' }">
																<li class="td td-change"><a
																	href="order.action?type=40&&oid=${mylistvo.id }"><div
																			class="am-btn am-btn-danger anniu">确认收货</div></a> <!-- <div onclick="c2(${mylistvo.id })" class="am-btn am-btn-danger anniu">确认收货</div> -->

																</li>
															</c:if>
															<c:if test="${mylistvo.status=='收货成功' }">
																<li class="td td-change"><a
																	href="order.action?type=50&&oid=${mylistvo.id }"><div
																			class="am-btn am-btn-danger anniu">关闭订单</div></a></li>
															</c:if>
															<c:if test="${mylistvo.status=='交易关闭' }">
																<li class="td td-change"><a
																	href="deleteorder.action?oid=${mylistvo.id }"><div
																			class="am-btn am-btn-danger anniu">删除订单</div></a></li>
															</c:if>

														</div>
													</div>
												</div>
											</div>



										</div>

									</div>
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="#">恒望科技</a> <b>|</b> <a href="index.action">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
							href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
							href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
							- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
							target="_blank">网页模板</a></em>
					</p>
				</div>

			</div>
		</div>
		<aside class="menu">
			<ul>
				<li class="person active"><a href="index.html"><i
						class="am-icon-user"></i>个人中心</a></li>
				<li class="person">
					<p>
						<i class="am-icon-newspaper-o"></i>个人资料
					</p>
					<ul>
						<li><a href="information.html">个人信息</a></li>
						<li><a href="safety.html">安全设置</a></li>
						<li><a href="address.html">地址管理</a></li>
						<li><a href="cardlist.html">快捷支付</a></li>
					</ul>
				</li>
				<li class="person">
					<p>
						<i class="am-icon-balance-scale"></i>我的交易
					</p>
					<ul>
						<li><a href="attention.action?type=1">我的关注</a></li>
						<li><a href="change.html">退款售后</a></li>
						<li><a href="comment.html">评价商品</a></li>
					</ul>
				</li>
				<li class="person">
					<p>
						<i class="am-icon-dollar"></i>我的资产
					</p>
					<ul>
						<li><a href="points.html">我的积分</a></li>
						<li><a href="coupon.html">优惠券 </a></li>
						<li><a href="bonus.html">红包</a></li>
						<li><a href="walletlist.html">账户余额</a></li>
						<li><a href="bill.html">账单明细</a></li>
					</ul>
				</li>

				<li class="person">
					<p>
						<i class="am-icon-tags"></i>我的收藏
					</p>
					<ul>
						<li><a href="collection.html">收藏</a></li>
						<li><a href="foot.html">足迹</a></li>
					</ul>
				</li>

				<li class="person">
					<p>
						<i class="am-icon-qq"></i>在线客服
					</p>
					<ul>
						<li><a href="consultation.html">商品咨询</a></li>
						<li><a href="suggest.html">意见反馈</a></li>

						<li><a href="news.html">我的消息</a></li>
					</ul>
				</li>
			</ul>

		</aside>
	</div>

</body>

</html>