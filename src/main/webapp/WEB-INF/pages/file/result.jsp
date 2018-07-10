<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/taglibs.jsp"%>
<html>
<head>

<title>上传结果</title>
</head>
<body style="font-size: 30px; font-style: italic;" >
	<c:if test="${fileUrl != null}">
		<a href="${fileUrl}">查看</a>
	</c:if>
	<ul>
		<li><a href="${fileUrl}">查看</a></li>
	</ul>
</body>
</html>