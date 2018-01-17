<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
<link href="../jscss/bootstrap.min.css" rel="stylesheet">
<title>${initParam['CWebTitle']}-首页</title>
</head>
<body>
<a href="user/login">登陆</a>
<a href="user/logout">登出</a>
${requestScope.message}
<script src="../jscss/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="../jscss/}bootstrap.min.js"></script>
</body>
</html>
