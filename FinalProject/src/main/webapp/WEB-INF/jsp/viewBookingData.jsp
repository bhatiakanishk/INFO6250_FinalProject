<%-- 
    Document   : viewBookingData
    Created on : Apr 13, 2022, 7:46:45 PM
    Author     : kanishk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@page import="com.mycompany.pojo.Flight" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Booking Information</title>
    </head>
    <body style="font-family:Consolas, 'Courier New', monospace" align="center">
        <h1 style="border-style:groove; border-color:black; font-size: 35px" align="center">View All Booking Information</h1>
        <table border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>PNR</th>
                <th>date</th>
                <th>adultCount</th>
                <th>childCount</th>
                <th>email</th>
                <th>Travel Date</th>
                <th>Flight Number</th>
                
            </tr>
            <c:forEach var="adv" items="${ticketList}">
                <tr>
                    <td>${adv.PNR}</td>
                    <td>${adv.date}</td>
                    <td>${adv.adultCount}</td>
                    <td>${adv.childCount}</td>
                    <td>${adv.email}</td>
                    <td>${adv.travel_date}</td>
                    <td>${adv.flightNo}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="javascript:history.back()" style="font-size: 25px; text-decoration: none">Go Back</a>
    </body>
</html>
