
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Login Page</title>
</head>
<body>
	<form name="registerForm" action="register.do" method="POST">
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<td>Enter UserName:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirm" /></td>
			</tr>
			<tr>
				<td>Enter First Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Last Name:</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td>Enter Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter DOB(dd/mm/yyyy) :</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>