<%@page import="java.util.Iterator"%>
<%@page import="com.example.bean.Student"%>
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
<h1>Student details</h1>
<%

	List<Student> l=(List<Student>)request.getAttribute("student");
	
Iterator<Student> i=l.iterator();
while(i.hasNext())
{
	Student s=i.next();
	out.println(s.toString());
	
}
%>
</body>
</html>