package com.wangyan.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Node;
import com.wangyan.bean.NodeInfo;
import com.wangyan.bean.Relation;
import com.wangyan.bean.RelationContent;
import com.wangyan.bean.RelationInfo;
import com.wangyan.dijkstra.Bus;
import com.wangyan.utils.HibernateUtils;

public class RelationDao {
	private Session session;
	
	public void saveRelation(Relation relation) {
		session = HibernateUtils.getSession();
		try {
			session.beginTransaction();
			// ===============================
			session.save(relation);
			
			Iterator<RelationInfo> it = relation.getInfos().iterator();
			while (it.hasNext()) {
				RelationInfo relationInfo = (RelationInfo) it.next();
				session.save(relationInfo);
			}
			
			Iterator<RelationContent> it2 = relation.getContents().iterator();
			while (it2.hasNext()) {
				RelationContent relationContent = (RelationContent) it2.next();
				session.save(relationContent);
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
	
	@Test
	public void testName() throws Exception {
		Bus bus = this.getBus("abc");
		System.out.println(bus);
	}
	
	public Bus getBus(String bus_No) {
		Bus bus = new Bus(bus_No);
		
		session = HibernateUtils.getSession();

		String hql = "SELECT rc FROM Relation as r inner join r.infos as ri join r.contents as rc WHERE ri.info_key='ref' and ri.info_value=?";

		try {
			session.beginTransaction();
			// ===============================
			List<RelationContent> list = session.createQuery(hql)//
										.setParameter(0, bus_No)//
										.list();
			Iterator<RelationContent> it = list.iterator();
			while (it.hasNext()) {
				RelationContent relationContent = (RelationContent) it.next();
				if(relationContent.getType().equals("node")){
					Node node = new NodeDao().getNodeById(relationContent.getId(), session);
					bus.getList().add(node);
				}
			}
			System.out.println(bus.getList());
			// ===============================
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		return bus;

	}
}
