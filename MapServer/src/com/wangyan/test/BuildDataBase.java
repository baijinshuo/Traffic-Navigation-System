package com.wangyan.test;


import org.hibernate.Session;
import org.junit.Test;

import com.wangyan.utils.HibernateUtils;

public class BuildDataBase {
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
	}
}
