package com.demo;
import java.util.*;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class ArrayListSortByMultiProps {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		   ArrayList<Employee> arraylist = new ArrayList<Employee>();
		   arraylist.add(new Employee(101, "Zues", 9800.00));
		   arraylist.add(new Employee(505, "Abey", 12500.00));
		   arraylist.add(new Employee(809, "Vignesh", 10700.00));

		   /*Sorting based on Employee Name*/
		   System.out.println("Student Name Sorting:");
		   Collections.sort(arraylist, Employee.empNameComparator);

		   for(Employee str: arraylist){
				System.out.println(str);
		   }

		   /* Sorting on Salary property*/
		   System.out.println("Salary Sorting:");
		   Collections.sort(arraylist, Employee.empSalComparator);
		   for(Employee str: arraylist){
				System.out.println(str);
		   }
		}

}
