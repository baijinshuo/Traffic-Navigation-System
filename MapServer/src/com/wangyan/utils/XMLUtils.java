package com.wangyan.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Node;
import com.wangyan.bean.NodeInfo;
import com.wangyan.bean.Relation;
import com.wangyan.bean.RelationContent;
import com.wangyan.bean.RelationInfo;
import com.wangyan.bean.Way;
import com.wangyan.bean.WayInfo;
import com.wangyan.dao.NodeDao;
import com.wangyan.dao.RelationDao;
import com.wangyan.dao.WayDao;

public class XMLUtils {

	@Test
	public static void analyseNode(Element element) throws Exception {
		Node node = new Node();

		Attribute attribute = element.attribute("id");
		node.setId(attribute.getText());

		attribute = element.attribute("lat");
		node.setLat(Double.parseDouble(attribute.getText()));

		attribute = element.attribute("lon");
		node.setLon(Double.parseDouble(attribute.getText()));

		attribute = element.attribute("version");
		node.setVersion(Integer.parseInt(attribute.getText()));

		attribute = element.attribute("timestamp");
		Date timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(attribute.getText());
		node.setTime(timestamp);

		attribute = element.attribute("changeset");
		node.setChangeset(attribute.getText());

		attribute = element.attribute("uid");
		node.setUid(attribute.getText());

		attribute = element.attribute("user");
		node.setUser(attribute.getText());

		Set<NodeInfo> infoList = getNodeInfo(element);

		Iterator<NodeInfo> it = infoList.iterator();
		while (it.hasNext()) {
			NodeInfo nodeInfo = (NodeInfo) it.next();
			nodeInfo.setNode(node);
		}

		NodeDao nodeDao = new NodeDao();
		nodeDao.saveNode(node, infoList);
	}

	private static Set<NodeInfo> getNodeInfo(Element element) {

		Set<NodeInfo> set = new HashSet<>();

		Iterator<Element> it = element.elementIterator();
		while (it.hasNext()) {
			Element tag = (Element) it.next();
			NodeInfo nodeInfo = new NodeInfo();
			Attribute tagAttribute = tag.attribute("k");
			nodeInfo.setInfo_key(tagAttribute.getText());
			tagAttribute = tag.attribute("v");
			nodeInfo.setInfo_value(tagAttribute.getText());
			set.add(nodeInfo);
		}

		return set;
	}

	public static void analyseWay(Element element) throws ParseException {
		Way way = new Way();

		Attribute attribute = element.attribute("id");
		way.setId(attribute.getText());

		attribute = element.attribute("version");
		way.setVersion(Integer.parseInt(attribute.getText()));

		attribute = element.attribute("timestamp");
		Date timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(attribute.getText());
		way.setTime(timestamp);

		attribute = element.attribute("changeset");
		way.setChangeset(attribute.getText());

		attribute = element.attribute("uid");
		way.setUid(attribute.getText());

		attribute = element.attribute("user");
		way.setUser(attribute.getText());

		Set<WayInfo> infoSet = way.getInfos();

		List<String> wayNodes = new ArrayList<>();

		Iterator<Element> it = element.elementIterator();

		while (it.hasNext()) {
			Element tag = (Element) it.next();

			if (tag.getName().equals("nd")) {
				Attribute ref = tag.attribute("ref");
				// NodeDao nodeDao = new NodeDao();
				// Node node = nodeDao.getNodeById(ref.getText());
				// Node node = new Node(ref.getText());
				wayNodes.add(ref.getText());
			} else if (tag.getName().equals("tag")) {
				WayInfo wayInfo = new WayInfo();
				Attribute tagAttribute = tag.attribute("k");
				wayInfo.setInfo_key(tagAttribute.getText());
				tagAttribute = tag.attribute("v");
				wayInfo.setInfo_value(tagAttribute.getText());
				infoSet.add(wayInfo);
			}
		}
		WayDao wayDao = new WayDao();
		wayDao.saveWay(way, wayNodes);
	}

	public static void analyseRelation(Element element) throws Exception {
		Relation relation = new Relation();

		Attribute attribute = element.attribute("id");
		relation.setId(attribute.getText());

		attribute = element.attribute("version");
		relation.setVersion(Integer.parseInt(attribute.getText()));

		attribute = element.attribute("timestamp");
		Date timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(attribute.getText());
		relation.setTime(timestamp);

		attribute = element.attribute("changeset");
		relation.setChangeset(attribute.getText());

		attribute = element.attribute("uid");
		relation.setUid(attribute.getText());

		attribute = element.attribute("user");
		relation.setUser(attribute.getText());

		Set<RelationInfo> infoSet = relation.getInfos();
		
		List<RelationContent> contentList = relation.getContents();
		
		
		Iterator<Element> it = element.elementIterator();

		while (it.hasNext()) {
			Element tag = (Element) it.next();

			if (tag.getName().equals("member")) {
				RelationContent relationContent = new RelationContent();
				
				Attribute type = tag.attribute("type");
				Attribute ref = tag.attribute("ref");
				Attribute role = tag.attribute("role");

				relationContent.setType(type.getText());
				relationContent.setId(ref.getText());
				relationContent.setRole(role.getText());
				relationContent.setRelation(relation);
				
				contentList.add(relationContent);
			} else if (tag.getName().equals("tag")) {
				RelationInfo relationInfo = new RelationInfo();
				Attribute k = tag.attribute("k");
				Attribute v = tag.attribute("v");

				relationInfo.setInfo_key(k.getText());
				relationInfo.setInfo_value(v.getText());
				
				infoSet.add(relationInfo);
			}
		}

		RelationDao relationDao = new RelationDao();
		relationDao.saveRelation(relation);
	}

	private static Set<RelationInfo> getRelationInfo(Element element) {

		Set<RelationInfo> set = new HashSet<>();

		Iterator<Element> it = element.elementIterator();
		while (it.hasNext()) {
			Element tag = (Element) it.next();
			RelationInfo relationInfo = new RelationInfo();
			Attribute tagAttribute = tag.attribute("k");
			relationInfo.setInfo_key(tagAttribute.getText());
			tagAttribute = tag.attribute("v");
			relationInfo.setInfo_value(tagAttribute.getText());
			set.add(relationInfo);
		}

		return set;
	}

}
