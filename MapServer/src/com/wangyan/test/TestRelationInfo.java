package com.wangyan.test;


import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Relation;
import com.wangyan.bean.RelationInfo;
import com.wangyan.utils.HibernateUtils;

public class TestRelationInfo {
	@Test
	public void test() throws Exception {
		Relation r1 = new Relation("r1111");
		
		RelationInfo ri1 = new RelationInfo();
		RelationInfo ri2 = new RelationInfo();
		RelationInfo ri3 = new RelationInfo();
		
		r1.getInfos().add(ri1);
		r1.getInfos().add(ri2);
		r1.getInfos().add(ri3);
		
		ri1.setRelation(r1);
		ri2.setRelation(r1);
		ri3.setRelation(r1);
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(r1);
		session.save(ri1);
		session.save(ri2);
		session.save(ri3);
		
		session.getTransaction().commit();
	}
}
