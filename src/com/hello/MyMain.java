package com.hello;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyMain {
	public static void main(String[] args) {
		Cat catOne = new Cat();
		catOne.setName("One");
		
		Cat catTwo = new Cat();
		catTwo.setName("Two");
		//开启一个Hibernate对话
		Session session = HibernateUtil.getSessionfactory().openSession();
		//开启事务
		Transaction trans = session.beginTransaction();
		//将catOne、catTwo保存进数据库
		session.persist(catOne);
		session.persist(catTwo);
		//提交事务
		trans.commit();
		//关闭Hibernate对话
		session.close();			
	}
}
