<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
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

<!-- ============================================== SEARCH BAR : END ============================================== -->					</div><!-- /.top-search-holder -->

					<div class="col-xs-12 col-sm-4 col-md-4 text-center logo-holder">
						<!-- ============================================== LOGO ============================================== -->
<a href="home.html">
	<h1 class="logo">BookShop</h1>
	<div class="logo-subtitle">
		<span>World of books</span>
	</div><!-- /.logo-subtitle -->
</a>
<!-- ============================================== LOGO : END ============================================== -->					</div><!-- /.logo-holder -->

					<div class="col-xs-12  col-md-2 header-shippment hidden-sm m-t-10">
						<!-- ============================================== FREE DELIVERY ============================================== -->
<div class="media free-delivery hidden-xs ">
	<span class="media-left"><img src="assets/images/delivery-icon.png" height="48" width="48" alt=""></span>
	<div class="media-body">
		<h3 class="media-heading">个人中心</h5>
	</div>
</div>
<div class="col-xs-12 col-sm-4 col-md-2 animate-dropdown1 top-cart-row m-t-10">
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
    <div class="collapse navbar-collapse" id="navbar-primary-collapse">
        <ul class="nav navbar-nav">
        <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
              <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
              <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
             <li><a href="indexList">主页</a></li>
             <li><a href="queryByPageno" >订单查看</a></li>
             <li><a href="UpdatePwd.jsp">修改密码</a></li>
             <li><a href="logout">退出</a></li>
        </ul><!-- /.nav -->
    </div><!-- /.collapse navbar-collapse -->   
</nav><!-- /.yamm -->
		</div><!-- /.container -->
	
</div><!-- /.header-nav -->

<div>
</div>
</div>
</div>


<!-- ============================================== NAVBAR : END ============================================== -->
	</header>   </br></br>
  <div class="all-categories content">
	<div class="container">
		<div class="row">
			<div class="categories-breadcrumb">
				<ul class="breadcrumb">
					<li><a>个人信息：</a></li>
			  
				</ul>
				<table align="center">
				<tr><th><ul><li>用户名 :${username }</li></ul></th></tr>

				</table>
				
			</div>
			<div class="divider">
				<img class="img-responsive" src="assets/images/all-categories/shadow_all_categories_01.png" alt="">
			</div>
		</div><!-- /.row -->
	</div><!-- /.container -->
 </div><!-- /#wrapper -->     
</div>
</div>       
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
