package com.wangyan.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.wangyan.bean.Node;
import com.wangyan.bean.Way;
import com.wangyan.bean.WayInfo;
import com.wangyan.utils.HibernateUtils;

public class WayDao {
	private Session session;

	public void model(){
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
	
	public void saveWay(Way way, List<String> wayNodes){
		session = HibernateUtils.getSession();

		String hql = "";

		try {
			session.beginTransaction();
			// ===============================

			session.save(way);
			
			Iterator<WayInfo> it = way.getInfos().iterator();
			while (it.hasNext()) {
				WayInfo wayInfo = (WayInfo) it.next();
				session.save(wayInfo);
			}
			
			
			NodeDao nodeDao = new NodeDao();
			Iterator<String> it2 = wayNodes.iterator();
			while (it2.hasNext()) {
				String id = it2.next();
				Node node = nodeDao.getNodeById(id, session);
				
				way.getNodes().add(node);
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
