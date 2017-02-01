package com.wangyan.utils;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wangyan.bean.Node;

public class XMLAnalyser {
		Element element_osm;
		
		public XMLAnalyser() throws DocumentException {
			super();
			SAXReader reader = new SAXReader();
			System.out.println("reader");
			Document document = reader.read(new File("E:\\Study\\实训\\beijing_china\\lijiang_china.osm"));
			System.out.println("document");
			element_osm = document.getRootElement();
			System.out.println(element_osm.getName());
		}
		
		
		public void analyseOSM() throws Exception{
			Iterator iterator = element_osm.elementIterator();
			//iterator.next();
			while (iterator.hasNext()) {
				Element element = (Element) iterator.next();
				
				System.out.println(element.getName());
				
				if(element.getName().equals("node")){
					XMLUtils.analyseNode(element);
				} else if (element.getName().equals("way")) {
					XMLUtils.analyseWay(element);
				} else if (element.getName().equals("relation")){
					XMLUtils.analyseRelation(element);
				} else {
					System.out.println("不解析了");
				}
			}
		}
		
		
}
