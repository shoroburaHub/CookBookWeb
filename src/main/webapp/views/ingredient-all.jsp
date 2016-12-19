<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Cookbook.org - search what you can cook!</title>

<!-- Main style sheet -->
<link href="<c:url value="/resources/css/main-style-sheet.css"/>"
	rel="stylesheet">

<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link rel="shortcut icon"
	href="<c:url value="/resources/images/logo.png"/>" type="image/png" />
</head>

<body>
<body id="pageBody">

	<div id="welcomeHeader" class="container-fluid">

		<!-- Begin of the welcome header -->

		<div>
			<h3>Ingredients:</h3>
			<table>
				<tr>
					<th>MS</th>
					<th>Ingredient</th>
				</tr>
				<c:forEach items="${allIngredients}" var="ingredient">
					<tr>
						<td>${ingredient.measuringSystem.name}</td>
						<td>${ingredient.ingredientName}</td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<!-- End of the welcome header -->

		<a href="showAllRecipes">Show Recipe</a> <a href="showAllIngredient">Show
			Ingredients</a>
	</div>
</html>