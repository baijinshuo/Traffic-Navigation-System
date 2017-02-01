package com.wangyan.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;
import com.wangyan.bean.NodeInfo;
import com.wangyan.bean.Relation;
import com.wangyan.bean.RelationContent;
import com.wangyan.bean.RelationInfo;
import com.wangyan.bean.Way;
import com.wangyan.bean.WayInfo;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration()//
				.configure()//
				.addClass(Way.class)//
				.addClass(Node.class)//
				.addClass(NodeInfo.class)//
				.addClass(WayInfo.class)//
				.addClass(Relation.class)//
				.addClass(RelationInfo.class)//
				.addClass(RelationContent.class)//
				.addClass(ChainNode.class)//
				.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
