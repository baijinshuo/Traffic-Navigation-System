package com.wangyan.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.wangyan.bean.Node;
import com.wangyan.dao.NodeDao;

public class TestNodeDao {
	
	@Test
	public void testName() throws Exception {
		NodeDao nodeDao = new NodeDao();
		List<Node> list = nodeDao.getAllNodes();
		
		Iterator<Node> it = list.iterator();
		
		while (it.hasNext()) {
			Node node = (Node) it.next();
			System.out.println(node);
		}
	}
}
