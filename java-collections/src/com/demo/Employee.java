package com.demo;
import java.util.Comparator;

/**
 * 
 */

/**
 * @author Nanda
 *
 */
public class Employee {
	
	private int empId;
	private String name;
	private double salary;
	
	
	
	/**
	 * @param empId
	 * @param name
	 * @param salary
	 */
	public Employee(int empId, String name, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empid to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static Comparator<Employee> empNameComparator = new Comparator<Employee>() {

		public int compare(Employee s1, Employee s2) {
		   String empName1 = s1.getName().toUpperCase();
		   String empName2 = s2.getName().toUpperCase();

		   //ascending order
		   return empName1.compareTo(empName2);

		   //descending order
		   //return empName2.compareTo(empName1);
	    }};

	    /* Comparator for sorting the list by Salary */
	    public static Comparator<Employee> empSalComparator = new Comparator<Employee>() {

		public int compare(Employee s1, Employee s2) {

		   double sal1 = s1.getSalary();
		   double sal2 = s2.getSalary();

		   /*For ascending order*/
		   return (int) (sal1-sal2);

		   /*For descending order*/
		   //sal2-sal1;
	   }};
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", name=" + name + ", salary="
					+ salary + "]";
		}
	   
	   

}
