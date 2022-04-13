<%-- 
    Document   : closeUser
    Created on : Apr 12, 2022, 8:38:43 PM
    Author     : kanishk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close Account</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">Would you like to close your account?</h1>
        <form:form modelAttribute = "user">
            <table>
		<tr>
		    <td>Enter your email to confirm</td>
		    <td><form:input path = "email" size = "30" /> <font color = "red"><form:errors path = "email"/></font></td>
		</tr>

		<tr>
		    <td colspan = "2"><input type = "submit" value = "Delete" /></td>
		</tr>
	</table>
	<br>
            </form:form>
    </body>
</html>