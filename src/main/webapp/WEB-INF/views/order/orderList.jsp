<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%--head.jsp--%>
<%@ include file="../include/head.jsp"%>
<body class="animsition">
<%-- Main Header --%>
<%@ include file="../include/header.jsp"%>
	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(/images/heading-pages-01.jpg);">
		<h2 class="l-text2 t-center">
			ORDER
		</h2>
	</section>

	<!-- Order -->
	<section class="cart bgwhite p-t-70 p-b-100">
		<div class="container" id = "cartContainer">
			<!-- Cart item -->
			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
					<table class="table-shopping-cart">
						<tr class="table-head">
							<th class="column-1"  style='padding-left:55px'>
							</th>
							<th class="column-2">Product</th>
							<th class="column-3">Price (KRW)</th>
							<th class="column-4 p-l-70">Quantity</th>
							<th class="column-5">Total (KRW)</th>
							<th class="column-6">ProdCd</th>
							<th class="column-7">orgPrice</th>
						</tr>
						<!--c:forEach 시작  -->	
						<c:forEach items="${cartList}" var = "list"> 	
							<tr class="table-row">
								<td class="column-1">
									<input type="checkbox" name="chBox" class="form-check-input" data-keyNum="${list.cartNo}" />
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="/images/item-10.jpg" alt="IMG-PRODUCT">
									</div>
								</td>
								<td class="column-2 prodNm">${list.prodNm}</td>
								<td class="column-3  csmePrice"><fmt:formatNumber pattern="###,###,###"  value="${list.csmePrice}" /></td>
								<td class="column-4">
									<div class="flex-w bo5 of-hidden w-size17">
										<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
										</button>
										<input class="size8 m-text18 t-center num-product" type="number" name="cartStock" value="${list.cartStock}">
										<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
										</button>
									</div>
								</td>
								<td class="column-5 numComma"></td>
								<td class="column-6">${list.prodCd}</td>
								<td class="column-7">${list.csmePrice}</td>
							</tr>
						</c:forEach>	
						<!--c:forEach 종료  -->
					</table>
				</div>
			</div>

			<div class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
				<div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10" >
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"  id = "deleteCart" >
						Delete Selection
					</button>
				</div>
				<div class="size10 trans-0-4 m-t-10 m-b-10" >
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"  id = "updateCart">
						Update Cart
					</button>
				</div>
			</div>

			<!-- Total -->
			<div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">
					Cart Totals (KRW)
				</h5>
				
				<!-- Total 금액 -->
				<div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm">
						Subtotal:
					</span>
					<span class="m-text21 w-size20 w-full-sm numComma" id = "subTotalAmt">
					</span>
				</div>
				
				<!-- 배송료 -->
				<div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm">
						Shipping:
					</span>
					<div class="w-size20 w-full-sm">
						<span class="m-text21 w-size20 w-full-sm numComma" >
						2500
						</span>
						<span id = "shippingAmt"></span>
					</div>
				</div>

				<div class="flex-w flex-sb-m p-t-26 p-b-30">
					<span class="m-text22 w-size19 w-full-sm">
						Total:
					</span>

					<span class="m-text21 w-size20 w-full-sm numComma"  id = "totalAmt">
					</span>
				</div>

				<div class="size15 trans-0-4">
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
						ORDER  / PAYMENT
					</button>
				</div>
			</div>
		</div>
	</section>
