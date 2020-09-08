<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
 <%--head.jsp--%>
	<%@ include file="../include/head.jsp"%>

<body>
	<%-- Main Header --%>
    <%@ include file="../include/header.jsp"%>
	
	<!-- Title Page -->
	<section class="bg-title-page p-t-50 p-b-40 flex-col-c-m" style="background-image: url(/images/heading-pages-02.jpg);">
		<h2 class="l-text2 t-center">
			Women
		</h2>
		<p class="m-text13 t-center">
			New Arrivals Women Collection 2018
		</p>
	</section>

	<!-- Content page -->
	<section class="bgwhite p-t-55 p-b-65">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
					<div class="leftbar p-r-20 p-r-0-sm">
						<!--  -->
						<h4 class="m-text14 p-b-7">
							Categories
						</h4>

						<ul class="p-b-54">
							<li class="p-t-4">
								<a href="#" class="s-text13 active1">
									All
								</a>
							</li>

							<li class="p-t-4">
								<a href="#" class="s-text13">
									Women
								</a>
							</li>

							<li class="p-t-4">
								<a href="#" class="s-text13">
									Men
								</a>
							</li>

							<li class="p-t-4">
								<a href="#" class="s-text13">
									Kids
								</a>
							</li>

							<li class="p-t-4">
								<a href="#" class="s-text13">
									Accesories
								</a>
							</li>
						</ul>

						<!--  -->
						<h4 class="m-text14 p-b-32">
							Filters
						</h4>

						<div class="filter-price p-t-22 p-b-50 bo3">
							<div class="m-text15 p-b-17">
								Price
							</div>

							<div class="wra-filter-bar">
								<div id="filter-bar"></div>
							</div>

							<div class="flex-sb-m flex-w p-t-16">
								<div class="w-size11">
									<!-- Button -->
									<button class="flex-c-m size4 bg7 bo-rad-15 hov1 s-text14 trans-0-4">
										Filter
									</button>
								</div>

								<div class="s-text3 p-t-10 p-b-10">
									Range: $<span id="value-lower">610</span> - $<span id="value-upper">980</span>
								</div>
							</div>
						</div>

						<div class="filter-color p-t-22 p-b-50 bo3">
							<div class="m-text15 p-b-12">
								Color
							</div>

							<ul class="flex-w">
								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter1" type="checkbox" name="color-filter1">
									<label class="color-filter color-filter1" for="color-filter1"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter2" type="checkbox" name="color-filter2">
									<label class="color-filter color-filter2" for="color-filter2"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter3" type="checkbox" name="color-filter3">
									<label class="color-filter color-filter3" for="color-filter3"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter4" type="checkbox" name="color-filter4">
									<label class="color-filter color-filter4" for="color-filter4"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter5" type="checkbox" name="color-filter5">
									<label class="color-filter color-filter5" for="color-filter5"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter6" type="checkbox" name="color-filter6">
									<label class="color-filter color-filter6" for="color-filter6"></label>
								</li>

								<li class="m-r-10">
									<input class="checkbox-color-filter" id="color-filter7" type="checkbox" name="color-filter7">
									<label class="color-filter color-filter7" for="color-filter7"></label>
								</li>
							</ul>
						</div>

						<div class="search-product pos-relative bo4 of-hidden">
							<input class="s-text7 size6 p-l-23 p-r-50" type="text" name="search-product" placeholder="Search Products...">

							<button class="flex-c-m size5 ab-r-m color2 color0-hov trans-0-4">
								<i class="fs-12 fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>
				
				<!-- MAIN PRODUCT  -->
				<div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
					<div class="flex-sb-m flex-w p-b-35">
						<div class="flex-w">
							<div class="rs2-select2 bo4 of-hidden w-size12 m-t-5 m-b-5 m-r-10">
								<select class="selection-2" name="sorting">
									<option>Default Sorting</option>
									<option>Popularity</option>
									<option>Price: low to high</option>
									<option>Price: high to low</option>
								</select>
							</div>

							<div class="rs2-select2 bo4 of-hidden w-size12 m-t-5 m-b-5 m-r-10">
								<select class="selection-2" name="sorting">
									<option>Price</option>
									<option>$0.00 - $50.00</option>
									<option>$50.00 - $100.00</option>
									<option>$100.00 - $150.00</option>
									<option>$150.00 - $200.00</option>
									<option>$200.00+</option>
								</select>
							</div>
						</div>

						<span class="s-text8 p-t-5 p-b-5"  id = "totalCount">
						</span>
					</div>

					<!-- Product -->
					<div class="row">
							<!--c:forEach 시작  -->
							<c:forEach items = "${prdList}" var = "list">
								<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
									<!-- Block2 -->
									<div class="block2">
										<div class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
											<img src="/images/item-02.jpg" alt="IMG-PRODUCT">
											<div class="block2-overlay trans-0-4">
												<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
													<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
													<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
												</a>
												<div class="block2-btn-addcart w-size1 trans-0-4">
													<!-- Button -->
													<button class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4 addCart" data-toggle="modal" data-target="#exampleModalCenter">
														Add to Cart
													</button>
												</div>
											</div>
										</div>
										<div class="block2-txt p-t-20">
											<!-- prodCd -->
											<input type="hidden"  name="prodCd" value="${list.prodCd}"/>
											<input type ="hidden" name="cartStock"  value="1">
											<a href="/product/productDetail${pagingMaker.makeSearch(pagingMaker.cri.page)}&prodCd=${list.prodCd}" class="block2-name dis-block s-text3 p-b-5" data-keyVal = "${list.prodNm}">
												${list.prodNm}
											</a>
											<span class="block2-price m-text6 p-r-5 numComma" >
												${list.csmePrice} <span class= "s-text3">won</span>
											</span>
										</div>
									</div>
								</div>
							</c:forEach>
							<!--c:forEach 종료  -->
					</div>
					<!-- Product end -->
					
					<!-- Pagination -->
					<div class="pagination flex-m flex-w p-t-26">
