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
	
	<h2>Request Song</h2>
	<h4><a href="${pageContext.request.contextPath}/artist/view.html">Artists</a> <br/> 
	 <span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;${artist.name} : Albums</h4><br/>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th width="150px">Name</th>
				<th width="50px">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="album" items="${albumList}">
				<tr>
					<td>
						<span class="glyphicon glyphicon-cd" aria-hidden="true"></span>&nbsp;
						${album.name}
					</td>
					<td>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/song/view/${album.id}.html" role="button"> 
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;Browse Songs
						</a> &nbsp; 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>