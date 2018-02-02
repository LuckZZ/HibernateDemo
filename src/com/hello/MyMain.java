package com.hello;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MyMain {
	public static void main(String[] args) {
		Cat catOne = new Cat();
		catOne.setName("One");
		
		Cat catTwo = new Cat();
		catTwo.setName("Two");
		//����һ��Hibernate�Ի�
		Session session = HibernateUtil.getSessionfactory().openSession();
		//��������
		Transaction trans = session.beginTransaction();
		//��catOne��catTwo��������ݿ�
		session.persist(catOne);
		session.persist(catTwo);
		//�ύ����
		trans.commit();
		//�ر�Hibernate�Ի�
		session.close();			
	}
}
