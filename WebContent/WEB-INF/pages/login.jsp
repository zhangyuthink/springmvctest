<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
<link href="../jscss/bootstrap.min.css" rel="stylesheet">
<title>${initParam['CWebTitle']}-登陆页面</title>
<script>
	function check(){
		var userid = document.getElementById("userid").value;
		var password = document.getElementById("password").value;
		if(userid==""){
			alert("用户ID为空，请检查");
			return false;
		}
		if(password==""){
			alert("密码为空，请检查");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form class="form-horizontal" role="form" action="user/checkLogin" method="post" onSubmit="return check()">
	<div class="container">
	  <div class="form-group">
		<label for="userID" class="col-sm-2 control-label">用户名</label>
		<div class="col-sm-10">
		  <input name="userID" type="text" class="form-control" id="userID" placeholder="请输入用户名" value="${requestScope.message}">
		</div>
	  </div>
	  <div class="form-group">
		<label for="passWord" class="col-sm-2 control-label">密码(默认为123456)</label>
		<div class="col-sm-10">
		  <input name="passWord" type="password" class="form-control" id="passWord" placeholder="请输入密码">
		</div>
	  </div>
	  <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
		  <button type="submit" class="btn btn-primary">登录</button>
		</div>
	  </div>
	  <div class="form-group"><h6>未说明情况下，信息采集页面字段为必填</h6>
	  </div>
	  <div class="form-group"><h6><a href="editpass.jsp">修改密码</a></h6>
	  </div>
	</div>
	</form>
<script src="../jscss/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="../jscss/bootstrap.min.js"></script>
</body>
</html>
