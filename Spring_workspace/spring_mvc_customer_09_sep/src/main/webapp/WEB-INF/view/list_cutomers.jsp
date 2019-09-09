<%@page import="java.util.Iterator"%>
<%@page import="com.example.bean.entity.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All the Customers</h2>
<table>
<tr>
<th>Ser.No</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<% 
	List<Customer> l=(List)request.getAttribute("customer");
	Iterator<Customer> i=l.iterator();
	while(i.hasNext())
	{
		Customer s=i.next();
		out.println("<tr><td>"+s.getId()+"</td><td>"+s.getFirstName()+"</td><td>"+s.getLastName()+"</td><td>"+s.getEmail()+"</td><td><a href=\"edit?id="+s.getId()+"\">Edit</a></td><td><a href=\"deleteCustomer?id="+s.getId()+"\">Delete</a></td></tr>");
	}
	
	%>
	
	</table>
	<a href="/"><button>Back</button></a>
	
</body>
</html>