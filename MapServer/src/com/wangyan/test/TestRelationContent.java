package com.wangyan.test;


import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Relation;
import com.wangyan.bean.RelationContent;
import com.wangyan.utils.HibernateUtils;

public class TestRelationContent {
	@Test
	public void test() throws Exception {
		
		Relation r1 = new Relation("r1111");

		RelationContent rc1 = new RelationContent("way", "w1111");
		RelationContent rc2 = new RelationContent("node", "n1111");
		RelationContent rc3 = new RelationContent("node", "n2222");
		RelationContent rc4 = new RelationContent("way", "w2222");
		RelationContent rc5 = new RelationContent("way", "w3333");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(r1);
		session.save(rc1);
		session.save(rc2);
		session.save(rc3);
		session.save(rc4);
		session.save(rc5);
		
		session.getTransaction().commit();
	}
}
