<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请输入公交线路</title>
</head>
<body>
	<s:form action="search_bus.do">
		<s:textfield name="busNo" label="公交线路" value="59"></s:textfield>
		<s:submit value="查询"></s:submit>
	</s:form>
</body>
</html>