<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Add Customer Details</h1>
	
	<form:form modelAttribute="customerObj" method="POST" action="SaveCustomer.html">
	
		<table>
			<tr>
				<td>Customer Name:</td>
				<td><form:input path="customerName"/></td>
			</tr>
			<tr>
				<td>Customer Type:</td>
				<td>Checkbox here</td>
			</tr>
			<tr>
				<td>Bill Amount</td>
				<td><form:input path="bill"/></td>
			</tr>
			<tr>
				<td>Billing Date [dd-MMM-yyyy]]</td>
				<td><form:input path="billingDate"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	
	</form:form>
	
	<a href="${pageContext.request.contextPath}/index.html">Home</a>
	
</body>
</html>