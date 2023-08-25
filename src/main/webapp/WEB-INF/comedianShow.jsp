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
	<title><c:out value="${comedian.name}"/></title>
</head>
<body style="font-family: nunito, sans-serif">

	<div class="container mt-5">	
		<a href="/dash" class="text-decoration-none text-left text-secondary p-1 border border-warning rounded-bottom">The Vault</a>
	
		<div class="container mt-5">
		
			<h1 class="mb-3 text-center"><c:out value="${comedian.name}"/></h1>
			<h6 class="text-center text-secondary mb-3">Hover over for the punchline!</h6>

			<div class="container d-flex flex-column align-items-center">
				<div class="container col-4 text-center border border-black rounded">
					<h4 class="border-bottom">Originals</h4>
					<table>
						<tbody class="d-flex justify-content-center">
							<c:forEach items="${jokes}" var="joke">
	
								<tr class="text-center text-decoration-none text-secondary" data-toggle="tooltip" data-placement="top" title="${joke.punchline}">
									<td><a href="/joke/show/${joke.id}" class="text-decoration-none text-secondary"><c:out value="${joke.setup}"/></a></td>
								</tr>
	
							</c:forEach>
						</tbody>
					
					</table>
				</div>
				<div class="container">




					<table class="table table-striped border black-border rounded ">
						

					</table>

				</div>
			

			
			
			
			</div>
		
		
		
		</div>
	
	
	
	</div>
</body>
</html>