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
			<div class="col-sm-6 text-left"><h3>Danh sách sản phẩm</h3></div>
			<div class="col-sm-6 text-right">
				<a href="/nhom21/addproduct" class="btn btn-primary">Thêm sản phẩm mới</a>
			</div>
		</div>
		<table class="table table-striped text-center">
			<tr>
				<th>Tên </th>
				<th>Giá</th>
				<th>Ảnh</th>
				<th>Mô tả</th>
				<th>Loại</th>
				<th>Trạng thái</th>
				<th>Thao tác</th>
			</tr>
			<c:forEach var="product" items="${list}">
				<tr class="success">
					<td>${product.tensp}</td>
					<td>${product.dongia}</td>
					<td>${product.anhsp}</td>
					<td>${product.mota}</td>
					<td>
							<c:forEach var="type" items="${listtype}">
								<c:if test="${product.maloai==type.maLoai }">
								<c:out value="${type.tenLoai}"></c:out>
								</c:if>
							</c:forEach>
					</td>
					<td>${product.trangthai}</td>
					<td>
						<a class="btn btn-primary" href="deleteproduct/${product.masp}">Xóa</a>
						<a class="btn btn-primary" href="editproduct/${product.masp}">Sửa</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
