/**
 * 
 */
package com.marlabs.tags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author nandakumarv
 *
 */
public class EmployeeHandler extends TagSupport {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private String firstName;
	private int salary;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary= salary;
	}

	public EmployeeHandler() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");// 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/try?serverTimezone=UTC","root","password");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		try{
			if(salary != 0) {
				ps = con.prepareStatement("select * from emp where salary > ?");
				ps.setInt(1, salary);
			}
			else if(firstName != null) {
				ps = con.prepareStatement("select * from emp where fname like ?");
				ps.setString(1, "%" + firstName + "%");
			}
			else {
				ps = con.prepareStatement("select * from emp");
			}
			rs = ps.executeQuery();
			out.println("<table border='1'>");
			if(!rs.next()) {
				out.println("<tr>");
				out.println("<td>No data for this criteria</td>");
				out.println("</tr>");
			}
			else {
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>FName</th>");
				out.println("<th>LName</th>");
				
				out.println("<th>Sal</th>");
				out.println("</tr>");
				
				do {
					
					
					out.println("<tr>");
					out.println("<td>" + rs.getString(1) + "</td>");
					
					out.println("<td>" + rs.getString(2) + "</td>");
					
					out.println("<td>" + rs.getString(3) + "</td>");
					
					out.println("<td>" + rs.getString(5) + "</td>");
					out.println("</tr>");
				} while(rs.next());
			}
			out.println("</table>");
			rs.close();
		}catch(Exception e){System.out.println(e);}
		return SKIP_BODY;
	}

}
