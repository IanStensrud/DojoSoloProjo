<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jovault</title>    
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="font-family: nunito, sans-serif;">
	<div class="container p-5 mt-5 d-flex justify-content-between align-items-center">
		<div class="container col-5">
			<h2 class="text-center">Enter The Vault</h2>
			<form:form 	action="/register" modelAttribute="newUser" method="POST" class="mx-auto" >
				<div class="input-group mt-3">
					<form:label path="username" class="p-1">Stage Name: </form:label>
					<form:input type="text" path="username" class="form-control" />
				</div>
				<div>
					<form:errors path="username" class="text-danger" />
				</div>
				<div class="input-group mt-3">
					<form:label path="email" class="p-1">Email: </form:label>
					<form:input type="email" path="email" class="form-control" />
				</div>
				<div>
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="input-group mt-3">
					<form:label path="password" class="p-1">Password: </form:label>
					<form:input type="password" path="password" class="form-control" />
				</div>
				<div>
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="input-group mt-3">
					<form:label path="confirm" class="p-1">Confirm Password: </form:label>
					<form:input type="password" path="confirm" class="form-control" />
				</div>
				<div>
					<form:errors path="confirm" class="text-danger" />
				</div>
				<div class="mt-3">
					<input type="submit" value="Register" class="btn btn-outline-primary" />
				</div>
				
			</form:form>
		
		
		</div>
		<div class="container col-5">
			<form:form action="/login" method="POST" modelAttribute="newLogin" class="mx-auto">
				<h2 class="text-center">Returning Credentials</h2>
				<div class="input-group mt-3">
					<form:label path="confirmEmail" class="p-1">Email: </form:label>
					<form:input type="email" path="confirmEmail" class="form-control" />
				</div>
				<div>
					<form:errors path="confirmEmail" class="text-danger" />
				</div>
				<div class="input-group mt-3">
					<form:label path="confirmPassword" class="p-1">Password: </form:label>
					<form:input type="password" path="confirmPassword" class="form-control" />
				</div>
				<div>
					<form:errors path="confirmPassword" class="text-danger" />
				</div>
				<div class="mt-3">
					<input type="submit" value="Login" class="btn btn-outline-info" />
				</div>
				
			</form:form>
		
		</div>
	
	
	</div>
</body>
</html>