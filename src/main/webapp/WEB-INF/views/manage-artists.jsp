<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Jaz-E Jenn JukeBox</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap.js"></script>
	
</head>
<body>
	<ul class="nav nav-tabs">
  		<li role="presentation"><a href="${pageContext.request.contextPath}/#">Home</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/artist/view.html">Request Song</a></li>
  		<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/artist/manage.html">Manage Catalog</a></li>
  		<li role="presentation"><a href="#">Login</a></li>
	</ul>
	
	<h2>Manage Catalog</h2>
	<h4>Artists</h4><br/>
	<form:form method="POST" commandName="artist"
		action="${pageContext.request.contextPath}/artist/create.html">
		<table>
			<tbody>
				<tr>
					<td><b>Add Artist:</b>&nbsp;</td>
					<td><form:input path="name" />&nbsp;&nbsp;</td>
					<td><input class="btn btn-default" type="submit" value="Add" /></td>
				</tr>
			</tbody>
		</table>
		<form:errors path="name" cssStyle="color: red; font-weight: bold;" />
	</form:form>
	<div><font color="green"><b>${message}</b></font></div>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th width="25px">ID</th>
				<th width="150px">Name</th>
				<th width="50px">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="artist" items="${artistList}">
				<tr>
					<td>
						${artist.id}
					</td>
					<td>
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;
						${artist.name}
					</td>
					<td>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/album/manage/${artist.id}.html" role="button"> 
							<span class="glyphicon glyphicon-cd" aria-hidden="true"></span>&nbsp;Manage Albums
						</a> &nbsp; 
						<a class="btn btn-default" href="${pageContext.request.contextPath}/artist/edit/${artist.id}.html" role="button"> 
							<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>&nbsp;Edit Artist
						</a> &nbsp;
						<a class="btn btn-default" href="${pageContext.request.contextPath}/artist/delete/${artist.id}.html" role="button"> 
							<span class="glyphicon glyphicon-trash"	aria-hidden="true"></span>&nbsp;Delete Artist
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>