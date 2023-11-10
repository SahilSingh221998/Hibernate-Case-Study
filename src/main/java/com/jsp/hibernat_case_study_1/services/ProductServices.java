package com.jsp.hibernat_case_study_1.services;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernat_case_study_1.dao.ProductDao;
import com.jsp.hibernat_case_study_1.entity.Product;

public class ProductServices {
	ProductDao productdao=new ProductDao();
	Scanner sc=new Scanner(System.in);

	public void addProduct()
	{
		System.out.println("Enter the ProductName");
		String pname=sc.next();
		System.out.println("Eneter the Product Price");
		double price=sc.nextDouble();
		System.out.println("Enter the product Quantity");
		int quantity=sc.nextInt();
		Product product=new Product();
		product.setProductName(pname);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		String message=productdao.addProduct(product);
		System.out.println(message);
	}

	public void getProduct()
	{
		System.out.println("Enter the Product Id");
		int pid=sc.nextInt();
		Product product=productdao.getProductById(pid);
		System.out.println("Product [productId=" +product.getProductId()+ ", productName=" + product.getProductName() + ", productPrice=" + product.getProductPrice()
		+ ", productQuantity=" + product.getProductQuantity() + "]");
	}
	public void getAllProducts()
	{
		List<Product> list=productdao.getAllProducts();
		for(Product product:list)
		{
			System.out.println("Product [productId=" +product.getProductId()+ ", productName=" + product.getProductName() + ", productPrice=" + product.getProductPrice()
			+ ", productQuantity=" + product.getProductQuantity() + "]");
		}
	}

	public void updateProduct()
	{
		System.out.println("Enter the id for updation");
		int pid=sc.nextInt();
		Product product=productdao.getProductById(pid);
		if(product!=null)
		{
			System.out.println("Enter the name for updation");
			String pname=sc.next();
			product.setProductName(pname);
			String message=productdao.updateProduct(product);
			System.out.println(message);
		}
		else {
			System.err.println("Invalid id");
		}

	}
	public void deleteProduct()
	{
		System.out.println("Enter the product id to delete");
		int pid=sc.nextInt();
		Product product=productdao.getProductById(pid);
		if(product!=null) {
			String message=productdao.deleteProduct(product);
			System.out.println(message);
		}
		else {
			System.err.println("Invalid Product id");
		}
	}
}
