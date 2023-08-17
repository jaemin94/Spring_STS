<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>FORM PAGE!</h1>
<div>${msg }</div>
<form action="${pageContext.request.contextPath}/upload/reqUpload" method="POST" enctype="multipart/form-data">
	<input type="file" name="files" />
	<input type="submit" value="upload" />

</form>
<hr>
<a href="${pageContext.request.contextPath}/upload/list">Show FILEList</a>
</body>
</html>