<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Register</h1>
	<form method="POST">
		First Name: <input type="text" name="firstName"
			value="<c:out value="${spitter!=null?spitter.firstName:''}"/>" /><br />
		Last Name: <input type="text" name="lastName"
			value="<c:out value="${spitter!=null?spitter.lastName:''}"/>" /><br />
		Username: <input type="text" name="username"
			value="<c:out value="${spitter!=null?spitter.username:''}"/>" /><br />
		Password: <input type="password" name="password" /><br /> <input
			type="submit" value="Register" />
	</form>
	<c:forEach items="${errors}" var="error">
		<li>
			<div class="spittleError">
				<c:out value="${error}" />
			</div>
		</li>
	</c:forEach>
</body>
</html>