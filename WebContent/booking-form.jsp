<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Booking Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Booking Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Bookings</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${bookings != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${bookings == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${bookings != null}">
            			Edit Bookings
            		</c:if>
						<c:if test="${bookings == null}">
            			Add New Bookings
            		</c:if>
					</h2>
				</caption>

				<c:if test="${bookings != null}">
					<input type="hidden" name="id" value="<c:out value='${bookings.bookingId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Origin Station</label> <input type="text"
						value="<c:out value='${bookings.originStation}' />" class="form-control"
						name="originStation" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Destination Station</label> <input type="text"
						value="<c:out value='${bookings.destinationStation}' />" class="form-control"
						name="destinationStation">
				</fieldset>

				<fieldset class="form-group">
					<label>No Of Passengers</label> <input type="number"
						value="<c:out value='${bookings.noOfPassengers}' />" class="form-control"
						name="noOfPassengers">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Date</label> <input type="date"
						value="<c:out value='${bookings.date}' />" class="form-control"
						name="date">
				</fieldset>
				
				<fieldset class="form-group">
				    <label>Prefered Class</label>
				    <select class="form-control" name="preferedClass">
				        <option value="First Class" <c:if test="${bookings != null and bookings.preferedClass eq 'First Class'}">selected</c:if>>First Class</option>
				        <option value="Business Class" <c:if test="${bookings != null and bookings.preferedClass eq 'Business Class'}">selected</c:if>>Business Class</option>
				        <option value="Economy Class" <c:if test="${bookings != null and bookings.preferedClass eq 'Economy Class'}">selected</c:if>>Economy Class</option>
				        
				    </select>
				</fieldset>
				
				<fieldset class="form-group">
				    <label>Depart Time</label>
				    <select class="form-control" name="departTime">
				        <option value="Morning" <c:if test="${bookings != null and bookings.departTime eq 'Morning'}">selected</c:if>>Morning</option>
				        <option value="Afternoon" <c:if test="${bookings != null and bookings.departTime eq 'Afternoon'}">selected</c:if>>Afternoon</option>
				        <option value="Evening" <c:if test="${bookings != null and bookings.departTime eq 'Evening'}">selected</c:if>>Evening</option>
				        
				    </select>
				</fieldset>
				
				<fieldset class="form-group">
				    <label>Payment Type</label>
				    <select class="form-control" name="paymentType">
				        <option value="Credit Card" <c:if test="${bookings != null and bookings.paymentType eq 'Credit Card'}">selected</c:if>>Credit Card</option>
				        <option value="Debit Card" <c:if test="${bookings != null and bookings.paymentType eq 'Debit Card'}">selected</c:if>>Debit Card</option>
				        <option value="PayPal" <c:if test="${bookings != null and bookings.paymentType eq 'PayPal'}">selected</c:if>>PayPal</option>

				    </select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>