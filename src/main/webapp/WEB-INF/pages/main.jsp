<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/common/taglibs.jsp"%>
<html>
	<head>

		<meta charset="utf-8"/>
	    <title>欢迎-admin</title>
	    
	    <!-- 导入jquery，可以进行ajax请求 -->
		<script type="text/javascript" src="<c:url value="resources/jquery/jquery.js"/>"></script>
	</head>
	
	<body>

		<script type="text/javascript" >
		var serverName = '<%=request.getServerName()%>';//主机ip
		var serverPort = '<%=request.getServerPort()%>';//服务端口
		var context_path = '<%=request.getContextPath()%>/';//服务名字
		var _webPath = 'http://' + serverName + ':' + serverPort + context_path;
		/**
		 * ajax请求
		 */
		function getData(){
			
			alert(_webPath);
			$.ajax({
				url : _webPath+ "queryMy",
				type: "POST",
				data:{
				},
				success : function(data){
					alert(data.resultCode);
					alert(data.resultDesc);
					alert(data.resultList);
				}
			 });
		}
	</script>
	<button type ="button" onclick="getData()">点击</button>
	<br>
	<br>
	<c:forEach var="element" items="${myl}" varStatus="index" >
		${element} <br>
	</c:forEach>
	

	</body>
</html>