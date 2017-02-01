package com.wangyan.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.wangyan.utils.Graph;

public class Algorithm {

	private final double MAX = 100000;
	MapBuilder mapBuilder = new MapBuilder();
	Set<Dot> S = new HashSet<>();
	Set<Dot> U = new HashSet<>();
	Dot e = new Dot("end");
	Dot s = new Dot("start");
	Map<String, Double> dis = new HashMap<String, Double>();// 封装距离
	Map<String, String> path = new HashMap<String, String>();// 封装路径
	@SuppressWarnings("rawtypes")
	Map<String, ArrayList> dotPath = new HashMap<String, ArrayList>();// 封装路径
	public ArrayList dotPathList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public void calculate(String start, String end, Graph g) {

		s.setId(start);
		e.setId(end);
		mapBuilder.build(s, U, S, g);
		int flag = mapBuilder.dotList.indexOf(new Dot(start));
		s = (Dot) mapBuilder.dotList.get(flag);
		for (int i = 0; i < mapBuilder.dotList.size(); i++) {
			if (i == mapBuilder.dotList.indexOf(start))
				;
			else {
				dis.put(((Dot) mapBuilder.dotList.get(i)).getId(),
						mapBuilder.Distance[mapBuilder.dotList.indexOf(s)][i]);
				path.put(((Dot) mapBuilder.dotList.get(i)).getId(), s.getId()
						+ ">" + ((Dot) mapBuilder.dotList.get(i)).getId());
			}

		}
		computePath(s);
		String str_path = path.get(e.getId());
		while (str_path.indexOf(">") != -1) {
			dotPathList.add(new Dot(
					str_path.substring(0, str_path.indexOf(">"))));
			str_path = str_path.substring(str_path.indexOf(">") + 1);
		}
		dotPathList.add(new Dot(str_path));
		dotPath.put(s.getId(), dotPathList);
		System.out.println("terminate:" + e.getId());// 路径
		System.out.println("path");
		for (int i = 0; i < dotPathList.size(); i++) {
			System.out.println(((Dot) (dotPathList.get(i))).getId());
		}

	}

	public void computePath(Dot start) {
		Dot nearest = getShortestPath(start);// 取距离start节点最近的子节点,放入close
		if (nearest == null) {
			return;
		}
		S.add(nearest);
		U.remove(nearest);
		if (S.contains(e)) {
			return;
		}
		Map<Dot, Double> childs = nearest.getChild();
		for (Dot child : childs.keySet()) {
			if (U.contains(child)) {// 如果子节点在open中
				double newCompute = dis.get(nearest.getId())
						+ childs.get(child);
				if (dis.get(child.getId()) > newCompute) {
					dis.put(child.getId(), newCompute);
					path.put(child.getId(), path.get(nearest.getId()) + ">"
							+ child.getId());
				}
			}
		}
		computePath(start);
		computePath(nearest);// 递归
	}

	private Dot getShortestPath(Dot dot) {
		Dot res = null;
		Double minDis = Double.MAX_VALUE;
		Map<Dot, Double> childs = dot.getChild(); //
		for (Dot child : childs.keySet()) { // dot点所有链接结点
			if (U.contains(child)) {
				Double distance = childs.get(child);
				if (distance < minDis) {
					minDis = distance;
					res = child;
				}
			}
		}		
		return res;
	}
}
