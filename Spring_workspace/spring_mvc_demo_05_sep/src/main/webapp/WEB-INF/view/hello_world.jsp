<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Student Details
first name:${param.fname}
last name :${param.lname}
email:${param.email }

<br>
first: ${student_value.firstName}
last :${student_value.lastName}
email: ${student_value.email}
</body>
</html>