package com.wangyan.dijkstra;


import java.util.List;

import com.wangyan.bean.Node;
import com.wangyan.dao.RelationDao;

public class GetBus {
	
	public List<Node> getBus(String no){
		
		RelationDao rd = new RelationDao();
		Bus bus = rd.getBus(no);
		return bus.getList();
		
	}
}
