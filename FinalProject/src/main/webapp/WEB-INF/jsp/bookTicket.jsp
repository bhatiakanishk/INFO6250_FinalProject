<%-- 
    Document   : bookTicket
    Created on : Apr 12, 2022, 8:32:53 PM
    Author     : kanishk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Tickets</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1>Book Tickets</h1>
        <form:form modelAttribute="ticket">
            <table>
		<tr>
		    <td>Train No:</td>
		    <td><form:input path="trainNo" size="30" /> <font color="red"><form:errors path="trainNo"/></font></td>
		</tr>
		
		<tr>
		    <td>Travel Date</td>
		    <td><form:input path="travel_date" size="30" /> <font color="red"><form:errors path="travel_date"/></font></td>
		</tr>
                
                <tr>
		    <td>Adult Count</td>
		    <td><form:input path="adultCount" size="30" /> <font color="red"><form:errors path="adultCount"/></font></td>
		</tr>
                
                <tr>
		    <td>Child Count</td>
		    <td><form:input path="childCount" size="30" /> <font color="red"><form:errors path="childCount"/></font></td>
		</tr>
                
                <tr>
		    <td>Enter Email</td>
		    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
		</tr>
                
		
		<tr>
		    <td colspan="2"><input type="submit" value="Book Ticket" /></td>
		</tr>
	</table>
	<br>
            </form:form>
    </body>
</html>
