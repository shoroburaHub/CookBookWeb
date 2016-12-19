<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href=<c:url value="/resources/css/style.css"/>
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="bg">
	<c:forEach items="${Recipes}" var="recipe">
		<div>
			<div id="innerone">
				${recipe.name} <a href="${recipe.urlToRecipe}">source</a>
			</div>
			<div id="innertwo">
				<c:forEach items="${recipe.ingredientAndAmount}"
					var="ingredientAndAmount">
					<div>
						<p>${ingredientAndAmount.amount}
							${ingredientAndAmount.ingredient.ingredientName}
							${ingredientAndAmount.ingredient.measuringSystem.name}
					</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</body>
</html>