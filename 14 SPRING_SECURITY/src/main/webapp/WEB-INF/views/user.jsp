<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>USER PAGE</h1>

principal : <sec:authentication property="principal"/><hr/>
UserDto : <sec:authentication property="principal.user"/><hr/>
UserName : <sec:authentication property="principal.user.username"/><hr/>
ROLE : <sec:authentication property="principal.user.role"/><hr/>




<form action="${pageContext.request.contextPath }/logout" method="post">
	<button>로그아웃</button>
</form>


</body>
</html>