package com.jsp.hibernat_case_study_1;

import java.util.Scanner;

import com.jsp.hibernat_case_study_1.services.CartServices;
import com.jsp.hibernat_case_study_1.services.ProductServices;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ProductServices product=new ProductServices();
		CartServices cart=new CartServices();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Product\n2.Cart");
		int option=sc.nextInt();
		switch (option) {

		case 1:System.out.println("Enter the Product Choices");
		System.out.println("1.ADD PRODUCT\n2.GET A PRODUCT\n3.GET ALL PRODUCT\n4.UPDATE PRODUCT\n5.DELETE PRODUCT");
		int productChoice=sc.nextInt();
		switch (productChoice) {

		case 1:
			product.addProduct();
			break;
		case 2:
			product.getProduct();
			break;
		case 3:
			product.getAllProducts();
			break;
		case 4:
			product.updateProduct();
			break;
		case 5:
			product.deleteProduct();
			break;
		default:
			System.out.println("Invalid Choice!!!");
			System.out.println("Choose from correct options from product");
			break;
		}

		break;

		case 2:System.out.println("Enter the Cart Choices");
		System.out.println("1.ADD CART\n2.GET A CART\n3.GET ALL CART\n4.DELETE CART\n5.ADD PRODUCT");
		int cartChoice=sc.nextInt();
		switch (cartChoice) {
		case 1:
			cart.addCart();
			break;
		case 2:
			cart.getCart();
			break;
		case 3:
			cart.getAllCart();
			break;
		
		case 4:
			cart.deleteCart();
			break;
		case 5:
			cart.addProductToCart();
			break;
		default:
			System.out.println("Invalid Choice!!!");
			System.out.println("Choose from correct options from cart");
			break;
		}
         break;
		default:
			System.out.println("Invalid options !!!");
			
		}
	}
}
