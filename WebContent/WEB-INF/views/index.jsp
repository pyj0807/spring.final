<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/signin.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<title>그룹웨어</title>
<body class="text-center">
	<form class="form-signin"
		action="${pageContext.servletContext.contextPath }/login.do"
		method="post">
		<h1 class="h3 mb-3 font-weight-normal">GROUP WARE</h1>
		<label for="inputEmail" class="sr-only">사원 아이디</label> 
		<input type="id" id="inputEmail" class="form-control" placeholder="사원 아이디" required autofocus name="id"> 
		<label for="inputPassword" class="sr-only">사원 비밀번호</label> 
		<input type="password" id="inputPassword" class="form-control" placeholder="사원 비밀번호" required name="pass">
		
		<c:if test="${!empty err }">
			<div class="alert alert-danger" role="alert">
				정보를 잘못 입력하셨습니다.
			</div>
		</c:if>
		
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				로그인 유지
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그 인</button>
	</form>
</body>
</html>