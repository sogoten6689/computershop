 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<title>User</title>
<jsp:include page="./parts/add_head.jsp" />
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp" />
	<!-- end header -->
	<div class="container">
		<h1>Thông tin thành viên</h1>
		<form:form method="post" action="/nhom21/editsaveuser">
			<div class="form-group">
				 <form:hidden class="form-control" path="ma" />
			</div>
			<div class="form-group">
				<label for="tenLoai">Tên người dùng</label>
				 <form:input class="form-control" path="ten" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Số điện thoại</label>
				 <form:input disabled="true" class="form-control" path="sdt" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Địa chỉ</label>
				 <form:input class="form-control" path="diachi" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				 <form:input class="form-control" path="email" />
			</div>
			<div class="form-group">
				<label for="giotinh">Giới tính</label>
				 <form:input class="form-control" path="gioitinh" />
			</div>
			<input type="submit" class="btn btn-primary" value="Save"/>
			<a href="/nhom21/" class="btn btn-danger">Thoát</a>
		</form:form>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
