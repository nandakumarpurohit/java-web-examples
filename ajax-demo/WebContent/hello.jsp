<%
	String name = request.getParameter("username");
	out.println("Have a nice weekend, " + name.toUpperCase());
%>