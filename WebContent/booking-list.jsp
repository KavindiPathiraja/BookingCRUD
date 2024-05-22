<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Booking Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Booking Management App </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Bookings</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Bookings</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Booking</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>BookingID</th>
                        <th>Origin Station</th>
                        <th>Destination Station</th>
                        <th>No Of Passengers</th>
                        <th>Date</th>
                        <th>Preferred Class</th>
                        <th>Depart Time</th>
                        <th>Payment Type</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booking" items="${listBookings}">
                        <tr>
                            <td><c:out value="${booking.bookingId}" /></td>
                            <td><c:out value="${booking.originStation}" /></td>
                            <td><c:out value="${booking.destinationStation}" /></td>
                            <td><c:out value="${booking.noOfPassengers}" /></td>
                            <td><c:out value="${booking.date}" /></td>
                            <td><c:out value="${booking.preferedClass}" /></td>
                            <td><c:out value="${booking.departTime}" /></td>
                            <td><c:out value="${booking.paymentType}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${booking.bookingId}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp; 
                                <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${booking.bookingId}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
