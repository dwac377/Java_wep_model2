<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp"></jsp:include>

<link 
	href="./res/css/member/signup_form.css" 
	rel="stylesheet" 
	type="text/css">

	
<jsp:include page="../include/diary/diary.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="../include/header.jsp"></jsp:include>
	
	<jsp:include page="../include/nav.jsp"></jsp:include>
	
	<article>
		<div class="art_wrap">

			<form action="<%= request.getContextPath()%>/write_confirm.dir"
					name="write_form"
					method="post">
					
					<input class="basic_input" type="text" name="diaryWord"
						placeholder="일기를 작성하십시오">
					<br>
					<input class="basic_input_button" type="button" value="작성"
						onclick="write_confirm();">
					<input class="basic_input_button" type="reset" value="초기화">
						
				</form>
		</div>
	</article>
	
	<jsp:include page="../include/footer.jsp"></jsp:include>
	


	
</body>
</html>