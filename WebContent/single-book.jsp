<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>

<script language="javascript">
function goUrl(){
window.location.href=document.referrer;
}
</script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bookshop</title>

    <!-- Bootstrap -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/animate.min.css" rel="stylesheet">
    <link href="assets/css/main.min.css" rel="stylesheet">

    <!-- Favicon -->
    <link rel="shortcut icon" href="/assets/images/favicon.ico">

    <link href='http://fonts.googleapis.com/css?family=PT+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Fira+Sans:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
 


    <div id="wrapper" >
        <div id="page-content-wrapper" class="st-pusher">
            <div class="st-pusher-after"></div>
            <!-- ============================================== HEADER ============================================== -->
	
	<header class="header">

		<nav class="navbar navbar-bookshop navbar-static-top" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-md-5 hidden-xs hidden-sm">
                <ul class="nav navbar-nav">
                    <li><a href="indexList">网上书店</a></li>
                    <li><a href="demo.html">关于我们</a></li>
                    <li><a href="#">运送方式</a></li>
                    <li><a href="FAQs.html">常见问题</a></li>
                </ul><!-- /.nav -->
            </div><!-- /.col -->
            <div class="col-md-3 col-xs-10 col-sm-10 navbar-left">

                <p class='text-center'><a href="#"><span class="icon glyphicon glyphicon-earphone"></span>8888-8888</a></p>

            </div><!-- /.col -->
            <div class="col-md-4 col-sm-2">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden-xs hidden-sm"><a href="center">个人中心</a></li>
                   
                    <li class="hidden-xs hidden-sm" ><a href="#">${sessionScope.username}</a></li>
                    <c:if test="${sessionScope.username==null||sessionScope.username==''}">
                    	<li class="icon icon-small hidden-xs"><a data-toggle="modal" data-target="#modal-login-big" href="#">登陆注册</a></li>
                    	<li class="icon hidden-lg hidden-sm hidden-md"><a data-toggle="modal" data-target="#modal-login-small" href="#">登陆</a></li>
                    </c:if>
                </ul><!-- /.nav -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->


<!-- Modal -->
<div id="modal-login-big" class="modal login fade hidden-xs"  tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="text-center">
                    <ul class="login-list clearfix ">
                        <li class='active'>Login</li> 
                        <li class="divider"></li>
                        
                        <li><a data-toggle="modal" data-target="#modal-SignUp-big" href="#" >Sign Up</a></li>
                    </ul><!-- /.login-list -->	
                    <form role="form" class="inner-top-50" action="login">
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="sr-only">Email address</label>
                            <input type="text" class="form-control bookshop-form-control" id="username" name="username" placeholder="输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="userpwd" name="userpwd">
                        </div>

                        <input type="submit" class="btn btn-primary btn-uppercase" value="登陆"/>
                        <a href="#" class='forgot-password'>忘记密码</a>
                    </form>
                </div>
            </div><!-- /.modal-body -->
            <div class="modal-footer">
                <div class="text-center">
                    <ul class='social-list text-center'>
                        <li><a href="#" class="facebook"></a></li>
                        <li><a href="#" class="google-plus"></a></li>
                        <li><a href="#" class="twitter"></a></li>
                        <li><a href="#" class="pinterest"></a></li>
                    </ul><!-- /.social-list -->
                </div>
            </div><!-- /.modal-footer -->
            <a href="#" data-dismiss="modal" class="remove-icon"><i class="fa fa-times"></i></a>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal -->
