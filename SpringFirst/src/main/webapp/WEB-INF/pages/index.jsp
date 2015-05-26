<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Task Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Account List</h1>

		<table id = "table">
			<tr>
				<th><a href="sortById"><button value="idTask">idTask</button>
				</a></th>
				<th><a href="sortByName"><button value="nameTask">nameTask</button>
				</a></th>
				<th>timeUpdat</th>
				<th>statusTask</th>
				<th>publicTask</th>
				<th>acctionTask</th>
			</tr>
			<c:forEach var="account" items="${list}" varStatus="status">
				<tr class = "alt">
					<td>${account.idTask}</td>
					<td>${account.nameTask}</td>
					<td>${account.timeUpdate}</td>
					<td>${account.statusTask }</td>
					<td><input type="checkbox" value="true"
						<c:if test="${account.publicTask}">checked</c:if> /></td>
					<td><a href="editTask?idTask=${account.idTask}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteTask?idTask=${account.idTask}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>

		<ul class="pagination">
			<c:forEach var="page" begin="1" end="${maxPage}">
			<li><a href="selectPage?page=${page-1}">${page}</a></li>
			</c:forEach>
		</ul>

		<form action="search" method="post">
			<input type="text" name="keyword"> <input type="submit"
				value="Search">
		</form>
		<h3>
			<a href="newTask">New Task</a>
		</h3>
		<h3>
			<a href="saveJob">Save job</a>
		</h3>
	</div>

</body>
</html>
