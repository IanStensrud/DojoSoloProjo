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
	<title>Enter the Jokratory: BTS</title>
</head>
<body style="font-family: nunito, sans-serif">

	<div class="container mt-5">
		<a href="/joke/show/${joke.id}" class="text-decoration-none text-secondary p-1 border border-warning rounded-bottom">Eh, You Tried Your Best</a>
	
	
		<h1 class="text-center">Hope You Brought Your Pen and Pad</h1>
		<div class="container mt-5 col-5">
			<div class="container ">
				<form:form action="/joke/update/${joke.id}" method="POST" modelAttribute="joke" class="form-control">
					
					<div class="input-group mt-3">
						<form:label path="comedian" class="d-flex align-items-center">Owner of This Masterpiece:&nbsp;</form:label>
						<form:select path="comedian" class="form-select">
							<form:option value="${user.id}"  label="${user.username}(You)" />
							<c:forEach items="${comedians}" var="comedian">
								<form:option value="${comedian.id}" label="${comedian.name}" />
							</c:forEach>						
						
						</form:select>
					</div>
					
					
					<form:input type="hidden" value="${user.id}" path="poster"/>
					<div class="input-group mt-3">
						<form:label class="p-1 d-flex align-items-center" path="setup">Setup:&nbsp;</form:label>
						<form:input path="setup" placeholder="Set 'em up!" type="text" class="form-control" />
					</div>
					<div class="input-group mt-3">
						<form:errors path="setup" class="text-danger" />
					</div>
					<div class="input-group mt-3">
						<form:label class="p-1 d-flex align-items-center" path="punchline">Punchline:&nbsp;</form:label>
						<form:textarea path="punchline" placeholder="Knock 'em dead!" type="text" class="form-control" />
					</div>
					<div class="input-group mt-3">
						<form:errors path="punchline" class="text-danger" />
					</div>
					
					<div class="d-block">
						<button type="submit" class="btn btn-outline-secondary">Let 'em Know</button>
					</div>
					<div class="d-flex justify-content-end">
						<a href="/joke/update/${joke.id}" class="text-decoration-none text-secondary">Introduce Comedian</a>
					</div>
				</form:form>
			</div>
		
		
		
		</div>
	
	
	
	</div>
</body>
</html>