<div id="modal-login-small" class="modal fade login login-xs hidden-sm hidden-lg"  tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="text-center">
                    <div class="logo-holder">
                        <h1 class="logo">BookShop</h1>
                        <div class="logo-subtitle">
                            <span>World of books</span>
                        </div><!-- /.logo-subtitle --> 
                    </div>

                    <form role="form" class="inner-top-50">
                        <div class="form-group">
                            <label for="entername" class="sr-only">Email</label>
                            <input type="email" class="form-control bookshop-form-control" id="entername" placeholder="输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="enterpassword" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="enterpassword">
                        </div>

                        <input type="submit" class="btn btn-primary btn-block btn-uppercase" value="Login"/>
                        <a href="#" class='forgot-password'>forgot password</a>
                    </form>
                </div>
            </div><!-- /.modal-body -->
            <div class="modal-footer">
                <div class="text-center">
                    <ul class='social-list text-center'>
                        <li><a href="#" class="facebook"></a></li>
                        <li><a href="#" class="google-plus"></a></li>
                        <li><a href="#" class="twitter"></a></li>
                        <li><a href="#" class="pinterest"></a></li>
                    </ul><!-- /.social-list -->
                </div>
            </div><!-- /.modal-footer -->
            <a href="#" data-dismiss="modal" class="remove-icon"><i class="fa fa-times"></i></a>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modal-SignUp-big" class="modal login fade hidden-xs"  tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="text-center">
                    <ul class="login-list clearfix ">
                        <li class='active'>Sign Up</li> 
                        <li class="divider"></li>
                        <li><a data-toggle="modal" data-target="#modal-loign-big1" href="#" >login</a></li>
                    </ul><!-- /.login-list -->	
                    <form role="form" class="inner-top-50" action="SignUp">
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="sr-only">Email address</label>
                            <input type="text" class="form-control bookshop-form-control" id="username" name="username" placeholder="输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="userpwd" name="userpwd">
                        </div>

                        <input type="submit" class="btn btn-primary btn-uppercase" value="注册"/> 
                        
                    </form>
                </div>
            </div><!-- /.modal-body -->
            <div class="modal-footer">
                <div class="text-center">
                    <ul class='social-list text-center'>
                        <li><a href="#" class="facebook"></a></li>
                        <li><a href="#" class="google-plus"></a></li>
                        <li><a href="#" class="twitter"></a></li>
                        <li><a href="#" class="pinterest"></a></li>
                    </ul><!-- /.social-list -->
                </div>
            </div><!-- /.modal-footer -->
            <a href="#" data-dismiss="modal" class="remove-icon"><i class="fa fa-times"></i></a>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!-- Modal -->
<div id="modal-loign-big1" class="modal login fade hidden-xs"  tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="text-center">
                    <ul class="login-list clearfix ">
                        <li class='active'>Login</li> 
                        <li class="divider"></li>
                        
                        <li><a data-toggle="modal" data-target="#modal-SignUp-big" href="#" >Sign Up</a></li>
                    </ul><!-- /.login-list -->	
                    <form role="form" class="inner-top-50" action="login">
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="sr-only">Email address</label>
                            <input type="text" class="form-control bookshop-form-control" id="username" name="username" placeholder="输入用户名">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="userpwd" name="userpwd">
                        </div>

                        <input type="submit" class="btn btn-primary btn-uppercase" value="登陆"/>
                        <a href="#" class='forgot-password'>忘记密码</a>
                    </form>
                </div>
            </div><!-- /.modal-body -->
            <div class="modal-footer">
                <div class="text-center">
                    <ul class='social-list text-center'>
                        <li><a href="#" class="facebook"></a></li>
                        <li><a href="#" class="google-plus"></a></li>
                        <li><a href="#" class="twitter"></a></li>
                        <li><a href="#" class="pinterest"></a></li>
                    </ul><!-- /.social-list -->
                </div>
            </div><!-- /.modal-footer -->
            <a href="#" data-dismiss="modal" class="remove-icon"><i class="fa fa-times"></i></a>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->










		<div class="main-header">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-4 col-md-4 top-search-holder m-t-10">
						<!-- ============================================== SEARCH BAR ============================================== -->
<form class="search-form" role="search" action="find">
	<div class="form-group">
		<label class="sr-only" for="page-search">Type your search here</label>
		<input name="page-search" id="page-search" class="search-input form-control" type="search" value="${pageSearch}" placeholder="输入搜索内容" >
	</div>
	
	<button class="page-search-button">
		<span class="fa fa-search">
			<span class="sr-only">Search</span>
		</span>
	<button>
</form>

<!-- ============================================== SEARCH BAR : END ============================================== -->					
</div><!-- /.top-search-holder -->

<div class="col-xs-12 col-sm-4 col-md-4 text-center logo-holder">
						<!-- ============================================== LOGO ============================================== -->
