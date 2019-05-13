package com.demo;
/**
 * @author Nanda
 *
 */
public class HashMapEH1 {

	public static void main(String[] args) {
		Country india1 = new Country();
		india1.setName("India");
		Country india2 = new Country();
		india2.setName("India");
		System.out.println("Is india1 is equal to india2:"
				+ india1.equals(india2));
	}

}
