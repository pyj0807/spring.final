<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link active" href="${pageContext.servletContext.contextPath }/index.do"> <span
					data-feather="home"></span> Dashboard <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="file"></span> Orders
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="shopping-cart"></span> Customers
			</a></li>
		</ul>
		<hr/>
		<h6
			class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
			<span>My Page</span> <a
				class="d-flex align-items-center text-muted" href="#"> <span
				data-feather="plus-circle"></span>
			</a>
		</h6>
		<ul class="nav flex-column mb-2">
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/change.do"> 
		<span data-feather="file-text"></span> 비밀번호 변경</a>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/message/box.do"> 
		<span data-feather="file-text"></span> 쪽지함</a>	
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/message/send.do"> 
		<span data-feather="file-text"></span> 쪽지보내기</a>	
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/chat/room.do"> 
		<span data-feather="file-text"></span> 채팅방</a>		
	</ul>
	<hr/>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>Saved reports</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<div id="alert" style="font-size: .75em">
	
	</div>
	
	<script>
		
		var ws = new WebSocket("ws://"+location.host+"${pageContext.servletContext.contextPath}/alert.do");
		ws.onmessage = function(evt) {
			console.log(evt.data);
			var obj = JSON.parse(evt.data);
			switch(obj.mode) {
			case "login":
				loginAlertHandle(obj);
				break;
			case "relogin" :
				reLoginAlertHandel(obj);
				break;
			case "newtalk" :
				newtalkAlertHandel(obj);
				break;
			}
		};
		
		
		var loginAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【로그인】</strong><br/>" + obj.actor.NAME+"(" + obj.actor.DNAME+"/"+ obj.actor.PNAME+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
			
		}
		/* 
		var reLoginAlertHandel = function(obj){
			window.alert("다른 기기에서 접속이 되었습니다");
			document.getElementById("alert").innerHTML += html;
		}
		 */
		
		 
		var newtalkAlertHandel = function(obj) {
			 var html = "<div class=\"alert alert-info alert-dismissible fade show px-3 mt-4 mb-1\" role=\"alert\">";
				html += "<strong>【채팅방】</strong><br/>새로운 채팅이 있습니다.";
				html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
				html += "<span aria-hidden=\"true\">&times;</span>";
				html += "</button>";
				html += "</div>";
				document.getElementById("alert").innerHTML += html;
			}
		 
		var reLoginAlertHandel = function(obj) {
				var html = "<div class=\"alert alert-warning\" role=\"alert\">";
				html += "<strong>【중복로그인】</strong><br/>다른 기기에서 로그인되었습니다.<br/>재로그인 해주세요(새로고침)";
				html += "</div>";
				document.getElementById("alert").innerHTML += html;
				document.getElementById("alert").id="";
			}
		 
		 
		 
	</script>
	
</div>
















