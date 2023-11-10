package com.jsp.hibernat_case_study_1.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernat_case_study_1.entity.Cart;
import com.jsp.hibernat_case_study_1.entity.Product;

public class ProductDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory s=cfg.buildSessionFactory();

	//Method to add an element

	public String addProduct( Product product) {
		Session session=s.openSession();
		Transaction trans=session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();
		return "Product added successfully";
	}

	//Method to get a record
	public Product getProductById(int pid)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		Product product = session.get(Product.class,pid);
		t.commit();
		session.close();
		return product;

	}

	//method to fetch all records
	public List<Product> getAllProducts()
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> list = query.getResultList();
		t.commit();
		session.close();
		return list;
	}

	//method to update an product
	public String updateProduct( Product product)
	{

		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		session.update(product);
		t.commit();
		session.close();
		return "product successfully updated";
	}	

	//method to delete a record
	public String deleteProduct(Product product)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		session.delete(product);
		t.commit();
		session.close();
		return "product deleted successfully";
	}


}
