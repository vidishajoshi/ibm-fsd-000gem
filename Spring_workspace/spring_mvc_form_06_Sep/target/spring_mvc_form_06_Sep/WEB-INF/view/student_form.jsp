<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student details</h1>
<form:form action="processForm" modelAttribute="student">
First Name : <form:input path="fname"/><br><br>
Last Name : <form:input path="lname" /><br><br>
Email : <form:input path="email"/><br><br>
Country:		
		<form:select path="country">
		
			<form:options items="${student.countryOption}" />
			
		</form:select>
				
		<br><br>

		Favorite Language:
		
		Java <form:radiobutton path="lang" value="Java" />
		C# <form:radiobutton path="lang" value="C#" />
		PHP <form:radiobutton path="lang" value="PHP" />
		Ruby <form:radiobutton path="lang" value="Ruby" />
		<br><br>
		Operating system:
		
		Mac <form:checkbox path="os" value="Mac"/>
		Windows <form:checkbox path="os" value="Windows"/>
		Ubantu <form:checkbox path="os" value="Ubantu"/>
		Linux <form:checkbox path="os" value="Linux"/>
		<br><br>
<input type="submit"/>
</form:form>
</body>
</html>