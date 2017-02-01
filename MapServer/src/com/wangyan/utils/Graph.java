package com.wangyan.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;

public class Graph {
	Map<Node, Set<ChainNode>> hashMap = new HashMap<>();

	public Map<Node, Set<ChainNode>> getHashMap() {
		return hashMap;
	}

	public void setHashMap(Map<Node, Set<ChainNode>> hashMap) {
		this.hashMap = hashMap;
	}
}
