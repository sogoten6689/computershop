<%@ page contentType="text/html; charset=UTF-8"%>
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
			<div class="col-sm-6 text-left">
				<h3>Sửa Loại Sản Phẩm</h3>
			</div>
			<div class="col-sm-6 text-right">
				<a href="/nhom21/types" class="btn btn-danger">Hủy</a>
			</div>
		</div>
		<form:form method="post" action="/nhom21/editsavetype">
			<div class="form-group">
				 <form:hidden  path="maLoai" />
			</div>
			<div class="form-group">
				<label for="tenLoai">Tên loại:</label>
				 <form:input class="form-control" path="tenLoai" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Thông Tin Loại:</label>
				 <form:input class="form-control" path="thongTinLoai" />
			</div>
			<input type="submit" class="btn btn-primary" value="Save"/>
		</form:form>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
