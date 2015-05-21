<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Account</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Account</h1>
		<form:form action="saveTask" method="post" modelAttribute="task">
		<table>
			
			<tr>
				<td>idTask:</td>
				<td><form:input path="idTask" /></td>
			</tr>
			<tr>
				<td>nameTask:</td>
				<td><form:input path="nameTask" /></td>
			</tr>
			<tr>
				<td>timeUpdate:</td>
				<td>${task.timeUpdate } </td>
			</tr>
			<tr>
				<td>statusTask:</td>
				<td>
				<form:select path="statusTask">
					<form:option value="Done!" >Done!</form:option>
					<form:option value="Doing...">Doing...</form:option>
					<form:option value="Do not.">Do not.</form:option>
				</form:select>
				 </td>
			</tr>
			<tr>
				<td>publicTask:</td>
				<td><form:checkbox path="publicTask"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>