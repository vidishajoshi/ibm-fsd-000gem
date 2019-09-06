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

	List<Student> l=(List)request.getAttribute("student");
Iterator<Student> i=l.iterator();
out.println("<table style=\"border-collapse: collapse;border: 1px solid black;\"><tr><th>Ser.No</th><th>first Name</th><th>Last Name</th><th>Email</th><th>Country</th><th>Fav Language</th><th>Operating System</th></tr>");
while(i.hasNext())
{
	Student s=i.next();
	out.println("<tr><td>"+s.getId()+"</td><td>"+s.getFname()+"</td><td>"+s.getLname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getCountry()+"</td><td>"+s.getFavoriteLanguage()+"</td><td>"+s.getOs()+"</td></tr>");
}
out.println("</table>");
%>
<a href="/student/"><button>Back</button></a>
</body>
</html>