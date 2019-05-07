 <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
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
			<div class="col-sm-6 text-left"><h1 style="color:brown;">Danh sách sản phẩm 
			</h1></div>
		</div>
			<div class="row">
				<c:forEach var="product" items="${list}">
				<div class="col-sm-3">
					<h3> Sản phẩm ${product.tensp}</h3>
					<img alt="" src="/nhom21/resources/theme1/img/sanpham/${product.masp%10}.jpg">
					<div>${product.dongia}</div>
					<div>${product.mota}</div>
					<div>
							<c:forEach var="type" items="${listtype}">
								<c:if test="${product.maloai==type.maLoai }">
								<c:out value="${type.tenLoai}"></c:out>
								</c:if>
							</c:forEach>
					</div>
					<div>${product.trangthai}</div>
					<div>
						<a class="btn btn-primary" href="/nhom21/addcart/${product.masp}">Thêm vào giỏ</a>
					</div>
				</div>
					
			</c:forEach>
				</div>
			
	
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
