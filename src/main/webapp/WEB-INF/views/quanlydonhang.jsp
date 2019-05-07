 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<title>Computer shop</title>
<jsp:include page="./parts/add_head.jsp" />
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp" />
	<!-- end header -->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 text-left"><h3 style="color:brown;">Danh sách sản phẩm đã mua </h3></div>
			<div class="col-sm-6 text-right">
			</div>
		</div>
		<table class="table table-striped text-center">
			<tr>
				<th>Mã đơn hàng </th>
				<th>Số điện thoại khách</th>
				<th>Phương thức thanh toán</th>
				<th>Địa chỉ</th>
				<th>Thao tác</th>
			</tr>
			<c:forEach var="order" items="${orders}">
				<tr class="success">
					<td>${order.imadonhang}</td>
					<td>${order.sSDT}</td>
					<td>${order.sPtthanhtoan}</td>
					<td>${order.sDiachiNhanhang}</td>
					<td>
						<a class="btn btn-primary" href="/nhom21/ordercheck/${order.imadonhang}">Xem</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="text-center">
						<a class="btn btn-primary" href="/nhom21/">Thoát</a>
		</div>
		
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
