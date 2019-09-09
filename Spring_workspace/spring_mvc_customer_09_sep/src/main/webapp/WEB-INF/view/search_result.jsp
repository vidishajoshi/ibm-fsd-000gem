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
<h2>Search results</h2>
<table>
<tr>
<th>Ser.No</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>

</tr>
<% 
	List<Customer> l=(List)request.getAttribute("list");
	Iterator<Customer> i=l.iterator();
	while(i.hasNext())
	{
		Customer s=i.next();
		out.println("<tr><td>"+s.getId()+"</td><td>"+s.getFirstName()+"</td><td>"+s.getLastName()+"</td><td>"+s.getEmail()+"</td></tr>");
	}
	
	%>
	
	</table>
	<a href="/"><button>Back</button></a>
	
</body>
</html>