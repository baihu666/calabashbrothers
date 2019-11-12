<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    
    <title>分类展示商品页</title>
    
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/list.css" />
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head> 
<body>
    <div class="header-bar">
        <div class="header-inner">
            <ul class="father">
                <li><a>北京</a></li>
                <li>|</li>
                <li class="city">
                    <a>切换城市<span class="arrow-down-logo"></span></a>
                    <div class="city-drop-down">
                        <h3>热门城市</h3>
                        <ul class="son">
                            <li><a href="">北京</a></li>
                            
                        </ul>
                        <a href="" class="morelink ">更多城市 &gt;</a>
                    </div>
                </li>
                <c:if test="${current_user.id==null }">
                	<li><a href="register.jsp">注册</a></li>
                	<li>|</li>
                	<li><a href="login.jsp">登录</a></li>
                </c:if>
                	<li><a href="index.action">首页</a></li>
            </ul>
        </div>
    </div>

    <div class="search">
        <img src="image/logo.png" />
    </div>

    <div class="nav-bar-header">
        <div class="nav-inner">
            <ul class="nav-list">
                <li class="nav-item">
                    <span class="item">全部分类</span>
                    <div class="left-menu">
                        <div class="level-item">
                            <div class="first-level">
                                <dl>
                                    <dt class="title"><a href="" target="_top">美食</a></dt>
                                    <dd><a href="" target="_top" class="">精选品牌</a></dd>
                                    <dd><a href="" target="_top" class="">小吃快餐</a></dd>
                                </dl>
                            </div>
                            <div class="second-level">
                                <div class="section">
                                    <div class="section-item clearfix no-top-border">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a class="hot">精选品牌</a></li>
                                           
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="level-item">
                            <div class="first-level">
                                <dl>
                                    <dt class="title"><a href="" target="_top">电影</a></dt>
                                    <dd><a href="" target="_top" class="">订座</a></dd>
                                    <dd><a href="" target="_top" class="">电影票团购</a></dd>
                                </dl>
                            </div>
                            <div class="second-level">
                                <div class="section">
                                    <div class="section-item clearfix no-top-border">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                           
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="level-item">
                            <div class="first-level">
                                <dl>
                                    <dt class="title"><a href="" target="_top">休闲娱乐</a></dt>
                                    <dd><a href="" target="_top" class="">ktv</a></dd>
                                    <dd><a href="" target="_top" class="">温泉洗浴</a></dd>
                                </dl>
                            </div>
                            <div class="second-level">
                                <div class="section">
                                    <div class="section-item clearfix no-top-border">
                                        <ul>
                                            <li><a class="hot">精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="level-item">
                            <div class="first-level">
                                <dl>
                                    <dt class="title"><a href="" target="_top">电影</a></dt>
                                    <dd><a href="" target="_top" class="">订座</a></dd>
                                    <dd><a href="" target="_top" class="">电影票团购</a></dd>
                                </dl>
                            </div>
                            <div class="second-level">
                                <div class="section">
                                    <div class="section-item clearfix no-top-border">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="level-item">
                            <div class="first-level">
                                <dl>
                                    <dt class="title"><a href="" target="_top">电影</a></dt>
                                    <dd><a href="" target="_top" class="">订座</a></dd>
                                    <dd><a href="" target="_top" class="">电影票团购</a></dd>
                                </dl>
                            </div>
                            <div class="second-level">
                                <div class="section">
                                    <div class="section-item clearfix no-top-border">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                            
                                        </ul>
                                    </div>
                                    <div class="section-item clearfix">
                                        <h3>热门分类</h3>
                                        <ul>
                                            <li><a>精选品牌</a></li>
                                           
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="nav-item"><a class="item first active">首页</a></li>
                <li class="nav-item"><a class="item">团购</a></li>
                <li class="nav-item"><a class="item">商户</a></li>
            </ul>
        </div>
    </div>

    <div class="page-body">
        <div class="filter-bg">
            <div class="filter-wrap">
                <div class="w-filter-ab-test">
                   
                </div>
                <br>
                <table>
						<tr style="margin-bottom: 20px;">
							<td><h5>商品图片</h5></td>
							<td><h5>商品名字</h5></td>
							<td><h5>商品描述</h5></td>
						</tr>
						<c:forEach items="${list}" var="goods">
							<tr>
								<td>
									<a href="goodsinfo.action?id=${goods.id }">
										<img src="${goods.imgSrc }" style="height: 150px;"></img>
									</a>
								</td>
								<td style="width: 250px; text-align: center;">${goods.name }</td>
								<td>${goods.desc }</td> 
							</tr>
						</c:forEach>
					</table>
            </div>
        </div>
        <div class="content-wrap">共<span style="color: #ff4883">4321</span>条</div>
    </div>

    <div class="footer-content">
        <div class="copyright-info">
            
        </div>
    </div>
    <script>
        $(".tab-item-wrap").click(function(){
            var index = $(".tab-item-wrap").index(this);
            $(".tab-item-wrap").removeClass("selected");
            $(".district-cont-wrap").css({display: "none"});
            $(this).addClass("selected");
            $(".district-cont-wrap").eq(index).css({display: "block"});
        });

        $(".sort-area a").click(function(){
            $(".sort-area a").removeClass("sort-default-active").css({color: "#666"});
            $(this).addClass("sort-default-active").css({color: "#ff4883"});
        });
    </script>
</body>
</html>