<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Deposit a Comedian</title>
</head>
<body style="font-family: nunito, sans-serif">

	<div class="container mt-5">	
		<a href="/dash" class="text-decoration-none text-secondary p-1 border border-warning rounded-bottom">We All Get Cold Feet</a>
	
		<h1 class="text-center">Who's Next on the Lineup?</h1>
		<div class="container mt-5 col-5">
			<div class="container ">
				<form:form action="/introduce" method="POST" modelAttribute="newComedian" class="form-control">					
					
					<div class="input-group mt-3">
						<form:label class="p-1 d-flex align-items-center" path="name">Name:&nbsp;</form:label>
						<form:input path="name" placeholder="I like Mitch Hedberg, personally..." type="text" class="form-control" />
					</div>
					<div class="input-group mt-3">
						<form:errors path="name" class="text-danger" />
					</div>
					
					<div>
						<button type="submit" class="btn btn-outline-secondary">Introduce</button>
					</div>
					<div class="d-flex justify-content-end">
						<a href="/jokes/jokratory" class="text-decoration-none text-secondary">Make a Deposit</a><br/>

					</div>
					
				</form:form>
			</div>
		
		
		
		</div>
	
	
	
	</div>
</body>
</html>