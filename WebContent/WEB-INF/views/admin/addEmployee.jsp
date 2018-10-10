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
				<select class="form-control">
					<option>인사부</option>
					<option>관리부</option>
					<option>재무부</option>
					<option>개발부</option>
					<option>영업부</option>
				</select>
			</div>
			<div class="col-md-6">
			<label>직책</label>
				<select class="form-control">
					<option>사원</option>
					<option>대리</option>
					<option>과장</option>
					<option>차장</option>
					<option>부장</option>
					<option>이사</option>
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