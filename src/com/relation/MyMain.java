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
		
		//����һ��Hibernate�Ի�
		Session session = HibernateUtil.getSessionfactory().openSession();
		//��������
		Transaction trans = session.beginTransaction();
		
		//��catOne��catTwo��������ݿ�
		session.persist(houseOne);
		session.persist(houseTwo);
		
		//��catOne��catTwo��������ݿ�
		session.persist(catOne);
		session.persist(catTwo);
		
		//��ѯ���ݿ⣬��ӡcat
		List<Cat> cats = session.createQuery("select c from Cat c").list();
		for (Cat cat : cats) {
			System.out.println("cat: id=" + cat.getId() + " name:"+cat.getName()); 
		}
		
		//�ύ����
		trans.commit();
		//�ر�Hibernate�Ի�
		session.close();
	}
	
}
