
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<jsp:include page="./parts/add_head.jsp" />
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp" />
	<!-- end header -->
	<div class="container">
		<c:if test="${empty listcart }">
			<h1 class="text-center">Giỏ hàng rỗng</h1>
			<div class="text-center">
				<a href="/nhom21/products">Mua sắm ngay</a>
			</div>
		</c:if>

		<c:if test="${ not empty listcart }">
			<h1 class="text-center">Giỏ hàng của bạn</h1>
			<table class="table table-striped text-center">
			<tr>
				<th>Tên</th>
				<th>Số lương</th>
				<th>Đơn giá</th>
				<th>Thành tiền</th>
				<th>Thao tác</th> 
			</tr>
			<c:forEach var="cart" items="${listcart}">
				<tr class="success">
					<td>${cart.tensp}</td>
					<td>${cart.soluong}</td>
					<td>${cart.dDongia}</td>
					<td>${cart.soluong*cart.dDongia}</td>
					<td>
						<%-- <a class="btn btn-success" href="/nhom21/addcart/${cart.masp}">Thêm 1 sản phẩm</a> --%>
						<a class="btn btn-warning" href="/nhom21/removeonecart/${cart.masp}">Giảm 1 sản phẩm</a>
						<a class="btn btn-danger" href="/nhom21/removecart/${cart.masp}">Xóa sản phẩm</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class="col-sm-3"><a class="btn btn-danger" href="/nhom21/cancelcart">Hủy đơn</a></div>
			<div class="col-sm-3"></div>
			<div class="col-sm-3">Tổng tiền</div>
			<div class="col-sm-3">${totalmoney} <a class="btn btn-primary" href="/nhom21/charge">Thanh toán</a>
				
			</div>
		</div>
		</c:if>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
