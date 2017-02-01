package com.wangyan.dijkstra;

import java.util.ArrayList;
import java.util.List;

import com.wangyan.bean.Node;

public class Bus {
	private String No;
	private List<Node> list = new ArrayList<>();
	
	
	
	public Bus(String no) {
		super();
		No = no;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public List<Node> getList() {
		return list;
	}
	public void setList(List<Node> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Bus [No=" + No + ", list=" + list + "]";
	}
	
	
}
