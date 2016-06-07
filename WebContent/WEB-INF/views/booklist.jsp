<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>图书管系统</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}

td {
	text-align: left;
}
</style>

</head>

<body>

	<%@ include file="nav.jsp"%>

	<div class="container">

		<div class="starter-template">
			<a href="bookadd" style="float: right;" class="btn btn-primary">添加书籍</a>
			<form action="/bookhome" method="get" class="navbar-form navbar-left"
				role="search">
				<div class="form-group">
					<input name="wd" type="text" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>编号</th>
						<th>书号</th>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>总数</th>
						<th>剩余数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${requestScope.list}">
						<tr>
							<th scope="row">${b.id}</th>
							<td>${b.code}</td>
							<td>${b.title}</td>
							<td>${b.author}</td>
							<td>${b.publishing}</td>
							<td>${b.total}</td>
							<td>${b.count}</td>
							<td>
								<button data="${b.id}" type="button"
									class="btn btn-danger btn-xs">删除</button>
								<button data="${b.id}" type="button"
									class="btn btn-success btn-xs">编辑</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("td>button.btn-danger").click(function() {
				if (confirm("确认删除么？")) {
					var i = $(this).attr("data");
					location.href = "/bookdel?id=" + i;
				}
			});

			$("td>button.btn-success").click(function() {
				var i = $(this).attr("data");
				location.href = "/bookedit?id=" + i;
			});

			$("#bookhome").addClass("active");
		});
	</script>
</body>
</html>
