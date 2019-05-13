package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class HashSetIterate {
	
	public static void main(String[] args) {
	     // Create a HashSet
	     HashSet<String> hset = new HashSet<String>();
	 
	     //add elements to HashSet
	     hset.add("Chaitanya");
	     hset.add("Rahul");
	     hset.add("Tim");
	     hset.add("Rick");
	     hset.add("Harry");
	 
	     Iterator<String> it = hset.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next());
	     }
	     
	     for (String temp : hset) {
	         System.out.println(temp);
	      }
	     
	     
	  }

}
