<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/taglibs.jsp"%>
<html>

<head>
</head>

<body>
	<form action="addObj" method="post">
		<table width="40%" border="1" cellpadding="2" cellspacing="0" align="center">
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>岗位：</td>
				<td><input type="text" name="job"></td>
			</tr>
			<tr>
				<td>工资：</td>
				<td><input type="text" name="sal"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>

</html>