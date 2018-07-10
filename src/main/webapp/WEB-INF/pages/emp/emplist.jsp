<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/taglibs.jsp"%>
<html>
	<head>

		<meta charset="utf-8"/>
	    <title>欢迎-admin</title>
	    
	    <!-- 导入jquery，可以进行ajax请求 -->
		<script type="text/javascript" src="<c:url value="../resources/jquery/jquery.js"/>"></script>
		<script type="text/javascript">
			function delete_emp(id){
				var r=window.confirm("确定要删除此数据么？");
				if(r){
					location.href="delete?id="+id;
				}
			}
		</script>
	</head>
	
	<body>
		<!-- http://localhost:8080/spring-mybits/emp/findEmp -->
		<table width="60%" border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>JOB</th>
				<th>MGR</th>
				<th>HIREDATE</th>
				<th>SAL</th>
				<th>COMM</th>
				<th>DEPTNO</th>
				<th>BUTTON</th>
			</tr>
			<c:forEach items="${elist}" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.sal}</td>
					<td>${emp.comm}</td>
					<td>${emp.deptno}</td>	
					<td align="center"> 
						<input type="button" value="修改" onclick="location.href='toUpdate?id=${emp.empno}'">
						<input type="button" value="删除" onclick="delete_emp(${emp.empno})">
					</td>			
				</tr>
			
			</c:forEach>
		
		</table>


	</body>
</html>