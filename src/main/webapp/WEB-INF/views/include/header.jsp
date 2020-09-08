<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
%>
	<%-- Main Header --%>
	<header class="header1">
		<!-- Header desktop -->
		<div class="container-menu-header">
			<div class="topbar">
				<div class="topbar-social">
					<a href="#" class="topbar-social-item fa fa-facebook"></a>
					<a href="#" class="topbar-social-item fa fa-instagram"></a>
					<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
					<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
					<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
				</div>

				<span class="topbar-child1">
					Free shipping for standard order over $100
				</span>

				<div class="topbar-child2">
						<c:choose>
							<c:when test="${empty login.userNm}"></c:when>	
							<c:otherwise>
								<small>${login.userNm} (${login.signUpUserId})</small>
							</c:otherwise>
						</c:choose>
					<div class="topbar-language rs1-select2">
						<select class="selection-1" name="time">
							<option>USD</option>
							<option>EUR</option>
						</select>
					</div>
				</div>
			</div>

			<div class="wrap_header">
				<!-- Logo -->
				<span><a href="/" class="logo font-weight-bold font-italic text-monospace text-info" style= "font-size: x-large;" title="Chae hee*">Chae hee* 
<!-- 					<img src="/images/icons/logo.png" alt="IMG-LOGO"> -->
				</a></span>

				<!-- Menu -->
				<div class="wrap_menu">
					<nav class="menu">
						<ul class="main_menu">
							<li>
								<a href="/">Home</a>
<!-- 								<ul class="sub_menu">
									<li><a href="home.jsp">Homepage V1</a></li>
									<li><a href="home2.jsp">Homepage V2</a></li>
									<li><a href="home3.jsp">Homepage V3</a></li>
								</ul> -->
							</li>

							<li>
								<a href="/product/productList">Shop</a>
							</li>

							<li class="sale-noti">
								<a href="/product/productDetail">Sale</a>
							</li>

							<li>
								<a href="/cart/shoppingCart">Features</a>
							</li>

							<li>
								<a href="/blog/blogList">Blog</a>
							</li>

							<li>
								<a href="/aboutUs">About</a>
							</li>

							<li>
								<a href="/contactUs">Contact</a>
							</li>
						</ul>
					</nav>
				</div>

				<!-- Header Icon -->
				<div class="header-icons">
					<c:choose>
							<c:when test="${empty login.userNm}">
								<a href="/user/login" class="header-wrapicon1 dis-block">
									<!-- <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> -->
									<i class="fas fa-sign-in-alt fa-2x"  aria-hidden="true" title = "LOG IN"></i>
								</a>
							</c:when>	
							<c:otherwise>
								<a href= "/user/logout" class = "header-wrapicon1 dis-block">
									<i class="fas fa-sign-out-alt fa-2x" title= "LOG OUT"></i>
								</a>
							</c:otherwise>
					</c:choose>
					<span class="linedivide1"></span>
					<a href="#" class="header-wrapicon1 dis-block">
						<img src="/images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide1"></span>

					<div class="header-wrapicon2">
						<img src="/images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
						<span class="header-icons-noti">0</span>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-01.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											White Shirt With Pleat Detail Back
										</a>

										<span class="header-cart-item-info">
											1 x $19.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-02.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Converse All Star Hi Black Canvas
										</a>

										<span class="header-cart-item-info">
											1 x $39.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-03.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Nixon Porter Leather Watch In Tan
										</a>

										<span class="header-cart-item-info">
											1 x $17.00
										</span>
									</div>
								</li>
							</ul>

							<div class="header-cart-total">
								Total: $75.00
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="cart.html" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										View Cart
									</a>
								</div>

								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Check Out
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap_header_mobile">
			<!-- Logo moblie -->
			<span><a href="/" class="logo-mobile font-weight-bold font-italic text-monospace text-info" style= "font-size: x-large;" title="Chae hee*">Chae hee* 
