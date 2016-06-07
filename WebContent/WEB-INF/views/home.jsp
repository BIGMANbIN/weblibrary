<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<title>会员卡管理</title>


<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">


<link href="starter-template.css" rel="stylesheet">


<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<style>
body {
	padding-top: 60px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>


	<%@ include file="nav.jsp"%>

	<div class="container">
	<c:choose>
		<c:when test="${'100'==param.msg}">
			<div class="alert alert-success alert-dismissible fade in"
			role="alert"><strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button>
			借书成功!</strong></div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${'200'==param.msg}">
			<div class="alert alert-success alert-dismissible fade in"
			role="alert"><strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button>
			还书成功!</strong></div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${'101'== param.msg}">
			<div class="alert alert-warning alert-dismissible fade in"
			role="alert"><strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button>
			借书失败!</strong></div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${'201'==param.msg}">
			<div class="alert alert-warning alert-dismissible fade in"
			role="alert"><strong>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button>
			还书失败!</strong></div>
		</c:when>
	</c:choose>
		<div class="starter-template">
			<h1 style="color: red">欢迎登陆图书管理系统!</h1>
		</div>

	
	<div class="col-sm-8 col-sm-offset-2">
		<div class="page-header">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2 style="text-align: center" class="panel-title">借书</h2>
				</div>
				<div class="panel-body">
					<form id="borrowForm" method="post" class="form-horizontal"
						action="borrowbook">
						<div class="form-group">
							<label class="col-sm-4 control-label" for="cardcode">卡号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="cardcode" name="cardcode"
									placeholder="请输入借书证卡号" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="bookcode">书号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="bookcode" name="bookcode"
									placeholder="请输入书籍编号" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button style="text-align:right" type="submit" class="btn btn-primary" name="signup"
									value="提交">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-8 col-sm-offset-2">
		<div class="page-header">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2 style="text-align: center" class="panel-title">还书</h2>
				</div>
				<div class="panel-body">
					<form id="backForm" method="post" class="form-horizontal"
						action="backbook">
						<div class="form-group">
							<label class="col-sm-4 control-label" for="cardcode">卡号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="cardcode" name="cardcode"
									placeholder="请输入借书证卡号" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="bookcode">书号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="bookcode" name="bookcode"
									placeholder="请输入书籍编号" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button style="text-align:right" type="submit" class="btn btn-primary" name="signup"
									value="提交">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
	<script>
		$(function(){
			$("#home").addClass("active");
			$("#borrowForm").validate({
				rules : {
					bookcode : "required",
					cardcode : "required",
					
				},
				messages : {
					bookcode : "",
					cardcode : "",
					
				}, 
				errorElement : "span",
				highlight : function(element, errorClass,
						validClass) {
					$(element).parents(".col-sm-5").addClass(
							"has-error").removeClass(
							"has-success");
				},
				unhighlight : function(element, errorClass,
						validClass) {
					$(element).parents(".col-sm-5").addClass(
							"has-success").removeClass(
							"has-error");
				}
		})
		$("#backForm").validate({
				rules : {
					bookcode : "required",
					cardcode : "required",
					
				},
				messages : {
					bookcode : "",
					cardcode : "",
					
				}, 
				errorElement : "span",
				highlight : function(element, errorClass,
						validClass) {
					$(element).parents(".col-sm-5").addClass(
							"has-error").removeClass(
							"has-success");
				},
				unhighlight : function(element, errorClass,
						validClass) {
					$(element).parents(".col-sm-5").addClass(
							"has-success").removeClass(
							"has-error");
				}
		})
	})	
	
	
	</script>
</body>
</html>
