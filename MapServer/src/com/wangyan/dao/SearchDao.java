package com.wangyan.dao;

import java.util.List;

import org.hibernate.Session;

import com.wangyan.bean.Node;

public class SearchDao {
	private Session session;
	
	public static List<Node> findAdjoinNode(Node node){
		NodeDao nodeDao = new NodeDao();
		return null;
	}
}
