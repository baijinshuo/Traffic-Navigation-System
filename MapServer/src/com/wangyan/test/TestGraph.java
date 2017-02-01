package com.wangyan.test;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;
import com.wangyan.dao.ChainNodeDao;
import com.wangyan.dijkstra.Algorithm;
import com.wangyan.utils.FileUtils;
import com.wangyan.utils.Graph;

public class TestGraph {
	@Test
	public void test() throws Exception {
		Graph g = new Graph();
		FillGraph.fill(g);
//		Algorithm algorithm = new Algorithm();
//		
//		algorithm.caculate(g, new Node("266198501"), new Node("506241617"));
//		Map<String, String> path = algorithm.getPath();
//		Set<String> keys = path.keySet();
//		Iterator<String> it = keys.iterator();
//		
//		while (it.hasNext()) {
//			String string = (String) it.next();
//			System.out.println(string);
//		}
		
		Set<Node> set = g.getHashMap().keySet();
		Iterator<Node> it = set.iterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			ChainNodeDao cnd = new ChainNodeDao();
			cnd.save(node, g.getHashMap().get(node));
		}
		
		FileUtils.Write(g);
//		Map<Node, Set<ChainNode>> hashMap = g.getHashMap();
//		Iterator<Node> it =hashMap.keySet().iterator();
//		
//		while (it.hasNext()) {
//			Node node = (Node) it.next();
//			System.out.print(node + "::");
//			
//			Set<ChainNode> chainNodes = hashMap.get(node);
//			System.out.println(chainNodes);
//		}
		
		
	}
}
