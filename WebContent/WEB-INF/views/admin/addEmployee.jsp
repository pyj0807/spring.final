<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>사원등록</h2>
<form>
	<div class="form-group">
		<label>이름</label> <input
			type="text" class="form-control" placeholder="Example input">
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-md-6">
		<label>부서명</label>
				<select class="form-control" name="deparment" >
					<c:forEach var="deparments" items="${de }">
						<option value="${deparments.DID}">${deparments.DNAME }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6">
			<label>직책</label>
				<select class="form-control">
					
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label>입사 일짜</label> <input
			type="date" class="form-control" placeholder="Another input">
	</div>
	<div class="form-group">
		<button type="submit"  class="form-control btn btn-outline-primary">사원등록</button>
	</div>
</form>