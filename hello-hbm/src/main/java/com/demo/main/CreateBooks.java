package com.demo.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Book;

public class CreateBooks {
	
	SessionFactory factory;
	
	CreateBooks() {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void insertBook() {
		try {
			Book book = new Book("Java Complete Reference", "Herbert Schildt", 14.99);
			Book book2 = new Book("Java Servlets", "Oreilly", 9.90);
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.persist(book);
			session.persist(book2);
			System.out.println("Books inserted!");
			t.commit();
			session.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	List<Book> viewAll() {
		
		Session session = factory.openSession();
		Query query = session.createQuery("from Book");
		List<Book> list = query.list();
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new CreateBooks().insertBook();
		
		List<Book> list = new CreateBooks().viewAll();
		
		for(Book book : list) {
			System.out.println(book);
		}
	}

}
