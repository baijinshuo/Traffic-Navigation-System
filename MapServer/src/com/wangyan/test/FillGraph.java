package com.wangyan.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;
import com.wangyan.dao.NodeDao;
import com.wangyan.utils.Graph;

public class FillGraph {
	public static void fill(Graph graph) {
		NodeDao nodeDao = new NodeDao();
		List<Node> list = nodeDao.getAllNodes();

		Iterator<Node> it = list.iterator();

		int length = list.size();

		int count = 0;
		while (it.hasNext()) {
			count++;
			Node node = (Node) it.next();
			List<Node> adjoin_node = nodeDao.getAdjoinNodes(node);

			Set<ChainNode> chainNodes = new HashSet<>();

			Iterator<Node> it_adjoin_node = adjoin_node.iterator();
			while (it_adjoin_node.hasNext()) {
				Node node2 = (Node) it_adjoin_node.next();
				double dis = Distance(node.getLon(), node.getLat(), node2.getLon(), node2.getLat());
				ChainNode chainNode = new ChainNode(node2.getId(), dis);
				chainNodes.add(chainNode);
			}

			graph.getHashMap().put(node, chainNodes);
			System.out.println("%" + count * 100.0 / length);
		}
	}

	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double Distance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}
}
