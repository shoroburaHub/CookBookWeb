<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
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
	href="<c:url value="/resources/images/logo-small.png"/>"
	type="image/png" />
</head>

<body id="pageBody">

	<div id="welcomeHeader" class="container-fluid">

		<!-- Begin of the welcome header -->

		<div>
			<img src="<c:url value="/resources/images/cookbook-big-logo.png"/>"
				class="img-responsive center-block" id="cookbook-big-logo" />
			<p class="center-block">
				type in ingredients and see <br> what you can cook &#9786;
			</p>

			<div id="mainInput">

				<!-- Don't scream on me because of this. I know it's weird but something is wrong with bootstrap -->

				<form action="searchRecipe" method="POST">
					<input type="text" value="type in ingredients" id="mainInputField"
						name="name" class="form-control"
						onfocus="if(this.value=='type in ingredients')this.value=''; this.style.color = 'black';"
						onblur="if(this.value==''){this.value='type in ingredients';this.style.color = 'grey'};" />
					<button type="submit" class="img-responsive center-block">Search</button>
				</form>
			</div>

		</div>

		<!-- End of the welcome header -->

		<a href="showAllRecipes">Show Recipe</a> <a href="showAllIngredient">Show
			Ingredients</a>
	</div>
</body>
</html>