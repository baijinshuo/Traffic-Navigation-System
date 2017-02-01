package com.wangyan.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.wangyan.bean.ChainNode;
import com.wangyan.bean.Node;
import com.wangyan.utils.HibernateUtils;

public class ChainNodeDao {
	private Session session;

	public void save(Node node, Set<ChainNode> chainNodes) {
		session = HibernateUtils.getSession();

		//String hql = "";

		try {
			session.beginTransaction();
			// ===============================
			node = (Node) session.get(Node.class, node.getId_key());
			Iterator<ChainNode> it = chainNodes.iterator();
			while (it.hasNext()) {
				ChainNode chainNode = (ChainNode) it.next();
				node.getChainNodes().add(chainNode);
				chainNode.setNode(node);
			}
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}
}
