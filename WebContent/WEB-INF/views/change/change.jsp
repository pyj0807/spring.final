<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form class="form-signin" action=""${pageContext.servletContext.contextPath }/final/change.do" method="post"">
      <div class="text-center mb-4">
        <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">My Page</h1>
      </div>

      <div class="form-label-group">
        <label for="inputEmail">아이디</label>
        <input type="email" id="id" class="form-control" placeholder="Id" required autofocus>
      </div>

      <div class="form-label-group">
        <label for="inputPassword">비번</label>
        <input type="password" id="pw" class="form-control" placeholder="Password" required>
      </div>
      <div class="form-label-group">
        <label for="inputPassword">변경비번</label>
        <input type="password" id="repw" class="form-control" placeholder="RePassword" required>
      </div>
	
	  <hr/>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">변경</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
</body>
</html>