<a href="indexList">
	<h1 class="logo">BookShop</h1>
	<div class="logo-subtitle">
		<span>书籍是人类进步的阶梯</span>
	</div><!-- /.logo-subtitle -->
</a>
<!-- ============================================== LOGO : END ============================================== -->					</div><!-- /.logo-holder -->

					<div class="col-xs-12  col-md-2 header-shippment hidden-sm m-t-10">
						<!-- ============================================== FREE DELIVERY ============================================== -->
<div class="media free-delivery hidden-xs ">
	<span class="media-left"><img src="assets/images/delivery-icon.png" height="48" width="48" alt=""></span>
	<div class="media-body">
		<h5 class="media-heading">Free delivery</h5>
	</div>
</div>
<!-- ============================================== FREE DELIVERY : END ============================================== -->					
</div><!-- /.header-shippment -->

<div class="col-xs-12 col-sm-4 col-md-2 animate-dropdown1 top-cart-row m-t-10">
<!-- ============================================== SHOPPING CART DROPDOWN ============================================== -->                              
<ul class="clearfix shopping-cart-block list-unstyled">
    <li class="dropdown">
        <a class="menu-toggle-right clearfix" href="/.menu-toggle-right">
            <span class="pull-right cart-right-block">
                <img src="assets/images/cart-icon.png" alt="" width="46" height="39" />
            </span><!-- /.cart-right-block -->
            <span class="pull-right cart-left-block">
                <span class="cart-block-heading">购物车</span>
                <span class="hidden-xs"></span>
            </span><!-- /.cart-left-block -->
        </a>
    </li>
</ul> <!-- /.list-unstyled --> 
<!-- ============================================== SHOPPING CART DROPDOWN : END ============================================== -->					
</div><!-- /.top-cart-row -->
				</div><!-- /.row -->

			</div><!-- /.container -->

		</div><!-- /.main-header -->

		


<!-- ============================================== 导航条 ============================================== -->
<div class="header-nav animate-dropdown">
		<div class="container">			
			<div class="nav-bg-class">
				<!-- ============================================================= NAVBAR PRIMARY ============================================================= -->
<nav class="yamm navbar navbar-primary animate-dropdown" role="navigation">
    <div class="navbar-header">
        <button id="btn-navbar-primary-collapse" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-primary-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div><!-- /.navbar-header -->
    <div class="collapse navbar-collapse" id="navbar-primary-collapse">
        <ul class="nav navbar-nav">
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                                                
            <li class="active"><a href="indexList">主页</a></li>
            
             <li><a href="find">全部图书</a></li>
             <li class="hidden-sm"><a href="#">有声读物</a></li>
             <li class="hidden-sm hidden-md"><a href="#">杂志</a></li>
             <li class="hidden-sm hidden-md"><a href="#">短视频</a></li>
             <li><a href="#">音乐</a></li>
             <li class="dropdown navbar-right"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">菜单界面</a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="yamm-content">
                            <div class="row">
                                <div class="col-md-6 col-sm-6">
                                    <ul class="links">
                                        <li><a href="indexList">Home</a></li>
                                        <li><a href="find">Books</a></li>
                                        <li><a href="find">Single-Book</a></li>
                                        <li><a href="#">Blog</a></li>
                                        <li><a href="#">Blog Post</a></li>
                                    </ul>
                                </div>
                            <div class="col-md-6 col-sm-6">
                                <ul class="links">
                                    <li><a href="#">About</a></li>
                                    <li><a href="#">Contact</a></li>
                                    <li><a href="#">Categories</a></li>
                                    <li><a href="#">Magazine</a></li>
                                    <li><a href="#">Error</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                    
                    
                </ul>
             </li>
        </ul><!-- /.nav -->
    </div><!-- /.collapse navbar-collapse -->   
</nav><!-- /.yamm -->
<!-- ============================================================= NAVBAR PRIMARY : END ============================================================= -->			</div><!-- /.nav-bg-class -->
		</div><!-- /.container -->
	
</div><!-- /.header-nav -->
<!-- ============================================== NAVBAR : END ============================================== -->
	</header>

<!-- ============================================== HEADER : END ============================================== -->   


