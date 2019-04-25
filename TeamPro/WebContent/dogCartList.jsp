<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
		<title>Insert title here</title>
		<style type="text/css">
			#listForm{
				width:960px;
				margin: 0 auto;
			}
			
			h2{
				text-align:center;
			}
			
			table{
				width:750px;
				margin: 0 auto;
			}
			
			.tr_top{
				background-color: #cccc00
			}
			
			#image{
				width:70px;
				height:70px;
				border:none;
			}						
			
		</style>
		<!-- 체크박스의 선택에 따른 작업을 수행하는 함수 -->
		<script type="text/javascript">
			function checkAll(frm){
				if(frm.remove.length == undefined){ // 하나의 제품만 가지고 있다면
					frm.remove.checked = frm.allCheck.checked;
				}else{ // 장바구니에 여러개의 제품이 있다면
					for(var i = 0; i < frm.remove.length; i++){
						frm.remove[i].checked = frm.allCheck.checked;
					}
				}
			}
			
			function checkQty(id, qty){
				if(qty > 1){
					location.href="dogCartQtyDown.dog?id="+id;
				}
			}
		</script>
	</head>
	<body>
		<h2>장바구니 목록</h2>
		<form action = "dogCartRemove.dog" method = "post">
			<%-- <input type = "hidden" name = "id" value = "${cart.id}"/> --%>
			<table>
				<tr class = "tr_top">
					<td>
						<input type = "checkbox" id = "allCheck" name = "allCheck" onclick="checkAll(this.form)"/>
					</td>
					<td> 번호 </td>
					<td> 상품이미지 </td>
					<td> 상품명 </td>
					<td> 상품가격 </td>
					<td> 상품수량 </td>
				</tr>
				<c:forEach var="cart" items="${cartList}" varStatus="status">
					<tr>
						<td>
							<input type = "checkbox" id = "remove" name = "remove" value = "${cart.id}"/>
						</td>
						<td> ${status.index+1}</td>
						<td> <img src="images/${cart.image}" id = "image"/> </td>
						<td> ${cart.kind}</td>
						<td> ${cart.price }</td>
						<td align = "center">
							<a href = "dogCartQtyUp.dog?id=${cart.id}"><i class='fas fa-plus'></i></a>
							${cart.qty}
							<a href = "javascript:checkQty(${cart.id}, ${cart.qty})"><i class='fas fa-minus'></i></a>
						</td>
					</tr>					
				</c:forEach>
				<tr>
					<td colspan = "5" style = "text-align:center;">
						총 구매금액 : ${totalMoney} 원
					</td>
				</tr>	
				<tr>
					<td colspan = "5" style = "text-align:center;">
						<input type = "submit" value = "삭제하기" />
						<input type = "button"  value = "결재하기"  onclick = "location.href='dogCartCheckout.dog?totalMoney=${totalMoney}'"/>
						<input type = "button"  value = "쇼핑계속하기" onclick="location.href='dogList.dog'"/>
					</td>
				</tr>	
							
			</table>
		</form>
	
	</body>
</html>