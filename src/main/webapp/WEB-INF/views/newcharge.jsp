<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Computer shop</title>
<jsp:include page="./parts/add_head.jsp" />
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp" />
	<!-- end header -->
	<div class="container">
		<form:form action="savecharge"
			method="post" acceptCharset="UTF-8">
			<h1>Xác nhận mua hàng</h1>
			<table align="center" class="tablettkh">
				<tr>
					<td>Xin chào khách hàng</td>
					<td> ${ user.ten }
					<form:hidden path="makh" value="${user.ma}" ></form:hidden>
					</td>
				</tr>
				<tr>
					<td>Số điện thoại</td>
					<td><form:input disabled="true" path="sSDT" value="${sdt}" /></td>
				</tr>
				<tr>
					<td><form:label path="sPtthanhtoan">Phương thức thanh toán</form:label></td>
					<!-- <td><form:input path="sPtthanhtoan" name="sPtthanhtoan" id="sPtthanhtoan" /></td> -->
					<td>: <span class="sp2">
					<form:radiobutton
								path="" name="sPtthanhtoan" id="sPtthanhtoan"
								checked="true" value="Khi nhận" class="sp2" />
								&nbsp Khi nhận &nbsp </span> <span class="sp2"><form:radiobutton
								path="sPtthanhtoan" name="sPtthanhtoan" id="sPtthanhtoan2"
								value="Gửi Ví Momo" />&nbsp Gửi Ví Momo &nbsp </span>
					</td>

				</tr>
				<tr>
					<td><form:label path="sDiachiNhanhang">Địa chỉ nhận hàng</form:label></td>
					<td>: <form:input path="sDiachiNhanhang"
							name="sDiachiNhanhang" id="sDiachiNhanhang" /></td>
				</tr>
			</table>
			<div class="text-center">
				<input type="submit" class="btn btn-primary" value="Xác nhận" />
				<a class="btn btn-primary" href="/nhom21/cancelcart">Hủy đơn</a>
				</div>
		</form:form>
	
		<!-- ========================================================================= -->


	</div>

	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
