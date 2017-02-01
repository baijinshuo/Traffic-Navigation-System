package com.wangyan.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.wangyan.bean.Node;
import com.wangyan.dao.NodeDao;
import com.wangyan.dijkstra.Algorithm;
import com.wangyan.dijkstra.Dot;
import com.wangyan.test.FillGraph;
import com.wangyan.utils.Graph;

public class routeAction implements RequestAware, ApplicationAware{
	private static Graph g = new Graph();

	private Map<String, Object> request;
	private Map<String, Object> application; 
	private Map<String, Object> dataMap;

	static {
		FillGraph.fill(g);
	}
	
	

	private String startpoint;
	private String endpoint;

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String execute() {
		dataMap = new HashMap<>();
		String sp = this.getStartpoint();
		String ep = this.getEndpoint();
		
		List<Node> nodes;
		if(application.containsKey(sp + "-" + ep)){
			nodes = (List<Node>) application.get(sp + "-" + ep);
		} else {
			nodes = new ArrayList<>();
			
			Algorithm algorithm = new Algorithm();
			algorithm.calculate(sp, ep, g);
			List<Dot> dots = algorithm.dotPathList;
			
			Iterator<Dot> it = dots.iterator();
			NodeDao nd = new NodeDao();
			while (it.hasNext()) {
				Dot dot = (Dot) it.next();
				Node node = nd.getNodeById(dot.getId());
				nodes.add(node);
			}
			
			application.put(sp + "-"+ ep, nodes);
		}
		
		
//		Node node1 = nd.getNodeByName(sp);
//		Node node2 = nd.getNodeByName(ep);
//		nodes.add(node1);
//		nodes.add(node2);
//		System.out.println(nodes);
//		dataMap.put("nodes", nodes);
		
		// Gson gson = new Gson();
		// String result = gson.toJson(nodes);
		 request.put("route", nodes);
		 request.put("start", startpoint);
		 request.put("end", endpoint);
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

}
