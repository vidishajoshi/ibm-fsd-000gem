<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
</head>
<body>
<h2>CRM-Customer Relationship Management</h2><br/>
<a href='/addCustomer'><button>Add Customers</button></a>
<a href='/showCustomers'><button>Show Customers</button></a>
<br><br>
<h3>Search Customers</h3>
<div>
<fieldset>
<legend>Search by First Name</legend>
<form action="/searchByFname">
<label>Enter text: </label>
<input type="text" name="sf" />
<br><br>
<input type="submit" value="search"/>
</form>
</fieldset>
</div>
<div>
<fieldset>
<legend>Search by Last Name</legend>
<form action="/searchByLname">
<label>Enter text: </label>
<input type="text" name="lf" />
<br><br>
<input type="submit" value="search"/>
</form>
</fieldset>
</div>
<div>
<fieldset>
<legend>Search by Email</legend>
<form action="/searchByEmail">
<label>Enter text: </label>
<input type="text" name="ef" />
<br><br>
<input type="submit" value="search"/>
</form>
</fieldset>
</div>



</table>
</body>
</html>