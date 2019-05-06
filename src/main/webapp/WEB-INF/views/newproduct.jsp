<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>account</title>
<jsp:include page="./parts/add_head.jsp" />
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp" />
	<!-- end header -->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 text-left">
				<h3>Thêm sản phẩm mới</h3>
			</div>
			<div class="col-sm-6 text-right">
				<a href="/nhom21/products" class="btn btn-danger">Hủy</a>
			</div>
		</div>
		<form:form method="post" action="saveproduct" enctype="multipart/form-data">
			<div class="form-group">
				<label for="tensp">Tên sản phẩm:</label>
				<form:input class="form-control" path="tensp" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Giá sản phẩm</label>
				<form:input class="form-control" path="dongia" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Ảnh sản phẩm</label>
				<form:input  type="file" class="form-control" name="file" path="file" />
			</div>
			<div class="form-group">
				<label for="thongTinLoai">Mô tả sản phẩm</label>
				<form:input class="form-control" path="mota" />
			</div>

			<div class="form-group">
				<label for="loaisp">Loại sản phẩm</label>
				<form:select path="maloai" class="form-control">
					<form:options items="${listtype}" itemValue="maLoai" itemLabel="tenLoai"/>
				</form:select>
			</div>
				<div class="form-group">
					<label for="thongTinLoai">Trạng thái sản phẩm(còn, hết)</label>
					<form:input class="form-control" path="trangthai" />
				</div>
				<input type="submit" class="btn btn-primary" value="Lưu" />
		</form:form>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