<!-- ==============================================单个书籍显示 开始==============================================-->        
            <div class="content wow fadeInUp">
	<div class="container">
		<div class="row">
			<ul class="breadcrumb text-center">
				<li><a href="indexList">主页</a></li>
				<li><a href="allbooks">全部图书</a></li>
				<li class="active">${book.bookname}</li>				
			</ul>

			<div class="divider">
			      <img class="img-responsive" src="assets/images/shadow.png" alt="">
			</div><!-- /.divider -->
		</div>
		<div class="row inner-top-xs single-book-block">
			<div class="col-md-9 col-md-push-3">
				<!-- .primary block -->
				<div class="single-book primary-block">
	<div class="row">
		<div class="col-md-5 col-sm-5">
			<div class="book-cover">
				<img width="268" height="408" alt="" src="assets/images/blank.gif" data-echo="${book.cover}">
			</div><!-- /.book-cover -->
			<div class="share-button">
				
				<!-- Go to www.addthis.com/dashboard to customize your tools -->
                <div class="addthis_native_toolbox inner-top-vs"></div>
			</div>
			<div class="list-unstyled link-block inner-top-50">
				<a href="#customer-reviews" class='customer-review'><i class="icon fa fa-comment"></i><span class="customer-review">书本评论(${plNum}) &darr; </span></a>
			</div>
		</div>
		<div class="col-md-7 col-sm-7">
			<div class="featured-book-heading">
				<h1 class="title">${book.bookname}</h1>
				<p class="singl-book-author">
					作者：
					<a href="#">${book.author}</a>
				</p>
			</div>

			<div class="row">
				<div class="col-md-3">
					<p class="single-book-price">￥${book.price} </p>
				</div>
				<div class="col-md-9">
					<div class="add-cart-button btn-group">
					
						<button class="btn btn-single btn-sm" type="button" data-toggle="dropdown" id="bookid" name="bookid"  onclick="window.location.href = 'addCar?bookid=${book.bookid}'">
							<img src="assets/images/add-to-cart.png" alt="">
						</button>
					
				
						<button class="btn btn-single btn-uppercase" type="button" name="bookid" value="bookid" onclick="window.location.href = 'buy?bookid=${book.bookid}'">购买</button>
					
					</div>
				</div>
			</div>
			<div class="description"><p>${book.text}</p>

			</div>
				</div>
			</div>
		</div>			    
<!-- ==============================================单个书籍显示 结束==============================================-->        
			<div class="divider inner-top-xs">
                    <img src="assets/images/shadow.png" class="img-responsive" alt=""/>
				</div>
		
<!-- ==============================================推荐书籍  开始==============================================-->

			
				

				 <div class="module wow fadeInUp">
				    <div class="module-heading home-page-module-heading">
				        <h2 class="module-title home-page-module-title"><span>推荐书籍</span></h2>
				        
				 <!--  <p class="see-all-link"><a href="#">See All</a> &rarr;</p>--> 
				    </div>
				    
				
				    <div class="module-body">
					    <div class="row text-center">
<!-- ==============================================单条推荐书籍 开始 ==============================================-->
<c:forEach  items="${xgList}" var="cl">
 <div class="col-md-3 col-sm-4">
	<div class="book">
		<a href="singleBook?bookid=${cl.bookid}"><div class="book-cover">
			<img width="140" height="212" alt="" src="assets/images/blank.gif" data-echo="${cl.cover }">
		</div></a>
		<div class="book-details clearfix">
			<div class="book-description">
				<h3 class="book-title"><a href="single-book.html">${cl.bookname}</a></h3>
				<p class="book-subtitle">作者：<a href="single-book.html">${cl.author}</a></p>
			</div>
			<div class="actions">
				<span class="book-price price">￥${cl.price}</span>

				<div class="cart-action"> 
					<a class="add-to-cart" title="Add to Cart" href="addCar?bookid=${cl.bookid}">Add to Cart</a>       

				</div>
			</div>
		</div>
	</div>
</div>
</c:forEach>
<!-- ==============================================单条推荐书籍 结束==============================================-->
					    </div>
					</div>
				 </div>
