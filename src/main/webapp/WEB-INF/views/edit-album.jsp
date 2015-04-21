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
  		<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/artist/view.html">Request Song</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/artist/manage.html">Manage Catalog</a></li>
  		<li role="presentation"><a href="#">Login</a></li>
	</ul>
	
	<h2>Manage Catalog</h2>
	<h4><a href="${pageContext.request.contextPath}/artist/manage.html">Artists</a> -> 
	<a href="${pageContext.request.contextPath}/album/manage/${artist.id}.html">${artist.name}</a> ->
	${album.name} : Edit</h4><br/>
	
	<form:form method="POST" commandName="album"
		action="${pageContext.request.contextPath}/album/edit/${album.id}.html">
		<table>
			<tbody>
				<tr>
					<td><b>Album Name: &nbsp;</b></td>
					<td><form:input path="name" /></td>
					<td><form:hidden path="artist_id" value="${artist.id}"/></td>
				</tr>
			</tbody>
		</table>
		<br/>
		<form:errors path="name" cssStyle="color: red; font-weight: bold;" /> <br/>
		<input class="btn btn-default" type="submit" value="Update" /> 
		<a class="btn btn-default" href="${pageContext.request.contextPath}/album/manage/${artist.id}.html" role="button">
			Cancel
		</a> 
		
	</form:form>
	
	
</body>
</html>