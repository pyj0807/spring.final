<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<hr />
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">쪽지함</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.NAME }</button>
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.DNAME }
				${sessionScope.user.PNAME }</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> ${sessionScope.id }
		</button>
	</div>
</div>
<h4>
	Message Room<small>(All Departments)</small>
</h4>
<hr />
	<div>
         <c:forEach var="c" items="${remsg }" >
         <c:choose>
         	<c:when test="${c.CHO==0 }">
         		<a href="${pageContext.servletContext.contextPath }/message/view.do?no=${c.NO}"><b style="color: blue">보낸사람 : ${c.SENDER} / 내용 : ${c.CONTENT } / 받은 날짜 : ${c.SENDDATE }</b><br/></a>
         	</c:when>
         	<c:otherwise>
         	<a href="${pageContext.servletContext.contextPath }/message/view.do?no=${c.NO}"><b style="color: red">보낸사람 : ${c.SENDER} / 내용 : ${c.CONTENT } / 받은 날짜 : ${c.SENDDATE }</b><br/></a>
         	</c:otherwise>
         </c:choose>
         </c:forEach>
         </div> 