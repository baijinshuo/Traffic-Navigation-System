package com.wangyan.dijkstra;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;
import com.wangyan.utils.Graph;


public class MapBuilder {  
    @SuppressWarnings("resource")
    Double[][] Distance;//=new Double[100][100];
    ArrayList dotList=new ArrayList();
    int start_flag=0;

	public void build(Dot start, Set<Dot> U, Set<Dot> S,Graph g){  	
		Set<Node> set = g.getHashMap().keySet();
		Distance = new Double[set.size()][set.size()];
		
		for(int i=0;i<set.size();i++)
			for(int j=0;j<set.size();j++)
			{
				if(i==j)
					Distance[i][j]=(double) 0;
				else
					Distance[i][j]=Double.MAX_VALUE;
			}
		Iterator<Node> it = set.iterator();
		while (it.hasNext()) {
			Node node = (Node) it.next();
			Dot dot = new Dot(node.getId());
			dotList.add(dot);
			
			Set<ChainNode> set1 = g.getHashMap().get(node);
			Iterator<ChainNode> it_1 = set1.iterator();
			int index = 0;
			while (it_1.hasNext()) {
				ChainNode chainNode = (ChainNode) it_1.next();
				dot.getChild().put(dot, chainNode.getLength());
				Distance[index][dotList.indexOf(new Dot(chainNode.getNodeId()))] = chainNode.getLength();
				index++;
			}
			U.add(dot);
		}
		U.remove(start);
		S.add(start);
		
	
	}
    
}  