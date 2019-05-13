package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class ArrayListTypesOfInit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 Using Arrays.asList()
		 */
		ArrayList<String> obj = new ArrayList<String>(
				Arrays.asList("Pratap", "Peter", "Harsh"));
			  System.out.println("Elements are:"+obj);
		
		/*	  
		Anonymous Inner class method	  
		*/
			  
			  ArrayList<String> cities = new ArrayList<String>(){
				  {
					   add("Delhi");
					   add("Agra");
					   add("Chennai");
				  }
			};
			  System.out.println("Content of Array list cities:"+cities);	  
	
		/*
		 Using Collections.ncopis()	  
		 */
		
		  ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5));
		  System.out.println("ArrayList items: "+intlist);	  
	
	}

}