<!-- 				<img src="/images/icons/logo.png" alt="IMG-LOGO"> -->
			</a></span>

			<!-- Button show menu -->
			<div class="btn-show-menu">
				<!-- Header Icon mobile -->
				<div class="header-icons-mobile">
<!-- 					<a href="/user/login" class="header-wrapicon1 dis-block">
						<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
						<i class="fas fa-sign-in-alt fa-2x"  aria-hidden="true"></i>
					</a> -->
					<c:choose>
						<c:when test="${empty login.userNm}">
							<a href="/user/login" class="header-wrapicon1 dis-block">
								<!-- <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> -->
								<i class="fas fa-sign-in-alt fa-2x"  aria-hidden="true" title = "LOG IN"></i>
							</a>
						</c:when>	
						<c:otherwise>
								<a href= "/user/logout" class = "header-wrapicon1 dis-block">
									<i class="fas fa-sign-out-alt fa-2x" title= "LOG OUT"></i>
								</a>
						</c:otherwise>
					</c:choose>
					<span class="linedivide2"></span>
					<a href="#" class="header-wrapicon1 dis-block">
						<img src="/images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide2"></span>

					<div class="header-wrapicon2">
						<img src="/images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
						<span class="header-icons-noti">0</span>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-01.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											White Shirt With Pleat Detail Back
										</a>

										<span class="header-cart-item-info">
											1 x $19.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-02.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Converse All Star Hi Black Canvas
										</a>

										<span class="header-cart-item-info">
											1 x $39.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="/images/item-cart-03.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Nixon Porter Leather Watch In Tan
										</a>

										<span class="header-cart-item-info">
											1 x $17.00
										</span>
									</div>
								</li>
							</ul>

							<div class="header-cart-total">
								Total: $75.00
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="cart.html" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										View Cart
									</a>
								</div>

								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Check Out
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
					<span class="hamburger-box">
						<span class="hamburger-inner"></span>
					</span>
				</div>
			</div>
		</div>

		<!-- Menu Mobile -->
		<div class="wrap-side-menu" >
			<nav class="side-menu">
				<ul class="main-menu">
					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8" style='text-align:right; padding-right:10px;'>
						<span class="topbar-child1" >
							${login.userNm} (${login.signUpUserId})
						</span>
					</li>

<!-- 					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8">
						<div class="topbar-child2-mobile">
							<div class="topbar-language rs1-select2">
								<select class="selection-1" name="time">
									<option>USD</option>
									<option>EUR</option>
								</select>
							</div>
						</div>
					</li> -->

					<li class="item-topbar-mobile p-l-10">
						<div class="topbar-social-mobile">
							<a href="#" class="topbar-social-item fa fa-facebook"></a>
							<a href="#" class="topbar-social-item fa fa-instagram"></a>
							<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
							<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
							<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
						</div>
					</li>

					<li class="item-menu-mobile">
						<a href="/">Home</a>
<!-- 						<ul class="sub-menu">
							<li><a href="home.jsp">Homepage V1</a></li>
							<li><a href="home2.jsp">Homepage V2</a></li>
							<li><a href="home3.jsp">Homepage V3</a></li>
						</ul> -->
						<i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
					</li>

					<li class="item-menu-mobile">
						<a href="/product/productList">Shop</a>
					</li>

					<li class="item-menu-mobile">
						<a href="/product/productDetail">Sale</a>
					</li>

					<li class="item-menu-mobile">
						<a href="/cart/shoppingCart">Features</a>
					</li>

					<li class="item-menu-mobile">
						<a href="/blog/blogList">Blog</a>
					</li>

					<li class="item-menu-mobile">
						<a href="/aboutUs">About</a>
					</li>

					<li class="item-menu-mobile">
						<a href="/contactUs">Contact</a>
					</li>
				</ul>
			</nav>
		</div>
	</header>
	
	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	