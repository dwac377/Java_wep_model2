<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>MODIFY FORM</h2>
  	
	<jsp:include page="../include/nav.jsp"/>
	
	<br><br>
	
	<form action="<%= request.getContextPath() %>/modify_form.mem" method="post">
	
		<input type="password" name="memPw" placeholder="Input new member PW!!">
		<br>
		<input type="email" name="memMail" placeholder="Input new member MAIL!!">
		<br>
		<input type="text" name="memPhone" placeholder="Input new member PHONE!!">
		<br>
		<input type="submit" value="MODIFY">
		<input type="reset" value="RESET"> 
		
	</form>

</body>
</html>