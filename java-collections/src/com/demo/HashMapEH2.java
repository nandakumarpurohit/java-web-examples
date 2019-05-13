package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class HashMapEH2 {
	
	public static void main(String[] args) {         
		HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>();         
		
		Country india1=new Country();         
		india1.setName("India");         
		
		Country india2=new Country();         
		india2.setName("India");         
		
		countryCapitalMap.put(india1, "Delhi");         
		countryCapitalMap.put(india2, "Delhi");   
		
		Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();    
		
		while(countryCapitalIter.hasNext()) {             
			Country countryObj=countryCapitalIter.next();             
			String capital=countryCapitalMap.get(countryObj);             
			System.out.println("Capital of "+ countryObj.getName()+"----"+capital);         
		}     
	}

}
