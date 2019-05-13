package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class LinkedListListIterator {
	
	public static void main(String[] args) {
		 
	    // Create a LinkedList
	    LinkedList<String> linkedlist = new LinkedList<String>();
	 
	    // Add elements to LinkedList
	    linkedlist.add("Delhi");
	    linkedlist.add("Agra");
	    linkedlist.add("Mysore");
	    linkedlist.add("Chennai");
	    linkedlist.add("Pune");
	 
	    // Obtaining ListIterator
	    ListIterator listIt = linkedlist.listIterator();
	 
	    // Iterating the list in forward direction
	    System.out.println("Forward iteration:");
	    while(listIt.hasNext()){
	       System.out.println(listIt.next());
	    }

	    // Iterating the list in backward direction
	    System.out.println("\nBackward iteration:");
	    while(listIt.hasPrevious()){
	       System.out.println(listIt.previous());
	    } 
	 }

}
