<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
<link href="${pageContext.request.contextPath}/jscss/bootstrap.min.css" rel="stylesheet">
<title>${initParam['CWebTitle']}-登出页面</title>
</head>
<body>
${requestScope.message}
<script src="${pageContext.request.contextPath}/jscss/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${pageContext.request.contextPath}/jscss/bootstrap.min.js"></script>
</body>
</html>
