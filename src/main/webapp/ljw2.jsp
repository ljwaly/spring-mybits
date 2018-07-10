<%@ page language="java" import="java.util.*" %>

<%@ page language="java" import="com.ljw.spring.mybits.test.*" %>
<%@ page language="java" import="com.ljw.spring.mybits.util.*" %>

<%

	
	String contid = request.getParameter("contid");
	out.println("*******contid="+contid+";");
	
	
	LjwTestManager ljwTestManager = (LjwTestManager) ServerApplicationContextUtil.getApplicationContext().getBean("ljwTestManager");
	String string =ljwTestManager.get("key"+contid);

	
	
	

	out.println("reuslt:"+string);
%>

‘
