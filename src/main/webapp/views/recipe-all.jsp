<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href=<c:url value="/resources/css/style.css"/> rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Recipe:</h3>
	<table>
		<tbody>
			<c:forEach items="${allRecipes}" var="recipe">
				<tr>
					<td>${recipe.name}</td>
					<td><a href="${recipe.urlToRecipe}">source</a></td>
						<c:forEach items="${recipe.ingredientAndAmount}" var="ingredientAndAmount">
							<td>${ingredientAndAmount.amount}</td>
							<td>${ingredientAndAmount.ingredient.ingredientName}</td>
							<td>${ingredientAndAmount.ingredient.measuringSystem.name}</td>
						</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>