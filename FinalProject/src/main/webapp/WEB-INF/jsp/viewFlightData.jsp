<%-- 
    Document   : viewFlightData
    Created on : Apr 13, 2022, 4:46:00 PM
    Author     : kanishk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@page import="com.mycompany.pojo.Flight"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Flight Information</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">View All Flight Information</h1>
        <table border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>Flight No.</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Total Seats!</th>
            </tr>
            <c:forEach var="adv" items="${flightList}">
                <tr>
                    <td>${adv.flightNo}</td>
                    <td>${adv.source}</td>
                    <td>${adv.dest}</td>
                    <td>${adv.totalSeats}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
