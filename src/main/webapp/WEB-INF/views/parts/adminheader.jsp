<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-expand-lg navbar-gray bg-gray fixed-top"
	style="background-color: gray!important; top:66; line-height: 0.5;">
	<div class="container">
		<div  class="collapse navbar-collapse">
			<span class="navbar-brand">&nbsp;&nbsp;
			Hello Admin
		</span>
			<ul class="navbar-nav ml-auto">
					<c:if test="${ quyen == 1 }">
						<li class="nav-item"><a class="nav-link"
							href="/nhom21/accounts">Quản lý tài khoản</a></li>
						<li class="nav-item"><a class="nav-link" href="/nhom21/types">Quản lý loại sản phẩm</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/nhom21/users">Quản lý thành viên</a></li>
						
						<li class="nav-item"><a class="nav-link" href="/nhom21/quanlyproducts">Quản lý sản phẩm</a></li>
					</c:if>
			</ul>
		</div>
	</div>
</nav>
<br/><br/>

