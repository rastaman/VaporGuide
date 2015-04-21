<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>
<html>
<head>
	<title>Admin</title>
</head>
<body>
<h1>
	Hello admin!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<spring:url value="/j_spring_security_logout" var="logout" />
<a href="${logout}">Logout</a>

</body>
</html>
