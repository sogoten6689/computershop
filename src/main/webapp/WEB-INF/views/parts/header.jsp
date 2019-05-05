<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	style="background-color: #343a40 !important;">
	<div class="container">
		<a class="navbar-brand" href="/nhom21"> <img
			src="/nhom21/resources/theme1/img/favicon.png" style="height: 40px;" />&nbsp;&nbsp;
			Computer Shop
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/nhom21/search">Tìm kiếm <span class="sr-only">(current)</span>
				</a></li>
				<c:if test="${ empty sdt}">
					<li class="nav-item"><a class="nav-link" href="/nhom21/login">Đăng
							nhập</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/nhom21/register">Đăng kí</a></li>
				</c:if>
				<c:if test="${ sdt!=null }">
					<li class="nav-item"><a class="nav-link" href="/nhom21/user/${sdt}">Hello
							${sdt}</a></li>
					<li class="nav-item"><a class="nav-link" href="/nhom21/logout">Logout</a>
					</li>
					<c:if test="${ quyen == 1 }">
						<li class="nav-item"><a class="nav-link"
							href="/nhom21/accounts">Tài khoản</a></li>
						<li class="nav-item"><a class="nav-link" href="/nhom21/types">Loại</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/nhom21/users">Thành
								viên</a></li>
					</c:if>
				</c:if>
			</ul>
		</div>
	</div>
</nav>

