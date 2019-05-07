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
		<h1>Danh sach thanh vien <span>Them thanh vien</span></h1>
		<table class="table table-striped text-center">
			<tr>
				<th>Mã</th>
				<th>Họ và tên</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Email</th>
				<th>Giới tính</th>
				<th>Ngày sinh</th>
				<th>Hành Động</th>
			</tr>
			<c:forEach var="user" items="${list}">
				<tr class="success">
					<td>${user.ma}</td>
					<td>${user.ten}</td>
					<td>${user.sdt}</td>
					<td>${user.diachi}</td>
					<td>${user.email}</td>
					<td>${user.gioitinh}</td>
					<td>${user.ngaysinh}</td>
					<td>xoa - sua</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
