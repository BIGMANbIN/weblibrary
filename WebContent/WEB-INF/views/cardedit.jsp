<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="col-sm-8 col-sm-offset-2">
		<div class="page-header">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 style="text-align: center" class="panel-title">会员系统</h3>
				</div>
				<div class="panel-body">
					<form id="sigroupForm" method="post" class="form-horizontal"
						novalidate="novalidate" action="cardedit">
						<input type="hidden" value="${card.id}" name="id"/>
						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">卡号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="code" name="code"
									placeholder="请输入卡号" value="${card.code}"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="name">姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="请输入姓名" value="${card.name}"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="tel">电话</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="tel" name="tel"
									placeholder="请输入电话" value="${card.tel}"/>
							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button style="text-align:right" type="submit" class="btn btn-primary" name="signup"
									value="修改">修改</button>
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
			<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
			<script>
					$("#card").addClass("active");
				$(function() {
					$("#sigroupForm").validate({
						rules : {
							code : "required",
							name : "required",
							tel : "required"
						},
						messages : {
							code : "",
							name : "",
							tel : ""
						}, 
						
					});
				})
			</script>
		</div>

	</div>
</body>
</html>