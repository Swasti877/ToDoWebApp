<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>ToDo WebApp</title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">ToDo Application</h1>

		<c:if test="${not empty msg }">
			<div class="alert alert-success">
				<b><c:out value="${msg }"></c:out></b>
			</div>
		</c:if>

		<%--Side Navigation --%>
		<div class="row mt-5">
			<div class="col-md-2">
				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active"
						aria-current="true">Menu</button>
					<a href="<c:url value="/add"></c:url>"
						class="list-group-item list-group-item-action">Add TODO</a> <a
						href="<c:url value="/home"></c:url>"
						class="list-group-item list-group-item-action">View TODO</a>
				</div>
			</div>

			<%--Content --%>
			<div class="col-md-10">

				<%--page == home --%>
				<c:if test="${page== 'home' }">
					<h1>Home page...</h1>

					<c:forEach items="${todos }" var="t">
						<div class="card mt-2">
							<div class="card-body" style="position: relative;">
								<h3>
									<c:out value="${t.toDoTitle }"></c:out>
								</h3>
								<p>
									<c:out value="${t.toDoDesc }"></c:out>
								</p>
								<a href="<c:url value="/editToDo/${t.todoId }"/>"
									class="material-icons"
									style="color: black; position: absolute; right: 50px; bottom: 10px; text-decoration: none">
									edit </a> <a href="<c:url value="/deleteToDo/${t.todoId}" />"
									class="material-icons"
									style="color: red; position: absolute; right: 10px; bottom: 10px; text-decoration: none">
									delete </a>
							</div>
						</div>
					</c:forEach>

				</c:if>

				<%--page == add --%>
				<c:if test="${page== 'add' }">
					<h1>Add to do....</h1>
					<form:form action="saveToDo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="toDoTitle" cssClass="form-control"
								placeholder="Enter Title" />
						</div>
						<div class="form-group">
							<form:textarea path="toDoDesc" cssClass="form-control"
								placeholder="Enter the Content here..." cssStyle="height:300px;" />
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-primary">Add ToDo</button>
						</div>
					</form:form>
				</c:if>

				<%--page == update --%>
				<c:if test="${page== 'update' }">
					<h1>Edit ToDo......</h1>
					<form action="${pageContext.request.contextPath }/saveToDo" method="post">
						<input type="text" name="todoId" value="${toDo.todoId }" hidden/> 
						<div class="form-group row">
							<label for="toDoTitle" class="col-sm-2 col-form-label">Title</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="toDoTitle" name="toDoTitle"
									value="${toDo.toDoTitle }" />
							</div>
						</div>
						<div class="form-group row">
							<label for="toDoDesc" class="col-sm-2 col-form-label">Description</label>
							<div class="col-sm-10">
								<input type="textarea" class="form-control" id="toDoDesc" name="toDoDesc" value="${toDo.toDoDesc }"/>
							</div>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-outline-primary">Update</button>
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>