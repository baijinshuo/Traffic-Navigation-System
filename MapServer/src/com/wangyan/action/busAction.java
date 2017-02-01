package com.wangyan.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.wangyan.bean.Node;
import com.wangyan.dijkstra.GetBus;
import com.wangyan.utils.Graph;

public class busAction implements RequestAware{
	private static Graph g = new Graph();

	private Map<String, Object> request;
	private Map<String, Object> dataMap;

	static {
		// FillGraph.fill(g);
		System.out.println("tada!!!!");
	}
	
	private String busNo;

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	@Override
	public void setRequest(Map<String, Object> req) {
		// TODO Auto-generated method stub
		this.request = req;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
	public String execute() {
		dataMap = new HashMap<>();
		String no = this.getBusNo();
		
		System.out.println("Roger That");
		
		List<Node> nodes = new GetBus().getBus(no);
		System.out.println("!!!!"+nodes);
		request.put("route", nodes);
		return "success";
	}
	
}
