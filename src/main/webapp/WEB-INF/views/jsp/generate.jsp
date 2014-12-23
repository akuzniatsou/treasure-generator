<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width">

		<link href='http://fonts.googleapis.com/css?family=MedievalSharp|Alegreya:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/reset.css" >
		<link rel="stylesheet" href="resources/css/base.css" >
		<link rel="stylesheet" href="resources/css/generate.css" >
		<link rel="stylesheet" href="resources/css/footer.css" >
		
		<fmt:setLocale value="en_US" scope="session"/>

		<title>Treasure Generator - Result</title>
	</head>
	<body>
	
		<nav class="wrap-menu container">
			<ul class="menu">
				<li class="wrap-menu-item"><a href="javascript:window.history.go(-1)" class="menu-item" id="back">Back</a></li>
				<li class="wrap-menu-item"><a href="home" class="menu-item" id="home">Home</a></li>
				<li class="wrap-menu-item"><a href="" class="menu-item" id="regen">Regenerate</a></li>
			</ul>
		</nav>
		
		<section class="container result">
			<h3 class="result-title">Result for <fmt:formatNumber value="${selectedValue}" /> gp of Treasure Type ${selectedLetter}</h3>
			
			<table class="container">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${treasures}" var="treasure" >
						<tr>
							<td>${treasure.name}</td>
							<td><fmt:formatNumber type="number" value="${treasure.treasureValue}" /> gp</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>		
					<tr>
						<td>Total price generated</td>
						<td><fmt:formatNumber value="${totalPrice}" /> gp</td>
					</tr>
				</tfoot>
			</table>
		</section>
		
		<footer class="container footer">
			<small>by @decoverri</small>
		</footer>
		
	</body>
</html>