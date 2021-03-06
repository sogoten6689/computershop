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
		<h1>Thông tin thành viên</h1>
		<form:form >
	
			<div class="form-group">
				<label for="tenLoai">Tên người dùng</label>
				 <form:input disabled="true" class="form-control" path="ten" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Số điện thoại</label>
				 <form:input disabled="true"  class="form-control" path="sdt" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Địa chỉ</label>
				 <form:input disabled="true"  class="form-control" path="diachi" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Email</label>
				 <form:input disabled="true"  class="form-control" path="email" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Giới tính</label>
				 <form:input disabled="true"  class="form-control" path="gioitinh" />
			</div>
			<a href="/nhom21/accounts" class="btn btn-primary">Thoát</a>
		</form:form>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
