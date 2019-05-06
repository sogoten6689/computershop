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
		<div>
			<input type="text">
			<button>Tìm kiếm</button>
		</div>		
		
		<div class="dropdown">
			<button class="btn dropdown-toggle" type="button"
				data-toggle="dropdown" style="color:white;box-shadow: none;">
				Loại sản phẩm<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<c:forEach items="${listtype}" var="type">
					<li><a href="/nhom21/products/${type.maLoai}">${type.tenLoai}</a></li>
				 </c:forEach>
			</ul>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${ not empty listcart}">
					<li class="nav-item">
					<a class="btn" href="#" style="font-size:20px;color:white;" >Giỏ<i class="fa fa-shopping-cart" style="font-size:20px;color:white;"> ${listcart.size()} </i></a>
				</li>
				</c:if>
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
					
				</c:if>
			</ul>
		</div>
	</div>
</nav>
	<c:if test="${quyen != null && quyen==1 }">
		<jsp:include page="adminheader.jsp"/>
	</c:if>
	<br/>

