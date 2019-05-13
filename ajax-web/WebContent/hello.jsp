<%@ page import="java.util.*, org.json.*" %>

<jsp:useBean id="service" class="com.demo.service.StateService" />

<%
	/*ArrayList<String> list = new ArrayList<String>();
	list.add("NJ");
	list.add("NY");*/
	ArrayList<String> states = service.fetchAllStates();
	String json = (new JSONArray(states)).toString();
	out.println(json);
%>