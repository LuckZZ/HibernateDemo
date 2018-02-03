package com.relation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyMain {
	
	public static void main(String[] args) {
		House houseOne = new House();
		houseOne.setName("HouseOne");
		
		House houseTwo = new House();
		houseTwo.setName("HouseTwo");
		
		Cat catOne = new Cat();
		catOne.setName("CatOne");
		
		Cat catTwo = new Cat();
		catTwo.setName("CatTwo");
		
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(catOne);
		catList.add(catTwo);
		houseOne.setCats(catList);
		
		//开启一个Hibernate对话
		Session session = HibernateUtil.getSessionfactory().openSession();
		//开启事务
		Transaction trans = session.beginTransaction();
		
		//将catOne、catTwo保存进数据库
		session.persist(houseOne);
		session.persist(houseTwo);
		
		//将catOne、catTwo保存进数据库
		session.persist(catOne);
		session.persist(catTwo);
		
		//查询数据库，打印cat
		List<Cat> cats = session.createQuery("select c from Cat c").list();
		for (Cat cat : cats) {
			System.out.println("cat: id=" + cat.getId() + " name:"+cat.getName()); 
		}
		
		//提交事务
		trans.commit();
		//关闭Hibernate对话
		session.close();
	}
	
}
