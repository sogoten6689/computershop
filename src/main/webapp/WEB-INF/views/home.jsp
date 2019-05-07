<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	
	<div class="container text-center" style="color:yellow;">
	<br/><br/>
		<div>
			<a href="/nhom21/products" >
			<img src="/nhom21/resources/theme1/img/sanpham/linhkienhome.jpg" />
		</a>
		</div>
		<div>
		<a href="/nhom21/products" class="btn btn-warning" >Tìm và lựa chọn linh kiện cần thiết cho mình nhé!</a>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
