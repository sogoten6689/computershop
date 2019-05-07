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
		<h1>Danh sach tai khoan <span>Them tai khoan</span></h1>
		<table class="table table-striped text-center">
			<tr>
				<th>Sdt</th>
				<th>Quyen</th>
				<th>Chi Tiet</th>
			</tr>
			<c:forEach var="account" items="${list}">
				<tr class="success">
					<td>${account.sdt}</td>
					<td>${account.quyen}</td>
					<td>
						<a class="btn btn-primary" href="user/${account.sdt}">Xem Tài khoản</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
