<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<c:import url="main-config.jsp" />
		<link rel="stylesheet" href="<c:url value="/resources/css/generate.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/footer.css" />" >
		<link rel="stylesheet" href="<c:url value="/resources/css/typeColors.css" />" >
		
		<fmt:setLocale value="en_US" scope="session"/>

		<title>Treasure Generator - Result</title>
	</head>
	<body>
	
		<c:import url="header.jsp" />
			
		<nav class="nav-header header-type${selectedLetter} container">
			<ul class="menu">
				<li class="wrap-menu-item"><a href="javascript:window.history.go(-1)" class="menu-item" id="back">Back</a></li>
				<li class="wrap-menu-item"><a href="home" class="menu-item" id="home">Home</a></li>
				<li class="wrap-menu-item"><a href="" class="menu-item" id="regen">Regenerate</a></li>
			</ul>
		</nav>
		
		<section class="container result">
			<h3 class="result-title">Result for <fmt:formatNumber value="${selectedValue}" /> gp of ${typeName}</h3>
			
			<table class="container result-list">
				<thead>
					<tr class="result-list-header">
						<th class="result-list-name">Name</th>
						<th class="result-list-price">Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${treasures}" var="treasure" >
						<tr class="result-list-item" >
							<td class="result-list-name">${treasure.treasureName}</td>
							<td class="result-list-price"><fmt:formatNumber type="number" value="${treasure.treasureValue}" /> gp</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="result-list-footer">
						<td class="result-list-name">Total</td>
						<td class="result-list-price"><fmt:formatNumber value="${totalPrice}" /> gp</td>
					</tr>
				</tfoot>
			</table>
		</section>
		
		<c:import url="footer.jsp" />
		
	</body>
</html>