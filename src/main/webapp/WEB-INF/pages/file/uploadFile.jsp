<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/taglibs.jsp"%>
<html>
<head>
<title>文件上传</title>
</head>
<body>
	<form action="upload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file" /><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>