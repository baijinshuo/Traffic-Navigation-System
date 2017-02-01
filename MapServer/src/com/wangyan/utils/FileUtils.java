package com.wangyan.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;

public class FileUtils {
	public static void Write(Graph g){
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("abc.graph"));
			BufferedWriter bw = new BufferedWriter(fw);
			
			Map<Node, Set<ChainNode>> hashMap = g.getHashMap();
			Iterator<Node> it =hashMap.keySet().iterator();
			
			while (it.hasNext()) {
				Node node = (Node) it.next();
				bw.write(node + "::");
				
				//System.out.print(node + "::");
				
				Set<ChainNode> chainNodes = hashMap.get(node);
				bw.write(chainNodes + "");
				//System.out.println(chainNodes);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fw != null){
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