<%--plugin_js  include --%>
<%@ include file="../include/plugin_js.jsp" %>
<script type= "text/javascript">
$(document).ready(function(){
	
	//table hidden 처리
	$('.column-6, .column-7, #shippingAmt').css('display','none');
	
	caculateAmtFn();
	
	//updateCart
	$('#updateCart').on('click',function(){
		var confirmVal = confirm("저장 하시겠습니까?");
		if(confirmVal){
			// html table을 json객체로 변환
	    	var jsonObj = tableToJsonFn();
	    	console.log("=======================================");
			console.log(jsonObj);
			console.log("=======================================");
	    	//json 객체를 String 객체로 변환 (stringify 함수 사용)
	  	    var stringObj = JSON.stringify(jsonObj);
	  	  	console.log(stringObj);
	  	  	
	  	  	// ajax client와 서버통신 및 데이터 저장
	  	  	$.ajax({
	  	  		type : 'post',
	  	  		url : '/cart/updateCart',
	  	  		dataType : 'json',
	  	  		data : {'stringObj' : stringObj},
	  	  		success : function(rtnMap){
					
	  	  			// map에 저장된 값(result) 을 불러올수 있다.
	  	  			if (rtnMap.result == 'success'){
	  	  				alert('저장되었습니다.');
	  	  				location.reload();
	  	  			}
	  	  		},
	  	  		error:function(error){
	  	  			alert('데이터를 갖고 오는데 실패하였습니다.');
	  	  		}
	  	  	});
		}
	});
	
	//금액 계산
	function caculateAmtFn(){
		var price = 0; //판매가
		var stock = 0; //수량 
		var sellAmt = 0;  //판매금액(판매가*수량)
		var subTotalAmt = 0; //subTotal 금액
		var shippingAmt = 2500;
		var totalAmt = 0;
		
		//each문으로 품목당 판매금액을 구함
		$('.table-row').each(function(idx, item){
			price = $(item).find('.column-7').text();
			//console.log(price);
			stock = $(item).find('.column-4').find('input[name=cartStock]').val();
			//console.log(stock);
			sellAmt =(price*stock);
			//console.log(sellAmt);
			$(item).find('.column-5').text(sellAmt);
			subTotalAmt += sellAmt;
		});
		
		// subTotal
		$("#subTotalAmt").text(subTotalAmt);
		totalAmt = (subTotalAmt+shippingAmt);
		
		$("#totalAmt").text(totalAmt);
		
		//천단위 콤마
		numCommaFn();
	}
	
	//매우중요 table => json 객체로 변환
 	function tableToJsonFn() {
 	    var myRows = [];
 	    var title = [];
 	    var $headers = $(".table-shopping-cart .table-head th");
 	    
 	    //table-header
 	    $("th").each(function(index, item) {
 	        title[index] = $(item).html();
 	    });
 	 
 	    // table-row
 	    var tr = $(".table-row");
 	    
 	    // json 형식으로 가공
 	    var $rows = tr.each(function(index) {
 	    						$cells = $(this).find("td");
 	                			myRows[index] = {};
 	                			
 	                			$cells.each(function(cellIndex) {
 	                				//console.log("cellIndex= "+cellIndex);
 	                				//첫번째 index는 상품사진이므로 제외한다.
 	                				if(cellIndex != 0 && cellIndex != 3){
 	                   		 			myRows[index][$($headers[cellIndex]).html()] = $(this).html();
 	                				}else if(cellIndex == 3){ // 구입수량
 	                					myRows[index][$($headers[cellIndex]).html()] = $(this).find('input[name=cartStock]').val();
 	                					console.log($(this).find('input[name=cartStock]').val());
 	                				}
 	               			 	});
 	           			  });
 	    var jsonObj = {};
 	    jsonObj = myRows;
 	    return jsonObj;
 	}
	
    //천단위 콤마 함수
	function numCommaFn(){
	    $(".numComma").each(function(index, item){
	    	var price = $(item).text();	
	    	rtnVal = numberWithCommas(price);
	    	$(this).text(rtnVal);
	    });
	    
	 	// 숫자 천단위마다 콤마
	    function numberWithCommas(price){
	    	return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	    }		
	}
    
    //전체선택체크
    $('#allCheck').on('click',function(){
    	var allChk = $('#allCheck').prop('checked');
    	if(allChk){
    		$('.form-check-input').prop('checked',true);	
    	}else{
    		$('.form-check-input').prop('checked',false);
    	}
    });
    
    $(".form-check-input").each(function(){
    	$(this).on('click',function(){
        	if($(this).prop('checked') == false){
        		$("#allCheck").prop('checked',false);
        	}   		
    	});
    });
    
    
    // 일괄삭제
    $('#deleteCart').on('click',function(){
    	var checkArray = new Array();
    	var target = $('input[name=chBox]');
    	var chk = 0; //체크여부 
    	
    	target.each(function(){
    		chk = $(this).is(':checked');
    		// 체크된것만!! push
    		if(chk){
    			checkArray.push($(this).attr('data-keyNum'));
    		}
    	});
    	
    	if(checkArray.length == 0){
    		alert('삭제할 내역을 선택해 주시기 바랍니다.');
    		return false;
    	}
    	
    	var rtnConfirm = confirm('삭제 하시겠습니까?');
    	
    	if(rtnConfirm){
    		console.log("checkArray= "+checkArray);
    		$.ajax({
    			url : "/cart/deleteCart", 
    			type : "post",
    			data : {cartNoArr : checkArray},
    			async : "false",
    			success: function(data){
    				if(data.result == 'success'){
    					alert('삭제되었습니다.');
    					 location.reload();
    				}else{
    					alert('실패하였습니다.');
    				}
    			},
    			error : function(jqXHR, exception){
    				var errCd = jqXHR.status;
    				var msg = errorMsgCommonFn(errCd, exception);
    					alert(msg);
    			} 
    		});
    	}
    });
    
    
    // 에러 메세지 처리 공통함수
    function errorMsgCommonFn (errCd, exception){
    	 
		var msg = "";
		
		if (errCd === 0) {
            msg = 'Not connect.\n Verify Network.';
        } 
        else if (errCd == 400) {
            msg = 'Server understood the request, but request content was invalid. [400]';
        } 
        else if (errCd == 401) {
            msg = 'Unauthorized access. [401]';
        }
        else if (errCd == 403) {
            msg = 'Forbidden resource can not be accessed. [403]';
        } 
        else if (errCd == 404) {
            msg = 'Requested page not found. [404]';
        } 
        else if (errCd== 500) {
            msg = 'Internal server error. [500]';
        } 
        else if (errCd == 503) {
            msg = 'Service unavailable. [503]';
        } 
        else if (exception === 'parsererror') {
            msg = 'Requested JSON parse failed. [Failed]';
        } 
        else if (exception === 'timeout') {
            msg = 'Time out error. [Timeout]';
        } 
        else if (exception === 'abort') {
            msg = 'Ajax request aborted. [Aborted]';
        } 
        else {
            msg = 'Uncaught Error.n';
        }
		return msg;
    }
    
    
    var num =0;
    $('.table-row .column-1').each(function(i,item){
    	num  += num+1;
    	console.log('item='+item);
    	$(item).text(num);
    });
    
});

</script>
<%@ include file="../include/commonFn.jsp"%>
</body>
<!-- Main Footer -->
<%@ include file="../include/footer.jsp"%>