<!-- 						<a href="#" class="item-pagination flex-c-m trans-0-4 active-pagination">1</a>
						<a href="#" class="item-pagination flex-c-m trans-0-4">2</a> -->
							<c:if test = "${pagingMaker.prev}">
            					<%-- <a href = "pageList${pagingMaker.makeFind(pagingMaker.startPage - 1)}"> --%>
						  		<a href = "productList${pagingMaker.makeSearch(pagingMaker.startPage - 1)}">
						  			<button type="button" class="fas fa-angle-left fa-2x" ></button>
						  		</a>
						  	</c:if>
						  	<c:forEach begin = "${pagingMaker.startPage}" end = "${pagingMaker.endPage}"  var = "pNum">
						  		<a href = "/product/productList${pagingMaker.makeSearch(pNum)}">
						  			<button type="button" class="<c:out value="${pagingMaker.cri.page == pNum?'item-pagination flex-c-m trans-0-4 active-pagination':' item-pagination flex-c-m trans-0-4 ' }"/>">${pNum}</button>
						  		</a>
                            </c:forEach>
						  	<c:if test = "${pagingMaker.next && pagingMaker.endPage > 0}">
						  		<a href = "productList${pagingMaker.makeSearch(pagingMaker.endPage+1)}">
						  			<button type="button" class="fas fa-angle-right fa-2x"></button>
						  		</a>
 							</c:if>
					</div>
				</div>
				<!-- MAIN PRODUCT END -->
			</div>
		</div>	
	</section>
<%--plugin_js  include --%>
<%@ include file="../include/plugin_js.jsp" %>
</body>
<script type ="text/javascript">
$(document).ready(function(){
 	
 	// showing startNum ~ endNum of totalNum
	var startNum = 0; //페이지 당 첫 숫자
	var endNum = 0; //페이지 당 마지막 숫자
	var curPage= 0;   //현재 페이지
	var totalNum = 0; //전체 숫자
	var txt = "";        //최종 텍스트 
	
	curPage = $(".active-pagination").text();
	
 	if(curPage == 1){
 		startNum = 1;
 	}else{
 		startNum = 1+6*(curPage-1);
 	}
 	
 	if(${pagingMaker.cri.page} == 1){
 		endNum = 6;
 	}else if(curPage == ${pagingMaker.endPage}){
 		endNum = parseInt(${pagingMaker.totalData});
 	}else{
 		endNum = 6*(curPage-1)+6;
 	}
 	
 	// 전체 숫자
 	totalNum = ${pagingMaker.totalData};
 	txt = "";
	txt = "Showing "+ ""+startNum+"" +"~"+ ""+endNum+""+ " of "+"" +totalNum+" results";
	$("#totalCount").text("");
 	$("#totalCount").text(txt);
 	
 	
 	//카트 담기
    $('.block2-btn-addcart').each(function(){
		// 카트 담기 ajax 
		$(this).on('click',function(){
			console.log($(this).attr('class'));
			var parent = $(this).parent().parent().parent();
			console.log(parent.attr('class'));
			var prodCd = parent.find('input[name=prodCd]').val();
			var prodNm = parent.find('.block2-txt a').text();
			var cartStock = parent.find('input[name=cartStock]').val();
			console.log("prodNm= "+prodNm);
			console.log("prodCd= "+prodCd);
			console.log("cartStock= "+cartStock);
			
			var data = {prodCd : prodCd, cartStock : cartStock};
			
			$.ajax({
				url : "/cart/addCart",
				type : "post",
				data : data,
				success : function(result){
					if(result == 1){
						//카트담기 성공 및 팝업오픈
						$("#modalBox").modal('show');
						
					} else {
						alert("회원만 사용 가능합니다. 로그인해 주세요.");
						self.location = '/user/login';
					}
				},
				error : function(){
					alert("카트담기에 실패 하였습니다.");
				}
			});
		});
    });
});

</script>

<%@ include file="../include/commonFn.jsp"%>
<!-- Main Footer -->
<%@ include file="../include/footer.jsp"%>