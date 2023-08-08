<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 연결 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Axios Cdn -->


<!DOCTYPE html>
<html>
<head>
<!-- Axios Cdn -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
	integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ShowMemo</h1>
	<div class="showMemo">
	<c:forEach items="${list }" var="dto">
	<a href="javascript:void(0)" class="memo">
	<span>${dto.id }</span> &nbsp;&nbsp;<span>${dto.text }</span><br/>
	</a>
	</c:forEach>
	</div>
	<hr>
	<h1>Post Memo</h1>
	<div class="postMemo">
		<form onsubmit="return false" name="post_form">
			<textarea name="postArea"></textarea>
			<button class="post_btn">POST</button>
		</form>
	</div>
	<hr>
		<h1>Update Memo</h1>
	<div class="updateMemo">
		<form onsubmit="return false" name="update_form">
			<input name="updateId" disabled ><br>
			<textarea name="updateArea"></textarea>
			<button class="update_btn">POST</button>
		</form>
	</div>

<script>
	// Post Memo
	const post_btn_el=document.querySelector(".post_btn");
	
	post_btn_el.addEventListener("click",function(){
		console.log("post_btn_el clicked!!");
		const postArea_el = document.post_form.postArea;
		console.log("area's value : ",postArea_el.value)
		
		// 작성한 파라미터
		const params = { text: postArea_el.value}
		// 컨테츠 타입 설정
		const axiosConfig = {headers :{"Content-Type":"application/json"}};
		// 접속할 URL
		const url="http://localhost:8080/app/memo/add";
		
		axios.post(url,params,axiosConfig)
		.then(response=>{
			alert("memo add SUCCESS!!" , response);
			location.reload();
		})
		.catch(error=>{
			alert("Memo Add Fail!!" , error);
		})
		
		
	})
	
	// update Memo
	const memo_els = document.querySelectorAll(".memo");
	memo_els.forEach((memo_el)=>{
		
		memo_el.addEventListener("click",function(){
			console.log("memo clicked.." , memo_el.children[1].innerHTML);
			const form=document.update_form;
			form.updateId.value=memo_el.children[0].innerHTML;
			form.updateArea.value=memo_el.children[1].innerHTML;
		})
	})
	
	const update_btn_el=document.querySelector(".update_btn");
	
	update_btn_el.addEventListener("click",function(){
		console.log("update_btn_el clicked!!");
		
	})
	
</script>


</body>
</html>