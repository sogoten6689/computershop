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
			<div class="col-sm-6 text-left"><h3>Danh sách loại sản phẩm</h3></div>
			<div class="col-sm-6 text-right">
				<a href="addtype" class="btn btn-primary">Thêm loại mới</a>
			</div>
		</div>
		<table class="table table-striped text-center">
			<tr>
				<th>Tên Loại</th>
				<th>Thông tin loại</th>
				<th>Thao tác</th>
			</tr>
			<c:forEach var="type" items="${list}">
				<tr class="success">
					<td>${type.tenLoai}</td>
					<td>${type.thongTinLoai}</td>
					<td>
						<a class="btn btn-primary" href="deletetype/${type.maLoai}">Xóa</a>
						<a class="btn btn-primary" href="edittype/${type.maLoai}">Sửa</a>
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
