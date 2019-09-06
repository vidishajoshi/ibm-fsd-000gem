<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Details</h1><br>
first name:${tempStudent.fname}<br><br>
last name :${tempStudent.lname}<br><br>
email:${tempStudent.email }<br><br>
country :${tempStudent.country }<br><br>
favourite lang:${tempStudent.lang }<br><br>
operating system : ${tempStudent.os }<br><br>
<a href="/student/"><button>Back</button></a>
</body>
</html>