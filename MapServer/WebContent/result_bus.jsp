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
	src="http://webapi.amap.com/maps?v=1.3&key=0d726a05ed1jhg111f0a3f811bdbb9cab"></script>
	<!-- 这里是我在高德地图申的一个key,因为我已经用了，不知道你还能不能用，你可以试一试，如果不行的话你可以自己申一个试一试 -->
<script type="text/javascript">



</script>
</head>

<body>
	<div id="mapContainer"></div>

	<script>
		
		
		var points = new Array();
		<% Object nodes = request.getAttribute("route");
			ArrayList<Node> a = (ArrayList<Node>)nodes;
			System.out.println("###"+a);
			int count = a.size();
			int i = 0;
			for(;i < count;i++){
				Node node = a.get(i);
				if(node != null){
					

				
		%>
				points[<%=i %>] = [<%=node.getLon() %> + 0.0062, <%=node.getLat() %> + 0.001440];
		<% 		}
			}
		%>
		
		var map = new AMap.Map('mapContainer', {
			// 设置中心点
			center : points[0],
			// 设置缩放级别
			zoom : 14
		});
		
		map.setCenter(AMap.LngLat(points[<%= i-1 %>]));
		
		
		for(m=0;m<<%= i-1 %>;m++){
	   	marker_start = new AMap.Marker({
	          icon: "http://webapi.amap.com/images/marker_sprite.png",
	          position: points[m]
	        });
	   	marker_start.setMap(map);
			
		}		
	</script>
</body>

</html>