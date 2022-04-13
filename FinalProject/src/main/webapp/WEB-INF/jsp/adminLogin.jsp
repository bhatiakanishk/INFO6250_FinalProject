<%-- 
    Document   : adminLogin
    Created on : Apr 12, 2022, 7:24:20 PM
    Author     : kanishk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Admin Login</h1>
        <form:form modelAttribute="admin" style="font-size: 25px; text-decoration: none">
            <table>
		<tr>
		    <td>Admin Email:</td>
		    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
		</tr>
		
		<tr>
		    <td>Password:</td>
		    <td><form:password path="pass" size="30" /> <font color="red"><form:errors path="pass"/></font></td>
		</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
	</table>
	<br>
            </form:form>
    </body>
</html>
