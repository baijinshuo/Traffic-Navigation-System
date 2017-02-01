package com.wangyan.test;

import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.bean.Way;
import com.wangyan.bean.WayInfo;
import com.wangyan.utils.HibernateUtils;

public class TestNodeInfo {
	@Test
	public void test(){
		Way way = new Way("w1111");
		
		WayInfo info1 = new WayInfo();
		WayInfo info2 = new WayInfo();
		
		info1.setInfo_key("国安");
		info1.setInfo_value("冠军");
		info2.setInfo_key("鲁能");
		info2.setInfo_value("傻逼");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(way);
		session.save(info1);
		session.save(info2);
		
		session.getTransaction().commit();
	}
}
