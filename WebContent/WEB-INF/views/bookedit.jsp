<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<title>图书管理</title>
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
	<%@ include file="nav.jsp"%>

	<div class="col-sm-8 col-sm-offset-2">
		<div class="page-header">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 style="text-align: center" class="panel-title">图书管理系统</h3>
				</div>
				<div class="panel-body">
					<form id="sigroupForm" method="post" class="form-horizontal"
						action="/bookedit">
						<input type="hidden" name="id" value="${book.id}">

						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">编号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="code" name="code"
									placeholder="请输入书籍编号" value="${book.code}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="title">书名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="请输入书名" value="${book.title}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="author">作者</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="请输入作者" value="${book.author}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="publishing">出版社</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="publishing"
									name="publishing" placeholder="请输入出版社"
									value="${book.publishing}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="total">数量</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="total" name="total"
									placeholder="请输入总数" value="${book.total}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="count">剩余数量</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="count" name="count"
									placeholder="请输入数量" value="${book.count}" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button style="text-align: right" type="submit"
									class="btn btn-primary" name="signup" value="修改">修改</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="starter-template">
			<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
			<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
			<script
				src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
			<script>
				$("#book").addClass("active");
				$(function() {
					$("#sigroupForm").validate({
						rules : {
							code : "required",
							title : "required",
							author : "required",
							publishing : "required",
							total : {
								required : true,
								digits : true
							},
							count : {
								required : true,
								digits : true
							}

						},
						messages : {
							code : "",
							title : "",
							author : "",
							publishing : "",
							total : "",
							count : ""
						},

					});
				})
			</script>
		</div>

	</div>
</body>
</html>