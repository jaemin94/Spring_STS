<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 연결 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Axios Cdn -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
	integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
	
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ShowMemo</h1>
	<div class="showMemo">
	<c:forEach items="${list }" var="dto">
	<span>${dto.id }</span> &nbsp;&nbsp;<span>${dto.text }</span><br/>
	</c:forEach>
	</div>
	<hr>


</body>
</html>