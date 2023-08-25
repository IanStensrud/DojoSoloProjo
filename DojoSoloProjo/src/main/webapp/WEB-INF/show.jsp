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
	<title><c:out value="${joke.poster.username}'s Deposit"/></title>
	
</head>
<body style="font-family: nunito, sans-serif">

	<div class="container mt-5">	
		<a href="/dash" class="text-decoration-none text-left text-secondary p-1 border border-warning rounded-bottom">Vault</a>
		<a href="/jokes/rewrite/${joke.id}" class="text-decoration-none text-left text-secondary p-1 border border-success rounded-bottom">ReWrite</a>
		
		<div class="container mt-5">
		
			<h2 class="mb-5 text-center"><c:out value="${joke.comedian.name}"/></h2>
			<div class="container d-flex flex-column align-items-center">
				<div class="container col-4 text-center border border-black rounded">
					<h4 class="border-bottom">Setup</h4>
					<c:out value="${joke.setup}"/>
				</div>
				<div class="mt-5 container col-4 text-center border border-black rounded">
					<h4 class="border-bottom">Punchline</h4>
					<c:out value="${joke.punchline}"/>
				</div>
				<div class="mt-5">
					<c:set value="${joke.id}" var="jokeId" />
				
					<c:if test="${favs.contains(joke)}">
					
						<form:form action="/joke/unfav/${jokeId}" method="POST">
						
							<button type="submit" class="btn btn-outline-danger">UnFav</button>
						
						</form:form>
						
					</c:if>
					<c:if test="${!favs.contains(joke)}">
						
						<form:form method="POST" action="/joke/fav/${jokeId}">
						
							<button type="submit" class="btn btn-outline-info">Fav</button>
						
						</form:form>
						
					</c:if>
					
				</div>
					
			</div>
		
		
		
		</div>
		
		
		<div class="container border p-2 mt-5">
			<h3>Favorited By:&nbsp;</h3>
			<ul class="list-unstyled">
				<c:forEach items="${favUsers}" var="favUser">
					<li class="p-2 mt-1 d-inline"><c:out value="${favUser.username}" />
				</c:forEach>
			
			</ul>
			
		</div>
	
	
	</div>
</body>
</html>