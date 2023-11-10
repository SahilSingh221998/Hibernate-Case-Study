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

public class CartDao {

	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sessionFactory=cfg.buildSessionFactory();

	//method to add an element
	public String addCart(Cart cart)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "Cart added successfully";
	}

	//method to get a record
	public Cart getCartById( int cid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		Cart cart=session.get(Cart.class,cid);
		System.out.println(cart);
		transaction.commit();
		session.close();
		return cart;
	}

	//get all records
	public List<Cart> getAllCart()
	{
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		Query query = session.createQuery("from Cart");
		List<Cart> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	public String cartDelete(Cart cart)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		session.delete(cart);
		transaction.commit();
		session.close();
		return "Cart deleted successfully";
	}
	public String addProductToCart(Product product,Cart cart)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction =session.beginTransaction();
		cart.getProducts().add(product);
		session.update(cart);
		transaction.commit();
		session.close();
		return "Products mapped successfully";
	}
}