<!-- ==============================================推荐书籍 结束==============================================-->
	 <div class="divider inner-top-xs">
                    <img src="assets/images/shadow.png" class="img-responsive" alt="" />
	</div>
				 
<!-- ==============================================评论 开始==============================================-->

			

				<div class="module wow fadeInUp" id="customer-reviews">
				    <div class="module-heading home-page-module-heading margin-top-10">
				        <h2 class="module-title home-page-module-title "><span>书本评论(${plNum})</span></h2>
				        
				    </div>
				    <!-- .customer reviews -->

					    <div class="module-body inner-top-xs" id="reviews">
	<ul class="list-unstyled review-list">
	<!-- ==============================================单条评论 开始===============================================-->
	<c:forEach  items="${plList}" var="cl">
		<li class="box effect">
			<section class="paper">
				<div class="tape"></div>
				<div class="head"></div>
				<div class="row review-content">
					<div class="col-md-2 col-sm-2">
						<div class="customer-image-text"><span>${cl.username}</span></div>

					</div>
					<div class="col-md-10 col-sm-10">
						<h5 class="customer-name inner-right-xs">${cl.username}</h5>
						<p class="posted-date">${cl.time}</p>
						<p class="text">${cl.text}</p>
							<a href="#" class="reply-review"></a> 
						</div>
					</div>
					<div class="bottom"></div>
				</section>
			</li>
</c:forEach>
 <!-- ==============================================单条评论 结束==============================================-->
			

				</ul>
			</div>					<!-- /.customer reviews -->
				</div>

			</div><!-- /.col -->
<!-- ==============================================评论 结束==============================================-->	
		
			<div class="col-md-3 col-md-pull-9">
				<aside class="sidebar">
					<div class="sidebar-module">
						<div class="sidebar-module-heading">
							<h4 class="sidebar-module-title">你正在浏览</h4>
						</div>
						<div class="sidebar-module-body clearfix">
							<ul class="list-unstyled filter-list">						
								<li>
									<a class="pull-right remove-filter" title="Cancel" href="javascript:goUrl();">
									<i class="fa fa-times"></i>
									</a>
									${book.bookname}
								</li>
							</ul>
						</div>
					</div>
						
                 </aside>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container -->
</div><!-- /.content -->
<!-- ============================================== è¯ä»·ç»æ ============================================== -->







<!-- ============================================== FOOTER ============================================== -->
<footer class="footer clearfix">
    <div class="margin-top-10">
        <div class="container inner-top-vs">
 <!-- ============================================== FOOTER-TOP ============================================== -->
<div class="row">
    <div class="col-md-3 col-sm-4">
        <div class="footer-module">
            <h4 class="footer-module-title">About this site</h4>
            <div class="footer-module-body m-t-20 clearfix">
                <p><span class="pull-left"><img src="assets/images/footer-logo.png" alt="" width="75" height="75"></span>A cras tincidunt, ut tellus et. Gravida scele risque, ipsum sed iacul is, nunc non namtellus. Placerat sed phasellus, purus purus elit. Cras ante eros. Erat vel. Donec vestibulum sed, vel euismod donec. </p>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-4">
        <div class="footer-module">
            <h4 class="footer-module-title">Categories</h4>
            <div class="footer-module-body clearfix">
                <ul class="list-unstyled link-list">
                    <li><a href="#">Books</a></li>
                    <li><a href="#">Text books</a></li>
                    <li><a href="#">Nook books</a></li>
                    <li><a href="#">Audiobooks</a></li>
                    <li><a href="#">Magazines</a></li>
                </ul>

                <ul class="list-unstyled link-list">
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">Music</a></li>
                    <li><a href="#">Games</a></li>

                </ul>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-4 clearfix ">
        <div class="footer-module">
            <h4 class="footer-module-title">Information</h4>
            <div class="footer-module-body clearfix">
                <ul class="list-unstyled link-list">
                    <li><a href="#">Track Order</a></li>
                    <li><a href="#">Delivery</a></li>
                    <li><a href="#">Return Policy</a></li>
                    <li><a href="#">Giftcards</a></li>
                </ul>

                <ul class="list-unstyled link-list">
                    <li><a href="#">Contact Us</a></li>
                    <li><a href="#">Store Locations</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Terms of Use</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-12">
        <div class="footer-module">
            <h4 class="footer-module-title">connect</h4>
            <div class="footer-module-body clearfix">
                <ul class="clearfix list-unstyled footer-social-contact">
                    <li><a href="#" class="fa fa-facebook" title="Facebook"></a></li>
                    <li><a href="#" class="fa fa-pinterest" title="Pinterest"></a></li>
                    <li><a href="#" class="fa fa-linkedin" title="Linkedin"></a></li>
                    <li><a href="#" class="fa fa-twitter" title="Twitter"></a></li>
                    <li><a href="#" class="fa fa-google-plus" title="Google Plus"></a></li>
                    <li><a href="#" class="fa fa-rss" title="Rss"></a></li>
                    <li><a href="#" class="fa fa-instagram" title="Instagram"></a></li>

                </ul>


                <div class="inner-top-xs">
                    <p>Subscribe to our weekly newsletter.</p>
                    <form class="searchform" action="http://inspectelement.com/" method="get">
                        <input class="s" type="text" placeholder="Email Address" name="s" value="">
                        <input class="searchsubmit" type="submit" value="Subscribe">
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- ============================================== FOOTER-TOP : END ============================================== -->     
 <!-- ============================================== FOOTER-BOTTOM ============================================== -->
