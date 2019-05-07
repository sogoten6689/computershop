<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
	<title>Đăng nhập</title>
	<jsp:include page="./parts/add_head.jsp" />
  <link href="/nhom21/resources/theme1/css/login.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<jsp:include page="./parts/header.jsp"/>
	<br/><br/><br/><br/><br/>
	<!-- end header -->
		<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-danger">
  				<strong>Danger!</strong> ${msg }
			</div>
		</c:if>
		<div class="d-flex justify-content-center">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="/nhom21/resources/theme1/img/favicon.png" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form:form  method="post" action="loginpost">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<form:input type="text"  class="form-control input_user" path="sdt" placeholder="username"/>
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<form:password  class="form-control input_pass" path="matkhau" placeholder="password"/>
						</div>
<!-- 						<div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="customControlInline">
								<label class="custom-control-label" for="customControlInline">Remember me</label>
							</div>
						</div> -->
						
				<div class="d-flex justify-content-center mt-3 login_container">
					<input type="submit" class="btn btn-primary" value="Login"/>
				</div>
					</form:form>
				</div>
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Don't have an account? <a href="/nhom21/register" class="ml-2">Sign Up</a>
					</div>
					<!-- <div class="d-flex justify-content-center links">
						<a href="#">Forgot your password?</a>
					</div> -->
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="./parts/footer.jsp" />
	<!-- end footer -->
</body>
</html>
