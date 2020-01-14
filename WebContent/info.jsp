
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
<style type="text/css">
input{
	transition:all 0.30s ease-in-out;
	-webkit-transition: all 0.30s ease-in-out;
	-moz-transition: all 0.30s ease-in-out;
	
	border:#35a5e5 1px solid;
	border-radius:3px;
	outline:none;
}
input:focus{
	box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-webkit-box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-moz-box-shadow:0 0 5px rgba(81, 203, 238, 1);
}
button{
	transition:all 0.30s ease-in-out;
	-webkit-transition: all 0.30s ease-in-out;
	-moz-transition: all 0.30s ease-in-out;
	
	border:#35a5e5 1px solid;
	border-radius:3px;
	outline:none;
}
button:focus{
	box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-webkit-box-shadow:0 0 5px rgba(81, 203, 238, 1);
	-moz-box-shadow:0 0 5px rgba(81, 203, 238, 1);
}
</style>

<script>
 function trim(s){
	  return s.replace(/(^\s*)|(\s*$)/g,"")
	}
 function check(){
	 var name=trim(document.getElementById("name").value);
	 var address=trim(document.getElementById("address").value);
	 var tel=trim(document.getElementById("tel").value);
	 if(name==''){
		 alert("收货人不能为空！");
	 }
	 else if(address==''){
		 alert("收货地址不能为空！");
	 }	
	 else if(tel==''){
		 alert("联系人电话不能为空！");
	 }
	 else{
		 document.getElementById("form1").submit();
	 }
	 
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
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">运送方式</a></li>
                    <li><a href="#">常见问题</a></li>
                </ul><!-- /.nav -->
            </div><!-- /.col -->
            <div class="col-md-3 col-xs-10 col-sm-10 navbar-left">

                <p class='text-center'><a href="#"><span class="icon glyphicon glyphicon-earphone"></span> 8888-8888 </a></p>

            </div><!-- /.col -->
            <div class="col-md-4 col-sm-2">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden-xs hidden-sm"><a href="#">个人中心</a></li>
                    <li class="icon icon-small hidden-xs"><a data-toggle="modal" data-target="#modal-login-big" href="#">登陆注册</a></li>
                    <li class="icon hidden-lg hidden-sm hidden-md"><a data-toggle="modal" data-target="#modal-login-small" href="#">登陆</a></li>
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
                        <li><a href="#">Sign Up</a></li>
                    </ul><!-- /.login-list -->	
                    <form role="form" class="inner-top-50" action="webce1">
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="sr-only">Email address</label>
                            <input type="email" class="form-control bookshop-form-control" id="exampleInputEmail1" name="exampleInputEmail1" placeholder="输入邮箱">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="exampleInputPassword1" name="exampleInputPassword1">
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
                            <input type="email" class="form-control bookshop-form-control" id="entername" placeholder="Hezy Theme">
                        </div>
                        <div class="form-group">
                            <label for="enterpassword" class="sr-only">Password</label>
                            <input type="password" class="form-control bookshop-form-control" id="enterpassword">
                        </div>

                        <button type="button" class="btn btn-primary btn-block btn-uppercase">Login</button>
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
		<div class="main-header">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-4 col-md-4 top-search-holder m-t-10">
						<!-- ============================================== SEARCH BAR ============================================== -->
<form class="search-form" role="search">
	<div class="form-group">
		<label class="sr-only" for="page-search">Type your search here</label>
		<input id="page-search" class="search-input form-control" type="search" placeholder="输入搜索内容">
	</div>
	<button class="page-search-button">
		<span class="fa fa-search">
			<span class="sr-only">Search</span>
		</span>
	</button>
</form>
<!-- ============================================== SEARCH BAR : END ============================================== -->					</div><!-- /.top-search-holder -->

					<div class="col-xs-12 col-sm-4 col-md-4 text-center logo-holder">
						<!-- ============================================== LOGO ============================================== -->
<a href="home.jsp">
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
<!-- ============================================== FREE DELIVERY : END ============================================== -->					</div><!-- /.header-shippment -->

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
<!-- ============================================== SHOPPING CART DROPDOWN : END ============================================== -->					</div><!-- /.top-cart-row -->
				</div><!-- /.row -->

			</div><!-- /.container -->

		</div><!-- /.main-header -->

		


<!-- ============================================== NAVBAR ============================================== -->
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
            <li class="active"><a href="indexList">主页</a></li>
            
             <li><a href="books.jsp">全部图书</a></li>
             <li class="hidden-sm"><a href="#">有声读物</a></li>
             <li class="hidden-sm hidden-md"><a href="www.baidu.com">杂志</a></li>
             <li class="hidden-sm hidden-md"><a href="books.jsp">短视频</a></li>
             <li><a href="books.jsp">音乐</a></li>
             <li class="dropdown navbar-right"><a href="#" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">菜单界面</a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="yamm-content">
                            <div class="row">
                                <div class="col-md-6 col-sm-6">
                                    <ul class="links">
                                        <li><a href="indexList">Home</a></li>
                                        <li><a href="books.jsp">Books</a></li>
                                        <li><a href="single-book.jsp">Book</a></li>
                                        <li><a href="#">Blog</a></li>
                                        <li><a href="#">Blog Post</a></li>
                                    </ul>
                                </div>
                            <div class="col-md-6 col-sm-6">
                                <ul class="links">
                                    <li><a href="about.jsp">About</a></li>
                                    <li><a href="contact.jsp">Contact</a></li>
                                    <li><a href="categories.jsp">Categories</a></li>
                                    <li><a href="magazine.jsp">Magazine</a></li>
                                    <li><a href="error.jsp">Error</a></li>
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
            <div class="content">
	<div class="container">
		<div class="row">
			<ul class="breadcrumb text-center">
				
				<li><a href="indexList">返回全部图书</a></li>
				<li><a href="#">填写订单信息</a></li>
			</ul><!-- /.breadcrumb -->

		</div><!-- /.row -->
	</div><!-- /.container -->
</div>  
  <div class="all-categories content">
	<div class="container">
		<div class="row">
			<div class="categories-breadcrumb">
			<form action="addorder?userid=${userid}" id="form1">
				<table align="center">
				<tr><th>用户名:</th><th>${sessionScope.username}</th></tr>
				<tr><th>用户号：</th><th><input type="text" id="userid" name="userid" style="border-style:none"  value="${userid}"  readonly="readonly" ></th></tr>
                <tr><th>下单时间：</th><th><input type="text" id="time" name="time" style="border-style:none"  value="${time }" readonly="readonly"></th></tr>
                <tr><th>订单总价：</th><th><input type="text" id="totPrice" name="totPrice" style="border-style:none"  value="${totPrice }" readonly="readonly"></th></tr>          
                <tr><th>收货人:</th><th><input type="text" name="name" id="name" required="required" value="${username}"></th></tr>
                <tr><th>收货地址:</th><th><input type="text" name="address" id="address" required="required" value="${address }"></th></tr>
                <tr><th>联系人电话:</th><th><input type="text" name="tel" id="tel" required="required"></th></tr>
                <tr><th><button type="button" onclick="return check()">保存信息并购买</button></th><th><input type="reset" value="重置" name="重置"></input></th></tr>
				</table>
				</form>
			</div>
			<div class="divider">
				<img class="img-responsive" src="assets/images/all-categories/shadow_all_categories_01.png" alt="">
			</div>
		</div><!-- /.row -->
	</div><!-- /.container -->
 </div><!-- /#wrapper -->  



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
<!-- ============================================== FOOTER-TOP : END ============================================== -->            <hr>
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



<!-- ============================================== TOGGLE RIGHT CONTENT : END ============================================== -->


 
                           <!-- ============================================== TOGGLE LEFT CONTENT ============================================== -->
<div id="filter-wrapper">
	<nav id="menu2" class="filter">
		<div class="filter-module">
	        <div class="scrollbar1">		
				<div class="filter-module-box">
					<h5 class="filter-module-title">Filter</h5>
					<div class='filter-module-body'>
						
						<div id="slider-range" class="m-t-20"></div>
						<p class="m-t-20">
						    <label for="amount">Price:</label>
						    <input type="text" id="amount" readonly style="border:0; color:#333; font-weight:normal;">
						</p>
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

				<div class="filter-module-box">
					<h5 class="filter-module-title">product Categories</h5>
					<div class='filter-module-body'>
						<ul>
							<li><a href="#">Books</a></li>
							<li><a href="#">Textbooks</a></li>
							<li><a href="#">Audiobooks</a></li>
							<li><a href="#">Magazines</a></li>
							<li><a href="#">Movies</a></li>
							<li><a href="#">Music</a></li>
							<li><a href="#">Games</a></li>
						</ul>	
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

				<div class="filter-module-box">
					<h5 class="filter-module-title">new releases</h5>
					<div class='filter-module-body'>
						<ul>
							<li><a href="#">Last 30 days <span class="pull-right">100,358</span></a></li>
							<li><a href="#">Last 90 days <span class="pull-right">308,425</span></a></li>
							<li><a href="#">Coming Soon<span class="pull-right">55,123</span></a></li>
						</ul>	
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

				<div class="filter-module-box">
					<h5 class="filter-module-title">format</h5>
					<div class='filter-module-body'>
						<ul>
							<li><a href="#">paperback <span class="pull-right">24,874,630</span></a></li>
							<li><a href="#">Hardcover <span class="pull-right">8,803,309</span></a></li>
							<li><a href="#">Kindle Edition<span class="pull-right">1,360,419</span></a></li>
							<li><a href="#">Audible Audio Edition<span class="pull-right">48,280</span></a></li>
							<li><a href="#">Printed Access Code<span class="pull-right">20,666</span></a></li>
							<li><a href="#">Audio CD<span class="pull-right">381,425</span></a></li>
							<li><a href="#">Board Book<span class="pull-right">149,751</span></a></li>
						</ul>	
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

				<div class="filter-module-box">
					<h5 class="filter-module-title">author</h5>
					<div class='filter-module-body'>
						<ul>
							<li><a href="#">John Green <span class="pull-right">286</span></a></li>
							<li><a href="#">J.J.Smith <span class="pull-right">3</span></a></li>
							<li><a href="#">Laura Hillenbrand<span class="pull-right">5</span></a></li>
							<li><a href="#">George R.R.Martin <span class="pull-right">377</span></a></li>
							<li><a href="#">Dean Koontz <span class="pull-right">260</span></a></li>
							<li><a href="#">Edward Klein <span class="pull-right">4</span></a></li>
							<li><a href="#">Donna Tartt<span class="pull-right">5</span></a></li>

						</ul>
						<a href="#" class="filter-see-more">see more <i class="icon fa fa-plus"></i></a>	
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

				<div class="filter-module-box">
					<h5 class="filter-module-title">Language</h5>
					<div class='filter-module-body'>
						<ul>
							<li><a href="#">English <span class="pull-right">18,610,000</span></a></li>
							<li><a href="#">German <span class="pull-right">2,199,573</span></a></li>
							<li><a href="#">French<span class="pull-right">2,185,922</span></a></li>
							<li><a href="#">Spanish <span class="pull-right">1,171,681</span></a></li>
							<li><a href="#">Italian <span class="pull-right">804,936</span></a></li>
							<li><a href="#">Ulkrainian <span class="pull-right">910,814</span></a></li>
							<li><a href="#">Chineses<span class="pull-right">562,811</span></a></li>

						</ul>	
						<a href="#" class="filter-see-more">see more <i class="icon fa fa-plus"></i></a>
					</div><!-- /.filter-module-body-->
				</div><!-- /.filter-module-box -->

			</div><!-- /.scrollbar -->
		</div><!-- /.filter-module -->

	</nav><!-- /.filter-wrapper -->
</div>
<!-- ============================================== TOGGLE LEFT CONTENT : END ============================================== -->  
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
