package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class ArrayListEnumExample {
	
	public static void main(String[] args) {
	      //create an ArrayList object
	      ArrayList<String> arrayList = new ArrayList<String>();
	 
	      //Add elements to ArrayList
	      arrayList.add("C");
	      arrayList.add("C++");
	      arrayList.add("Java");
	      arrayList.add("DotNet");
	      arrayList.add("Perl");
	 
	      // Get the Enumeration object
	      Enumeration<String> e = Collections.enumeration(arrayList);
	 
	      // Enumerate through the ArrayList elements
	      System.out.println("ArrayList elements: ");
	      while(e.hasMoreElements())
	      System.out.println(e.nextElement());
	   }

}
