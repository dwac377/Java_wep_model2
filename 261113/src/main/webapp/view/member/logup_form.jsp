<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/firstpjt/">home</a>
	&nbsp;&nbsp; | &nbsp;&nbsp;
	<a href="/firstpjt/logup.mem">sign-up</a>
	&nbsp;&nbsp; | &nbsp;&nbsp;
	<a href="/firstpjt/login.mem">sign-in</a>
	

<form action="/firstpjt/logup_confirm.mem" method="post">

		<input type="text" name="memId" placeholder="Input new member ID!!">
		<br>
		<input type="password" name="memPw" placeholder="Input new member PW!!">
		<br>
		<input type="submit" value="SINGUP">
		<input type="reset" value="RESET"> 
		
	</form> 



</body>
</html>