<div class="row">
	<div class="col-md-12">
		<div class="pull-left">
			<ul class="payment-list list-unstyled">
				<li><a href="#"><img src="assets/images/payments/1.png" class="img-responsive" height="22" alt=""></a></li>

			</ul>
		</div>
		<p class="copyright-footer pull-right">&copy; 2014 Bookshop. All rights reserved. Made with love by <a href="#">Heztheme</a></p>
	</div>
</div>
<!-- ============================================== FOOTER-BOTTOM : END ============================================== -->        </div>
    </div>
</footer>
<!-- ============================================== FOOTER : END ============================================== -->        </div><!-- /.st-pusher -->
            <!-- ============================================== TOGGLE RIGHT CONTENT ============================================== -->

<div id="cart-dropdown-wrapper">
	<nav id="menu1" class="cart-dropdown">
		<h2 class="shopping-cart-heading">我的购物车</h2>
			<div class="cart-items">
				<div >			
					<ul>		
					  <c:forEach  items="${shopbookList}" var="sl">			
						<li class="media">
							
							<div class="clearfix book cart-book">
								<a href="singleBook?bookid=${sl.bookid }" class="media-left">
									<div class="book-cover">
										<img width="140" height="212" alt="" src="assets/images/blank.gif" data-echo="${sl.cover }">
									</div>
								</a>
								<div class="media-body book-details">
									<div class="book-description">
										<h3 class="book-title"><a href="single-book.jsp">${sl.bookname }</a></h3>
										<p class="book-subtitle">by <a href="single-book.jsp">${sl.author }</a></p>
										<p class="price m-t-20">$${sl.price }</p>
										
										<br>
										<br>
								
								      <button style='background-color:red' class="btn btn-single btn-sm" type="button" data-toggle="dropdown"   onclick="window.location.href = 'deleteCar?bookid=${sl.bookid}'">
								         删除
						             </button>
								
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
										
					</ul>
				</div>
				<div class="cart-item-footer">
					<h3 class='total text-center'>总价格:<span>${totPrice}</span></h3>
					<div class="proceed-to-checkout text-center">
						<button type="button" class="btn btn-primary btn-uppercase"  onclick="window.location.href = 'addinfo?totPrice=${totPrice}&flag=1'">全部购买</button>
					</div>
				</div>
			
		</div>
		
	</nav>
</div>

<!-- ============================================== TOGGLE RIGHT CONTENT : END ============================================== -->


 
                </div><!-- /#wrapper -->

    <script src="assets/js/jquery-1.11.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap-hover-dropdown.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/perfect-scrollbar.min.js"></script>
    <script src="assets/js/jquery-ui.min.js"></script>
    <script src="assets/js/jquery.customSelect.min.js"></script>    
    <script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/wow.min.js"></script>
    <script src="assets/js/echo.min.js"></script>
    <script src="assets/js/scripts.js"></script>
</body>
</html>
