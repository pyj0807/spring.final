<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr/>
<hr/>
<hr/>	

<form action="<%=application.getContextPath()%>/message/message.do">
		<p>
			받을사람(*)<br/> 
			<input type="text" placeholder="write a receiver"
			style="width: 220px; padding: 5px;" name="receiver" />
		</p>
		<p>
			보낼내용(*)<br/>
			<textarea name="content" style="height: 170px; width: 220px; 
			padding: 5px; resize: none; font-family: inherit;" placeholder="write a message"></textarea>
		</p>
		<button type="submit">메세지 전송</button>
	</form>
	
</body>
</html>