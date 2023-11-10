package com.jsp.hibernat_case_study_1.services;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernat_case_study_1.dao.CartDao;
import com.jsp.hibernat_case_study_1.dao.ProductDao;
import com.jsp.hibernat_case_study_1.entity.Cart;
import com.jsp.hibernat_case_study_1.entity.Product;

public class CartServices {
   CartDao cartdao=new CartDao();
   Scanner sc=new Scanner(System.in);
   
   public void addCart()
   {
	   Cart cart=new Cart();
	   String message=cartdao.addCart(cart);
	   System.out.println(message);
   }
   
   public void getCart()
   {
	   System.out.println("Enter the Cart Id");
	   int cid=sc.nextInt();
	   Cart cart=cartdao.getCartById(cid);
//	   Product product=new Product();
	   System.out.println("Cart [cartId=" + cart.getCartId() + "]");
   }
   
   public void deleteCart()
   {
	   System.out.println("Enter the Cart Id");
		int cid=sc.nextInt();
		Cart cart=cartdao.getCartById(cid);
		if(cart!=null)
		{
			String message=cartdao.cartDelete(cart);
			System.out.println(message);
		}
		else {
			System.err.println("Invalid Cart id");
		}

   }
   public void getAllCart()
   {
	   List<Cart> list=cartdao.getAllCart();
	   for(Cart cart:list)
		{
			System.out.println("Cart [cartId=" + cart.getCartId() + "]");
		}
   }
   public void addProductToCart()
   {
	   System.out.println("Enter the cart id");
	   int cid=sc.nextInt();
	   System.out.println("Enter the product id");
	   int pid=sc.nextInt();
	   Product product= new ProductDao().getProductById(cid);
	   Cart cart=cartdao.getCartById(cid);
	   if(product!=null&&cart!=null)
	   {
		   String message=cartdao.addProductToCart(product, cart);
		   System.out.println(message);
	   }
	   else
	   {
		   System.err.println("Invalid id");
	   }
   }
}
