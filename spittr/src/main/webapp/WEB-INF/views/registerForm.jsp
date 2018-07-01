<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<style>
.collapsed {
	display: none
}
</style>
</head>
<body>
	<h1>Register</h1>
	<form method="POST">
		First Name: <input type="text" name="firstName"
			value="<c:out value="${spitter!=null?spitter.firstName:''}"/>" /> <span
			class="error <c:out value="${errors!=null && errors.hasFieldErrors('firstName')?'':'collapsed'}"/>">
			<c:out
				value="${errors!=null && errors.hasFieldErrors('firstName')?errors.getFieldError('firstName').getDefaultMessage():'' }" />
		</span> <br /> Last Name: <input type="text" name="lastName"
			value="<c:out value="${spitter!=null?spitter.lastName:''}"/>" /> <span
			class="error <c:out value="${errors!=null && errors.hasFieldErrors('lastName')?'':'collapsed'}"/>">
			<c:out
				value="${errors!=null && errors.hasFieldErrors('lastName')?errors.getFieldError('lastName').getDefaultMessage():'' }" />
		</span> <br /> Username: <input type="text" name="username"
			value="<c:out value="${spitter!=null?spitter.username:''}"/>" /> <span
			class="error <c:out value="${errors!=null && errors.hasFieldErrors('username')?'':'collapsed'}"/>"><c:out
				value="${errors!=null && errors.hasFieldErrors('username')?errors.getFieldError('username').getDefaultMessage():'' }" />
		</span> <br /> Password: <input type="password" name="password" /> <span
			class="error <c:out value="${errors!=null && errors.hasFieldErrors('password')?'':'collapsed'}"/>"><c:out
				value="${errors!=null && errors.hasFieldErrors('password')?errors.getFieldError('password').getDefaultMessage():'' }" />
		</span> <br /> <input type="submit" value="Register" />
	</form>

</body>
</html>