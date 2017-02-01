package com.wangyan.test;

import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Node;
import com.wangyan.bean.Way;
import com.wangyan.utils.HibernateUtils;

public class TestNode_Way {

	@Test
	public void test() {
		Node node1 = new Node("n1111");
		Node node2 = new Node("n2222");
		Node node3 = new Node("n3333");
		Node node4 = new Node("n4444");
		Node node5 = new Node("n5555");
		Node node6 = new Node("n6666");
		Node node7 = new Node("n7777");
		Node node8 = new Node("n8888");

		Way way1 = new Way("w1111");
		Way way2 = new Way("w2222");
		


		way1.getNodes().add(node1);
		way1.getNodes().add(node3);
		way1.getNodes().add(node2);
		way1.getNodes().add(node4);

		node1.getWays().add(way1);
		node3.getWays().add(way1);
		node2.getWays().add(way1);
		node4.getWays().add(way1);

		way2.getNodes().add(node8);
		way2.getNodes().add(node5);
		way2.getNodes().add(node6);
		way2.getNodes().add(node4);
		way2.getNodes().add(node7);

		node4.getWays().add(way2);
		node5.getWays().add(way2);
		node6.getWays().add(way2);
		node7.getWays().add(way2);
		node8.getWays().add(way2);


		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		session.save(node1);
		session.save(node2);
		session.save(node3);
		session.save(node4);
		session.save(node5);
		session.save(node6);
		session.save(node7);
		session.save(node8);
//		
//		System.out.println("+++++++++++++++++++++");
//		System.out.println(way1.getNodes());
//		System.out.println(way2.getNodes());
//		System.out.println(node1.getWays());
//		System.out.println(node2.getWays());
//		System.out.println(node3.getWays());
//		System.out.println(node4.getWays());
//		System.out.println(node5.getWays());
//		System.out.println(node6.getWays());
//		System.out.println(node7.getWays());
//		System.out.println(node8.getWays());
//
		session.save(way1);
		session.save(way2);

		session.getTransaction().commit();
	}
}
