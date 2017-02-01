<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入起始信息</title>
</head>
<body>
	<s:form action="search.do">
		<s:textfield name="startpoint" label="起点" value="中央财经大学"></s:textfield>
		<s:textfield name="endpoint" label="终点" value="北京交通大学南门"></s:textfield>
		<s:submit value="查询"></s:submit>
	</s:form>
</body>
</html>