<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="/CSS/tabel.css">
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Welcome, <c:out value="${user.username}" /></title>
</head>
<body style="font-family: nunito, sans-serif;">

	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Whole Container Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	<div class="container mt-5">	
		<a href="/logout" class="shadow-sm text-decoration-none text-secondary p-1 border border-danger rounded-bottom">Logout</a>
	
		
		<h1 class="text-center">Welcome to the Stage ~ <c:out value="${user.username}" />!</h1>
		<div class="mt-5">
			<h3 class="text-center text-bold">The Vault</h3>
		</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Main Dash Div Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
		<div class="container">

			<div class="d-flex justify-content-between text-center align-items-center">
			
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Left Div Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

				<div class="container pt-5 pb-5 d-flex flex-column">
					
					<div>
						<h3 class="">Current Lineup</h3>
					</div>

					<div style="max-height: 250px; overflow: auto; width: 100%;">
						<ul class="shadow-sm list-unstyled">
						<c:forEach items="${comedians}" var="comedian">
							<li><a class="text-decoration-none text-secondary" href="/comedians/${comedian.id}">${comedian.name}</a></li>
						</c:forEach>
						</ul>
					</div>
				</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Left Div End ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Vault Table Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->	
				<div id="tabelDiv" style="max-height: 375px; overflow: auto; width: 100%;">
				<!-- I tried setting this ^^^^^^^^^^^^ in tabel.css, but it wasn't giving me the same results :( -->
					<table class="table table-hover text-center">
						<tbody>
						
							<c:forEach items="${jokes}" var="joke">
								<tr class="shadow-sm "><td><a class="text-decoration-none text-secondary" href="/joke/show/${joke.id}">${joke.setup}</a></td></tr>
							</c:forEach>
							
						</tbody>
					
					</table>
				</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Vault Table End ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Addition Div Start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	
				<div class="container d-flex flex-column align-items-center text-center">
					<a href="/jokes/jokratory" class="text-decoration-none text-secondary">Make a Deposit</a><br/>
					<a href="/killtony" class="text-decoration-none text-secondary">Introduce Comedian</a><br/>
					<a href="" class="text-decoration-none text-secondary">Pick a Joke For You?</a><br/>
					<a href="" class="text-decoration-none text-secondary">Favorite Jokes</a><br/>
				</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Addition Div End ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

			</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Beginning of Bottom Div ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
			<!--<div class="container text-center p-5">
				
				<h3>Your Favorite Zingers</h3>
				
				<div class="container">
					<table class="table table-hover text-center">
						<tbody>
						
							<c:forEach items="${jokes}" var="joke">
								<tr class="shadow-sm "><td><a class="text-decoration-none text-secondary" href="/joke/show/${joke.id}">${joke.setup}</a></td></tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
				
				
      			<sql:setDataSource var = "consensus" scope="session" driver = "com.mysql.cj.jdbc.Driver" url = "jdbc:mysql://localhost:3306/jovault" user = "root" password = "root"/>
      			<sql:query dataSource = "${consensus}" sql = "SELECT count(*) FROM jokes;" var = "results"></sql:query>
			
				<c:forEach items="${results.rows}" var="result">
					
					<c:set var="count" value="${fn:substring(result, 10, 11)}"/>
					
      				Mehh mehh mehhhhh
      				for an idea of getting random number generator based on amount of jokes in vault, 
      				probably relatively simple but my brain stopped understanding when I tried to 
      				implement it. I'll try again later. 👍
      				
      				
				</c:forEach>
			
			</div>-->
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End of Bottom Div ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Beginning of Bottom Section ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
			<div class="d-flex flex-row justify-content-around mt-5">
				<div class="container border border-top-0 border-bottom-0 text-center p-5 col-4">
					
					<h3><c:out value="${user.username}'s Jokes" /></h3>
					
					<ul class="list-unstyled">
						<c:forEach items="${myJokes}" var="myJoke">
							
							<li><a class="text-decoration-none text-secondary" href="/joke/show/${myJoke.id}">${myJoke.setup}</a></li>
							
						</c:forEach>
					</ul>
					
				
				</div>
				<!-- <div class="container border border-top-0 border-bottom-0 text-center p-5 col-4">
					
					
					<h3><c:out value="Favorited Jokes" /></h3>
				
				
				</div> -->
			</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End of Bottom Section ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
		</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End of Main Dash div ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
	</div>
	<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ End of Whole Container ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
</body>
</html>