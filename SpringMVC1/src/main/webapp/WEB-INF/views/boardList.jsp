<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC01</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">	<!-- viewport는 반응형 웹페이지 만들때 사용  -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> <!-- bootstrap에서 제공하는 css를 사용하겠다 -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>  <!-- jquery를 사용하겠다  -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> <!-- bootstrap에서 제공하는 javascript를 사용하겠다 -->
</head>
<body>
 
<div class="container">
  <h2>Spring MVC01</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body">
    	<table class="table table-bordered table-hover">
    		<tr>
    			<td>번호</td>
    			<td>제목</td>
    			<td>작성자</td>
    			<td>작성일</td>
    			<td>조회수</td>
    		</tr>
    		<c:forEach var="vo" items="${list}">
	    		<tr>
	    			<td>${vo.idx}</td>
	    			<td><a href="boardContent.do?idx=${vo.idx}">${vo.title}</a></td>
	    			<td>${vo.writer}</td>
	    			<td>${fn:split(vo.indate," ")[0]}</td>
	    			<td>${vo.count}</td>
	    		</tr>    		
    		</c:forEach>
    	</table>
    	<!-- <button class="btn btn-primary btn-sm">글쓰기</button> -->
    	<!-- boardForm.do 앞에 /를 넣으면 안된다. /를 넣으면 contextpath가 없는 localhost:8081/boardForm.do가 호출됨 -->
    	<!-- <a href="/m01/boardForm.do" class="btn btn-primary btn-sm">글쓰기</a> 이렇게는 가능	 -->
    	<a href="boardForm.do" class="btn btn-primary btn-sm">글쓰기</a>
    </div>
    <div class="panel-footer">인프런_스프1탄_김태수</div>
  </div>
</div>

</body>
</html>
