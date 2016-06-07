<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<title>会员卡管理</title>


<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">


<link href="starter-template.css" rel="stylesheet">

<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>


	<%@ include file="nav.jsp" %>

	<div class="container">

		<div class="starter-template">


<a style="float:right" href="/cardadd" class="btn btn-primary">新建借书卡</a>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>编号</th>
			<th>卡号</th>
			<th>姓名</th>
			<th>电话</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var = "cd" items="${requestScope.list}">
		<tr>
			<th scope="row">${cd.id}</th>
			<td>${cd.code}</td>
			<td>${cd.name}</td>
			<td>${cd.tel}</td>
			<td>
				<button data="${cd.id}" type="button" class="btn btn-danger btn-xs">删除</button>
				<button data="${cd.id}" type="button" class="btn btn-success btn-xs">修改</button>
			</td>
		</tr>
	</c:forEach>
			
	</tbody>
</table>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	$(function() {
	$("td>button.btn-danger").click(function(){
		if(confirm("确认删除吗？")){
		var i = $(this).attr("data");
		location.href = "/carddel?id=" + i;
		}
		
	});
	$("td>button.btn-success").click(function(){
		var i = $(this).attr("data");
		location.href = "/cardedit?id=" + i;
		
	});
		$("#card").addClass("active");
 });
	 
		
</script>
</body>
</html>

