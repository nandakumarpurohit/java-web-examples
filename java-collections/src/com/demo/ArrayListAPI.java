package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class ArrayListAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList1 of String type
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hi");
        al.add("hello");
        al.add("String");
        al.add("Test");
        System.out.println("ArrayList1 before addAll:"+al);

        //ArrayList2 of String Type
        ArrayList<String> al2 = new ArrayList<String>();
        al2.add("Text1");
        al2.add("Text2");
        al2.add("Text3");
        al2.add("Text4");
        
		//Adding ArrayList2 into ArrayList1
        al.addAll(al2);
        System.out.println("ArrayList1 after addAll:"+al);
        
      //Adding ArrayList2 in ArrayList1 at 3rd position(index =2)
        al.addAll(2, al2);
        
      //Sublist to ArrayList
        ArrayList<String> al3 = new ArrayList<String>(al.subList(1, 4));
        System.out.println("SubList stored in ArrayList: "+al3);

        //Sublist to List
        List<String> list = al.subList(1, 4);
        System.out.println("SubList stored in List: "+list);
        
      //Swapping 2nd(index 1) element with the 5th(index 4) element
        Collections.swap(al, 1, 4);
        
      //Updating 1st element
        al.set(0, "Tested");
        
        /*ArrayList to Array Conversion */
		String frnames[]=al.toArray(new String[al.size()]);

		/*Displaying Array elements*/
		for(String k: frnames)
		{
			System.out.println(k);
		}
		
		/* Array Declaration and initialization*/
		  String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal"};
		/*Array to ArrayList conversion*/
		  ArrayList<String> citylist= new ArrayList<String>(Arrays.asList(citynames));

		  /*Conversion*/
		    Collections.addAll(al, citynames);  
		  
	}

}
