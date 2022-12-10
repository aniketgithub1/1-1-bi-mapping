package com.jsp.person.pan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("aniket");
		EntityManager eManager = eMFactory.createEntityManager();
		EntityTransaction eTransaction=eManager.getTransaction();
		
		Person person=new Person();
		person.setName("sky");
		person.setEmail("sky@gamil.com");
		
		
		Pan pan = new Pan();
		pan.setPanNum(23456779);
		person.setPan(pan);          //person <-- pan
		pan.setPerson(person);       // pan <-- person
		
		person.setPan(pan);
		eTransaction.begin();
		eManager.persist(pan);
		eManager.persist(person);
		eTransaction.commit();
		
		System.out.println("ALL GOOD");
	}

}
