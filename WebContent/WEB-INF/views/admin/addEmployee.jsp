<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<h2>사원등록</h2>
<c:if test="${!empty err }">
<div class="alert alert-danger" role="alert">
   	DB 처리중에 문제가 발생하였습니다.
</div>
</c:if>
<form action="${pageContext.servletContext.contextPath }/admin/employee/add.do" method="post">
	<div class="form-group">
		<label>이름</label> <input
			type="text" class="form-control" placeholder="Example input">
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-md-6">
		<label>부서명</label>
				<select class="form-control" name="deparment" >
					<c:forEach var="deparments" items="${dep }">
						<option value="${deparments.DID}">${deparments.DNAME }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6">
			<label>직책</label>
				<select class="form-control">
					<c:forEach var="p" items="${pos }">
						<option value="${p.PID}">${p.PNAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label>입사일 </label> <input
			type="date" class="form-control" name="joindate">
	</div>
	<div class="form-group">
		<button type="submit"  class="form-control btn btn-outline-primary">사원등록</button>
	</div>
</form>