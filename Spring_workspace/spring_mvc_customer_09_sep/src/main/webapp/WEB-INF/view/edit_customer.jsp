<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h1>Update Customer</h1>
	    
		<form action="editCustomer">
		
			<table>
				<tbody>
				
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" value="${customer.getFirstName()}"/></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" value="${customer.getLastName()}"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email" value="${customer.getEmail()}"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="update" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form>
</body>
</html>