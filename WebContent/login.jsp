<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link href="resource\CSS\login.css" rel="stylesheet">
<title>loGIN PAGE</title>
</head>

<body>
	
	<%
		if (request.getAttribute("error") != null) {
	%>
			<div class="alert alert-error"><strong>Error !</strong><% out.println(request.getAttribute("error")); %></div>
	<%
		}
	%>
	
	<div class="loginForm">
		<img src="resource\CSS\login-logo-user-login-png-900_520.png" class="img-login" alt="">
	<br><br>
		<form class="register-form" action="login" method="post">
            <input type="text" name="UserName" placeholder="user name"/><br>
            <input type="password" name="Password" placeholder="password"/><br>
            <button class="button button4" name="loginbutton" id="loginbutton" value="login" type="submit" >
							Log in</button>
      </form> 
	</div>	

</body>
</html>