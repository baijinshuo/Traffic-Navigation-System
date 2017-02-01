<%@page import="com.wangyan.bean.Node"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>

<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="initial-scale=1.0, user-scalable=no, width=device-width">

<title>地图显示</title>

<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css" />
<style type="text/css">
#OthersContainer {
	width: 20%;
}

#mapContainer {
	width: 100%;
	height: 100%;
}
</style>
<script
		src="http://webapi.amap.com/maps?v=1.3&key=0d726a05ed15d111f0a3f811bdbb9caa"></script>
<script type="text/javascript">



</script>
</head>

<body>
	<div id="mapContainer"></div>

	<script>
		
		
		var points = new Array();
		<% Object nodes = request.getAttribute("route");
			ArrayList<Node> a = (ArrayList<Node>)nodes;
			int count = a.size();
			int i = 0;
			for(;i < count;i++){
				Node node = a.get(i);
				
		%>
				points[<%=i %>] = [<%=node.getLon() %> + 0.0062, <%=node.getLat() %> + 0.001440];
		<% 
			}
		%>
		
		var map = new AMap.Map('mapContainer', {
			// 设置中心点
			center : points[0],
			// 设置缩放级别
			zoom : 14
		});
		
		map.setCenter(AMap.LngLat(points[<%= i-1 %>]));
		
		var route = new AMap.Polyline({
			path: points
		});
		
		route.setMap(map);
		
	   	marker_start = new AMap.Marker({
	          icon: "http://webapi.amap.com/images/marker_sprite.png",
	          position: points[0]
	        });
	   	marker_start.setMap(map);
	    marker_start.setLabel({//label的父div默认蓝框白底右下角显示，样式className为：amap-marker-label
	        //offset:new AMap.Pixel(50,50),//修改父div相对于maker的位置
	        content:'<%= request.getAttribute("start") %>'
	    });
	   	
	   	marker_end = new AMap.Marker({
	          icon: "http://webapi.amap.com/images/marker_sprite.png",
	          position: points[<%= i-1 %>]
	        });
	   	marker_end.setMap(map);
	   	marker_end.setLabel({//label的父div默认蓝框白底右下角显示，样式className为：amap-marker-label
	        //offset:new AMap.Pixel(50,50),//修改父div相对于maker的位置
	        content:'<%= request.getAttribute("end") %>'
	    });
	</script>
</body>

</html>