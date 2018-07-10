<%@ page language="java" import="java.util.*" %>

<%@ page language="java" import="com.ljw.spring.mybits.test.*" %>
<%@ page language="java" import="com.ljw.spring.mybits.util.*" %>

<%

	
	String contid = request.getParameter("contid");
	out.println("*******contid="+contid+";");
	
	String string = "";
	
	LjwTestManager ljwTestManager = (LjwTestManager) ServerApplicationContextUtil.getApplicationContext().getBean("ljwTestManager");
	int j = ljwTestManager.getJ();
	int i = ljwTestManager.getI();
	int temp =i;
	if(contid.equals("1")){
		
		ljwTestManager.update("key"+j, "value"+j);
		string =ljwTestManager.get("key"+j);
		ljwTestManager.setJ(j+1);
	}else if(contid.equals("0")){
		for(;i<temp+20;i++){
			ljwTestManager.update("key"+i, "value"+i);
		}
		
		ljwTestManager.setI(i);
	}
	
	

	out.println("j"+j+"*************11:"+string);
%>

‘
