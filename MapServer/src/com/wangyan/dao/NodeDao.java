package com.wangyan.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.wangyan.bean.Node;
import com.wangyan.bean.NodeInfo;
import com.wangyan.bean.Way;
import com.wangyan.utils.HibernateUtils;

public class NodeDao {

	private Session session;

	public void model() {
		session = HibernateUtils.getSession();

		String hql = "";

		try {
			session.beginTransaction();
			// ===============================

			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	public Node getNodeById(String id) {
		session = HibernateUtils.getSession();

		Node node = null;

		String hql = "FROM Node n WHERE n.id=?";
		System.out.println(id);
		try {
			session.beginTransaction();
			// ===============================

			node = (Node) session.createQuery(hql)//
					.setParameter(0, id).uniqueResult();

			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return node;
	}

	public Node getNodeById(String id, Session session) {
		this.session = session;

		Node node = null;

		String hql = "FROM Node n WHERE n.id=?";
		// try {
		// session.beginTransaction();
		// ===============================

		node = (Node) session.createQuery(hql)//
				.setParameter(0, id).uniqueResult();

		// ===============================
		// session.getTransaction().commit();
		// } catch (Exception e) {
		// session.getTransaction().rollback();
		// throw e;
		// } finally {
		// session.close();
		// }

		return node;
	}

	public List<Node> getAllNodes() {
		session = HibernateUtils.getSession();

		String hql = "FROM Node";
		List<Node> nodes;

		try {
			session.beginTransaction();
			// ===============================

			nodes = session.createQuery(hql)//
					.list();
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return nodes;
	}

	public List<Node> getAdjoinNodes(Node node) {
		session = HibernateUtils.getSession();

		String hql = "SELECT w FROM Way as w JOIN w.nodes as n JOIN w.infos as i WHERE n.id=? AND i.info_key = 'highway'";
		List<Way> ways;
		List<Node> nodes = new ArrayList<>();

		try {
			session.beginTransaction();
			// ===============================

			ways = session.createQuery(hql)//
					.setParameter(0, node.getId())//
					.list();
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		Iterator<Way> it = ways.iterator();
		while (it.hasNext()) {
			Way way = (Way) it.next();
			List<Node> wayNodes = way.getNodes();
			int index = wayNodes.indexOf(node);
			if(index != wayNodes.size() - 1){
				nodes.add(wayNodes.get(index + 1));
			}
			if(index != 0){
				nodes.add(wayNodes.get(index - 1));
			}
		}

		return nodes;
	}

	public void saveNode(Node node, Set<NodeInfo> infos) {
		session = HibernateUtils.getSession();
		try {
			session.beginTransaction();
			// ===============================
			session.save(node);

			Iterator<NodeInfo> it = infos.iterator();
			while (it.hasNext()) {
				NodeInfo nodeInfo = (NodeInfo) it.next();
				session.save(nodeInfo);
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
	
	public Node getNodeByName(String name){
		session = HibernateUtils.getSession();

		String hql = "SELECT n FROM Node as n join n.infos as i WHERE i.info_key='name' AND i.info_value=?";
		Node node;
		try {
			session.beginTransaction();
			// ===============================
			node = (Node) session.createQuery(hql)//
			     .setParameter(0, name)//
			     .uniqueResult();
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return node;
	}
	
	public Node getBus_Stop(String str){
		session = HibernateUtils.getSession();

		String hql = "SELECT n FROM Node as n join n.infos as i WHERE i.info_key='name' AND i.info_value=?";
		Node node;
		try {
			session.beginTransaction();
			// ===============================
			node = (Node) session.createQuery(hql)//
			     .setParameter(0, str)//
			     .uniqueResult();
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		return node;
	}

}
