<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bomman House Hold - Log In</title>
<script type="text/javascript">
$(document).ready(function(){
	if(request.getAttribute("error")!= null){
		alert(request.getAttribute("error"));
	}
});
</script>
</head>
<body>
<%if(request.getAttribute("error")!= null){
%>	<p><%=request.getAttribute("error")%></p>
<%} %>
	<form action="./login" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" required="required" tabindex="1"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="LogIn"></td>
			</tr>
		</table>
	</form>
</body>
</html>