<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link active" href="#"> <span
					data-feather="home"></span> Dashboard <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="file"></span> Orders
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="shopping-cart"></span> Products
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="users"></span> Customers
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="bar-chart-2"></span> Reports
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <span
					data-feather="layers"></span> Integrations
			</a></li>
		</ul>
		<h6
			class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
			<span>Saved reports</span> <a
				class="d-flex align-items-center text-muted" href="#"> <span
				data-feather="plus-circle"></span>
			</a>
		</h6>
		<ul class="nav flex-column mb-2">
		<li class="nav-item"><a class="nav-link" href="#"> <span
				data-feather="file-text"></span> Current month
		</a></li>
		<li class="nav-item"><a class="nav-link" href="#"> <span
				data-feather="file-text"></span> Last quarter
		</a></li>
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
		
		var reLoginAlertHandel = function(obj){
			window.alert("다른 기기에서 접속이 되었습니다");
			document.getElementById("alert").innerHTML += html;
		}
		
	</script>
	
</div>
















