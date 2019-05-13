package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class ArrayListSort {
	
	public static void main(String args[]){
		   ArrayList<Product> listofcountries = new ArrayList<Product>();
		   
		   listofcountries.add(new Product(10, "USB", 12.45));
		   listofcountries.add(new Product(6, "Laptop", 299.95));
		   listofcountries.add(new Product(9, "Air Fryer", 80.00));
		   listofcountries.add(new Product(7, "TV", 499.00));
		   
		   /*listofcountries.add("India");
		   listofcountries.add("US");
		   listofcountries.add("China");
		   listofcountries.add("Denmark");*/

		   /*Unsorted List*/
		   System.out.println("Before Sorting:");
		   for(Product product: listofcountries){
				System.out.println(product);
			}

		   /* Sort statement*/
		   Collections.sort(listofcountries);

		   /* Sorted List*/
		   System.out.println("After Sorting:");
		   for(Product product: listofcountries){
				System.out.println(product);
			}
		}

}
